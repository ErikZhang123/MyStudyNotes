package Wildcard.closestPoint;
import java.util.*;
public class ClosestPoints {
    public static List<? extends Point> generatePoints(int n){
        List<Point> points = new ArrayList<>();
        Random r = new Random();
        for(int i=0;i<n;i++){
            points.add(new Point(r.nextDouble(), r.nextDouble()))
        }
        return points;
    }

    public static Point[] closestPair(List<? extends Point> points){
        Point[] pair = new Point[2];
//        code here
        double distance;
        double min=99999999;
        for(int i=0;i<points.size()-1;i++)
        {
            for (int j=1+i; j< points.size();j++){
                Point p1 = points.get(i);
                Point p2 = points.get(j);
                distance = ClosestPoints.getdistance(p1,p2);
                if(distance < min)
                {
                    pair[0]=p1;
                    pair[1]=p2;
                    min = distance;
                }
            }
        }
        return pair;
    }

    public static double getdistance(Point a , Point b)
    {
        double x1 = a.x();
        double x2 = b.x();
        double y1 = a.y();
        double y2 = b.y();
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }
}
class Point{
    private double x;
    private double y;
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
    public double x(){return x;}
    public double y(){return y;}
    public String toString(){
        return "("+ x+ ","+y+")";
    }
}
