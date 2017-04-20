package Day4;

public class driver_Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//class name refrence var= Object
		Calculator c1= new Calculator();
		
		//call add method
		int Add_Result = c1.Add(20, 10);
		System.out.println(Add_Result);
		
		
		//call sub method
		int Sub_Result = c1.Sub(20,10);
		System.out.println(Sub_Result);
		
		int mult_Result = Calculator.mult(20, 10);
		System.out.println(mult_Result);
		
		int mult_Result2 = c1.mult(20, 10);
		System.out.println(mult_Result2);
		

		
	}

}
