package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    Assertion hardAssert = new Assertion();
    String baseurl = "https://rahulshettyacademy.com/client";

    @BeforeTest
    public void beforeTest() {

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(baseurl);

    }

    @AfterTest
    public void ShutDown() {
        driver.close();
    }

}

/*
    @AfterTest
    public void ShutDown() {
        driver.close();
    }
}*/
