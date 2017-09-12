/**ShpiliIKartave modelon nje shpil(komplet) te kartave */
public class ShpiliIKartave {
 private int numero_kartat; // sa karta mbesin ne shpil
 private Kartat[] shpili = new Kartat[ 4 * Kartat.MADHESIA_E_NJE_LLOJI];
 
/*Konstruktori ShpiliIKartave krijon shpilin me te gjitha kartat */
 public ShpiliIKartave()
 { krijoLlojin(Kartat.GJETHE);
   krijoLlojin(Kartat.ZEMER);
   krijoLlojin(Kartat.LULE);
   krijoLlojin(Kartat.DIAMAND);
 }
 
/*karteTeRe merr nje karte te re nga shpili *
 *@return kthen nje karte te paperdorur me pare, ose kthen null, nese nuk kane mbetur karta ne shpil*/
 public Kartat karteTeRe()
{ Kartat karte_tjeter = null;
  if (numero_kartat == 0 )
      { System.out.println("ShpiliIKartave-gabim: s'ka me karta"); }
  else{ int indeksi = (int)(Math.random() * numero_kartat);
        karte_tjeter = shpili[indeksi];
        for ( int i = indeksi + 1; i != numero_kartat; i = i + 1 )
              { shpili[i-1] = shpili[i]; }
        numero_kartat = numero_kartat - 1;
  }
  return karte_tjeter;
}

/*meshumeKarta tregon nese ne shpil kane mbetur karta te paperdorura
 *@return kthen pergjigje nese shpili ka karta ose jo*/
public boolean meshumeKarta()
{ return ( numero_kartat > 0 ); }

/*krijoLlojin krijon llojin e kartave per nje shpil te ri*/
private void krijoLlojin(String cilin_lloj)
{ for ( int i = 1; i <= Kartat.MADHESIA_E_NJE_LLOJI; i = i + 1 )
       { shpili[numero_kartat] = new Kartat(cilin_lloj, i);
         numero_kartat = numero_kartat + 1;
       }
       
}
}















