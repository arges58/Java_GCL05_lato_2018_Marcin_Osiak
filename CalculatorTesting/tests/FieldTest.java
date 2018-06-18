import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)


public class FieldTest {
    FieldCalculator test2;
    double x,y;

    public FieldTest(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {

        Object[][] data = new Object[][]{
                {4.0, 16.0},
                {8.0, 64.0},
                {5.0, 25.0}

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

    @Test
    public void squareTest()
    {
        assertEquals(y, test2.calculateSquare(x), 0);
    }
    @Test
    public void circleTest()
    {
        assertEquals(Math.PI * 2 * 4, test2.calculateCircle(4), 0);
        assertEquals(Math.PI * 2 * 6, test2.calculateCircle(6), 0);
        assertEquals(Math.PI * 2 * 7, test2.calculateCircle(7), 0);
    }
    @Test
    public void triangleTest()
    {
        assertEquals(4, test2.calculateTriangle(4,2), 0);
        assertEquals(18, test2.calculateTriangle(6, 6), 0);
        assertEquals(14, test2.calculateTriangle(7, 4), 0);
    }
    @Test
    public void rectangleTest()
    {
        assertEquals(12, test2.calculateRectangle(4, 3), 0);
        assertEquals(36, test2.calculateRectangle(6, 6), 0);
        assertEquals(70, test2.calculateRectangle(7, 10), 0);
    }
    @After
    public void clean()
    {
        test2 = null;
    }
}
