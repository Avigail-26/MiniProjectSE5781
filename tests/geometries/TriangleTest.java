package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;
/**
 * test for triangle get normal function @link geometries.Triangle# getNormal(primitives.Point3D)}.
 */
class TriangleTest {
    @Test
    public void getNormal() {
        Triangle tr = new Triangle(new Point3D(0,0,1), new Point3D(1,1,1), new Point3D(1,0,1));
        assertEquals(new Vector(0d,0d,-1d),tr.getNormal(null));
}

    @Test
    public void findIntersections() {
        Triangle triangle = new Triangle(new Point3D(1,0,0), new Point3D(0,1,0),
                Point3D.ZERO);

        // ============ Equivalence Partitions Tests ==============
        //TC01: the ray begins inside the triangle
        assertNull(triangle.findIntersections(new Ray(new Point3D(0.5,0.5,0), new Vector(1,0,0))),"Ray from triangle outside");

        //TC02: the ray begins outside against edge
        assertNull(triangle.findIntersections(new Ray(new Point3D(0.5,-1,0), new Vector(0,1,0))),"Ray from outside of triangle against edge");

        //TC03: the ray begins outside against vertex
        assertNull(triangle.findIntersections(new Ray(new Point3D(2,0,0), new Vector(-1,0,0))),"Ray from outside of triangle against vertex");

        // =============== Boundary Values Tests ==================
        //TC11: the ray begins on edge
        assertNull(triangle.findIntersections(new Ray(new Point3D(0.5,0,0), new Vector(0,0,1))),"Ray begins on edge against outside");

        //TC12: the ray begins in vertex
        assertNull(triangle.findIntersections(new Ray(new Point3D(0,1,0), new Vector(0,0,1))),"Ray begins in vertex against outside");

        //TC13: the ray begins on edge's continuation
        assertNull(triangle.findIntersections(new Ray(new Point3D(0,2,0), new Vector(0,-1,0))),"Ray begins on edge's continuation against outside");
    }

}