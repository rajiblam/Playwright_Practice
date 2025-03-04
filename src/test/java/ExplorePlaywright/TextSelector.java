package ExplorePlaywright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		String text=page.locator("h2:has-text('Sign In')").textContent();
		System.out.println("Page Text = "+text);
		String btnText = page.locator("button:has-text('Sign In')").textContent();
		System.out.println("Button text :"+btnText);
		
		String footerText = page.locator("h3:has-text('Learn Automation')").textContent();
		
		System.out.println("Footer text :"+footerText);
		
		String headerText=page.locator("div.navbar-menu-logo h1:has-text('Learn Automat')").textContent();
		System.out.println("Header Text : "+headerText);
		
		page.close();
		context.close();
		browser.close();
		playwright.close();
		
	}

}
