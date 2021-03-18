package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {
    /**
     * test for sphere get normal @link geometries.Sphere# getNormal(primitves.Point3D)}.
     */
    @Test
    void getNormal() {
        Sphere sp = new Sphere(new Point3D(0,0,0), 5);
        assertEquals(new Vector(1,0,0),sp.getNormal(new Point3D(5,0,0)));

        }

    }
