    /*
    * To change this license header, choose License Headers in Project Properties.
    * To change this template file, choose Tools | Templates
    * and open the template in the editor.
    */


    package FlowerArrgAssg;
    import java.io.IOException;
    import java.util.Scanner;
    import java.util.List;
    import java.io.*;
    import java.text.DateFormat;
    import java.time.Instant;
    import java.util.ArrayList;
    import java.util.Date;
    import java.text.SimpleDateFormat;
    /**
    *
    * @author user
    */
    public class FlowerArrgAssg {

    /**
     * @param args the command line arguments
     */
    public static Double totalAmount=0.00;
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
                        case 2: System.out.println("\n\n==============================\n customized floral arrangement\n====================================");
                                    //customize style
                                    String ChosenStyle=CustomizedFlowerArrangementsStyle();
                                    CustomizedFlowerOrder.add(ChosenStyle);
                                   
                                    //customize size
                                    String ChosenFlowerSize=CustomizedFlowerSize();
                                    CustomizedFlowerOrder.add(ChosenFlowerSize);
                                    
                                    
                                    //customize flower
                                    ChosenFlower=CustomizedFlowerSelection();

                                    //customize Accessories
                                    ChosenAccessories=CustomizedAccessoriesSelection();
                               
//                                    Delivery priority
                                    String ChosenDeliveryPriority = CustomizedDeliveryPriority();
                                    CustomizedFlowerOrder.add(ChosenDeliveryPriority);
                             
                                    System.out.println("\nItemized bill for customized floral arrangement\n");
                                    System.out.printf("|%-40s :%-42s|\n","Flower Arrangement Style","Price");
                                    System.out.println("==========================================================================================");
                                    System.out.printf("|%-40s :RM %40s|\n",CustomizedFlowerOrder.get(0).substring(0, CustomizedFlowerOrder.get(0).indexOf("|")),CustomizedFlowerOrder.get(0).substring( CustomizedFlowerOrder.get(0).indexOf("|")+1, CustomizedFlowerOrder.get(0).length()));
                                    System.out.println("\n=======================================\nFlower Arrangement Size\n=======================================");
                                    System.out.printf("|%-40s :RM %40s|\n",CustomizedFlowerOrder.get(1).substring(0, CustomizedFlowerOrder.get(1).indexOf("|")),CustomizedFlowerOrder.get(1).substring( CustomizedFlowerOrder.get(1).indexOf("|")+1, CustomizedFlowerOrder.get(1).length()));
                                    System.out.println("\n=======================================\nSelected Flower\n=======================================");
                                    for(int i=0;i<ChosenFlower.size();i++)
                                    {
                                        
                                        System.out.printf("|%-40s :RM %40s|\n",ChosenFlower.get(i).substring(0, ChosenFlower.get(i).indexOf("|")),ChosenFlower.get(i).substring( ChosenFlower.get(i).indexOf("|")+1, ChosenFlower.get(i).length()));
                                    }
                                    System.out.println("\n=======================================\nSelected Accessories\n=======================================");
                                     for(int i=0;i<ChosenAccessories.size();i++)
                                    {
                                        
                                        System.out.printf("|%-40s :RM %40s|\n",ChosenAccessories.get(i).substring(0, ChosenAccessories.get(i).indexOf("|")),ChosenAccessories.get(i).substring( ChosenAccessories.get(i).indexOf("|")+1, ChosenAccessories.get(i).length()));
                                        
                                    }
                                    System.out.println("\n=======================================\nDelivery Priority\n=======================================");
                                    System.out.printf("|%-40s :RM %40s|\n",CustomizedFlowerOrder.get(2).substring(0, CustomizedFlowerOrder.get(2).indexOf("|")),CustomizedFlowerOrder.get(2).substring( CustomizedFlowerOrder.get(2).indexOf("|")+1, CustomizedFlowerOrder.get(2).length()));
                                    System.out.println("\n==========================================================================================");
                                    System.out.printf("|%-40s :RM %40s|\n","Total Amount",totalAmount);
                              
                                    
                                    
                                    
                                    
                                    File fileBill = new File("Bill(1).txt");
                                    FileWriter fileBillWrite = new FileWriter(fileBill.getName(),true);
                                    PrintWriter printBillWrite=new PrintWriter(fileBillWrite);
                                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                    Date date = new Date();
                                    
                                    printBillWrite.println("Date and Time :" + dateFormat.format(date));
                                    printBillWrite.println("\nItemized bill for customized floral arrangement\n");
                                    printBillWrite.printf("|%-40s :%-42s|\n","Flower Arrangement Style","Price");
                                    printBillWrite.println("\n");
                                    printBillWrite.println("\n==========================================================================================\n");
                                    printBillWrite.printf("|%-40s :RM %40s|\n",CustomizedFlowerOrder.get(0).substring(0, CustomizedFlowerOrder.get(0).indexOf("|")),CustomizedFlowerOrder.get(0).substring( CustomizedFlowerOrder.get(0).indexOf("|")+1, CustomizedFlowerOrder.get(0).length()));
                                    printBillWrite.println("\n");
                                    printBillWrite.println("=======================================");
                                    printBillWrite.println("Flower Arrangement Size");
                                    printBillWrite.println("=======================================");
                                    printBillWrite.println("\n");
                                    printBillWrite.printf("|%-40s :RM %40s|\n",CustomizedFlowerOrder.get(1).substring(0, CustomizedFlowerOrder.get(1).indexOf("|")),CustomizedFlowerOrder.get(1).substring( CustomizedFlowerOrder.get(1).indexOf("|")+1, CustomizedFlowerOrder.get(1).length()));
                                    printBillWrite.println("\n");
                                   
                                     printBillWrite.println("=======================================");
                                    printBillWrite.println("Selected Flower");
                                    printBillWrite.println("=======================================");
                                    for(int i=0;i<ChosenFlower.size();i++)
                                    {
                                        printBillWrite.println("\n");
                                        printBillWrite.printf("|%-40s :RM %40s|\n",ChosenFlower.get(i).substring(0, ChosenFlower.get(i).indexOf("|")),ChosenFlower.get(i).substring( ChosenFlower.get(i).indexOf("|")+1, ChosenFlower.get(i).length()));
                                        printBillWrite.println("\n");
                                    }
                                    
                                    printBillWrite.println("=======================================");
                                    printBillWrite.println("Selected Accessories");
                                    printBillWrite.println("=======================================");
                                     for(int i=0;i<ChosenAccessories.size();i++)
                                    {
                                        printBillWrite.println("\n");
                                        printBillWrite.printf("|%-40s :RM %40s|\n",ChosenAccessories.get(i).substring(0, ChosenAccessories.get(i).indexOf("|")),ChosenAccessories.get(i).substring( ChosenAccessories.get(i).indexOf("|")+1, ChosenAccessories.get(i).length()));
                                        printBillWrite.println("\n");
                                    }
                                    
                                    printBillWrite.println("=======================================");
                                    printBillWrite.println("Delivery Priority");
                                    printBillWrite.println("=======================================");
                                    printBillWrite.println("\n");
                                    printBillWrite.printf("|%-40s :RM %40s|\n",CustomizedFlowerOrder.get(2).substring(0, CustomizedFlowerOrder.get(2).indexOf("|")),CustomizedFlowerOrder.get(2).substring( CustomizedFlowerOrder.get(2).indexOf("|")+1, CustomizedFlowerOrder.get(2).length()));
                                    printBillWrite.println("\n");
                                    printBillWrite.println("\n==========================================================================================\n");
                                    printBillWrite.printf("|%-40s :RM %40s|\n","Total Amount",totalAmount);
                                    printBillWrite.println("\n");
                                    printBillWrite.flush();
                                    printBillWrite.close();
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
       
   public static String CustomizedDeliveryPriority() throws Exception
   {
        ArrayList<String> ArrayDeliveryPriority = new ArrayList<String>();
        ArrayList<Double> ArrayDeliveryPriorityPrice = new ArrayList<Double>();
        int CusDeliveryPrority;
        int i;
         Scanner UserInput=new Scanner(System.in);
        
       
    				
                        ArrayDeliveryPriority.add("express (highest priority)");
                        ArrayDeliveryPriorityPrice.add(15.00);
                        ArrayDeliveryPriority.add("normal");
                        ArrayDeliveryPriorityPrice.add(10.00);
                        ArrayDeliveryPriority.add("flexi (lowest priority)");
                        ArrayDeliveryPriorityPrice.add(5.00);
                     
    			
    					
    
        do{
            System.out.printf("\n\nStep 5------Delivery Prority Selection------\n");
            System.out.println("==========================================================================");
            System.out.printf("%-2s | %-30s | %-22s|\n","No","Priority","Price");
            System.out.println("==========================================================================");
            for(i=0;i<ArrayDeliveryPriority.size();i++){ 
            System.out.printf("%-2s | %-30s |RM %-20s|\n",i+1,ArrayDeliveryPriority.get(i),ArrayDeliveryPriorityPrice.get(i));
           
           
            }
    //        System.out.println("0.back");
            System.out.print("\nEnter a number to select : ");
             while(!UserInput.hasNextInt())
            {
                 System.out.printf("\ninput invalid(not a number),please enter a number :");
                 UserInput.next();
            }
            CusDeliveryPrority = UserInput.nextInt();
            if(CusDeliveryPrority<=0)
            {
                System.out.println("\nEnter positive number :");
            }
            else if(CusDeliveryPrority>i+1)
            {
                System.out.println("\nNumber that you enter out of range\n");
            }
        }while(CusDeliveryPrority<=0||CusDeliveryPrority>i+1);
        
        totalAmount+=ArrayDeliveryPriorityPrice.get(CusDeliveryPrority-1);
        return ArrayDeliveryPriority.get(CusDeliveryPrority-1) +"|"+ArrayDeliveryPriorityPrice.get(CusDeliveryPrority-1);
   }

    public static String CustomizedFlowerArrangementsStyle() throws Exception{
        ArrayList<String> ArrayStyle = new ArrayList<String>();
        ArrayList<Double> ArrayStylePrice = new ArrayList<Double>();
        int CusFlowerStyle;
        int i;
         Scanner UserInput=new Scanner(System.in);
        
        File CusFlowerArrangement= new File("flowerArrangement.txt");		
    	Scanner inputCusFlowerArrangement = new Scanner(CusFlowerArrangement);
    	
    	inputCusFlowerArrangement.useDelimiter(",");

        while(inputCusFlowerArrangement.hasNext()){
                        
    				
    			String ArrangementStyle=inputCusFlowerArrangement.next();
    			ArrayStyle.add(ArrangementStyle);
    			String ArrangementStylePrice =inputCusFlowerArrangement.next();
                        ArrayStylePrice.add(Double.parseDouble(ArrangementStylePrice));
    			String next = inputCusFlowerArrangement.nextLine();
    			
    					
    	}
        do{
            System.out.printf("\nStep 1------Flower Arrangement Style------\n");
            System.out.println("==========================================================================");
            System.out.printf("%-2s | %-40s | %-22s|\n","No","Arrangement Style","Price");
            System.out.println("==========================================================================");
            for(i=0;i<ArrayStyle.size();i++){
            System.out.printf("%-2s | %-40s |RM %-20s|\n",i+1,ArrayStyle.get(i),ArrayStylePrice.get(i));
           
           
            }
    //        System.out.println("0.back");
            System.out.print("\nEnter a number to select : ");
             while(!UserInput.hasNextInt())
            {
                 System.out.printf("\ninput invalid(not a number),please enter a number :");
                 UserInput.next();
            }
            CusFlowerStyle = UserInput.nextInt();
            if(CusFlowerStyle<=0)
            {
                System.out.println("\nEnter positive number\n");
            }
            else if(CusFlowerStyle>i)
            {
                System.out.println("\nNumber that you enter out of range\n");
            }
        }while(CusFlowerStyle<=0||CusFlowerStyle>i);
        
        totalAmount+=ArrayStylePrice.get(CusFlowerStyle-1);
        return ArrayStyle.get(CusFlowerStyle-1) +"|"+ ArrayStylePrice.get(CusFlowerStyle-1);
        
        


    }
    public static String CustomizedFlowerSize() throws Exception{
         ArrayList<String> ArrayFlowerSize = new ArrayList<String>();
         ArrayList<Double> ArrayFlowerSizePrice = new ArrayList<Double>();
        int CusFlowerSize,i;
         Scanner UserInput=new Scanner(System.in);
        
        File CusFlowerSizeFile= new File("flowerSize.txt");		
    	Scanner inputCusFlowerSize = new Scanner(CusFlowerSizeFile);
    	
    	inputCusFlowerSize.useDelimiter(",");
  
        while(inputCusFlowerSize.hasNext()){
                        
    				
    			String FlowerSize=inputCusFlowerSize.next();
    			ArrayFlowerSize.add(FlowerSize);
                        String FlowerSizePrice=inputCusFlowerSize.next();
    			ArrayFlowerSizePrice.add(Double.parseDouble(FlowerSizePrice));
    			
    			String next = inputCusFlowerSize.nextLine();
    			
    					
    	}
        do{
            System.out.println("\nStep 2------flower arrangement size-----\n");
            System.out.println("==========================================================================");
            System.out.printf("%-2s | %-40s | %-22s|\n","No","Arrangement Size","Price");
            System.out.println("==========================================================================");
            for(i=0;i<ArrayFlowerSize.size();i++){
             System.out.printf("%-2s | %-40s |RM %-20s|\n",i+1,ArrayFlowerSize.get(i),ArrayFlowerSizePrice.get(i));
             }
    //        System.out.println("0.back");
            System.out.print("\nEnter a number to select : ");
             while(!UserInput.hasNextInt())
            {
                 System.out.printf("\ninput invalid(not a number),please enter a number :");
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
        
        totalAmount+=ArrayFlowerSizePrice.get(CusFlowerSize-1);
        return ArrayFlowerSize.get(CusFlowerSize-1) +"|"+ ArrayFlowerSizePrice.get(CusFlowerSize-1);


    }
    public static ArrayList<String> CustomizedFlowerSelection() throws Exception{
        ArrayList<String> ArrayFlower = new ArrayList<String>();
        ArrayList<String> FlowerChosen = new ArrayList<String>();
        ArrayList<Integer> repeatChosen = new ArrayList<Integer>();
        ArrayList<Double> ArrayFlowerPrice = new ArrayList<Double>();
        int CusFlower = 0,AddOnFlower,count=0,i;
         Scanner UserInput=new Scanner(System.in);
       
        File CusFlowerFile= new File("flower.txt");		
    	Scanner inputCusFlower = new Scanner(CusFlowerFile);
    	
    	inputCusFlower.useDelimiter(",");
        
       
        
 
    	
        while(inputCusFlower.hasNext()){
                        
    				
    			String Flower=inputCusFlower.next();
    			ArrayFlower.add(Flower);
    			String FlowerPrice = inputCusFlower.next();
                        ArrayFlowerPrice.add(Double.parseDouble(FlowerPrice));
    			String next = inputCusFlower.nextLine();
    			
    					
    	}
        
       
        do{
        if(count<5){
            do{
        System.out.println("\n\nStep 3-----flower selection------\n");
        System.out.println("==========================================================================");
        System.out.printf("%-2s | %-40s | %-22s|\n","No","Flower Type","Price");
        System.out.println("==========================================================================");
        for(i=0;i<ArrayFlower.size();i++){
            System.out.printf("%-2s | %-40s |RM %-20s|\n",i+1,ArrayFlower.get(i),ArrayFlowerPrice.get(i));
        }

        System.out.print("\nEnter a number to select : ");
         while(!UserInput.hasNextInt())
            {
                 System.out.printf("\ninput invalid(not a number),please enter a number : ");
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
        
        totalAmount+=ArrayFlowerPrice.get(CusFlower-1);
        FlowerChosen.add(ArrayFlower.get(CusFlower-1) +"|"+ ArrayFlowerPrice.get(CusFlower-1));
        
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
            System.out.println("\nMaximum flower only 5!!!!!\n");
        }
       }while(AddOnFlower==1&&count<=5);
        return FlowerChosen;


    }
    public static ArrayList<String> CustomizedAccessoriesSelection()throws Exception{
        
        ArrayList<String> ArrayFlowerAccessories = new ArrayList<String>();
        ArrayList<String> AccessoriesChosen = new ArrayList<String>();
        ArrayList<Double> ArrayFlowerAccessoriesPrice = new ArrayList<Double>();
        int CusFlowerAccessories,AddOnAccessories,count=0,i;
         Scanner UserInput=new Scanner(System.in);
       
        File CusFlowerAccessoriesFile= new File("Accessories.txt");		
    	Scanner inputCusFlowerAccessories = new Scanner(CusFlowerAccessoriesFile);
    	
    	inputCusFlowerAccessories.useDelimiter(",");
        
       
 
    	
        while(inputCusFlowerAccessories.hasNext()){
                        
    				
    			String FlowerAccessories=inputCusFlowerAccessories.next();
    			ArrayFlowerAccessories.add(FlowerAccessories);
    			String FlowerAccessoriesPrice=inputCusFlowerAccessories.next();
                        ArrayFlowerAccessoriesPrice.add(Double.parseDouble(FlowerAccessoriesPrice));
    			String next = inputCusFlowerAccessories.nextLine();
    				
    	}
        do{
        if(count<3)
        {
         
        do{    
        System.out.println("\nStep 4-------Accessories selection-------\n");
        System.out.println("==========================================================================");
        System.out.printf("%-2s | %-40s | %-22s|\n","No","Flower Accessories","Price");
        System.out.println("==========================================================================");
        for(i=0;i<ArrayFlowerAccessories.size();i++){
        
        System.out.printf("%-2s | %-40s | %-22s|\n",i+1,ArrayFlowerAccessories.get(i),ArrayFlowerAccessoriesPrice.get(i));
        }
       
        
        System.out.print("\nEnter a number to select : ");
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
        
            totalAmount+=ArrayFlowerAccessoriesPrice.get(CusFlowerAccessories-1);
            AccessoriesChosen.add(ArrayFlowerAccessories.get(CusFlowerAccessories-1)+"|"+ArrayFlowerAccessoriesPrice.get(CusFlowerAccessories-1));
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
            System.out.println("\nMaximum flower accessories only 3!!!!!\n");
        }
        }while(AddOnAccessories==1&&count<=5);
        return AccessoriesChosen;
        
    

    }

    }
