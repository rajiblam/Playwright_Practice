package ExplorePlaywright;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PWsecondTest {
	Playwright playwright; 
	Browser browser; 
	BrowserContext browserContext; 
	Page page;
	@Test
	public void crossBrowserTesting()
	{
		String browerType="chrome";
		playwright=Playwright.create();
		switch(browerType.toLowerCase())
		{
		case "chromium": //Open Chromium browser
		browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		break;
		case "firefox": //Open Firefox browser
			browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		break;
		case "safari": //Open Safari browser
		browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		break;
		case "chrome": // Open Chrome Browser
		browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		break;
		case "msedge": // Open Chrome Browser
		browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
		break;
		default: // If user enter not supporting browser
		System.out.println("Not supporting browser");
		break;
		}
		browserContext=browser.newContext(); // create new browser context;
		page=browserContext.newPage(); // create new page
		page.navigate("https://www.google.com"); // using page instance open URL
		page.context().browser().close(); //close browser
	}
}
