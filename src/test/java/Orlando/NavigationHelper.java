package Orlando;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Orlando.BaseTest.driver;


public class NavigationHelper implements ProjectConfig {

    final static int IMPLICIT_WAIT = 60;
    final static int PAGA_LOAD_TIMEOUT = 30;
    //final static int WEBDRIVER_WAIT = 100;
    WebElement dynamicElement;


    public void myImplicitWait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    public void myPageLoadTimeout(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(PAGA_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    public static  void login( String url,String tenant, String username, String password) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.findElement(By.className("tenant")).sendKeys(tenant);
        driver.findElement(By.className("username")).sendKeys(username);
        driver.findElement(By.className("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Log In']")).sendKeys(Keys.ENTER);

    }

    public void openProject(String projectName) {
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(@href, '" + projectName + "'  )]")).click();
    }

    public void buttonHandle(){
        myImplicitWait(driver);
//        dynamicElement = (new WebDriverWait(driver, WEBDRIVER_WAIT)
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@value, 'Continue'  )]"))));
        driver.findElement(By.xpath("//input[contains(@value, 'Continue'  )]")).click();
    }

    public void selectReportFolder(String reportFolder) {
        myImplicitWait(driver);
//        dynamicElement = (new WebDriverWait( driver, WEBDRIVER_WAIT)
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), '" + reportFolder + "'  )]"))));
        driver.findElement(By.xpath("//div[contains(text(), '" + reportFolder + "'  )]")).click();
    }

    public void selectDatasetid(String datasedID) {
        myImplicitWait(driver);
        handleprogressBar();
//        dynamicElement = (new WebDriverWait(driver, WEBDRIVER_WAIT)
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@oid= '" + datasedID + "' ]/.."))));
        driver.findElement(By.xpath("//td[@oid = '" + datasedID + "' ]/..")).click();
    }

    public void selectReportid(String reportID) {
        myImplicitWait(driver);
        handleprogressBar();
//        dynamicElement = (new WebDriverWait(driver,WEBDRIVER_WAIT)
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[(@oid =  '" + reportID + "'  )]/.."))));
        driver.findElement(By.xpath("//td[(@oid =  '" + reportID + "'  )]/..")).click();
    }

    public void handleprogressBar()  {
        while (true) {
            String progressBar = driver.findElement(By.className("mstrWaitBox")).getCssValue("visibility");
            if (progressBar.equals("hidden")) {
                break;
            }
        }
    }

    public String readValue(String element) {
        return  driver.findElement(By.xpath("//td[contains(@class, '" + element + "'  )]")).getText();
    }

    public  void addAttribute (String attributeID) throws InterruptedException {
        WebElement ele;
        ele =  driver.findElement(By.xpath("//span[(@title =  '" + attributeID + "'  )]"));
        Actions action = new Actions(driver);
        action.doubleClick(ele);
        action.perform();
    }

    public void drillDown (String drillCell) {
        myImplicitWait(driver);
        handleprogressBar();
//        dynamicElement = (new WebDriverWait(driver, WEBDRIVER_WAIT)
//                .until(ExpectedConditions.presenceOfElementLocated(By.linkText(drillCell))));
        handleprogressBar();
        driver.findElement(By.linkText(drillCell)).click();
    }

    public String getValueFromSummaryBeforeDrill () throws IOException {

        String drillMetricValue = null;
        handleprogressBar();
        List<WebElement> TRCollection = driver.findElement(By.xpath(".//*[@id='table_UniqueReportID']/tbody")).findElements(By.tagName("tr"));

        for (WebElement Tr : TRCollection) {
                List<WebElement> TDCollection = Tr.findElements(By.tagName("td"));

                for (int i = 0; i <TDCollection.size() ; i++) {
                    if ((TDCollection.get(i)).getText().equals(getCellForDrill())) {
                        drillMetricValue=(TDCollection.get(i+1)).getText();
                    }
                }
            }
        return  drillMetricValue;
    }

    public String getIntegerValueFromDetail() {
        String text = driver.findElement(By.className("toolbar-static-text")).getText();
        return text.trim().substring(text.trim().lastIndexOf(" ")+1);
    }

    public boolean readElementName(String element) {
        myImplicitWait(driver);
        return driver.findElement(By.xpath("//span[contains(@title, '" + element + "'  )]")).isDisplayed();
    }

    public boolean readElementName_detailed(String element) {
        myImplicitWait(driver);

//        dynamicElement = (new WebDriverWait(driver, WEBDRIVER_WAIT)
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@title, '" + element + "'  )]"))));
        return driver.findElement(By.xpath("//span[contains(@title, '" + element + "'  )]")).isDisplayed();
    }

}
