public class main {
    public static void main(String[] args) {
        Human man = new Human();
        Animal cat = new Animal();

        man.walkForward();
        man.walkRight();

        cat.walkBackward();
        cat.walkLeft();
    }
}
