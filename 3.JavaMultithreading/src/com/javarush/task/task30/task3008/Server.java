package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args){
        int port = ConsoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(port);) {
            ConsoleHelper.writeMessage("Server start");
            while (true) {
                try (Socket socket = serverSocket.accept()){
                    new Handler(socket).start();
                } 
            }
        }catch (Exception e){
            ConsoleHelper.writeMessage("Socket connection exception");
        }
    }

    public static void sendBroadcastMessage(Message message){
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                try {
                    pair.getValue().send(message);
                } catch (IOException e) {
                    ConsoleHelper.writeMessage("Cannot send message" + e);
                }
            }
    }

    private static class Handler extends Thread{
        private Socket socket;
        private Connection connection;
        private String name;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage(socket.getRemoteSocketAddress().toString());

            try {
                connection = new Connection(socket);

                name = serverHandshake(connection);

                notifyUsers(connection,name);

                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));

                serverMainLoop(connection, name);

                connectionMap.entrySet().removeIf(name -> name.getKey().equals(name));

                if(name != null){
                    connectionMap.remove(name);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
                }

            } catch (IOException e) {
                ConsoleHelper.writeMessage("Error with share data");
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Error with share data");
            }




            ConsoleHelper.writeMessage("Connection close");
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
           Message request;
           Message messageAccept;
           Message response;
           String name;

           request = new Message(MessageType.NAME_REQUEST);

            do {
                connection.send(request);
                response = connection.receive();
                name = response.getData();
            } while (response.getType() != MessageType.USER_NAME || name.isEmpty() || connectionMap.containsKey(name));

           connectionMap.put(name, connection);

           messageAccept = new Message(MessageType.NAME_ACCEPTED);
           connection.send(messageAccept);

           return name;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> pair: connectionMap.entrySet()){
                if(pair.getKey().equals(userName)) continue;
                connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            Message response;
            Message transformedMessage;

            while(true) {
                response = connection.receive();
                if(response.getType() == MessageType.TEXT){
                    transformedMessage = new Message(MessageType.TEXT, userName + ": " + response.getData());
                    sendBroadcastMessage(transformedMessage);
                }else if(response.getType() != MessageType.TEXT){
                    ConsoleHelper.writeMessage("Error to get message");
                }
            }
        }
    }
}
