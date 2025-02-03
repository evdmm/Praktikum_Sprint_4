package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookiePage {

    private final WebDriver driver;

    //Локаторы
    //Кнопка Принять куки
    private final By acceptCookieButton = By.id("rcc-confirm-button");

    public CookiePage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы
    //Принять куки
    public void clickAcceptCookieButton() {
        driver.findElement(acceptCookieButton).click();
    }
}
