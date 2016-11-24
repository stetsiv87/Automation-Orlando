package demo1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Yuriy_Stetsiv on 11/24/2016.
 */
public class Test {


    public static void main(String[] args) {

        try(FileReader reader = new FileReader("C:\\Users\\yuriy_stetsiv\\autoscript\\test.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                char s = ((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
