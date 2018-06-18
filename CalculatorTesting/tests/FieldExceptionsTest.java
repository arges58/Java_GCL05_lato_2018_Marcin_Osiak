import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class FieldExceptionsTest {

    FieldCalculator test2;
    double x,y;

    public FieldExceptionsTest(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {

        Object[][] data = new Object[][]{
                {-3.0, 16.0},
                {0.0, 64.0},
                {5.0, -2.0}

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
        test2 = new FieldCalculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void sideInSquareLessThanZero()
    {
        test2.calculateSquare(-3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void sideInSquareLessThanZero2()
    {
        test2.calculateSquare(-4);
    }
    @Test(expected = IllegalArgumentException.class)
    public void sideInSquareLessThanZero3()
    {
        test2.calculateSquare(0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void radiusInCircleLessThanZero()
    {
        test2.calculateCircle(-3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void radiusInCircleLessThanZero2()
    {
        test2.calculateCircle(0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void radiusInCircleLessThanZero3()
    {
        test2.calculateCircle(-4);
    }
    @Test(expected = IllegalArgumentException.class)
    public void valuesInTriangleLessThanZero()
    {
        test2.calculateTriangle(x, y);
    }

    @Test(expected = IllegalArgumentException.class)
    public void secondSideInRectangleLessThanZero()
    {
        test2.calculateRectangle(9, -3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void secondSideInRectangleLessThanZero2()
    {
        test2.calculateRectangle(0, 3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void secondSideInRectangleLessThanZero3()
    {
        test2.calculateRectangle(-3, -3);
    }
    @After
    public void clean()
    {
        test2 = null;
    }
}