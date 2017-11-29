package implementation;

import service.Polygon;

public class RegularPolygon implements Polygon {
    int sumOfSides;
    int sum;

    public void calculatePerimeter(int length, int sides) {
        if (sides < 3 || sides > 10) {
            System.out.println("Enter the sides in proper range");
        } else {
            sumOfSides = length * sides;
            System.out.println("The perimeter of regular polygon is " + sumOfSides);
        }
    }
    public void calculateSumOfAngles(int sides){
        if (sides < 3 || sides > 10) {
            System.out.println("Enter the sides in proper range");
        } else {

            sum = (sides - 2) * 180;
            System.out.println("The sum of interior angles of polygon is " + sum + " degrees");
        }
    }
}
