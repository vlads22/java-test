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
    public int getNumPointsWrong () {
        // Put code here. we’ll need to write some language that will allow for this method to return an int that is the number of points in Shape s.
        //Point previousPoint = s.getLastPoint();
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);


        int count = 0;
        for (Point p : s.getPoints()) {
            count = count + 1;
        }

        System.out.println("WRONG - The shape has this number of points:" + count);
        return count;
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
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()){
            double currDist = prevPt.distance(currPt);

            if (currDist >= largestSide) {
                largestSide = currDist;
            }

            prevPt = currPt;
        }
        double largestSideRounded = Math.round(largestSide * 100.0) / 100.0;

        System.out.println("getLargestSide - longest side id:" + largestSideRounded);
        return largestSideRounded;
    }

    public double getLargestX(Shape s) {
        double largestX = 0.0;

        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()){
            double currX = prevPt.getX();

            if (currX >= largestX) {
                largestX = currX;
            }

            prevPt = currPt;
        }

        System.out.println("getLargestX - largest x is:" + largestX);
        return largestX;

    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();

        double largestPerimeter = 0.0;

        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);

            double currentPerimeter = getPerimeter(s);

            if (currentPerimeter >= largestPerimeter) {
                largestPerimeter = currentPerimeter;

            }

        }
        double largestPerimeterRounded = Math.round(largestPerimeter * 100.0) / 100.0;
        System.out.println("getLargestPerimeterMultipleFile: " + largestPerimeterRounded);
        return largestPerimeterRounded;
    }

    public String getFileWithLargestPerimeter() {
        // return the name of the file with the larget perimeter
        DirectoryResource directory = new DirectoryResource();

        double largestPerimeter = 0.00;
        String fileNameWithLargestPerimeter = "";

        for (File f : directory.selectedFiles()) {

            FileResource file = new FileResource(f);

            Shape shape = new Shape(file);

            double currentPerimeter = getPerimeter(shape);

            if (currentPerimeter >= largestPerimeter) {
                largestPerimeter = currentPerimeter;
                fileNameWithLargestPerimeter = f.getName();
            }

        }

        //File temp = null;    // replace this code

        System.out.println("getFileWithLargestPerimeter: " + fileNameWithLargestPerimeter);

        return fileNameWithLargestPerimeter;
        //return temp.getName();
    }


    public void testPerimeter () {
    //public Shape testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);


        double lengthRoundedToTwoDecimalPlaces = Math.round(length * 100.0) / 100.0;

        System.out.println("testPerimeter: perimeter rounded to .00 = " + lengthRoundedToTwoDecimalPlaces);

        int numberOfPoints = 0;
        for (Point currentPoint : s.getPoints()){
            numberOfPoints = numberOfPoints + 1;
        }
        System.out.println("testPerimeter: The shape has this number of points:" + numberOfPoints);
        double averageLength = length / numberOfPoints;
        System.out.println("testPerimeter - average length: " + averageLength);
        //return s;
    }
    
    public void testPerimeterMultipleFiles() {
        double stringToPrint = getLargestPerimeterMultipleFiles();

        System.out.println("testPerimeterMultipleFiles: " + stringToPrint);
    }

    public void testFileWithLargestPerimeter() {
        String stringToPrint = getFileWithLargestPerimeter();
        System.out.println("testFileWithLargestPerimeter: " + stringToPrint);

//        String stringToPrint = getFileWithLargestPerimeter();
//
//        System.out.println("testFileWithLargestPerimeter: " + stringToPrint);
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

        //pr.getPerimeter();

        //pr.testPerimeter();

        pr.getNumPoints();
        pr.getNumPointsWrong();

        //pr.getAverageLength();

//        FileResource fr = new FileResource();
//        Shape s = new Shape(fr);
//        pr.getLargestSide(s);
//        pr.getLargestX(s);

        //pr.getLargestPerimeterMultipleFiles();

        //pr.testFileWithLargestPerimeter();

        //pr.getFileWithLargestPerimeter();
        //pr.testFileWithLargestPerimeter();

    }
}
