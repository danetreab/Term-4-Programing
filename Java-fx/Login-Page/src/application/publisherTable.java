package application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class publisherTable {

    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty address;
    private final StringProperty phone;

    public publisherTable()
    {
        this.id = new SimpleStringProperty(this, "id");
        this.name = new SimpleStringProperty(this, "name");
        this.address = new SimpleStringProperty(this, "address");
        this.phone = new SimpleStringProperty(this, "phone");
    }

    public StringProperty idProperty() { return id; }
    public String getId() { return id.get(); }
    public void setId(String newId) { id.set(newId); }

    public StringProperty nameProperty() { return name; }
    public String getName() { return name.get(); }
    public void setName(String newName) { name.set(newName); }

    public StringProperty addressProperty() { return address; }
    public String getAddress() { return address.get(); }
    public void setAddress(String newAddress) { address.set(newAddress); }

    public StringProperty phoneProperty() { return phone; }
    public String getphone() { return phone.get(); }
    public void setphone(String newphone) { phone.set(newphone); }

}
