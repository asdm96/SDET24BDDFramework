package stepDefinitions;

import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
public class ReadDataTableTest {
	@When("read the data from the below table")
	public void read_the_data_from_the_below_table(DataTable dataTable) {
//	    List<List<String>> data = dataTable.asLists();
//	    System.out.println(data);
//	    String empId=data.get(1).get(0);
//	    System.out.println(empId);
		
		List<Map<String, String>> data = dataTable.asMaps();
		System.out.println(data);
		Map<String,String> firstRow=data.get(0);
		System.out.println(firstRow);
		Map<String,String> secondRow=data.get(1);
		System.out.println(secondRow);
		Map<String,String> thirdRow=data.get(2);
		System.out.println(thirdRow);
		
		String empName=data.get(0).get("empName");
		System.out.println(empName);
		String empId=data.get(0).get("empid");
		System.out.println(empId);
		
	}

}
