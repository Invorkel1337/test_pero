package pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.clipboard;

public class ProductPage {
    // Определение переменных для элементов страницы.
    public SelenideElement
            PhotoPlaceBig = $(".ItemGallery__main"),
            PhotoPlaceSmall = $(".vkuiImageBase__img"),
            IconButton = $(".vkuiIcon--add_square_outline_28"),
            ItemPrice = $(".MarketItemCard__price"),
            LikeButton = $(".ItemActions__iconLike"),
            FollowButton = $(byText("Подписаться")),
            ToStoreButton = $(byText("Перейти в магазин")),
            WrittenButton = $(".vkuiButton__content"),
            CopyLinkButton = $(".ItemActions__itemText");
    public ProductPage clickToStoreButton() {
        WrittenButton.shouldBe(visible);
        WrittenButton.click();
        return this;
    }

    public ProductPage clickLikeButton() {
        LikeButton.click();
        return this;
    }

    public ProductPage clickIconButton() {
        IconButton.click();
        return this;
    }

    public String getItemPrice() {
        return ItemPrice.getText();
    }
    public String getCopiedLink() {
        CopyLinkButton.click();
        return clipboard().getText();
    }
}