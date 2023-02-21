package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class TechGlobalBasePage {

    public TechGlobalBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "main_heading")
    public WebElement mainHeading;

    @FindBy(id = "sub_heading")
    public WebElement subHeading;

    @FindBy(id = "content")
    public WebElement paragraph;

    @FindBy(id = "previous")
    public WebElement previousButton;

    @FindBy(id = "next")
    public WebElement nextButton;

    @FindBy(css = ".Pagination_pagBodyData__up2c0 p")
    public List<WebElement> cityInfo;

    @FindBy(css = "city_image")
    public WebElement cityImage;

}