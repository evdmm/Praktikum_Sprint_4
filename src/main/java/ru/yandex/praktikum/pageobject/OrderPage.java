package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    private final WebDriver driver;

    //Локаторы
    //Форма заказа Для кого самокат
    private final By personalDataForm = By.xpath(".//div[@class='Order_Form__17u6u']");
    //Поле Имя
    private final By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    //Поле Фамилия
    private final By secondNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле Адресс
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле Станция метро
    private final By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Поле Номер телефона
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private final By continueButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Форма заказа Про аренду
    private final By aboutRentForm = By.xpath(".//div[@class='Order_Form__17u6u']");
    //Поле Когда привезти самокат
    private final By deliveryDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By deliveryDate = By.xpath(".//div[@aria-label='Choose суббота, 1-е февраля 2025 г.']");
    //Датапикер
    private final By datePicker = By.xpath(".//div[@class='react-datepicker-popper']");
    //Поле Срок аренды
    private final By rentalPeriodField = By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    //Выпадающий список Срок аренды
    private final By rentalPeriodDropdown = By.xpath(".//div[@class='Dropdown-menu']");
    //Поле Цвет самоката
    private final By scooterColourField = By.xpath(".//input[@class='Checkbox_Input__14A2w' and @id='black']");
    //Поле Цвет самоката
    private final By commentToCourierField = By.xpath(".//input[@placeholder ='Комментарий для курьера']");
    //Кнопка Заказать
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы
    //Ожидание формы заказа Для кого самокат
    public void waitPersonalDataForm() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(personalDataForm));
    }
    //Ввести имя
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    //Ввести фамилию
    public void enterSecondName(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }
    //Ввести адрес доставки
    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    //Выбрать станцию метро
    public void selectMetroStation(String metroStationId) {
        driver.findElement(metroStationField).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//li[@data-index=" + "'" + metroStationId + "'" + "]")));
        driver.findElement(By.xpath(".//li[@data-index=" + "'" + metroStationId + "'" + "]")).click();
    }
    //Ввести номер телефона
    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    //Нажать на кнопку Далее
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
    //Ожидание формы заказа Про аренду
    public void waitAboutRentForm() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(aboutRentForm));
    }
    //Выбрать дату доставки
    public void selectDeliveryDate(String deliveryDate) {
        driver.findElement(deliveryDateField).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(datePicker));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class, 'react-datepicker__day--" + deliveryDate + "')]")));
        driver.findElement(By.xpath(".//div[contains(@class, 'react-datepicker__day--" + deliveryDate + "')]")).click();
    }
    //Выбрать срок аренды
    public void selectRentalPeriod(String rentalPeriod) {
        driver.findElement(rentalPeriodField).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(rentalPeriodDropdown));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='Dropdown-option' and text()=" + "'" + rentalPeriod + "'" + "]")));
        driver.findElement(By.xpath(".//div[@class='Dropdown-option' and text()=" + "'" + rentalPeriod + "'" + "]")).click();
    }
    //Выбрать цвет самоката
    public void selectScooterColour(String scooterColour) {
        driver.findElement(By.xpath(".//input[@class='Checkbox_Input__14A2w' and @id=" + "'" + scooterColour + "'" + "]")).click();
    }
    //Ввести комментарий для курьера
    public void enterCommentToCourier(String commentToCourier) {
        driver.findElement(commentToCourierField).sendKeys(commentToCourier);
    }
    //Нажать на кнопку Заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }



}

