package tests.day02_practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_Raporlama extends TestBaseRapor{

    /**
        // 'https://www.amazon.com' adresine gidin
        // arama kutusuna "Java" yazip aratın
        // sonuc yazisinin "Java" icerdigini test edin
        // kontrollu olarak yeni bir sayfa acın
        // yeni acılan sayfada "Kitap" aratın
        // sonuc yazisinin Kitap icerdigini test edin
        // sayfayı kapatınız

     // test raporu alınız

     */

        @Test
        public void test01() {

            extentTest = extentReports.createTest("Batch151","Amazonu test edebilmeli");
            // extentTest'e testname ve description degerlerini atamalıyız

            // 'https://www.amazon.com' adresine gidin
            Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
            extentTest.info("AMAZON SAYFASINA GİDİLDİ");

            // arama kutusuna "Java" yazip aratın
            AmazonPage amazonPage = new AmazonPage();
            amazonPage.aramaKutusu.sendKeys("Java" + Keys.ENTER);
            extentTest.info("ARAMA KUTUSUNA JAVA YAZIP ARATILDI");

            // sonuc yazisinin "Java" icerdigini test edin
            Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("Mava"));
            extentTest.pass("SONUC YAZISININ JAVA İCERDİGİ TEST EDİLDİ");

            // kontrollu olarak yeni bir sayfa acın
            Driver.getDriver().switchTo().newWindow(WindowType.TAB);
            extentTest.info("KONTROLLU YENİ SAYFA ACILDI");

            // yeni acılan sayfada "Kitap" aratın

            Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

            amazonPage.aramaKutusu.sendKeys("Kitap" + Keys.ENTER);
            extentTest.info("YENİ ACILAN SAYFADA KİTAP ARATILDI");

            // sonuc yazisinin Kitap icerdigini test edin

            Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("Kitap"));
            extentTest.pass("SONUC YAZISININ KİTAP İCERDİGİ TEST EDİLDİ");

            // sayfayı kapatınız
            Driver.closeDriver();

        }

}
