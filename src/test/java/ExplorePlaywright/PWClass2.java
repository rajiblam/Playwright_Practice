package ExplorePlaywright;

import java.nio.file.Paths;

import org.xml.sax.ext.Locator2Impl;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.MouseButton;

public class PWClass2 {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.omind.ai/");
		page.getByText("Schedule A Demo").first().click();
		page.getByPlaceholder("Enter Here").first().fill("Rajib Lama");
		
		page.keyboard().down("Control"); //press the control key
		page.keyboard().press("a"); // press the 'a' key (ctrl + a) = Select All
		page.keyboard().up("Control"); // Release the Control key
		
		page.keyboard().down("Control"); // Again press the control key
		page.keyboard().press("c"); // with combination of 'c' = (ctrl + c) = Copy above select text
		page.keyboard().up("Control"); // Release control key which was previously press
		
		page.keyboard().press("Tab"); // Now press tab to move cursor to next text box
		
		page.keyboard().down("Control"); // Now press control 
		page.keyboard().press("v"); // press 'v' combination of (ctrl + v) = Paste
		page.keyboard().up("Control"); // release control key 

//		page.keyboard().down("Control");
//		page.keyboard().press("v");
//		page.locator("//input[@name='First Name']").fill("Ravi");
//		page.locator("//input[@name='Last Name']").fill("Kumar");
//		page.locator("//input[@name='Business Email']").fill("ravikumar@gmail.com");
//		page.locator(".iti__selected-flag").click();
//		page.locator("//span[text()='Canada']").click();
//		page.locator("input[name='Phone Number']").fill("123456789");
//		page.locator("input[name='Job Title']").fill("Frontent Developer");
//		page.locator("input[name='Country']").fill("Canada");
//		page.locator("input[name='Company']").fill("HCL");
//		page.locator("select[name='How can we best support you?']").selectOption("Arya AI");
		
		
//		context.tracing().start(
//		new Tracing.StartOptions()
//		.setScreenshots(true)
//		.setSnapshots(true)
//		.setSources(true)
//		);
//		context.tracing().stop(
//				new Tracing.StopOptions()
//				.setPath(Paths.get("traceRajib.zip"))
//				);
		
//		page.close();
//		context.close();
//		playwright.close();
//		page.locator("//input[@name='firstname']").fill("Rajib");
//		page.locator("//input[@name='lastname']").fill("Lama");
//		Locator day = page.locator("select#day");
//		Locator month = page.locator("select#month");
//		Locator year = page.locator("select#year");
//		day.selectOption("4");
//		month.selectOption("Mar");
//		year.selectOption("2000");
//		page.locator("input#sex").nth(1).click();
//		page.locator("//input[@name=\"reg_email__\"]").fill("12345678");
//		page.locator("input#password_step_input").fill("123456");
//		page.locator("//button[text()='Sign Up']").first().click();
//		
//		//Taking visible screenshot
//		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/visiblePage.png")));
//		//Taking full page screenshot
//		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./target/fullPage.png")).setFullPage(true));
		
		
	}

}
