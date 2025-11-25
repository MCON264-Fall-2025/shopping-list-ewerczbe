package exercises.shopping_app;

import edu.touro.mcon264.apps.collections.ListInterface;

import java.util.Scanner;

/**
 * Creates a ListInterface<ShoppingItem> instance.
 * Has a main method that runs a console application.
 * Provides a simple text-based menu to:
 * Add items (in sorted order).
 * View the current list.
 * “Shop” the next item on the list.
 * Exit the program.
 */
public class ShoppingListApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListInterface<ShoppingItem> shoppingList = new edu.touro.mcon264.apps.collections.ArrayBasedList<>();

        System.out.println("\n=== Shopping List Menu ===");
        System.out.println("1. Add item");
        System.out.println("2. Show current shopping list");
        System.out.println("3. Shop next item");
        System.out.println("0. Exit");
       System.out.println("Enter your choice: ");
       int choice = scanner.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    System.out.print("Enter aisle: ");
                    String aisle = scanner.nextLine();
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    ShoppingItem newItem = new ShoppingItem(aisle, name);
                    insertSorted(shoppingList, newItem);
                    System.out.println("Item added successfully!");
                    break;

                case 2:
                    if (shoppingList.size() == 0) {
                        System.out.println("Shopping list is empty.");
                    } else {
                        System.out.println("\nCurrent Shopping List:");
                        for (int i = 0; i < shoppingList.size(); i++) {
                            System.out.println((i + 1) + ". " + shoppingList.get(i));
                        }
                    }
                    break;

                case 3:
                    ShoppingItem nextItem = shopNext(shoppingList);
                    if (nextItem == null) {
                        System.out.println("No items to shop!");
                    } else {
                        System.out.println("You shopped: " + nextItem);
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Try again: ");
                    choice = scanner.nextInt();
            }
            System.out.println("\n=== Shopping List Menu ===");
            System.out.println("1. Add item");
            System.out.println("2. Show current shopping list");
            System.out.println("3. Shop next item");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
        }

        scanner.close();

    }
    /**
     * Inserts the given item into the list so that the list remains sorted
     * by aisle and then item name.
     */
    public static void insertSorted(ListInterface<ShoppingItem> list, ShoppingItem item) {
        // TODO: implement using list.get(i), list.add(i, item), list.size()
        int i = 0;
        while (i < list.size() && list.get(i).compareTo(item) <= 0) {
            i++;
        }
        list.add(i, item);

    }

    /**
     * Returns the "next" item to shop and removes it from the list.
     * If the list is empty, returns null.
     */
    public static ShoppingItem shopNext(ListInterface<ShoppingItem> list) {
        if (list.size() == 0) {
            return null; // nothing to shop
        }
        return list.remove(0);
    }



}
