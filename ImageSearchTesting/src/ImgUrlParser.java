//
//
//
//		 FirefoxProfile profile = new FirefoxProfile();
//	        profile.setPreference("general.useragent.override", "some UA string");
//	        WebDriver driver = new FirefoxDriver(profile);
//
//	        String Url = "http://www.walmart.com/ip/Generic-14-MP-X400-BK/19863348";
//	        driver.get(Url);
//	        List<WebElement> resultsDiv = driver.findElements(By.xpath("//table[contains (@class,'SpecTable')//td"));
//
//	        System.out.println(resultsDiv.size());
//	        for (int i=0; i<resultsDiv.size(); i++) {
//	            System.out.println(i+1 + ". " + resultsDiv.get(i).getText());
//	        }
//
//	}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shawn
 */
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImgUrlParser {

	
	// use this one to capture the image url
	public static String[] getImgUrlFromResultPage(String resultPage, int numOfRecords){
//		int numOfRecords = 100;
		String[] sampleImgUrl = new String[numOfRecords];
		WebDriver driver = new FirefoxDriver();
		driver.get(resultPage);
		WebDriverWait wait=new WebDriverWait(driver, 25);
		
//		//failed to do the waiting for loading
//		WebDriverWait wait =new WebDriverWait(driver,300);// The int here is the maximum time in seconds the element can wait.
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fsl")));
		
		
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(500);
		
//		load the html tags in 10 phases to be ready for getting <img> tags
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 for (int i = 0; i < 20; i++){
			 js.executeScript("window.scrollBy(0,900)");
			 try {
				Thread.sleep(500);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 }
		 //fetch the <img> tags
		List<WebElement> resultsImgTags =
			driver.findElements(By.xpath("//div[@class='rg_di']//a/img"));
		int sizeOfImgTags = resultsImgTags.size();
		System.out.println("The number of <img> tags: " + sizeOfImgTags);
		System.out.println();

		String imgUrl = null;
		numOfRecords = (numOfRecords <= sizeOfImgTags)?numOfRecords:sizeOfImgTags;
		
			for (int i = 0; i < numOfRecords; i++) {
				imgUrl = resultsImgTags.get(i).getAttribute("src"); //get image url in src=""
				sampleImgUrl[i] = imgUrl;

				System.out.format("img URL %d : %s", i, sampleImgUrl[i]);
				System.out.println();

			}
//		
//		else{
//			System.out.println("Error: There are not enough images to capture!");
//		}
		
		
		driver.quit();
		return sampleImgUrl;
	}

	public static void main(String[] args) {

		// Create a new instance of the Firefox driver
		// Notice that the remainder of the code relies on the interface,
		// not the implementation.

		// And now use this to visit Google
		// String imageURL =
		// "https://www.google.com.au/search?tbs=simg:CAESpAEaoQELEKjU2AQaAggKDAsQsIynCBo8CjoIAhIU3QjzFtoM4AjIFNIN3wvfCOcL7RQaIK0fqlUUxM_1AMJWB6Na89I44EusgIx7fF_1AQGiF7HytoDAsQjq7-CBoKCggIARIEVu2-vAwLEJ3twQkaNQoGCgRsb2dvCgYKBHRleHQKBgoEZm9udAoNCgthbGxveSB3aGVlbAoMCgphdXRvbW9iaWxlDA&q=audi+logo&tbm=isch&sa=X&ei=PTh0U8ajC8ftkgWa-4DYAg&ved=0CDgQsw4&biw=1280&bih=635";
		// String imageURL2=
		// "https://www.google.com/search?tbs=simg:CAESngEamwELEKjU2AQaAggKDAsQsIynCBo8CjoIAhIU3QjaDM4N4w3JFPEW2wjzFu0U0g0aIFAz3Rm4slCxHAtxBQfpx0o4DLM_1V6TT5X90udcBlifCDAsQjq7-CBoKCggIARIEHaYR3QwLEJ3twQkaLwoGCgR0ZXh0CgYKBGZvbnQKBgoEbG9nbwoJCgdnbGFzc2VzCgoKCHdlYiBwYWdlDA&q=audi+logo&tbm=isch&sa=X&ei=iIB2U7KZI4jtlAXi04HwAg&ved=0CDoQsw4&biw=960&bih=501&dpr=1";
		// String imageURL3 =
		// "https://www.google.com/search?tbs=simg:CAEShwEahAELEKjU2AQaAggKDAsQsIynCBo8CjoIAhIU2QuTCN8I1AvTC9EM2AvjC4cImAwaIBSkeVHJbE8N5PBdZcPnx5YagHVFGrkQpL2aSiiDlq_1CDAsQjq7-CBoKCggIARIEGoOZQAwLEJ3twQkaGAoGCgR0ZXh0CgYKBGxvZ28KBgoEZm9udAw&q=audi+logo+vector&tbm=isch&sa=X&ei=6e12U4mNJIuZkgXZqoB4&ved=0CDoQsw4&biw=1280&bih=672&dpr=1";

		// String imageURL =
		// "file:///Users/Shawn/Projects/ImageSearchTesting/926/result1.htm";
		// String imageURL2 =
		// "file:///Users/Shawn/Projects/ImageSearchTesting/926/result2.htm";

		int overlap = 0;

		String resultPage =
			"https://www.google.com.au/search?tbs=simg:CAESpAEaoQELEKjU2AQaAggKDAsQsIynCBo8CjoIAhIU3QjzFtoM4AjIFNIN3wvfCOcL7RQaIK0fqlUUxM_1AMJWB6Na89I44EusgIx7fF_1AQGiF7HytoDAsQjq7-CBoKCggIARIEVu2-vAwLEJ3twQkaNQoGCgRsb2dvCgYKBHRleHQKBgoEZm9udAoNCgthbGxveSB3aGVlbAoMCgphdXRvbW9iaWxlDA&q=audi+logo&tbm=isch&sa=X&ei=PTh0U8ajC8ftkgWa-4DYAg&ved=0CDgQsw4&biw=1280&bih=635";
		String resultPage2 =
			"https://www.google.com/search?tbs=simg:CAESngEamwELEKjU2AQaAggKDAsQsIynCBo8CjoIAhIU3QjaDM4N4w3JFPEW2wjzFu0U0g0aIFAz3Rm4slCxHAtxBQfpx0o4DLM_1V6TT5X90udcBlifCDAsQjq7-CBoKCggIARIEHaYR3QwLEJ3twQkaLwoGCgR0ZXh0CgYKBGZvbnQKBgoEbG9nbwoJCgdnbGFzc2VzCgoKCHdlYiBwYWdlDA&q=audi+logo&tbm=isch&sa=X&ei=iIB2U7KZI4jtlAXi04HwAg&ved=0CDoQsw4&biw=960&bih=501&dpr=1";
		int numOfRecordsToGet = 100;
		String[] result1 = new String[numOfRecordsToGet];
		String[] result2 = new String[numOfRecordsToGet];
		result1 = getImgUrlFromResultPage(resultPage, numOfRecordsToGet);
		result2 = getImgUrlFromResultPage(resultPage2, numOfRecordsToGet);
		// Alternatively the same thing can be done like this
		// driver.navigate().to("http://www.google.com");

		// compare the two sample img url array to count the overlap
		for (int m = 0; m < result1.length; m++) {
			for (int n = 0; n < result2.length; n++) {
				if ((result1[m] != null) && (result2[n] != null)) {
					if (result1[m].equalsIgnoreCase(result2[n])) {
						overlap++;
					}
				}
			}
		}

		System.out.format("The number of overlap images between [%d] and [%d]: %s", result1.length,result2.length, overlap);
		// //Close the browser

	}
}
