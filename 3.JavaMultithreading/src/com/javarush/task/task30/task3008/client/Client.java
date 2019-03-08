package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    volatile private boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();

    }

    public void run(){
        Thread thread = getSocketThread();
        thread.setDaemon(true);
        thread.start();
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Exception when thread was waiting");
                return;
            }
        }
        while(clientConnected){
            String readString = ConsoleHelper.readString();
            if(readString.equals("exit")) break;
            if(shouldSendTextFromConsole()) sendTextMessage(readString);
        }


    }

    public class SocketThread extends Thread{

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("Coonected: " + userName );
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("Left: " + userName );
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            Message receive;
            Message response;

            while (true){
                receive = connection.receive();

                if(receive.getType() == MessageType.NAME_REQUEST) {
                    response = new Message(MessageType.USER_NAME, getUserName());
                    connection.send(response);
                }else if(receive.getType() == MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    break;
                }else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            Message receive;

            while(true) {
                receive = connection.receive();

                if(receive.getType() == MessageType.TEXT) {
                    processIncomingMessage(receive.getData());
                }else if(receive.getType() == MessageType.USER_ADDED){
                    informAboutAddingNewUser(receive.getData());
                }else if(receive.getType() == MessageType.USER_REMOVED){
                    informAboutDeletingNewUser(receive.getData());
                }else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

    }

    protected String getServerAddress(){
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        return ConsoleHelper.readString();
    }
    
    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Error on client side to send message");
            clientConnected = false;
        }
    }
}
