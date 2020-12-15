package automacao.tc03;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class TC003_001_1_Abrir_Website {

	public String abrirSite(WebDriver driver) throws IOException {
		String retorno;
		PrintScreen capturaTela = new PrintScreen();
		
		driver.get("http://sampleapp.tricentis.com/101/index.php");
		
		capturaTela.takeScreenShot(driver);
		
		retorno = driver.getTitle();		
		return retorno;
	}
	
}
