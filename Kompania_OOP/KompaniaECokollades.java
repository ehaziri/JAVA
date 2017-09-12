package KompaniaECokollatesOOP;
import javax.swing.*;
public class KompaniaECokollades
{
public static void main (String args[])
{
  JOptionPane.showMessageDialog(null,"Miresevini ne EHEACokollata!!!");
  DatabazaKompania db =new DatabazaKompania(2);
  //Sa per ilustrim krijojme dy grupe te shitesve ku grupi i pare mbikeqyret nga menaxheri i pare, i dyti nga menaxheri i dyte
  InterfejsShitesi[]  shitesitEMenaxherit1=new InterfejsShitesi[2];
  InterfejsShitesi[]  shitesitEMenaxherit2=new InterfejsShitesi[3];
  
  
  InterfejsMenaxheri[] menaxheri = new InterfejsMenaxheri[2];
  //Vendosja e celesave per shitesit ne menyre te rastesishme duke shfrytezuar rritjen e numrave
  InterfejsCelesi[] sh = new InterfejsCelesi[5];
  for(int i = 0; i < 5; i++ )
      {
        sh[i] = new Celesi(i);
      }
  //Vendosja e celesave per menaxheret ne menyre te rastesishme duke shfrytezuar rritjen e numrave te shumezuar me 10
  InterfejsCelesi[]  m = new InterfejsCelesi[2];
  for(int i = 0; i < menaxheri.length; i++ )
      {
        m[i] = new Celesi(i * 10);
      }
  //Regjistrojme identitetin per secilin shites    
  shitesitEMenaxherit1[0] = new Shitesi("Riza", "Bytyci", sh[0]);
  shitesitEMenaxherit1[1] = new Shitesi("Halil", "Matoshi", sh[1]);
  
  shitesitEMenaxherit2[0] = new Shitesi("Armend", "Bilalli", sh[2]);
  shitesitEMenaxherit2[1] = new Shitesi("Ari", "Beka", sh[3]);
  shitesitEMenaxherit2[2] = new Shitesi("Arsim", "Beqiri", sh[4]);
  
  //Regjistrojme identitetin per secilin menaxher
  menaxheri[0] = new Menaxheri("Edis", "Rexha", m[0], shitesitEMenaxherit1);
  menaxheri[1] = new Menaxheri("Andi", "Haliti", m[1], shitesitEMenaxherit2);
  
  //Sa per ilustrim insertojme te dy menaxheret ne databaze
  db.insert(menaxheri[0]); //mund te afishohet suksesi i insertimit
  db.insert(menaxheri[1]);
  
  //REALIZIMI I SHITJEVE dhe afishimi i punes e identitetit per secilin shites
  JOptionPane.showMessageDialog(null, "Momentalisht jane duke u realizuar shitjet e cokollatave nga brende te ndryshme."); 
  JOptionPane.showMessageDialog(null, "Sa per ilustrim tregojme qe nje shites nuk do te arrije te shese me shume cokollata sesa qe ka aktualisht ne stok ->");
  
  shitesitEMenaxherit1[0].shitja("MILKA" , 200);//Sa per ilustrim tregojme se nuk mund te shiten me shume cokollata sesa qe kemi ne stok 
  shitesitEMenaxherit1[1].shitja("TOBLERONE" , 99); 
     
  double fitimiimxh1 = ((Menaxheri)menaxheri[0]).ktheFitimin(); 
     
  JOptionPane.showMessageDialog(null, "Shih ne vijim performancen e secilit shites ne ekran.");
  for(int i = 0; i < shitesitEMenaxherit1.length; i++)
      {
       System.out.println("Shitesi: " + shitesitEMenaxherit1[i].ktheEmrin()+" " + shitesitEMenaxherit1[i].ktheMbiemrin()+
                          ", ka arketuar " +((Shitesi)shitesitEMenaxherit1[i]).arka() + "Euro" + " nga shitja e " +
                          ((Shitesi)shitesitEMenaxherit1[i]).saKaShitur()+ " cokollatave.");
      }
   
 
  shitesitEMenaxherit2[0].shitja("MILKA" , 20);   
  shitesitEMenaxherit2[0].shitja("ALPELLA",1); //Per ilustrim tregojme se shitesi i njejte mund te shes produkt tjeter nga parapraku
  shitesitEMenaxherit2[1].shitja("TOBLERONE" , 100);
  shitesitEMenaxherit2[2].shitja("DORINA" , 1);
     
  for(int i = 0; i < shitesitEMenaxherit2.length; i++)
      {
       System.out.println("Shitesi: " + shitesitEMenaxherit2[i].ktheEmrin()+" " + shitesitEMenaxherit2[i].ktheMbiemrin()+
                          ", ka arketuar " +((Shitesi)shitesitEMenaxherit2[i]).arka() + "Euro" + "Euro" + " nga shitja e " +
                          ((Shitesi)shitesitEMenaxherit2[i]).saKaShitur()+ " cokollatave.");
      }
  double fitimiimxh2 = ((Menaxheri)menaxheri[1]).ktheFitimin();
      
  JOptionPane.showMessageDialog(null, "Sa para kane mbledhur menaxheret ne fund te dites?");
  JOptionPane.showMessageDialog(null,"Menaxheri1: " + menaxheri[0].ktheEmrin() + " " + menaxheri[0].ktheMbiemrin()+ " arketon nga te gjithe shitesit e tij shumen prej: " + fitimiimxh1 + " Euro");
  JOptionPane.showMessageDialog(null,"Menaxheri2: " + menaxheri[1].ktheEmrin() + " " + menaxheri[1].ktheMbiemrin()+ " arketon nga te gjithe shitesit e tij shumen prej: " + fitimiimxh2 + " Euro");  
  
  System.out.println("\n\nMenaxheri1 ka nen mbikeqyrje shitesit: ");
  InterfejsShitesi[] gr1ishitesve = menaxheri[0].ktheShitesat(); 
  for ( int i = 0; i < gr1ishitesve.length; i++) 
       {
        System.out.print(gr1ishitesve[i].ktheEmrin() + " " + gr1ishitesve[i].ktheMbiemrin()+", ");
       }  
  System.out.println("\n\nMenaxheri2 ka nen mbikeqyrje shitesit: ");
  InterfejsShitesi[] gr2ishitesve = menaxheri[1].ktheShitesat(); 
  for ( int i = 0; i < gr2ishitesve.length; i++) 
       {
        System.out.print(gr2ishitesve[i].ktheEmrin() + " " + gr2ishitesve[i].ktheMbiemrin()+", ");
       }  
       
       
       /** me lart eshte ruajtur fitimi i secilit menaxher,dhe u pa edhe gjate ekzekutimit.Per te pare funksionimin edhe te bazes se te
          dhenave, largojme menaxherin me shitjet me te vogla*/
       JOptionPane.showMessageDialog(null,"Fshijme nga baza e te dhenave menaxherin me me pak shitje, per te treguar funksionimin e bazes");
       InterfejsCelesi kerkimipasfshirjes;
          
       if(fitimiimxh1 > fitimiimxh2)
         {InterfejsCelesi idimenaxherit2=menaxheri[1].ktheID();
          kerkimipasfshirjes=idimenaxherit2;
          boolean fshirja=db.delete(idimenaxherit2);
          JOptionPane.showMessageDialog(null,"Menaxheri2 a u largua nga databaza? " + "Pergjigja = " + fshirja);}
             
       else{InterfejsCelesi idimenaxherit1=menaxheri[0].ktheID();
            kerkimipasfshirjes=idimenaxherit1;
            boolean fshirja=db.delete(idimenaxherit1);
            JOptionPane.showMessageDialog(null,"Menaxheri1 a u largua nga databaza? " + "Pergjigja = " + fshirja);} 
        
        //kerkimi pas fshirjes
       InterfejsMenaxheri tregoaeshteneDB=db.find(kerkimipasfshirjes);
       if(tregoaeshteneDB == null){JOptionPane.showMessageDialog(null,"IDeMenaxherit: " + kerkimipasfshirjes.ktheCelesin() + " ,ky menaxher nuk gjendet ne baze te te dhenave me.");}
            
           
 }

}