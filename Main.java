abstract class shape {
    int dim1,dim2;
    
    shape(int a,int b){
        dim1=a;
        dim2=b;
    }
abstract void printArea();
}
class Rectangle extends shape{
    Rectangle(int a,int b){
        super(a,b);
    }
    void printArea(){
        System.out.println("Area of Rectangle:"+(dim1*dim2));
    }
}
class Triangle extends shape{
    Triangle(int a, int b){
        super(a,b);
    }
    void printArea(){
        System.out.println("Area of Triangle:"+(0.5*dim1*dim2));
}
}
class Circle extends shape{
 Circle(int radius){
    super(radius,0);
 }
 void printArea(){
    System.out.println("Area of circle:"+(Math.PI*dim1*dim1));
 }
}

public class Main{
    public static void main(String[] args) {
        Rectangle r=new Rectangle(10,20);
        Triangle t=new Triangle(10,15 );
        Circle c=new Circle(5);

        r.printArea();
        t.printArea();
        c.printArea();
    }
}