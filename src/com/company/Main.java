package com.company;


import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;


public class Main {
    private static WebDriver driver;
    private static String baseUrl = "http://www.qalab.com.br";

    public static void main(String[] args) {
	// write your code here
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.quit();
    }


    @Test
    public void clicarLupaEDigitarTexto(){
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        WebElement iconeBusca = driver.findElement(By.className("icon-search-2"));
        iconeBusca.click();
        WebElement textFieldBusca = driver.findElement(By.id("s"));
        textFieldBusca.sendKeys("selenium");
        driver.quit();
    }

    @Test
    public void verificarLinkFaleConosco(){
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        WebElement linkFaleConosco = driver.findElement(By.linkText("Fale conosco"));
        System.out.println(linkFaleConosco.getText());
        driver.quit();
    }

    @Test
    public void capturarAlturaELargura(){
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        WebElement imgCursoSelenium = driver.findElement(By.xpath("//img[@alt='Automação de Testes com Selenium WebDriver']"));
        System.out.println(imgCursoSelenium.getAttribute("height"));
        System.out.println(imgCursoSelenium.getAttribute("width"));
        driver.quit();
    }


    @Test
    public void exemploDropdown(){
        driver = new FirefoxDriver();
        driver.get("https://classedetestes.wordpress.com/formulario-completo/");
        Select dropdownEstado = new Select(driver.findElement(By.id("g22-estado")));
        dropdownEstado.selectByVisibleText("Pernambuco");
        driver.quit();
    }

    @Test
    public void exemploCheckbox(){
        driver = new FirefoxDriver();
        driver.get("https://classedetestes.wordpress.com/formulario-completo/");
        WebElement checkboxRSS = driver.findElement(By.name("g22-assinarfeedrss"));
        if (!checkboxRSS.isSelected()){
            checkboxRSS.click();
       }
        driver.quit();
    }


    @Test
    public void verificarTituloHomePage(){
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        assertThat(driver.getTitle(), is("QALab | Consultoria e Treinamentos em Qualidade de Software"));
        driver.quit();
    }

    @Test
    public void verificarTituloResultadoBusca(){
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        WebElement iconeBusca = driver.findElement(By.className("icon-search-2"));
        iconeBusca.click();
        WebElement textFieldBusca = driver.findElement(By.id("s"));
        textFieldBusca.sendKeys("selenium");
        textFieldBusca.sendKeys(Keys.RETURN);

        WebElement tituloPagResultados = driver.findElement(By.tagName("h1"));
        assertThat(tituloPagResultados.getText(), containsString("selenium"));
        driver.quit();
    }

    @Test
    public void navegarChrome(){
        File file = new File("C:\\Users\\jcan\\Downloads\\selenium tools\\chromedriver.exe"); // set driver path
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driverChrome = new ChromeDriver();
        driverChrome.get("http://www.google.com");
        driverChrome.quit();

    }
    /*
    WebElement searchTitle = driver.findElement(By.id("resultsHeader"));
    /*Exemplos do assertThat*/
    /*
    assertThat(searchTitle.getText(), is("Titulo da pagina"));
    assertThat(searchTitle.getText(), equalToIgnoringCase("teste"));
    assertThat(searchTitle.getText(),containsString("selenium"));
    assertThat(searchTitle.isDisplayed(),is(true));
    assertThat(searchTitle.getText(), not(containsString("erro")));
    assertThat(searchTitle.getAttribute("color"), either(containsString("474747")).or(containsString("94c55a")));
    */
}
