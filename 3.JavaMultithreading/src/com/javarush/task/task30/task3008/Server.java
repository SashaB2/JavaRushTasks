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
                try (Socket socket = serverSocket.accept();){
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

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
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
    }
}
