package tests.day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C03_SoftAssert extends TestBase {

    /**
    // "https://amazon.com" sayfasına gidiniz
    /// Title'in "Amazon" icerdigini test edin
    /// Arama kutusunun erisilebilir oldugunu test edin
    // Arama kutusuna nutella yazıp aratın
    /// Sonuc yazısının gorunur oldugunu test edin
    /// Sonuc yazısının "Nutella" icerdigini test edin

    // test islemlerini softAssert ile yapınız ve hatalar icin mesaj versin
     */

    @Test
    public void test01() {
        // "https://amazon.com" sayfasına gidiniz
        driver.get("https://amazon.com");


        /// Title'in "Amazon" icerdigini test edin
        SoftAssert softAssert = new SoftAssert();
        String amazonTitle = driver.getTitle();
        softAssert.assertTrue(amazonTitle.contains("RAmazon1"),"Title Amazon icermiyor...");

        /**
        SoftAssert Objesi olusturmaliyiz. Cünkü SoftAssert static degildir, instance'dir.
         */


        /// Arama kutusunun erisilebilir oldugunu test edin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(searchBox.isEnabled(), "Arama kutusuna erisilemiyor...");



        // Arama kutusuna nutella yazıp aratın
        searchBox.sendKeys("Nutella" + Keys.ENTER);



        /// Sonuc yazısının gorunur oldugunu test edin
        WebElement resultText = driver.findElement(By.xpath("(//div[@class='sg-col-inner']//div)[1]"));
        softAssert.assertTrue(resultText.isDisplayed(),"Sonuc yazisi görünmüyor...");



        /// Sonuc yazısının "Nutella" icerdigini test edin
        softAssert.assertTrue(resultText.getText().contains("Nutella"),"Sonuc yazisi Nutella icermiyor...");


        // Sarelle iceriyor mu dogrula
        softAssert.assertTrue(resultText.getText().contains("Sarelle"),"Sonuc yazisi Sarelle icermiyor..." +
                resultText.getText());


        softAssert.assertAll();

        /**
           assertAll(); tüm hatalari listelemesini istemeliyiz. Eger kullanmazsak sonunda bunu hata vermez.
         */


        System.out.println("tolga");

        /**
        Hata ile karsilastigi icin assertAll(); dan sonraki kodlari görmez yani calistirmaz.
        Sout islemini konsolda yazdirmaz.

        Ama eger yukaridaki kodlarda hata olmasaydi hersey normal olsaydi bu sefer kendisinden sonraki kodlari
        görür yani calistirir.
        Sout islemini yapar konsola Tolga yazardi.
         */


        /*
        Junit'de assert kullandigimizda Assert Failed oldugu anda test calistirmayi durduruyordu ve geri kalan kodlari
        calistirmiyordu.

        TestNG'de ; hem Assert, hem de SoftAssert yapilari vardir.

        Test sonuna kadar calissin, testin sonunda tüm hatalari listelesin mesaj versin istiyorsak SoftAssert kullaniriz.

        SoftAssert'un hata bulsa bile calismaya devam etme özelligi  softAssert.assertAll();'a kadardir.

        Eger  softAssert.assertAll()'da hata bulunursa calisma durur ve Class'in kalan kismi calismaz.

         */

    }
}
