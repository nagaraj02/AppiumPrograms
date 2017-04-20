package Day6_Session2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

public class dataprovide_Summation {
	
	@DataProvider(name="dp_Sum")
	public static Iterator<Object[]> gettestdata_summation() throws IOException
	{
		ExcelReadWrite xl= new ExcelReadWrite("D:\\Sum1.xls");
		
		HSSFSheet Sheet1 = xl.Setsheet("Sheet1");
		int RowCount = xl.getrowcount(Sheet1);
		System.out.println(RowCount);
		
		//Create the list of Object array
		List<Object[]> arr_list= new ArrayList<Object[]>();
		
		
		for(int i=1;i<=RowCount;i++)
		{
			//Create the Map
			Map<String,String> dsMap= new HashMap<String,String>();
			
			dsMap.put(xl.Readvalue(Sheet1, 0, "Num1"), (xl.Readvalue(Sheet1, i, "Num1")));
			dsMap.put(xl.Readvalue(Sheet1, 0, "Num2"), (xl.Readvalue(Sheet1, i, "Num2")));
			
			dsMap.put(xl.Readvalue(Sheet1, 0, "Exp_Result"), (xl.Readvalue(Sheet1, i, "Exp_Result")));
			
			Object[] Obj= new Object[1];
			Obj[0]=dsMap;
			
			arr_list.add(Obj);
			
		}
		
		 return arr_list.iterator();
		
		
		
		
	}

}
