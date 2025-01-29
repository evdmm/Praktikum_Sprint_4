package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmOrderPage {

    private final WebDriver driver;

    //Локаторы
    //Форма подтверждения заказа Хотите оформить заказ?
    private final By confirmOrderForm = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    //Кнопка Да
    private final By confirmButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //Сообщение об успешном создании заказа
    private final By successfulOrderMessage = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    public ConfirmOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы
    //Подтверждение заказа
    public void confirmOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(confirmOrderForm));
        driver.findElement(confirmButton).click();
    }

    //Отображение сообщения об успешном создании заказа
    public void viewSuccessfulOrderMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(successfulOrderMessage));


    }



}
