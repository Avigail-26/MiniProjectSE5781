package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point3DTest {

    Point3D p1 = new Point3D( 0.0d, 0.5d, 1.0d);
    Point3D p2 = new Point3D( 0.00000001d, 0.49999999d, 1d);

    @Test
    void testEquals() {
        assertEquals(p1, p2);
    }

    @Test
    void testToString() {
        System.out.println("th first point is: " + p1);
        System.out.println("th first point is: " + p2);

    }
}