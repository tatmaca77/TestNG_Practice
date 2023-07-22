package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HerokuappPage {

    public HerokuappPage() {
        PageFactory.initElements(Driver.getDriver(),this);


        /**
         // https://id.heroku.com/login sayfasına gidin

         // yanlıs email ve yanlıs password giriniz
         // (NOT: birden fazla yanlıs email ve password'u dataProvider kullanarak sırayla deneyin)

         // login butonuna tıklayınız

         // "There was a problem with your login." yazisinin gorunur oldugunu test edin

         // sayfayı kapatınız
         */

    }

    // yanlıs email ve yanlıs password giriniz
    @FindBy (xpath = "//input[@type='email']")
    public WebElement emailBox;


    @FindBy (id = "password")
    public WebElement passwordBox;


    // login butonuna tıklayınız
    @FindBy (xpath = "//button[@type='submit']")
    public WebElement loginButton;


    // "There was a problem with your login." yazisinin gorunur oldugunu test edin
    @FindBy (xpath = "//div[@class='alert alert-danger']")
    public  WebElement alertText;


}
