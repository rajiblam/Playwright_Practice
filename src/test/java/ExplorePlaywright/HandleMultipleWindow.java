package ExplorePlaywright;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleMultipleWindow {

	@Test
	public  void multipleWindow() {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		//page.navigate("https://selectorshub.com/xpath-practice-page/");
		Page YTPage = context.waitForPage(()->
		{
			page.locator("(//*[local-name()='svg'])[1]").click();	
		}
				);
		YTPage.waitForLoadState();
		YTPage.locator("(//input[@name='search_query'])[1]").fill("Rajib Lama");
		String TYPageTitle = YTPage.title();
		System.out.println("YT Page Titlle"+TYPageTitle);
		page.waitForTimeout(2000);
		page.bringToFront();
		String parentPageTitle = page.title();
		System.out.println("Parent Page Title : "+parentPageTitle);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/23jan1.png")).setFullPage(true));
		page.close();
		context.close();
		browser.close();
		playwright.close();
	}

}
