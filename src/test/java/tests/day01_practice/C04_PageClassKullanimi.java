package tests.day01_practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_PageClassKullanimi {

    /**
    // facebook anasayfaya gidin
// kullanıcı email kutusuna rastgele bir isim yazın
// kullanıcı sifre kutusuna rastgele bir password yazın
// giris yap butonuna tıklayın
// Lütfen bu hesabı bir başka şekilde tanımla, gorunur oldugunu test edin
// sayfayı kaptın
     */

    @Test
    public void test01() {
        // facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        // Cookies kapat
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.cookies.click();


        // kullanıcı email kutusuna rastgele bir isim yazın
        facebookPage.emailBox.sendKeys("facebookEmail");


        // kullanıcı sifre kutusuna rastgele bir password yazın
        facebookPage.passwordBox.sendKeys("facebookPassword");


        // giris yap butonuna tıklayın
        facebookPage.loginButton.click();


        // Lütfen bu hesabı bir başka şekilde tanımla, gorunur oldugunu test edin
        Assert.assertTrue(facebookPage.wrongPasswordText.isDisplayed());


        // sayfayı kaptın
        Driver.closeDriver();


    }
}
