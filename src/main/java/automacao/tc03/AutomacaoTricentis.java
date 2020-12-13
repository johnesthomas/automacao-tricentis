package automacao.tc03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomacaoTricentis {

	private WebDriver driver;
	static final String PATH_WEBDRIVE = "./src/main/resources/chromedriver.exe";

	public WebDriver getWebDriver() {
		System.setProperty("webdriver.chrome.driver", PATH_WEBDRIVE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		return driver;
	}
	
	public void killAndCloseWebDriver() throws InterruptedException {
		Thread.sleep(5000);	// esperar 5 segundos para finalizar o processo
		driver.close();
		driver.quit();
	}
}