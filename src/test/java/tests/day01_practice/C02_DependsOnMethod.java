package tests.day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C02_DependsOnMethod  {

    /**
    // test01 isimli bir test methodu olusturunuz. Ve amazona gidiniz
    // test02 isimli bir test methodu olusturunuz. Ve arama motoruna "Nutella" Yazıp aratın
    // test03 isimli bir test methodu olusturunuz. Ve sonuc yazısının "Nutella" icerdigini test edelim


    // test02 isimli test methodunu, test01'e baglayınız.
    // test03 isimli test methodunu, test02'ye baglayınız.
     */

    static WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://amazon.com/");

    }                               // Eger test01 de bir hata yaparsak bagli oldugu test ignore olur ona bagli olanda ignore olur.

    @Test (dependsOnMethods = "test01")
    public void test02() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);
    }
    /**
    Sadece test02'yi calistirinca otomatik olarak bagli oldugu test01'de calismis oluyor.
     */

    @Test(dependsOnMethods = "test02")
    public void test03() {
        WebElement resultText = driver.findElement(By.xpath("(//div[@class='sg-col-inner']//div)[1]"));
        Assert.assertTrue(resultText.getText().contains("Nutella"));

    }
    /**
    DependsOnMethod = test methodlarinin calisma sirasina karismaz.
    Sadece bagli olan test baglandigi test'in sonucuna bakar.
    Eger baglandigi test passed olmazsa, baglanan test hic calismaz kendisini Ignore eder.
    */

}
