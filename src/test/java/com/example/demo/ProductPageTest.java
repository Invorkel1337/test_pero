package com.example.demo;


import com.codeborne.selenide.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.*;
;
import static com.codeborne.selenide.Selenide.*;

public class ProductPageTest {
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
    public void testClickWriteButton(){
        SelenideElement writtenButton = $(".MarketServiceButton__text");
        writtenButton.click();
        sleep(1000);
        SelenideElement chatMessage = $("#mail_box_editable");
        chatMessage.shouldHave(Condition.text("Здравствуйте!Меня заинтересовала эта услуга."));
    }
    @Test
    public void testButtonTest(){
        SelenideElement subscribeButton = $(".Button-module__root--enpNU.MarketItemCardShopInfo__buttonToggleSubscribeGroup.vkuiButton");
        subscribeButton.shouldHave(Condition.text("Подписаться"));
        SelenideElement goToStoreButton = $(".Button-module__root--enpNU.MarketItemCardShopInfo__buttonGoToShop.vkuiButton");
        goToStoreButton.shouldHave(Condition.text("Перейти в магазин"));
        SelenideElement writeButton = $(".Button-module__root--enpNU.vkuiButton");
        writeButton.shouldHave(Condition.text("Написать"));
    }
    @Test
    public void testPhotoPresence(){
        SelenideElement photo = $(".ItemGallery__main");
        photo.shouldBe(Condition.visible);
    }
    @Test
    public void testLikeButtonColor(){
        SelenideElement likeButton = $("._like_button_icon ");
        likeButton.click();
        likeButton.shouldHave(Condition.cssValue("color","#ff5c5c"));
    }
    @Test
    public void testButtonColor(){
        SelenideElement iconButton = $(".vkuiIcon.vkuiIcon--28.vkuiIcon--w-28.vkuiIcon--h-28.vkuiIcon--add_square_outline_28");
        iconButton.click();
        iconButton.shouldHave(Condition.cssValue("color","#828282"));
    }
}
