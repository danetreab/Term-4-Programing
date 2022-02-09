class ex14 {
    public static void main(String[] args) {
        // helloWhileLoop();
        helloForDoWhile();
    }
    public static void helloForLoop() {
        for(int i=0;i<10;i++){
            System.out.println("helloForLoop");
        }
    }
    public static void helloWhileLoop() {
        int i=0;
        while(i<10){
            System.out.println("helloWhileLoop");
            i++;
        }
    }
    public static void helloForDoWhile() {
        int i=0;
        do{
            System.out.println("helloForDoWhile");
            i++;
        }while(i<10);
    }
}


