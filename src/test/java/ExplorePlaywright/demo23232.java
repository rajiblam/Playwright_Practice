package ExplorePlaywright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class demo23232 {

public static void main(String[] args) {
		
Playwright playwright = Playwright.create();
Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
BrowserContext HandleMutpleWindowcontext = browser.newContext();
Page page=HandleMutpleWindowcontext.newPage();
page.navigate("https://www.omind.ai/");
//page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/fullPageOmind.png")).setFullPage(true));
Page YTPage = HandleMutpleWindowcontext.waitForPage(()->
		{
			page.locator("//p[text()='Watch Demo']").click();
		});
YTPage.waitForLoadState();
String title=YTPage.title();
System.out.println(title);
//pageForTYChannel.locator("//p[text()='Watch Demo']").click();
page.close();
HandleMutpleWindowcontext.close();
browser.close();
playwright.close();

}
}
