package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        assert ip.length == 4 && mask.length == 4;

        byte [] bytes = new byte[ip.length];

        for(int i = 0; i < ip.length; i++) {
            bytes[i] = (byte)( ((ip[i]+256)%256) &  ((mask[i]+256)%256));
        }

        return bytes;
    }

    public static String getBytes(byte b){
        return Integer.toBinaryString((b+256)%256);
    }


    public static String getByteBinaryString(byte b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; --i) {
            sb.append(b >>> i & 1);
        }
        return sb.toString();
    }

    public static void print(byte[] bytes) {

        String temp = "";

        for(int i = 0; i < bytes.length ; i++) {
            temp = getBytes(bytes[i]);

            if(temp.length() < 8){
                for(int j = temp.length(); j < 8; j++) {
                    temp = "0" + temp;
                }
            }

            System.out.print(temp);
            System.out.print(" ");
        }
        System.out.println();
    }
}
