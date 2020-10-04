package ru.gosuslugi;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.*;

public class TestS {
    private static final String url = "jdbc:mysql://localhost:3306/world";
    private static final String user = "root";
    private static final String password = "12340000";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    @Test
    public void testSt() {
        System.setProperty("webdriver.chrome.driver", "/Users/solnysko/Downloads/chromedriver2");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.gosuslugi.ru/");
        driver.findElement(By.cssSelector("[placeholder=\"Введите название услуги или ведомства\"]")).click();
        driver.findElement(By.cssSelector("[placeholder=\"Введите название услуги или ведомства\"]")).sendKeys("Изменение регистрационных данных в связи с переходом права собственности (купли-продажи)");
        driver.findElement(By.cssSelector("[class=\"btn-base medium search\"")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-href=\"https://www.gosuslugi.ru/10059/12\"]")));
        System.out.println("Test closed");
        driver.quit();
    }
}
