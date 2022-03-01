import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner Obj = new Scanner(System.in);
        Human human[] = new Human[2];
        char i;
        int temp=0;
        do{
            System.out.println("a. Add Student");
            System.out.println("b. Add Teacher");
            System.out.println("c. Search By Name");
            System.out.println("d. Edit By Name");
            System.out.println("e. Print all element");
            System.out.println("f. Exit");
            i = Obj.next().charAt(0);
            if(i=='a'){
                if(temp==human.length){
                    System.out.println("The array is full!");
                }
                else{
                    System.out.print("Name : ");
                    Obj.nextLine();
                    String name = Obj.nextLine();
                    System.out.print("Age : ");
                    int age = Integer.parseInt(Obj.nextLine());
                    System.out.print("Nationality : ");
                    String nationality = Obj.nextLine();
                    System.out.print("Skill : ");
                    String skill = Obj.nextLine();
                    System.out.print("School Name : ");
                    String school = Obj.nextLine();
                    human[temp]=new Student(name, age, nationality,school,skill);
                    ++temp;
                }
            }
            else if(i=='b'){
                if(temp==human.length){
                    System.out.println("The array is full!");
                }
                else{
                    System.out.print("Name : ");
                    Obj.nextLine();
                    String name = Obj.nextLine();
                    System.out.print("Age : ");
                    int age = Integer.parseInt(Obj.nextLine());
                    System.out.print("Nationality : ");
                    String nationality = Obj.nextLine();
                    System.out.print("School Name : ");
                    String school = Obj.nextLine();
                    System.out.print("salary : ");
                    int salary = Integer.parseInt(Obj.nextLine());
                    human[temp]=new Teacher(name, age, nationality,salary,school);
                    ++temp;
                }
            }
            else if(i=='c'){
                System.out.print("Input the name to search : ");
                Obj.nextLine();
                String name_search = Obj.nextLine();
                int count=0,index=0;
                for(int t=0;t<human.length;t++){
                    if(name_search.equals(human[t].getName())){
                        count=1;
                        index=t;
                    }
                }
                if(count==0){
                    System.out.println(name_search+" Not found");
                }else{
                    System.out.println(human[index].getName()+" "+human[index].getAge()+" "+human[index].getNationality()+" "+human[index]);
                }
            }
            else if(i=='d'){
                System.out.print("Input the name to Edit : ");
                Obj.nextLine();
                String name_search = Obj.nextLine();
                int count=0,index=0;
                for(int t=0;t<human.length;t++){
                    if(name_search.equals(human[t].getName())){
                        count=1;
                        index=t;
                    }
                }
                if(count==0){
                    System.out.println(name_search+" Not found");
                }else{
                    if(human[index].getClass().getName()=="Student"){
                        System.out.print("Name : ");
                        String name = Obj.nextLine();
                        System.out.print("Age : ");
                        int age = Integer.parseInt(Obj.nextLine());
                        System.out.print("Nationality : ");
                        String nationality = Obj.nextLine();
                        System.out.print("Skill : ");
                        String skill = Obj.nextLine();
                        System.out.print("School Name : ");
                        String school = Obj.nextLine();
                    human[index]=new Student(name, age, nationality,school,skill);
                    }else{
                        System.out.print("Name : ");
                        String name = Obj.nextLine();
                        System.out.print("Age : ");
                        int age = Integer.parseInt(Obj.nextLine());
                        System.out.print("Nationality : ");
                        String nationality = Obj.nextLine();
                        System.out.print("School Name : ");
                        String school = Obj.nextLine();
                        System.out.print("salary : ");
                        int salary = Integer.parseInt(Obj.nextLine());
                    human[index]=new Teacher(name, age, nationality,salary,school);
                    }
                }
            }
            else if(i=='e'){
                System.out.println("\nInfo\n");
                for(int t=0;t<human.length;t++){
                    System.out.println(human[t].getName()+" "+human[t].getAge()+" "+human[t].getNationality()+" "+human[t]);
                }
            }
        }while(i!='f');
    }
}
