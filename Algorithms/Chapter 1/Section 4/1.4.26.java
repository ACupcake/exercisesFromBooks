//They are collinear <-> a³-b³/a-b=b³-c³/b-c

//(a³-b³)/a-b=(b³-c³)/b-c
//(a-b)(a²+ab+b²)/a-b=(b-c)(b²+bc+c²)/b-c
//(a²+ab+b²)=(b²+bc+c²)
//(a²+ab+b²)=(b²+bc+c²)
//(a²-c²)+b(a-c)=0
//(a-c)(a+b+c)=0
//Since the points are distinct a=/=c, hence:
//a+b+c=0

public class Main {
	public static int countTriples(Point2D[] points) {
		int countValid = 0;

		for(int i = 0; i < points.length; i++) {
			for(int j = i+1; j < points.length; j++) {
				for(int k = j+1; k < points.length; k++) {
					if(areCollinear(points[i], points[j], points[k])) {
						countValid++;
					}
				}
			}
		}
		return countValid;
	}

	public static boolean areCollinear(Point2D a, Point2D b, Point2D c) {
		double abCoefficient = (a.y() - b.y()) / (a.x() - b.x());
		double bcCoefficient = (b.y() - c.y()) / (b.x() - c.x());
		
		return abCoefficient == bcCoefficient;
	}
}