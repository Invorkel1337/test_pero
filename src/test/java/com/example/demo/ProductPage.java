package com.example.demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

// page_url = https://vk.com/club225299895?w=product-225299895_10044406
public class ProductPage {
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895?w=");
    }
    @Test
    public void testClickGroupTabButton(){
        SelenideElement writtenButton = $(".group-tab-buttons");
        writtenButton.scrollTo();
        writtenButton.click();
    }
    @Test
    public void testPhotoPlaces(){
        List<SelenideElement> photoPlaces = $$(".redesigned-group-avatar, .redesigned-group-cover");
        assertEquals(2,photoPlaces.size());
    }
    @Test
    public void testButtonText(){
        SelenideElement subscribeButton =$("#join_button");
        subscribeButton.shouldHave(Condition.text("подписаться"));
        SelenideElement moreButton = $(".FlatButton.FlatButton--secondary.FlatButton--size-m.redesigned-group-action.redesigned-group-action--more");
        moreButton.shouldHave(Condition.text("Ещё"));
        SelenideElement showAllButton = $(".group-tab-buttons");
        String initialText = showAllButton.getText();
        showAllButton.shouldHave(Condition.text("Показать все"));
        ///После добавление в список улсг
        showAllButton =$(".group-tab-buttons");
        String newText = showAllButton.getText();
        assertEquals(initialText,newText);
        showAllButton.shouldHave(Condition.text("Показать все"));
    }
}
