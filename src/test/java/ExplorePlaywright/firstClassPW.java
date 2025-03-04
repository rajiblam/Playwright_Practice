package ExplorePlaywright;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class firstClassPW
{
	static Playwright pw = null;
	//static BrowserType browserType;
	static Browser browser = null;
	static Page page = null;
	static BrowserContext context=null;
	
	@BeforeMethod
	public static void setUP()
	{
			pw = Playwright.create();
			browser=pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));			
			context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1366,633));
			page = context.newPage();
			page.navigate("https://one.omind.ai/login");
			page.locator("xpath=//input[@name='userId']").fill("prodqa@omind.com");
			page.locator("xpath=//input[@name='password']").fill("Password@123");
			page.locator("xpath=//button[text()='Login']").click();
			
	}
	
	@AfterMethod
	public static void tearDown()
	{
		page.close();
		browser.close();
		pw.close();
	}
	
@Test(priority = 1)
public void loginLogoutTest()
{
		String titlePage = page.title();
		System.out.println("Page Title : " + titlePage);
		page.locator("xpath=//div[@aria-label='QA Team']").click();
		page.locator("xpath=//p[text()='Logout']").click();
		page.locator("xpath=//button[text()='Yes']").click();
}
@Test(priority = 2)
public void createSegmentTest()
{
	//page.pause();
	page.locator("xpath=//img[@src='/assets/common/audience.svg']").hover();
	page.locator("xpath=//img[@src='/assets/common/audience.svg']").click();
	page.locator("xpath=//P[text()='Segments']").click();
	page.getByText("Create Segment").click();
	page.locator("xpath=//p[contains(text(),'Build your segment')]").click();
	page.locator("xpath=//button[text()='Save & Next']").click();
	page.locator("xpath=(//input[@placeholder='Add a filter']//parent::div//descendant::img)[2]").click();
	page.locator("xpath=(//img[@alt='select value'])[1]").click();
	page.getByPlaceholder("Search").fill("age");
	page.locator("xpath=//p[text()='Age']").click();
	page.getByAltText("downIcon").click();
	page.locator("xpath=//p[text()='Equal To']").click();
	page.getByPlaceholder("Enter here").fill("50");
	page.locator("xpath=//button[text()='Save & Next']").click();
	page.getByPlaceholder("Enter only alphanumeric value").fill("AutomationPlaywright_"+System.currentTimeMillis());
	page.locator("xpath=(//*[name()='svg'][@stroke='currentColor'])[6]").click();
	page.locator("xpath=//button[text()='Save']").click();
	page.locator("xpath=//button[text()='Okay, Got It']").click();
	String createSegmentText = page.locator("//button[text()='Create Segment']").innerText();
	Assert.assertTrue(createSegmentText.contains("Create Segment"));
	System.out.println("Text ="+ createSegmentText);
}

//Test(priority = 3)
public void createCampaignWhatsApp()
{
	page.locator("a").filter(new Locator.FilterOptions().setHasText("Engage")).click();
    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Campaign")).click();
    page.getByText("Create Campaign").click();
  page.locator("xpath=//input[@name='campaignName']").fill("AutomationPlaywright_"+System.currentTimeMillis());
  page.locator("xpath=//p[text()='WhatsApp']").click();
  page.locator("xpath=//p[text()='Transactional']").click();
  page.locator("xpath=//button[text()='Save & Next']").click();
page.locator("xpath=(//input[@class='chakra-checkbox__input']//parent::label//span)[1]").click();
  page.locator("xpath=//button[text()='Save & Next']").click();
  page.locator("xpath=//tbody/tr[1]/td[7]/div[1]/img[1]//parent::div//parent::td//following-sibling::td").click();
page.locator("xpath=//button[text()='Save & Next']").click();
page.locator("//button[text()='Back']//following-sibling::button").click();
page.locator("xpath=//p[text()='Draft']").click();
page.locator("xpath=//button[text()='Save As Draft']").click();
page.locator("xpath=//button[text()='Okay, Got It']").click();
String createCampaignText = page.locator("//button[text()='Create Campaign']").innerText();
Assert.assertTrue(createCampaignText.contains("Create Campaign"));
System.out.println("Text ="+ createCampaignText);
}
}
	
	


	
