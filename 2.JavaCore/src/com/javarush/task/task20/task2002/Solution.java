package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
//            File yourFile = new File("your_file_name");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
//        User user = new User();
//
//        {
//            user.setCountry(User.Country.OTHER);
//            user.setMale(true);
//            user.setBirthDate(new Date(1L));
//            user.setFirstName("TestFirstName");
//            user.setLastName("TestLastName");
//            users.add(user);
//        }




        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            String doesUserIs = "not";
            String comma = ",";
            PrintStream printStream = new PrintStream(outputStream);

            for(User user: users) {
                doesUserIs = "not";

                //verify if object is not null
                if(user != null){
                    doesUserIs = "yes";
                    printStream.write(doesUserIs.getBytes());
                    printStream.write(comma.getBytes());
                    printStream.flush();
                }else{
                    printStream.write(doesUserIs.getBytes());
                    printStream.write("\n".getBytes());
                    printStream.flush();
                }

                //writes fields of object to file if file exists
                if(doesUserIs.equals("yes")){
                    //date
                    printStream.write((user.getBirthDate() != null) ? String.valueOf(user.getBirthDate().getTime()).getBytes() : "null".getBytes());
                    printStream.write(comma.getBytes());
                    printStream.flush();

                    //Country
                    printStream.write((user.getCountry() != null) ? user.getCountry().getDisplayName().getBytes() : "null".getBytes());
                    printStream.write(comma.getBytes());
                    printStream.flush();

                    //FirstName
                    printStream.write((user.getFirstName() != null) ? user.getFirstName().getBytes() : "null".getBytes());
                    printStream.write(comma.getBytes());
                    printStream.flush();

                    //LastName
                    printStream.write((user.getLastName() != null) ? user.getLastName().getBytes() : "null".getBytes());
                    printStream.write(comma.getBytes());
                    printStream.flush();

                    //isMale
                    printStream.write(String.valueOf(user.isMale()).getBytes());
//                    printStream.write(comma.getBytes());
                    printStream.write("\n".getBytes());
                    printStream.flush();

                }

            }
            printStream.close();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            final String objectAvailable = "yes";
            final String objectUnAvailable = "not";
            String readedLine = "";
            String parsedBuffer [];

            while (bufferedReader.ready()){
                readedLine = bufferedReader.readLine();
                parsedBuffer = readedLine.split(",");

                if(parsedBuffer[0].equals("\n"))
                    break;

                if(parsedBuffer[0].equals(objectUnAvailable)){
                    users.add(null);
                }else if(parsedBuffer[0].equals(objectAvailable)){
                    User user = new User();

                    Date birtDate = (!parsedBuffer[1].equals("null"))? new Date(Long.parseLong(parsedBuffer[1])) : null;
                    user.setBirthDate(birtDate);

                    String country = (!parsedBuffer[2].equals("null"))? parsedBuffer[2] : null;
                    if(country != null && country.equals(User.Country.UKRAINE.getDisplayName())){
                        user.setCountry(User.Country.UKRAINE);
                    }else if(country != null && country.equals(User.Country.RUSSIA.getDisplayName())){
                        user.setCountry(User.Country.RUSSIA);
                    }else if(country != null && country.equals(User.Country.OTHER.getDisplayName())){
                        user.setCountry(User.Country.OTHER);
                    }

                    String firtName = parsedBuffer[3];
                    user.setFirstName(firtName);

                    String lastName = parsedBuffer[4];
                    user.setLastName(lastName);

                    boolean male = false;
                    if(parsedBuffer[5].equals("true"))
                        male = true;
                    user.setMale(male);

                    users.add(user);
                    user = null;
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }

}
