import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class client {
    public static void main(String[] args) {
        try {
            
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            interinvor stub = (interinvor) registry.lookup("InventoryService");

           
            String name = "Laptop";
            int quantity = 100;
            String category = "Electronics";
            double price = 2500.33;
            String description = "Dell Latitude 7420";
            String companyName = "Dell Company";

            
            stub.addProduct(name, quantity, category, price, description, companyName);

        
            System.out.println(" Product added successfully:");
            System.out.println(" Name: " + name);
            System.out.println(" Quantity: " + quantity);
            System.out.println(" Category: " + category);
            System.out.println(" Price: $" + price);
            System.out.println(" Description: " + description);
            System.out.println(" Company: " + companyName);
        

        
            System.out.println(" Product list:");
            for (String prodName : stub.listProducts()) {
                System.out.println("- " + prodName);
            }
            System.out.println();

           
            int currentQuantity = stub.getQuantity(name);
            int addedQuantity = 20;
            int boughtQuantity = 5;

            stub.updateQuantity(name, currentQuantity, addedQuantity, boughtQuantity);
            System.out.println(" Quantity updated successfully.");

            
            int updatedQty = stub.getQuantity(name);
            System.out.println(" Current quantity of " + name + ": " + updatedQty);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
