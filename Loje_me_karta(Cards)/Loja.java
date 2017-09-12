import javax.swing.*;
/**Loja inicializon objektet modeluese dhe shfaq zhvillimin e lojes ne mes te lojtarit kompjuter dhe lojtarit njeri.
  *Secili lojtar perpiqet te arrije 21 pike ose sa me afer ketyre pikeve.
  *Lojtari kompjuter eshte "i menqur" ashtu qe posa te iu afrohet 16 pikeve nuk kerkon me karta.
  *Kurse lojtari njeri mund te kerkoje karta sa te deshiroje perderisa kompjuteri nuk e nderpret lojen.
  *Lojtari qe ka me shume pike, pa i tejkaluar 21 pike, fiton.
  *Lojtari qe i tejkalon i pari keto pike deshton.
  *Fillimisht permes dialogut dales dihen vetem kartat e lojtarit njeri.
  *Atehere kur ndonjeri prej lojtareve nuk do me karta(nderpret lojen),
  *zbulohen fituesi apo lojtari qe ka arritur piken kritike,kartat qe mban kompjuteri dhe 
  *per transparence totali i pikeve te secilit lojtar.**/
public class Loja {
  public static void main(String[] args) {
	Shperndaresi sh = new Shperndaresi();
    LojtariKompjuter lk = new LojtariKompjuter();
    LojtariNjeri ln = new LojtariNjeri();
    sh.shperndajTe(lk, ln);
    int KUFIRI = 21;//kufiri te cilin nese e arrin ndonjeri lojtar atehere del nga loja
    int PIKA_LK = 16;//piket e preferueshme per lojtarin kompjuter qe te mos kerkoje me karta
    
    Kartat[] doralk = lk.zbuloKartat();//kartat qe mban lojtari kompjuter
    Kartat[] doraln = ln.zbuloKartat();//kartat qe mban lojtari njeri
    
    int lk_totali = 0;//totali i pikeve te kompjuterit
    int i = 0;
    int ln_totali = 0;//totali i pikeve te njeriut
    System.out.println("Lojtari Kompjuter mban keto karta:");
    while ( lk_totali <= PIKA_LK && doraln[i] != null )
	      {  int vleraln = doraln[i].merrVleren();
	         ln_totali = ln_totali + vleraln;
	         System.out.println(doralk[i].merrVleren() + " me " + doralk[i].merrLlojin());
	         int vlera = doralk[i].merrVleren();
             lk_totali = lk_totali + vlera;
             i++; 
           }
    System.out.println(" ");
    System.out.println("****************") ;
    System.out.println("Ju keni: " + ln_totali + " pike.");    
	System.out.println("Kompjuteri ka: " + lk_totali + " pike.");
   
    if ( lk_totali > KUFIRI )
        { JOptionPane.showMessageDialog(null,"KOMPJUTERI ARRITI KUFIRIN!"); }
    else if ( ln_totali > KUFIRI )
              { JOptionPane.showMessageDialog(null,"JU ARRITET KUFIRIN!"); }
          else if ( lk_totali > ln_totali )
                    { JOptionPane.showMessageDialog(null,"KOMPJUTERI FITOI!!!"); }
               else  if ( lk_totali == ln_totali )
                           { JOptionPane.showMessageDialog(null,"BARAZ!!!"); }
                       else{ JOptionPane.showMessageDialog(null,"JU FITUAT!!!"); }
  }
}
	


