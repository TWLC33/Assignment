
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.util.Scanner;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
/**
 *
 * @author User
 */
public class Menu {

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
                    CustomerMaintain();
                }
                else if (loginSelect == 2) 
                {
                    Register();
                }
            } else {
                System.err.println("\n !!!!!!Please Enter 1 OR 2 !!!!!!!!! \n");
            }

        } while (loginSelect != 1 && loginSelect != 2);
    }

    public static void loginSelection() {

        System.out.println("==================\n Flower Shop \n==================");
        System.out.println("1. CUSTOMER MAINTIAN");
        System.out.println("2. REGISTER");

        System.out.print("Please Enter Your Selection : ");

    }

    public static void Register() throws Exception {
        String RUserName;
        String RIC;
        String PhoneNumber;
        int CustomerType;
        String CreditLimit;
        String Address;
        String CompanyName;
        Scanner Register = new Scanner(System.in);
        Scanner Ctype = new Scanner(System.in);
        System.out.println("==============\n Register \n===============");
        System.out.print("USERNAME     : ");
        RUserName = Register.nextLine();
        System.out.print("IC           : ");
        RIC = Register.nextLine();
        System.out.print("Phone Number : ");
        PhoneNumber = Register.nextLine();
        System.out.print("Please Enter Address : ");
        Address = Register.nextLine();
        System.out.println("CUSTOMER TYPE : ");
        System.out.println("1. Consumer  ");
        System.out.println("2. Corporate Customer ");
        System.out.print("Please Enter Your Selection : ");
        CustomerType = Ctype.nextInt();
        do {
            if (CustomerType == 1 || CustomerType == 2) {
                if (CustomerType == 1) {
                    File consumer = new File("Consumer.txt");
                    FileWriter fileWritterConsumer = new FileWriter(consumer.getName(), true);
                    PrintWriter printWriterConsumer = new PrintWriter(fileWritterConsumer);
                    printWriterConsumer.println(RUserName + "," + RIC + "," + PhoneNumber + "," + Address + ",");
                    printWriterConsumer.flush();
                    printWriterConsumer.close();
                } 
                
                if (CustomerType == 2) {
                
                System.out.print("Enter Monthly Credit Limit  : ");
                CreditLimit = Register.nextLine();
                System.out.print("Enter Company Name          : ");
                CompanyName = Register.nextLine();
                
                File corporate = new File("Corporate.txt");
                FileWriter fileWritterCorporate = new FileWriter(corporate.getName(), true);
                PrintWriter printWriterCorporate = new PrintWriter(fileWritterCorporate);
                printWriterCorporate.println(RUserName + "," + RIC + "," + PhoneNumber + "," + Address + "," + CreditLimit + "," + CompanyName + ",");
                printWriterCorporate.flush();
                printWriterCorporate.close();    
                }

            } 
            
            else {
                System.out.println("\n !!!!!!Please Enter 1 OR 2 !!!!!!!!! \n");
            }
        } while (CustomerType != 1 && CustomerType != 2);

    }
    
    public static void CustomerMaintain() throws Exception 
    {
        int CusMaintainSelect;
        
        do {
        
        Scanner Custmaintain = new Scanner(System.in);
        System.out.println("1. Corporate Customer List ");
        System.out.println("2. Consumer  Customer List ");
        System.out.println("3. Search by IC            ");
        System.out.println("4. EXIT                    ");
        System.out.print("\n Please Enter Your Selection : ");
        CusMaintainSelect = Custmaintain.nextInt();
            if (CusMaintainSelect == 1 || CusMaintainSelect == 2 || CusMaintainSelect == 3 || CusMaintainSelect == 4) 
                
            {
                if (CusMaintainSelect == 1) 
                {
                    File CorporateFile = new File("Corporate.txt");
                    Scanner inputCusCorporate = new Scanner(CorporateFile);

                    inputCusCorporate.useDelimiter(",");
                    
                    System.out.println("*************************************************************************************************************************************************");
                    System.out.printf("** %-20s ** %-20s ** %-20s ** %-20s ** %-20s ** %-20s ** \n"," NAME","IC","PHONE NUMBER","ADDRESS","CREDIT LIMIT","COMPANY ");
                    System.out.println("=================================================================================================================================================");

                    while (inputCusCorporate.hasNext()) 
                    {
                        String cORPORATE_NAME = inputCusCorporate.next();
                        String cORPORATE_IC = inputCusCorporate.next();
                        String cORPORATE_PN = inputCusCorporate.next();
                        String cORPORATE_Address = inputCusCorporate.next();
                        String cORPORATE_Credit = inputCusCorporate.next();
                        String cORPORATE_Company = inputCusCorporate.next();
                        
                        String next = inputCusCorporate.nextLine();
                        System.out.printf("** %-20s ** %-20s ** %-20s ** %-20s ** %-20s ** %-20s ** \n", cORPORATE_NAME,cORPORATE_IC,cORPORATE_PN,cORPORATE_Address,cORPORATE_Credit,cORPORATE_Company);

                    }
                }
                if (CusMaintainSelect == 2) 
                {
                    File ConsumerFile = new File("Consumer.txt");
                    Scanner inputCusConsumer = new Scanner(ConsumerFile);

                    inputCusConsumer.useDelimiter(",");
                    
                    System.out.println("*********************************************************************************************************************");
                    System.out.printf("** %-20s ** %-20s ** %-20s ** %-20s **\n"," NAME","IC","PHONE NUMBER","ADDRESS");
                    System.out.println("=====================================================================================================================");
                    
                    while (inputCusConsumer.hasNext()) 
                    {
                        String cONSUMER_NAME = inputCusConsumer.next();
                        String cONSUMER_IC = inputCusConsumer.next();
                        String cONSUMER_PN = inputCusConsumer.next();
                        String cONSUMER_Address = inputCusConsumer.next();
                        
                         String next = inputCusConsumer.nextLine();
                        
                        System.out.printf("** %-20s ** %-20s ** %-20s ** %-20s **\n", cONSUMER_NAME,cONSUMER_IC,cONSUMER_PN,cONSUMER_Address);
                    }

                }
                if (CusMaintainSelect == 3) 
                {
                    Search();
                } 
            }
            else 
                {
                    System.err.print("\nPlease Enter A Valid Number (1-4) \n\n");
                }
        }while (CusMaintainSelect != 1 && CusMaintainSelect != 2 && CusMaintainSelect != 3 && CusMaintainSelect != 4);
        
    }
    ;

    public static void Search() throws Exception
    {
        int SearchSelection;
        String Name = null;
        String ShowIC = null;
        String PN = null;
        String Address = null;
        String CreditLimit = null;
        String Company = null;
        boolean flag = false;
        Scanner SSearch = new Scanner(System.in);
        
        do {
            System.out.println("1. Corporate Customer   ");
            System.out.println("2. Consumer  Customer   ");
            System.out.println("3. EXIT                    ");
            System.out.print("\n Please Enter Your Selection : ");
            SearchSelection = SSearch.nextInt();
            if (SearchSelection == 1 || SearchSelection == 2 || SearchSelection == 3) {
                if(SearchSelection == 1)
                {
                    String IC;
                    Scanner SearchIC = new Scanner(System.in);
                    System.out.print("Please Enter IC   :    ");
                    IC = SearchIC.next();
                    File ConsumerFile = new File("Corporate.txt");
                    Scanner inputCusCorporate = new Scanner(ConsumerFile);
                    
                    inputCusCorporate.useDelimiter(",");
                    
                    while ( inputCusCorporate.hasNext()) 
                    {
                        String cORPORATE_NAME = inputCusCorporate.next();
                        String cORPORATE_IC = inputCusCorporate.next();
                        String cORPORATE_PN = inputCusCorporate.next();
                        String cORPORATE_Address = inputCusCorporate.next();
                        String cORPORATE_Credit = inputCusCorporate.next();
                        String cORPORATE_Company = inputCusCorporate.next();
                       
                        String next = inputCusCorporate.nextLine();
                       
                        if (IC.toString().compareTo(cORPORATE_IC.toString())==0)
                        {
                            
                            System.out.println("NAME         : " + cORPORATE_NAME);
                            System.out.println("IC           : " + cORPORATE_IC);
                            System.out.println("Phone Number : " + cORPORATE_PN);
                            System.out.println("Address      : " + cORPORATE_Address);
                            System.out.println("Credit Limit : " + cORPORATE_Credit);
                            System.out.println("Company Name : " + cORPORATE_Company);
                            flag = true;
                            break;
                        }
                        
                    }
                   if(flag==false)
                        {
                            System.err.println("Sorry , This IC is NOT Exist ");
                        }
                        
                    

                }
                if(SearchSelection == 2)
                {
                    String IC;
                    Scanner SearchIC = new Scanner(System.in);
                    System.out.print("Please Enter IC   :    ");
                    IC = SearchIC.next();
                    File ConsumerFile = new File("Consumer.txt");
                    Scanner inputCusCorporate = new Scanner(ConsumerFile);
                    
                    inputCusCorporate.useDelimiter(",");
                    
                    while ( inputCusCorporate.hasNext()) 
                    {
                        String cORPORATE_NAME = inputCusCorporate.next();
                        String cORPORATE_IC = inputCusCorporate.next();
                        String cORPORATE_PN = inputCusCorporate.next();
                        String cORPORATE_Address = inputCusCorporate.next();
                       
                        String next = inputCusCorporate.nextLine();
                       
                        if (IC.toString().compareTo(cORPORATE_IC.toString())==0)
                        {
                            
                            System.out.println("NAME         : " + cORPORATE_NAME);
                            System.out.println("IC           : " + cORPORATE_IC);
                            System.out.println("Phone Number : " + cORPORATE_PN);
                            System.out.println("Address      : " + cORPORATE_Address);
                            flag = true;
                            break;
                        }
                        
                    }
                   if(flag==false)
                        {
                            System.err.println("Sorry , This IC is NOT Exist ");
                        }
                }
                if(SearchSelection == 3)
                {
                    
                }

            } 
            else 
            {
                System.out.println("\nPlease Enter A Valid Number (1-4) \n\n");
            }
        }while (SearchSelection != 1 && SearchSelection != 2 && SearchSelection != 3);
    }

    public static void ConfirmStatement() {
        int confirm;
        Scanner input2 = new Scanner(System.in);
        System.out.println("1. Confirm ");
        System.out.println("2. Exit");
        System.out.print("Please Enter Your Selection  : ");
        confirm = input2.nextInt();

        if (confirm == 1) {

        } else if (confirm == 2) {

        }
    }
    

}
