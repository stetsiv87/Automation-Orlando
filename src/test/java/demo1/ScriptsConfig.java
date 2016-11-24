package demo1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ScriptsConfig {

    private String filename;

    static String jhome = System.getenv("Autoscript");

    private static Properties props = new Properties();

    public void setTestScript (String filename){

        this.filename=filename;
    }


    public void getPropsFromFile() throws IOException {
        String fullPath = jhome + File.separator + "autoscript" + File.separator + File.separator +"scripts" + File.separator + filename;
        props.load(new FileReader(new File(fullPath)));
    }

    public String getTestQuery() throws IOException {
        return props.getProperty("testquery");

    }


}
