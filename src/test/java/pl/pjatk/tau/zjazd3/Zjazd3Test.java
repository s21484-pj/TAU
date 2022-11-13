package pl.pjatk.tau.zjazd3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Zjazd3Test {

    private WebDriver driver;

    @BeforeEach
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void clean() {
        driver.close();
        driver.quit();
    }

    @Test
    public void check_mouse_price_test() throws InterruptedException {
        // wejscie na strone komputronika
        driver.get("https://www.komputronik.pl/");

        // wpisanie "myszka" w oknie wyszukiwarki
        WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div[2]/ktr-header-autocomplete/div/form/div/input"));
        String input = "myszka";
        element.sendKeys(input);
        element.submit();

        Thread.sleep(2000);
        // zatwierdzenie ciastek
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
        // wybranie konkretnej myszki
        driver.findElement(By.xpath("//*[@id=\"products-list\"]/div[4]/div[7]/ul/li[4]/div[1]/div[1]/a")).click();
        // sprawdza cene myszki
        String price = driver.findElement(By.xpath("//*[@id=\"p-inner-prices\"]/div/span/span")).getText();

        assertThat("54,90zł", is(price));
        String url = "https://www.komputronik.pl/product/309154/logitech-m171-czarna.html";
        assertThat(url, is(driver.getCurrentUrl()));
    }

    @Test
    public void login_to_pjatk_test() throws InterruptedException {
        // wejscie na strone planu zajec pjatk
        driver.get("https://planzajec.pjwstk.edu.pl/Logowanie.aspx");

        Thread.sleep(2000);
        String login = "admin";
        String password = "admin";

        // wpisanie loginu
        WebElement element = driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_Login1_UserName\"]"));
        element.sendKeys(login);
        // wpisanie hasla
        element = driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_Login1_Password\"]"));
        element.sendKeys(password);
        // wcisniecie zaloguj
        driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_Login1_LoginButton\"]")).click();
        // pobiera komunikat o nieudanym logowaniu
        String error = driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_Login1\"]/tbody/tr/td/table/tbody/tr[4]/td")).getText();

        assertThat("Błędny login lub hasło. Spróbuj ponownie.", is(error));
        String url = "https://planzajec.pjwstk.edu.pl/Logowanie.aspx";
        assertThat(url, is(driver.getCurrentUrl()));
    }
}
