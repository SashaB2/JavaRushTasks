package testT;


import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws IOException {

        SortedMap<String,Charset> charsets = Charset.availableCharsets();

        for(Map.Entry<String,Charset> pair: charsets.entrySet()
            ) {
            System.out.println(pair.getKey() + " | " + pair.getValue());
        }

        Charset charset = Charset.defaultCharset();
        System.out.println(charset);

    }

}
