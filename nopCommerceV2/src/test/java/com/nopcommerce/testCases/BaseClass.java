package com.nopcommerce.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUseremail();
	public String password = readconfig.getPassword();
	public static WebDriver driver;

	public static Logger logger;

	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) {
		logger = Logger.getLogger("nopEcommerce");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());

			driver = new ChromeDriver();

		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());

			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());

			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
