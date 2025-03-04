package ExplorePlaywright;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleAlertPlaywright {

	@Test
	public void handleAlert() {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://demo.automationtesting.in/Alerts.html");
		page.locator("//a[contains(@href,'#Textbox')]").click();
		
		page.onDialog(dialog->{
			String text=dialog.message();
			System.out.println(text);
			dialog.accept("Rajib lama");
		}
				);
		page.locator("//button[contains(text(),'click the button')]").nth(2).click();
		String presstetx=page.locator("//p[contains(text(),'Hello ')]").innerText();
		System.out.println(presstetx);
		page.close();
		context.close();
		browser.close();
		playwright.close();
	}

}
