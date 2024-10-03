package operation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class UIoperation {
	WebDriver driver;

	public void action(String keyword, String objectname, String objecttype, String value) throws Exception {

		switch (keyword.toUpperCase()) {
		case "BROWSER":
			base b = new base();
			driver=b.init_driver(value);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			extentmanager.getTest().info("Browser opened");
			extentmanager.setDriver(driver);
			break;
		case "CLICK":
			driver.findElement(getobject(objectname, objecttype)).click();
			extentmanager.getTest().info("Clicked element " + value);
			extentmanager.setDriver(driver);
			break;
		case "GOTOURL":
			driver.get(value);
			 extentmanager.getTest().info("GOTOURL" + value);
			 extentmanager.setDriver(driver);
			break;
		case "SENDKEYS":
			driver.findElement(getobject(objectname, objecttype)).sendKeys(value);
			 extentmanager.getTest().info("Entered text in " + value);
			 extentmanager.setDriver(driver);

			break;
		case "SELECT":
			 WebElement drag = driver.findElement(getobject(objectname, objecttype));
			 Select draganddrop=new Select(drag);
			 draganddrop.selectByVisibleText(value.toUpperCase());
			 extentmanager.getTest().info("select option " + objectname);
			 extentmanager.setDriver(driver);
			 break;
		case "QUIT":
			 extentmanager.getTest().info("before quit");
			 extentmanager.setDriver(driver);
			Thread.sleep(10000);
			//driver.quit();
			break;
		}
		
			

	}

	public By getobject(String objectname, String objecttype) throws Exception {
		if (objecttype.equalsIgnoreCase("XPATH")) {

			return By.xpath(objectname);
		}
		// find by class
		else if (objecttype.equalsIgnoreCase("CLASSNAME")) {

			return By.className(objectname);

		}
		// find by name
		else if (objecttype.equalsIgnoreCase("NAME")) {

			return By.name(objectname);

		}
		// Find by css
		else if (objecttype.equalsIgnoreCase("CSS")) {

			return By.cssSelector(objectname);

		}
		// find by link
		else if (objecttype.equalsIgnoreCase("LINK")) {

			return By.linkText(objectname);

		}
		// find by partial link
		else if (objecttype.equalsIgnoreCase("PARTIALLINK")) {

			return By.partialLinkText(objectname);
		} else {
			throw new Exception("object not found exception");
		}
	}
}
