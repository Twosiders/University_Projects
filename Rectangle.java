/**
 * Created by Alexander on 20/07/2015.
 */
public class Rectangle {
    private double length;
    private double width;
    private static int count;
    public Rectangle (double l, double w) {
        this.length = l;
        this.width = w;
        count++;
    }
    public double perimeter() {
        return (length+width)*2;
    }
    public double area() {
        return length * width;
    }
    public void report () {
        System.out.print("Length: ");
        System.out.format("%6.3f", length);
        System.out.print(" Width: ");
        System.out.format("%6.3f",width);
        System.out.print(" Area: ");
        System.out.format("%8.4f", area());
        System.out.print(" Perimeter: ");
        System.out.format("%9.4f", perimeter());
        System.out.print("\n");
    }
    public static void main(String[] args) {
        System.out.println("Number of rectangles: " + count);
        Rectangle[] oblongs = new Rectangle[4];
        oblongs[0] = new Rectangle(2, 3);
        oblongs[1] = new Rectangle(Math.sqrt(2), 3);
        oblongs[2] = new Rectangle(2, 3 * Math.sqrt(2));
        oblongs[3] = new Rectangle(Math.sqrt(2), 3 * Math.sqrt(2));
        for (int j=0;j<4;j++) oblongs[j].report();
        System.out.println("Number of rectangles: " + count);
    }
}
