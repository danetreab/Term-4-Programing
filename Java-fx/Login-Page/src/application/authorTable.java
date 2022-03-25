package application;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hocin
 */
public class authorTable {
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty address;
    private SimpleStringProperty phone;
    
    public authorTable(String id, String name,String address,String phone) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.phone = new SimpleStringProperty(phone);
    }
    public String getId() {
        return id.get();
    }
    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
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
    public SimpleStringProperty idProperty(){return id;}
    public SimpleStringProperty nameProperty(){return name;}
    public SimpleStringProperty addressProperty(){return address;}
    public SimpleStringProperty phoneProperty(){return phone;}
    
}