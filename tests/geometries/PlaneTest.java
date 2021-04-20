package geometries;

import org.junit.jupiter.api.Test;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {
    /**
     * test for plane get normal function @link geometries.Plane# getNormal(primitives.Point3D)}.
     */
    @Test
    void getNormal() {

        Plane P = new Plane(new Point3D(6,7,8), new Vector(4,5,6));
        Vector v1 = P._normal;
        Vector v2 = P.getNormal(new Point3D(3,4,5));
        assertEquals(v1, v2);
    }

    @Test
    public void findIntersections() {

        Plane plane = new Plane(new Point3D(1,1,0), new Vector(0,0,1));

        // ============ Equivalence Partitions Tests ==============
        //TC01: ray intersects the plane
        assertEquals( List.of(new Point3D(1,0,0)),
                plane.findIntersections(new Ray(new Point3D(0,0,-1), new Vector(1,0,1))),"ray intersects the plane");

        //TC02: ray does'nt intersect the plane
        assertNull(plane.findIntersections(new Ray(new Point3D(0,0,-1), new Vector(1,0,-1))),"ray doesn't intersect the plane");

        // =============== Boundary Values Tests ==================
        // **** Group: ray is parallel to the plane
        //TC11: the ray is included in the plane

        //TC12: the ray is not included in the plane
        assertNull(plane.findIntersections(new Ray(new Point3D(1,1,1), new Vector(0,1,0))),"the ray is parallel and not included in the plane");

        //**** Group: ray is orthogonal to the plane
        //TC13: the ray is before the plane
        assertEquals( List.of(new Point3D(1,1,0)),
                plane.findIntersections(new Ray(new Point3D(1,1,-1), new Vector(0,0,1))),"the ray is orthogonal and before the plane");

        //TC14: the ray is in the plane
        assertNull(plane.findIntersections(new Ray(new Point3D(1,1,0), new Vector(0,0,1))),"the ray is orthogonal and in the plane");

        //TC15: the ray is after the plane
        assertEquals(List.of(new Point3D(1,1,0)),
                plane.findIntersections(new Ray(new Point3D(1,1,1), new Vector(0,0,-1))),"the ray is orthogonal and after the plane");
        //TC16: the ray is neither orthogonal nor parallel to and begins at the plane
        assertNull(plane.findIntersections(new Ray(new Point3D(2,2,0), new Vector(1,1,1))),"the ray is neither orthogonal nor parallel to and begins at the plane");

        //TC17: the ray is neither orthogonal nor parallel to the plane and begins in
        //the same point which appears as reference point in the plane
        assertNull(plane.findIntersections(new Ray(new Point3D(1,1,0), new Vector(1,1,1))),"the ray is neither orthogonal nor parallel to the plane and begins in " +
                "the same point which appears as reference point in the plane");
    }
    }
