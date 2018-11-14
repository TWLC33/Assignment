/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Prototype {

    public static Scanner input = new Scanner(System.in);
    public static Product productDetails[] = new Product[3];
    
      public static void initValue()
	{
            //initialize value for productDetails
            productDetails[0] = new Product("P1","Fresh Flowers", 9.99);
            productDetails[1] = new Product("P2","Bouquests", 99.99);
            productDetails[2] = new Product("P3","Floral Arrangement", 499.99);

        }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        initValue();
        productMenu();
        
    }
   
     public static void productMenu()
    {
    	int treat;
    	do
    	{
    		
    	System.out.println("Catalog Order");
    	System.out.println("Choose options below: ");
    	System.out.println("1. Product Transactions");
    	System.out.println("2. Product Records");
    	System.out.println("3. Back to Main Menu");
    	System.out.println("4. Exit Program");
    	
    	treat = input.nextInt();
        
        switch (treat)
    		{
    			case 1:
    				selectProduct();
    				break;
    			case 2:
//    				MorePayment.subricptionDetail(subList);
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
    	}while(treat >= 1 && treat <= 3);
    }
    
    public static void selectProduct(){
     	
     	System.out.println("ID  Product");
     		
     	for(int i = 0 ; i < productDetails.length ; i++){
     		System.out.println(productDetails[i].getProductCode() + "  " + productDetails[i].getProductDesc());
     	}
     
     	Product product = null;
     	int proError = 1;
        MorePayment newSubsricption = null ;
     	
     	do{
     		System.out.println("Choose your Product ID: ");
     		String proId = input.nextLine();
                
     		for(int i = 0 ; i < productDetails.length ; i++){
     			if(productDetails[i].getProductCode().equals(proId)){
     				proError = 0;
     				product = productDetails[i];
     				break;
     			}else{
     				proError = 1;
     			}
     		}
     		
     		if(proError == 1){
     			
     			if(proError == 1){
     				System.out.println("Error!!! The product ID that you key in is wrong.");
     			}
     		}else{
                    
                        System.out.println("Quantity : ");
     			int qty = input.nextInt();
                        double productPrice = product.getProductPrice();
                        double qtyValue = Payment.calQuantity(qty , productPrice);
//     			double payableAmt = Payment.calPayableAmt(productPrice, qtyValue);
//     			Payment payment = new Payment(productPrice, payableAmt, qtyValue);
     			//display payment details
     			System.out.println("Product Price : RM" + productPrice + "\nPayment Amount : RM" + String.format("%.2f", qtyValue));
     			//prompt user paid amount
     			//make payment for treatment
//     			boolean payError = false;
//     			do{
//     				
//     				System.out.println("Enter Payment Amount you want to pay : RM");
//     				double paymentPaid = input.nextDouble();
//     				
//     				if( paymentPaid <= 0){
//     					System.out.println("Cannot key in the value that less than 0.");
//     					payError = true;
//     				}else if(paymentPaid > payableAmt){
//     					System.out.println("Changes : " + String.format("%.2f" , paymentPaid - payableAmt));
//     					payError = false;
//     				}
//     				else{
//     					System.out.println("Due :" + String.format("%.2f" , payment.getPaymentPaid() - payment.getPayableAmt()));
//     					payError = false;
//     				}
//     			
//     			}while(payError);
//     			
//     			newSubsricption.addPayment(payment);
//     			subList.add(newSubsricption);
     			System.out.println("Success");
     		}
     		
     	}while(proError == 1);
    }
}
    

