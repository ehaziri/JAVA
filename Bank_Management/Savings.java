 
import java.util.*;
import javax.swing.*;
/** 
 * Klase konkrete qe modelon nje llogari kursimi
 */
public class Savings extends BankAccount
{
    private static double interesiVjetor = 0.08;  //8 %  interes vjetor
    Date koha_perfundimtare;   // koha deri kur afatizohen parate, qe eshte e barabarte me kohen e tanishme + sa_vite_afatizim
    int nr_viteve;
    boolean afatizuar;
    public Savings( int initial_amount, Key k, Customer cust)
    {
        super(initial_amount, k, cust);
        afatizuar = false;
    }
    /**
     * Shton ne balancin interesin e pefituar nga afatizimi i mjeteve
     */
    private void shtoInteresin()
    {
        balance = balance + balance*interesiVjetor*nr_viteve;
    }

    /**
     * @param amount - shuma qe duhet te deponohet
     * @return a u depozitua
     */
    @Override
    public boolean deposit(double amount)
    {
        boolean ok = false;
        if ( afatizuar)
        {
            if ( a_ka_kaluar_afati() == true )
            {
                // ka kaluar afati i caktuar i afatizimit, prandaj mund ta llogaritim interesin dhe ta lejojme transaksionin
                shtoInteresin();
                //tash therrasim metoden deposit te mbiklases, qe ta kryeje punen e depozitimit.
                ok = super.deposit(amount);
                afatizuar = false; // u shtu interesi, parate me nuk jane te afatizuara
            }
            else
            {
                String s = JOptionPane.showInputDialog("Nuk ka kaluar ende afati i caktuar i afatizimit. Nese e kryeni transaksionin tani, nuk do fitoni interes. Jeni i sigurte se doni te vazhdoni ? Y/N");
                if (s != null && s.toUpperCase().equals("Y"))
                {
                    ok = super.deposit(amount);
                    afatizuar = false;
                }
            }
        }
        else
        {
            ok = super.deposit(amount); // parate nuk jane te afatizuara, thjesht depono sipas kerkeses
        }
        return ok;
    }

    private boolean a_ka_kaluar_afati()
    {
        boolean kaluar = false;
        Date koha = new Date(); // koha e tanishme e PC
        if ( koha.after(koha_perfundimtare) )   // a eshte koha e tanishme "pas" kohes per deri kur jane afatizuar
        {
            kaluar = true;
        }
        return kaluar;
    }

    /**
     * @param amount - shuma qe duhet te terhiqet
     * @return a u terhiq me sukses
     */
    @Override
    public boolean withdraw(double amount)
    {
        boolean ok = false;
        if ( afatizuar)
        {
            if ( a_ka_kaluar_afati() == true )
            {
                // ka kaluar afati i caktuar i afatizimit, prandaj mund ta llogaritim interesin dhe ta lejojme transaksionin
                shtoInteresin();
                //tash therrasim metoden withdraw te mbiklases, qe ta kryeje punen e terheqjes.
                ok = super.withdraw(amount);
                afatizuar = false; // u shtu interesi, parate me nuk jane te afatizuara
            }
            else
            {
                String s = JOptionPane.showInputDialog("Nuk ka kaluar ende afati i caktuar i afatizimit. Nese e kryeni transaksionin tani, nuk do fitoni interes. Jeni i sigurte se doni te vazhdoni ? Y/N");
                if ( s.toUpperCase().equals("Y"))
                {
                    ok = super.withdraw(amount);
                    afatizuar = false;
                }
            }
        }
        else
        {
            ok = super.withdraw(amount); // parate nuk jane te afatizuara, thjesht terhiq sipas kerkeses
        }
        return ok;
    }

    /**
     * Afatizon parate qe gjenden ne konto per numrin e viteve qe jipet si argument
     */
    public boolean afatizoParate( int sa_vite_afatizim )
    {
        boolean ok = false;
        if (afatizuar == false) // dmth parate nuk jane tashme te afatizuara
        {
            nr_viteve = sa_vite_afatizim;
            koha_perfundimtare = shtoVitet(sa_vite_afatizim);
            afatizuar = true;
            ok = true;
        }
        return ok;
    }

    /**
     * @param nr - numri i viteve
     * @return objekt Date, i cili paraqet daten per nr vite me shume ( dmth data deri kur po i afatizojme parate )
     */
    private Date shtoVitet(int nr)
    {
        Date koha_tanishme = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(koha_tanishme);
        cal.add(Calendar.YEAR, nr);
        return cal.getTime();
    }

    public String getType()
    {
        return "llogari kursimi";
    }

    /**
     * Po e bejme override edhe kete metode, ashtu qe secilen here qe qaset llogaria ( provohet te deponohet ne te, behet terheqje, apo shikohet bilanci) fillimisht te shikohet se a duhet shtuar interes.
     */
    @Override
    public double getBalance()
    {
        if ( a_ka_kaluar_afati() == true )
        {
            shtoInteresin();
        }
        return balance;
    }
}
