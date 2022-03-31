package application;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hocin
 */
public class returnTable {
    private SimpleStringProperty id;
    private SimpleStringProperty mid;
    private SimpleStringProperty mname;
    private SimpleStringProperty bname;
    private SimpleStringProperty returndate;
    private SimpleStringProperty dayselip;
    private SimpleStringProperty fine;

    // String id,categoryname,status;
    public returnTable(String id, String mid, String mname, String bname, String returndate, String dayselip, String fine) {
        this.id = new SimpleStringProperty(id);
        this.mid = new SimpleStringProperty(mid);
        this.mname = new SimpleStringProperty(mname);
        this.bname = new SimpleStringProperty(bname);
        this.returndate = new SimpleStringProperty(returndate);
        this.dayselip = new SimpleStringProperty(dayselip);
        this.fine = new SimpleStringProperty(fine);
    }
    public String getId() {
        return id.get();
    }
    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }
    public String getmId() {
        return mid.get();
    }
    public void setmId(String mid) {
        this.mid = new SimpleStringProperty(mid);
    }
    public String getmname() {
        return mname.get();
    }
    public void setmname(String mname) {
        this.mname = new SimpleStringProperty(mname);
    }
    public String getBookName() {
        return bname.get();
    }
    public void setBook(String bname) {
        this.bname = new SimpleStringProperty(bname);
    }
    public String getreturnDate() {
        return returndate.get();
    }
    public void setreturnDate(String returndate) {
        this.returndate = new SimpleStringProperty(returndate);
    }
    public String getdaysElip() {
        return dayselip.get();
    }
    public void setdaysElip(SimpleStringProperty dayselip) {
        this.dayselip = dayselip;
    }
    public String getfine() {
        return fine.get();
    }
    public void setfine(SimpleStringProperty fine) {
        this.fine = fine;
    }
    public SimpleStringProperty idProperty(){return id;}
    public SimpleStringProperty midProperty(){return mid;}
    public SimpleStringProperty mnameProperty(){return mname;}
    public SimpleStringProperty bnameProperty(){return bname;}
    public SimpleStringProperty returndateProperty(){return returndate;}
    public SimpleStringProperty dayselipProperty(){return dayselip;}
    public SimpleStringProperty fineProperty(){return fine;}
}
