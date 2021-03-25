
/**
 * This object represents a real customer with their name
 * address, and phone number. Note that phone numbers must be numbers that are
 * positive.
 * @author Karanveer Sandhu
 */
public class Customer 
{
    /**
     * The person's name
     */
    private String name;
    
    /**
     * The person's address
     */
    private String address;
    
    /**
     * The person's phone number
     */
    private String number;  
    
    /**
     * Creates a new Customer
     * @param name name of the person
     * @param address the address of the person 
     * @param number the person's phone number.
     */
    public Customer(String name, String address, String number)
    {
        this.name = name;
        this.address = address;
        this.number = number;
    }
    
    /**
     * An accessor for the person's phone number.
     * @return the person's phone number as a String.
     */
    public String getNumber()
    {
        return number;
    }
    
    /**
     * An accessor for the person's name.
     * @return the person's name as a String.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * An accessor for the person's address.
     * @return the person's address as a String.
     */
    public String getAddress()
    {
        return address;
    }
    
}
