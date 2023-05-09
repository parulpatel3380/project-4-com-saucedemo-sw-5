package com.saucedemo.testsuite;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    ProductPage productPage;    //  LoginTest loginTest = new LoginTest();
    LoginPage loginpage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        loginpage = new LoginPage();
        productPage= new ProductPage();
    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatSixProductsAreDisplayedOnPage(){
        loginpage.enterUsername("standard_user");
        loginpage.enterPassword("secret_sauce");
        loginpage.clickOnLoginButton();
        Assert.assertEquals(productPage.getProductText(),"Products");
        String productPerPage = "6";

        Assert.assertEquals(productPage.getProductsPerPage(),productPerPage);


    }

}
