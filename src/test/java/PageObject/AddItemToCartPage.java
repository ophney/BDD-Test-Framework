package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddItemToCartPage extends BasePage {
    public AddItemToCartPage() {
        PageFactory.initElements(Utilities.WebDriverManager.getDriver(), this);
    }

    @FindBy(id ="search")
    public WebElement searchItem;

    @FindBy(xpath = "//button[contains(@title,'Search')]")
    public WebElement searchButton;

    @FindBy(css ="#maincontent > div.columns > div.column.main > div.search.results > div.products.wrapper.grid.products-grid > ol > li:nth-child(1) > div > a > span > span > img")
    public WebElement desiredItem;

    @FindBy(id="option-label-size-143-item-167")
    public WebElement size;

    @FindBy(id="option-label-color-93-item-53")
    public WebElement colour;

    @FindBy(id ="product-addtocart-button")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[contains(@class,'counter-number')]")
    public WebElement myCartCounterNumber;
    @FindBy(css = "#maincontent > div.page.messages > div:nth-child(2) > div > div > div")
    public WebElement itemAddedMessage;

    @FindBy(xpath = "//a[@class='action showcart']")
    public WebElement myCart;

    @FindBy(linkText = "Hero Hoodie")
    public WebElement verifyItemInCart;

}
