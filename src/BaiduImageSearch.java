import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *This class is for web search engine (Baidu image search: http://image.baidu.com/) testing, 
 *it tests the overlap rate of image URLs from resulting pages of image search.
 * @author Xiong Wen (xw926@uowmail.edu.au)
 */
public class BaiduImageSearch extends AutoImageSearch {

	/*
	 * search images for the given image url, then get a image url sample from
	 * /* the resulting page
	 * @see AutoImageSearch#search(java.lang.String, int)
	 */
	public LinkedList<String> search(String inputImageLink, int numOfRecords)
		throws InterruptedException {

		WebDriver driver = new FirefoxDriver();

		// And now use this to visit Google
		driver.get("http://image.baidu.com/");

		// wait until the appearance of input box
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("sttb")));

		// click to open the input box for entering image url
		WebElement openImageInputBox =
			driver.findElement(By.xpath("//a[@id='sttb']"));
		openImageInputBox.click();

		// input image url
		WebElement input = driver.findElement(By.name("objurl"));
		input.sendKeys(inputImageLink);

		// click to search
		WebElement submit =
			driver.findElement(By.xpath("//input[@id='sbobj']"));
		submit.click();

		Thread.sleep(2000);

		// System.out.println("start to find the moreLink");
		WebElement getVisuallySimilarImages =
			driver.findElement(By.xpath("//div[@id='simiDom']//div[@class='right_dom_tit']"));
		WebElement linkToVisuallySimilarImages =
			getVisuallySimilarImages.findElement(By.xpath("a[@class='moreLink']"));

		String searchResult = linkToVisuallySimilarImages.getAttribute("href");
		// test the capture of the link for more
		// System.out.println("The link for more: " + searchResult);
		driver.get(searchResult);

		// load the html tags in 14 phases to be ready for getting <img> tags
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 14; i++) {
			js.executeScript("window.scrollBy(0,800)");
			try {
				Thread.sleep(400);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// fetch the <img> tags
		List<WebElement> resultsImgTags =
			driver.findElements(By.xpath("//div[@class='thumb-item']//a[@class='thumb-link']//img"));
		int sizeOfImgTags = resultsImgTags.size();
		// test the capture of <img> tags
		// System.out.println("The number of <img> tags: " + sizeOfImgTags);
		// System.out.println();

		String imgUrl = null;
		LinkedList<String> sampleImgUrl = new LinkedList<String>();

		numOfRecords =
			(numOfRecords <= sizeOfImgTags) ? numOfRecords : sizeOfImgTags;
		//
		for (int i = 0; i < numOfRecords; i++) {
			// get image url in src=""
			imgUrl = resultsImgTags.get(i).getAttribute("src");
			sampleImgUrl.add(imgUrl);
			imgUrl = null;

		}
		// close browser
		driver.quit();
		return sampleImgUrl;

	}

	public static void main(String[] args)
		throws InterruptedException, IOException {

		// input: audi logo
		String inputImg =
			"http://ts2.mm.bing.net/th?id=HN.608023131377893893&pid=15.1";

		int numOfRecords = 200;

		LinkedList<String> sample1 = new LinkedList<String>();
		LinkedList<String> sampleB = new LinkedList<String>();

		String resultFileName = "BaiduResult.txt";
		// open file
		FileWriter fileWriter = new FileWriter(resultFileName);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		BaiduImageSearch imgSearcher = new BaiduImageSearch();
		sample1 = imgSearcher.search(inputImg, numOfRecords);

		int overlap1_B = 0;
		//do the comparison between 50 samples to calculate the overlap rate
		for (int i = 0; i <= 48; i++) {
			//generate test cases automatically 
			sampleB = imgSearcher.search(sample1.get(i), numOfRecords);
			overlap1_B = imgSearcher.calculateOverlap(sample1, sampleB);
			System.out.println(String.format(
				"Overlap of sample1 and sample%d:   %.0f %% [%d/%d] ", i + 2,
				Math.ceil(overlap1_B * 100.0 / numOfRecords), overlap1_B,
				numOfRecords));
			bufferedWriter.write(String.format(
				"Overlap of sample1 and sample%d:   %.0f %% [%d/%d] \n", i + 2,
				Math.ceil(overlap1_B * 100.0 / numOfRecords), overlap1_B,
				numOfRecords));
			bufferedWriter.flush();
			overlap1_B = 0;
			// sampleA = sampleB;
			sampleB = null;

		}
		//close file
		bufferedWriter.close();

	}
	

}
