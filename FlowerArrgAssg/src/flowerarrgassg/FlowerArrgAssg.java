    /*
    * To change this license header, choose License Headers in Project Properties.
    * To change this template file, choose Tools | Templates
    * and open the template in the editor.
    */


    package flower.arrangement.assignment;
    import java.io.IOException;
    import java.util.Scanner;
    import java.util.List;
    import java.io.*;
    import java.util.ArrayList;
    
    /**
    *
    * @author user
    */
    public class FlowerArrangementAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Scanner UserInput=new Scanner(System.in);
        int loginInput;
        ArrayList<String> CustomizedFlowerOrder  = new ArrayList<String>();
        ArrayList<String> ChosenFlower = new ArrayList<String>();
         ArrayList<String> ChosenAccessories = new ArrayList<String>();
        do{
            do{
                
                login();
                while(!UserInput.hasNextInt())
                {
                     System.out.println("input invalid(not a number),please enter a number");
                     UserInput.next();
                }
                loginInput=UserInput.nextInt();
                if(loginInput<0)
                {
                    System.out.println("Enter positive number");
                }
            }while(loginInput<0);
            
        switch(loginInput){
            case 1: System.out.println("Staff only");
                    int StaffInput;
                    do{
                        do{
                            StaffMenu();
                            while(!UserInput.hasNextInt())
                             {
                                System.out.println("input invalid(not a number),please enter a number");
                                UserInput.next();
                             }
                            StaffInput = UserInput.nextInt();
                            if(StaffInput <0)
                            {
                                System.out.println("Enter positive number");
                            }
                        }while(StaffInput<0);
                    }while(StaffInput!=0);
                    break;
            case 2: System.out.println("customer only");

                    int ConsumerInput,CusAccessories;
                    do{
                        do{
                            ConsumerMenu();
                          while(!UserInput.hasNextInt())
                            {
                                 System.out.println("input invalid(not a number),please enter a number");
                                 UserInput.next();
                            }
                            ConsumerInput = UserInput.nextInt();
                            if(ConsumerInput <0)
                            {
                                System.out.println("Enter positive number");
                            }
                        }while(ConsumerInput<0);
                    switch(ConsumerInput){
                        case 1: System.out.println("Catalog order");

                                break;
                        case 2: System.out.println("customized floral arrangement");
                                    String ChosenStyle=CustomizedFlowerArrangementsStyle();
                                    CustomizedFlowerOrder.add(ChosenStyle);
                                   
                                    for(int i=0;i<CustomizedFlowerOrder.size();i++)
                                    { 
                                        System.out.println(CustomizedFlowerOrder.get(i));
                                    }
                                    
                                    String ChosenFlowerSize=CustomizedFlowerSize();
                                    CustomizedFlowerOrder.add(ChosenFlowerSize);
                                    for(int i=0;i<CustomizedFlowerOrder.size();i++)
                                    {
                                        System.out.println(CustomizedFlowerOrder.get(i));
                                    }
                                    
                                    ChosenFlower=CustomizedFlowerSelection();
                                     for(int i=0;i<ChosenFlower.size();i++)
                                    {
                                  
                                        CustomizedFlowerOrder.add(ChosenFlower.get(i)); 
                                     
                                    }
                                     for(int i=0;i<CustomizedFlowerOrder.size();i++)
                                    {
                                        System.out.println(CustomizedFlowerOrder.get(i));
                                    }
                                    
                                    ChosenAccessories=CustomizedAccessoriesSelection();
                                     for(int i=0;i<ChosenAccessories.size();i++)
                                    {
                                  
                                        CustomizedFlowerOrder.add(ChosenAccessories.get(i)); 
                                     
                                    }
                                     for(int i=0;i<CustomizedFlowerOrder.size();i++)
                                    {
                                        System.out.println(CustomizedFlowerOrder.get(i));
                                    }
                                  
                                   break;
                    }
                    }while(ConsumerInput!=0);
                    break;
            case 3: System.out.println("Register only");

                    break;
        }

        }while(loginInput!=0); 

    }
     public static void login()
    {

        System.out.println("=====\nLogin\n=====");
        System.out.println("1.Staff");
        System.out.println("2.customer");
        System.out.println("3.Register");
        System.out.println("0.Exit");
        System.out.print("Enter a number to select :");


    }
    public static void StaffMenu(){
        System.out.println("====\nStaff Menu\n====");
        System.out.println("1.Catalog Maintenance");
        System.out.println("2.Customer Maintenance and invoice payment");
        System.out.println("3.Order pickup and consumer payment management");
        System.out.println("0.back");
        System.out.print("Enter a number to select : ");


    }
       public static void ConsumerMenu(){
        System.out.println("====\nCunsumer menu\n====");
        System.out.println("1.Catalog Orders");
        System.out.println("2.Customized Floral Arrangements");
        System.out.println("0.back");
        System.out.print("Enter a number to select : ");


    }

    public static String CustomizedFlowerArrangementsStyle() throws Exception{
        ArrayList<String> ArrayStyle = new ArrayList<String>();
        int CusFlowerStyle;
        int i;
         Scanner UserInput=new Scanner(System.in);
        
        File CusFlowerArrangement= new File("flowerArrangement.txt");		
    	Scanner inputCusFlowerArrangement = new Scanner(CusFlowerArrangement);
    	
    	inputCusFlowerArrangement.useDelimiter(",");

        while(inputCusFlowerArrangement.hasNext()){
                        
    				
    			String ArrangementStyle=inputCusFlowerArrangement.next();
    			ArrayStyle.add(ArrangementStyle);
    			
    			String next = inputCusFlowerArrangement.nextLine();
    			
    					
    	}
        do{
            System.out.printf("Step 1------Flower Arrangement Style------\n");
            System.out.println("==========================================================================");
            for(i=0;i<ArrayStyle.size();i++){
            System.out.println(i+1+"."+ArrayStyle.get(i));
           
           
            }
    //        System.out.println("0.back");
            System.out.print("Enter a number to select : ");
             while(!UserInput.hasNextInt())
            {
                 System.out.println("\ninput invalid(not a number),please enter a number\n");
                 UserInput.next();
            }
            CusFlowerStyle = UserInput.nextInt();
            if(CusFlowerStyle<=0)
            {
                System.out.println("\nEnter positive number\n");
            }
            else if(CusFlowerStyle>i+1)
            {
                System.out.println("\nNumber that you enter out of range\n");
            }
        }while(CusFlowerStyle<=0||CusFlowerStyle>i+1);
        
        
        return ArrayStyle.get(CusFlowerStyle-1);
        
        


    }
    public static String CustomizedFlowerSize() throws Exception{
         ArrayList<String> ArrayFlowerSize = new ArrayList<String>();
        int CusFlowerSize,i;
         Scanner UserInput=new Scanner(System.in);
        
        File CusFlowerSizeFile= new File("flowerSize.txt");		
    	Scanner inputCusFlowerSize = new Scanner(CusFlowerSizeFile);
    	
    	inputCusFlowerSize.useDelimiter(",");
  
        while(inputCusFlowerSize.hasNext()){
                        
    				
    			String FlowerSize=inputCusFlowerSize.next();
    			ArrayFlowerSize.add(FlowerSize);
    			
    			String next = inputCusFlowerSize.nextLine();
    			
    					
    	}
        do{
            System.out.println("Step 2------flower arrangement size-----\n");
            for(i=0;i<ArrayFlowerSize.size();i++){
             System.out.println(i+1+"."+ArrayFlowerSize.get(i));
             }
    //        System.out.println("0.back");
            System.out.print("Enter a number to select : ");
             while(!UserInput.hasNextInt())
            {
                 System.out.println("\ninput invalid(not a number),please enter a number\n");
                 UserInput.next();
            }
            CusFlowerSize = UserInput.nextInt();
            if(CusFlowerSize<=0)
            {
                System.out.println("\nEnter positive number\n");
            }
            else if(CusFlowerSize>i+1)
            {
                System.out.println("\nNumber that you enter out of range\n");
            }
                    
        }while(CusFlowerSize<=0||CusFlowerSize>i+1);
        
   
        return ArrayFlowerSize.get(CusFlowerSize-1);


    }
    public static ArrayList<String> CustomizedFlowerSelection() throws Exception{
        ArrayList<String> ArrayFlower = new ArrayList<String>();
        ArrayList<String> FlowerChosen = new ArrayList<String>();
        ArrayList<Integer> repeatChosen = new ArrayList<Integer>();
        int CusFlower = 0,AddOnFlower,count=0,i;
         Scanner UserInput=new Scanner(System.in);
       
        File CusFlowerFile= new File("flower.txt");		
    	Scanner inputCusFlower = new Scanner(CusFlowerFile);
    	
    	inputCusFlower.useDelimiter(",");
        
       
        
 
    	
        while(inputCusFlower.hasNext()){
                        
    				
    			String Flower=inputCusFlower.next();
    			ArrayFlower.add(Flower);
    			
    			String next = inputCusFlower.nextLine();
    			
    					
    	}
        
       
        do{
        if(count<5){
            do{
        System.out.println("Step 3-----flower selection------\n");
        for(i=0;i<ArrayFlower.size();i++){
            System.out.println(i+1+"."+ArrayFlower.get(i));
        }

        System.out.print("Enter a number to select : ");
         while(!UserInput.hasNextInt())
            {
                 System.out.println("\ninput invalid(not a number),please enter a number\n");
                 UserInput.next();
            }
        
        CusFlower = UserInput.nextInt();
         if(CusFlower<=0)
            {
                System.out.println("\nEnter positive number\n");
            }
            else if(CusFlower>i+1)
            {
                System.out.println("\nNumber that you enter out of range\n");
            }
         }while(CusFlower<=0||CusFlower>i+1);
        repeatChosen.add(CusFlower-1);
        
        FlowerChosen.add(ArrayFlower.get(CusFlower-1));
        System.out.println("1.add on flower");
        }
        do{
        System.out.println("any number to next");
        System.out.print("Enter a number to select : ");
          while(!UserInput.hasNextInt())
            {
                 System.out.println("\ninput invalid(not a number),please enter a number\n");
                 UserInput.next();
            }
        AddOnFlower= UserInput.nextInt();
        if(AddOnFlower<=0)
            {
                System.out.println("\nEnter positive number\n");
                System.out.println("1.add on flower");
            }
          
         }while(AddOnFlower<=0);
        count++;
        if(count==5)
        {
            System.out.println("Maximum flower only 5!!!!!\n");
        }
       }while(AddOnFlower==1&&count<=5);
        return FlowerChosen;


    }
    public static ArrayList<String> CustomizedAccessoriesSelection()throws Exception{
        
        ArrayList<String> ArrayFlowerAccessories = new ArrayList<String>();
        ArrayList<String> AccessoriesChosen = new ArrayList<String>();
        int CusFlowerAccessories,AddOnAccessories,count=0,i;
         Scanner UserInput=new Scanner(System.in);
       
        File CusFlowerAccessoriesFile= new File("Accessories.txt");		
    	Scanner inputCusFlowerAccessories = new Scanner(CusFlowerAccessoriesFile);
    	
    	inputCusFlowerAccessories.useDelimiter(",");
        
       
 
    	
        while(inputCusFlowerAccessories.hasNext()){
                        
    				
    			String FlowerAccessories=inputCusFlowerAccessories.next();
    			ArrayFlowerAccessories.add(FlowerAccessories);
    			
    			String next = inputCusFlowerAccessories.nextLine();
    				
    	}
        do{
        if(count<3)
        {
         
        do{    
        System.out.println("Step 4-------Accessories selection-------\n");    
        for(i=0;i<ArrayFlowerAccessories.size();i++){
        
        System.out.println(i+1+"."+ArrayFlowerAccessories.get(i));
        }
       
        
        System.out.print("Enter a number to select : ");
        while(!UserInput.hasNextInt())
            {
                 System.out.println("\ninput invalid(not a number),please enter a number\n");
                 UserInput.next();
            }
        CusFlowerAccessories = UserInput.nextInt();
         if(CusFlowerAccessories<=0)
            {
                System.out.println("\nEnter positive number\n");
            }
            else if(CusFlowerAccessories>i+1)
            {
                System.out.println("\nNumber that you enter out of range\n");
            }
         }while(CusFlowerAccessories<=0||CusFlowerAccessories>i+1);
            AccessoriesChosen.add(ArrayFlowerAccessories.get(CusFlowerAccessories-1));
            System.out.println("1.add on flower Accessories");
        }
        do{
        System.out.println("any number to next");
        System.out.print("Enter a number to select : ");
         while(!UserInput.hasNextInt())
            {
                 System.out.println("\ninput invalid(not a number),please enter a number\n");
                 UserInput.next();
            }
        AddOnAccessories=UserInput.nextInt();
         if(AddOnAccessories<=0)
            {
                System.out.println("\nEnter positive number\n");
                System.out.println("1.add on flower Accessories");
                
            }
          
         }while(AddOnAccessories<=0);
        count++;
         if(count==3)
        {
            System.out.println("Maximum flower accessories only 3!!!!!\n");
        }
        }while(AddOnAccessories==1&&count<=5);
        return AccessoriesChosen;
        
    

    }

    }
