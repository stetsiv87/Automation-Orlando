package demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import static demo1.OpenARAccounts_Test.driver;

public interface NavigationDriver {

    default void login(String url, String tenant, String username, String password) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.className("tenant")).sendKeys(tenant);
        driver.findElement(By.className("username")).sendKeys(username);
        driver.findElement(By.className("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Log In']")).sendKeys(Keys.ENTER);
    }

    default void openProject(String projectName) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //getDriver().findElement(By.cssSelector (projectName)).click();
        driver.findElement(By.xpath("//a[contains(@href, '" + projectName + "'  )]")).click();
    }

    default void buttonHandle(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement dynamicElement = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value, 'Continue'  )]"))));
        driver.findElement(By.xpath("//input[contains(@value, 'Continue'  )]")).click();
    }

    default void selectReportFolder(String reportFolder) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement dynamicElement = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), '" + reportFolder + "'  )]"))));
        //getDriver().findElement(By.cssSelector(reportFolder)).click();
        driver.findElement(By.xpath("//div[contains(text(), '" + reportFolder + "'  )]")).click();
    }

    default void  selectDatasetid(String datasedID) {
        handleprogressBar();
        WebElement dynamicElement = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@oid= '" + datasedID + "' ]/.."))));
        driver.findElement(By.xpath("//td[@oid = '" + datasedID + "' ]/..")).click();
    }

    default void selectReportid(String reportID) {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        handleprogressBar();
        WebElement dynamicElement = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[(@oid =  '" + reportID + "'  )]/.."))));
        driver.findElement(By.xpath("//td[(@oid =  '" + reportID + "'  )]/..")).click();
    }

    default String readValue(String element) {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        handleprogressBar();
      return  driver.findElement(By.xpath("//td[contains(@class, '" + element + "'  )]")).getText();
    }

    default void handleprogressBar() {
        while (true) {
            String progressBar = driver.findElement(By.className("mstrWaitBox")).getCssValue("visibility");
            if (progressBar.equals("hidden"))
                break;
        }

    }



}