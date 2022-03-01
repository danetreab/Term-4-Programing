public class Circle extends MyShape {
    public double radius;
    Circle(double radius){
        this.radius=radius;
    }
    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return 3.14*radius*radius;
    }
    @Override
    public double getperimeter() {
        return 3.14*2*radius;
    }
    @Override 
    public String toString(){
        return "Circle("+"Area : "+getArea()+" Perimeter : "+getperimeter()+")";
    }
}
