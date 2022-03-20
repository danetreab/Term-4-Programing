/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;


import com.mysql.cj.conf.StringProperty;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hocin
 */
public class categoryTable {
    private SimpleStringProperty id;
    private SimpleStringProperty categoryname;
    private SimpleStringProperty status;
    // String id,categoryname,status;
    public categoryTable(String id, String categoryname,String status) {
        this.id = new SimpleStringProperty(id);
        this.categoryname = new SimpleStringProperty(categoryname);
        this.status = new SimpleStringProperty(status);
    }
    public categoryTable(String id, String categoryname) {
        this.id = new SimpleStringProperty(id);
        this.categoryname = new SimpleStringProperty(categoryname);
    }
    public String getId() {
        return id.get();
    }
    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }
    public String getcategoryname() {
        return categoryname.get();
    }
    public void setcategoryname(String categoryname) {
        this.categoryname = new SimpleStringProperty(categoryname);
    }
    public String getstatus() {
        return status.get();
    }
    public void setstatus(String status) {
        this.status = new SimpleStringProperty(status);
    }
    public SimpleStringProperty idProperty(){return id;}
    public SimpleStringProperty categorynameProperty(){return categoryname;}
    public SimpleStringProperty statusProperty(){return status;}
    
}
