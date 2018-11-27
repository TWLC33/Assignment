package flowerarrgassg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogMaintenance {
    
    public static List<Catalog> CatalogList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static void MaintenanceMenu() {
        
        System.out.println("Welcome to Juan Floral Order System!!!");
        System.out.println("1. View Catalog ");
        System.out.println("2. Search products ");
        System.out.println("3. Add products ");
        System.out.println("What would you like to do? ");
        System.out.print("My choice > ");
        int i = scanner.nextInt();
            switch (i) {
                case 1:
                    System.out.println("List of Catalog");
                    displayCatalog();
                    System.out.println("");
                    MaintenanceMenu();
                case 2:
                    break;
                case 3:
                    AddProduct();
                    System.out.println("You have successfully added product!!!");
                    System.out.print("Do you wish to continue? (1. Yes, 2. No ) > ");
                    int j = scanner.nextInt();
                    if (j == 1)
                    {
                        AddProduct();
                    }
                    else
                    {
                    MaintenanceMenu();
                    }
                default:
                    break;
            }
    }
    
    public static void AddProduct() {
        
        System.out.println("------------------------------------------ ");
        System.out.println("**************Add products**************** ");
        System.out.println("-------------------------------------------");
        System.out.print("Product's name: ");
        String name = scanner.nextLine();    
        System.out.print("Product's type: ");
        String type = scanner.nextLine();
        System.out.print("Description (Like size, flower type): ");
        String desc = scanner.nextLine();
        System.out.print("Price of the product: $");
        double price = scanner.nextDouble();
        System.out.print("Current stocks: ");
        int qty = scanner.nextInt();
        Catalog newCatalog = new Catalog(CreateID(), name, type, desc, price, qty);
        CatalogList.add(newCatalog);  
    }
    
    private static int CreateID(){
        int id, counter = 10000;
        for(int a=0; a < CatalogList.size();a++)
        {
            counter++;
        }
        id = counter + 1;
        return id;
    }
    
    public static void displayCatalog(){
        for(int b=0; b<CatalogList.size();b++ )
        {
            System.out.println("ID: " + CatalogList.get(b).getID());
            System.out.println("Name: " + CatalogList.get(b).getName());
            System.out.println("Type: " + CatalogList.get(b).getType());
            System.out.println("Description: " + CatalogList.get(b).getDesc());
            System.out.println("Price: $" + CatalogList.get(b).getPrice());
            System.out.println("Stock Quantity: " + CatalogList.get(b).getQty());
            System.out.println("");
            
        }
    }
    
    public static void searchProduct(){
        
    }
}
