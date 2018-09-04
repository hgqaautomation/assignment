package com.growthengineering;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseSetUp.BaseSetUp;
import junit.framework.Assert;

public class Scenario2_Contact_Us_Form_Validations extends BaseSetUp{
	
	String firtName="Tom";
	String lastname="Peter";
	String emailAdd="peter@gmail.com";
	String companyName="Growth Engineering";
	String audienceName="1 - 199 Users";
	String phoneNum="123456790";
	String countryName="South Korea";
	String knowName="The Academy LMS";
	String helpValue="helpText";
	WebElement valMsg;

	
	/*
	 * The following @BeforeMethod calls browserSetup method defined in base set up class to open browser
	 * 
	 */
	
	@BeforeMethod()
	public void openWebSite()
	{
		browserSetUp();
	}

	
	/*
	 * Test Case 1 - Purpose : The following test case will validate the generic validation message where data is provided for all 
	 * mandatory fields but kept one of mandatory field as empty say 'First Name' field.
	 * 
	 */
	
	@Test
	public void validate_GenericValidationMsg()
	{
		try
		{
		
		System.out.println("Inside Contact Us verification test");
		String expPageTitle = "Contact the Engagement A-Team! - Growth Engineering";

// Step 1: Click 'Contact Us' link

		WebElement contactUS_Link = driver.findElement(By.xpath("//span[text()='Get in Touch']"));
		contactUS_Link.click();
		WebElement title= (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.name("lastname")));
		String actContactUs_title = driver.getTitle();

// Step 2: Verify user routes to Contact Us page. If assertion fails, then script fails here and script would not proceed further

		//Assert.assertEquals(expPageTitle, actContactUs_title,"Contact Us page is not displayed hence can not procceed further");
		if(expPageTitle.equals(actContactUs_title))
			System.out.println("Contact us link clicked successfully and page title is : " + actContactUs_title);
		else
			System.out.println("Incorrect page is displayed");

// Step 3: Enter valid last name. If last name text box is enabled and displayed then last name will be entered
// otherwise , assertion will fail here and script would not proceed further

		WebElement lastName = driver.findElement(By.name("lastname"));
		if (lastName.isDisplayed() && lastName.isEnabled()) {
			lastName.clear();
			lastName.sendKeys(lastname);
			System.out.println("Last name "  + lastname + " entered successfully");
		} else {
			System.out.println("Last name "  + lastname + " was not entered successfully");
			Assert.assertFalse(false);
		}

// Step 4: Enter valid email id. If email id text box is enabled and displayed then email id will be entered
// otherwise , assertion will fail here and script would not proceed further

		WebElement emailID = driver.findElement(By.name("email"));
		if (lastName.isDisplayed() && lastName.isEnabled()) {
			
			emailID.clear();
			emailID.sendKeys(emailAdd);
			System.out.println("Email Address "  +  emailAdd + "entered successfully");
		}

		else {
			System.out.println("Email Address "  +  emailAdd + "was entered successfully");
			Assert.assertFalse(false);
		}

// Step 5: Check receive mails or notifications checkbox.If checked box is enabled and is not checked then it will be selected
// otherwise , assertion will fail here and script would not proceed further

		WebElement notifyChcBox = driver.findElement(
				By.name("i_d_like_to_receive_emails_or_phone_calls_from_the_growth_engineering_sales_team_"));
		if (notifyChcBox.isDisplayed() && !notifyChcBox.isSelected())
		{
			notifyChcBox.click();
			System.out.println("Notification checkbox is checked successfully");
		}
		else
		{
			System.out.println("Notification checkbox could not be checked");
			Assert.assertFalse(false);
		}

// Step 6: Enter valid company name. If company name text box is enabled and displayed then company name will be entered
// otherwise , assertion will fail here and script would not proceed further

		WebElement comName = driver.findElement(By.name("company"));

		if (comName.isDisplayed() && comName.isEnabled()) {
			comName.clear();
			comName.sendKeys(companyName);
			System.out.println("Company "  +  companyName + "entered successfully");
		}

		else {
			System.out.println("Company "  +  companyName + "could not be entered");
			Assert.assertFalse(false);
		}

// Step 7: Select Audience value

		WebElement audienceDropDwn = driver.findElement(By.xpath("//select[@name='how_big_is_your_audience_']"));
		if (audienceDropDwn.isDisplayed() && audienceDropDwn.isEnabled())
		{
			GenericUtility.selectFromDropdown(audienceDropDwn, audienceName, "First Value");
			System.out.println(audienceName + "was selected successfully");
		}
		else
		{
			System.out.println(audienceName + "could not be selected");
			Assert.assertFalse(false);
		}

// Step 8 : Enter valid phone number If phone number field is enabled and displayed then company name will be entered
// otherwise , assertion will fail here and script would not proceed further

		WebElement phNum = driver.findElement(By.name("phone"));
		if (phNum.isDisplayed() && phNum.isEnabled()) {
			phNum.clear();
			phNum.sendKeys(phoneNum);
			System.out.println("Phone "  +  phoneNum + "entered successfully");
		}

		else {
			System.out.println("Phone "  +  phoneNum + "could not be entered");
			Assert.assertFalse(false);
		}

// Step 9: Select Country from country drop down

		WebElement countryDropDown = driver.findElement(By.name("country_"));

		if (countryDropDown.isDisplayed() && countryDropDown.isEnabled())
		{
			GenericUtility.selectFromDropdown(countryDropDown, countryName, "Country");
			System.out.println(countryName +  "was selected successfully");
		}
		
		else
		{
			System.out.println(countryName +  "could not be selected");
			Assert.assertFalse(false);
		}

// Step 10 : Check Role radial button. If role radio button is enabled and not selected then the required radio button will be selected
// otherwise , assertion will fail here and script would not proceed further

		WebElement firstRadialBtn = driver
				.findElement(By.xpath("//input[@id='role_description0-904e0350-5c3a-43a2-aa4c-434b02d38da6']"));

		if (firstRadialBtn.isDisplayed() && !firstRadialBtn.isSelected())
		{
			firstRadialBtn.click();
			System.out.println("Reqiured Radial button was selected successfully");
		}
		else
		{
			System.out.println("Reqiured Radial button could not be selected");
			Assert.assertFalse(false);
		}

// Step 11: Select value in to know more about drop down.

		WebElement knowDropDown = driver.findElement(By.name("what_would_you_like_to_find_out_more_about_"));

		if (knowDropDown.isDisplayed() && knowDropDown.isEnabled())
		{
			GenericUtility.selectFromDropdown(knowDropDown, knowName, "Know more about");
			System.out.println(knowName + "was selected successfully from drop down");
			
		}
		else
		{
			Assert.assertFalse(false);
			System.out.println("Faild to select " + knowName + "from drop down");
		}

// Step 12 : Enter help data. If help text box field is enabled and displayed then data will be entered
// otherwise , assertion will fail here and script would not proceed further

		WebElement helpTxtBox = driver.findElement(By.name("what_s_your_goal_"));

		if (helpTxtBox.isDisplayed() && helpTxtBox.isEnabled()) {
			helpTxtBox.clear();
			helpTxtBox.sendKeys(helpValue);
			System.out.println(helpValue + "was entered successfully");
		}

		else {
			System.out.println(helpValue + "was not entered");
			Assert.assertFalse(false);
		}

// Step 13 : Check email updates checkbox. If this checkbox is enabled and displayed then it will be checked
// otherwise , assertion will fail here and script would not proceed further
		
		WebElement notificationChcBox = driver
				.findElement(By.name("send_me_promotional_emails_from_growth_engineering_"));
		if (notificationChcBox.isDisplayed() && !notificationChcBox.isSelected())
		{
			notificationChcBox.click();
			System.out.println("Notification checkbox clicked successfully");
		}
		else
		{
			System.out.println("Notification checkbox could not be clicked successfully");
			Assert.assertFalse(false);
		}

// Step 14 : Click on Submit button.

		WebElement submitBtn = driver.findElement(By.xpath("(//input[@class='hs-button primary large'])[1]"));
		if (submitBtn.isDisplayed() && submitBtn.isEnabled())
		{
			submitBtn.click();
			System.out.println("Submit button clicked successfully");
		}
		else
		{
			System.out.println("Submit button could not be clicked successfully");
			Assert.assertFalse(false);
		}

// Step 15: A validation message stating "Please complete all required fields" should be displayed

		
		valMsg = driver.findElement(By.xpath("//label[text()='Please complete all required fields.']"));
		if (valMsg.isDisplayed() && valMsg.getText().equals("Please complete all required fields."))
			System.out.println("Test Passed: As system throws a valid and correct validation message which is " + valMsg.getText());
		else
			System.out.println("Test failed: As system failed to throw a valid validation message when only first name field kept empty");
		
	}

	
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
	
