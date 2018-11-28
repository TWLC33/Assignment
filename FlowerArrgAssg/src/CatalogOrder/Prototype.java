package CatalogOrder;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Prototype {

    public static Scanner input = new Scanner(System.in);
    public static Product productDetails[] = new Product[3];
    public static double total = 0;
    
      public static void initValue()
	{
            //initialize value for productDetails
            productDetails[0] = new Product("P1","Fresh Flowers", 9.00);
            productDetails[1] = new Product("P2","Bouquests", 99.00);
            productDetails[2] = new Product("P3","Floral Arrangement", 499.00);
        }
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        initValue();
        productMenu();
    }
   
     public static void productMenu() throws Exception
    {
    	int prod;	
    	System.out.println("Catalog Order");
    	System.out.println("Choose options below: ");
    	System.out.println("1. Product Transactions");
    	System.out.println("2. Pick up");
    	System.out.println("3. Back to Main Menu");
    	System.out.println("4. Exit Program");
    	
    	prod = input.nextInt();
        
        switch (prod)
    		{
    			case 1:
    				selectProduct();
    				break;
    			case 2:
                                pickUp();
    				break;
                        case 3:
    				System.out.println("\n\nGoing back to Main Menu...\n\n");
    				return;
                        case 4:
                                System.out.println("\n\nTerminating program...");
    				System.exit(0);
    				break;
    			default:
    				System.out.println("\n\nError !!! NO this option !!!");
    				break;
    		}
    }
    
    public static void selectProduct() throws Exception{
     	
     	System.out.println("ID  Product");
     		
     	for(int i = 0 ; i < productDetails.length ; i++){
     		System.out.println(productDetails[i].getProductCode() + "  " + productDetails[i].getProductDesc());
     	}
        
     	Product product = null;
     	int proError = 0;
                
        input.nextLine();
        System.out.println("Choose your Product ID: ");
        do
        {
            String proId = input.nextLine();
     	
             	for(int i = 0 ; i < productDetails.length ; i++){
                    if(productDetails[i].getProductCode().equals(proId)){
     			proError = 0;			
                        product = productDetails[i];
     			break;
                    }
                }
     		
     		if(!proId.equals("P1")&&!proId.equals("P2")&&!proId.equals("P3")){
     			System.out.println("Error!!! The product ID that you key in is wrong.");
     		}else{
                    
                        System.out.println("Quantity : ");
     			int qty = input.nextInt();
                        double productPrice = product.getProductPrice();
                        double qtyValue = Payment.calQuantity(qty , productPrice);
                        total += qtyValue;
     			System.out.println("Product Price : RM" + productPrice + "\nPayment Amount : RM" + String.format("%.2f", qtyValue) + 
                                            "\nTotal Payment Amount" + String.format("%.2f", total));
     			System.out.println("Success");
                       
                        File fileProduct= new File("Payment.txt");
                        FileWriter fileWriterP = new FileWriter(fileProduct.getName(),true);
                        PrintWriter printWriterP = new PrintWriter(fileWriterP);
                        printWriterP.println(proId+","+qty+","+productPrice+","+qtyValue+","+total+",");
                        printWriterP.flush();
                        printWriterP.close();
                        
                        productMenu();
     		}
                proError++;
                if(proError>0)
                {
                    System.out.println("Choose your Product ID: ");
                }
        }while (proError!=0);     		
    }
    
    public static void pickUp(){
        
    }
}
    

