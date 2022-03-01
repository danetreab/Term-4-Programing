public class main {
    public static void main(String[] args) {
        DoAble man[] = new DoAble[10];
        for(int i=0;i<10;i++){
            man[i]=new Human("Man"+i, i+10, "Khmer"+i);
        }
        for(int i=0;i<10;i++){
            System.out.println(man[i]);
        }
    }
}
