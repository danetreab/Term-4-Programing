public class Human implements Walkable {

    @Override
    public void walkLeft() {
        System.out.println("Turn left");  
    }

    @Override
    public void walkRight() {
        System.out.println("Turn right");
    }

    @Override
    public void walkForward() {
        System.out.println("Forward");
    }

    @Override
    public void walkBackward() {
        System.out.println("Backward"); 
    }
    
}

