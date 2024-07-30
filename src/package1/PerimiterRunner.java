package package1;

import edu.duke.*;



public class PerimiterRunner {
    public double getPerimiter (Shape s) {
        double totalPerim = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt: s.getPoints()){
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }

    public void testPerimiter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimiter(s);
        System.out.println("perimeter = " + length);
    }

    public static void main (String[] args){
        PerimiterRunner pr = new PerimiterRunner();
        pr.testPerimiter();
    }
}
