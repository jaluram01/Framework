package com.qa.pages.mobile;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.qa.base.MobileBaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * 
 * @author Jalu Ram
 *
 */
public class RegistrationPage extends MobileBaseTest {

	@AndroidFindBy(id = "io.selendroid.testapp:id/startUserRegistration")
	MobileElement fileIconButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(text(),'Welcome to register')]")
	MobileElement welcomeLabel;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/inputUsername")
	MobileElement userNameTextBox;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/inputEmail")
	MobileElement emailTextBox;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/inputPassword")
	MobileElement passwordTextBox;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/inputName")
	public MobileElement nameTxtBox;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/input_adds")
	MobileElement tNCCheckbox; 
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/btnRegisterUser")
	MobileElement regUserBtn;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_name_data")
	public MobileElement nameField;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_username_data")
	public MobileElement userNameField;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/input_preferedProgrammingLanguage")
	public MobileElement programmingLangDropdownValue;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_password_data")
	public MobileElement passwordField;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_email_data")
	public MobileElement emailField;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_preferedProgrammingLanguage_data")
	public MobileElement pRLangField;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_acceptAdds_data")
	public MobileElement iAcceptVal;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/buttonRegisterUser")
	public MobileElement registerButton;
		
	public WebDriverWait wait;
	public AppiumDriver<MobileElement> appiumDriver;
	
	public RegistrationPage(AppiumDriver<MobileElement> appiumDriver) {
		this.appiumDriver = appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.appiumDriver), this);
		wait = new WebDriverWait(appiumDriver, 30);
	}
	
	public void verifyRegPageElements() {
		Assert.assertEquals(userNameTextBox.isDisplayed(), true);
		Assert.assertEquals(emailTextBox.isDisplayed(), true);
		Assert.assertEquals(passwordTextBox.isDisplayed(), true);
		Assert.assertEquals(nameTxtBox.isDisplayed(), true);
		Assert.assertEquals(tNCCheckbox.isDisplayed(), true);
		Assert.assertEquals(regUserBtn.isDisplayed(), true);
	}
	
	public void clickFileLogo() {
		Assert.assertEquals(fileIconButton.isDisplayed(), true);		
		fileIconButton.click();
	}
	
	public void verifyRegPageTitle() {
		Assert.assertEquals(welcomeLabel.isDisplayed(), true);
	}
	
	public void fillRegistrationFormAndClickRegister(String uname, String email, String pwd, String name) {
		userNameTextBox.sendKeys(uname);
		emailTextBox.sendKeys(email);
		passwordTextBox.sendKeys(pwd);
		nameTxtBox.sendKeys(name);
		tNCCheckbox.click();
		regUserBtn.click();			
	}
	
	public void postRegistrationPage(String uname, String email, String pwd, String name, 
			String lang, String acceptVal) {
		
		Assert.assertEquals(nameField.getText(), name);
		Assert.assertEquals(userNameField.getText(), uname);
		Assert.assertEquals(passwordField.getText(), pwd);
		Assert.assertEquals(emailField.getText(), email);
		Assert.assertEquals(pRLangField.getText(), lang);
		Assert.assertEquals(iAcceptVal.getText(), acceptVal);	
	}
}
