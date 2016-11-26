package demo;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigDB {


    static String jhome = System.getenv("Autoscript");

    public static String fullPath=jhome+ File.separator+"autoscript"+File.separator+"autoscript.properties";

    private static Properties props = new Properties();

    private ConfigDB() {

    }

    public static void getPropsFromFile() throws IOException {
        props.load(new FileReader(new File(fullPath)));

    }

    public static String getServerName() {
        return props.getProperty("serverName");
    }

    public static Integer getPortNumber() {
        return Integer.parseInt(props.getProperty("portNumber"));
    }

    public static Boolean getUseNTLMV2() {
        return Boolean.parseBoolean(props.getProperty("useNTLMV2"));
    }

    public static String getUser() {
        return props.getProperty("user");
    }

    public static String getPassword() {
        return props.getProperty("password");
    }

    public static String getDomain() {
        return props.getProperty("domain");
    }

    public static String getTenant(){
        return props.getProperty("tenant");
    }
    public static String getUserName () {
        return props.getProperty("username");
    }
    public static String getTenantPassword(){
        return props.getProperty("tenantpassword");
    }
}




