package catalogMaintenance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogMaintenance {

    public static List<Catalog> CatalogList = new ArrayList<>();
    private static int typeInt = 0;

    public static void CatalogMaintenanceMain() {

        System.out.println("Welcome to Juan Floral Order System!!!");
        System.out.println("1. View Catalog ");
        System.out.println("2. Search products ");
        System.out.println("3. Add products ");
        System.out.println("4. Remove products ");
        System.out.println("What would you like to do? ");
        System.out.print("My choice > ");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                String l = null;
                displayCatalog();
                System.out.print("Press enter to continue.");
                l = scanner.nextLine();
                if(l == null){
                System.out.println("");
                CatalogMaintenanceMain();
                }
                else
                {
                System.out.println("");
                CatalogMaintenanceMain();
                }
            case 2:
                int k;
                do {
                    searchProduct();
                    System.out.print("Do you wish to continue? (1. Yes, 2. No ) > ");
                    k = scanner.nextInt();
                } while (k == 1);
                System.out.println("");
                CatalogMaintenanceMain();
            case 3:
                int j;
                do {
                    AddProduct();
                    System.out.print("Do you wish to continue? (1. Yes, 2. No ) > ");
                    j = scanner.nextInt();
                } while (j == 1);
                System.out.println("");
                CatalogMaintenanceMain();
            case 4:
                RemoveProduct();
                System.out.println("");
                CatalogMaintenanceMain();

            default:
                break;
        }
    }

    public static void AddProduct() {
        String type = null;
        
        System.out.println("");
        System.out.println("------------------------------------------ ");
        System.out.println("**************Add products**************** ");
        System.out.println("-------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Product's name: ");
        String name = scanner.nextLine();
        
        System.out.println("1. Flower ");
        System.out.println("2. Floral Arrangement ");
        System.out.println("3. Bouquet ");
        System.out.print("Select TYPE: ");
        Scanner scanInt = new Scanner(System.in);
        do{
        typeInt = scanInt.nextInt();
        
        switch (typeInt) {
            case 1:
                {
                    type = "Flower";
                    break;
                }
            case 2:
                {
                    type = "Floral Arrangement";
                    break;
                }
            case 3:
                {
                    type = "Bouquet";
                    break;
                }
            default:
            {
                System.out.println("Error Input!!! Please enter again.");
                System.out.print("Please select type: ");
                break;
            }
        }
        }while(typeInt <= 0 || typeInt > 3);
        System.out.print("Description (Like size, flower type): ");
        Scanner scan = new Scanner(System.in);
        String desc = scan.nextLine();
        System.out.print("Price of the product: $");
        Scanner scan1 = new Scanner(System.in);
        double price = scan1.nextDouble();
        System.out.print("Current stocks: ");
        Scanner scan2 = new Scanner(System.in);
        int qty = scan2.nextInt();
        Catalog newCatalog = new Catalog(CreateID(), name, type, desc, price, qty);
        CatalogList.add(newCatalog);
        System.out.println("You have successfully added product!!!");
    }

    public static void RemoveProduct() {
        System.out.println("");
        System.out.println("------------------------------------------ ");
        System.out.println("**************Remove products**************** ");
        System.out.println("-------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        Scanner f = new Scanner(System.in);
        int j = 0;
        do {
            System.out.print("Please enter the product name you want to remove (-1 to exit) : ");
            String name = scanner.nextLine();
            if (name == "-1") {
                break;
            } else {
                for (int e = 0; e < CatalogList.size(); e++) {
                    if (name.equals(CatalogList.get(e).getName())) {
                        System.out.println("******************************************************* ");
                        System.out.println("ID: " + CatalogList.get(e).getID());
                        System.out.println("Name: " + CatalogList.get(e).getName());
                        System.out.println("Type: " + CatalogList.get(e).getType());
                        System.out.println("Description: " + CatalogList.get(e).getDesc());
                        System.out.println("Price: $" + CatalogList.get(e).getPrice());
                        System.out.println("Stock Quantity: " + CatalogList.get(e).getQty());
                        System.out.println("******************************************************* ");
                        System.out.println("");
                        System.out.print("Are you sure you want to remove this product? (1. Yes, 2. No ) > ");
                        j = f.nextInt();
                        if (j == 1) {
                            CatalogList.remove(e);
                            System.out.print("************Product removed successfully !!*************");
                            System.out.print("\n");
                        }

                    }
                }
            }

        } while (j == 2);
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
        } else if (choice == 2) {
            System.out.println("");
            System.out.print("Enter product name > ");
            Scanner scan = new Scanner(System.in);
            String pName = scan.nextLine();
            for (int d = 0; d < CatalogList.size(); d++) {
                if (pName.equals(CatalogList.get(d).getName())) {
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
        } else if (choice == 3) {
            System.out.println("");
            System.out.print("Enter price > ");
            Scanner scan = new Scanner(System.in);
            double pPrice = scan.nextDouble();
            for (int e = 0; e < CatalogList.size(); e++) {
                if (pPrice == CatalogList.get(e).getPrice()) {
                    System.out.println("******************************************************* ");
                    System.out.println("ID: " + CatalogList.get(e).getID());
                    System.out.println("Name: " + CatalogList.get(e).getName());
                    System.out.println("Type: " + CatalogList.get(e).getType());
                    System.out.println("Description: " + CatalogList.get(e).getDesc());
                    System.out.println("Price: $" + CatalogList.get(e).getPrice());
                    System.out.println("Stock Quantity: " + CatalogList.get(e).getQty());
                    System.out.println("******************************************************* ");
                    System.out.println("");
                }

            }
        }
    }
}
