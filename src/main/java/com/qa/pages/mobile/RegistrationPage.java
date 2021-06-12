package com.qa.pages.mobile;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * 
 * @author Jalu Ram
 *
 */
public class RegistrationPage {

	@AndroidFindBy(id = "io.selendroid.testapp:id/startUserRegistration")
	MobileElement fileIconButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
	MobileElement welcomeLabel;

	@AndroidFindBy(id = "io.selendroid.testapp:id/inputUsername")
	MobileElement userNameTextBox;

	@AndroidFindBy(id = "io.selendroid.testapp:id/inputEmail")
	MobileElement emailTextBox;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/inputPassword")
	MobileElement passwordTextBox;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/inputName")
	MobileElement nameTxtBox;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/input_adds")
	MobileElement tNCCheckbox; 
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/btnRegisterUser")
	MobileElement regUserBtn;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_name_data")
	MobileElement nameField;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_username_data")
	MobileElement userNameField;
	
	@AndroidFindBy(id = "android:id/text1")
	MobileElement programmingLangDropdownValue;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_password_data")
	MobileElement passwordField;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_email_data")
	MobileElement emailField;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_preferedProgrammingLanguage_data")
	MobileElement pRLangField;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/label_acceptAdds_data")
	MobileElement iAcceptVal;
	
	@AndroidFindBy(id = "io.selendroid.testapp:id/buttonRegisterUser")
	MobileElement registerButton;
		
	public WebDriverWait wait;
	public AppiumDriver<MobileElement> appiumDriver;
	
	public RegistrationPage(AppiumDriver<MobileElement> appiumDriver) {
		this.appiumDriver = appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(this.appiumDriver), this);
		wait = new WebDriverWait(appiumDriver, 30);
	}

	
	public void fillRegistrationFormAndClickRegister(String uname, String email, String pwd, String name) {
		userNameTextBox.sendKeys(uname);
		emailTextBox.sendKeys(email);
		passwordTextBox.sendKeys(pwd);
		nameTxtBox.clear();
		nameTxtBox.sendKeys(name);
		tNCCheckbox.click();
		regUserBtn.click();			
	}
	
	
	public MobileElement getFileIconButton() {
		return fileIconButton;
	}

	public MobileElement getWelcomeLabel() {
		return welcomeLabel;
	}

	public MobileElement getUserNameTextBox() {
		return userNameTextBox;
	}

	public MobileElement getEmailTextBox() {
		return emailTextBox;
	}

	public MobileElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public MobileElement getNameTxtBox() {
		return nameTxtBox;
	}

	public MobileElement gettNCCheckbox() {
		return tNCCheckbox;
	}

	public MobileElement getRegUserBtn() {
		return regUserBtn;
	}

	public MobileElement getNameField() {
		return nameField;
	}

	public MobileElement getUserNameField() {
		return userNameField;
	}

	public MobileElement getProgrammingLangDropdownValue() {
		return programmingLangDropdownValue;
	}

	public MobileElement getPasswordField() {
		return passwordField;
	}

	public MobileElement getEmailField() {
		return emailField;
	}

	public MobileElement getpRLangField() {
		return pRLangField;
	}

	public MobileElement getiAcceptVal() {
		return iAcceptVal;
	}

	public MobileElement getRegisterButton() {
		return registerButton;
	}
}
