/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowerarrgassg;

/**
 *
 * @author Tarc
 */
public interface LinkedInterface<T> {
     
  public void addFront(T data);
  public void addRear(T data);
  public T removeFront();
  public T removeRear();
  public int size();
  public boolean isEmpty();
    
    
}
