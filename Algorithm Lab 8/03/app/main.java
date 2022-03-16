package app;
public class main {
    public static void main(String[] args) {
        search a = new search();
        a.setValue();

        new search(0, 3333, "Thread1");
        new search(3334,6667,"Thread2");
        new search(6668,10000,"Thread3");
    }
}

