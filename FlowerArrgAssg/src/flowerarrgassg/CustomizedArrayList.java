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
public class CustomizedArrayList<T extends Comparable<T>> implements CustomizedArrayListInterface<T> {
    private T[] array=(T[])new Comparable[DEFAULT_SIZE];
    private int numberofEntries=0;
    
    
    public void add(T item) {
        boolean full=isFull();
        if(full==true)
        {
            expandArray();
        }
        array[numberofEntries] = item;
        numberofEntries++;
        
    }


    public void add(T item, int index) {
        
        int start=index;
        boolean full=isFull();
        if(full==true)
        {
            expandArray();
        }
        //shift items to the right
        for(int i=numberofEntries;i>start;i--)
        {
            array[i]=array[i-1];//example,item of index 5 = item of index 4
        }
        
        array[index]=item;
        numberofEntries++;
        
        
    }

    public T get(int i) {
        T item = null;
        boolean empty=isEmpty();
        if(empty==false && i<numberofEntries)
        {
            item=array[i];
        }
        
        return item;
        
    }


    public int getNumberOfEntries() {
        
        return numberofEntries;
    }

    public boolean remove() {//remove the first item
        boolean success = false;
        boolean empty = isEmpty();
        if(empty==false)
        {
            for(int i=0;i<numberofEntries-1;i++)
            {
                array[i]=array[i+1];
                
            }
            numberofEntries--;
            success=true;
        }
        
        return success;
    }

   
    public boolean remove(int i) {
        
        boolean success=false;
        int start = i;
          boolean empty = isEmpty();
        if(empty==false && i < numberofEntries)
        {   
            makeRoom(start);
            numberofEntries--;
            success=true;
        }
        return success;
    }


    public boolean remove(T item) {
        
        boolean success = false;
         boolean empty = isEmpty();
         if(empty == false)
         {
             for(int i=0;i<numberofEntries;i++)
             {
                 if(item.compareTo(array[i])==0)
                 {
                     int start=i;
                      makeRoom(start);
                      numberofEntries--;
                      success=true;
                      break;
                 }
                
             }
             numberofEntries--;
             success=true;
         }
         return success;
    }
    
    private boolean isFull()
    {
        if(numberofEntries== array.length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

 
    public boolean isEmpty() {
        if(numberofEntries==0)
        {
           return true;
        }
        else
        {
            return false;
    }
    
    }

    private void expandArray() {
        T[] oldArray = array;
        int size=oldArray.length;
        array=(T[])new Comparable[size*2];
        
        for(int i=0;i<size;i++)
        {
            array[i]=oldArray[i];
        }
        
    }
    
    private void makeRoom(int start)
    {
           for(int i=start;i<numberofEntries-1;i++)
           {
               array[i]=array[i+1];
           }
    }
    
    public String toString()
    {
        String s= "";
        
        for(int i=0;i<numberofEntries;i++)
        {
            s+=array[i]+" ";
        }
        return s;
    }
    
}
