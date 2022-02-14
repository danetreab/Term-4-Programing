import java.util.Arrays;
import java.util.Scanner;

public class MainForBook {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        // books[0] = new Book(1,"A","Elon","2000");
        // books[1] = new Book(2,"F","Elon","2003");
        // books[2] = new Book(3,"C","Elon","2005");
        // books[3] = new Book(8,"D","Elon","2001");
        // books[4] = new Book(6,"E","Elon","2011");
        
        fillData(books);
        searchBookByTitle(books, "Good To ");
        searchBookByISBN(books,001);
        sortByISBN(books);
        System.out.println();
        sortByTitle(books);
        printAll(books);
    }
    public static void fillData(Book[] books) {
        Scanner Obj = new Scanner(System.in);
        for(int i=0;i<books.length;i++){    
            System.out.println(i+". Title ISBM Author Publish-Year");
            String title = Obj.nextLine();
            int ISBN = Integer.valueOf(Obj.nextLine());
            String author = Obj.nextLine();
            String publishYear = Obj.nextLine();
            books[i] = new Book(ISBN,title,author,publishYear);
        }
    }
    public static void printAll(Book[] books) {
        System.out.println("Title\tISBN\tAuthor\tPublish-Year");
        for(int i=0;i<books.length;i++){
            System.out.println(books[i].title+"\t"+books[i].ISBN+"\t"+books[i].author+"\t"+books[i].publishYear);
        }
    }
    public static void searchBookByTitle(Book[] books,String title) {
        int j=0;
        for(int i=0;i<books.length;i++){
            if((books[i].title).equals(title)){
                j=1;
            }
        }
        String Out = (j==1) ? ("The Book title \""+title+"\" Found") : ("The Book title \""+title+"\" not found");
        System.out.println(Out);
    }
    public static void searchBookByISBN(Book[] books,int ISBN) {
        int j=0;
        for(int i=0;i<books.length;i++){
            if(ISBN==(books[i].ISBN)){
                j=1;
            }
        }
        String Out = (j==1) ? ("The Book ISBN \""+ISBN+"\" Found") : ("The Book ISBN \""+ISBN+"\" not found");
        System.out.println(Out);
    }
    public static void sortByISBN(Book books[]) {
        int temp=0;
        String temp1,temp2,temp3;
        for (int i = 1; i < books.length; i++) {
            for (int j = i; j > 0; j--) {
             if (books[j].ISBN < books [j - 1].ISBN) {
              temp = books[j].ISBN;
              books[j].ISBN = books[j - 1].ISBN;
              books[j - 1].ISBN = temp;

              temp1 = books[j].title;
              books[j].title = books[j - 1].title;
              books[j - 1].title = temp1;

              temp2 = books[j].author;
              books[j].author = books[j - 1].author;
              books[j - 1].author = temp2;

              temp3 = books[j].publishYear;
              books[j].publishYear = books[j - 1].publishYear;
              books[j - 1].publishYear = temp3;
             }
            }
           }
           for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].title+"\t"+books[i].ISBN+"\t"+books[i].author+"\t"+books[i].publishYear);
        }
    }
    public static void sortByTitle(Book[] books) {
        for(int a = 0; a < 5 - 1; a++){
            for(int b = a + 1; b < books.length; b++){
                if((books[a].title).compareTo(books[b].title) > 0){
                    String temp = books[a].title;
                    books[a].title = books[b].title;
                    books[b].title = temp;

                    String temp1 = books[a].author;
                    books[a].author = books[b].author;
                    books[b].author = temp1;

                    int temp2 = books[a].ISBN;
                    books[a].ISBN = books[b].ISBN;
                    books[b].ISBN = temp2;

                    String temp3 = books[a].publishYear;
                    books[a].publishYear = books[b].publishYear;
                    books[b].publishYear = temp3;
                }
            }
        }
        for (int i = 0; i < books.length; i++){
        System.out.println(books[i].title+"\t"+books[i].ISBN+"\t"+books[i].author+"\t"+books[i].publishYear);
        }
    }
}