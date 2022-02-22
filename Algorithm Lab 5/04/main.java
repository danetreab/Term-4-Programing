public class main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        Rectangle r = new Rectangle();
        Circle t = new Circle();
        RightTriangle l = new RightTriangle();
        shapes[0] = new Rectangle(5,6);
        shapes[1] = new Circle(5);
        shapes[2] = new RightTriangle(2,3);
        shapes[3] = new Circle(1);
        shapes[4] = new RightTriangle(1,3);

        for(int i=0;i<5;i++){
            System.out.println(shapes[i].getArea()+" "+shapes[i].getPerimeter());
        }
    }
}
