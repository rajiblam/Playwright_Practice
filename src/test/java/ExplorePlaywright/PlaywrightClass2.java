package ExplorePlaywright;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightClass2 {

	public static void main(String[] args) throws IOException {

		Browser br=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=br.newPage();
		page.navigate("https://www.google.co.in/");
		page.locator("//textarea[@name='q']").fill("Hello");
		
		FileReader r = new FileReader("path");
		
		Properties prop = new Properties();
		prop.load(r);
		
		System.out.println(prop.getProperty("key"));
		
	}

}
