package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type){


            if(type.equals(ImageTypes.BMP)){
                return new BmpReader();
            } else if(type.equals(ImageTypes.PNG)){
                return new PngReader();
            } else if(type.equals(ImageTypes.JPG)){
                return new JpgReader();
            }else if(type == null){
                throw new NullPointerException("null not allow");
            }
            else {
                throw new IllegalArgumentException("work only with allowed files");
            }

//        if (i != null) {
//            if (i.equals(ImageTypes.BMP)) return new BmpReader();
//            else if (i.equals(ImageTypes.JPG)) return new JpgReader();
//            else if (i.equals(ImageTypes.PNG)) return new PngReader();
//        }
//        throw new IllegalArgumentException("Неизвестный тип картинки");

    }

    public static void main(String[] args) {



        Object o =  getImageReader(ImageTypes.GFD);


    }
}
