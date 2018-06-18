import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BasicTest {

    double x,y,z;
    BasicCalculator test1;

    public BasicTest(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {

        Object[][] data = new Object[][]{
                {4.0, 2.0, 6.0},
                {8.0, 3.0, 11.0},
                {5.0, 5.0, 10.0}

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
    @Before
    public void initialize()
    {
        test1 = new BasicCalculator();
    }

    @Test
    public void addingTest()
    {
        assertEquals(z, test1.calculateSum(x,y), 0);

    }
    @Test
    public void supplyingTest()
    {
        assertEquals(-1, test1.calculateDifference(2,3), 0);
        assertEquals(-6, test1.calculateDifference(0,6), 0);
        assertEquals(-35, test1.calculateDifference(-7,28), 0);
    }
    @Test
    public void multiplyingTest()
    {
        assertEquals(6, test1.calculateMultiplication(2,3), 0);
        assertEquals(0, test1.calculateMultiplication(0,6), 0);
        assertEquals(280, test1.calculateMultiplication(10,28), 0);
    }
    @Test
    public void dividingTest()
    {
        assertEquals(2, test1.calculateDivision(4,2), 0);
        assertEquals(0, test1.calculateDivision(0,6), 0);
        assertEquals(5, test1.calculateDivision(10,2), 0);
    }
    @Test
    public void poweringTest()
    {
        assertEquals(4, test1.calculatePow(2), 0);
        assertEquals(36, test1.calculatePow(-6), 0);
        assertEquals(100, test1.calculatePow(10), 0);
    }
    @Test
    public void rootTest()
    {
        assertEquals(2, test1.calculateSqr(4), 0);
        assertEquals(3, test1.calculateSqr(9), 0);
        assertEquals(10, test1.calculateSqr(100), 0);
    }
    @After
    public void clean()
    {
        test1 = null;
    }


}
