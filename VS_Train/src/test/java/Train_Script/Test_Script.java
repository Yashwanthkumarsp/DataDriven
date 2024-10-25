package Train_Script;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import POM_Script.Element_Address;

public class Test_Script {

	@Test(dataProvider = "VSTrain")
	public void train(String Email, String Password, String Name, String Description) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://vsapi.unifynow.ai/dashboard");
		Element_Address train = new Element_Address(driver);
		train.EmailData(Email);
		train.PwdData(Password);
		train.LogButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[.='Test']"))));
		train.Selectfolder();
		train.Projectcard();
		train.Trainpage();
		train.Name(Name);
		train.Description(Description);
		train.Epoch(Keys.chord(Keys.CONTROL, "a"));
		train.Epoch(Keys.chord(Keys.DELETE));
		Faker faker = new Faker();
		int epoch = faker.number().numberBetween(10, 15);
		train.Epoch(String.valueOf(epoch));
		Thread.sleep(500);
		try {
			train.Starttrain();
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//div[.='Project Train is commenced']"))));
			driver.quit();
		} catch (Exception e) {
			System.out.println("Train is not started.");
			driver.quit();
		}
	}

	@DataProvider(name = "VSTrain", parallel = true)
	public Object[][] testinglogin() throws EncryptedDocumentException, IOException {
		return DataDriven_Script.training("Train_Data");
	}
}
