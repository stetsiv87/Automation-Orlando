package demo;


import java.io.IOException;
import java.math.BigDecimal;

public class test {
    public static void main(String[] args) throws IOException {
        ConfigDB.getPropsFromFile();
        System.out.println(ConfigDB.getServerName());
        System.out.println(ConfigDB.getPortNumber());
        System.out.println(ConfigDB.getUseNTLMV2());
        System.out.println(ConfigDB.getUser());
        System.out.println(ConfigDB.getPassword());
        System.out.println(ConfigDB.getDomain());

        System.out.println(Double.MAX_VALUE);
        String s = "$724,798,862.90";
        String parseString  = ((s).replace(",","")).replace("$","");
        double d=  Double.parseDouble(parseString);

        BigDecimal finals = BigDecimal.valueOf(d);

        System.out.println(finals);

       // System.out.println(ConfigDB.getDomain());
    }
}