	/*
	 * Test Case 2 - Purpose: The following test case will validate the individual/independent warning message/text corresponding to
	 * mandatory data fields say 'Last Name'.
	 * 
	 */
	
	@Test
	public void validateMandatoryFirstName() throws InterruptedException
	{
		
	try
	 {
		System.out.println("Inside Contact Us verification test");
		String expPageTitle = "Contact the Engagement A-Team! - Growth Engineering";

// Step 1: Click 'Contact Us' link

		WebElement contactUS_Link = driver.findElement(By.xpath("//span[text()='Get in Touch']"));
		contactUS_Link.click();
		WebElement firstName1= (new WebDriverWait(driver, 20))
				  .until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
		String actContactUs_title = driver.getTitle();

// Step 2: Verify user routes to Contact Us page. If assertion fails, then script fails here and script would not proceed further

		if(expPageTitle.equals(actContactUs_title))
			System.out.println("Contact us link clicked successfully and page title is : " + actContactUs_title);
		else
			System.out.println("Incorrect page is displayed");

// Step 3: Keep the first name field empty and then try to shift to next field say 'last name' then verify that proper/correct validation text for mandatory 
// first name should be displayed

		WebElement firstname = driver.findElement(By.name("firstname"));
		firstname.sendKeys(Keys.SHIFT);
		Thread.sleep(1000);
		firstname.sendKeys(Keys.TAB);
		
		valMsg = driver.findElement(By.xpath("//input[@name='firstname']/..//following-sibling::ul//li"));
		WebElement valMsg1= (new WebDriverWait(driver, 20))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstname']/..//following-sibling::ul//li")));
		
			Assert.assertTrue(valMsg.isDisplayed() && valMsg.getText().equals("Please complete this required field."));
			System.out.println("Test Passed: As system throws a valid and correct validation message which is " + valMsg.getText());
		
}
	
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
	
	/*
	 * Test Case 3 - Purpose: The following test case will validate the individual/independent warning message/text corresponding when user did not
	 * select the required drop down from 'Audience' or 'Country Drop down.
	 * 
	 */
	
	@Test
	public void validateMandatoryDropDownValue() throws InterruptedException
	{
		
	try
	 {
		System.out.println("Inside Contact Us verification test");
		String expPageTitle = "Contact the Engagement A-Team! - Growth Engineering";

// Step 1: Click 'Contact Us' link

		WebElement contactUS_Link = driver.findElement(By.xpath("//span[text()='Get in Touch']"));
		contactUS_Link.click();
		WebElement lastName1= (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.name("lastname")));
		String actContactUs_title = driver.getTitle();

// Step 2: Verify user routes to Contact Us page. If assertion fails,then script fails here and script would not proceed further

		
		if(expPageTitle.equals(actContactUs_title))
			System.out.println("Contact us link clicked successfully and page title is : " + actContactUs_title);
		else
			System.out.println("Incorrect page is displayed");

// Step 3: Enter valid last name. If last name text box is enabled and displayed then last name will be entered
// otherwise , assertion will fail here and script would not proceed further

		WebElement lastName = driver.findElement(By.name("lastname"));
		if (lastName.isDisplayed() && lastName.isEnabled()) {
			lastName.clear();
			lastName.sendKeys(lastname);
			System.out.println("Last name "  + lastname + " entered successfully");
		} else {
			System.out.println("Last name "  + lastname + " was not entered successfully");
			Assert.assertFalse(false);
		}

// Step 4: Enter valid email id. If email id text box is enabled and displayed then email id will be entered
// otherwise , assertion will fail here and script would not proceed further

		WebElement emailID = driver.findElement(By.name("email"));
		if (lastName.isDisplayed() && lastName.isEnabled()) {
			
			emailID.clear();
			emailID.sendKeys(emailAdd);
			System.out.println("Email Address "  +  emailAdd + "entered successfully");
		}

		else {
			System.out.println("Email Address "  +  emailAdd + "was entered successfully");
			Assert.assertFalse(false);
		}

// Step 5: Check receive mails or notifications checkbox.If checked box is enabled and is not checked then it will be selected
// otherwise , assertion will fail here and script would not proceed further

		WebElement notifyChcBox = driver.findElement(
				By.name("i_d_like_to_receive_emails_or_phone_calls_from_the_growth_engineering_sales_team_"));
		if (notifyChcBox.isDisplayed() && !notifyChcBox.isSelected())
		{
			notifyChcBox.click();
			System.out.println("Notification checkbox is checked successfully");
		}
		else
		{
			System.out.println("Notification checkbox could not be checked");
			Assert.assertFalse(false);
		}

// Step 6: Enter valid company name. If company name text box is enabled and displayed then company name will be entered
// otherwise , assertion will fail here and script would not proceed further

		WebElement comName = driver.findElement(By.name("company"));

		if (comName.isDisplayed() && comName.isEnabled()) {
			comName.clear();
			comName.sendKeys(companyName);
			System.out.println("Company "  +  companyName + "entered successfully");
		}

		else {
			System.out.println("Company "  +  companyName + "could not be entered");
			Assert.assertFalse(false);
		}

// Step 7: Select Audience value

		WebElement audienceDropDwn = driver.findElement(By.xpath("//select[@name='how_big_is_your_audience_']"));
		if (audienceDropDwn.isDisplayed() && audienceDropDwn.isEnabled())
		{
			GenericUtility.selectFromDropdown(audienceDropDwn, audienceName, "First Value");
			System.out.println(audienceName + "was selected successfully");
		}
		else
		{
			System.out.println(audienceName + "could not be selected");
			Assert.assertFalse(false);
		}

// Step 8 : Enter valid phone number If phone number field is enabled and displayed then company name will be entered
// otherwise , assertion will fail here and script would not proceed further

		WebElement phNum = driver.findElement(By.name("phone"));
		if (phNum.isDisplayed() && phNum.isEnabled()) {
			phNum.clear();
			phNum.sendKeys(phoneNum);
			System.out.println("Phone "  +  phoneNum + "entered successfully");
		}

		else {
			System.out.println("Phone "  +  phoneNum + "could not be entered");
			Assert.assertFalse(false);
		}

// Step 10: Do'nt select country from country drop down

		WebElement countryDropDown = driver.findElement(By.name("country_"));

		countryDropDown.sendKeys(Keys.SHIFT);
		Thread.sleep(1000);
		countryDropDown.sendKeys(Keys.TAB);
		
		WebElement validationMsg = driver.findElement(By.xpath("//select[@id='country_-904e0350-5c3a-43a2-aa4c-434b02d38da6']/..//following-sibling::ul//li"));
		WebElement valMsg= (new WebDriverWait(driver, 20))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='country_-904e0350-5c3a-43a2-aa4c-434b02d38da6']/..//following-sibling::ul//li")));
		
			Assert.assertTrue(validationMsg.isDisplayed() && validationMsg.getText().equals("Please select an option from the dropdown menu."));
			System.out.println("Test Passed: As system throws a valid and correct validation message which is " + validationMsg.getText());

	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
	
/*
 * Test Case # 4:  Purpose : The following test case will validate the correct format of email id. For instance, if email id
 * is entered without having '@' in email id before the domain name then proper warning text should be displayed
 * 
 */
	
	//@Test
	public void validateEmailId_Format() throws InterruptedException
	{
		
	try
	 {
		System.out.println("Inside Contact Us verification test");
		String expPageTitle = "Contact the Engagement A-Team! - Growth Engineering";

// Step 1: Click 'Contact Us' link

		WebElement contactUS_Link = driver.findElement(By.xpath("//span[text()='Get in Touch']"));
		contactUS_Link.click();
		WebElement firstName= (new WebDriverWait(driver, 20))
				  .until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
		String actContactUs_title = driver.getTitle();

// Step 2: Verify user routes to Contact Us page. If assertion fails, then script fails here and script would not proceed further

		
		if(expPageTitle.equals(actContactUs_title))
			System.out.println("Contact us link clicked successfully and page title is : " + actContactUs_title);
		else
			System.out.println("Incorrect page is displayed");


// Step 3: Enter valid first name. If last name text box is enabled and displayed then last name will be entered
// otherwise , assertion will fail here and script would not proceed further

				WebElement firstName1 = driver.findElement(By.name("firstname"));
				if (firstName1.isDisplayed() && firstName.isEnabled()) {
					firstName1.clear();
					firstName1.sendKeys(firtName);
					System.out.println("First name "  + firtName + " entered successfully");
				} else {
					System.out.println("Last name "  + firtName + " was not entered successfully");
					Assert.assertFalse(false);
				}
		
// Step 4: Enter valid last name. If last name text box is enabled and displayed then last name will be entered
// otherwise , assertion will fail here and script would not proceed further

		WebElement lastName = driver.findElement(By.name("lastname"));
		if (lastName.isDisplayed() && lastName.isEnabled()) {
			lastName.clear();
			lastName.sendKeys(lastname);
			System.out.println("Last name "  + lastname + " entered successfully");
		} else {
			System.out.println("Last name "  + lastname + " was not entered successfully");
			Assert.assertFalse(false);
		}

// Step 5: Enter invalid email id say without having '@' in email address

		WebElement emailID = driver.findElement(By.name("email"));
		if (lastName.isDisplayed() && lastName.isEnabled()) {
			
			emailID.sendKeys("TestEmailID");
			emailID.sendKeys(Keys.TAB);
			Thread.sleep(1000);
			
			WebElement validationMsg = driver.findElement(By.xpath("//input[@id='email-904e0350-5c3a-43a2-aa4c-434b02d38da6']/..//following-sibling::ul//li"));			
			WebElement valMsg= (new WebDriverWait(driver, 20))
					 .until(ExpectedConditions.visibilityOf(validationMsg));
			
			Assert.assertTrue(validationMsg.isDisplayed() && validationMsg.getText().equals("Email must be formatted correctly."));
			System.out.println("Test Passed: As system throws a valid and correct validation message which is " + validationMsg.getText());
			
		}
	 }
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}

}
	
