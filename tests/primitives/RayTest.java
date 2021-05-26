package primitives;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RayTest {

    @Test
    void testFindClosestPoint() {
        Ray ray = new Ray(new Point3D(0, 0, 10), new Vector(1, 10, -100));

        List<Point3D> list = new LinkedList<>();
        list.add(new Point3D(1, 1, -200));
        list.add(new Point3D(-1, 1, -98));
        list.add(new Point3D(0, 2, -10));
        list.add(new Point3D(0.5, 0, -200));

        assertEquals(list.get(2), ray.findClosestPoint(list));

    }

    @Test
    void testFindClosestPoint2() {
        Ray ray = new Ray(new Point3D(0, 0, 10), new Vector(1, 10, -100));

        List<Point3D> list = null;

        assertNull(ray.findClosestPoint(list), "try again");
    }

    @Test
    void testFindClosestPointFirst() {
        Ray ray = new Ray(new Point3D(0, 0, 10), new Vector(1, 10, -100));

        List<Point3D> list = new LinkedList<>();
        list.add(new Point3D(0, 2, -10));
        list.add(new Point3D(1, 1, -200));
        list.add(new Point3D(-1, 1, -98));
        list.add(new Point3D(0.5, 0, -200));

        assertEquals(list.get(0), ray.findClosestPoint(list));

    }
    @Test
    void testFindClosestPointLast() {
        // Arrange
        Ray ray = new Ray(new Point3D(0, 0, 10), new Vector(1, 10, -100));

        List<Point3D> list = new LinkedList<>();
        list.add(new Point3D(1, 1, -100));
        list.add(new Point3D(-1, 1, -98));
        list.add(new Point3D(0.5, 0, -100));
        list.add(new Point3D(0, 2, -10));

        // Act
        Point3D closest = ray.findClosestPoint(list);

        // Assert
        assertEquals(list.get(3), closest);
    }
}