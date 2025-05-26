package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class TestBase {

    public  WebDriver driver;
    private static Properties config = new Properties();

    public static void loadConfig() {
        try (FileInputStream input = new FileInputStream("src/test/resources/config.properties")) {
            config.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public  void initializeDriver() {
        loadConfig();

        String browser = config.getProperty("browser", "chrome").toLowerCase();
        String baseUrl = config.getProperty("baseUrl");

        switch (browser.toLowerCase()) {
            case "chrome":
                this.driver = new ChromeDriver();
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

    public  WebDriver getDriver() {
        return driver;
    }

    public  void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}


