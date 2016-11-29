package demo;


import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

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

       String path = "C:\\Users\\yuriy_stetsiv\\autoscript\\scripts\\script_ChargesRolling25Months.txt";




        try (BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
