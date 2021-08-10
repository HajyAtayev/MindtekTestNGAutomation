package utilities;

import org.testng.annotations.Test;

public class TestUtils {

    @Test

    public void testConfigReader(){
        String url = ConfigReader.getProperty("RedShelfURL");
        System.out.println(url);
        System.out.println(ConfigReader.getProperty("username"));

    }


}
