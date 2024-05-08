package tests;

import com.codeborne.selenide.Configuration;
import com.example.demo.pages.pages.pages.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;


////Тут так же не для зарегистрированнонго




public class UnauthorizedMainPageTest {
    MainPage mainPage = new MainPage();
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895");
    }
    @DisplayName("Тест на соответствие надписей на кнопках")
    @Test
    public void testButtonTextsComparison(){
        assertEquals("Подписаться",mainPage.getItemSubscribe(), "Текст кнопки Subscribe не соответствует ожиданиям.");
        assertEquals("Показать все 1", mainPage.getItemShowAll(), "Текст кнопки ShowAll не соответствует ожиданиям.");
    }
    @DisplayName("Тест на редирект кнопки показать все")
    @Test
    public void testShowAllRedirect(){
        mainPage.showAllButton.scrollTo();
        mainPage.clickShowAllButton();
        sleep(1000);
        String expectedLoginPageUrl = "https://vk.com/uslugi-225299895?screen=group";
        String currentUrl = url();
        assert currentUrl.contains(expectedLoginPageUrl);
    }
    @DisplayName("Тест открытие окна подробная информация")
    @Test
    public void testMoreInfoRedirect(){
        mainPage.moreInfoButton.scrollTo();
        mainPage.clickMoreInfoButton();
        sleep(1000);
        String expectedLoginPageUrl = "https://vk.com/club225299895?w=club225299895";
        String currentUrl = url();
        assert currentUrl.contains(expectedLoginPageUrl);
    }
    @DisplayName("Тест на наличие фото")
    @Test
    public void testPhotoPresence() {
        mainPage.productPhoto.shouldBe(visible);
        mainPage.publicPhoto.shouldBe(visible);
        mainPage.headPhoto.shouldBe(visible);
    }
    @DisplayName("Тест на переключение между вкладками 'Все записи' и 'Записи сообщества'")
    @Test
    public void testTabSwitching(){
        mainPage.communityPostButton.scrollTo();
        mainPage.allPostButton.shouldHave(cssClass(".ui_tab_sel"));
        mainPage.communityPostButton.shouldNotHave(cssClass(".ui_tab_sel"));
        mainPage.clickCommunityPostButton();
        mainPage.allPostButton.shouldNotHave(cssClass(".ui_tab_sel"));
        mainPage.communityPostButton.shouldHave(cssClass(".ui_tab_sel"));
    }
}
