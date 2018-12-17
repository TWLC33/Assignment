    /*
    * To change this license header, choose License Headers in Project Properties.
    * To change this template file, choose Tools | Templates
    * and open the template in the editor.
    */


    package flowerarrgassg;
    import java.io.IOException;
    import java.util.Scanner; 
    import java.io.*;
    import java.text.DateFormat;
    import java.time.Instant;
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
    private static Double totalAmount=0.00;
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static DateFormat dateFormatDeliveryPriority = new SimpleDateFormat("yyyy/MM/dd");
    private static Date date = new Date();
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        ListInterface<String> CustomizedFlowerOrder = new ArrayList1();
        ListInterface<String> ChosenFlower = new ArrayList1();
        ListInterface<String> ChosenAccessories = new ArrayList1();
        ListInterface<String> DeliveryOrderExpress = new ArrayList1();
        ListInterface<String> DeliveryOrderNormal = new ArrayList1();
        ListInterface<String> DeliveryOrderFlexi = new ArrayList1();
        LinkedInterface<String> DeliveryPriorityList = new linked();
        Scanner UserInput=new Scanner(System.in);
        int loginInput = 0;
       
        
        do{
            do{
                
                login();
                loginInput=validate(UserInput, loginInput);
            }while(loginInput<0);
            
        switch(loginInput){
            case 1: System.out.println("Staff only");
                    int StaffInput = 0;
                    do{
                        do{
                            StaffMenu();
                            StaffInput = validate(UserInput, StaffInput);
                        }while(StaffInput<0);
                         switch(StaffInput){
                            case 1: catalogMaintenance.CatalogMaintenance.CatalogMaintenanceMain();
                            break;
                            
                            case 2: Menu.Menu.Consumer();
                            break;
                            
                            case 3: invoice.Invoice.Invoice();
                            break;
                        }
                    }while(StaffInput!=0);
                    break;
            case 2: System.out.println("customer only");

                    int ConsumerInput = 0;
                    do{
                        do{
                            ConsumerMenu();
                            ConsumerInput = validate(UserInput, ConsumerInput);
                        }while(ConsumerInput<0);
                       
                    switch(ConsumerInput){
                        case 1: System.out.println("Catalog order");
                                        CatalogOrder.Prototype.CatalogOrder();
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
                                    System.out.print("Enter 1 to complete, any number to abandon :");
                                    ConsumerInput = validate(UserInput, ConsumerInput);
                                    
                                   if(ConsumerInput==1){
                                       
                                      File FileCusDeliveryPriority= new File("DeliveryPriority.txt");		
                                       Scanner inputCusDeliveryPriority = new Scanner(FileCusDeliveryPriority);
    	
                                       inputCusDeliveryPriority.useDelimiter(",");

                                      while(inputCusDeliveryPriority.hasNext()){
                        
    				
                                       String CustomerName=inputCusDeliveryPriority.next();
                                       String DeliveryPriority =inputCusDeliveryPriority.next();
                                       String OrderDate = inputCusDeliveryPriority.next();
                                       if(DeliveryPriority.compareTo("express (highest priority)")==0)
                                       {
                                           DeliveryOrderExpress.add(CustomerName+","+DeliveryPriority+","+OrderDate+",");
                                       }else if(DeliveryPriority.compareTo("normal")==0)
                                       {
                                           DeliveryOrderNormal.add(CustomerName+","+DeliveryPriority+","+OrderDate+",");
                                       }else
                                       {
                                           DeliveryOrderFlexi.add(CustomerName+","+DeliveryPriority+","+OrderDate+",");
                                       }
                                       String next = inputCusDeliveryPriority.nextLine();
    			
    					
                                      }
                                      if(CustomizedFlowerOrder.get(2).substring(0, CustomizedFlowerOrder.get(2).indexOf("|")).compareTo("express (highest priority)")==0)
                                      {
                                          DeliveryOrderExpress.add("Tam Yew Wah"+","+"express (highest priority)"+","+dateFormatDeliveryPriority.format(date)+",");
                                         
                                      }
                                      else if(CustomizedFlowerOrder.get(2).substring(0, CustomizedFlowerOrder.get(2).indexOf("|")).compareTo("normal")==0)
                                      {
                                          DeliveryOrderNormal.add("Liew Yih Chan"+","+"normal"+","+dateFormatDeliveryPriority.format(date)+",");
                                      }
                                      else
                                      {
                                          DeliveryOrderFlexi.add("Wai Zhen Hao"+","+"flexi (lowest priority)"+","+dateFormatDeliveryPriority.format(date)+",");
                                      }
                                      PrintWriter Write=new PrintWriter(FileCusDeliveryPriority);
                                      Write.print("");
                                      Write.flush();
                                      Write.close();
                                      FileWriter fileDeliveryPriorityWrite = new FileWriter(FileCusDeliveryPriority.getName(),true);
                                       PrintWriter printDeliveryPriorityWrite=new PrintWriter(fileDeliveryPriorityWrite);
                                       for(int i=0;i<DeliveryOrderExpress.size();i++)
                                       {
                                           DeliveryPriorityList.addRear(DeliveryOrderExpress.get(i));
                                           
                                       }
                                       for(int i=0;i<DeliveryOrderNormal.size();i++)
                                       {
                                       DeliveryPriorityList.addRear(DeliveryOrderNormal.get(i));
                                       }
                                        for(int i=0;i<DeliveryOrderFlexi.size();i++)
                                       {
                                       DeliveryPriorityList.addRear(DeliveryOrderFlexi.get(i));
                                       }
                                        while(!DeliveryPriorityList.isEmpty())
                                        {
                                       printDeliveryPriorityWrite.println(DeliveryPriorityList.removeFront());
                                        }
                                      
                                    printDeliveryPriorityWrite.flush();
                                    printDeliveryPriorityWrite.close();
                                    CustomizedBill(CustomizedFlowerOrder, ChosenFlower, ChosenAccessories);
                                    generateCustomizedBill(CustomizedFlowerOrder, ChosenFlower, ChosenAccessories);
                                    
                                   }
                                   else
                                   {
                                       System.out.println("You have been abandon your customized flower order!!!");
                                   };
                                   totalAmount=0.00;
                                    CustomizedFlowerOrder.remove();
                                   DeliveryOrderExpress.remove();
                                   DeliveryOrderNormal.remove();
                                   DeliveryOrderFlexi.remove();
                                    ChosenFlower.remove();
                                    ChosenAccessories.remove();
                                   break;
                    }
                    }while(ConsumerInput!=0);
                    break;
            case 3: System.out.println("Register only");

                    break;
        }

        }while(loginInput!=0); 

    }

    public static int validate(Scanner UserInput, int loginInput) {
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
        
        return loginInput;
    }

    private static void generateCustomizedBill(ListInterface<String> CustomizedFlowerOrder, ListInterface<String> ChosenFlower, ListInterface<String> ChosenAccessories) throws IOException {
        File fileBill = new File("Tam Yew Wah.txt");
        FileWriter fileBillWrite = new FileWriter(fileBill.getName(),true);
        PrintWriter printBillWrite=new PrintWriter(fileBillWrite);
        
        printBillWrite.println("Customer Name : Tam Yew Wah");
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
        return;
    }

    private static void CustomizedBill(ListInterface<String> CustomizedFlowerOrder, ListInterface<String> ChosenFlower, ListInterface<String> ChosenAccessories) {
        
        System.out.println("Customer Name : Tam Yew Wah");
        System.out.println("Date and Time :" + dateFormat.format(date));
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
        System.out.println("2.Customer Maintenance");
        System.out.println("3.Invoice payment");
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
        ListInterface<String> ArrayDeliveryPriority = new ArrayList1();
        ListInterface<Double> ArrayDeliveryPriorityPrice = new ArrayList1();
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
        ListInterface<String> ArrayStyle = new ArrayList1();
        ListInterface<Double> ArrayStylePrice = new ArrayList1();
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
         ListInterface<String> ArrayFlowerSize = new ArrayList1();
         ListInterface<Double> ArrayFlowerSizePrice = new ArrayList1();
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
    public static ListInterface<String> CustomizedFlowerSelection() throws Exception{
        ListInterface<String> ArrayFlower = new ArrayList1();
        ListInterface<String> FlowerChosen = new ArrayList1();
        ListInterface<Double> ArrayFlowerPrice = new ArrayList1();
        int CusFlower = 0,AddOnFlower,count=0,i,FlowerRemove=0;
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
            else if(CusFlower>=i+1)
            {
                System.out.println("\nNumber that you enter out of range\n");
            }
         }while(CusFlower<=0||CusFlower>=i+1);
        
      
            totalAmount+=ArrayFlowerPrice.get(CusFlower-1);
            FlowerChosen.add(ArrayFlower.get(CusFlower-1) +"|"+ ArrayFlowerPrice.get(CusFlower-1));
        
        System.out.println("1.add on flower");
        System.out.println("2.Remove flower");
        count++;
        }
        do{
        System.out.println("any number to next(except 1 and 2)");
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
                System.out.println("2.Remove flower");
            }
          
         }while(AddOnFlower<=0);
       
        
       
        
        if(AddOnFlower==2)
        {
            do{
             do{
        System.out.println("\n\n-----Remove Selected flower------\n");
        System.out.println("-----Remaining flower------\n");
        System.out.println("==========================================================================");
        System.out.printf("%-2s | %-40s | %-22s|\n","No","Flower Type","Price");
        System.out.println("==========================================================================");
        for(i=0;i<FlowerChosen.size();i++){
            
            System.out.printf("%-2s | %-40s |RM %-20s|\n",i+1,FlowerChosen.get(i).substring(0, FlowerChosen.get(i).indexOf("|")),FlowerChosen.get(i).substring( FlowerChosen.get(i).indexOf("|")+1, FlowerChosen.get(i).length()));
        }
         
        System.out.println("enter 0 to quit");
         System.out.println("enter -1 to next step");
        System.out.print("Enter a number to remove : ");
          while(!UserInput.hasNextInt())
            {
                 System.out.println("\ninput invalid(not a number),please enter a number\n");
                 UserInput.next();
            }
        FlowerRemove= UserInput.nextInt();
        if(FlowerRemove<-1)
            {
                System.out.println("\nEnter positive number\n");
               
            }
        else if(FlowerRemove>i+1)
        {
            System.out.println("\nNumber that you enter out of range\n");
        }
          
         }while(FlowerRemove<-1||FlowerRemove>i+1);
             if(FlowerRemove>0&&FlowerRemove<=FlowerChosen.size())
             {
                 
                count--;
                totalAmount-=Double.parseDouble(FlowerChosen.get(FlowerRemove-1).substring( FlowerChosen.get(FlowerRemove-1).indexOf("|")+1, FlowerChosen.get(FlowerRemove-1).length()));
                FlowerChosen.remove(FlowerRemove-1);
             }
            }while(FlowerRemove>0&&FlowerRemove<=FlowerChosen.size()+1&&!FlowerChosen.isEmpty());
        }
        
        if(count==5)
        {
            System.out.println("\nMaximum flower only 5!!!!!\n");
        }
       }while(AddOnFlower>0&&AddOnFlower<3&&FlowerRemove>-1&&count>-1&&count<6);
        
        return FlowerChosen;


    }
    public static ListInterface<String> CustomizedAccessoriesSelection()throws Exception{
        
        ListInterface<String> ArrayFlowerAccessories = new ArrayList1();
        ListInterface<String> AccessoriesChosen = new ArrayList1();
        ListInterface<Double> ArrayFlowerAccessoriesPrice = new ArrayList1();
        int CusFlowerAccessories,AddOnAccessories,count=0,i,AccessoriesRemove=0;
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
            else if(CusFlowerAccessories>=i+1)
            {
                System.out.println("\nNumber that you enter out of range\n");
            }
         }while(CusFlowerAccessories<=0||CusFlowerAccessories>=i+1);
        
            totalAmount+=ArrayFlowerAccessoriesPrice.get(CusFlowerAccessories-1);
            AccessoriesChosen.add(ArrayFlowerAccessories.get(CusFlowerAccessories-1)+"|"+ArrayFlowerAccessoriesPrice.get(CusFlowerAccessories-1));
            
            System.out.println("1.add on flower Accessories");
            System.out.println("2.Remove flower Accessories");
             count++;
        }
        do{
        System.out.println("any number to next(except 1 and 2)");
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
                System.out.println("2.remove flower Accessories");
                
            }
          
         }while(AddOnAccessories<=0);
        
       
        if(AddOnAccessories==2)
        {
            do{
             do{
        System.out.println("\n\n-----Remove Selected flower Accessories------\n");
        System.out.println("-----Remaining Accessories------\n");
        System.out.println("==========================================================================");
        System.out.printf("%-2s | %-40s | %-22s|\n","No","Flower Accessories","Price");
        System.out.println("==========================================================================");
        for(i=0;i<AccessoriesChosen.size();i++){
            
            System.out.printf("%-2s | %-40s |RM %-20s|\n",i+1,AccessoriesChosen.get(i).substring(0, AccessoriesChosen.get(i).indexOf("|")),AccessoriesChosen.get(i).substring( AccessoriesChosen.get(i).indexOf("|")+1, AccessoriesChosen.get(i).length()));
        }
         
        System.out.println("enter 0 to quit");
         System.out.println("enter -1 to next step");
        System.out.print("Enter a number to remove : ");
          while(!UserInput.hasNextInt())
            {
                 System.out.println("\ninput invalid(not a number),please enter a number\n");
                 UserInput.next();
            }
        AccessoriesRemove= UserInput.nextInt();
        if(AccessoriesRemove<-1)
            {
                System.out.println("\nEnter positive number\n");
               
            }
        else if(AccessoriesRemove>i+1)
        {
            System.out.println("\nNumber that you enter out of range\n");
        }
          
         }while(AccessoriesRemove<-1||AccessoriesRemove>i+1);
             if(AccessoriesRemove>0&&AccessoriesRemove<=AccessoriesChosen.size())
             {
                count--;
                totalAmount-=Double.parseDouble(AccessoriesChosen.get(AccessoriesRemove-1).substring( AccessoriesChosen.get(AccessoriesRemove-1).indexOf("|")+1, AccessoriesChosen.get(AccessoriesRemove-1).length()));;
                AccessoriesChosen.remove(AccessoriesRemove-1);
             }
            }while(AccessoriesRemove>0&&AccessoriesRemove<=AccessoriesChosen.size()+1&&!AccessoriesChosen.isEmpty());
        }
         if(count==3)
        {
            System.out.println("\nMaximum flower accessories only 3!!!!!\n");
        }
        }while(AddOnAccessories>0&&AddOnAccessories<3&&AccessoriesRemove>-1&&count<4&&count>-1);
      
        return AccessoriesChosen;
        
    

    }

    }
