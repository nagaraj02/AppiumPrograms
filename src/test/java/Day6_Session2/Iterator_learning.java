package Day6_Session2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterator_learning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> arr_list= new ArrayList<String>();
		
		arr_list.add("mango");
		arr_list.add("apple");
		arr_list.add("grapes");
		arr_list.add("orange");
		arr_list.add("mango");
		
		//for each
		
//		for(String x:arr_list)
//		{
//			System.out.println(x);
//		}
		
		//normal for loop
//		
//		for(int i=0;i<arr_list.size();i++)
//		{
//			
//			System.out.println(arr_list.get(i));
//		}
		
		//iterator
		
		Iterator<String> itr = arr_list.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		

	}

}
