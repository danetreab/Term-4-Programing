public class MainForBook {
    public static void main(String[] args) {
        Book b = new Book("Good To Great","Elon-Musk","123B");
        System.out.println("Book title : "+ b.getTitle()+"\nAuthor : "+b.author+"\nISBN : "+b.isbn);
    }
}
