package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class TestBase {

    public WebDriver driver;
    public static Properties config = new Properties();

    public static void loadConfig() {
        try (FileInputStream input = new FileInputStream("src/test/resources/config.properties")) {
            config.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public void initializeDriver() {
        System.out.println("start initialize");
        loadConfig();

        String browser = config.getProperty("browser", "chrome").toLowerCase();
        String baseUrl = config.getProperty("baseUrl");

        switch (browser.toLowerCase()) {
            case "chrome":
                System.out.println("Chrome browser selected");
                ChromeOptions options = new ChromeOptions();
                options.addExtensions(new File("C:\\Users\\ncoopoosamy\\Downloads\\Stands AdBlocker - Chrome Web Store 2.1.46.0.crx"));
                this.driver = new ChromeDriver(options);

                break;
            case "firefox":
                this.driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}


