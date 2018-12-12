/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice;

import java.util.Scanner;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class Invoice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
         Scanner input = new Scanner(System.in);
        ArrayList<String> ass = new ArrayList<String>();
        int loginSelect;
        do {
            loginSelection();
            loginSelect = input.nextInt();

            if (loginSelect == 1 || loginSelect == 2) {
                if (loginSelect == 1) 
                {
                    ShowPersonalInvoice();
                }
                else if (loginSelect == 2) 
                {
                    ShowALLinvoice();
                }
            } else {
                System.err.println("\n !!!!!!Please Enter 1 OR 2 !!!!!!!!! \n");
            }

        } while (loginSelect != 1 && loginSelect != 2);
    }
    
    public static void loginSelection() {

        System.out.println("==================\n Invoice \n==================");
        System.out.println("1. SHOW BY INVOICE NUMBER");
        System.out.println("2. SHOW ALL INVOICE ");

        System.out.print("Please Enter Your Selection : ");

    }
    
    public static void ShowPersonalInvoice() throws Exception{
        String Select;
        Scanner Selection = new Scanner(System.in);
        System.out.print("Please Enter Invoice ID : ");
        Select = Selection.next();
        File PaymentFile = new File("Payment.txt");
        Scanner inputCusPayment = new Scanner(PaymentFile);
        inputCusPayment.useDelimiter(",");
        int count = 0;
        double TotalPrice = 0;
        double Line_Total = 0;
        double Credit_Limit = 0;
        
        while (inputCusPayment.hasNext()) {
            String CompanyName = inputCusPayment.next();
            String InvoiceNo = inputCusPayment.next();
            String CompanyAddress = inputCusPayment.next();
            String PhoneNumber = inputCusPayment.next();
            String Quantity = inputCusPayment.next();
            String Product = inputCusPayment.next();
            String UnitPrice = inputCusPayment.next();
            String LineTotal = inputCusPayment.next();
            String Date = inputCusPayment.next();
            String CreditLimit = inputCusPayment.next();

            String next = inputCusPayment.nextLine();
           
            if (Select.toString().compareTo(InvoiceNo.toString()) == 0){
                if(count < 1)
                {
                    System.out.println("                     INVOICE                             ");
                    System.out.println("Company Name     : " + CompanyName + "               Date   : "+ Date);
                    System.out.println("                                       Invoice No   : " + InvoiceNo);
                    System.out.println("                                       Phone Number : " + PhoneNumber);
                    System.out.println("Company Address  : " + CompanyAddress);

                    System.out.println("*********************************************************************");
                    System.out.println("**    QTY    **   Product        **   Unit Price   **   Line Total ** ");
                    System.out.println("*********************************************************************");
                    count ++;
                }
                Line_Total = Double.parseDouble(LineTotal);
                Credit_Limit = Double.parseDouble(CreditLimit);
                TotalPrice = TotalPrice + Line_Total;
                System.out.printf("**    %-6s **   %-14s **   %-10s   **   %-10s **\n", Quantity, Product, UnitPrice, LineTotal);

            }
            
        }
        if(Line_Total < Credit_Limit)
        {
            System.out.println("                                     Total Price  :  RM "+ TotalPrice);
        }
        else if (Line_Total > Credit_Limit)
        {
            System.err.println("                                     Total Price  :  RM "+ TotalPrice);
            System.err.println("SORRY , YOUR CREDIT LINIT IS RM "+Credit_Limit+".");

        }
    }
    
    public static void ShowALLinvoice() throws Exception {
        
        String InvoiceCheck = "x";
        File PaymentFile = new File("Payment.txt");
        Scanner inputCusPayment = new Scanner(PaymentFile);
        inputCusPayment.useDelimiter(",");
        System.out.println("*****************************************************************************");
        System.out.println("**  CompanyName  **  Invoice No  **  Company Address  **   Phone Number   ** ");
        System.out.println("*****************************************************************************");

        while (inputCusPayment.hasNext()) {
            String CompanyName = inputCusPayment.next();
            String InvoiceNo = inputCusPayment.next();
            String CompanyAddress = inputCusPayment.next();
            String PhoneNumber = inputCusPayment.next();
            String Quantity = inputCusPayment.next();
            String Product = inputCusPayment.next();
            String UnitPrice = inputCusPayment.next();
            String LineTotal = inputCusPayment.next();
            String Date = inputCusPayment.next();
            String CreditLimit = inputCusPayment.next();

            String next = inputCusPayment.nextLine();
            if(InvoiceCheck.toString().compareTo(InvoiceNo.toString()) != 0)
            {
                System.out.printf("**    %-10s **   %-10s **   %-10s      **   %-10s     **\n", CompanyName , InvoiceNo , CompanyAddress , PhoneNumber );
                InvoiceCheck = InvoiceNo;
            }
        }
    }
}
    
