package algorithms;

public class LineIntersection {

	public boolean onSegment(Line line, Point point) {
		if (point.x >= Math.min(line.a.x, line.z.x)
				&& point.x <= Math.max(line.a.x, line.z.x)
				&& point.y >= Math.min(line.a.y, line.z.y)
				&& point.y <= Math.max(line.a.y, line.z.y)) {
			return true;
		}
		return false;
	}

	/*****
	 * clockwise => dy1/dx1 > dy2/dx2
	 *           => dy1*dx2 - dy2*dx1 > 0
	 */
	public Orientation getOrientation(Point point1, Point point2, Point point3) {

		int slopeDiff = (point1.y - point2.y) * (point2.x - point3.x)
				- (point1.x - point2.x) * (point2.y - point3.y);

		if (slopeDiff > 0)
			return Orientation.clockwise;
		else if (slopeDiff < 0)
			return Orientation.counterclockwise;

		return Orientation.colinear;
	}

	public boolean intersects(Line line1, Line line2) {

		Orientation o1 = getOrientation(line1.a, line1.z, line2.a);
		Orientation o2 = getOrientation(line1.a, line1.z, line2.z);
		Orientation o3 = getOrientation(line2.a, line2.z, line1.a);
		Orientation o4 = getOrientation(line2.a, line2.z, line1.z);

		if (o1 != o2 && o3 != o4)
			return true;

		if (o1 == Orientation.colinear && onSegment(line1, line2.a))
			return true;

		if (o2 == Orientation.colinear && onSegment(line1, line2.z))
			return true;

		if (o3 == Orientation.colinear && onSegment(line2, line1.a))
			return true;

		if (o4 == Orientation.colinear && onSegment(line2, line1.z))
			return true;

		return false;
	}

	public static void main(String args[]) {
		LineIntersection lineIntersection = new LineIntersection();

		Line line1 = new Line(new Point(3, 4), new Point(9, 7));
		Line line2 = new Line(new Point(5, 2), new Point(7, 6));
		System.out.println(lineIntersection.intersects(line1, line2));

		line1 = new Line(new Point(3, 4), new Point(5, 6));
		System.out.println(lineIntersection.intersects(line1, line2));

		line2 = new Line(new Point(4, 3), new Point(5, 6));
		System.out.println(lineIntersection.intersects(line1, line2));

		line2 = new Line(new Point(4, 5), new Point(6, 7));
		System.out.println(lineIntersection.intersects(line1, line2));

		line2 = new Line(new Point(6, 7), new Point(8, 9));
		System.out.println(lineIntersection.intersects(line1, line2));
	}
}

class Line {
	Point a;
	Point z;

	public Line(Point a, Point z) {
		super();
		this.a = a;
		this.z = z;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

enum Orientation {
	colinear, counterclockwise, clockwise
}