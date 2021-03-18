package geometries;

import org.junit.jupiter.api.Test;
import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

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
    }
