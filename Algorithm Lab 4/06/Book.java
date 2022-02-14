public class Book{
    public String title;
    public int ISBN;
    public String author;
    public String publishYear;
    public Book(){
        
    }
    public Book(String title){
        this.title=title;
    }
    public Book(String title,String author){
        this.title=title;
        this.author=author;
    }
    public Book(int ISBM,String title,String author){
        this.ISBN=ISBM;
        this.title=title;
        this.author=author;
    }
    public Book(int ISBM,String title,String author,String publishYear){
        this.title=title;
        this.ISBN=ISBM;
        this.author=author;
        this.publishYear=publishYear;
    }
    public void printInfo(){
        System.out.println("Title : "+title+"\nAuthor : "+author+"\nISBM : "+ISBN+"\nPublish-Year : "+publishYear);
    }
}
