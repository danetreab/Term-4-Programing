public class Book {
    private String title;
    public String author;
    public String isbn;
    public Book() {
        
    }
    public Book(String title) {
        this.title=title;
    }
    public Book(String title,String author,String isbn) {
        this.title=title;
        this.author=author;
        this.isbn=isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
}
