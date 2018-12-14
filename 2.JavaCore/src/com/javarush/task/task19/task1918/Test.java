package com.javarush.task.task19.task1918;

public class Test {
    public static void main(String[] args) {
        String a = "<span><b><span>la</span></b></span>\n" +
                "<span>Tu</span>\n" +
                "<span>Su</span>\n" +
                "<span>gi</span>";

        int bS = a.indexOf("<span");
        int eS = a.indexOf("</span>");
        StringBuilder str = new StringBuilder();

        int countInnerTags = 0;

        if(bS >= 0 && eS > 0){
            while(bS >= 0){


//                System.out.println(a.indexOf("<span", bS+1));
//                System.out.println(a.indexOf("<span", bS+1));

                if((a.indexOf("<span", bS+1) < a.indexOf("</span>", bS)) && a.indexOf("<span", bS+1) != -1){  //we have inner tag/s
                    int t1 = bS;
                    int t2 = a.indexOf("</span>", bS);
                    for(int i = bS; i < eS; i++) {

                        t1 = a.indexOf("<span", t1+1);

                        if(t1>t2)
                            break;
                        if(t1 < t2){
                                ++countInnerTags;
                        }


                    }

                    //find out last index of closed tag of all inner tags

                    int finalClosedTagOfAllInnerTags = 0;
                    while (countInnerTags > 0){
                        --countInnerTags;
                        t2 = a.indexOf("</span>", eS+1);
                        finalClosedTagOfAllInnerTags = t2;


                    }

                    for(int i = bS; i < finalClosedTagOfAllInnerTags+7; i++) {
                        str.append(a.charAt(i));
                    }
                    System.out.println(str.toString());
                    str = new StringBuilder();



                    bS = a.indexOf("<span", finalClosedTagOfAllInnerTags+1);
                    eS = a.indexOf("</span>", finalClosedTagOfAllInnerTags+1);

                    continue;
                }




                for(int i = bS; i < eS+7; i++) {
                    str.append(a.charAt(i));
                }
                System.out.println(str.toString());
                str = new StringBuilder();



                bS = a.indexOf("<span", bS+1);
                eS = a.indexOf("</span>", eS+1);
//                System.out.println(bS);
//                System.out.println(eS);

            }
        }

    }
}
