package com.growthengineering;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseSetUp.BaseSetUp;
import junit.framework.Assert;

public class Scenario1_Test_Cases_All_Sub_Links_Verification extends BaseSetUp{
	
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
	 * Test Case 1: The following test will verify the working of all links of 'Solutions' menu
	 * 
	 */
	@Test
	public void verify_Solution_SubLinks() throws InterruptedException
	{
		try
		{
			System.out.println("Inside Solutions menu Sub links verification tests");
			List<String> expPageTitles = Arrays.asList("The #1 Learning Management System for Employee Engagement",
					"Genie - a collaborative content authoring tool", "The Knowledge Arcade - Growth Engineering",
					"eLearning - Training Content That Inspires Learners");

			List<String> actSubLinkTitles = new ArrayList<String>();
			Actions builder = new Actions(driver);
			WebElement solutionsLink = driver.findElement(By.xpath("//span[text()='Solutions']"));
			builder.moveToElement(solutionsLink).build().perform();
			List<WebElement> allSolutionLinks = driver
					.findElements(By.xpath("//span[text()='Solutions']/parent::a//following-sibling::ul//li//a"));
			int linksCount = allSolutionLinks.size();
			System.out.println("Count of links are " + allSolutionLinks.size());
			String[] links = new String[linksCount];

			// print all the links from webpage

			for (int i = 0; i < linksCount; i++) {
				links[i] = allSolutionLinks.get(i).getAttribute("href");
				System.out.println(allSolutionLinks.get(i).getAttribute("href"));
			}

			// navigate to each Link on the webpage

			for (int i = 0; i < linksCount; i++) {
				driver.navigate().to(links[i]);
				actSubLinkTitles.add(driver.getTitle());
				System.out.println("Title is ---->" + driver.getTitle());
			}

			for (int i = 0; i < expPageTitles.size(); i++) {
				if (actSubLinkTitles.get(i).equals(expPageTitles.get(i))) {
					System.out.println("Title matches for : " + actSubLinkTitles.get(i));
				}

				else {
					System.out.println("Title did not match for : " + actSubLinkTitles.get(i));
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	/*
	 * Test Case 2: The following test will verify the working of all links of 'Learning Engagement' menu
	 * 
	 */
	
	@Test
	public void verify_LearnerEngagement_SubLinks() throws InterruptedException
	{
		try {
			System.out.println("Inside Learner Engagement menu Sub links verification tests");
			List<String> expPageTitles = Arrays.asList("Gamification in Online Learning - the #1 Gamified LMS!",
					"Social Learning Platform - The Academy LMS",
					"Epic Meaning: How We Build Ideal Learning Environments",
					"Mobile Learning - Training Solutions for the Mobile Generation");

			List<String> actSubLinkTitles = new ArrayList<String>();
			// Actions builder= new Actions(driver);
			// WebElement solutionsLink=
			// driver.findElement(By.xpath("//span[text()='Learner
			// Engagement']"));
			// builder.moveToElement(solutionsLink).build().perform();
			List<WebElement> allSolutionLinks = driver.findElements(
					By.xpath("//span[text()='Learner Engagement']/parent::a//following-sibling::ul//li//a"));
			int linksCount = allSolutionLinks.size();
			System.out.println("Count of links are " + allSolutionLinks.size());
			String[] links = new String[linksCount];

			// print all the links from webpage

			for (int i = 0; i < linksCount; i++) {
				links[i] = allSolutionLinks.get(i).getAttribute("href");
				System.out.println(allSolutionLinks.get(i).getAttribute("href"));
			}

			// navigate to each Link on the webpage

			for (int i = 0; i < linksCount; i++) {
				driver.navigate().to(links[i]);
				actSubLinkTitles.add(driver.getTitle());
				System.out.println("Title is ---->" + driver.getTitle());
			}

			for (int i = 0; i < expPageTitles.size(); i++) {
				Assert.assertEquals(actSubLinkTitles.get(i), expPageTitles.get(i));
			}

			System.out.println("All links of Learner Engagement are navigated successfully ");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/*
	 * Test Case 3 :The following test will verify the working of all links of 'Success Stories' menu
	 * 
	 */
	
	@Test
	public void verify_SuccessStories_SubLinks() throws InterruptedException
	{
		try {
			System.out.println("Inside Learner Engagement menu Sub links verification tests");
			List<String> expPageTitles = Arrays.asList("Our Clients: Growth Engineering - Engaging Online Learning",
					"Award-Winning - Growth Engineering");

			List<String> actSubLinkTitles = new ArrayList<String>();
			List<WebElement> allSolutionLinks = driver
					.findElements(By.xpath("//span[text()='Success Stories']/parent::a//following-sibling::ul//li//a"));
			int linksCount = allSolutionLinks.size();
			System.out.println("Count of links are " + allSolutionLinks.size());
			String[] links = new String[linksCount];

			// print all the links from webpage

			for (int i = 0; i < linksCount; i++) {
				links[i] = allSolutionLinks.get(i).getAttribute("href");
				System.out.println(allSolutionLinks.get(i).getAttribute("href"));
			}

			// navigate to each Link on the webpage

			for (int i = 0; i < linksCount; i++) {
				driver.navigate().to(links[i]);
				actSubLinkTitles.add(driver.getTitle());
				System.out.println("Title is ---->" + driver.getTitle());
			}

			for (int i = 0; i < expPageTitles.size(); i++) {
				Assert.assertEquals(actSubLinkTitles.get(i), expPageTitles.get(i));
			}

			System.out.println("All links of Success Stories are navigated successfully ");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * Test Case 4 :The following test will verify the working of all links of 'Resources' menu
	 * 
	 */
	
	@Test
	public void verify_Resources_SubLinks() throws InterruptedException
	{
		try {
			System.out.println("Inside Learner Engagement menu Sub links verification tests");
			List<String> expPageTitles = Arrays.asList("GE TV - Growth Engineering",
					"Archives of Awesome - Growth Engineering", "Our Blog - Growth Engineering",
					"Webinars - Growth Engineering");

			List<String> actSubLinkTitles = new ArrayList<String>();
			List<WebElement> allSolutionLinks = driver
					.findElements(By.xpath("//span[text()='Resources']/parent::a//following-sibling::ul//li//a"));
			int linksCount = allSolutionLinks.size();
			System.out.println("Count of links are " + allSolutionLinks.size());
			String[] links = new String[linksCount];

			// print all the links from webpage

			for (int i = 0; i < linksCount; i++) {
				links[i] = allSolutionLinks.get(i).getAttribute("href");
				System.out.println(allSolutionLinks.get(i).getAttribute("href"));
			}

			// navigate to each Link on the webpage

			for (int i = 0; i < linksCount; i++) {
				driver.navigate().to(links[i]);
				actSubLinkTitles.add(driver.getTitle());
				System.out.println("Title is ---->" + driver.getTitle());
			}

			for (int i = 0; i < expPageTitles.size(); i++) {
				Assert.assertEquals(actSubLinkTitles.get(i), expPageTitles.get(i));
			}

			System.out.println("All links of Resources are navigated successfully ");

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * Test Case 5:The following test will verify the working of all links of 'About Us' menu
	 * 
	 */
	
	@Test
	public void verify_AboutUs_SubLinks() throws InterruptedException
	{
		try {
			System.out.println("Inside Learner Engagement menu Sub links verification tests");
			List<String> expPageTitles = Arrays.asList("Online Learning Superheroes: About Growth Engineering",
					"Growth Engineering Jobs - Growth Engineering",
					"GDPR: Growth Engineering Keep Your Secret Identity Secure");

			List<String> actSubLinkTitles = new ArrayList<String>();
			List<WebElement> allSolutionLinks = driver
					.findElements(By.xpath("//span[text()='About Us']/parent::a//following-sibling::ul//li//a"));
			int linksCount = allSolutionLinks.size();
			System.out.println("Count of links are " + allSolutionLinks.size());
			String[] links = new String[linksCount];

			// print all the links from webpage

			for (int i = 0; i < linksCount; i++) {
				links[i] = allSolutionLinks.get(i).getAttribute("href");
				System.out.println(allSolutionLinks.get(i).getAttribute("href"));
			}

			// navigate to each Link on the webpage

			for (int i = 0; i < linksCount; i++) {
				driver.navigate().to(links[i]);
				actSubLinkTitles.add(driver.getTitle());
				System.out.println("Title is ---->" + driver.getTitle());
			}

			for (int i = 0; i < expPageTitles.size(); i++) {
				Assert.assertEquals(actSubLinkTitles.get(i), expPageTitles.get(i));
			}

			System.out.println("All links of Resources are navigated successfully ");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Test Case 6:The following test will verify the working of 'Get In Touch' link
	 * 
	 */
	
	@Test
	public void verify_GetInTouch_Link() throws InterruptedException
	{
		try {
			System.out.println("Inside Contact Us verification test");
			String expPageTitle = "Contact the Engagement A-Team! - Growth Engineering";
			WebElement contactUS_Link = driver.findElement(By.xpath("//span[text()='Get in Touch']"));
			contactUS_Link.click();
			String contactUS_title = driver.getTitle();
			Assert.assertEquals(expPageTitle, contactUS_title);
			System.out.println("Contact us link clicked successfully");
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	/*
	 * 
	 * Following method will tear down the webdriver instance after finishing the browser actions
	 * 
	 */
	
	@AfterMethod()
	public void tearDown()
	{
		try {
			System.out.println("Inside after method");
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
