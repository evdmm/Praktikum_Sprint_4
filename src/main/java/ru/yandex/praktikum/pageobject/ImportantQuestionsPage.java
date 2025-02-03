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

    //Локаторы
    //Вопросы
    private final By question = By.id("accordion__heading-");
    private final String questionStr = "accordion__heading-";

    //Ответы
    private final By answer = By.id("accordion__panel-");
    private final String answerStr = "accordion__panel-";

    //Методы
    //Получить ответ на вопрос

    public String getAnswerToQuestion(String questionNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(questionStr + questionNumber)));
        driver.findElement(By.id(questionStr + questionNumber)).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(answerStr + questionNumber)));
        return driver.findElement(By.id(answerStr + questionNumber)).getText();
    }
}
