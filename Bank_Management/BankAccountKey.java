 

/**Modelon nje celes te tipit String, pasi numri identifikues i llogarise brenda bankes mund te kete ndonje shkronje ?
 */
public class BankAccountKey implements Key
{   private String id;
    /**Konstrukton objektin celes.
     *@param n - numri i plote i ruajtur si celes
     */
    public BankAccountKey(String n)
    { id = n; }

    /**Kthen vleren String 
     */
    public String valOf()
    { return id; }
    /**
     * Kthen se a jane te barabarte apo jo.
     */
    public boolean equals(Key anotherKey)
    { 
        boolean ok = false;
        if ( anotherKey instanceof BankAccountKey)
        {
            String m = ((BankAccountKey)anotherKey).valOf();
            
            ok =  id.equals(m);
        }
        return ok;
    }

}