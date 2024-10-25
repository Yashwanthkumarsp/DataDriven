package POM_Script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Element_Address {
	// Declaration
	// Login To Vision Studio
	@FindBy(id = "Email")																			
	private WebElement Emailfield;

	@FindBy(id = "Password")
	private WebElement Passwordfield;

	@FindBy(id = "login-submit")
	private WebElement Loginbutton;

	@FindBy(xpath = "//img[@src='/images/vision-studio.png']")
	private WebElement VisionStudio;

	// Select Folder
	@FindBy(xpath = "//span[.='Test']") // -->If the folder name is changed, give the changed name.
	private WebElement SelectFolder;

	// Open Project Card
	@FindBy(xpath = "//h5[text()='Vehicle Detection']")
	private WebElement ProjectCard;

	// Train Page
	@FindBy(xpath = "//span[text()='Train']")
	private WebElement TrainPage;
	@FindBy(xpath = "//input[@name='name']")
	private WebElement Name;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement Description;

	@FindBy(xpath = "//input[@name='epoch']")
	private WebElement Epoch;

	@FindBy(xpath = "//p[text()='Start Training']")
	private WebElement StartTraining;

	// Initialization
	public Element_Address(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	// Login to Vision Studio
	public void EmailData(String Email) {
		Emailfield.sendKeys(Email);
	}

	public void PwdData(String Password) {
		Passwordfield.sendKeys(Password);
	}

	public void LogButton() {
		Loginbutton.click();
	}

	public void SelectVS() {
		VisionStudio.click();
	}

	// Select Folder
	public void Selectfolder() {
		SelectFolder.click();
	}

	// Open Project Card
	public void Projectcard() {
		ProjectCard.click();
	}

	// Train Page
	public void Trainpage() {
		TrainPage.click();
	}

	public void Name(String name) {
		Name.sendKeys(name);
	}

	public void Description(String description) {
		Description.sendKeys(description);
	}

	public void Epoch(String epochs) {
		Epoch.sendKeys(epochs);
	}

	public void Starttrain() {
		StartTraining.click();
	}
}
