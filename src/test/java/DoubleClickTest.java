import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleClickTest {

    @Test
    public void doubleClick() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        driver.manage().window().maximize();

        WebElement doubleClickBox = driver.findElement(By.id("double-click"));

        String backgroundColor = doubleClickBox.getCssValue("background-color");
        assertEquals("rgba(254, 196, 45, 1)", backgroundColor);

        Actions action = new Actions(driver);
        action.doubleClick(doubleClickBox).perform();

        backgroundColor = doubleClickBox.getCssValue("background-color");
        assertEquals("rgba(147, 203, 90, 1)", backgroundColor);


    }
}
