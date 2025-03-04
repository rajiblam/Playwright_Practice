package ExplorePlaywright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywroghtProgram {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("");
		
		page.onDialog(dialog->
		{
			dialog.accept();
		});
		
		FileChooser fc = page.waitForFileChooser(()->
		{
			page.getByText("xpath").click();
		});
		//fc.setFiles(null);
	}

}
