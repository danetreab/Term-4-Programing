public class main {
    public static void main(String[] args) {
        Human s = new Student("Jonh", 15, "KH","CADT","CS");
        Human t = new Teacher("Jake", 60, "HG",1500,"TN");

        System.out.println(s.getName()+" is "+s.getAge()+" year old and reponsible for "+s.getResponsible()+" is the student of "+s);
        System.out.println(t.getName()+" is "+t.getAge()+" year old and reponsible for "+t.getResponsible()+" is the teacher of "+t);
        
    }
}

