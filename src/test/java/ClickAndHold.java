import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClickAndHold {

    @Test
    public void ClickAndHoldTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        driver.manage().window().maximize();

        WebElement clickBox = driver.findElement(By.id("click-box"));
        Actions actions = new Actions(driver);

        String backgroundColor = clickBox.getCssValue("background-color");
        assertEquals("rgba(0, 0, 0, 1)", backgroundColor);
        assertEquals("Click and Hold!", clickBox.getText());

        actions.clickAndHold(clickBox).perform();

        clickBox = driver.findElement(By.id("click-box"));
        backgroundColor = clickBox.getCssValue("background-color");
        assertEquals("rgba(0, 255, 0, 1)", backgroundColor);
        assertEquals("Well done! keep holding that click now.....", clickBox.getText());


    }
}
