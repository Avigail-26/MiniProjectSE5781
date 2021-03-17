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

        Sphere s = new Sphere(new Point3D(0,0,0), 4);

        assertEquals(new Vector(new Point3D(0, 0, 1)), s.getNormal(new Point3D(0, 0, 4)));
        assertEquals(new Vector(new Point3D(0, 0, -1)), s.getNormal(new Point3D(0, 0, -4)));
        assertEquals(new Vector(new Point3D(0, 1, 0)), s.getNormal(new Point3D(0, 4, 0)));
        assertEquals(new Vector(new Point3D(0, -1, 0)), s.getNormal(new Point3D(0, -4, 0)));
        assertEquals(new Vector(new Point3D(1, 0, 0)), s.getNormal(new Point3D(4, 0, 0)));
        assertEquals(new Vector(new Point3D(-1, 0, 0)), s.getNormal(new Point3D(-4, 0, 0)));

        }

    }
