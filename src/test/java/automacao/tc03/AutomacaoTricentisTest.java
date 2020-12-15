package automacao.tc03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class AutomacaoTricentisTest {

	static AutomacaoTricentis config;
	static WebDriver driver;
	static WebElement element;
	static TC003_001_1_Abrir_Website abrir;
	static PrintScreen capturaTela = new PrintScreen();
	

	@BeforeAll
	public static void init() {
		config = new AutomacaoTricentis();
		driver = config.getWebDriver();
		abrir = new TC003_001_1_Abrir_Website();
	}

	@Test
	@DisplayName("TC003.001.1 - Abrir Website")
	void testA() throws IOException {
		String resultEsperado = "Tricentis Vehicle Insurance";
		String resultAtual;

		resultAtual = abrir.abrirSite(driver);						

		assertEquals(resultEsperado, resultAtual, "Impossível Carregar Página!");

	}

	@Test
	@DisplayName("TC003.001.1.1 - Botão Motocycle")
	void testB() throws IOException {

		element = driver.findElement(By.id("nav_motorcycle"));
		element.click();		
	}

	@Test
	@DisplayName("TC003.001.2 - Preencher os campos de “Enter Vehicle Data” com dados válidos e clicar no botão 'Next >>'")
	void testC() throws IOException {

		String resultEsperado = "0";
		String resultAtual;
		WebElement xPath;
		
		capturaTela.takeScreenShot(driver);

		element = driver.findElement(By.id("make"));
		element.click();
		element.sendKeys("Audi");
		element.click();

		element = driver.findElement(By.id("model"));
		element.sendKeys("Scooter");

		element = driver.findElement(By.id("cylindercapacity"));
		element.sendKeys("123");

		element = driver.findElement(By.id("engineperformance"));
		element.sendKeys("1234");

		element = driver.findElement(By.id("dateofmanufacture"));
		element.click();
		element.sendKeys("12/12/2020");

		element = driver.findElement(By.id("numberofseatsmotorcycle"));
		element.sendKeys("1");

		element = driver.findElement(By.id("listprice"));
		element.sendKeys("500");

		element = driver.findElement(By.id("annualmileage"));
		element.sendKeys("100");
		
		capturaTela.takeScreenShot(driver);

		element = driver.findElement(By.id("nextenterinsurantdata"));
		element.click();

		xPath = element.findElement(By.xpath("//*[@id=\"entervehicledata\"]/span"));
		resultAtual = xPath.getText();

		assertEquals(resultEsperado, resultAtual, "Preencha os campos necessários para prosseguir!");
	}

	@Test
	@DisplayName("TC003.001.3 - Preencher os campos de “Enter Insurant Data” com dados válidos e clicar no botão 'Next >>'")
	void testD() throws IOException {

		String resultEsperado = "0";
		String resultAtual;
		WebElement xPath;
		
		capturaTela.takeScreenShot(driver);

		element = driver.findElement(By.id("firstname"));
		element.sendKeys("Johnes");

		element = driver.findElement(By.id("lastname"));
		element.sendKeys("Thomas");

		element = driver.findElement(By.id("birthdate"));
		element.sendKeys("03/03/1996");

		element = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[4]/p/label[1]/span"));
		element.click();

		element = driver.findElement(By.id("streetaddress"));
		element.sendKeys("Av. Recife");

		element = driver.findElement(By.id("country"));
		element.click();
		element.sendKeys("Brazil");

		element = driver.findElement(By.id("zipcode"));
		element.sendKeys("50865030");

		element = driver.findElement(By.id("city"));
		element.sendKeys("Recife");

		element = driver.findElement(By.id("occupation"));
		element.click();
		element.sendKeys("Employee");

		element = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[5]/span"));
		element.click();
		
		capturaTela.takeScreenShot(driver);

		element = driver.findElement(By.id("nextenterproductdata"));
		element.click();

		xPath = element.findElement(By.xpath("//*[@id=\"enterinsurantdata\"]/span"));
		resultAtual = xPath.getText();

		assertEquals(resultEsperado, resultAtual, "Preencha os campos necessários para prosseguir!");
	}

	@Test
	@DisplayName("TC003.001.4 - Preencher os campos de “Enter Insurant Data” com dados válidos e clicar no botão 'Next >>'")
	void testE() throws IOException {

		String resultEsperado = "0";
		String resultAtual;
		WebElement xPath;
		
		capturaTela.takeScreenShot(driver);

		element = driver.findElement(By.id("startdate"));
		element.click();
		element.sendKeys("12/01/2021");

		element = driver.findElement(By.id("insurancesum"));
		element.sendKeys("3000000");

		element = driver.findElement(By.id("damageinsurance"));
		element.click();
		element.sendKeys("Full Coverage");

		element = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[4]/p/label[1]/span"));
		element.click();
		
		capturaTela.takeScreenShot(driver);

		element = driver.findElement(By.id("nextselectpriceoption"));
		element.click();

		xPath = element.findElement(By.xpath("//*[@id=\"enterproductdata\"]/span"));
		resultAtual = xPath.getText();

		assertEquals(resultEsperado, resultAtual, "Preencha os campos necessários para prosseguir!");
	}

	@Test
	@DisplayName("TC003.001.5 - Selecionar uma das 4 opções de plano na etapa “Select Price Option” e clicar no botão 'Next >>'")
	void testF() throws IOException {

		String resultEsperado = "0";
		String resultAtual;
		WebElement xPath;
		
		capturaTela.takeScreenShot(driver);

		element = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[4]/span"));
		element.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // setar um tempo para que o proximo elemento
																			// seja carregado (no caso o botão next)

		capturaTela.takeScreenShot(driver);
		
		element = driver.findElement(By.id("nextsendquote"));
		element.click();

		xPath = element.findElement(By.xpath("//*[@id=\"selectpriceoption\"]/span"));
		resultAtual = xPath.getText();

		assertEquals(resultEsperado, resultAtual, "Preencha o campo necessário para prosseguir!");
	}

	@Test
	@DisplayName("TC003.001.6 - Preencher os campos de “Send Quote” com dados válidos e clicar no botão 'Next >>'")
	void testG() throws IOException {

		String resultEsperado = "Sending e-mail success!";
		String resultAtual;
		WebElement xPath;
		
		capturaTela.takeScreenShot(driver);

		element = driver.findElement(By.id("email"));
		element.sendKeys("johnes_brasil10@hotmail.com");

		element = driver.findElement(By.id("phone"));
		element.sendKeys("81999999999");

		element = driver.findElement(By.name("Username"));
		element.sendKeys("Johnes");

		element = driver.findElement(By.id("password"));
		element.sendKeys("1234Jt");

		element = driver.findElement(By.id("confirmpassword"));
		element.sendKeys("1234Jt");

		element = driver.findElement(By.id("Comments"));
		element.sendKeys("Hello Selenium!");

		capturaTela.takeScreenShot(driver);
		
		element = driver.findElement(By.id("sendemail"));
		element.click();
		
		xPath = element.findElement(By.xpath("/html/body/div[4]/h2"));
		resultAtual = xPath.getText();

		assertEquals(resultEsperado, resultAtual, "Preencha o campo necessário para prosseguir!");
	}

	@AfterAll
	public static void terminate() throws InterruptedException, IOException {
		Thread.sleep(5000);
		capturaTela.takeScreenShot(driver);
		config.killAndCloseWebDriver();
	}
}