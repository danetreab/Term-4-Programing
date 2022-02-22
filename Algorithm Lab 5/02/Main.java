public class Main {
    public static void main(String[] args) {
        Human man = new Human();
        man.setName("Jonh");man.setAge(19);
        System.out.println(man.getName()+man.getAge());

        Student women = new Student();
        women.setName("Lee");women.setAge(18);women.setSchool("CADT");women.setId(001);women.setSkill("Computer-Scient");
        System.out.println(women.getName()+women.getAge()+women.getSchool()+women.getId()+women.getSkill());
    }
}
