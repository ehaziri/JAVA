public class LojtariKompjuter {
 private Kartat[] dora;//kartat qe i mban lojtari
 private int numero_kartat = 0;//sa karta i mban lojtari
 private int madhesia_e_dores = (4 * Kartat.MADHESIA_E_NJE_LLOJI) / 2 ;//max i kartave qe mban lojtari

 /*Konstruktori */
 public LojtariKompjuter()
 { dora = new Kartat[madhesia_e_dores]; }

 /*kerkonNjeKarte pyet lojtarin nese deshiron nje karte te re
  *@return nese kerkohet karta*/
 public boolean kerkonNjeKarte()
 { return (numero_kartat < madhesia_e_dores); }
 
 /*pranonNjeKarte pranon karten dhe e shton te dora
  *@param c karta qe shtohet*/
 public void pranonNjeKarte(Kartat c)
 { dora[numero_kartat] = c;
   numero_kartat ++ ;
 }
 
 /*zbuloKartat shfaq te gjitha kartat qe mban lojtari
  *@return kthehet adresa e dora-s*/
 public Kartat[] zbuloKartat()
 { return dora; }
 
}
