/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class MainClass {
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int StaffInput=0;
        Scanner UserInput=new Scanner(System.in);
        do{
        StaffMenu();
        StaffInput = validate(UserInput, StaffInput);
        switch(StaffInput)
        {
            case 1: System.out.println("=====Catalog Maintenance=====");
                    catalogMaintenance.CatalogMaintenance.CatalogMaintenanceMain();
                    break;
            case 2: System.out.println("=====Customer Maintenance=====");
                    Menu.Menu.Consumer();
                    break;
            case 3: System.out.println("=====Invoice payment=====");
                    invoice.Invoice.Invoice();
                    break;
            case 4: System.out.println("=====Catalog Orders=====");
                    CatalogOrder.Prototype.CatalogOrder();
                    break;
            case 5: System.out.println("=====Customized Floral Arrangements=====");
                    flowerarrgassg.CustomizedFloral.CustomizedFloral();
                    break;
             
        }
        }while(StaffInput!=0);

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

    public static void StaffMenu(){
        System.out.println("====\nStaff Menu\n====");
        System.out.println("1.Catalog Maintenance");
        System.out.println("2.Customer Maintenance");
        System.out.println("3.Invoice payment");
        System.out.println("4.Catalog Orders");
        System.out.println("5.Customized Floral Arrangements");
       
        System.out.println("0.back");
        System.out.print("Enter a number to select : ");
        
          
    }
    
   

}
