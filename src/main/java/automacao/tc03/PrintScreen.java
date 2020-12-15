package automacao.tc03;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class PrintScreen {
	
	static private int id;

	public void takeScreenShot(WebDriver driver) throws IOException {
		File scrFile;
		String pathScreen = "./src/test/resources/screenshots/";		

		scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);			
		FileUtils.copyFile(scrFile, new File(pathScreen + "imagem" + gerarId() + ".png"));	
	}
	
	private int gerarId() {
		return ++id;
	}
}
