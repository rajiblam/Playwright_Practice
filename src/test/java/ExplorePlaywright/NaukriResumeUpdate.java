package ExplorePlaywright;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NaukriResumeUpdate {

	@Test
	public void uploadResume() throws IOException {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		String dirPath=System.getProperty("user.dir");
		FileInputStream filePath = new FileInputStream(dirPath+"\\src\\main\\java\\Com\\qa\\config\\config.properties");
		Properties prop = new Properties();
		prop.load(filePath);
		page.navigate(prop.getProperty("url"));
		page.click("#login_Layer");
		page.getByPlaceholder("Enter your active Email ID / Username").fill(prop.getProperty("username"));
		page.getByPlaceholder("Enter your password").fill(prop.getProperty("password"));
		page.click("button[type=submit]");
		page.click("//div[@class='view-profile-wrapper']//a[text()='View']");
		FileChooser fileChooser = page.waitForFileChooser(()->page.locator("input[type='button'][value='Update resume']").click());
		fileChooser.setFiles(Paths.get("D:\\Rajib\\Rajib_Lama_Update.pdf"));
		String sucessText=page.locator("//p[text()='Success']").innerText();
		Assert.assertTrue(sucessText.contains("Success"));
		System.out.println("Your Resume update Successfully!!!!");
		page.getByAltText("naukri user profile img").click();
		page.click("//a[text()='Logout']");
		String homePageText=page.locator("//h1[text()='Find your dream job now']").innerText();
		Assert.assertTrue(homePageText.contains("Find your dream"));
		System.out.println("You Logout Successfully!!!!!");
		page.close();
		context.close();
		browser.close();
		playwright.close();
	
	}

}
