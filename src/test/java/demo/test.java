package demo;


import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        ConfigDB.getPropsFromFile();
        System.out.println(ConfigDB.getServerName());
        System.out.println(ConfigDB.getPortNumber());
        System.out.println(ConfigDB.getUseNTLMV2());
        System.out.println(ConfigDB.getUser());
        System.out.println(ConfigDB.getPassword());
        System.out.println(ConfigDB.getDomain());
        System.out.println(ConfigDB.getTenant());
        System.out.println(ConfigDB.getUserName());
        System.out.println(ConfigDB.getTenantPassword());


       // System.out.println(ConfigDB.getDomain());
    }
}
