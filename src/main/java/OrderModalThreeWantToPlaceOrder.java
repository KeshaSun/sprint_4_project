import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderModalThreeWantToPlaceOrder {
    //Добавили поле driver
    private final WebDriver driver;
    //Добавили конструктор класса page object
    public OrderModalThreeWantToPlaceOrder(WebDriver driver) {
        this.driver = driver; // Инициализировали в нём поле driver
    }
    //Заголовок модала
    private final By wantToMakeOrder = By.className("Order_ModalHeader__3FDaJ");

    //Кнопка "Да"
    private final By yesButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");
    //Нажать на кнопку "Да"
    public void clicYesButton() {
        driver.findElement(yesButton).click();
    }
    //Проверить что страница загрузилась
    public void waitTilWantToMakeOrder() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(wantToMakeOrder));
    }

}
