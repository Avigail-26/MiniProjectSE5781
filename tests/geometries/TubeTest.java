package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class TubeTest {
    /**
     * test for tube get normal function @link geometries.Tube# getNormal(primitives.Point3D)}.
     * }
     */
    @Test
    void getNormal() {

            //Tube t= new Tube(new Ray(new Point3D(3,5,8),new Vector(4,7,6)), 4);
            //Vector n=t.getNormal(new Point3D(4,2,1));
            //Vector check=new Vector(0.6736255682471604, 0.21987778192043828, -0.7056077910719512);
            //assertEquals(check, n);

            Tube tb = new Tube(1, new Ray(new Point3D(0,0,1), new Vector(0, 1, 0)));
            assertEquals(new Vector(0,0,1),tb.getNormal(new Point3D(0,0.5,2)));
    }
}