package ExplorePlaywright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleShadowDom {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		Locator shadowRoot = page.locator("#userName").first();
		shadowRoot.locator("#kils").fill("hellow");
	}

}
