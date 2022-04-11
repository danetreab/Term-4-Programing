package application;

import javafx.beans.property.SimpleStringProperty;

public class issueTable {
    private SimpleStringProperty id;
    private SimpleStringProperty mid;
    private SimpleStringProperty name;
    private SimpleStringProperty bookname;
    private SimpleStringProperty issuedate;
    private SimpleStringProperty returndate;
    public issueTable(String id, String mid,String name, String bookname, String issuedate, String returndate) {
        this.id = new SimpleStringProperty(id);
        this.mid = new SimpleStringProperty(mid);
        this.name = new SimpleStringProperty(name);
        this.bookname = new SimpleStringProperty(bookname);
        this.issuedate = new SimpleStringProperty(issuedate);
        this.returndate = new SimpleStringProperty(returndate);
    }
    public String getid() {
        return id.get();
    }
    public void setid(String id) {
        this.id = new SimpleStringProperty(id);
    }
    public String getmid() {
        return mid.get();
    }
    public void setmid(String mid) {
        this.mid = new SimpleStringProperty(mid);
    }
    public String getname() {
        return name.get();
    }
    public void setname(String name) {
        this.name = new SimpleStringProperty(name);
    }
    public String getbookname() {
        return bookname.get();
    }
    public void setbookname(String bookname) {
        this.bookname = new SimpleStringProperty(bookname);
    }
    public String getissuedate() {
        return issuedate.get();
    }
    public void setissuedate(String issuedate) {
        this.issuedate = new SimpleStringProperty(issuedate);
    }
    public String getreturndate() {
        return returndate.get();
    }
    public void setreturndate(String returndate) {
        this.returndate = new SimpleStringProperty(returndate);
    }
    public SimpleStringProperty idProperty(){return id;}
    public SimpleStringProperty midProperty(){return mid;}
    public SimpleStringProperty nameProperty(){return name;}
    public SimpleStringProperty booknameProperty(){return bookname;}
    public SimpleStringProperty issuedateProperty(){return issuedate;}
    public SimpleStringProperty returndateProperty(){return returndate;}
}
