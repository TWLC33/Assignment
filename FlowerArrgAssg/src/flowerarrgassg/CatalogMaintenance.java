package flowerarrgassg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogMaintenance {

    public static List<Catalog> CatalogList = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Welcome to Juan Floral Order System!!!");
        System.out.println("1. View Catalog ");
        System.out.println("2. Search products ");
        System.out.println("3. Add products ");
        System.out.println("What would you like to do? ");
        System.out.print("My choice > ");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                displayCatalog();
                System.out.println("");
                main(args);
            case 2:
                int k;
                do {
                    searchProduct();
                    System.out.print("Do you wish to continue? (1. Yes, 2. No ) > ");
                    k = scanner.nextInt();
                } while (k == 1);
                System.out.println("");
                main(args);
            case 3:
                int j;
                do {
                    AddProduct();
                    System.out.print("Do you wish to continue? (1. Yes, 2. No ) > ");
                    j = scanner.nextInt();
                } while (j == 1);
                System.out.println("");
                main(args);
            default:
                break;
        }
    }

    public static void AddProduct() {
        System.out.println("");
        System.out.println("------------------------------------------ ");
        System.out.println("**************Add products**************** ");
        System.out.println("-------------------------------------------");
        Scanner scanner = new Scanner(System.in);
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
        System.out.println("You have successfully added product!!!");
    }

    private static int CreateID() {
        int id, counter = 10000;
        for (int a = 0; a < CatalogList.size(); a++) {
            counter++;
        }
        id = counter + 1;
        return id;
    }

    public static void displayCatalog() {
        System.out.println("");
        System.out.println("----------------------------------------------------");
        System.out.println("******************List of Catalog*******************");
        System.out.println("----------------------------------------------------");
        for (int b = 0; b < CatalogList.size(); b++) {
            System.out.println("******************************************************* ");
            System.out.println("ID: " + CatalogList.get(b).getID());
            System.out.println("Name: " + CatalogList.get(b).getName());
            System.out.println("Type: " + CatalogList.get(b).getType());
            System.out.println("Description: " + CatalogList.get(b).getDesc());
            System.out.println("Price: $" + CatalogList.get(b).getPrice());
            System.out.println("Stock Quantity: " + CatalogList.get(b).getQty());
            System.out.println("******************************************************* ");
            System.out.println("");

        }
    }

    public static void searchProduct() {
        System.out.println("");
        System.out.println("------------------------------------------ ");
        System.out.println("**************Search products************** ");
        System.out.println("-------------------------------------------");
        System.out.println("What would you like to search? ");
        System.out.println("1. Search by product type ");
        System.out.println("2. Search by product name ");
        System.out.println("3. Search by price ");
        System.out.print("Your choice > ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("");
            System.out.print("Enter product type > ");
            Scanner scan = new Scanner(System.in);
            String pType = scan.nextLine();
            for (int c = 0; c < CatalogList.size(); c++) {
                if (pType.equals(CatalogList.get(c).getType())) {
                    System.out.println("******************************************************* ");
                    System.out.println("ID: " + CatalogList.get(c).getID());
                    System.out.println("Name: " + CatalogList.get(c).getName());
                    System.out.println("Type: " + CatalogList.get(c).getType());
                    System.out.println("Description: " + CatalogList.get(c).getDesc());
                    System.out.println("Price: $" + CatalogList.get(c).getPrice());
                    System.out.println("Stock Quantity: " + CatalogList.get(c).getQty());
                    System.out.println("******************************************************* ");
                    System.out.println("");
                }

            }
        }
        else if (choice == 2)
            
            System.out.println("");
            System.out.print("Enter product name > ");
            Scanner scan = new Scanner(System.in);
            String pType = scan.nextLine();
            for (int d = 0; d < CatalogList.size(); d++) {
                if (pType.equals(CatalogList.get(d).getName())) {
                    System.out.println("******************************************************* ");
                    System.out.println("ID: " + CatalogList.get(d).getID());
                    System.out.println("Name: " + CatalogList.get(d).getName());
                    System.out.println("Type: " + CatalogList.get(d).getType());
                    System.out.println("Description: " + CatalogList.get(d).getDesc());
                    System.out.println("Price: $" + CatalogList.get(d).getPrice());
                    System.out.println("Stock Quantity: " + CatalogList.get(d).getQty());
                    System.out.println("******************************************************* ");
                    System.out.println("");
                }

            }
    }
}
