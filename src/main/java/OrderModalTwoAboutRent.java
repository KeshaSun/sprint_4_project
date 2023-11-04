import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderModalTwoAboutRent {
    //Добавили поле driver
    private final WebDriver driver;
    //Добавили конструктор класса page object
    public OrderModalTwoAboutRent(WebDriver driver) {
        this.driver = driver; // Инициализировали в нём поле driver
    }
    //Поле "Когда привезти самокат"
    private final By whenBringScooter = By.xpath(".//input[@placeholder ='* Когда привезти самокат']");
    //Поле "Срок Аренды"
    private final By rentalPeriod = By.className("Dropdown-placeholder");
    //Кнопка "Заказать"
    private final By makeOrderButton = By.xpath(".//div[2]/div[3]/button[2]");

    //Заполнить поле "Куда привезти самокат"
    public void setWhenBringScooter(String data) {
        driver.findElement(whenBringScooter).sendKeys(data, Keys.ENTER);
    }
    //Заполнить поле "Срок Аренды"
    public void setRentalPeriod() {
            driver.findElement(rentalPeriod).click();
            driver.findElement(By.xpath(".//div[1][@class = 'Dropdown-option']")).click();
    }
    //Нажать на кнопку "Заказать"
    public void clicOnMakeOrderButton() {
        driver.findElement(makeOrderButton).click();
    }
    //Ждать загрузки модала
    public void waitForLoadHeader() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(whenBringScooter));
    }
}
