package flowerarrgassg;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tarc
 */
public interface ListInterface<D> {
    public static final int DEFAULT_SIZE=5;
    
    void add(D item);
    void add(D item,int index);
    D get(int i);
    int getNumberOfEntries();
    boolean remove();//remove the first item
    boolean remove(int i);
    boolean remove(D item);
    boolean isEmpty();
}
