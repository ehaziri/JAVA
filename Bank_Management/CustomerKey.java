 

/**Modelon nje celes numer te plote ( psh numri i leternjoftimit i klientit )
 */
public class CustomerKey implements Key
{   private int id;
    /**Konstrukton objektin celes.
     *@param n - numri i plote i ruajtur si celes
     */
    public CustomerKey(int n)
    { id = n; }

    /**Kthen vleren numer te plote te celesit.
     */
    public int valOf()
    { return id; }

    public boolean equals(Key anotherKey)
    {   boolean ok=false;
        if ( anotherKey instanceof CustomerKey)
        {
            int m = ((CustomerKey)anotherKey).valOf();
            ok =  (id == m);
        }
        return ok;
    }

}