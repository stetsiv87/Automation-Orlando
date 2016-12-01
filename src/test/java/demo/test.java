package demo;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static demo.Test_New.driver;

public class test {
    public static void main(String[] args) throws IOException {
//        ConfigDB.getPropsFromFile();
//        System.out.println(ConfigDB.getServerName());
//        System.out.println(ConfigDB.getPortNumber());
//        System.out.println(ConfigDB.getUseNTLMV2());
//        System.out.println(ConfigDB.getUser());
//        System.out.println(ConfigDB.getPassword());
//        System.out.println(ConfigDB.getDomain());
//
//        System.out.println(Double.MAX_VALUE);
//        String s = "$724,798,862.90";
//        String parseString  = ((s).replace(",","")).replace("$","");
//        double d=  Double.parseDouble(parseString);
//
//        BigDecimal finals = BigDecimal.valueOf(d);
//
//        System.out.println(finals);


            long start = System.currentTimeMillis();
        System.out.println(start);
            while (true) {

                System.out.println(System.currentTimeMillis());
                if (System.currentTimeMillis()-start>60000) {
                    break;
                }

            }
        }

    }

