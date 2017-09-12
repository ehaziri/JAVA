
public class Database
{ private Record[] base;
    private int count;
    private int NOT_FOUND = -1;
    /**Inicializon bazen.
     * @param initialSize - madhesia fillestare e bazes
     */
    public Database(int initialSize)
    { if ( initialSize > 0 )
        { base = new Record[initialSize]; }
        else { base = new Record[1]; }
        count = 0;
    }

    private int locationOf(Key k)
    { int result = NOT_FOUND;
        boolean found = false;
        int i = 0;
        while ( !found && i != base.length )
        { if ( base[i] != null && base[i].keyOf().equals(k) )
            { found = true;
                result = i;
            }
            else { i++; }
        }
        return result;
    }

    /**Alokon nje regjistrim mbeshtetur ne celesin.
     *@param k - celesi i regjistrimit te kerkuar
     *@return rrokja e bazes (adresa e saj);
     *null ne qofte se rrokja nuk eshte gjetur
     */
    public Record find(Key k)
    { Record answer = null;
        int index = locationOf(k);
        if ( index != NOT_FOUND )
        { answer = base[index]; }
        return answer;
    }

    /**Inserton nje regjistrim ne bazen e te dhenave.
     *@param r - rrokja
     *@return true ne qofte se rrokja eshte shtuar;
     *false ne qofte se rrokja nuk eshte shtuar
     */
    public boolean insert(Record r)
    { boolean success = false;
        if ( locationOf(r.keyOf()) == NOT_FOUND )
        { boolean foundSlot = false;
            int i = 0;
            while ( !foundSlot && i != base.length)
            { // deri me tani base[0]...base[i-1] jane te zena
                if ( base[i] == null )
                { foundSlot = true; }
                else { i++; }
            }
            if ( foundSlot )
            { base[i] = r; }
            else { Record[] temp = new Record[2*base.length];
                for (int j = 0; j != count; j++)
                { // kopjohet permbajtja e base ne temp
                    temp[j] = base[j];
                }
                base = temp;
                base[count] = r;
            }
            count++;
            success = true;
        }
        return success;
    }

    /**Fshin nje regjistrim nga baza e te dhenave.
     *@param k - celesi i regjistrimit
     *@return true ne qofte se rrokja eshte fshire;
     *false ne qofte se rrokja nuk eshte fshire
     */
    public boolean delete(Key k)
    { boolean success = false;
        int index = locationOf(k);
        if ( index != NOT_FOUND )
        { base[index] = null;
            count--;
            success = true;
        }
        return success;
    }

    public Record[] getRecords()
    {
        return base;
    }
    
