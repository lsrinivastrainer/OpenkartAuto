package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1

	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException {
		//taking xl file from testData
		//String path=".\\testData\\Opencart_LoginData.xlsx";
		
		String path="C:\\Users\\Admin\\Desktop\\Flynaut\\JavaClass\\OpenkartAuto\\testData\\Openkart_LoginData.xlsx";
	
		//creating an object for XLUtility
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
	
		//create a two dimension array which can store excel data
		String logindata[][]=new String[totalrows][totalcols]; 
	
		//read the data from x1 storing in two dimensional array
		for(int i=1;i <= totalrows;i++) { //1 
			for(int j=0;j<totalcols;j++) { //0 	i is rows, j is col
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j); //1,0
			}
		}
		//returning two dimension array
		return logindata;
	}
	
	//DataProvider 2
	//DataProvider 3
}
