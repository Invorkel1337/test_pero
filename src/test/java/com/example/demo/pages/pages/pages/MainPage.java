package com.example.demo.pages.pages.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
public class MainPage {
    public SelenideElement
            publicPhoto = $(".redesigned-group-avatar"),
            allPostButton = $("._wall_tab_all"),
            communityPostButton = $("._wall_tab_own"),
            headPhoto = $(".redesigned-group-cover"),
            productPhoto = $(".EcommPreviewProductCardProductPicture__img"),
            showAllButton = $(".group-tab-buttons"),
            subscribeButton = $("#page_actions"),
            moreButton = $(byText("Ещё")),
            messageButton = $(".message_outline_20__Page-2"),
            moreInfoButton = $(".groups-redesigned-info-more");


    public MainPage clickMessageButton() {
        messageButton.click();
        return this;
    }
    public MainPage clickAllPostButton(){
        allPostButton.click();
        return this;
    }
    public MainPage clickCommunityPostButton(){
        communityPostButton.click();
        return this;
    }
    public MainPage clickShowAllButton(){
        showAllButton.click();
        return this;
    }
    public MainPage clickMoreInfoButton(){
        moreInfoButton.click();
        return this;
    }

    public String getItemMore() {
        return moreButton.getText();
    }
    public String getItemSubscribe(){
        return subscribeButton.getText();
    }
    public String getItemShowAll(){
        return showAllButton.getText();
    }
}