package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
/**
 POM(Page Object Model)
 Test senaryolarının daha az kod ile yazılmasına ve bakımının daha kolay yapılmasına
 olanak sağlayan yazılım test yöntemidir. "TestNG" de ve "CUCUMBER" da "POM" kalıbını kullanırız.
 */

/**  SingletonPattern = Tekli Kullanım  */

public class Driver {

    private Driver(){
        /**             SingletonPattern = Tekli Kullanım
         Driver class'ından obje oluşturmanın önüne geçmek için
         default constructor'ı private yaparak bunun önüne geçebiliriz.
         Bu uygulamaya "singleton patter" denir.

         Object olusturmak istemiyoruz cünkü karisikliga sebebiyet vermemk icin.
         */
    }

    static WebDriver driver;
    public static WebDriver getDriver() {  /** Methodlari static yapariz diger Class'larda sadece method ismi ile cagirmak icin. */
        /**
         Driver'i her çağırdığımızda yeni bir pencere açılmasının önüne geçmek için
         if bloğu içinde Eğer driver'a değer atanmamışsa değer ata, eğer değer atanmışsa
         Driver'i aynı sayfada return et.
         */


        /**
         .properties dosyasina key degeri olarak browser ve degerini asagida olusturdugumuz switch-case ' lerden birsini
         seceriz ve sectigimiz driver calisir.
         */

        if (driver == null){ // --> Driver'a deger atanmamissa
            switch (ConfigReader.getProperty("browser")){
                case "chrome":                                        // Key degeri eger chrome ise burayi calistir.
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":                                         // Browser'i belirledik. !!!!!!
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();      // Testlerin baska browser'larda ne sonuc veriyor test etmek gerekebilir.
                    driver = new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();      // Testlerin baska browser'larda ne sonuc veriyor test etmek gerekebilir.
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }
    public static void closeDriver(){
        if (driver != null){ //-->driver'a değer ATANMIŞSA, yani bos degilse
            driver.close();
            driver = null; //-->driver'ı kapattıktan sonra boşalt
        }

    }
    public static void quitDriver(){
        if (driver != null){ //-->driver'a değer ATANMIŞSA
            driver.quit();
            driver = null; //-->driver'ı kapattıktan sonra boşalt
        }
    }

}

