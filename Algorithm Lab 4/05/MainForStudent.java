public class MainForStudent {
    public static void main(String[] args) {
        Student q =new Student();
        Student p =new Student("Rock","Jack","007");
        Student s =new Student("Tom","Jerry","B2222","Phnom Penh");
        q.firstname="Hi";
        q.lastname="Hello";
        q.address="Siem Reap";
        q.student_id="066";

        q.printInfo();
        p.printInfo();
        s.printInfo();
    }
}
