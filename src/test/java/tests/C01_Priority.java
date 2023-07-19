package tests;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_Priority extends TestBase {

/**
// amazon isimli bir test methodu olusturunuz. Ve amazona gidiniz
    // bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz
    // techproeducation isimli bir test methodu olusturunuz. Ve techproeducation'a gidiniz

    // once techproeducation, sonra amazon, sonra bestbuy test methodu calısacak sekilde sıralama yapınız
 */


@Test(priority = -2)
public void amazon() {
    driver.get("https://amazon.com/");

}


    // bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz
    @Test
    public void bestbuy() {
        driver.get("https://bestbuy.com/");

    }


    // techproeducation isimli bir test methodu olusturunuz. Ve techproeducation'a gidiniz
    @Test(priority = -5)
    public void techproeducation() {
        driver.get("https://techproeducation.com/");

    }
    /**
    TestNG, test methodlarini isim sirasina göre calistirir.
    Eger isim siralamasinin disinda bir sekilde calistirmak isterseniz; o zaman Test methodlarina
    öncelik yani ( priority ) tanimlayabiliriz.

     priority kucukten buyuge göre calisir. Eger bir Test methoduna priority degeri atanmamissa default olarak
     priority = 0 olarak kabul edilir.
     */

}
