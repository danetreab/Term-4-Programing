public class main {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.setRadius(1);System.out.println(c.getArea()+" "+c.getPerimeter());

        Rectangle r = new Rectangle();
        r.setheight(5);r.Setwidth(5);
        System.out.println(r.getArea()+" "+r.getPerimeter());

        RightTriangle ri = new RightTriangle();
        ri.setheight(3);ri.Setwidth(3);
        System.out.println(ri.getArea()+" "+ri.getPerimeter()+" "+ri.getHypotenuse());
        
    }
}
