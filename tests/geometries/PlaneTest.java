package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {
    /**
     * test for plane get normal function @link geometries.Plane# getNormal(primitives.Point3D)}.
     */
    @Test
    void getNormal() {

            //Point3D point=new Point3D(3, 2,0);
           // Point3D vectorPoint=new Point3D(0,0,1);
           // Vector v=new Vector(new Point3D(0,0,1));
            //Plane p=new Plane(point,v);
            //assertEquals(p.getNormal(point),v);
        Plane p = new Plane(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals( new Vector(sqrt3, sqrt3, sqrt3), p.getNormal(new Point3D(0, 0,1)), "Bad normal to plane");
    }
    }
