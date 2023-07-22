package tests.day03_practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

    @DataProvider
    public static Object[][] kullaniciListesi() {

        Object[][] kullaniciBilgileri = {{ConfigReader.getProperty("wrongEmail"), ConfigReader.getProperty("wrongPassword")},
                {ConfigReader.getProperty("wrongEmail2"), ConfigReader.getProperty("wrongPassword2")},   // Congigrurations.properties icine yanlis email ve passsword ekleyip cagirabiliriz.
                {ConfigReader.getProperty("wrongEmail3"), ConfigReader.getProperty("wrongPassword3")}};

        return kullaniciBilgileri;
    }


    @Test(dataProvider = "kullaniciListesi")
    public void negativeLoginDataProvider(String email, String password) {

        // https://id.heroku.com/login sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokuAppUrl"));


        // yanlıs email ve yanlıs password giriniz
        // (NOT: birden fazla yanlıs email ve password'u dataProvider kullanarak sırayla deneyin)
        HerokuappPage herokuappPage = new HerokuappPage();
        herokuappPage.emailBox.sendKeys(email);
        herokuappPage.passwordBox.sendKeys(password);


        // login butonuna tıklayınız
        herokuappPage.loginButton.click();


        // "There was a problem with your login." yazisinin gorunur oldugunu test edin
        Assert.assertTrue(herokuappPage.alertText.isDisplayed());


        // sayfayı kapatınız
        Driver.closeDriver();





    }
}
