package utilities;

import java.io.IOException;


import org.testng.annotations.DataProvider;

public class DataProviders {

	// Data Provider 1
	@DataProvider(name = "LoginData") //login we given a name to this
	public String[][] getData() throws IOException {
		String path = ".\\testData\\ValidationPassword.xlsx"; // taking xl file from test data

		ExcelUtil12 xlutil = new ExcelUtil12(path); // creating an object for xlutiliyu

		int totalrows = xlutil.getRowCount("Sheet1");  // no of rows
		int totalcols = xlutil.getCellCount("Sheet1", 1);  // no of cols

		String logindata[][] = new String[totalrows][totalcols]; // created or two dimensional aray which can
		// store row and cols

		for (int i = 1; i <= totalrows; i++)// 1 // read the data from xl storing in two dimesnion array
		{
			for (int j = 0; j < totalcols; j++)// 0 i is rows amd j is cols
			{
				logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // 1,0

			}
		}
		return logindata; // returninhg two dimesninal aray

	}

}
