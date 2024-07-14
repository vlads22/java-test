import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        // loop iterates through each point (currPt) in the shape using the s.getPoints() method
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return totalPerim; // totalPerim is the answer
    }
    public int getNumPoints () {
        // Put code here. we’ll need to write some language that will allow for this method to return an int that is the number of points in Shape s.
        //Point previousPoint = s.getLastPoint();
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        int numberOfPoints = 0;
        for (Point currentPoint : s.getPoints()){
            numberOfPoints = numberOfPoints + 1;
        }
        System.out.println("The shape has this number of points:" + numberOfPoints);
        return numberOfPoints;
    }

    public double getAverageLength() {
        // Put code here
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        int numPoints = getNumPoints();

        // get perimeter
        double length = getPerimeter(s);

        double averageLength = length / Double.valueOf(numPoints);

        System.out.println("The average length is:" + averageLength);
        return averageLength;
        //return 0.0;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        return 0.0;
    }

    public double getLargestX(Shape s) {
        // Put code here
        return 0.0;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }
    public void testPerimeter () {
    //public Shape testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("testPerimeter: perimeter = " + length);

        int numberOfPoints = 0;
        for (Point currentPoint : s.getPoints()){
            numberOfPoints = numberOfPoints + 1;
        }
        System.out.println("testPerimeter: The shape has this number of points:" + numberOfPoints);
        //return s;
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.getNumPoints();
        //FileResource fr = new FileResource();
        //Shape s = new Shape(fr);
        pr.getAverageLength();
    }
}
