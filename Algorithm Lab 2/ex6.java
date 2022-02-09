import java.util.Scanner;

class ex6 {
    public static void main(String[] args) {
        Scanner Obj = new Scanner(System.in);
        System.out.println("Input : ");
        char a = Obj.next().charAt(0);
        switch(a){
            case 'a' :
                System.out.println("Apple");
                break;
            case 'b' :
                System.out.println("Boy");
                break;
            case 'c' :
                System.out.println("Cat");
                break;
            case 'd' :
                System.out.println("Dog");
                break;
            case 'e' :
                System.out.println("Elephant");
                break;
            case 'f' :
                System.out.println("Fox");
                break;
            case 'g' :
                System.out.println("Goat");
                break;
            case 'h' :
                System.out.println("Hen");
                break;
            case 'i' :
                System.out.println("Ice");
                break;
            case 'j' :
                System.out.println("Jug");
                break;
            case 'k' :
                System.out.println("Kite");
                break;
            case 'l' :
                System.out.println("Lion");
                break;
            case 'm' :
                System.out.println("Mango");
                break;
            case 'n' :
                System.out.println("Nest");
                break;
            case 'o' :
                System.out.println("Orange");
                break;
            case 'p' :
                System.out.println("Parrot");
                break;
            case 'q' :
                System.out.println("Queen");
                break;
            case 'r' :
                System.out.println("Rose");
                break;
            case 's' :
                System.out.println("Ship");
                break;
            case 't' :
                System.out.println("Tiger");
                break;
            case 'u' :
                System.out.println("Umberella");
                break;
            case 'v' :
                System.out.println("Van");
                break;
            case 'w' :
                System.out.println("Watch");
                break;
            case 'x' :
                System.out.println("X-box");
                break;
            case 'y' :
                System.out.println("Yellow");
                break;
            case 'z' :
                System.out.println("Zebra");
                break;
            default : 
                System.out.println("Wrong Input");
        }

    }
}