package readexcel;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import operation.UIoperation;

public class readexcel {
	UIoperation ui=new UIoperation();
String  objectname;
String objecttype;
	public void read(String sheetname,Properties prop) throws Exception {
	FileInputStream fs=new FileInputStream("C:\\Letitbe\\javaprogram\\keyword_driven2\\src\\main\\java\\excelsheet\\guru99register.xlsx");
	   XSSFWorkbook wb=new XSSFWorkbook(fs);
	   XSSFSheet sheet=wb.getSheet(sheetname);
	   int r=sheet.getLastRowNum();
	   for(int i=1;i<=r;i++) {
		   String locatorvalue=sheet.getRow(i).getCell(1).toString();
		   if(!locatorvalue.equalsIgnoreCase("NA")) {
			   objecttype=locatorvalue.split("=")[0].trim();
			   if(objecttype.equalsIgnoreCase("XPATH")) {
				   objectname=locatorvalue.split("#")[1];
			   }
			   else {
				   objectname=locatorvalue.split("=")[1].trim();
			   }
		   }
		   String keyword=sheet.getRow(i).getCell(2).toString();
		   String value=sheet.getRow(i).getCell(3).toString();
		    String val = prop.getProperty(value);
		  ui.action(keyword,objectname,objecttype,val);
		   
	   }
	}
}
