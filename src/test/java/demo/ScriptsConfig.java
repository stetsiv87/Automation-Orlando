package demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public interface ScriptsConfig {


 Properties props = new Properties();

    static void getPropsFromFile( String filename_script) throws IOException {
        String jhome = System.getenv("Autoscript");
        String fullPath = jhome + File.separator + "autoscript" + File.separator + File.separator +"scripts" + File.separator + filename_script;
        props.load(new FileReader(new File(fullPath)));
    }

    default String getTestQuery() throws IOException {
        return props.getProperty("testquery");

    }


}
