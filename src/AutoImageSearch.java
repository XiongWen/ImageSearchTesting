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

/**
 *This class is for web search engine (Google image search: http://images.google.com/) testing, 
 *it tests the overlap rate of image URLs from resulting pages of image search.
 * @author Xiong Wen (xw926@uowmail.edu.au)
 */
public class AutoImageSearch {
 
	/**
	 * This method searches images according to the given image url, then get a
	 * sample image URLs from the resulting page
	 *  
	 * @param inpuImageLink
	 *            The image URL for image search
	 * @param numOfRecords
	 *            The number of records needs to be captured for analysis
	 * @return sampleImgUrl a sample set of image URLs captured(the number
	 *         equals numOfRecords)
	 * @author Xiong Wen (xw926@uowmail.edu.au)
	 * @throws InterruptedException
	 */

	public LinkedList<String> search(String inputImageLink, int numOfRecords)
		throws InterruptedException {

		WebDriver driver = new FirefoxDriver();

		// And now use this to visit Google
		driver.get("http://images.google.com/");
		// Alternatively the same thing can be done like this
		// driver.navigate().to("http://www.google.com");

		// click to open the input box for entering image url
		WebElement openImageInputBox =
			driver.findElement(By.xpath("//div[@id='gs_st0']//a"));
		openImageInputBox.click();

		//input image URL to be ready for search
		WebElement input = driver.findElement(By.name("image_url"));
		input.sendKeys(inputImageLink);
	

		// find the search button and click to take a search
		WebElement submit =
			driver.findElement(By.xpath("//td[@id='qbbtc']//input"));
		submit.click();
		//wait for a while to allow enough time for javascript execution for searching
		Thread.sleep(300);
		
		//get the div of "Visually Similar Images" 
		WebElement getVisuallySimilarImages =
			driver.findElement(By.xpath("//div[contains(@class, '_un _yc _ho')]//a"));
		
		//test if the link address of "Visually Similar Images" captured
//		String searchResult = getVisuallySimilarImages.getAttribute("href");
//		System.out.println("the link of Visually Similar Images: " + searchResult);
		
		//click to get the resulting page
		getVisuallySimilarImages.click();


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
			driver.findElements(By.xpath("//div[@class='rg_di']//a//img"));
		int sizeOfImgTags = resultsImgTags.size();
		// System.out.println("The number of <img> tags: " + sizeOfImgTags);
		// System.out.println();

		String imgUrl = null;
		LinkedList<String> sampleImgUrl = new LinkedList<String>();
		numOfRecords =
			(numOfRecords <= sizeOfImgTags) ? numOfRecords : sizeOfImgTags;

		for (int i = 0; i < numOfRecords; i++) {
			// get image url in src="" 
			imgUrl = resultsImgTags.get(i).getAttribute("src"); 
			sampleImgUrl.add(imgUrl);
			//test the capture of imgUrl
			// System.out.format("img URL %d : %s", i, imgUrl);
			// System.out.println();
			imgUrl = null;

		}

		driver.quit(); //close the browser
		return sampleImgUrl;

	}

	/**
	 * This method calculates the overlaps of two sample sets of image URLs
	 * 
	 * @param sample1
	 *            The image URLs for a resulting pages of a image search
	 * @param sample2
	 *            The image URLs for the other resulting pages of a image search
	 * @return overlap The number of overlaps of image URLs
	 * @author Xiong Wen (xw926@uowmail.edu.au)
	 */
	public int calculateOverlap(
		LinkedList<String> sample1, LinkedList<String> sample2) {
		
		int overlap = 0;
		for (String str1 : sample1) {
			for (String str2 : sample2) {
				if ((str1 != null) && (str2 != null)) {
					//if the image URLs are equal, then count it as overlap 
					if (str1.equalsIgnoreCase(str2)) { 
						overlap++;
					}
				}

			}
		}
		return overlap;
	}

	public static void main(String[] args)
		throws IOException, InterruptedException {

		//define the sample size
		int numOfRecords = 200;

		LinkedList<String> sample1 = new LinkedList<String>();
		LinkedList<String> sampleB = new LinkedList<String>();

		String inputFileName = "C5.txt";
		String resultFileName = "result5.txt";
		
		//open file
		FileWriter fileWriter = new FileWriter(resultFileName);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		List<String> inputImgs = null;
		inputImgs = TestCaseReader.read(inputFileName); //get input image URLs

		AutoImageSearch imgSearcher = new AutoImageSearch();

		for (int i = 0; i < 3; i++) {//read input test cases(image URL) form txt file
			System.out.println(String.format("Group %d :", i + 1));
			bufferedWriter.write(String.format("Group %d :\n", i + 1));
			bufferedWriter.flush();
			sample1 = imgSearcher.search(inputImgs.get(i), numOfRecords);

			int overlap1_B = 0;
			// sampleA = sample3;
			
			// do comparison between 50 samples with each sample has 200 image URLs
			for (int j = 0; j <= 48; j++) {
				//generate test cases automatically 
				sampleB = imgSearcher.search(sample1.get(j), numOfRecords);
				overlap1_B = imgSearcher.calculateOverlap(sample1, sampleB);
				System.out.println(String.format(
					"Overlap of sample1 and sample%d:   %.0f %% [%d/%d] ", j + 2,
					Math.ceil(overlap1_B * 100.0 / numOfRecords), overlap1_B, numOfRecords));
				//write the result to result file
				bufferedWriter.write(String.format(
					"Overlap of sample1 and sample%d:   %.0f %% [%d/%d] \n",
					j + 2, Math.ceil(overlap1_B * 100.0 / numOfRecords), overlap1_B,
					numOfRecords));
				bufferedWriter.flush();
				
				overlap1_B = 0;
				sampleB = null;

			}

		}
		//close file
		bufferedWriter.close();

	}
}
