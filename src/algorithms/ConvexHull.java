package algorithms;

import java.util.ArrayList;
import java.util.List;

public class ConvexHull extends LineIntersection {

	List<Point> points;

	public ConvexHull(List<Point> points) {
		super();
		this.points = points;
	}

	private Point getLeftMostPoint() {
		Point leftMostPoint = new Point(Integer.MAX_VALUE, 0);

		for (Point point : points) {
			if (point.x < leftMostPoint.x) {
				leftMostPoint = point;
			}
		}
		return leftMostPoint;
	}

	public List<Point> find() {
		List<Point> convexHull = new ArrayList<Point>();
		Point startingPoint = getLeftMostPoint();
		Point currentPoint = startingPoint;

		do {
			convexHull.add(currentPoint);

			Point nextPoint = null;

			for (Point point : points) {
				if (point != currentPoint) {
					if (nextPoint == null
							|| getOrientation(currentPoint, nextPoint, point) == Orientation.counterclockwise) {
						nextPoint = point;
					}
				}
			}
			
			currentPoint = nextPoint;
			
		} while (currentPoint != startingPoint);

		return convexHull;
	}

	public static void main(String args[]) {
		List<Point> points = new ArrayList<Point>();
		//expected output
		points.add(new Point(1, 5));
		points.add(new Point(5, 10));
		points.add(new Point(8, 3));
		points.add(new Point(6, 1));
		points.add(new Point(2, 2));
		//in between points
		points.add(new Point(3, 3));
		points.add(new Point(3, 6));
		points.add(new Point(4, 8));
		points.add(new Point(4, 4));
		points.add(new Point(4, 5));
		points.add(new Point(5, 4));
		points.add(new Point(6, 7));
		points.add(new Point(7, 3));

		ConvexHull convexHull = new ConvexHull(points);
		System.out.println(convexHull.find());
	}
}
