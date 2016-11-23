package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public interface NavigationHelper {

    default void login(String url, String tenant, String username, String password) {
        getDriver().get(url);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().findElement(By.className("tenant")).sendKeys(tenant);
        getDriver().findElement(By.className("username")).sendKeys(username);
        getDriver().findElement(By.className("password")).sendKeys(password);
        getDriver().findElement(By.xpath("//input[@value='Log In']")).sendKeys(Keys.ENTER);

    }

    default void openProject(String projectName) {
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //getDriver().findElement(By.cssSelector (projectName)).click();
        getDriver().findElement(By.xpath("//a[contains(@href, '" + projectName + "'  )]")).click();
    }

    default void selectReportFolder(String reportFolder) {
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement dynamicElement = (new WebDriverWait( getDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), '" + reportFolder + "'  )]"))));
        //getDriver().findElement(By.cssSelector(reportFolder)).click();
        getDriver().findElement(By.xpath("//div[contains(text(), '" + reportFolder + "'  )]")).click();
    }

    default void selectDatasetid(String datasedID) {
        handleprogressBar();
        WebElement dynamicElement = (new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@oid= '" + datasedID + "' ]/.."))));
        getDriver().findElement(By.xpath("//td[@oid = '" + datasedID + "' ]/..")).click();
    }

    default void selectReportid(String reportID) {
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        handleprogressBar();
        WebElement dynamicElement = (new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[(@oid =  '" + reportID + "'  )]/.."))));
        getDriver().findElement(By.xpath("//td[(@oid =  '" + reportID + "'  )]/..")).click();
    }

    default void handleprogressBar() {
        while (true) {
            String progressBar = getDriver().findElement(By.className("mstrWaitBox")).getCssValue("visibility");
            if (progressBar.equals("hidden"))
                break;
        }

    }

    WebDriver getDriver();


//    openFolder()
//    openReport()


}
