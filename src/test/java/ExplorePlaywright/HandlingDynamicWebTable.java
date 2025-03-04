package ExplorePlaywright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingDynamicWebTable {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.dezlearn.com/webtable-example/");
		
		String name="Mayur Deshmukh"; // Passing target text to locator
		String dropDown="Suv"; // Passing target dropdown value to locator
		String xpathCheckBox="//td[text()='" + name + "']//following::td[3]//input"; // locating target name in table
		String xpathDropDown="//td[text()='" + name +"']//following::td[4]//select"; // locating target Dropdown
		Locator rows = page.locator(".tg tr"); // Locating all table rows and store in locator
		
		rows.locator(":scope", new Locator.LocatorOptions() // using ":scope" CSS pseudo-class find the name and click on checkbox
				.setHasText(name))
						.locator(xpathCheckBox)
								.click();
		
		rows.locator(":scope",new Locator.LocatorOptions() // using ":scope" CSS pseudo-class find the name and select dropdown value
				.setHasText(name))
						.locator(xpathDropDown)
								.selectOption(dropDown);
		page.waitForTimeout(3000);
		page.close();
		browser.close();
		playwright.close();
	}

}
