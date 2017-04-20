package Day4_Session2;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;

public class driver_Mortgage extends Base_Class_Mortgage {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		Start_Server();
		Initialize_app();
		
		ExcelReadWrite xl= new ExcelReadWrite("D:\\EMI_Data1.xls");
		
		HSSFSheet Sheet1 = xl.Setsheet("Sheet1");
		int RowCount = xl.getrowcount(Sheet1);
		System.out.println(RowCount);
		
		for(int i=1;i<=RowCount;i++)
		{
			String Amount = xl.Readvalue(Sheet1, i, "Amount");
			String Interest = xl.Readvalue(Sheet1, i, "Interest");
			String Tenure = xl.Readvalue(Sheet1, i, "Tenure").replace(".0", "");
			
			String Exp_Result = xl.Readvalue(Sheet1, i, "Exp_Result");
			
			Mortgage_C c1= new Mortgage_C();
			String Actual_Result = c1.Calculate_EMI(driver, Amount, Tenure, Interest);
			
			xl.writecell(Sheet1, i, "Actual_Result", Actual_Result);
			
			if(Actual_Result.equals(Exp_Result))
			{
				xl.writecell(Sheet1, i, "Status", "Pass");
			}
			else
			{
				xl.writecell(Sheet1, i, "Status", "Fail");
			}
			
			
		}//end of for loop
		
		xl.save_excel("D:\\EMI_Data1.xls");
				
		Stop_Server();
	}

}
