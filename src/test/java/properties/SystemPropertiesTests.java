package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    @Tag("hello")
    void someTest7(){

        System.out.println("Hello " + System.getProperty("anyText")); // any text

        //gradle clean properties_test6 hello_test -DanyText=world!
        //Hello world!
    }
}
