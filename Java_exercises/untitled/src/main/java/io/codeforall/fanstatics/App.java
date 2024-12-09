package io.codeforall.fanstatics;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )  {
        ObjectMapper mapper = new ObjectMapper();

        // Read JSON data from a URL and convert it to a MyPojo object
        try {
            MyPojo myPojo = mapper.readValue(new URL("https://ipinfo.io/json"), MyPojo.class);

            mapper.writeValue(new File("result.json"), myPojo);
            MyPojo myPojo1 = mapper.readValue(new File("result.json"), MyPojo.class);

            String jsonString = mapper.writeValueAsString(myPojo);
            System.out.println(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

}
