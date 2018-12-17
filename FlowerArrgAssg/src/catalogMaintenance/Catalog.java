/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogMaintenance;

/**
 *
 * @author user
 */
public class Catalog implements CatalogInterface{
    private int id, qty;
    private double price;
    private String name, type, desc;

    Catalog(int id, String name, String type, String desc, double price, int qty) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.price = price;
        this.qty = qty;
    }
    
    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public int getQty() {
        return qty;
    }
}
