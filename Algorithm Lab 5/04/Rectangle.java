public class Rectangle extends Shape{
    public double width;
    public double height;
    public Rectangle(double width,double height){
        this.height=height;
        this.width=width;
    }
    public Rectangle() {
    }
    public void Setwidth(double width){
        this.width=width;
    }
    public double getwidth(){
        return width;
    }
    public void setheight(double height){
        this.height=height;
    }
    public double getheight(){
        return height;
    }
    public double getArea(){
        return getwidth()*getheight();
    }
    public double getPerimeter(){
        return 2*(getwidth()+getheight());
    }
}
