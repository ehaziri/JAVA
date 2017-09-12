package KompaniaECokollatesOOP;
import javax.swing.*;
/*CmimiDheStoku percakton cmimin per secilin brend te cokollatave qe aktualisht gjenden ne stok. Secili produkt do te largohet nga stoku
ne momentin qe shitet, ne kete menyre zvogelohet sasia e cokollatave per secilin shites.
Verejtje: Per shkaqe thjeshtesie, secili shites do te kete inventar te njejte te cokollatave dhe brendeve te tyre
*/
public class CmimidheStoku
{ 
  private int MILKAneSTOK=180;
  private int DORINAneSTOK=180;
  private int TOBLERONEneSTOK=100;
  private int MIGROSneSTOK=100;
  private int ALPELLAneSTOK=150;
  private int KANDITneSTOK=100;
  private int NESTLEneSTOK=200;
  private int TWINGOneSTOK=200;
  private int DIDOneSTOK=200;
  private int CHOCOBISCUITneSTOK=20;
  
 /**cmimi kthen cmimin per secilin brend te cokollates
* @param lloji - lloji i cokollates qe shitet
* @return double, cmimin fiks te cokollates nese ai lloj gjendet ne stok,
* perndryshe kthen -1. */  
public double cmimi(String lloji, int sasia)
  {
   double cmimicokollades=0;
   
   switch(lloji)
   { case "MILKA":{ if(MILKAneSTOK <= 0 || sasia > MILKAneSTOK)
                      {cmimicokollades=-1;}
                    else{cmimicokollades=0.9;
                         MILKAneSTOK=MILKAneSTOK-sasia;}
                         break;}
     case "DORINA":{ if(DORINAneSTOK <= 0 || sasia > DORINAneSTOK)
                        {cmimicokollades=-1;}
                     else{cmimicokollades=0.8;
                           DORINAneSTOK=DORINAneSTOK-sasia;}
                         break;}
     case "TOBLERONE":{ if(TOBLERONEneSTOK <= 0 || sasia > TOBLERONEneSTOK)
                          {cmimicokollades=-1;}
                        else{cmimicokollades=1.00;
                             TOBLERONEneSTOK=TOBLERONEneSTOK-sasia;}
                         break;}
     case "MIGROS":{ if(MIGROSneSTOK <= 0 || sasia > MIGROSneSTOK)
                       {cmimicokollades=-1;}
                     else{cmimicokollades=0.9;
                          MIGROSneSTOK=MIGROSneSTOK-sasia;}
                         break;}
     case "ALPELLA":{ if(ALPELLAneSTOK <= 0 || sasia > ALPELLAneSTOK)
                        {cmimicokollades=-1;}
                      else{cmimicokollades=0.3;
                           ALPELLAneSTOK=ALPELLAneSTOK-sasia;}
                         break;}
     case "KANDIT":{ if(KANDITneSTOK <= 0 || sasia > KANDITneSTOK)
                       {cmimicokollades=-1;}
                     else{cmimicokollades=0.9;
                          KANDITneSTOK=KANDITneSTOK-sasia;}
                         break;}
     case "NESTLE":{ if(NESTLEneSTOK <= 0 || sasia > NESTLEneSTOK)
                      {cmimicokollades=-1;}
                     else{cmimicokollades=1.2;
                           NESTLEneSTOK=NESTLEneSTOK-sasia;}
                         break;}
     case "TWINGO":{ if(TWINGOneSTOK <= 0 || sasia > TWINGOneSTOK)
                       {cmimicokollades=-1;}
                     else{cmimicokollades=0.10;
                          TWINGOneSTOK=TWINGOneSTOK-sasia;}
                         break;}
     case "DIDO":{ if(DIDOneSTOK <= 0 || sasia > DIDOneSTOK)
                     {cmimicokollades=-1;}
                   else{cmimicokollades=0.30;
                        DIDOneSTOK=DIDOneSTOK-sasia;}
                         break;}
     case "CHOCOBISCUIT":{ if(CHOCOBISCUITneSTOK <= 0 || sasia > CHOCOBISCUITneSTOK)
                             {cmimicokollades=-1;}
                           else{cmimicokollades=0.20;
                                CHOCOBISCUITneSTOK=CHOCOBISCUITneSTOK-sasia;}
                         break;}
                       
     default:{JOptionPane.showMessageDialog(null," Nuk e kemi kete lloj te cokollades ");
              cmimicokollades=-1;}             
   }   
   
   return cmimicokollades; 
  } 
}