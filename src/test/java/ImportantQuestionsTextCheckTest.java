import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.module.FindException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ImportantQuestionsTextCheckTest {
    private WebDriver driver;
    private final String answerText;
    private final int index;

    public ImportantQuestionsTextCheckTest(
            String answerText,
            int index
    )
    {
        this.answerText = answerText;
        this.index = index;

    }
    @Parameterized.Parameters

    public static Object[][] getSumData() {
        return new Object[][] {
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",1},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.",3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.",7}
        };
    }
    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void importantQuestionsTextCheck() {
        MainPage objMainPage = new MainPage(driver);
        String status = "true";
        //Открываем страницу
        objMainPage.openPage();
        //Нажать на кнопку кук
        objMainPage.clicOnCookieButton();
        //Идем до блока важных вопросов
        objMainPage.scrollToImportantQuestion();

        //клик по вопросу №1
        objMainPage.ImportantQuestion(index);
        //Проверить раскрылоcь ли пространство текста
        assertEquals(answerText, objMainPage.ImportantQuestion(index));


    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }

}
