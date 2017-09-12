
public class PowerMethod {
 private static double[] vektoriVetjak;
 private double vleraVetiake;
 
 public PowerMethod() {}

	
	public static double normaInf(double[]x)
	{
		double max = 0;
		for(int i = 0; i<x.length;i++)
		{
			if(max <Math.abs(x[i]))
			{
				max = Math.abs(x[i]);
			}
				
		}
		return max;
	}
	public static double[] shumezoAx(double[][]A, double[]x)
	{
		double[] result = new double[A.length];
		
		for(int i = 0; i<x.length;i++)
		{
			double s = 0;
			for(int j = 0; j<x.length;j++)
			{
				s += A[i][j]*x[j];
			}
			result[i] = s; 
		}
		
		return result;
	}
	public static void powerMethod(int n, double[][] A, double [] x0, double TOL, int No)
	{
		
		int k = 1;
		int p;
		boolean not_found = true;
		double[] x = new double[n];
		while(not_found){
			for(int i = 0; i<n;i++)
			{	
				if(Math.abs(x0[i]) == normaInf(x0) )
				{
				     p = i;
				     
				     not_found = false;
				     
				}
			}}
		double xp = normaInf(x0); 
		for(int i = 0; i<n;i++){
			
			x[i] = x0[i]/xp;
		}
		
		
		while(k<=No)
		{   
			double[] y = new double[n];
			y = shumezoAx(A,x);
			double yp = normaInf(y);
			double vleraVetiake = yp;
			boolean not_found1 = true;
			while(not_found1)
			{
			for(int i = 0; i<n;i++)
				{	
					if(Math.abs(y[i]) == normaInf(y))
					{
						p = i;
						not_found1 = false ;
					
				    } 
			    }
			}
			if(yp == 0)
			{
				System.out.println("Vektori vetiak "+x);
				System.out.println("A ka vlere vetiake 0, zgjedhe nje vektor x dhe ristarto");
				break;
			}
			
			
			double[] xMinusY = new double [n];
			for(int i = 0 ; i<n;i++)
			{
				xMinusY[i] = x[i]-(y[i]/yp); 
			}
			double ERR = normaInf(xMinusY); 
			for(int i = 0; i<n;i++)
			{
				x[i] = y[i]/yp;
			}
			if(ERR < TOL)
			{
				System.out.println("Vlera vetiake : "+vleraVetiake+"\n");
				System.out.print("Vektori vetiak : ");
				System.out.print("[ ");
				for(int i = 0; i<n;i++){
				System.out.print(x[i]+"  ");
				}
				System.out.print("]^t");
				System.out.println("\nProcedura ishte e sukseshme !");
				System.exit(0);
			}
			
			k++;	
		}
		
		
		
		System.out.println("Eshte tejkaluar numri maksimal i iteracioneve ! ");
		System.out.println("Procedura ishte jo e suksesshme");
      
      vektoriVetjak = x;
	}
   
}
