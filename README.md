# MTTPP-Projekt
U svrhu projekta testirana je mobilna aplikacija za bacanje kockica za Jamb igru koju sam samostalno razvila u svrhu Android prakse. Aplikacija je napisana u programskom jeziku Kotlin te se korisničko sučelje sastoji od naslova, slika šest kockica i tri gumba. Za automatsko testiranje mobilne aplikacije koristi se Appium. 

## Testiranje
Nakon instaliranja i podešavanja svih varijabli i aplikacija potrebnih za automatsko testiranje, sljedeći korak je pisanje testova. Prvo je potrebno napisati POM.xml datoteku sa svim potrebnim ovisnostima (eng. dependency).

```
//POM.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>MTTPP</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId> io.appium </groupId>
            <artifactId> java-client </artifactId>
            <version> 7.4.1 </version>
        </dependency>
        <dependency>
            <groupId> org.testng </groupId>
            <artifactId> testng </artifactId>
            <version> 7.3.0 </version>
            <scope> test </scope>
        </dependency>
        <dependency>
            <groupId> org.apache.maven.plugins </groupId>
            <artifactId> maven-compiler-plugin </artifactId>
            <version> 3.8.1 </version>
            <type> maven-plugin </type>
        </dependency>
        <dependency>
            <groupId> org.apache.maven.plugins </groupId>
            <artifactId> maven-surefire-report-plugin </artifactId>
            <version> 3.0.0-M5 </version>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>LATEST</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId> org.apache.maven.plugins </groupId>
                <artifactId> maven-compiler-plugin </artifactId>
                <configuration>
                    <source> 1.8 </source>
                    <target> 1.8 </target>
                </configuration>
            </plugin>
            <plugin>
                <groupId> org.apache.maven.plugins </groupId>
                <artifactId> maven-surefire-plugin </artifactId>
                <version> 3.0.0-M5 </version>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile> testng.xml </suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
        </plugins>
    </build>

    <properties>
        <maven.compiler.source>15</maven.compiler.source>
        <maven.compiler.target>15</maven.compiler.target>
    </properties>

</project>
```

Nakon POM.xml datoteke potrebno je napisati testove, u ovom slučaju klasa se zove TestMobile. Prije pisanja samog testa, moraju se podesiti željene mogućnosti. Te mogućnosti su u ovom slučaju koji .apk se treba pokrenuti, verzija i ime emulatora, ime platforme i također je potrebno postaviti alat za automatsko testiranje Android aplikacija, odnosno Android Driver. Na Android Driver-u je pozvano implicitno čekanje od 10 sekundi za slučaj kada traženi element nije odmah dostupan. U samom testu je provjereno nalaze li se elementi na korisničkom sučelju. Pronalaženje elemenata se radi pomoću xpath-a koji je pronađen pomoću Appium Session-a. 
```
//TestMobile.java
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations. BeforeClass ;
import org.testng.annotations. Test ;


public class TestMobile {
    AndroidDriver driver ;

    @BeforeClass ()
    public void setUp() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability( "app" , "C:\\Users\\Selma\\AndroidStudioProjects\\DiceThrowingApp\\app\\build\\outputs\\apk\\debug\\app-debug.apk" );
        capabilities.setCapability( "VERSION" , "9.0" );
        capabilities.setCapability( "deviceName" , "emulator" );
        capabilities.setCapability( "platformName" , "Android" );
        driver = new AndroidDriver(new URL( "http://127.0.0.1:4723/wd/hub" ), capabilities);
        driver.manage().timeouts().implicitlyWait( 10 , TimeUnit. SECONDS );
    }

    @Test
    public void testCal() throws Exception {
        MobileElement e11= (MobileElement)
                driver.findElement(By.xpath ( "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView\n" ));
        e11.click();

        MobileElement e12= (MobileElement)
                driver.findElement(By.xpath ( "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[1]\n" ));
        e12.click();

        MobileElement e13= (MobileElement)
                driver.findElement(By.xpath ( "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button[1]\n" ));
        e13.click();

        MobileElement e14= (MobileElement)
                driver.findElement(By.xpath ( "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button[2]" ));
        e14.click();

        MobileElement e15= (MobileElement)
                driver.findElement(By.xpath ( "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button[3]" ));
        e15.click();

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
    }

    public void teardown(){
        driver .quit();
    }
}

```
Posljednja datoteka koja nam je potrebna za testiranje je testng.xml u kojoj se određuje ime testa te klasa koja se poziva. 

```
<?xml version ="1.0" encoding ="UTF-8"?>
        <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name ="AllTestsSuite">
    <test name ="Dice Rolling Test">
        <classes>
            <class name ="TestMobile"/>
        </classes>
    </test>
</suite>
```

Za generiranje izvještaja korištena je naredba: 
```
mvn test (Ctrl + Enter)
```
Testirana Android aplikacija i izvještaj o uspješnosti testova nalazi se u repozitoriju.
