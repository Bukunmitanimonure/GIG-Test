package gigTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Booking {
		WebDriver driver;
	@BeforeTest
	//lauch chrome browser
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\GIG\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.gigm.com/");
		driver.manage().window().maximize();
	}

	//select arival and departure details
	@Test(priority=1)
	public void bookTicket() throws InterruptedException {
//		driver.findElement(By.xpath("(//span[@id='mClose'])[2]")).click();
		Thread.sleep(3000);
		WebElement departureField = driver.findElement(By.xpath("//div[@id='bookBusWidget']/div[2]/div/div/div/span/span/span/span[2]/b"));
		departureField.click();
		WebElement departureState = driver.findElement(By.xpath("//option[contains(text(),'Lagos => Iyana Ipaja')]"));
		departureState.click();
		Thread.sleep(4000);
		WebElement arrivalField =driver.findElement(By.xpath("//select[@id='ContentPlaceHolder2_ddlto']"));
		arrivalField.click();
		WebElement arrivalState = driver.findElement(By.xpath("//option[contains(text(),'Akwa Ibom-Uyo')]"));
		arrivalState.click();
		Thread.sleep(2000);
		WebElement date = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtdepart']"));
		date.click();
		WebElement day = driver.findElement(By.xpath("//td[@class='day'][contains(text(),'26')]"));
		day.click();
		Thread.sleep(4000);
		WebElement seat = driver.findElement(By.xpath("//select[@id='ContentPlaceHolder2_ddltickets']"));
		seat.click();
		WebElement noSeat = driver.findElement(By.xpath("//div[contains(@class,'form-group col-md-1 col-sm-1 col-xs-12 small-inputs')]//option[1]"));
		noSeat.click();
		WebElement bookBtn =driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_Button1']"));
		bookBtn.click();
		Thread.sleep(10000);
	}
	
	//select seat
	@Test(priority=2)
	public void selectSeat() throws InterruptedException {
		WebElement viewSeat = driver.findElement(By.xpath("//div[@class='row ng-scope']//div[1]//div[1]//div[1]//div[5]//button[1]"));
		viewSeat.click();
		Thread.sleep(2000);
		WebElement seatNo = driver.findElement(By.xpath("//div[@class='a12 add-pad-left bus-back ng-scope']//span[@class='seatsselect ng-binding bus-available'][contains(text(),'11')]"));
		seatNo.click();
		WebElement continueBtn = driver.findElement(By.xpath("//a[@id='ContentPlaceHolder2_lvbus_lnkbook_0']"));
		continueBtn.click();
		Thread.sleep(2000);
		WebElement skipLogin =driver.findElement(By.linkText("Continue without Login"));
		skipLogin.click();
		Thread.sleep(2000);
	}
	
	//enter personal details and payment
	@Test(priority=3)
	public void passengerDetails() throws InterruptedException {
		WebElement pickUp = driver.findElement(By.xpath("//input[@id='pickupNo']"));
		pickUp.click();
		Thread.sleep(2000);
		WebElement nameField = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtFullname1']"));
		nameField.sendKeys("Bukunmi Tanimonure");
		Thread.sleep(2000);
		Select gender = new Select(driver.findElement(By.id("ContentPlaceHolder2_ddlgender1")));
		gender.selectByVisibleText("Female");
		WebElement emailField=driver.findElement(By.id("ContentPlaceHolder2_txtemail1"));
		emailField.sendKeys("bukunmitanimonure@gmail.com");
		     
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	    WebElement phoneField=driver.findElement(By.id("ContentPlaceHolder2_txtphone1"));
	    phoneField.sendKeys("08133543495");
	    WebElement kinName=driver.findElement(By.id("ContentPlaceHolder2_txtnextofkin1"));
	    kinName.sendKeys("gbenga");
	    WebElement kinPhone=driver.findElement(By.id("ContentPlaceHolder2_txtnextofkinphone1"));
	    kinPhone.sendKeys("09067568764");
	    Thread.sleep(4000);

	    WebElement unionBankUssd=driver.findElement(By.xpath("//*[@id=\"lnkbtnUbnUssd2\"]/img"));
	    unionBankUssd.click();
	    
	    Thread.sleep(4000);
	}
	
	//close browser
	@AfterTest
	public void closeBrowser() {
		driver.close();

	}
}


