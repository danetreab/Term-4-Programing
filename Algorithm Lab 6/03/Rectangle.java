public class Rectangle extends MyShape {
    public double width;
    public double height;
    Rectangle(double width,double height){
        this.width=width;
        this.height=height;
    }
    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public double getArea(){
        return width*height;
    }
    @Override
    public double getperimeter(){
        return 2*(width+height);
    }
    @Override 
    public String toString(){
        return "Rectangle("+"Area : "+getArea()+" Perimeter : "+getperimeter()+")";
    }
}

