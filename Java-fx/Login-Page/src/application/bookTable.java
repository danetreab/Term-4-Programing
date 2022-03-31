package application;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hocin
 */
public class bookTable {
    private SimpleStringProperty id;
    private SimpleStringProperty bookname;
    private SimpleStringProperty author;
    private SimpleStringProperty publisher;
    private SimpleStringProperty contents;
    private SimpleStringProperty pages;
    private SimpleStringProperty edition;
    
    public bookTable(String id, String bookname,String author,String publisher,String contents,String pages,String edition) {
        this.id = new SimpleStringProperty(id);
        this.bookname = new SimpleStringProperty(bookname);
        this.author = new SimpleStringProperty(author);
        this.publisher = new SimpleStringProperty(publisher);
        this.contents = new SimpleStringProperty(contents);
        this.pages = new SimpleStringProperty(pages);
        this.edition = new SimpleStringProperty(edition);
    }
    public String getId() {
        return id.get();
    }
    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }
    public String getbookname() {
        return bookname.get();
    }
    public void setbookname(String bookname) {
        this.bookname = new SimpleStringProperty(bookname);
    }
    public String getauthor() {
        return author.get();
    }
    public void setauthor(String author) {
        this.author = new SimpleStringProperty(author);
    }
    public String getpublisher() {
        return publisher.get();
    }
    public void setpublisher(String publisher) {
        this.publisher = new SimpleStringProperty(publisher);
    }
    public String getcontents() {
        return contents.get();
    }
    public void setcontents(String contents) {
        this.contents = new SimpleStringProperty(contents);
    }
    public String getpages() {
        return pages.get();
    }
    public void setpages(String pages) {
        this.pages = new SimpleStringProperty(pages);
    }
    public String getedition() {
        return edition.get();
    }
    public void setedition(String edition) {
        this.edition = new SimpleStringProperty(edition);
    }
    public SimpleStringProperty idProperty(){return id;}
    public SimpleStringProperty booknameProperty(){return bookname;}
    public SimpleStringProperty authorProperty(){return author;}
    public SimpleStringProperty publisherProperty(){return publisher;}
    public SimpleStringProperty contentsProperty(){return contents;}
    public SimpleStringProperty pagesProperty(){return pages;}
    public SimpleStringProperty editionProperty(){return edition;}
}
    