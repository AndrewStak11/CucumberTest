package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/scenarios", // Путь к .feature-файлам
        glue = "org.example",                     // Пакет с StepDefinitions
        plugin = {"pretty", "html:target/cucumber-report.html"} // Для отчетов
)
public class CucumberRunTest {
    // Этот класс используется только для запуска тестов
}
