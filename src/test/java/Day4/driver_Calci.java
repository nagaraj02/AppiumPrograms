package Day4;

public class driver_Calci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Simple_Calci c1= new Simple_Calci();
		
		System.out.println(c1.Add(20, 10));
		System.out.println(c1.Sub(20, 10));
		System.out.println(c1.ktog(2));
		
		
		Scientific_Calci c2= new Scientific_Calci();
		
		System.out.println(c2.Add(20, 10));
		System.out.println(c2.Sub(20, 10));
		System.out.println(c2.pow(2,3));

	}

}
