
/**
 * The main class to test a Hashtable of Customer Objects
 * @author Karanveer Sandhu
 * Panther ID: 6096890
 */
public class TestHashing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // arrays of names, addresses, and phone numbers respective to their
        // index.
        String[] names = {"Comet", "Nebula", "Iris", "Aurora", "Crystal"};
        String[] addresses = {"Mercury", "Venus", "Mars", "Jupiter", "Saturn"};
        String[] numbers = {"7860010001", "7860210002", "7860210001",
                            "7860310001", "7860510003"};
        
        // our "system" of customers.
        CustomerHashing system = new CustomerHashing();
        
        // Adding each customer to the system hashtable.
        for (int i = 0; i < names.length; i++)
        {
            system.addCustomer(new Customer(names[i], addresses[i], 
                    numbers[i]));
        }
        
        // Finding various customers.
        System.out.println(system.findCustomer("7860010001"));
        System.out.println(system.findCustomer("7860210001"));
        System.out.println(system.findCustomer("7860310001"));
        System.out.println(system.findCustomer("7869999999"));
        
        // Remove a customer only to see if we can still find it.
        System.out.println(system.removeCustomer("7860210001"));
        System.out.println(system.findCustomer("7860210001"));
        System.out.println(system.removeCustomer("7860010001"));
        System.out.println(system.findCustomer("7860010001"));
        
        // Find a customer that was in the same index as the ones removed.
        System.out.println(system.findCustomer("7860310001"));
        
        // Remove a customer that does not exist.
        System.out.println(system.removeCustomer("7867310001"));
        
    }
    
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~Thanks for grading my program.~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
