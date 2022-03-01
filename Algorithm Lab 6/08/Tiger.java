public class Tiger implements MoveAble{
    public String color;
    public double weight;
    Tiger(String color,double weight){
        this.color=color;
        this.weight=weight;
    }
    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public void moveLeft() {
        System.out.println("Tiger move left");
    }

    @Override
    public void moveRight() {
        System.out.println("Tiger move right");
    }

    @Override
    public void moveUp() {
        System.out.println("Tiger move up");
    }

    @Override
    public void moveDown() {
        System.out.println("Tiger move down");
    }
    @Override
    public String toString(){
        return color+" "+weight;
    }
}
