package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImportantQuestionsPage {

    private final WebDriver driver;

    public ImportantQuestionsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы
    //Получить ответ на вопрос
    public String getAnswerToQuestion(String questionNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='accordion__heading-" + questionNumber + "']")));
        driver.findElement(By.xpath(".//div[@id='accordion__heading-" + questionNumber + "']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='accordion__panel-" + questionNumber + "']")));
        return driver.findElement(By.xpath(".//div[@id='accordion__panel-" + questionNumber + "']")).getText();
    }
}
