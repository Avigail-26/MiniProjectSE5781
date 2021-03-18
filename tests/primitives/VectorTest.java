package primitives;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

/**
 * Test for Vector
 * @author Aliza Eliacheff and Avigail Fitoussi
 */
class VectorTest {

    Vector v1 = new Vector(1, 2, 3);
    Vector v2 = new Vector(-2, -4, -6);
    /**
     * test for vector subtraction function @link primitives.Vector# subtract(primitives.Vector);}.
     */
    @Test
    void subtract() {
        Vector v3=v1.subtract(v2);
        assertEquals(new Vector(3.0, 6.0, 9.0), v3);

    }
    /**
     * test for vector addition function @link primitives.Vector# add(primitives.Vector);}.
     */
    @Test
    void add() {
        Vector v3 = v1.add(v2);
        assertEquals(new Vector(-1.0, -2.0, -3.0), v3);

        //v2 = v2.add(v1);
        //assertEquals(new Vector(-3.0, -3.0, -3.0), v2);
    }
    /**
     * test for vector scaling function @link primitives.Vector# scale(double);}.
     */
    @Test
    void scale() {

        v1.scale(1);
        assertEquals(v1, v1);
        Vector v2=v1.scale(2);
        assertEquals(new Vector(2.0, 4.0, 6.0), v2);
        Vector v3=v2.scale(-2);
        assertEquals(new Vector(-4.0, -8.0, -12.0), v3);
    }

    @Test
    void dotProduct() {

        assertEquals(-28, v1.dotProduct(v2));

    }
    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     */

    @Test
    void crossProduct() {


        // ============ Equivalence Partitions Tests ==============
        Vector v3 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v3);

        // Test that length of cross-product is proper (orthogonal vectors taken for simplicity)
        assertEquals(v1.length() * v3.length(), vr.length(), 0.00001,"crossProduct() wrong result length");

        // Test cross-product result orthogonality to its operands
        assertTrue(isZero(vr.dotProduct(v1)),"crossProduct() result is not orthogonal to 1st operand");
        assertTrue(isZero(vr.dotProduct(v3)),"crossProduct() result is not orthogonal to 2nd operand");

        // =============== Boundary Values Tests ==================
        // test zero vector from cross-product of co-lined vectors
        try {
            v1.crossProduct(v2);
            fail("crossProduct() for parallel vectors does not throw an exception");
        } catch (IllegalArgumentException e){}
    }

    /**
     * test for vector length squared function @link primitives.Vector# lengthSquared();}.
     */
    @Test
    void lengthSquared() {
        if (!isZero(v1.lengthSquared() - 14))
            fail("ERROR: lengthSquared() wrong value");
    }
    /**
     * test for vector length function @link primitives.Vector# length();}.
     */
    @Test
    void length() {
        // test length..
        if (!isZero(new Vector(0, 3, 4).length() - 5))
            fail("ERROR: length() wrong value");

    }

    @Test
    void normalize() {
        // ============ Equivalence Partitions Tests ==============

        Vector v = new Vector(1, 2, 3);
        Vector vCopy = new Vector(v.getHead());
        Vector vCopyNormalize = vCopy.normalize();
        if (vCopy != vCopyNormalize)
            fail("ERROR: normalize() function creates a new vector");
        if (!isZero(vCopyNormalize.length() - 1))
            fail("ERROR: normalize() result is not a unit vector");
        Vector u = v.normalized();
        if (u == v)
            fail("ERROR: normalized() function does not create a new vector");
    }
    /**
     * test for vector normalized function  @link primitives.Vector# normalized();}.
     */
    @Test
    void normalized() {
        Vector v1=new Vector(2,3,4);
        Vector v= v1.normalized();
        Vector v2=new Vector(2/Math.sqrt(29),3/Math.sqrt(29),4/Math.sqrt(29));
        assertEquals(v2, v);
        Vector v3 = new Vector(1, 2, 3);
        Vector u = v.normalized();
        assertNotEquals(u, v3);
    }
}