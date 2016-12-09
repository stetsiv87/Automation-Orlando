package demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Yura on 09.12.2016.
 */
public class fileString {


    static Properties prop = new Properties();

    static String fullpath = "C:\\Users\\Yura\\Downloads\\test.txt";

    static void getPropFromFile () throws IOException {
        prop.load(new FileReader(new File(fullpath)));
    }

    static String getValues(){
        return prop.getProperty("element_presence");
    }

    public static void main(String[] args) throws IOException {
        getPropFromFile();
        System.out.println(getValues());


        String jhome = System.getenv("Autoscript");
        System.out.println(jhome);

        String [] tokens = getValues().split(",");

//        ArrayList<String> list = new ArrayList<>();
//
//        for (int i = 0; i <tokens.length ; i++) {
//            list.add(tokens[i]);
//        }

        for (int i = 0; i <tokens.length ; i++) {
            System.out.println(tokens[i]);
        }


    }

}
