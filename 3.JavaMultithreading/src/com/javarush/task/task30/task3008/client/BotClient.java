package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            BotClient.this.sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }



        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            SimpleDateFormat dateFormat = null;
            String name = "";
            String text = "";

            if(message.contains(": ")) {
                name = message.substring(0, message.indexOf(": "));
                text = message.substring(message.indexOf(": ") + 2);
            }else {
                text = message;
            }

            if(text.equalsIgnoreCase("дата")){
                dateFormat = new SimpleDateFormat("d.MM.YYYY");
            }
            else if(text.equalsIgnoreCase("день")){
                dateFormat = new SimpleDateFormat("d");
            }
            else if(text.equalsIgnoreCase("месяц")){
                dateFormat = new SimpleDateFormat("MMMM");
            }
            else if(text.equalsIgnoreCase("год")){
                dateFormat = new SimpleDateFormat("YYYY");
            }
            else if(text.equalsIgnoreCase("время")){
                dateFormat = new SimpleDateFormat("H:mm:ss");
            }
            else if(text.equalsIgnoreCase("час")){
                dateFormat = new SimpleDateFormat("H");
            }
            else if(text.equalsIgnoreCase("минуты")){
                dateFormat = new SimpleDateFormat("m");
            }
            else if(text.equalsIgnoreCase("секунды")){
                dateFormat = new SimpleDateFormat("s");
            }

            if(dateFormat != null) {
                sendTextMessage("Информация для " + name + ": " + dateFormat.format(Calendar.getInstance().getTime()));
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }
}
