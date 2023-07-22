package tests.day03_practice;

import org.testng.annotations.Test;
import pages.HerokuappPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {

    /**
    // https://id.heroku.com/login sayfasına gidin

    // yanlıs email ve yanlıs password giriniz
    // (NOT: birden fazla yanlıs email ve password'u dataProvider kullanarak sırayla deneyin)

    // login butonuna tıklayınız

    // "There was a problem with your login." yazisinin gorunur oldugunu test edin

    // sayfayı kapatınız
     */


    @Test(dataProvider = "kullaniciListesi")
    public void negativeLoginDataProvider(String email, String password) {

        // https://id.heroku.com/login sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokuAppUrl"));


        // yanlıs email ve yanlıs password giriniz
        // (NOT: birden fazla yanlıs email ve password'u dataProvider kullanarak sırayla deneyin)
        HerokuappPage herokuappPage = new HerokuappPage();
        herokuappPage.emailBox.sendKeys(email);
        herokuappPage.passwordBox.sendKeys(password);





    }
}
