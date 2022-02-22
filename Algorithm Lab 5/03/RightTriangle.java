public class RightTriangle extends Shape {
    public double height;
    public double width;
    public RightTriangle(){

    }
    public RightTriangle(double height,double width){
        this.height=height;
        this.width=width;
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
    public double getHypotenuse(){
        return Math.sqrt((getheight()*getheight())+(getheight()*getheight()));
    }
    public double getArea(){
        return 0.5*getheight()*getwidth();
    }
    public double getPerimeter(){
        return getheight()+getwidth()+getHypotenuse();
    }
}
