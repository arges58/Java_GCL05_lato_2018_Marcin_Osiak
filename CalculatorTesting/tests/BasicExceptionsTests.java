import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class BasicExceptionsTests {


    BasicCalculator test1;

    double x,y;

    public BasicExceptionsTests(double x) {
        this.x = x;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {

        Object[][] data = new Object[][]{
                {-3.0},
                {-4.0},
                {-5.0}

        };
        return Arrays.asList(data);
    }

    @BeforeClass
    public static void beforeClass()
    {
        System.out.println("Start of the test");
    }
    @AfterClass
    public static void afterClass()
    {
        System.out.println("End of the test");
    }
    @Before public void initialize()
    {
        test1 = new BasicCalculator();
    }
    @Test(expected = IllegalArgumentException.class)
    public void divideByZero()
    {
        test1.calculateDivision(1,0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void divideByZero2()
    {
        test1.calculateDivision(2,0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void divideByZero3()
    {
        test1.calculateDivision(3,0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void lessThanZeroSqrt()
    {
        test1.calculateSqr(x);
    }
    @After
    public void clean()
    {
        test1 = null;
    }
}
