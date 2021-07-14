package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    private String browser;


    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void start() {
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }else if(browser.equals(BrowserType.EDGE)){
            wd = new EdgeDriver();
        }
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://bootsnipp.com/login");
        login("inter1234@gmail.com", "Aa123123");
    }

    public void stop() {
        wd.quit();
    }



    public void openSite(String url){
        wd.get(url);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void login(String userName, String password) {
        click(By.xpath("//body/div[1]/div[1]/div[1]/form[1]/fieldset[1]/input[1]"));
        type(By.xpath("//body/div[1]/div[1]/div[1]/form[1]/fieldset[1]/input[1]"), userName);
        click(By.xpath("//body[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/input[2]"));
        type(By.xpath("//body[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/input[2]"), password);
        WebDriverWait wait = new WebDriverWait(wd, 25);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[1]/div[1]/form[1]/fieldset[1]/div[1]/label[1]/input[1]"))).click();
        click(By.xpath("//body/div[1]/div[1]/div[1]/form[1]/fieldset[1]/input[3]"));
    }
}
