 

public class Customer implements Record
{
    private String name;
    private Key key;
    private boolean preferred;
    private Database my_accounts =  new Database(5); // secili klient i ruan adresat e llogarive qe i perkasin atij

    public Customer(String my_name,Key k, boolean pref)
    {
        name = my_name;
        key = k;
        preferred  = pref;
    }

    public boolean isPreferred()
    {
        return preferred;
    }

    /**
     * Shton adresen e nje llogarie bankare
     */
    public boolean addAccount(BankAccount b)
    {
        boolean ok = false;
        if ( this == b.getOwner() )  // nese une jam pronar i kesaj llogarie
        {
           ok = my_accounts.insert(b);
        }
        //perndryshe llogaria qe don te shtohet, nuk e ka pronar kete klient
        return ok;
    }

    public void deleteAccount(Key k)
    {
        my_accounts.delete(k);
    }

    public Record findAccount(Key k)
    {
        return my_accounts.find(k);
    }

    public Record[] getAllAccounts()
    {
        return my_accounts.getRecords();
    }

    public String getName()
    {
        return name;
    }

    public Key keyOf()
    {
        return key;
    }

}
