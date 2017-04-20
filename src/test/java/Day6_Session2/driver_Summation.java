package Day6_Session2;

import java.util.Map;

import org.testng.annotations.Test;

public class driver_Summation {
	
	
	@Test(dataProvider="dp_Sum" , dataProviderClass=Day6_Session2.dataprovide_Summation.class)
	public void testSummation(Map Calc)
	{
		String Num1 = Calc.get("Num1").toString();
		String Num2 = Calc.get("Num2").toString();
		
		String Exp_Result = Calc.get("Exp_Result").toString();
		
		double Number1=Double.parseDouble(Num1);
		double Number2=Double.parseDouble(Num2);
		
		double Expected_Result=Double.parseDouble(Exp_Result);
		
		double Actual_Result=Number1+Number2;
		
		if(Actual_Result==Expected_Result)
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		
	}
	

}
