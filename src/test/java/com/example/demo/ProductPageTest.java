package com.example.demo;


import pages.ProductPage;
import com.codeborne.selenide.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.*;
;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductPageTest {
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

    @Test
    public void testClickWriteButton() {
        productPage.clickToStoreButton();
        sleep(1000);
        String expectedLoginPageUrl = "https://vk.com/login";
        String currentUrl = url();
        assert currentUrl.contains(expectedLoginPageUrl);
    }

    @Test
    public void testCompareButtonTexts() {
        // Получите тексты кнопок из ProductPage.
        String writtenButtonText = productPage.WrittenButton.getText();
        String toStoreButtonText = productPage.ToStoreButton.getText();
        String followButtonText = productPage.FollowButton.getText();
        assertEquals("Написать", writtenButtonText, "Текст кнопки WrittenButton не соответствует ожиданиям.");
        assertEquals("Перейти в магазин", toStoreButtonText, "Текст кнопки ToStoreButton не соответствует ожиданиям.");
        assertEquals("Подписаться", followButtonText, "Текст кнопки FollowButton не соответствует ожиданиям.");
    }

    @Test
    public void testPhotoPresence() {
        productPage.PhotoPlaceSmall.shouldBe(visible);
        productPage.PhotoPlaceBig.shouldBe(visible);
    }

    @Test
    public void testLikeButtonColor() {
        productPage.clickLikeButton();
        productPage.LikeButton.shouldHave(Condition.cssValue("color", "#ff5c5c"));
    }

    @Test
    public void testButtonColor() {
        productPage.clickIconButton();
        productPage.IconButton.shouldHave(Condition.cssValue("color", "#828282"));
    }

    @Test
    public void checkItemCategory() {
        Assertions.assertEquals("бесплатно", productPage.getItemPrice());
    }

    @Test
    public void checkCopyLinkButton() {
        productPage.getCopiedLink();
        String copiedLink = clipboard().getText();
        String actualLink = "https://vk.com/club225299895?w=product-225299895_10044406";

        Assertions.assertEquals(actualLink, copiedLink);
    }
}
