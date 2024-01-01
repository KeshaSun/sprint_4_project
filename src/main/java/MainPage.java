import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class MainPage {

    //Добавили поле driver
    private final WebDriver driver;
    private int index;


    //Добавили конструктор класса page object
    public MainPage(WebDriver driver) {
        this.driver = driver;// Инициализировали в нём поле driver
    }

    // Кнопка "Заказать" №1 в шапке
    private final By makeOrderTop = By.cssSelector(".Button_Button__ra12g");
    // Кнопка "Заказать" №2 в блоке "Как это работат"
    private final By makeOrderBot = By.cssSelector(".Home_FinishButton__1_cWm");

    private final By cookieButton = By.className("App_CookieButton__3cvqF");

    //Блок вопросов о важном;
    private final By ImportantQuestion = By.xpath(".//div[.='Вопросы о важном']");



    //Открыть страницу
    public void openPage(){
        // страница
        String URL = "https://qa-scooter.praktikum-services.ru/";
        driver.get(URL);
    }

    // Метод клика по кнопке "Заказать' №1 в шапке
    public void clicOnMakeOrderTop() {
        driver.findElement(makeOrderTop).click();
    }
    // Метод клика по кнопке "Заказать' №2 в шапке
    public void clicOnMakeOrderBot() {
            driver.findElement(makeOrderBot).click();
    }
    //Нажать на куку чтобы не мешала
    public void clicOnCookieButton() {
        driver.findElement(cookieButton).click();
    }

    //Скролл до блока вопросов о важном
    public void scrollToImportantQuestion() {
        WebElement element = driver.findElement(ImportantQuestion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
    }

    //Клик по кнопке вопросу №1
    public String ImportantQuestion(int index) {
        this.index = index;
        //Вопрос о важном 1
        final By importantQuestion = By.id("accordion__heading-"+index);
        //Ответ о важном 1
        final By importantAnswer = By.id("accordion__panel-"+index);
        driver.findElement(importantQuestion).click();
        return driver.findElement(importantAnswer).getText();
    }

}
