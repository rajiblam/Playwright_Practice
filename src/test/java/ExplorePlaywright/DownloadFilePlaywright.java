package ExplorePlaywright;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadFilePlaywright {

	@Test
	public void downloadFileSVG() throws IOException
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
								.setRecordVideoDir(Paths.get("SaveVideo/"))
														.setRecordVideoSize(1024,768));
		Page page = context.newPage();
		String dirPath=System.getProperty("user.dir");
		FileInputStream filePath = new FileInputStream(dirPath+"\\src\\main\\java\\Com\\qa\\config\\config.properties");
		Properties prop = new Properties();
		prop.load(filePath);
		page.navigate(prop.getProperty("oURL"));
		page.locator("input[name=userId]").fill(prop.getProperty("oUserName"));
		page.locator("input[name=password]").fill(prop.getProperty("oPassword"));
		page.locator("//button[text()='Login']").click();
		page.locator("//p[text()='Audience']").first().click();
		page.locator("//p[text()='List']").click();
		page.locator("//button[text()='Import List']").click();
		
		Download sampleCSV = page.waitForDownload(()-> // download the file using waitForDownload method
		{
			page.click("//button[text()='Download Sample CSV']");
		}
				);
		sampleCSV.saveAs(Paths.get("DownloadFiles\\mySample3.csv")); // saving the file in same project
		System.out.println("This is URL "+sampleCSV.url());
		System.out.println("File has been successfully downloaded!!!!!!");
		page.close();
		context.close();
		browser.close();
		playwright.close();
	}
}
