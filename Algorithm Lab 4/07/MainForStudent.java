import java.util.Scanner;

public class MainForStudent {
    public static void main(String[] args) {
        Student[] students = new Student[10];
        // students[0] = new Student(1,"A","Elon",2000);
        // students[1] = new Student(2,"F","Elon",2003);
        // students[2] = new Student(3,"C","Elon",2005);
        // students[3] = new Student(8,"D","Elon",2001);
        // students[4] = new Student(32,"E","Elon",2011);
        // students[5] = new Student(9,"G","Elon",2011);
        // students[6] = new Student(11,"H","Elon",2011);
        // students[7] = new Student(15,"L","Elon",2011);
        // students[8] = new Student(116,"K","Elon",2011);
        // students[9] = new Student(18,"M","Elon",2011);
        fillData(students);
        printAll(students);
        searchStudentByName(students, "X");
        searchStudentById(students, 9);
        sortById(students);
        sortByName(students);

    }
    public static void fillData(Student[] students) {
        Scanner Obj = new Scanner(System.in);
        for(int i=0;i<students.length;i++){    
            System.out.println(i+". ID Name Department Generation");
            int id = Obj.nextInt();
            Obj.nextLine();
            String name = Obj.nextLine();
            String department = Obj.nextLine();
            int generation = Obj.nextInt();
            students[i] = new Student(id,name,department,generation);
        }
    }
    public static void printAll(Student[] students) {
        for(int i=0;i<students.length;i++)
        System.out.println(students[i].id+"\t"+students[i].name+"\t"+students[i].department+"\t"+students[i].generation);
    }
    public static void searchStudentByName(Student[] students,String name) {
        int l=0;
        for(int i=0;i<students.length;i++){
            if(name.equals(students[i].name)){
                l=1;
            }
        }
        String s = (l==1) ? ("Student Name \""+name+"\" found") :  ("Student Name \""+name+"\" not found");
        System.out.println(s);
    }
    public static void searchStudentById(Student[] students,int id) {
        int l=0;
        for(int i=0;i<students.length;i++){
            if(id==students[i].id){
                l=1;
            }
        }
        String s = (l==1) ? ("Student Id \""+id+"\" found") :  ("Student Id \""+id+"\" not found");
        System.out.println(s);
    }
    public static void sortByName(Student[] students) {
        for(int a = 0; a < students.length - 1; a++){
            for(int b = a + 1; b < students.length; b++){
                if((students[a].name).compareTo(students[b].name) > 0){
                    String temp = students[a].name;
                    students[a].name = students[b].name;
                    students[b].name = temp;

                    int temp1 = students[a].id;
                    students[a].id = students[b].id;
                    students[b].id = temp1;

                    int temp2 = students[a].generation;
                    students[a].generation = students[b].generation;
                    students[b].generation = temp2;

                    String temp3 = students[a].department;
                    students[a].department = students[b].department;
                    students[b].department = temp3;
                }
            }
        }
        for (int i = 0; i < students.length; i++){
        System.out.println(students[i].id+"\t"+students[i].name+"\t"+students[i].department+"\t"+students[i].generation);
        }
    }
    public static void sortById(Student[] students) {
        int temp=0,temp2;
        String temp1,temp3;
        for (int i = 1; i < students.length; i++) {
            for (int j = i; j > 0; j--) {
             if (students[j].id < students [j - 1].id) {
              temp = students[j].id;
              students[j].id = students[j - 1].id;
              students[j - 1].id = temp;

              temp1 = students[j].name;
              students[j].name = students[j - 1].name;
              students[j - 1].name = temp1;

              temp2 = students[j].generation;
              students[j].generation = students[j - 1].generation;
              students[j - 1].generation = temp2;

              temp3 = students[j].department;
              students[j].department = students[j - 1].department;
              students[j - 1].department = temp3;
             }
            }
           }
           for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].id+"\t"+students[i].name+"\t"+students[i].department+"\t"+students[i].generation);
        }
    }
}
