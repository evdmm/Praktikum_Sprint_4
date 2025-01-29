package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.pageobject.*;
import org.junit.Assert;

import java.time.Duration;

@RunWith(Parameterized.class)
public class Orders {

    private final DriverFactory factory = new DriverFactory();

    private final String firstName;
    private final String secondName;
    private final String address;
    private final String metroStationId;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String rentalPeriod;
    private final String scooterColour;
    private final String commentToCourier;

    public Orders(String name, String secondName, String address, String metroStation, String phoneNumber, String deliveryDate, String rentalPeriod, String scooterColour, String commentToCourier) {
        this.firstName = name;
        this.secondName = secondName;
        this.address = address;
        this.metroStationId = metroStation;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.scooterColour = scooterColour;
        this.commentToCourier = commentToCourier;
    }

    //Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Михаил", "Евдокимов", "Комсомольская площадь, 2, Москва", "5", "+79871112233", "today", "сутки", "black", ""},
                {"Иван", "Иванов", "Ивантеевская ул., 32, корпус 1, Москва", "0", "+79874445566", "030", "трое суток", "grey", "Домофон не работает!"},
        };
    }

    @Before
    public void initDriver() throws Exception {
        factory.initDriver();
    }

    @Test
    public void checkMakeOrderWithHeader() throws InterruptedException {
        WebDriver driver = factory.getDriver();
        //Открыть сайт
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //Принять куки
        CookiePage cookiePage = new CookiePage(driver);
        cookiePage.clickAcceptCookieButton();
        //Нажать на кнопку Заказать
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOrderButton();
        //Дождаться отображения формы Для кого самокат
        OrderPage orderPage = new OrderPage(driver);
        orderPage.waitPersonalDataForm();
        //Ввести имя
        orderPage.enterFirstName(firstName);
        //Ввести фамилию
        orderPage.enterSecondName(secondName);
        //Ввести адрес доставки
        orderPage.enterAddress(address);
        //Выбрать станцию метро
        orderPage.selectMetroStation(metroStationId);
        //Ввести телефон
        orderPage.enterPhoneNumber(phoneNumber);

        Thread.sleep(5000);

        //Нажать на кнопку Далее
        orderPage.clickContinueButton();
        //Дождаться отображения формы Про аренду
        orderPage.waitAboutRentForm();
        //Выбрать дату доставки
        orderPage.selectDeliveryDate(deliveryDate);
        //Выбрать срок аренды
        orderPage.selectRentalPeriod(rentalPeriod);
        //Выбрать цвет самоката
        orderPage.selectScooterColour(scooterColour);
        //Добавить комментарий
        orderPage.enterCommentToCourier(commentToCourier);

        Thread.sleep(5000);

        //Нажать на кнопку Заказать
        orderPage.clickOrderButton();
        //Подтвердить заказ
        ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage(driver);
        confirmOrderPage.confirmOrder();
        //Проверка
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']")));
        Assert.assertTrue(driver.findElement(By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']")).isDisplayed());
    }

    @Test
    public void checkMakeOrderWithPage() throws InterruptedException {
        WebDriver driver = factory.getDriver();
        //Открыть сайт
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //Принять куки
        CookiePage cookiePage = new CookiePage(driver);
        cookiePage.clickAcceptCookieButton();
        //Нажать на кнопку Заказать
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButton();
        //Дождаться отображения формы Для кого самокат
        OrderPage orderPage = new OrderPage(driver);
        orderPage.waitPersonalDataForm();
        //Ввести имя
        orderPage.enterFirstName(firstName);
        //Ввести фамилию
        orderPage.enterSecondName(secondName);
        //Ввести адрес доставки
        orderPage.enterAddress(address);
        //Выбрать станцию метро
        orderPage.selectMetroStation(metroStationId);
        //Ввести телефон
        orderPage.enterPhoneNumber(phoneNumber);

        Thread.sleep(5000);

        //Нажать на кнопку Далее
        orderPage.clickContinueButton();
        //Дождаться отображения формы Про аренду
        orderPage.waitAboutRentForm();
        //Выбрать дату доставки
        orderPage.selectDeliveryDate(deliveryDate);
        //Выбрать срок аренды
        orderPage.selectRentalPeriod(rentalPeriod);
        //Выбрать цвет самоката
        orderPage.selectScooterColour(scooterColour);
        //Добавить комментарий
        orderPage.enterCommentToCourier(commentToCourier);

        Thread.sleep(5000);

        //Нажать на кнопку Заказать
        orderPage.clickOrderButton();
        //Подтвердить заказ
        ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage(driver);
        confirmOrderPage.confirmOrder();
        //Проверка
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ']")));
        Assert.assertTrue(driver.findElement(By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ']")).isDisplayed());
    }

    @After
    public void tearDown() {
        factory.getDriver().quit();
    }
}
