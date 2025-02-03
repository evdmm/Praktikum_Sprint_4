package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPage {

    private final WebDriver driver;

    //Локаторы
    //Кнопка Заказать
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы
    //Нажать на кнопку Заказать
    public void clickOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        driver.findElement(orderButton).click();
    }
}
