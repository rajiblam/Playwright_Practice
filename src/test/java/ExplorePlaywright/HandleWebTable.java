package ExplorePlaywright;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleWebTable {

	@Test
	public void handleWebTable()
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		Locator allTableData = page.locator("//table[@id='resultTable']//td");
		List<String> allVal = allTableData.allTextContents(); // store all TD value in list of string
		for(String s : allVal)
		{
			if(s.equals("John Smith"))
			{
				System.out.println(s);
				break;
			}
		}
		page.locator("//td[text()='John Smith']//preceding-sibling::td[2]//a").click(); 
		page.close();
		context.close();
		browser.close();
		playwright.close();
	}
}
