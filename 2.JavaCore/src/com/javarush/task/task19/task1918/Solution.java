package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/


import java.io.*;

public class Solution {



    public static void main(String[] args) throws IOException {
        String fileContent = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
//        String fileName = "C:\\Users\\B2\\Desktop\\first.html";
        String tagName = args[0];
//        String tagName = "span";
//
//        FileReader fileReadear = new FileReader(fileName);
//        while(fileReadear.ready()) {
//            char a = (char)fileReadear.read();
//            fileContent += Character.toString(a);
//        }
//        fileReadear.close();
//
//        Document document = Jsoup.parse(fileContent.toString(), "", Parser.xmlParser());
//        Elements elements = document.select(tagName);
//        System.out.println(elements);
    }
}
//         String tagName = "span";
//         int lenghtOfTagName = tagName.length();
//         String tagOpen = "<" + tagName;
//         String tagClose = "</" + tagName + ">";
//
//
//        FileReader fileReadear = new FileReader(fileName);
//        while(fileReadear.ready()) {
//            char a = (char)fileReadear.read();
//            fileContent.append(a);
//        }
//        fileReadear.close();
//
////        int bS = fileContent.indexOf("<span");
//        int bS = fileContent.indexOf(tagOpen);
////        int eS = fileContent.indexOf("</span>");
//        int eS = fileContent.indexOf(tagClose);
//        StringBuilder str = new StringBuilder();
//
//        if(bS >= 0 && eS > 0){
//
//            int countInnerTag = 0;
//
//            while(bS >= 0){
//          //inner tags
//                int nextOpenedTagAfterPreviousOpenedTag = fileContent.indexOf(tagOpen, bS+1);
//                int closedTagAfterBeginTag = fileContent.indexOf(tagClose, bS);
//
//                //verify if in opened tag we have inner tags.
//                //find out how many inner tags are inside.
//                if((nextOpenedTagAfterPreviousOpenedTag < closedTagAfterBeginTag) && nextOpenedTagAfterPreviousOpenedTag != -1)
//                {
//                    int t1 = bS;
//                    int t2 = fileContent.indexOf(tagClose, bS);
//                    for(int i = bS; i < eS; i++){
//                        t1 = nextOpenedTagAfterPreviousOpenedTag;
//                        if(t1>t2)
//                            break;
//                        if(t1<t2)
//                            ++countInnerTag;
//                    }
//
//                    int finalClosedTagOfAllInnerTags = 0;
//                    while (countInnerTag > 0){
//                        --countInnerTag;
//                        t2 = fileContent.indexOf("</span>", eS+1);
//                        finalClosedTagOfAllInnerTags = t2;
//
//
//                    }
//
//                    for(int i = bS; i < finalClosedTagOfAllInnerTags+7; i++) {
//                        str.append(fileContent.charAt(i));
//                    }
//                    System.out.println(str.toString());
//                    str = new StringBuilder();
//
//
//
//                    bS = fileContent.indexOf("<span", finalClosedTagOfAllInnerTags+1);
//                    eS = fileContent.indexOf("</span>", finalClosedTagOfAllInnerTags+1);
//
//                    continue;
//
//                }
//
//
//
//
////old code
//                for(int i = bS; i < (eS + lenghtOfTagName + 3); i++) {
//                    str.append(fileContent.charAt(i));
//                }
//                System.out.println(str.toString());
//                str = new StringBuilder();
//
//                bS = fileContent.indexOf(tagOpen, bS+1);
//                eS = fileContent.indexOf(tagClose, eS+1);
//
//            }
//        }
//
//    }
//}
