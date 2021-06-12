package com.qa.pages.mobile;

import java.util.List;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.util.Sleeper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * 
 * @author Jalu Ram
 *
 */
public class ChromeBrowserPage {

	@AndroidFindBy(id = "io.selendroid.testapp:id/buttonStartWebview")
	MobileElement btnChromeLogo;

	@AndroidFindBy(id = "io.selendroid.testapp:id/tableHeader")
	MobileElement header;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, \"Hello, can you please\")]")
	MobileElement hdrTxt;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"name_input\"]")
	MobileElement nameTxtBox;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@text, \"Send\")]")
	MobileElement sendMeNameBtn;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[1]/android.widget.TextView")
	MobileElement webViewTitle;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView/android.view.View[1]")
	MobileElement myWayOfSayingHelloText;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView/android.widget.TextView[1]")
	MobileElement enteredName;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text, \"Volvo\")]")
	MobileElement preferedCardDropdown;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView/android.widget.TextView[2]")
	MobileElement selectedCar;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"here\"]/android.widget.TextView")
	MobileElement clickHereLink;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.TableLayout/android.widget.TableRow[3]/android.webkit.WebView/android.webkit.WebView"
			+ "/android.view.View/android.view.View[4]/android.view.View[2]")
	MobileElement carSelect;

	public WebDriverWait wait;
	public AppiumDriver<MobileElement> appiumDriver;

	public ChromeBrowserPage(AppiumDriver<MobileElement> appiumDriver) {
		this.appiumDriver = appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.appiumDriver), this);
		wait = new WebDriverWait(appiumDriver, 30);
		wait.until(ExpectedConditions.visibilityOf(webViewTitle));
	}

	public void selectOption(String option) {
		preferedCardDropdown.click();
		Sleeper.seconds(2, "Wait for the dropdown to load");
		List<MobileElement> options = appiumDriver.findElementsByClassName("android.widget.CheckedTextView");
		System.out.println("Total number of options available in dropdown:" + options.size());

		for (MobileElement elem : options) {
			String val = elem.getText();

			if (val.equalsIgnoreCase(option)) {
				elem.click();
				break;
			}
		}
	}

	public String getwebViewTitle() {
		return webViewTitle.getText();
	}

	public String getHeaderText() {
		return hdrTxt.getText();
	}

	public MobileElement getNameTxtBox() {
		return nameTxtBox;
	}

	public String enteredNameText() {
		return enteredName.getText();
	}

	public String getSelectedCarText() {
		return selectedCar.getText();
	}

	public String getPreferedCarDropdownDefaultValue() {
		return carSelect.getText();
	}

	public void clickOnclickHereLink() {
		clickHereLink.click();
	}

	public MobileElement getSendMeNameBtn() {
		return sendMeNameBtn;
	}
	
	public MobileElement getMyWayOfSayingHelloText() {
		return myWayOfSayingHelloText;
	}

}
