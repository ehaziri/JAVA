package KompaniaECokollatesOOP;
public class Menaxheri implements InterfejsMenaxheri
{
  private String Emri_Menaxher;
  private String Mbiemri_Menaxher;
  private InterfejsCelesi ktheIDMenaxher;
  private InterfejsShitesi[] shitesat;
  private double fitimi = 0;
  
  public Menaxheri(String Emri,String Mbiemri,InterfejsCelesi c,InterfejsShitesi[] cilet_shitesa)
  {
   Emri_Menaxher=Emri;
   Mbiemri_Menaxher=Mbiemri;
   ktheIDMenaxher=c;
   shitesat=cilet_shitesa;
  }
  
  public String ktheEmrin()
  {return Emri_Menaxher;}
  
  public String ktheMbiemrin()
  {return Mbiemri_Menaxher;}
  
  public InterfejsCelesi ktheID()
  {return ktheIDMenaxher;}
 
  public InterfejsShitesi[] ktheShitesat()  //kthen adresen e vargut qe permbane shitesat
  { 
   return shitesat;
  }
  
/**ktheFitimin - llogarite fitimin nga parate qe ka arketuar secili punetor nen mbikqyrjen e menaxherit
  *@return double, parate e grumbulluara*/
  public double ktheFitimin() 
  {
   for ( int i = 0; i < shitesat.length; i++ )
        {
         fitimi += ((Shitesi)shitesat[i]).arka();
        }
  return fitimi;
  }
}