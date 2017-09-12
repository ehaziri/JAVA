package ushtrimeShembujt;

public class MetodaSteffensen {
	
	public double steffesen(Function g,double po,double TOL,int No){
		double p = po;
		int i = 1;
		boolean found = false;
		while(!found && i<=No)
		{
			double p1 =g.value(po);
			double p2 =g.value(p1);
			p = po-Math.pow(p1-po, 2)/(p2-2*p1+po);
			System.out.println(p);
			if(Math.abs(p-po)<TOL)
			{found = true;}
			else{
				i++;
				po=p;
			}
			
		}
		if(!found){
			throw new ArithmeticException("Metoda deshtoi pas "+No+" iteracioneve");
		}
		return p;
	}
	
	public static void main(String[] args)
	{
		MetodaSteffensen m = new MetodaSteffensen();
		Function g = new TestFunction();
		try{
			m.steffesen(g, 1.5, 1E-8, 20);
		}
		catch(ArithmeticException e){
			System.err.println(e.getMessage());
		}
	}
	
	public static class TestFunction implements Function{
		public double value(double x){
			return Math.sqrt(10/x+4);
		}
	}

}
