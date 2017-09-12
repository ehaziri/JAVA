 

/** 
 * Klase konkrete qe modelon nje llogari rrjedhese.
 * Kjo klase nuk ka metoda shetese per llogaritje te interesit, keshtu qe mjafton vetem qe ta implementoje metode  getType()
 */
public class CheckingAccount extends BankAccount
{
    public CheckingAccount( int initial_amount, Key k, Customer cust)
    {
        super(initial_amount, k, cust);
    }
    
    public String getType()
    {
        return "llogari rrjedhese";
    }
}
