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
import java.util.*;
//package jdbc;

public class TestS {
    private static final String url = "jdbc:mysql://localhost:3306/world";
    private static final String user = "root";
    private static final String password = "12340000";//"root";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    @Test
    public void testSt() {
  /*      String query = "select count(*) from books";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total number of books in the table : " + count);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { / *can't do anything * / }
            try { stmt.close(); } catch(SQLException se) { / *can't do anything * / }
            try { rs.close(); } catch(SQLException se) { / *can't do anything * / }
        }
*/
        System.setProperty("webdriver.chrome.driver", "/Users/solnysko/Downloads/chromedriver2");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.gosuslugi.ru/");
    //    WebElement search = driver.findElement(By.className("searchBox page-searchBox"));
        driver.findElement(By.cssSelector("[placeholder=\"Введите название услуги или ведомства\"]")).click();//sendKeys("Изменение регистрационных данных в связи с переходом права собственности (купли-продажи)");
        driver.findElement(By.cssSelector("[placeholder=\"Введите название услуги или ведомства\"]")).sendKeys("Изменение регистрационных данных в связи с переходом права собственности (купли-продажи)");
    //    driver.findElement(By.cssSelector("[placeholder=\"Введите название услуги или ведомства\"]")).sendKeys("MEM");
        driver.findElement(By.cssSelector("[class=\"btn-base medium search\"")).click();
        //Assert.assertTrue((driver.findElement(By.cssSelector("[ng-href=\"https://www.gosuslugi.ru/10059/12\"]")).equals("ng-href=\"https://www.gosuslugi.ru/10059/12\"")));
       // WebElement links = driver.findElement(By.linkText("[ng-href=\"https://www.gosuslugi.ru/10059/12\"]"));
//        Assert.assertTrue("df", "df");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[ng-href=\"https://www.gosuslugi.ru/10059/12\"]")));
        System.out.println("Test closed");
        driver.quit();
    }
}
