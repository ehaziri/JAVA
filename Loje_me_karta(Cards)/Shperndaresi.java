import javax.swing.JOptionPane;
/**Shperndaresi u shperndan kartat lojtareve*/
public class Shperndaresi {
private ShpiliIKartave shpili = new ShpiliIKartave();//shpili qe perdore Shperndaresi

public Shperndaresi() {}
 
 public void shperndajTe(LojtariKompjuter lk, LojtariNjeri ln)
 { Kartat[] doraln = ln.zbuloKartat();
   Kartat[] doralk = lk.zbuloKartat();
   JOptionPane.showMessageDialog(null, "            LOJA \"21\"     ");  
   JOptionPane.showMessageDialog(null, "Ju do te luani kunder kompjuterit.");
   boolean procesi = true;
   int i = 0;
   int lk_totali = 0;
   while ( procesi )
          { if ( lk_totali <= 16 )
	            { boolean lk_kerkonKarte = lk.kerkonNjeKarte();
	              String kerkesa = JOptionPane.showInputDialog("Deshironi karte? (Shtyp PO, perndryshe cfaredo komande per te perfunduar):");
                  if ( ln.kerkonNjeKarte(kerkesa) && lk_kerkonKarte )
                      { lk.pranonNjeKarte(shpili.karteTeRe()); 
        	           ln.pranonNjeKarte(shpili.karteTeRe());
        	           JOptionPane.showMessageDialog(null,"Ju keni:  "+ doraln[i].merrVleren() + " me " + doraln[i].merrLlojin());
        	           System.out.println("Ju: "+ doraln[i].merrVleren() + " me " + doraln[i].merrLlojin());
        	           int vlera = doralk[i].merrVleren();
        	           lk_totali = lk_totali + vlera;
        	           i++; 
        	          }
                  else{ procesi = false;
                        JOptionPane.showMessageDialog(null, "Loja perfundoi! Ju nuk doni me karta.");}
                  }
	       else { procesi = false; 
	              JOptionPane.showMessageDialog(null, "Loja perfundoi! Kompjuteri nuk do me karta."); 
	            }
          }
   }
 }
