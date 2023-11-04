import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderModalOneForWhom {
    //Добавили поле driver
    private final WebDriver driver;
    //Добавили конструктор класса page object
    public OrderModalOneForWhom(WebDriver driver) {
        this.driver = driver; // Инициализировали в нём поле driver
    }
    //Поле "Имя" арендатора
    private final By nameResponsibleField = By.xpath(".//div[2]/div[1]/input");
    //Поле "Фамилия" арендатора
    private final By surnameResponsibleField = By.xpath(".//div[2]/input");
    //Поле "Адрес"
    private final By addressResponsibleField = By.xpath(".//div[3]/input");
    //Поле "Станция Метро"
    private final By metroStationResponsibleField = By.className("select-search__input");
    private final By chooseMetroStationOne = By.xpath("//div[2]/ul/li[2]");
    //Поле "Телефон"
    private final By telephoneResponsibleField = By.xpath(".//div[5]/input");
    //Кнопка "Далее"
    private final By nextButton = By.xpath(".//div[2]/div[3]/button");
    //Заполнить поле "Имя"
    public void setName(String name) {
        driver.findElement(nameResponsibleField).sendKeys(name);
    }
    //Заполнить поле "Фамилия"
    public void setSurname(String surname) {
        driver.findElement(surnameResponsibleField).sendKeys(surname);
    }
    //Заполнить поле "Адресс"
    public void setAddress(String address) {
        driver.findElement(addressResponsibleField).sendKeys(address);
    }
    //Заполнить поле "Станция Метро"
    public void setMetroStation() {
        driver.findElement(metroStationResponsibleField).click();
        driver.findElement(chooseMetroStationOne).click();
    }

    //Заполнить поле "Телефон"
    public void setTelephone(String telephone) {
        driver.findElement(telephoneResponsibleField).sendKeys(telephone);
    }
    //Нажать на кнопку "Далее"
    public void clickOnNextButton(){
        driver.findElement(nextButton).click();
    }
    //Ждать загрузки сраницы "Для кого самокат"
    public void waitForLoadHeader() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(nameResponsibleField));
    }


}
