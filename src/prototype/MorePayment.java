/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class MorePayment {
    	
	private String subId;
	private Product product;
	private String paymentStatus; 
	private ArrayList<Payment> paymentList;
	private static int subsricptionCount = 0;
	
    public MorePayment() {
    	paymentList = new ArrayList <Payment>();
    	this.subId = String.format("S%03d" , ++subsricptionCount);
    	paymentStatus = "Pending";
    }
    
    public MorePayment(Product product)
    {
    	paymentList = new ArrayList <Payment>();
    	this.subId = String.format("S%03d" , ++subsricptionCount);
    	this.product = product;
    	paymentStatus = "Pending";
    }
    
    public void addPayment(Payment payment)
    {
    	paymentList.add(payment);
    	
    	if(payment.getPayableAmt() - payment.getPaymentPaid() == 0){
    		paymentStatus = "Paid";
    	}else{
    		paymentStatus = "Pending";
    	}
    }
    
    public String getSubId()
    {
    	return subId;
    }

    public void setProduct(Product product)
    {
    	this.product = product;
    }
    
    public String getPaymentStatus(){
    	return paymentStatus;
    }
    
    public Product getProduct()
    {
    	return product;
    }
    
    public ArrayList<Payment> getPayment(){
    	return paymentList;
    }
    
    public static void subricptionDetail(ArrayList<MorePayment> subList) {
		//accept a payment list and display them all
        System.out.print("\n\nPayment Information\n");

        for (int i = 0; i < subList.size(); i++) {
            
            MorePayment more = subList.get(i);//get one payment from the list
		//display the payment detail 
            System.out.println("Subsricption ID : " + more.getSubId());
            System.out.println("Payment Status : " + more.getPaymentStatus());
            for(int j = 0 ; j < more.getPayment().size(); j++){
                
            	System.out.println("");
            	System.out.println("Payment ID : " + more.getPayment().get(j).getPaymentID());
            	System.out.println("Product Price : " + more.getPayment().get(j).getTotalAmt());
		System.out.println("Payment Amount : " + more.getPayment().get(j).getPayableAmt());
				
            }
            
            System.out.println("--------------------------------------------\n");
            
        }

    }
    
}
