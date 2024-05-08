package tests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.example.demo.pages.pages.pages.ProductPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UnauthorizedProductPageTests{
    ProductPage productPage = new ProductPage();
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }
    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895?w=product-225299895_10044406");
    }
    @DisplayName("Тест на редирект с кнопки написать")
    @Test
    public void testClickWriteButton() {
        productPage.clickToStoreButton();
        sleep(1000);
        String expectedLoginPageUrl = "https://vk.com/login";
        String currentUrl = url();
        assert currentUrl.contains(expectedLoginPageUrl);
    }
    @DisplayName("Тест на редирект с кнопки подписаться")
    @Test
    public void testClickSubscribe(){
        productPage.clickSubscribeButton();
        String expectedLoginPageUrl = "https://vk.com/login";
        String currentUrl = url();
        assert currentUrl.contains(expectedLoginPageUrl);
    }
    @DisplayName("Тест на редирект с кнопки лайка")
    @Test
    public void testClickLike(){
        productPage.clickLikeButton();
        sleep(1000);
        String expectedLoginPageUrl = "https://vk.com/login";
        String currentUrl = url();
        assert currentUrl.contains(expectedLoginPageUrl);
    }
}

public class AuthorizedProductPageTests {

    ProductPage productPage = new ProductPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895?w=product-225299895_10044406");
    }
@DisplayName("Тест на соответствие надписям на кнопках")
    @Test
    public void testCompareButtonTexts() {
        assertEquals("Написать", productPage.getItemWritten(), "Текст кнопки WrittenButton не соответствует ожиданиям.");
        assertEquals("Перейти в магазин", productPage.getItemToStore(), "Текст кнопки ToStoreButton не соответствует ожиданиям.");
        assertEquals("Подписаться", productPage.getItemFollow(), "Текст кнопки FollowButton не соответствует ожиданиям.");
    }
@DisplayName("Тест на наличие фото")
    @Test
    public void testPhotoPresence() {
        productPage.photoPlaceSmall.shouldBe(visible);
        productPage.photoPlaceBig.shouldBe(visible);
    }

    @DisplayName("Тест цвета после нажатия лайка")
    @Test
    public void testButtonColor() {
        productPage.clickIconButton();
        productPage.iconButton.shouldHave(Condition.cssValue("color", "#828282"));
    }
    @DisplayName("Тест цвета после нажатие на добавить")
    @Test
    public void testLikeButtonColor() {
        productPage.clickLikeButton();
        productPage.likeButton.shouldHave(Condition.cssValue("color", "#ff5c5c"));
    }
@DisplayName("Тест на наличие и совместимости стоимости")
    @Test
    public void checkItemCategory() {
        Assertions.assertEquals("бесплатно", productPage.getItemPrice());
    }
@DisplayName("Тест на функциональность кнопки поделится")
    @Test
    public void checkCopyLinkButton() {
        productPage.getCopiedLink();
        String copiedLink = clipboard().getText();
        String actualLink = "https://vk.com/club225299895?w=product-225299895_10044406";

        Assertions.assertEquals(actualLink, copiedLink);
    }
}
