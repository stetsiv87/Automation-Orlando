package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static demo.ProjectConfig.props;


public interface ScriptsConfig {




//    default void getPropsFromFile( String filename_script) throws IOException {




    default String getTestQuery(String filename_script) throws IOException {
        String jhome = System.getenv("Autoscript");
        String fullPath = jhome + File.separator + "autoscript" + File.separator + File.separator +"scripts" + File.separator + filename_script;

        return new String(Files.readAllBytes(Paths.get(fullPath)));

    }


}
