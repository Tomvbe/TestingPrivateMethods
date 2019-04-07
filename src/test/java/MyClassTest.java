import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyClassTest {

    @Test
    void testMyStringMethod() throws Exception{
        Method method = MyClass.class.getDeclaredMethod("myStringMethod", String.class);
        method.setAccessible(true);
        String output = (String) method.invoke(new MyClass(), "Hello private test");
        assertEquals(output, "Hello private test");
    }

    @Test
    void testMyListMethod() throws Exception{
        Method method = MyClass.class.getDeclaredMethod("myListMethod", null);
        method.setAccessible(true);

        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("my list");

        List<String> output = (List<String>) method.invoke(new MyClass(), null);
        assertEquals(output, expectedOutput);
    }

}
