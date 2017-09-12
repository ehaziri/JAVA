package KompaniaECokollatesOOP;
/**DatabazaKompania permbane te gjitha manovrimet qe behen me nje databaze te zakonshme*/
public class DatabazaKompania
{
 private InterfejsMenaxheri[] base;
 private int NOT_FOUND = -1;
 
 public DatabazaKompania(int initial_size)
 {
  if (initial_size > 0)
      {
       base = new Menaxheri[initial_size];
      }
 else { base = new Menaxheri[1]; }
 }
 
 private int findLocation(InterfejsCelesi k)
 {
  int result = NOT_FOUND;
  boolean found = false;
  int i = 0;
  while ( !found && i != base.length )
         {
           if ( base[i] != null && base[i].ktheID().equals(k) )
               { 
                found = true;
                result = i;
               }
          else { i++; }
         }
   return result;
  }
  
 public InterfejsMenaxheri find(InterfejsCelesi k)
 {
  InterfejsMenaxheri answer = null;
  int index = findLocation(k);
  if ( index != NOT_FOUND )
      {
       answer = base[index];
      }
  return answer;
 }
 
 public boolean insert(InterfejsMenaxheri r)
 {
  boolean success = false;
  if ( findLocation(r.ktheID()) == NOT_FOUND )
      {
       boolean found_empty_place = false;
       int i = 0;
       while(!found_empty_place && i != base.length)
             {
              if ( base[i] == null )
                  {
                   found_empty_place = true;
                  }
             else { i++; }
             }
        if ( found_empty_place )
            {
             base[i] = r;
            }
       else {
             InterfejsMenaxheri[] temp = new Menaxheri[base.length * 2];
             for ( int j = 0; j!= base.length; j++ )
                  {
                   temp[j] = base[j];
                  }
              temp[base.length] = r;
              base = temp;
            }
       success = true;
      }
   return success;
  }
  
  public boolean delete(InterfejsCelesi k)
  {
   boolean result = false;
   int index = findLocation(k);
   if ( index != NOT_FOUND ) 
       {
        base[index] = null;
        result = true;
       }
   return result;
  }
 }

 