	/*
	 * Test Case # 5_Case1:  Purpose : The following test case will validate the Phone number field depending upon the length of invalid data. 
	 * For instance, if phone number is provided as non numeric and length is GREATER than 7 characters then accordingly, proper warning text should be displayed.
	 * 
	 */
	
	
	//@Test
	public void validatePhoneNumber_InvalidDataGreaterThan_7_Characters_Case1()
	{
		
	try
	 {
		
		System.out.println("Inside Contact Us verification test");
		String expPageTitle = "Contact the Engagement A-Team! - Growth Engineering";
		
// Step 1: Click 'Contact Us' link
		
		WebElement contactUS_Link = driver.findElement(By.xpath("//span[text()='Get in Touch']"));
		contactUS_Link.click();
		WebElement lastNm= (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.name("lastname")));
		String actContactUs_title = driver.getTitle();

// Step 2: Verify user routes to Contact Us page. If assertion fails, then script fails here and script would not proceed further

		if(expPageTitle.equals(actContactUs_title))
			System.out.println("Contact us link clicked successfully and page title is : " + actContactUs_title);
		else
			System.out.println("Incorrect page is displayed");


// Step 3: Check receive mails or notifications checkbox.If checked box is enabled and is not checked then it will be selected
// otherwise , assertion will fail here and script would not proceed further

		WebElement notifyChcBox = driver.findElement(
				By.name("i_d_like_to_receive_emails_or_phone_calls_from_the_growth_engineering_sales_team_"));
		if (notifyChcBox.isDisplayed() && !notifyChcBox.isSelected())
		{
			notifyChcBox.click();
			System.out.println("Notification checkbox is checked successfully");
		}
		else
		{
			System.out.println("Notification checkbox could not be checked");
			Assert.assertFalse(false);
		}


// Step 4 : Enter alphanumeric phone number (invalid) where entered data length is greater than 7 characters

		String expValMsg="Must contain only numbers, +()-. and x.";
		WebElement phNum = driver.findElement(By.name("phone"));
		if (phNum.isDisplayed() && phNum.isEnabled()) {
			phNum.clear();
			phNum.sendKeys("test@#$"); // Invalid phone number (alphanumeric) where string length is greater than 7 characters
			phNum.sendKeys(Keys.TAB);
			Thread.sleep(1000);
			
			WebElement validationMsg = 
			driver.findElement(By.xpath("//input[@id='phone-904e0350-5c3a-43a2-aa4c-434b02d38da6']/..//following-sibling::ul"));			
			WebElement valMsg= (new WebDriverWait(driver, 20))
					 .until(ExpectedConditions.visibilityOf(validationMsg));
			
			//Assert.assertTrue(validationMsg.isDisplayed() && validationMsg.getText().equals("Must contain only numbers, +()-. and x."));
			if(validationMsg.isDisplayed())
			{
				if(expValMsg.equals(validationMsg.getText()))
				{
					System.out.println("Validation message is -->" + validationMsg.getText());
					System.out.println("Test Passed as correct validation message is being displayed");
				}
				
			}
			
			else
			{
				System.out.println("Test is failed as system fails to throw validation message");
			}
			
	 }	
}	
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
}
	
	
	
	
	/*
	 * Test Case # 6_Case2:  Purpose : The following test case will validate the Phone number field depending upon the length of invalid data. 
	 * For instance, if phone number is provided as non numeric and length is LESS than 7 characters then accordingly, proper warning text should be displayed.
	 * 
	 */
	
	
	//@Test
	public void validatePhoneNumber_InvalidDataLessThan_7_Characters_Case2()
	{
		
	try
	 {
		
		System.out.println("Inside Contact Us verification test");
		String expPageTitle = "Contact the Engagement A-Team! - Growth Engineering";
		
// Step 1: Click 'Contact Us' link
		
		WebElement contactUS_Link = driver.findElement(By.xpath("//span[text()='Get in Touch']"));
		contactUS_Link.click();
		WebElement lastNm= (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.name("lastname")));
		String actContactUs_title = driver.getTitle();

// Step 2: Verify user routes to Contact Us page. If assertion fails, then script fails here and script would not proceed further

		if(expPageTitle.equals(actContactUs_title))
			System.out.println("Contact us link clicked successfully and page title is : " + actContactUs_title);
		else
			System.out.println("Incorrect page is displayed");


// Step 3: Check receive mails or notifications checkbox.If checked box is enabled and is not checked then it will be selected
// otherwise , assertion will fail here and script would not proceed further

		WebElement notifyChcBox = driver.findElement(
				By.name("i_d_like_to_receive_emails_or_phone_calls_from_the_growth_engineering_sales_team_"));
		if (notifyChcBox.isDisplayed() && !notifyChcBox.isSelected())
		{
			notifyChcBox.click();
			System.out.println("Notification checkbox is checked successfully");
		}
		else
		{
			System.out.println("Notification checkbox could not be checked");
			Assert.assertFalse(false);
		}


// Step 4 : Enter alphanumeric phone number (invalid) where entered data length is greater than 7 characters

		String expValMsg="Please enter a phone number that's at least 7 numbers long.";
		WebElement phNum = driver.findElement(By.name("phone"));
		if (phNum.isDisplayed() && phNum.isEnabled()) {
			phNum.clear();
			phNum.sendKeys("TEST@1"); // Invalid phone number (alphanumeric) where string length is Less than 7 characters
			phNum.sendKeys(Keys.TAB);
			Thread.sleep(1000);
			
			WebElement validationMsg = 
			driver.findElement(By.xpath("//input[@id='phone-904e0350-5c3a-43a2-aa4c-434b02d38da6']/..//following-sibling::ul"));			
			WebElement valMsg= (new WebDriverWait(driver, 20))
					 .until(ExpectedConditions.visibilityOf(validationMsg));
			
			//Assert.assertTrue(validationMsg.isDisplayed() && validationMsg.getText().equals("Must contain only numbers, +()-. and x."));
	
			if(validationMsg.isDisplayed())
			{
				if(validationMsg.getText().contains(expValMsg))
				{
					System.out.println("Validation message is -->" + validationMsg.getText());
					System.out.println("Test Passed as correct validation message is being displayed");
				}
				
			}
			
			else
			{
				System.out.println("Test is failed as system fails to throw validation message");
			}
			
	 }	
}	
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
}

	
	
	@AfterMethod()
	public void tearDown()
	{
		System.out.println("Inside after method");
		driver.quit();
	}
}
