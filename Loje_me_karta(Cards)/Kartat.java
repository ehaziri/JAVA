/**Kartat modelon karten qe do te perdoret ne lojen me karta.*/
public class Kartat {
public static final String GJETHE = "gjethe";
public static final String ZEMER = "zemer";
public static final String DIAMAND = "diamand";
public static final String LULE = "lule";

public static final int ASI = 11;
public static final int OFICERI = 10;
public static final int MBRETERESHA = 10;
public static final int MBRETI = 10;

public static final int MADHESIA_E_NJE_LLOJI = 13;// sa karta ne nje kategori
//Keto jane atributet e kartes:
private String lloji;
private int vlera;

/*Konstruktori Kartat tregon llojin dhe vleren
 *@param s - lloji
 *@param c - vlera */
public Kartat(String s, int c)
{ lloji = s;
  vlera = c;
}

/*merrLlojin kthen llojin e kartes*/
public String merrLlojin()
{ return lloji; }

/*merrVleren kthen vleren e kartes*/
public int merrVleren()
{ return vlera; }

}

