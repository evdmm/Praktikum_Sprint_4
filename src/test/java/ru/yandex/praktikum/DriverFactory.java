package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private WebDriver driver;

    public void initDriver() throws Exception {
        if ("firefox".equalsIgnoreCase(System.getProperty("browser"))) {
            startUpFirefox();
        } else {
            startUpChrome();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void startUpChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void startUpFirefox() {
        WebDriverManager.firefoxdriver().setup();
        var opts = new FirefoxOptions().configureFromEnv();
        driver = new FirefoxDriver(opts);
    }
}
