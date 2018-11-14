/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;

/**
 *
 * @author USER
 */
public class Payment{
	
        private double quantity;
	private String paymentId;
	private double totalAmt;
	private double paymentPaid ;
	private double payableAmt; 
	private static int paymentCount = 0;
	
    public Payment(double quantity, double totalAmt ,double payableAmt) 
    {
    	this.quantity = quantity;
        this.paymentId = String.format("P%03d" , ++paymentCount);
    	this.totalAmt = totalAmt;
    	this.payableAmt = payableAmt;
    }

    public static double calQuantity(int qty , double productPrice){
           double qtyValue = 0;
           
           qtyValue = qty * productPrice;
            
           return qtyValue;
    }
    
    public String getPaymentID(){
    	return paymentId;
    }
    public void setPaymentPaid(double paymentPaid){
    	this.paymentPaid = paymentPaid;
    }
    
    public double getPaymentPaid(){
    	return paymentPaid;
    }
    
    public double getQuantity(){
    	return quantity;
    }
    
    public double getTotalAmt(){
    	return totalAmt;
    }
    
    public double getPayableAmt(){
    	return payableAmt;
    }
    
    public static double calPayableAmt( double totalAmt, double qtyValue){
    	
    	return totalAmt * qtyValue;
    }
    
    
}
