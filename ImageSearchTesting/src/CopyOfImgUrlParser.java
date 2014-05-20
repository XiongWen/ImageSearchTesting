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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;




public class CopyOfImgUrlParser  {
	
//	String[] imgUrls;
	
	public static String[] getImgUrls(String webpage, int printSwitch){
		
//		String[] imgUrlsArray = new String[100];
		
		 WebDriver driver = new FirefoxDriver();
		 driver.get(webpage);
		 
//		 (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//	            public Boolean apply(WebDriver d) {
//	                return d.getTitle().toLowerCase().startsWith("cheese!");
//	            }
//	        });
		 
//		 WebDriverWait wait=new WebDriverWait(driver, 10);
		 
		 List<WebElement> resultsImgs = driver.findElements(By.xpath("//div[@class='rg_di']//a"));
	
		 if(printSwitch == 1){
			 System.out.println("===========BEGIN=========");
			 System.out.println(resultsImgs.size());
		 }
		 
		 String[] imgUrlsArray = new String[resultsImgs.size()];
		 
	        int count = 0;
	        
	        
	        
//	        for(WebElement el: resultsImgs){
//	        	String imgUrl = el.getAttribute("src");
//	        
//	        	System.out.println(imgUrl);
//	        	System.out.println();
////	        	if(count == 0){
////	        		driver.get(imgUrl);
////	        		++count;
////	        	}
//	        }
	        
	        //assign the value of  src of img to the string array
	        
	        for(int i = 0; i<resultsImgs.size(); i++){
	        	String imgUrl = resultsImgs.get(i).getAttribute("src");
	        	imgUrlsArray[i] = imgUrl;
	        	if(printSwitch == 1){
	        		System.out.println(imgUrlsArray[i]);
		        	System.out.println();
	        	}
	        	
	        }
//	        driver.quit(); //close window
	        if(printSwitch == 1){
	        	System.out.println("===========END=========");
	        }
	        
		return imgUrlsArray;
	}
	
	
	
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
//        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
//		String imageURL = "https://www.google.com.au/search?tbs=simg:CAESpAEaoQELEKjU2AQaAggKDAsQsIynCBo8CjoIAhIU3QjzFtoM4AjIFNIN3wvfCOcL7RQaIK0fqlUUxM_1AMJWB6Na89I44EusgIx7fF_1AQGiF7HytoDAsQjq7-CBoKCggIARIEVu2-vAwLEJ3twQkaNQoGCgRsb2dvCgYKBHRleHQKBgoEZm9udAoNCgthbGxveSB3aGVlbAoMCgphdXRvbW9iaWxlDA&q=audi+logo&tbm=isch&sa=X&ei=PTh0U8ajC8ftkgWa-4DYAg&ved=0CDgQsw4&biw=1280&bih=635";
//String imageURL2= "https://www.google.com/search?tbs=simg:CAESngEamwELEKjU2AQaAggKDAsQsIynCBo8CjoIAhIU3QjaDM4N4w3JFPEW2wjzFu0U0g0aIFAz3Rm4slCxHAtxBQfpx0o4DLM_1V6TT5X90udcBlifCDAsQjq7-CBoKCggIARIEHaYR3QwLEJ3twQkaLwoGCgR0ZXh0CgYKBGZvbnQKBgoEbG9nbwoJCgdnbGFzc2VzCgoKCHdlYiBwYWdlDA&q=audi+logo&tbm=isch&sa=X&ei=iIB2U7KZI4jtlAXi04HwAg&ved=0CDoQsw4&biw=960&bih=501&dpr=1";
//   String imageURL3 = "https://www.google.com/search?tbs=simg:CAEShwEahAELEKjU2AQaAggKDAsQsIynCBo8CjoIAhIU2QuTCN8I1AvTC9EM2AvjC4cImAwaIBSkeVHJbE8N5PBdZcPnx5YagHVFGrkQpL2aSiiDlq_1CDAsQjq7-CBoKCggIARIEGoOZQAwLEJ3twQkaGAoGCgR0ZXh0CgYKBGxvZ28KBgoEZm9udAw&q=audi+logo+vector&tbm=isch&sa=X&ei=6e12U4mNJIuZkgXZqoB4&ved=0CDoQsw4&biw=1280&bih=672&dpr=1";     

   String imageURL = "file:///Users/Shawn/Projects/ImageSearchTesting/926/result1.htm";
   String imageURL2 = "file:///Users/Shawn/Projects/ImageSearchTesting/926/result2.htm";
   //	driver.get(imageURL);
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
//        WebElement element = driver.findElement(By.name("q"));
        
//        List<WebElement> resultsImgs = driver.findElements(By.xpath("//div[@class='rg_di']//a/img"));
//        System.out.println(resultsImgs.size());
//        for(int i = 1; i< resultsImgs.size(); i++){
//        	resultsImgs[i].
//        }
//        int count = 0;
//        for(WebElement el: resultsImgs){
//        	String imgUrl = el.getAttribute("src");
//        	System.out.println(imgUrl);
//        	System.out.println();
////        	if(count == 0){
////        		driver.get(imgUrl);
////        		++count;
////        	}
//        }
        
	
//	
//   String[] sample3 = new String[100];
   
	int overlap = 0;
    
    int sample1_size = getImgUrls(imageURL,0).length; //no print, just get the size to create the string array
    String[] sample1 = new String[sample1_size]; 
    sample1 = getImgUrls(imageURL,1); //print img url, and assign the value to the array
    
    
//    
    int sample2_size = getImgUrls(imageURL2,0).length; //no print, just get the size to create the string array
    String[] sample2 = new String[100];
    sample2 = getImgUrls(imageURL2,1);   
//     sample3 = getImgUrls(imageURL3,1);
    
    
    
//    
    for (int m = 0; m<sample1_size; m++){
    	for (int n = 0; n<sample2_size; n++){
    		if( (sample1[m] != null)  &&  (sample2[n] != null)){
    			if (sample1[m].equalsIgnoreCase(sample2[n])){
        			overlap++;
        		}	
    		}
    		
    	}
    		
    }
    
    
    
    
    System.out.println("Overlap of the first 100 images: " + overlap);
//        //Close the browser
        
    }
}