package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

/**
 * Created by jcan on 04/03/2015.
 */
public class DesafioBlog {
    static WebDriver driver;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver", "C:/Users/jcan/Downloads/selenium tools/chromedriver.exe");
//        driver = new ChromeDriver();
    }

    @Test
    public void testeDesafio(){
        driver.navigate().to("http://qalab.com.br/site/desafio-blog");
        WebElement nome = driver.findElement(By.id("nome"));
        WebElement email = driver.findElement(By.id("email"));
        nome.sendKeys("jose");
        email.sendKeys("qalab.com.br");
        driver.switchTo().frame(driver.findElement(By.id("frameTest")));
        WebElement radioButton = driver.findElement(By.id("Field0_2"));
        radioButton.click();
//        driver.findElement(By.xpath("//span[2]/input")).click();
        Select dropDown = new Select(driver.findElement(By.id("Field1")));
        dropDown.selectByVisibleText("Two good friends");
        WebElement comments = driver.findElement(By.id("Field4"));
        comments.sendKeys("Ola QAlab");
        WebElement botaoSubmit = driver.findElement(By.id("saveForm"));
        botaoSubmit.click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
