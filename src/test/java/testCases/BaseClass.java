package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	public Properties p;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br) throws IOException {
		
		//Loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);

		
		switch(br.toLowerCase()){
		case "chrome": driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver();break;
		case "firefox" : driver=new FirefoxDriver();break;
		default: System.out.println("Invalid browser"); return;
		}
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(p.getProperty("appURL"));
	driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()	{
		driver.quit();
	}

	public String randomeString(){
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
		}
	public String randomeNumber() {
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
		}
	
	public String randomeAlphaNumberic() {
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@"+generatednumber);
	}
}
