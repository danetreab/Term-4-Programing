public class Circle extends Shape {
    public double radius;
    
    public Circle(int radius) {
        this.radius=radius;
    }
    public Circle(){

    }
    public void setRadius(double radius){
        this.radius=radius;
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return 3.14*radius*radius;
    }
    public double getPerimeter(){
        return 2*3.14*radius;
    }
}
