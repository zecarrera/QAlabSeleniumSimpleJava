package com.company;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSetup {
    private static WebDriver driver;
    private static String baseUrl = "http://www.qalab.com.br";

    public static void main(String[] args) {
	// write your code here
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.quit();
    }

}
