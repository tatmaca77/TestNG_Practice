package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage() {

        PageFactory.initElements(Driver.getDriver(),this); // Bu Class'a Driver'i getir dedik. !!!!

    }

    // kullanıcı email kutusuna rastgele bir isim yazın
    @FindBy(xpath = "//input[@data-testid='royal_email']")
    public WebElement emailBox;


    @FindBy(xpath = "(//button[@value='1'])[3]")
    public WebElement cookies;


    // kullanıcı sifre kutusuna rastgele bir password yazın
    @FindBy(xpath = "//input[@id='pass']")
    public WebElement passwordBox;


    // giris yap butonuna tıklayın
    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginButton;


    // Lütfen bu hesabı bir başka şekilde tanımla, gorunur oldugunu test edin
    @FindBy(xpath = "(//h2[text()='Bitte identifiziere dieses Konto auf eine andere Art'])[2]")
    public WebElement wrongPasswordText;



}
