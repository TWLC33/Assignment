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
public interface CatalogInterface {
    public void setID(int id);
    int getID();
    public void setName(String name);
    String getName();
    public void setType(String type);
    String getType();
    public void setDesc(String desc);
    String getDesc();
    public void setPrice(double price);
    double getPrice();
    public void setQty(int qty);
    int getQty();
}
