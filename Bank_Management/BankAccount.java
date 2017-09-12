
public abstract class BankAccount implements Record
{
    private Key my_key;
    protected double balance;
    protected Customer owner;
    protected final double transactionFees = 0.1; // nese nuk eshte klienti i preferuar, per cdo transaksion, i terheqen 10 cente per sherbimin e ofruar.

    public BankAccount(int initial_balance,Key k, Customer cust)
    {
        my_key = k;
        balance = initial_balance;
        owner = cust;
        owner.addAccount(this); // shto kete llogari ne databazen e brendshme te pronarit
    }

    /**
     * @param amount - shuma qe duhet te deponohet
     * @return a u depozitua
     * Ne disa nga klaset konkrete kjo metode do behet override
     */
    public  boolean deposit(double amount)
    {
        // we deposit here
        boolean ok = false;
        if ( amount > 0 )
        {
            balance  +=amount;
            if ( owner.isPreferred() == false)
            {
                balance = balance -transactionFees;
            }
            ok = true;
        }
        return ok;
    }

    /**
     * @param amount - shuma qe duhet te terhiqet
     * @return a u terhoq
     * Ne disa nga klaset konkrete kjo metode do behet override
     */
    public boolean withdraw( double amount)
    {
        boolean ok = true;
        if (balance > amount+transactionFees)
        {
            balance = balance - amount;
            if ( owner.isPreferred() == false)
            {
                balance = balance -transactionFees;
            }
        }
        else
        {
            //po deshiron te terheqesh me shume para se sa kerkohet
            ok = false;
        }
        return ok;
    }

    public Key keyOf()
    {
        return my_key;
    }

    public double getBalance()
    {
        return balance;
    }

    /**
     * @return pronarin e llogarise
     */
    public Customer getOwner()
    {
        return owner;
    }

    /**
     * Kthen si String tipin e llogarise bankare;
     */
    public abstract String getType();
}
