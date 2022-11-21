import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class mainTesting {
	private static final String EXPECTED_MODEL_3_PRICE_WITH_SAVINGS = "$40,390*";
	private static final String EXPECTED_MODEL_3_PERFORMANCE_PRICE_WITH_SAVINGS = "$56,390*";

	private static final String EXPECTED_MODEL_3_PRICE = "$46,990";
	private static final String EXPECTED_MODEL_3_PERFORMANCE_PRICE = "$62,990";

	public static WebDriverWait wait;

	public WebDriver driver;

	@BeforeMethod
	public void setPrecondition() throws InterruptedException {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofMillis(3000));

		driver.manage().window().maximize();
		driver.get("https://www.tesla.com/model3/design#overview");

		driver.get("https://www.tesla.com/model3/design#overview");
	}

	@Test
	public void checkingPriceWithSavings() throws InterruptedException {
		WebElement model3Price = driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div[2]/div[1]/div[1]/div/div/div[4]/fieldset/div[1]/div/div/div/div/div[1]/div/label/div/span[3]/p"));
		wait.until(ExpectedConditions.visibilityOf(model3Price));
		Assert.assertEquals(model3Price.getText(), EXPECTED_MODEL_3_PRICE_WITH_SAVINGS);
	}


	@Test
	public void checkingPerformancePriceWithSavings() throws InterruptedException {
		WebElement model3PerformancePrice = driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div[2]/div[1]/div[1]/div/div/div[4]/fieldset/div[2]/div/div/div[1]/div/div[1]/div/label/div/span[3]/p"));
		wait.until(ExpectedConditions.visibilityOf(model3PerformancePrice));
		Assert.assertEquals(model3PerformancePrice.getText(), EXPECTED_MODEL_3_PERFORMANCE_PRICE_WITH_SAVINGS);
	}

	@Test
	public void checkingPriceWithoutSavings() throws InterruptedException {
		List <WebElement> purchasePriceButton = driver.findElements(By.id("purchase_price"));

		purchasePriceButton.get(0).click();

		WebElement model3PriceWithoutSavings = driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div[2]/div[1]/div[1]/div/div/div[4]/fieldset/div[1]/div/div/div/div/div[1]/div/label/div/span[3]/p"));
		wait.until(ExpectedConditions.visibilityOf(model3PriceWithoutSavings));
		Assert.assertEquals(model3PriceWithoutSavings.getText(), EXPECTED_MODEL_3_PRICE);
	}

	@Test
	public void checkingPerformancePriceWithoutSavings() throws InterruptedException {
		List <WebElement> purchasePriceButton = driver.findElements(By.id("purchase_price"));

		purchasePriceButton.get(0).click();

		WebElement model3PerformancePriceWithoutSavings = driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div[2]/div[1]/div[1]/div/div/div[4]/fieldset/div[2]/div/div/div[1]/div/div[1]/div/label/div/span[3]/p"));
		wait.until(ExpectedConditions.visibilityOf(model3PerformancePriceWithoutSavings));
		Assert.assertEquals(model3PerformancePriceWithoutSavings.getText(), EXPECTED_MODEL_3_PERFORMANCE_PRICE);
	}

	@AfterMethod
	public void endOfTest() {
		driver.quit();
		driver = null;
	}
}
