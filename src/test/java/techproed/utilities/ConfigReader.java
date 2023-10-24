package techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    // Bu sınıf configuration.properties dosyasını okur
    // property file i okumak icin property i object i kullanilir.
    private static Properties properties;
// static block : ilk calisir
    static {
        // configuration dosyasının yolu
        String path ="configuration.properties";
        try {
            // Configuration.properties dosyası FileInputStream kullanılarak açılıyor
            FileInputStream fileInputStream = new FileInputStream(path);
          //  properties object ini instantiate ediyoruz
            properties = new Properties();
            // configuration.property dosyasindaki datalari yukler
            properties.load(fileInputStream);
            // dosyayı kapat
            fileInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // Bu yöntem özellikler dosyasından anahtarı alır ve değeri String olarak döndürür dosyayı okumak için bu yöntemi oluşturuyoruz
    public static String getProperty(String key){
       String value = properties.getProperty(key);
       return value;
    }
}
