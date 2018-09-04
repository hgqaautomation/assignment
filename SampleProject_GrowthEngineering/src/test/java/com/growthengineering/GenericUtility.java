package com.growthengineering;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import BaseSetUp.BaseSetUp;


public class GenericUtility extends BaseSetUp{
	
	public static void selectFromDropdown(WebElement we, String inputValue, String elementName) {
		try {
			Assert.assertTrue(we.isDisplayed() && we.isEnabled(),"Element" + elementName + "is not displayed & visible");

			Select select = new Select(we);
			List<WebElement> options = select.getOptions();
			System.out.println(options.size());
			for (WebElement opt : options) {
				if (opt.getText().equals(inputValue)) {
					select.selectByVisibleText(inputValue);
					break;
				}
			}

		} catch (Throwable e) {
			System.out.println("No such element");

		}
	}

}
