public class Rectangle {
    public double width;
    public double height;
    public String color;
    public Rectangle() {
        
    }
    public Rectangle(double width,double height){
        this.width=width;
        this.height=height;
    }
    public Rectangle(double width,double height,String color){
        this.width=width;
        this.height=height;
        this.color=color;
    }
    public Double getWidth() {
        return width;
    }
    public Double getHeight() {
        return height;
    }
    public String getColor() {
        return color;
    }
    public Double getArea() {
        return width*height;
    }
}
