package KompaniaECokollatesOOP;
import javax.swing.*;
public class Shitesi implements InterfejsShitesi
{
  private String Emer;
  private String Mbiemer;
  private InterfejsCelesi ID;
  private double arka = 0;
  private CmimidheStoku c;
  private int te_shitura = 0;
  
  public Shitesi(String emri,String mbiemri,InterfejsCelesi Celesi)
  {
    Emer=emri;
    Mbiemer=mbiemri;
    ID=Celesi;
    c=new CmimidheStoku();
  }
/**ktheEmrin tregon emrin e shitesit
  *@return String */
  public String ktheEmrin()
  { return Emer; }
  
  public String ktheMbiemrin()
  { return Mbiemer;}

  public InterfejsCelesi ktheCelesin()
  { return ID; }
  
/**shitja tregon se a ka arrite shitesi ta shese cokollaten e caktuar
* @param lloji - lloji i cokollates qe shitet
* @param sasia- sa cokollata te llojit te caktuar duhet te shiten
* @return boolean, qe tregon realizimin ose jo te kerkeses. */ 
  public boolean shitja(String lloji,int sasia)
  { boolean suksesi;
    double rez = c.cmimi(lloji,sasia);
    if(rez== -1)
       {System.out.println("*Nuk mund te realizohet shitja per: " + lloji +
                                      ", meqe nuk ekziston sasia e kerkuar ne stok " );
        suksesi = false;}
    else
      {arka= arka + rez * sasia;
       suksesi = true;
       te_shitura += sasia;}
   return suksesi; 
  }
/**@arka tregon sa para ka fituar nje shites i caktuar nga shitja e cokollatave
   *@return double, parate e grumbulluara.*/  
  public double arka()
  {
   return arka;
  }
 /**@saKaShitur tregon sasine e cokollatave te shitura nga nje shites i caktuar
   *@return int, sasia.*/ 
  public int saKaShitur()
  {
   return te_shitura;
  }

}


















