import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoverTest {
    @Test
    public void HoverTest() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement hoverFirst = driver.findElement(new By.ByCssSelector("div:nth-of-type(1) > .dropbtn"));
        actions.moveToElement(hoverFirst).perform();
        WebElement firstSubMenuElement = driver.findElement(new By.ByCssSelector("div:nth-of-type(1) > .dropdown-content > .list-alert"));
        String expectedFirstSubMenu = "Link 1";
        String actualFirstSubMenu = firstSubMenuElement.getText();
        assertEquals(expectedFirstSubMenu, actualFirstSubMenu, "First sub-menu element should be: " + expectedFirstSubMenu);

        WebElement hoverSecond = driver.findElement(new By.ByCssSelector("div:nth-of-type(2) > .dropbtn"));
        actions.moveToElement(hoverSecond).perform();
        WebElement secondSubMenuElement = driver.findElement(new By.ByCssSelector("div:nth-of-type(2) > .dropdown-content > .list-alert"));
        String expectedSecondSubMenu = "Link 1";
        String actualSecondSubMenu = secondSubMenuElement.getText();
        assertEquals(expectedSecondSubMenu, actualSecondSubMenu, "Second sub-menu element should be: " + expectedSecondSubMenu);


        WebElement hoverThird = driver.findElement(new By.ByCssSelector("div:nth-of-type(3) > .dropbtn"));
        actions.moveToElement(hoverThird).perform();
        WebElement thirdSubMenuElement = driver.findElement(new By.ByCssSelector("div:nth-of-type(3) > .dropdown-content > a:nth-of-type(1)"));
        String expectedThirdSubMenu = "Link 1";
        String actualThirdSubMenu = thirdSubMenuElement.getText();
        assertEquals(expectedThirdSubMenu, actualThirdSubMenu, "Third sub-menu element should be: " + expectedThirdSubMenu);
        WebElement fourthSubMenuElement = driver.findElement(new By.ByCssSelector(".dropdown-content > a:nth-of-type(2)"));
        String expectedFourthSubMenu = "Link 1";
        String actualFourthSubMenu = fourthSubMenuElement.getText();
        assertEquals(expectedFourthSubMenu, actualFourthSubMenu, "Fourth sub-menu element should be: " + expectedFourthSubMenu);


    }
}
