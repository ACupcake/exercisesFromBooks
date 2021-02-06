import java.lang.Math;

public class Main {
    private static final int MAXIMUM_INTEGER = 1000000;

    // This class should not be instantiated.
    private Main() { }

    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        Point2D[] points = new Point2D[100];
        int position = 0;
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor();

        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f\n", n, time);
            points[position++] = new Point2D(n, time);
            StdDraw.clear();
            StdDraw.setXscale(0, Math.log(n)); // data to process
            double y = Math.log(time);
            if(y < -100000) y = 10;
            StdDraw.setYscale(-10, y); //time to complete
            drawPoints(points, position);
        } 
    } 

    public static void drawPoints(Point2D[] points, int totalPoints) {
        for(int i = 1; i < totalPoints; i++)
        	StdDraw.line(Math.log(points[i-1].x()), Math.log(points[i-1].y()), Math.log(points[i].x()), Math.log(points[i].y()));
    }
}