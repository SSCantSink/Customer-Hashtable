
/**
 * This object is a LinkedList/node whose contents are a customer.
 * @author Karanveer Sandhu
 */
public class CustomerNode 
{
    
    /**
     * The customer content of the CustomerNode
     */
    Customer cust;
    
    /**
     * The next CustomerNode this current node points to
     */
    CustomerNode next;
    
    /**
     * Creates a new CustomerNode instance
     * @param cust the customer to put in as the content of this CustomerNode
     */
    public CustomerNode(Customer cust)
    {
        this.cust = cust;
        next = null;
    }
}
