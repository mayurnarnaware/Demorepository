package demoPackage1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class HandleSSLCerts {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions handleSSL = new ChromeOptions();
		handleSSL.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(handleSSL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/sliders/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		WebElement element =  driver.findElement(By.xpath("//div[@id='red']//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		actions.clickAndHold(element).moveByOffset(-100, 0).release().perform();
	}

}
