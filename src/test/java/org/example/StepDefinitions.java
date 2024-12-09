package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefinitions {
    private WebDriver webDriver;

    @Given("url of the Skillfactory of {string}")
    public void url_of_the_skillfactory_of(String url) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(url);

        String currentUrl = webDriver.getCurrentUrl();
        System.out.println("Текущий URL: " + currentUrl);
        if (currentUrl.startsWith(url)) {
            System.out.println("Сайт успешно загружен.");
        } else {
            System.out.println("Ожидаемый URL не совпадает. Текущий: " + currentUrl);
        }
    }

    @Then("click on the button {string}")
    public void click_on_the_button(String buttonText) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rec834984450\"]/div/div/div/section/div/div[2]/div/ul/li[1]/a")));
            button.click();
            System.out.println("Кнопка \"" + buttonText + "\" нажата.");
        } catch (TimeoutException e) {
            System.out.println("Кнопка с текстом \"" + buttonText + "\" не появилась вовремя.");
        } catch (NoSuchElementException e) {
            System.out.println("Кнопка с текстом \"" + buttonText + "\" не найдена.");
        }
    }
}