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
public interface CustomizedArrayListInterface<T> {
    public static final int DEFAULT_SIZE=5;
    
    void add(T item);
    void add(T item,int index);
    T get(int i);
    int getNumberOfEntries();
    boolean remove();//remove the first item
    boolean remove(int i);
    boolean remove(T item);
    boolean isEmpty();
}
