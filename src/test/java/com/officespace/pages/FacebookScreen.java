package com.officespace.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookScreen {

    private WebDriver driver;

    public FacebookScreen(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"Username\"]")
    public WebElement usernameTextBox;
    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"Password\"]")
    public WebElement passwordTextBox;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Log In\"]")
    public WebElement loginBtn;
    @FindBy(xpath = "//android.widget.Button[@text=\"Not Now\"]")
    public WebElement notNowBtn;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Deny\"]")
    public WebElement denyBtn;
    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Search Facebook\"]")
    public WebElement searchTextBox;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"All\"]")
    public WebElement allBtn;
    @FindBy(xpath = "(/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup)[1]")
    public WebElement officeSpaceWidget;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"like button\"]")
    public WebElement likeBtn;

    public void loginFacebook(String username, String password){
        System.out.println("Login to Facebook...");
        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        loginBtn.click();
        notNowBtn.click();
        denyBtn.click();
    }

    public void searchOfficeSpaces(String officeSpace) throws InterruptedException {
        System.out.println("Search for OfficeSpace Software");
        Actions action = new Actions(driver);
        action.moveToElement(searchTextBox)
                .click()
                .build().perform();
        action.sendKeys(officeSpace)
                .sendKeys(Keys.ENTER)
                .build().perform();

        Thread.sleep(30000);
        allBtn.click();
    }

    public void likeOfficeSpace() {
        System.out.println("Open OfficeSpace Software App");
        officeSpaceWidget.click();
        likeBtn.click();
        System.out.println("OfficeSpace Software App Page was successfully liked");
    }
}
