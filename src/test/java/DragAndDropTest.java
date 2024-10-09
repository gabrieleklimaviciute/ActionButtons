import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragAndDropTest {
    @Test
    void dragAndDrop() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        driver.manage().window().maximize();

        WebElement draggable = driver.findElement(new By.ByCssSelector("#draggable b"));
        WebElement droppable = driver.findElement(new By.ByCssSelector("#droppable p"));

        Actions action = new Actions(driver);
        action.dragAndDrop(draggable, droppable).perform();

        WebElement changedText = driver.findElement(By.xpath("//div[@id='droppable']/p/b"));
        String expectedText = "Dropped!";
        String actualText = changedText.getText();
        assertEquals(expectedText, actualText, "Text should be: " + expectedText);

        WebElement colorField = driver.findElement(By.id("droppable"));
        String backgroundColor = colorField.getCssValue("background-color");
        assertEquals("rgba(97, 109, 179, 1)", backgroundColor);

        colorField = driver.findElement(new By.ByCssSelector("div[id=droppable] p"));
        backgroundColor = colorField.getCssValue("background-color");
        assertEquals("rgba(244, 89, 80, 1)", backgroundColor);
    }
}
