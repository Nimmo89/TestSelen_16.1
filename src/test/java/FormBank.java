import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.*;

public class FormBank {

    WebDriver driver;
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--disable-dev-shm-usage");
//    options.addArguments("--no-sandbox");
//    options.addArguments("--headless");
//    driver = new ChromeDriver(options);

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void shouldTestV1() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[name=name]")).sendKeys("Павел");
        driver.findElement(By.cssSelector("[name=phone]")).sendKeys("+79238456245");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.cssSelector("button")).click();
        String actualMessage = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        String expectedMessage = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expectedMessage, actualMessage.strip());
    }
}
