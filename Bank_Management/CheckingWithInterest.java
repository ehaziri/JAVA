 

/** 
 * Klase konkrete qe modelon nje llogari rrjedhese me interes
 */
public class CheckingWithInterest extends BankAccount
{
    private static double interesiVjetor = 0.12;  //12 %  interes vjetor
    public CheckingWithInterest( int initial_amount, Key k, Customer cust)
    {
        super(initial_amount, k, cust);
    }

    /**
     * Shton interesin mujor ne balanc, dhe per kete arsye kjo metode do duhet te thirret cdo muaj
     */
    public void shtoInteresinMujor()
    {
        balance *= (1 + (interesiVjetor/ 12));
    }
    
    public String getType()
    {
        return "llogari rrjedhese me interes";
    }
}
