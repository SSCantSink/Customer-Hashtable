
/**
 * This is a Hashtable of CustomerNodes.
 * The customers are hashed according to the last 4 digits
 * of their phone numbers.
 * If there is a duplicate phone number (a collision), then
 * the new Customer is added to the CustomerNode that is in that index.
 * @author Karanveer Sandhu
 */
public class CustomerHashing 
{
    
    /**
     * the CustomerNodes in our Hashtable/The hastable itself
     */
    private CustomerNode[] customers;
    
    /**
     * This number does not change, this is based on the possible number of
     * 4 digit numbers out there. This is the permanent size of the
     * hashtable/array.
     */
    private final int SIZEOFARRAY = 10000;
    
    /**
     * Makes a new empty Hashtable of CustomerNodes.
     */
    public CustomerHashing()
    {
        customers = new CustomerNode[SIZEOFARRAY];
    }
    
    /**
     * Formats a string so if it a 4-digit number or less, The string returned
     * will be a 5-digit number.
     * @param a the string to be formatted into a 5-digit number.
     * @return the formatted 5-digit string number.
     */
    private String formatString(String a)
    {
        int alen = a.length();
        
        if (alen <= 0)
        {
            return "00000";
        }
        else if (alen == 1)
        {
            return "0000" + a;
        }
        else if (alen == 2)
        {
            return "000" + a;
        }
        else if (alen == 3)
        {
            return "00" + a;
        }
        else if (alen == 4)
        {
            return "0" + a;
        }
        else
        {
            return a;
        }
    }
    
    /**
     * This function adds a customer to the hashtable/array. If there is a
     * collision (customer to be added has the same last 4 digit phone number
     * as a current one), then the customer to be added will be appended to the
     * CustomerNode.
     * @param custToAdd the customer to be added to the hashtable/array.
     */
    public void addCustomer(Customer custToAdd)
    {
        // This is the phone number of the customer, but formatted
        // so it can be hashed.
        String phoneNumber = formatString(custToAdd.getNumber());
        
        // This is the index of the array to put our new customer.
        int hashIndex = Integer.parseInt(phoneNumber.substring(
                phoneNumber.length() - 4));
        
        // If the contents of the array is null.
        if (customers[hashIndex] == null)
        {
            // The customer will be the head node of that node.
            customers[hashIndex] = new CustomerNode(custToAdd);
            return;
        }
        
        // otherwise, we will have to add to the end of the linked list.
        // Here is our "iterator"
        CustomerNode pointer;
        pointer = customers[hashIndex];
        
        // keep going until we find a node whose's next node doesn't point to
        // anything.
        while (pointer.next != null)
        {
            pointer = pointer.next;
        }
        
        // That next node will be our new customer.
        pointer.next = new CustomerNode(custToAdd);
    }
    
    /**
     * This function tries to find a customer that has the same phone number
     * as the parameter and gets their details.
     * @param phoneNumber the phone number to search for.
     * @return a String stating their phone number, address, and name. Otherwise
     * this string states that the customer could not be found.
     */
    public String findCustomer(String phoneNumber)
    {
        // format the string int a 5-digit number.
        String phoneNumberf = formatString(phoneNumber);
        
        // This is the index of the array to find our customer in.
        int hashIndex = Integer.parseInt(phoneNumberf.substring(
                phoneNumberf.length() - 4));
        
        // Message to return when we finish the program.
        String returnMessage;
        
        // Our "iterator" of the customerNode
        CustomerNode pointer = customers[hashIndex];
        
        // To check if we found the customer already
        boolean found = false;
        
        // The customer that is to be found;
        Customer tobeFound = null;
        
        // Keep going until we found it or we reach the end of CustomerNode.
        while (pointer != null && !found)
        {
            // if the pointer's phone number matches with the input...
            if (pointer.cust.getNumber().equals(phoneNumber))
            {
                found = true; // we've found it
                tobeFound = pointer.cust;
            }
            pointer = pointer.next;
        }
        
        // if the customer with the same phone number is found.
        if (found)
        {
            returnMessage = "Customer with phone number " + phoneNumber + " is"
                    + " found.\n";
            returnMessage += "Their name is " + tobeFound.getName() + ".\n";
            returnMessage += "They live at " + tobeFound.getAddress() + ".\n";
        }
        else
        {
            returnMessage = "Customer with phone number " + phoneNumber + " is"
                    + " not found.\n";
        }
        
        return returnMessage;
    }
    
    public String removeCustomer(String phoneNumber)
    {
        String phoneNumberf = formatString(phoneNumber);
        
        // This is the index of the array to find our customer in.
        int hashIndex = Integer.parseInt(phoneNumberf.substring(
                phoneNumberf.length() - 4));
        
        // Message to return when we finish the program.
        String returnMessage;
        
        // If the first customer in the CustomerNode is the one..
        if (customers[hashIndex].cust.getNumber().equals(phoneNumber))
        {
            // The customer to be removed
            String tobeRemName = customers[hashIndex].cust.getName();
            returnMessage = "Removing customer " + tobeRemName + " from the "
                    + "system.\n";
            
            // remove that customer.
            customers[hashIndex] = customers[hashIndex].next; 
            
            // return appropiate message.
            return returnMessage;
        }
        
        // otherwise the customer might be somewhere else in the linkedlist.
        
        // Current pointer
        CustomerNode currentPointer = customers[hashIndex].next;
        
        // Previous pointer
        CustomerNode previousPointer = customers[hashIndex];
        
        // To tell if we found the customer
        boolean found = false;
        
        // go through the linkedList of Customers with two iterators.
        while (currentPointer != null && !found)
        {
            // if the currentPointer is the one to be removed.
            if (currentPointer.cust.getNumber().equals(phoneNumber))
            {
                found = true; // we've found it.
            }
            else // otherwise
            {
                // continue forward.
                currentPointer = currentPointer.next;
                previousPointer = previousPointer.next;
            }
        }
        
        // if we found the customer to be removed...
        if (found)
        {
            // The customer to be removed
            String tobeRemName = currentPointer.cust.getName();
            returnMessage = "Removing customer " + tobeRemName + " from the "
                    + "system.\n";
            
            // remove that from the CustomerNode LinkedList.
            previousPointer.next = currentPointer.next;
        }
        else // otherwise
        {
            returnMessage = "Could not find customer with phone number "
                    + phoneNumber + ".\n";
        }
        
        return returnMessage;
    }
}
