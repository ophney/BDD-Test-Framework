package StepDefinitions;

import PageObject.AddItemToCartPage;
import Utilities.ExcelDataReader;
import Utilities.WebDriverManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AddItemToCartStep {
    AddItemToCartPage addItemToCartPage = new AddItemToCartPage();

    @Given("the user navigates to shopping website homepage")
    public void the_user_navigates_to_shopping_website_homepage() {
        WebDriverManager.getDriver().get("https://magento.softwaretestingboard.com/");
    }
    @When("user search for an item")
    public void user_search_for_an_item() throws IOException {

//        Getting Data from JSON file
//        String jsonFilePath = "src/test/resources/TestData/JSON_TestData.json";
//        JsonObject jsonObject= new Gson().fromJson(new FileReader(jsonFilePath), JsonObject.class);
//        String itemName = jsonObject.get("itemName").getAsString();

//        Getting Data from EXCEL File
        String excelFilePath = "src/test/resources/TestData/Excel_TestData.xlsx";
        String sheetName = "test data 1";
        String itemName = ExcelDataReader.readTestDataFromExcel(excelFilePath, sheetName, 1, 0);

        addItemToCartPage.mySendKeys(addItemToCartPage.searchItem,itemName);
        addItemToCartPage.myClick(addItemToCartPage.searchButton);

    }
    @When("select the desired item from the search results")
    public void select_the_desired_item_from_the_search_results() {
        addItemToCartPage.myClick(addItemToCartPage.desiredItem);
    }
    @When("add item to the card")
    public void add_item_to_the_card() {
        addItemToCartPage.myClick(addItemToCartPage.size);
        addItemToCartPage.myClick(addItemToCartPage.colour);
        addItemToCartPage.myClick(addItemToCartPage.addToCartButton);

    }
    @Then("the correct item should be added to the cart")
    public void the_correct_item_should_be_added_to_the_cart() {
        addItemToCartPage.verifyContainsText(addItemToCartPage.myCartcounterNumber,"1");

        addItemToCartPage.myClick(addItemToCartPage.myCart);
        addItemToCartPage.verifyContainsText(addItemToCartPage.verifyItemInCart,"Hero Hoodie");

    }
}
