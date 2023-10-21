package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
// import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Amazon");
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//input[@class='gNO89b'])[1]")).click();
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("//h3[@class = 'LC20lb MBeuO DKV0Md']")).getText();
        if (text.equals("Amazon.in") || text.equals("Amazon.com")) {
            System.out.println("Amazon found in search result");
        } else {
            System.out.println("Amazon not found in search result");
        }
        System.out.println("end Test case: testCase01");
    }


}
