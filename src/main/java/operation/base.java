package operation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
WebDriver driver;
Properties prop;
public WebDriver init_driver(String browser) {
	if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	return driver;
}

public Properties init_properties() throws IOException {
	prop=new Properties();
	FileInputStream strem=new FileInputStream("C:\\Letitbe\\javaprogram\\keyword_driven2\\src\\main\\java\\properties\\object.properties");
	prop.load(strem);
	return prop;
}
}
