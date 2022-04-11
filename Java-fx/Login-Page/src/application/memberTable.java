package application;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hocin
 */
public class memberTable {
    private SimpleStringProperty mid;
    private SimpleStringProperty name;
    private SimpleStringProperty address;
    private SimpleStringProperty phone;
    
    // String mid,categoryname,status;
    public memberTable(String mid, String name,String address,String phone) {
        this.mid = new SimpleStringProperty(mid);
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.phone = new SimpleStringProperty(phone);
    }
    public String getmid() {
        return mid.get();
    }
    public void setmid(String mid) {
        this.mid = new SimpleStringProperty(mid);
    }
    public String getcategoryname() {
        return name.get();
    }
    public void setname(String name) {
        this.name = new SimpleStringProperty(name);
    }
    public String getstatus() {
        return address.get();
    }
    public void setaddress(String address) {
        this.address = new SimpleStringProperty(address);
    }
    public String getPhone() {
        return phone.get();
    }
    public void setPhone(SimpleStringProperty phone) {
        this.phone = phone;
    }
    public SimpleStringProperty midProperty(){return mid;}
    public SimpleStringProperty nameProperty(){return name;}
    public SimpleStringProperty addressProperty(){return address;}
    public SimpleStringProperty phoneProperty(){return phone;}
    
}
