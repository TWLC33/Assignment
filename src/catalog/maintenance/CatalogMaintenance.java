
package catalog.maintenance;

import java.util.Scanner;

public class CatalogMaintenance {

    public static void main(String[] args) {
        System.out.println("Welcome to Juan Floral Order System!!!");
        System.out.println("1. View Catalog ");
        System.out.println("2. Update Catalog ");
        System.out.println("3. Exit ");
        System.out.println("What would you like to do? ");
        System.out.println("My choice > ");
        Scanner scanner = new Scanner(System. in); 
        int i = scanner.nextInt();
        OUTER:
        
            switch (i) {
                case 1:
                    System.out.println("List of category ");
                    System.out.println("1. Fresh Flowers ");
                    System.out.println("2. Bouquests ");
                    System.out.println("3. Floral Arrangement ");
                    System.out.println("4. Exit ");
                    System.out.println("My choice > ");
                    int j = scanner.nextInt();
                    switch (j) {
                        case 1:
                            System.out.println("1. Amaryllis ");
                            System.out.println("2. Daisy ");
                            System.out.println("3. Rose ");
                            System.out.println("4. Sunflower ");
                            System.out.println("5. Primrose ");
                            break;
                        case 2:
                            System.out.println("1. 99 Roses bouquest ");
                            System.out.println("2. Graduation Bouquet Cotton Flower With Baby Breath ");
                            System.out.println("3. Love Moment : Bridal Bouquet ");
                            System.out.println("4. Summer Bouquet ");
                            break;
                        case 3:
                            System.out.println("1. Rose Floral Arrangement ");
                            System.out.println("2. Sunflower Floral Arrangement ");
                            System.out.println("3. Orchid Floral Arrangement ");
                            System.out.println("4. Hydrangea Floral Arrangement ");
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid Input! ");
                            System.out.println("Please enter 1-4! ");
                            break;
                    }       break;
                case 2:
                    System.out.println("Sorry! System Maintenance! ");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Input! ");
                    System.out.println("Please enter 1-3! ");
                    break;
            }
    }
    
}
