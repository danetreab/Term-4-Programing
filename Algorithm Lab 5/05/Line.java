public class Line extends Point{

    Point p1;
    Point p2;

    Line(){

    }
    Line(Point p1,Point p2){
        this.p1=p1;
        this.p2=p2;
    }
    public void setp1(Point p1){
        this.p1=p1;
    }
    public Point getp1(){
        return p1;
    }
    public void setp2(Point p2){
        this.p2=p2;
    }
    public Point getp2(){
        return p2;
    }
}
