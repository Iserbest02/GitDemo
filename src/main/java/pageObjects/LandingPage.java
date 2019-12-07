package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver; // WebDriver is a interface

	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navigateBar = By.xpath("//*[@class='nav navbar-nav navbar-right']");

	public LandingPage(WebDriver driver) {
		// this is constructor
		this.driver = driver;
	}
	public WebElement getLogin() { // Webelement comes from selen
		return driver.findElement(signin);
	}
	public WebElement getNavigationBar() {
		return driver.findElement(navigateBar);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}

}
