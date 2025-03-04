package ExplorePlaywright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class demoPW {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.google.com");
		
		//taking screenshot
		
		//page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("path")).setFullPage(true));
		
		//handling alert
//		page.onDialog(dialog->{
//			dialog.accept();
//			dialog.dismiss();
//		});
		
//		Page mulPage = context.waitForPage(()->
//		{
//			page.getByText("button").click();
//		});
//		
//		mulPage.waitForLoadState();
//		mulPage.getByPlaceholder("").click();
		//tracing start
//		context.tracing().start(new Tracing.StartOptions()
//				.setScreenshots(true)
//				.setSnapshots(true)
//				.setSources(true)
//				);
//		
//		//tracing stop
//		
//		context.tracing().stop(new Tracing.StopOptions()
//				.setPath(Paths.get("")));
		
		Download download = page.waitForDownload(()->
		{
			page.getByPlaceholder("").click();
		});
		
		download.saveAs(Paths.get(""));
	}

}
