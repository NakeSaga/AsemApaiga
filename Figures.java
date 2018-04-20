import java.util.Scanner;
public class Figures {
// I renamed side1,side2,side3 with a,b,c
// Also it was our homework so I did it at home already and I have not only triangle
// I created also Rectangle, Square, Circle, Polygon
    public static void main(String args[]) {
        GeometricalObject s = new Triangle(3, 4, 5);
        s.setColour("Blue");
        s.setFilled(false);
        GeometricalObject r = new Rectangle(4, 5);
        r.setColour("Red");
        r.setFilled(true);
        GeometricalObject c = new Circle(4);
        c.setColour("Green");
        c.setFilled(true);
        GeometricalObject p = new Square(5);
        p.setColour("Black");
        p.setFilled(false);
        System.out.println(s);
        System.out.println(r);
        System.out.println(c);
        System.out.println(p);
    }

}

class GeometricalObject {

    /**
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return the perimeter
     */
    public double getPerimeter() {
        return perimeter;
    }

    /**
     * @param perimeter the perimeter to set
     */
    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    /**
     * @return the filled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * @param filled the filled to set
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * @return the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        if (filled) {
            return "Color: " + getColour() + ", " + "Filled";
        } else {
            return "Color: " + getColour() + ", " + "Not filled";

        }
    }

    private double area;
    private double perimeter;
    private boolean filled;
    private String colour = new String();

}

class Triangle extends GeometricalObject {

    private double a, b, c;

    @Override
    public double getArea() {
        double abc = getPerimeter() / 2;
        double g = Math.sqrt(abc * (abc - a) * (abc - b) * (abc - c));
        return g;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return super.toString() + " Triangle with sides: " + a + ", " + b + ", " + c + " perimeter is: " + getPerimeter() + " Area: " + getArea();
    }
    
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
}

class Rectangle extends GeometricalObject {

    private double a, b;

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public double getPerimeter() {
        return (a + b) * 2;
    }

    @Override
    public String toString() {
        return super.toString() + " Rectangle with sides: " + a + ", " + b + " perimeter is: " + getPerimeter() + " Area: " + getArea();
    }

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Rectangle() {
    }

}

class Square extends GeometricalObject {

    private double a;

    @Override
    public double getArea() {
        return a * a;
    }

    @Override
    public double getPerimeter() {
        return 4 * a;
    }

    @Override
    public String toString() {
        return super.toString() + " Square with side: " + a + " perimeter is: " + getPerimeter() + " Area: " + getArea();
    }

    public Square(double a) {
        this.a = a;
    }

}

class Circle extends GeometricalObject {

    private double radius;

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public String toString() {
        return super.toString() + " Circle with radius: " + radius + " perimeter is: " + getPerimeter() + " Area: " + getArea();
    }

    public Circle(double a) {
        radius = a;
    }
}

class Polygon extends GeometricalObject {

    private double[] xs;
    private double[] ys;

    public Polygon(double[] mass1, double[] mass2) {
        xs = mass1;
        ys = mass2;
    }

    @Override
    public double getArea() {
        double per = 0;
        for (int i = 0; i < xs.length - 1; i++) {
            per += xs[i] * ys[i + 1] - ys[i] * xs[i + 1];
        }
        per += xs[xs.length - 1] * ys[0] - ys[ys.length - 1] * xs[0];
        per = per / 2;
        if (per > 0) {
            return per;
        } else {
            return -per;
        }

    }

    @Override
    public double getPerimeter() {
        double per = 0;
        for (int i = 0; i < xs.length - 1; i++) {
            per += Math.sqrt(Math.pow((xs[i + 1] - xs[i]), 2) + Math.pow((ys[i + 1] - ys[i]), 2));
        }
        per += Math.sqrt(Math.pow((xs[xs.length - 1] - xs[0]), 2) + Math.pow((ys[ys.length - 1] - ys[0]), 2));
        return per;

    }
}
