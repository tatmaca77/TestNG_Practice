package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage(){

        PageFactory.initElements(Driver.getDriver() , this);
    }

        /** C01_PagesClassKullanimi */

    // dropdown'dan "Computers" optionunu secin
    @FindBy(xpath = "//select")
    public WebElement ddm;

    // arama kutusuna "Asus" yazıp aratın
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement aramaKutusu ;

    // ikinci urunun fotografını cekin
    @FindBy(xpath = "(//img[@class='s-image'])[2]")
    public WebElement ikinciUrun ;


        /** C02_Raporlama */

    // sonuc yazisinin "Java" icerdigini test edin
    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisi;


    



}




