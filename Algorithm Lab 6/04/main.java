import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner Obj=new Scanner(System.in);
        MyShape shape[] = new MyShape[2];
        char i;
        int temp=0;
        do{
            System.out.println("a. Add Rectangle");
            System.out.println("b. Add Circle");
            System.out.println("c. Search Object");
            System.out.println("d. Print all object");
            System.out.println("e. Exit");
            i=Obj.next().charAt(0);
            if(i=='a'){
                if(temp==shape.length){
                    System.out.println("The array is full!");
                }
                else{
                    System.out.print("Input width : ");
                    double width = Obj.nextDouble();
                    System.out.print("Input Height : ");
                    double height = Obj.nextDouble();
                    shape[temp]= new Rectangle(width, height);
                    ++temp;
                }
            }
            else if(i=='b'){
                if(temp==shape.length){
                    System.out.println("The array is full!");
                }
                else{
                    System.out.print("Input Radius : ");
                    double radius = Obj.nextDouble();
                    shape[temp]=new Circle(radius);
                    ++temp;
                }
            }
            else if(i=='c'){
                System.out.print("Input the area : ");
                double area = Obj.nextDouble();
                int count=0,index=0;
                for(int t=0;t<shape.length;t++){
                    if(area==shape[t].getArea()){
                        count=1;
                        index=t;
                    }
                }
                if(count==0){
                    System.out.println("Not match the given data area");
                }else{
                    System.out.println(shape[index]);
                    System.out.println("The class that this object create from : "+shape[index].getClass().getName());
                }
            }
            else if(i=='d'){
                for(int l=0;l<shape.length;l++){
                    System.out.println(shape[l]);
                }
            }
        }while(i!='e');
    }
}
