import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class ImportantQuestionsTextCheckTestFirefox {
    private WebDriver driver;
    private final String firstAnswerText;
    private final String secondAnswerText;
    private final String thirdAnswerText;
    private final String fourthAnswerText;
    private final String fifthAnswerText;
    private final String sixthAnswerText;
    private final String seventhAnswerText;
    private final String eighthAnswerText;

    public ImportantQuestionsTextCheckTestFirefox(
            String firstAnswerText,
            String secondAnswerText,
            String thirdAnswerText,
            String fourthAnswerText,
            String fifthAnswerText,
            String sixthAnswerText,
            String seventhAnswerText,
            String eighthAnswerText
    )
    {
        this.firstAnswerText = firstAnswerText;
        this.secondAnswerText = secondAnswerText;
        this.thirdAnswerText = thirdAnswerText;
        this.fourthAnswerText = fourthAnswerText;
        this.fifthAnswerText = fifthAnswerText;
        this.sixthAnswerText = sixthAnswerText;
        this.seventhAnswerText = seventhAnswerText;
        this.eighthAnswerText = eighthAnswerText;
    }
    @Parameterized.Parameters

    public static Object[][] getSumData() {
        return new Object[][] {
                {       "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30",
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."
                },
        };
    }
    @Before
    public void setUp() {

        driver = new FirefoxDriver();
    }

    @Test
    public void ImportantQuestionsTextCheck() {
        MainPage objMainPage = new MainPage(driver);
        String status = "true";
        //Открываем страницу
        objMainPage.openPage();
        //Нажать на кнопку кук
        objMainPage.clicOnCookieButton();
        //Идем до блока важных вопросов
        objMainPage.scrollToImportantQuestion();

        //клик по вопросу №1
        objMainPage.clicFirstImportantQuestion();
        //Проверить раскрылоcь ли пространство текста
        String firstQuestionAreaStatus = objMainPage.checkAreaStatusFirstImportantQuestion();

        MatcherAssert.assertThat(firstQuestionAreaStatus, is(status));
        //Проверить текс на совпадение
        String firstAnswer = objMainPage.getFirstImportantAnswerText();
        MatcherAssert.assertThat(firstAnswer, containsString(firstAnswerText));

        //клик по вопросу №2
        objMainPage.clicSecondImportantQuestion();
        //Проверить раскрылоcь ли пространство текста
        String secondQuestionAreaStatus = objMainPage.checkAreaStatusSecondImportantQuestion();
        MatcherAssert.assertThat(secondQuestionAreaStatus, is(status));
        //проверить текс на совпадение
        String secondAnswer = objMainPage.getSecondImportantAnswerText();
        MatcherAssert.assertThat(secondAnswer, containsString(secondAnswerText));

        //клик по вопросу №3
        objMainPage.clicThirdImportantQuestion();
        //Проверить раскрылоcь ли пространство текста
        String thirdQuestionAreaStatus = objMainPage.checkAreaStatusThirdImportantQuestion();
        MatcherAssert.assertThat(thirdQuestionAreaStatus, is(status));
        //проверить текс на совпадение
        String thirdAnswer = objMainPage.getThirdImportantAnswerText();
        MatcherAssert.assertThat(thirdAnswer, containsString(thirdAnswerText));

        //клик по вопросу №4
        objMainPage.clicFourthImportantQuestion();
        //Проверить раскрылоcь ли пространство текста
        String fourthQuestionAreaStatus = objMainPage.checkAreaStatusFourthImportantQuestion();
        MatcherAssert.assertThat(fourthQuestionAreaStatus, is(status));
        //проверить текс на совпадение
        String fourthAnswer = objMainPage.getFourthImportantAnswerText();
        MatcherAssert.assertThat(fourthAnswer, containsString(fourthAnswerText));

        //клик по вопросу №5
        objMainPage.clicFifthImportantQuestion();
        //Проверить раскрылоcь ли пространство текста
        String fifthQuestionAreaStatus = objMainPage.checkAreaStatusFifthImportantQuestion();
        MatcherAssert.assertThat(fifthQuestionAreaStatus, is(status));
        //проверить текс на совпадение
        String fifthAnswer = objMainPage.getFifthImportantAnswerText();
        MatcherAssert.assertThat(fifthAnswer, containsString(fifthAnswerText));

        //клик по вопросу №6
        objMainPage.clicSixthImportantQuestion();
        //Проверить раскрылоcь ли пространство текста
        String sixthQuestionAreaStatus = objMainPage.checkAreaStatusSixthImportantQuestion();
        MatcherAssert.assertThat(sixthQuestionAreaStatus, is(status));
        //проверить текс на совпадение
        String sixthAnswer = objMainPage.getSixthImportantAnswerText();
        MatcherAssert.assertThat(sixthAnswer, containsString(sixthAnswerText));

        //клик по вопросу №7
        objMainPage.clicSeventhImportantQuestion();
        //Проверить раскрылоcь ли пространство текста
        String seventhQuestionAreaStatus = objMainPage.checkAreaStatusSeventhImportantQuestion();
        MatcherAssert.assertThat(seventhQuestionAreaStatus, is(status));
        //проверить текс на совпадение
        String seventhAnswer = objMainPage.getSeventhImportantAnswerText();
        MatcherAssert.assertThat(seventhAnswer, containsString(seventhAnswerText));

        //клик по вопросу №8
        objMainPage.clicEighthImportantQuestion();
        //Проверить раскрылоcь ли пространство текста
        String eighthQuestionAreaStatus = objMainPage.checkAreaStatusEighthImportantQuestion();
        MatcherAssert.assertThat(eighthQuestionAreaStatus, is(status));
        //проверить текс на совпадение
        String eighthAnswer = objMainPage.getEighthImportantAnswerText();
        MatcherAssert.assertThat(eighthAnswer, containsString(eighthAnswerText));

    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

}