    public static void main(String args[])
    {
        // Krijojme dy databasat qe kerkohen
        Database llogarite =  new Database(10);
        Database klientet = new Database(10);
        
        // pjesa poshte eshte nje testim i funksionalitetit te databazave, kerkimit te llogarive, llojeve te klientave si dhe tipeve te ndryshme te llogarive
        
        CustomerKey kushtrimID = new CustomerKey(1232984046);
        Customer kushtrim = new Customer("Kushtrim",kushtrimID,false); // merr si argument emrin e klientit, celsin, si dhe se a eshte klient i preferuar
        klientet.insert(kushtrim);
        BankAccountKey kushtrim_acc_key = new BankAccountKey("A123");
        CheckingAccount kushtrim_ll_rrjedhese = new CheckingAccount(5,kushtrim_acc_key, kushtrim); // merr si argument bilancin fillestar, celsin, si dhe pronarin e llogarise
        llogarite.insert(kushtrim_ll_rrjedhese);     // e shton adresen e objektit te llogarise, te databaza ku ruhen llogarite e te gjithe klientave

        CustomerKey ismailKey = new CustomerKey(2013435327);
        Customer ismail = new Customer("Ismail",ismailKey,true); // merr si argument emrin e klientit, celsin, si dhe se a eshte klient i preferuar
        klientet.insert(ismail);
        BankAccountKey ismail_acc_key = new BankAccountKey("A123");
        CheckingAccount ismail_account = new CheckingAccount(70,ismail_acc_key, ismail); // merr si argument bilancin fillestar, celsin, si dhe pronarin e llogarise
        llogarite.insert(ismail_account);     // e shton adresen e objektit te llogarise, te databaza ku ruhen llogarite e te gjithe klientave

        BankAccount kushtrim_llogaria1 = (BankAccount)llogarite.find(kushtrim_acc_key);  // e kerkojme ne databasen e llogarive , llogarine me celsin kushtrim_acc_key
        BankAccount ismail_llogaria1 = (BankAccount)ismail.findAccount(ismail_acc_key); // nese e dime se llogaria me celsin ismail_acc_key eshte e ismailit, me lehte e kerkojme vetem te llogarite e tij
        // perndryshe e kerkojme te databaza e llogarive (BankAccount)llogarite.find(ismail_acc_key);  
         System.out.println(kushtrim.getName() + ", eshte i preferuar ? " + kushtrim.isPreferred());
          System.out.println(ismail.getName() + ", eshte i preferuar ? " + ismail.isPreferred());
        System.out.println("\n------------------------------------------\nTestim i llogarise rrjedhese \n------------------------------------------");
        System.out.println("Bilanci fillestar:");
        System.out.println( kushtrim_llogaria1.getOwner().getName() +" , " +  kushtrim_llogaria1.getType() + " : " + kushtrim_llogaria1.getBalance() );
        System.out.println( ismail_llogaria1.getOwner().getName() +" , " +  kushtrim_llogaria1.getType()  + " : " + ismail_llogaria1.getBalance() );

        System.out.println("\nPas transaksioneve, bilanci eshte : ");
        kushtrim_llogaria1.deposit(10);
        System.out.println("Deponojme 10 ne llogarine e " + kushtrim_llogaria1.getOwner().getName()  + ", balanci eshte " + kushtrim_llogaria1.getBalance() );
        ismail_llogaria1.withdraw(15);
        System.out.println("Terhqim 15 ne llogarine e "  + ismail_llogaria1.getOwner().getName()  + ", balanci eshte " + ismail_llogaria1.getBalance() );

        // Ne kete pjese testojme tipin CheckingWithInterest
        BankAccountKey celsi1 = new BankAccountKey("Q321");
        CheckingWithInterest kushtrim_ch_interest = new CheckingWithInterest (120,celsi1, kushtrim);
        llogarite.insert(kushtrim_ch_interest);
         System.out.println("\n------------------------------------------\nTestim i CheckingWithInterest \n------------------------------------------");
        System.out.println("Llogaria i ka fillimisht " + kushtrim_ch_interest.getBalance());
        kushtrim_ch_interest.shtoInteresinMujor();
        System.out.println("Pas shtimit te interesit mujor ka " + kushtrim_ch_interest.getBalance());
        
        //
        BankAccountKey celsi2 = new BankAccountKey("F456");
        int numri_viteve = 3;
        Savings kushtrim_savings = new Savings (500,celsi1, kushtrim);  // krijohet llogaria qe ka 500 euro, te afatizuara per 3  vite
        kushtrim_savings.afatizoParate(numri_viteve);
        llogarite.insert(kushtrim_savings);
        
        System.out.println("\n------------------------------------------\nTestim i Savings \n------------------------------------------");
        System.out.println("Llogaria i ka fillimisht " + kushtrim_savings.getBalance());
        boolean ok = kushtrim_savings.deposit(100);
        System.out.println("Pasi qe duhet te kalojne 3 vite ne menyre qe te shtohet interesi, nuk kemi si ta simulojme.");
        if (ok)
        {
             System.out.println("Pasi zgjodhet qe te depozitohen, atehere sipas specifikacioneve te llogarise, parate shtohen, por jo interesi. Gjendja momentale: "  + kushtrim_savings.getBalance() );
             //shenim: 0.1 cent ne kete rast ndalen per transaksion pasi nuk eshte klient i preferuar kushtrimi!
            }

    }
}