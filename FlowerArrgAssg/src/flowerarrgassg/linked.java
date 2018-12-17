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
public class linked<T> implements LinkedInterface<T>{
    Node lastNode;
     int numOfItem = 0;
    public void addFront(T data)
    {
        Node newNode = new Node(data);
        if(isEmpty()){
            lastNode = newNode;
            lastNode.next = newNode;
            
        }
        else{
             newNode.next = lastNode.next;
            lastNode.next = newNode;
           
            
            
            
        
        }
       numOfItem++;
       
    };
    
    public void addRear(T data)
    {
         Node newNode = new Node(data);
        if(isEmpty()){
            lastNode = newNode;
            lastNode.next = newNode;
        }
        else{
            newNode.next = lastNode.next;
            lastNode.next = newNode;
            lastNode = newNode;
        }
        numOfItem++;
    };
    
    public T removeFront()
    {
         T item = null;
        if(!isEmpty()){
            if(lastNode.next == lastNode){//contain only 1 node
                item = lastNode.data;
                lastNode = null;
            }
            else{//contain more than 1 node
                item = lastNode.next.data;
                lastNode.next = lastNode.next.next;
            }
        }
         numOfItem--;
        return item;
       
    }
    
    public T removeRear()
    {
          T item = null;
          Node currentNode = lastNode.next;
          item = lastNode.data;
        if(!isEmpty()){
            if(lastNode.next == lastNode){//contain only 1 node
                
                lastNode = null;
            }
            else{//contain more than 1 node
                for(int i=0; i<numOfItem;i++){
                    if(currentNode.next != lastNode){
                        currentNode = currentNode.next;
                    }
                    else{
                        currentNode.next = lastNode.next;
                        lastNode = currentNode;
                    }
                }            
                
            }
        }
         numOfItem--;
        return item;
        
    }
    
    public int size()
    {
       return numOfItem;
    }
     public String toString(){
        Node current = lastNode.next;
        String s = current.data.toString()+"\n";
        for(int i=0; i<numOfItem-1;i++){
            current=current.next;
            s+=current.data+"\n";
        }
        
        return s;
    }
    
   
    public boolean isEmpty(){
          if(lastNode == null)
            return true;
        else
            return false;
    };
    
     public class Node{
        private T data;
        private Node next;
        
        public Node(T data){
            this.data = data;
        }
        
    }
}
