package utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import baseTest.ConstantData;

@Listeners(utilities.ExtentReportManager.class)

public class DataProviderTest implements ConstantData {
	@DataProvider(name = "LoginTest")
	
//	 public Object [] [] getdata() throws Throwable{
//		
//		
//		String path="./src/test/resources/Data/OpenCartData.xlsx";
//		ReadDataFromExcel xlUtility=new ReadDataFromExcel(path);
//		
//		int totalrows=xlUtility.getRowCount("Sheet1");
//		int totalcolumn=xlUtility.getCellCount("Sheet1",1);
//		
//		String loinData[][]= new String[totalrows][totalcolumn];//Created for two dimension Array Whic can Store 
//		
//		for(int i=1;i<totalrows;i++) {
//			for(int j=0;j<totalcolumn;j++) {
//				loinData[i-1][j]=xlUtility.getCellData("Sheet1", i, j);
//			}
//		}
//		System.out.println(loinData);
//		
//		return loinData;// Returning Two dimension array
//	}
//}


	
		public Object [][] loginTest(){
		
		Object [] []obj = {
							{"sahoohimansu555@gmail.com","Baba@1234","Valid"},
							{"satish@gmail.com","Stish@1234","Invalid"},
							{"vinaya@gmaoil.com","Vinaya@1234","Invalid"},
							{"sahoohimansu555@gmail.com","Baba@1234","Valid"}
				
						};
			
			return obj;
	}	
		}
