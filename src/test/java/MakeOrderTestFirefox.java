import jdk.jfr.Label;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class MakeOrderTestFirefox {
    private final String name;
    private final String surname;
    private final String address;
    private final String telephone;
    private final String data;
    private final String textFromHeader;
    private WebDriver driver;

    public MakeOrderTestFirefox(String name, String surname, String address, String telephone,
                                String data, String textFromHeader ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.data = data;
        this.textFromHeader = textFromHeader;
    }

        @Parameterized.Parameters

        public static Object[][] getSumData() {
            return new Object[][] {
                    { "Иван", "Иванов", "ул. Ленина д.5","+79999999999","01.11.2023","Заказ оформлен"},
                    { "Петр", "Петров", "ул. Тленина д.5","+79999999999","01.11.2023","Заказ оформлен"},
            };
        }
  @Before
   public void setUp() {
      driver = new FirefoxDriver();
  }
    @Test
    public void MakeOrderFirefoxTopOrderButton() {
        //Создать Page Object для Main page для работы
        MainPage objMainPage = new MainPage(driver);
        //Создать Page Object для OrderModalOne для работы
        OrderModalOneForWhom objOrderModalOne = new OrderModalOneForWhom(driver);
        //Создать Page Object для ModalTwoForWhom для работы
        OrderModalTwoAboutRent objOrderModalTwo = new OrderModalTwoAboutRent(driver);
        //Создать Page Object для OrderModalThree для работы
        OrderModalThreeWantToPlaceOrder objOrderModalThree = new OrderModalThreeWantToPlaceOrder(driver);
        //Создать Page Object для OrderModalThree для работы
        OrderModalFourthPlacedOrder objOrderModalFourth = new OrderModalFourthPlacedOrder(driver);

        //открыть страницу
        objMainPage.openPage();
        //Нажать на кнопку кук
        objMainPage.clicOnCookieButton();
        //Нажать на кнопку "Заказать" в хедере
        objMainPage.clicOnMakeOrderTop();
        //Дождаться пока загрузится страница
        objOrderModalOne.waitForLoadHeader();
        //перейти на главную страницу
        objMainPage.openPage();
        // Нажать на кнопку "Заказать" в блоке "Как это работает"
        objMainPage.clicOnMakeOrderBot();
        //Дождаться пока загрузится страница
        objOrderModalOne.waitForLoadHeader();
        //Заполнить поле "* Имя"
        objOrderModalOne.setName(name);
        //Заполнить полe "* Фамилия"
        objOrderModalOne.setSurname(surname);
        //Заполнить поле "* Адрес: куда привезти заказ"
        objOrderModalOne.setAddress(address);
        //Заполнить поле "* Станция метро"
        objOrderModalOne.setMetroStation();
        //Заполнить поле "* Телефон: на него позвонит курьер"
        objOrderModalOne.setTelephone(telephone);
        //Нажать на кнопку "Далее"
        objOrderModalOne.clickOnNextButton();
        //Проверить что страница ModalTwoForWhom загрузилась
        objOrderModalTwo.waitForLoadHeader();
        //Заполнить поле "* Когда привезти самокат"
        objOrderModalTwo.setWhenBringScooter(data);
        //Заполнить поле "* Срок аренды"
        objOrderModalTwo.setRentalPeriod();
        //Нажать на кнопку "Заказать"
        objOrderModalTwo.clicOnMakeOrderButton();
        //Проверить что страница OrderModalThree загрузилась
        objOrderModalThree.waitTilWantToMakeOrder();
        //Нажать на кнопку "Да"
        objOrderModalThree.clicYesButton();
        //Проверить что страница загрузилась
        objOrderModalFourth.waitForLoadHeader();

        //Проверить что текст совпадает Заказ оформлен
        String headerText = objOrderModalFourth.getHeaderText();
        MatcherAssert.assertThat(headerText, containsString(textFromHeader));
    }

   @After
   public void teardown() {
        // Закрой браузер
       driver.quit();
   }

}
