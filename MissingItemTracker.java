import java.util.*;

public class MissingItemTracker {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, Integer> inventory = new HashMap<>();
    static final int LOW_STOCK_THRESHOLD = 3;

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addItem(); break;
                case 2: updateItem(); break;
                case 3: removeItem(); break;
                case 4: viewLowStockItems(); break;
                case 5: viewAllItems(); break;
                case 6: 
                    System.out.println("Exiting... Thank you!");
                    break;
                default: 
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    static void showMenu() {
        System.out.println("\n----- Missing Item Tracker -----");
        System.out.println("1. Add Item");
        System.out.println("2. Update Item Quantity");
        System.out.println("3. Remove Item");
        System.out.println("4. View Low Stock Items");
        System.out.println("5. View All Items");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    static void addItem() {
        System.out.print("Enter item name: ");
        String item = sc.nextLine();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();
        sc.nextLine(); // consume newline

        inventory.put(item, qty);
        System.out.println("Item added successfully.");
    }

    static void updateItem() {
        System.out.print("Enter item name to update: ");
        String item = sc.nextLine();
        if (inventory.containsKey(item)) {
            System.out.print("Enter new quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();
            inventory.put(item, qty);
            System.out.println("Item updated successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    static void removeItem() {
        System.out.print("Enter item name to remove: ");
        String item = sc.nextLine();
        if (inventory.remove(item) != null) {
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    static void viewLowStockItems() {
        System.out.println("\n-- Low Stock Items (less than " + LOW_STOCK_THRESHOLD + ") --");
        boolean found = false;
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getValue() < LOW_STOCK_THRESHOLD) {
                System.out.println(entry.getKey() + " → " + entry.getValue());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No low stock items.");
        }
    }

    static void viewAllItems() {
        System.out.println("\n-- All Items --");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                System.out.println(entry.getKey() + " → " + entry.getValue());
            }
        }
    }
}
