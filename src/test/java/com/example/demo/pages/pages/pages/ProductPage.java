package com.example.demo.pages.pages.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.clipboard;

public class ProductPage {
    // Определение переменных для элементов страницы.
    public SelenideElement
            photoPlaceBig = $(".ItemGallery__main"),
            photoPlaceSmall = $(".vkuiImageBase__img"),
            iconButton = $(".vkuiIcon--add_square_outline_28"),
            itemPrice = $(".MarketItemCard__price"),
            likeButton = $(".ItemActions__iconLike"),
            followButton = $(byText("Подписаться")),
            toStoreButton = $(byText("Перейти в магазин")),
            writtenButton = $(".vkuiButton__content"),
            copyLinkButton = $(".ItemActions__itemText"),
            subscribeButton = $("._buttonToggleSubscribeGroup");
    public ProductPage clickToStoreButton() {
        writtenButton.shouldBe(visible);
        writtenButton.click();
        return this;
    }

    public ProductPage clickLikeButton() {
        likeButton.click();
        return this;
    }
    public ProductPage clickSubscribeButton(){
        subscribeButton.click();
        return this;
}
    public ProductPage clickIconButton() {
        iconButton.click();
        return this;
    }
    public String getItemPrice() {
        return itemPrice.getText();
    }
    public String getCopiedLink() {
        copyLinkButton.click();
        return clipboard().getText();
    }
    public String getItemWritten() {
        return writtenButton.getText();
    }
    public String getItemToStore(){
        return toStoreButton.getText();
    }
    public String getItemFollow(){
        return followButton.getText();
    }
}