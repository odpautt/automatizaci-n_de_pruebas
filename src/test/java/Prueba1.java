import com.sun.javafx.runtime.SystemProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Prueba1 {

    WebDriver driver = new ChromeDriver();

    @Test
    void deberiaIniciarSesionCuandoEnvioCredencialesValidas() {

        driver.get("https://www.saucedemo.com/");

        WebElement usuario = driver.findElement(By.xpath("//input[@id='user-name']"));
        usuario.sendKeys("standard_user");
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginBtn= driver.findElement(By.id("login-button"));
        loginBtn.click();

        WebElement tituloProductos = driver.findElement(By.xpath("//span[contains(.,'Products')]"));


        Assertions.assertEquals(tituloProductos.getText(), "PRODUCTS");

    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}

