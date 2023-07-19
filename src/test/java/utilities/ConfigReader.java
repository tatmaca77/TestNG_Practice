package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /**  configuration.properties icindeki verileri cekebilmemiz okuyabilmemiz icin ConfigReader olusturduk. "fis"
     .properties uzantılı dosyaya erişebilmemiz için Properties class'ından obje oluşturmamız gerekir.
     bu oluşturduğumuz obje ile akışa aldığımız dosya yolunu load(fis) methodu ile properties dosyasındaki
     key değerini return edebiliriz.
     Bunu yapmak icin parametreli bir method olustururuz ve girdigimiz key'in degerini bize döndürür.
     */

    static Properties properties;
    static {
        try {
            FileInputStream fis = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(fis); // --> fis 'in okudugu bilgileri properties'e yükler.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty (String key) {

        return properties.getProperty(key); // --> String olarak girdigim key'in degerini return eder.
    }
}
