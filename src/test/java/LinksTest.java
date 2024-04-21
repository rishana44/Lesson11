import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
public class LinksTest {
    @Test(description = "Открыть сайт")
    public static void firstTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        String searchText = "Most Popular";

        driver.get("https://litecart.stqa.ru/en/");//переход по ссылке
//driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//div[@id='box-most-popular']/*"));
        Assert.assertEquals(element.getText(), searchText);

        driver.quit();
    }

    @Test(description = "Переход по ссылке Rubber Ducks")
    public static void linkFirst() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        String searchText = "Rubber Ducks";
        driver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/");
        WebElement element = driver.findElement(By.xpath("//*[@id='box-category']/*[@class='title']"));
        Assert.assertEquals(element.getText(), searchText);

        driver.quit();
    }
    @Test(description = "Переход по ссылке Subcategory")
    public static void linkSecond() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        String searchText2 = "Subcategory";
        driver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/");;
        WebElement element2 = driver.findElement(By.xpath("//*[@id='box-category']//*[@class='title']"));
        Assert.assertEquals(element2.getText(), searchText2);

        driver.quit();
    }
    @Test(description = "Переход по синей утке")
    public static void click() throws InterruptedException {
        String imageSource = "Blue Duck";

        WebDriver driver = new ChromeDriver();

        driver.get("https://litecart.stqa.ru/en/");
        driver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
//driver.manage().window().maximize();
        WebElement blueDuck = driver.findElement(By.xpath("//li[@class='product column shadow hover-light']/*[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/blue-duck-p-4']"));//находим нужный элемент
        Actions click = new Actions(driver);//создаём экземпляр класса
        click.click(blueDuck).perform();//perform запускает запуск
        WebElement duckBlue = driver.findElement(By.xpath("//div[@id='box-product']//*[@class='title']"));
        Assert.assertEquals(duckBlue.getText(), imageSource);

        driver.quit();
    }
    @Test(description = "Написать текст в окне")
    public static void sendText() throws InterruptedException {

        String someInput = "aaa";

        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.xpath("//*[@name='query']")).sendKeys(someInput);
        Actions builder = new Actions(driver);
        Assert.assertEquals(someInput, someInput);

        driver.quit();
    }
}