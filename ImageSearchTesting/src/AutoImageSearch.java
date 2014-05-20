
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
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoImageSearch {

	public String[] search(String inputImageLink, int numOfRecords) {

		WebDriver driver = new FirefoxDriver();

		// And now use this to visit Google
		driver.get("http://images.google.com/");
		// Alternatively the same thing can be done like this
		// driver.navigate().to("http://www.google.com");

		// click to open the input box for entering image url
		WebElement openImageInputBox =driver.findElement(By.xpath("//div[@id='gs_st0']//a"));
		openImageInputBox.click();

		// input id="qbui" name="image_url"
		// try {
		// Thread.sleep(100);
		// }
		// catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//

		WebElement input = driver.findElement(By.name("image_url"));
//		String inputImg ="data:image/jpeg;base64,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";
		input.sendKeys(inputImageLink);

		// id="qbbtc"
		WebElement submit =
			driver.findElement(By.xpath("//td[@id='qbbtc']//input"));

		submit.click();
		try {
			Thread.sleep(100);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// WebElement getVisuallySimilarImages =
		// driver.findElement(By.xpath("//li[@id=‘imagebox_bigimages’]"));

		WebElement getVisuallySimilarImages =
			driver.findElement(By.xpath("//div[contains(@class, '_nn _zc _Xn')]//a"));

		// System.out.println(getVisuallySimilarImages.findElement(By.tagName("a")).getAttribute("href"));
		String searchResult = getVisuallySimilarImages.getAttribute("href");
		getVisuallySimilarImages.click();

		// #############

		// load the html tags in 10 phases to be ready for getting <img> tags
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
		System.out.println("The number of <img> tags: " + sizeOfImgTags);
		System.out.println();

		String imgUrl = null;
		String[] sampleImgUrl = new String[numOfRecords];
		numOfRecords =
			(numOfRecords <= sizeOfImgTags) ? numOfRecords : sizeOfImgTags;

		for (int i = 0; i < numOfRecords; i++) {
			imgUrl = resultsImgTags.get(i).getAttribute("src"); // get image url
																// in src=""
			sampleImgUrl[i] = imgUrl;

			System.out.format("img URL %d : %s", i, imgUrl);
			System.out.println();
			imgUrl = null;

		}
		System.out.println("\n\n");
		driver.quit();
		return sampleImgUrl;

	}
	
	public int calculateOverlap(String[] sample1, String[]sample2){
		int overlap = 0;
		for (int m = 0; m < sample1.length; m++) {
			for (int n = 0; n < sample2.length; n++) {
				if ((sample1[m] != null) && (sample2[n] != null)) {
					if (sample1[m].equalsIgnoreCase(sample2[n])) {
						overlap++;
					}
				}
			}
		}
		return overlap;
	}

	public static void main(String[] args) {
		
		String inputImg =
						"data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxQTEhUSEhQWFRUSFhsXGBgUFRcXFxgUFxcYHhwXHhcZHCggGBolHBcYITEiJykrLi4wHR8zODMsNygtLiwBCgoKDg0OGxAQGywmICUtLC83LzQ3Niw0Ky8sLC8vLjQsLDAvLDQtLC0tLDQ1LSwsLCw1LiwsLC8sLCwsNDAsLP/AABEIAMgA/AMBEQACEQEDEQH/xAAcAAEAAwEBAQEBAAAAAAAAAAAABQYHBAMCCAH/xABLEAABAwICBgYECAwEBwEAAAABAAIDBBEFEgYhMUFRYQcTInGBkRQyQqEjUmJykrGywSQzVGNzgoOTorPR0hU0U+EWFzVDo8LTdP/EABsBAQACAwEBAAAAAAAAAAAAAAADBAECBgUH/8QAOBEBAAECAgUJBgUFAQAAAAAAAAECAwQRBRIhMVETQWFxkaGx0eEGFCIygfAWMzRTwRUjUnKyYv/aAAwDAQACEQMRAD8A3FAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQedRO1jS55DWjaSgpeOaZSerSx8g94JJ+awff5IKFi2kNQHH0mtEZ3tdMGEfso9Y+ig4qTSuC9hXMvzdUN/idGB70FswnSiYDPHKZWDaWPbO0d+Ulzfcgt2B6Yxy6nkNPEHs+IOtqDsxzSiGn7N88nxGkauZOwD3oKhiWlVTI0vDhDGN4IY0d8j9/iEFPn0qiafhK5hP6SaX3xscPegkcN0uYSOprGOJ2ATujJ8Jgy6C2UWmj4yG1AOv47cpI4h47JQWyHHIHRGXrGta0XdmNsvf/ALbUFSxTpBzHJSs5B7xcn5rB9/kgruKaRStP4TVNiJ15ZJhGbfomdr+FBGxaZU17CuivzNSB9LqbILFhWlcxGaGQTtbt6qVk9hzbfO3yQWnA9NIZuy8hjuOsDxB1t+rmg9dI9Mqel7BPWS/EYRqvvc7Y0e/kgp8umNVPmLOwxu3q7Na350rtQ8wghKjS+Jv4ythv+mllP/iY4e9B7UWmbSfgqyBx3Dr5IieXwrWhBZqTTeWIgVLCGnY5wFiOIkb2SguuF4rFO3NG6/Ebx4feg7UBAQEBAQEBB8yPABJ1Aaygpek+JNDHz1D+rgiF9fu1e087AEFIwjCq/Ge2wuoKA6gR+Pnbfbfge8N+cgveCdF+GUwAFM2Vw2vn+FJPGzuyPABBYDgFLbL6NBl4dTHbyyoK9inRlQSHPFGaWUerJSkxOafmt7J8kFVrcFmil6mqIkPsVcLcrtewTRt2H5QvxN9wQuLiWncIxH1tTK6zQ/swx3NhJI/UCTtDAdms8CFswfooZIWzYrM+slt6gcWQM+S1rbavIckFyotFKKIWjpKdvdCy/ibXKDxxDQrD5vxlHATxEbWO+k0A+9BUsV0BdSMdJQykxDW6mqSXxEfJcdbXc9vytyCtVOFukjzR5omNdeWOW56mwPbGrtsOwFu02FroPbRnR+bEMwgkNHSsOV8gt6ZN/wDBh4eeZBfcH6NMNpxqpWSO2l8461xPHt3APcAgnXYDSkZTTQEcDDHbysgreLdF9BKc8Mfoso9V9McljxyDs+QB5hBTsWw6WCXqat3WEAFlXED1jL7OtaNbhxOtw23cEEFLhjoZfh2iWaZ9oYswaxwJ1TSyDU2LeANbuQQaBh3RiyTK/E5TUub6sMZMVLFyZG21+87d4QWui0VoohaOkp290LL+JtcoOfEtCcPnBEtHAb72xtY76TACPNBS8T6NZaQOfhcpdGdbqSc543D5JO/v18HBBXsNxF8RM1MHRPhPw1O692a7EtvrLL6iDs2HcUGu6L4+yshEjNThqe3gf6FBMICAgICAgIOOuGazN20/cgzSpwp2L4n1bwf8OoLOI3Tz3ItzGo+A+Ug1WNgaA1oAAFgALAAbABuCD6QEHxK/KCeAQUPTjFjR05laM9RM8Rwt+NPJqbq3gbbcgEETJgswh9ErHdZPFE2Vsnx2H1233ljzt4EILR0c4w6aB0MhvJTHISdrmH1HeQI8EFtQEELjt3kM9lvaPM7h96DPpqiolnnfTWNPhwyzN/KJXWMkfdHHfxN0HzhtYKGuZIw3p6kC/DI/W13eN/cg11AQeVTNka53AeZ3BBnOkk5iY6VzeskcQGs/1JpHBscfcXEDuBQQWK4VOA+mqnB9RGzr45B7TTre0cmuuQNwDhssgvvRzjhqaUNefhIew7mPZPuI8EFrQEBBRukPR7UK+nAE8Gt+rVJHaxDhv1ajxF+AQVDR7FBR1jJGEinqQHWPstcbOaebHfZPFBtCAgICAgICCJx6q6qmnmG1rHZfnWs332Qc+hFAIaOIb3jO7mXf7WCCeQEBB5TtvYcT9SCmV1K2oxqFjhdlBCZwN3XSHKD3gWKCf0hpMzoJQNccmV3OKRpa4eeU+CCnaIgxYm9o2SNLD3i7gf4SPFBpSAghsbnENPNUH2GOf9EEge4IOXQHBxT0EMZ7TntMshO10kpzOJ59q3ggpGlODlkDIz/25nsYfzZfdn3oNG0ZqDJSwud62QNd85nZJ82lBKIOerZms3nfy/3sgqslAJcSgafVpWuqLcZHXjjPheUoJLSfChI+CYanROcDq9ZjmHM33IKj0fxGCtcy+qXrYyPlRkFp8g5BpyAgIPl7QQQRcEWI5FBmOP6MsjiiY25AfI3XuLg+/heMHxQXnRKqMtHA92t3VhrvnM7JPm0oJdAQEBAQEEDpm29DNbgD4B7SfcgksGP4PDb/AEmfZCDsQEBB8naPFBVMKFsYrL7XQQkfNGo+9BY8RPY8W/aCCi4C3NXueP8AVIHg15PuKDREBBXdOmE4bUgf6Lj5NuUE3QOBijI2FjSO7KEFP01GYxs4zD+HMSgsGirbUzfnSfzHIJdB8H1h3H7kEBhzbYlUX308VvCWe/1hBLYm6zPE/Zd9yCl4JF+FxO+NUTHwMc39Ag0BAQEBBVtJCCGj84T/ADP6FB16ED8Eb+kmt3dfIgnkBAQEBAQVfSHSGnY6SjnzN61uXNlu3LILZr8Ab+SDq0MqS6nEbvXgJjcO7Ye631IJ5AQEEXpJWyQwGaJgkcwglpvraTY7OF7+BQUugx8vroKp8fVZgaWUXuLOOaJ1+BcHA8Lc0Fq0rxIRM5tBfb3NHi4hBD6E0ZDmk7WtL3H5b9QHkXeSC7ICDO9IMWq4ppIH5H0xJBFu31LxrAPEAkeCCw6GV/4GGyHt0t4pP2Y1OHJzMrh3oIGrn6ybOdkYLv1n2J/hAP6yC7YVTmOFjDtDRf5x1n3koOtBAaaMl9HzwSGN8bgbj4p1EHlrB8EFQ0ZxeVtUx1RIHm5iLrAdibLkJ7pWNbf86gt2k2IBpbGNZtmI5bB5+r+sEHFoxS3mB3RMOv5TtQ9wegtqAgIPiWQNBcdwugpeI1NyXHYwE9/E+ecjk4ILTgVIYqeKN3rNYM3zzrd/ESg7kBAQEBAQVzTLDBJGJQ0F0Y16rnJv8tvmgrOB4t1cgkbrIaGyMG18Tdj28XtGojgL8UGiUtS2Rgexwc1wuCEHqgIPmWMOBadYcLHuKDKsbpjDM6CRpc1/ZsNrmE3a5vygQCObUCpke97BJIJWgB3WC2WUtFgRa/Zbr1bcxdyQaJo/QmKLtCz363cuDfAe+6CTQEFT0+w0uj69guYxZ4HxOPgfcTwQUrCKhzmus4tvZjmah6QGa2tGu+Zg9a2sssNoFwtOjFF1rwTra053Hi69wPE6+4ILwgIPOohD2uY4Xa4FpHIixQYtjtPJTVJiLS8g2sL/AAkb9QsRvI2EbHDiEFgp3EuLny9a9x1v1XJZ2RHZurM32gN54ZSQvuCUXVR9r13nM7lwHgPfdBIICAgrOPYwHExRnU09pwOw8AfjcOHrbhmDkwWi62QXHYYQ53DV6rB5DVwCC4oCAgICAgIBCDNdNtGJISaimBLB2iGXzRke0La8vds7kFewTTh0Ju45L+s5rS6J/N0bdbXfKZfuCC/YVp1DK29s3F0Dmyt8mnM3uIugkXaV03GTuEMt/soK9j/SbBACG2a786e14QsvIfENHMIMf0o02qKx5bHn7fYzW+EcD7DGtv1bTwbdx3uOxBKUM1TQBkUsbm2a0mKS7dYAs9jhfI/V6wuNxBtqC/6PdKET7MkeM3xZi2GXzJ6uX9VwPJBcI9JoSLkSN74nn3tBB80HhW6YQRtLrSEDeW9W3xdLlAQZvpb0rNcDHEcwOrJC42PJ89rW5R3+cEFYoa2prIXvFO/JAQTJFcMjtezW21gi99Wzadt0E1o50jPpjlqL2P8A3WtzMfzkjbra/wCWzbvag03CNOIJxdpD+cLmyjxaO23uLQgk3aRQ/nDyEMt/soK9j/SHDACLsjNtXXOGbwhjzSO8ggokOmcdVN67zI7stdI2znA+yxrbhgN9gu47zrsghMYqarD6yR7WFoe4PdDJcNeB6sjSNbXgbHN17jfWEF+0Y6WYJQGyuDXbMsxbG/webRyebTyQXeLSOFwvaQfs3OHmwEHzQeVVpREwEhkhtvLOrb4ukygIKlXaaCpJjjmZlG1lO8Od3Om2D9S/eEHvgtA+YgMFmt2m3ZaD9ZPiTtJ3oL5RUjYmBjdg37yeJQe6AgICAgICAgIKlpH0f0tUS9oMMh2ujtYniWHUfCxQZtjXQ3V5s0LoZbbDmMb/ACII/iQRH/KvFTqMYt8qoaW+Wb7kExg3QlUEj0iaKJvCIGR3vDQPeg07RXQSjoO1FHmltYyydp/O25g+aAgmMYweGqZ1c8Ye3dfUQeIcNbT3IMy0k6GRJc00w5MnGz9o0f8Aqgpx6JcUjJDGMI/NVAA/iyoPSn6HsRkcDI2JnOWbMR9AOQXbR3oXp4yHVcrpyPYYDHH4kHM7zHcg02jpGRMbHExrGMFmtYA1oHAAIKjpP0a0lVdzQYJDtdGBlJ5xnV5WQZlinQrWtdeF0ErdxzOjf5EED6SDiHRXix7JZq51LS3yzH6kEzgvQjUEg1E0UTd4iBkd5kNAPmg1DRXQajoO1DHmltYyydqTwOxg5NAQSuM4LBVR9XURtkbuvqIPFrhrae5BlmkPQlmJdSVAF/Ynbfw6xv3tKCrHolxOM9iNh5xTho9+UoPWDohxKUjrBE3nLNmI+iHILxot0PQwObJUTPlcPZjvEzxIOZ3mEGlwQtY0NYA1o2ACwQeiAgICAgICAgICAgICDxqapkYzSPawXtd7g0X4XO9JnJvRRVXOVMTM9Dm/xum/KIf3rP6rGtHFJ7rf/wAKuyXTTVTJBmje14Btdjg4X4XG9InNHXbqonKqJjr2PZZaCAgICAgICD+PcACSQABck6gAN90ZiM9kOH/G6b8oh/es/qtdaOKb3W//AIVdkvelropL9XIx9tuR7XWvxsdSzExO5pXaro+emY64ydCyjEBAQEBAQEBAQEBAQEBAQEBBG6RiD0aX0oAw5Dnvw3W+Ve1ra72WKsstqzg+W5enkfmz2ffDj0Pzm8C5y3tc2va9t17b7Ko+lRnlt3rR0e6Teh1Fnn4CazX8GndJ4b+R5BbUVasvJ0xgPerOdMfHTu6eMeXS3UFWnBP6gICAgICAgIMh6SdCupLqunb8E7XIwD8WT7QHxDw3d2yvcoy2w7HQuluUiLF6fi5p49E9Pj176jo5jclHO2aPdqc3c9h2tP3HcbLSJynOHs43CUYq1Nuv6Twl+gMIxOOphZNEbseL8wd7SNxB1K1ExMZw+d4ixXYuTbrjbDsWUIgICAgICAgICAgICAgICAgx7pU0n66T0SI/BwntkHU6Ubu5v134BV7lWc5Oy0Do/kqOXrj4qt3RHr4daE0H0YNdMWm7Yo2kvcOJBytHMnX3ArWinWlf0ppCMHaiY+ad0eKFxOgfBK+GQWfG7KfuI5EWI5FazGWxesXqb1uLlG6Wq9FWk/Wx+hyn4SEfBk+1EPZ72/VbgVPaq5pclp7R/JV8vRHw1b+ifXxaCpXOsd090lq4a+aOKd7GNyWa0iwvGwndxJVeuqYq2S7PROj8NdwlFddETM57frKQ6LcfqaireyeZ8jRA5wDiLZs8Yvs4E+a2tzMztV9O4LD2MPTVboiJ1su6WpKZyjHtP9JKqGuljinexjQyzWkWF2NJ3cVXrqmKt7stEYDDXcJTXcoiZ2+KS6LMeqaipkZPM+RrYS4BxFgc7BfyJWbdUzO1W07grFixTVapiJ1v4lZNNNNY6GzGt6yZwuGXsGj4zj9Q38tq3rr1djzNG6Krxk60zlTHPx6mW4lpzXTE3ndGD7MPwYHiO15lQzXVPO6uxofB2t1GfXt9O5z09bXkZ2Pq3A77yvaRzvcOHI6liJnpSV2sDHw1RRHZE+cIZ97m4sb6xa1jwtu7lhejLLYtXR9pUaObI8/ATEB/yHbBIPv5dwW9FWrPQ8jS+joxVrWp+end0xw8ulpfSPiEkNC6SF5Y7OwBzTrsSpbkzFOxzGhrFF7FRRcjOMp2MlOmVd+VSeY/ooNari6/+lYP9uG84XIXQxOcbl0bCSd5LRcq1G58/vREXKojjLqWUYgICAgICAgICAgICCp9Imk3odPljPw812s4tHtSeG7mRwKjuVZQ9bRGA96vZ1fLTv6eEfXwYa1pJAG0m2s21nmfrVd3szFMZ8G46IOo6OmZD6TTl57Ujuuj1yHbv2DYOQVijKmMs3B6QjFYu/Nzk6st0bJ2QrXSlTU07W1ME8LpY+y9rZWEvj3EAHWWn3E8FpciJ2w9PQVy/Zqmzcoqimd05Tsn18Wc0FY+GRksZyvjcHNPMfWDsIUXU6a9aovUTbrjZL9B6M42ysp2Ts1E6ntvfJIPWb/TiCCrVNWtGb5zjcJVhb02qubdPGOaWOdJf/Uqj9n/ACmKC58ztdCfoaPr/wBSlOhv/Oyf/nd/MjW1reqe0f6Wn/aPCWyKdxbCek7/AKlN3M/ltVa580u+0H+io+vjKV6Gz+FzfoD9tiza3qntJ+no/wBv4lSsSrnTyyTP9aVxceV9g7gLDwUeee17lizTZt026d0Rk0Xon0aikY6rlaHuDy2MOsWtygXfb41zqvstzUtqmJ2y5rT+PuU1xh6JyjLOenPm6moqdyqt6a6MxVcDyWgSsaSyQCxBAvlJ3tOy3itK6YmHpaNx9zC3Yyn4ZnbH3zsDVZ9CaViVa6XR+NzzdzXtZfiGSFrf4QFJM523L2LVNrTFUU7spntjPxZqVG6h+lMG/wAvD+iZ9kK3TufML/5tXXPi7FlEICAgICAgICAgICDmxKuZBE+aU5WRtzE/cOJJ1AcSsTOUZpLNqu9XFuiM5l+etIcYfV1D55PaNmjc1g9Vo7veSTvVWZznOX0bB4WnC2YtU83fPPP3zOjC9Fauoj62GAvYSQHZmNBI22zOBPekUzO6Gl/SWGsV6lyvKfr/ABDr/wCAcQ/Jj+8i/vWdSrgh/rWC/c7p8j/gHEPyY/vIv701KuB/WsF+53T5IrGMFnpXNbURmMvF23LTcDbraSFiYmN61hsXZxMTNqrPL750z0f6S+h1Fnn4GazZBuad0nhv5E8AtqKtWVLS+A96s50x8VO7p6PLpdfSvRFlcZbdmdjXNO4loDSL+APiFm58yLQF2KsLqc9Mz37UZoLjzaOqErwSxzTG+20NcQc1t9i0e9a0Vas5rWlcHVi8PqU74nOPv6tak08oA3N6Q08g15ceWW11PylPFx8aHxs1avJz3eLGNJsW9KqpaixaJCMoO0NaA0X52F1XqnOc3bYHDe7Yem1nnl4ztXXoXonGSee3ZDBGDuLiQ4jwAHmFJajbMvD9pbsalFrnzz/j76lR0wwN1HUviI7BJdGdxjJ1eI2HuWlUas5PY0djKcVYivPbGyev13pbQHTP0LNFK0uhkdm7PrMdYAuAO0EAXHLzzRXqqmltFe95V0TlVGzrhpMWn2HuF/SAOTmSA+WVTcpS5irQ2NpnLk57vNV9MukeN0T4KPM4yNLTKQWgNOo5QdZdbfqtzWldzZlD1dHaCuRci5iNkRty359fNkzGngc9zWMaXOcQGtGsknYFC6quumimaqpyiGq6XYV6LgjIDtY5ma3x3PLneGYlTVU6tGTkdH4n3jSk3eOfZEZR3MmKhdg/SmDf5eH9Ez7IVunc+YX/AM2rrnxdiyiEBAQEBAQEBAQEBBV9N9G5q5rI2TNijaczgWklzt17Eahw49wUddM1PU0ZjreDqmuqjWq693cqLeiSS+upZbfaM3t9JacjPF7M+0tPNbnt9GnYfRshjZFGMrI2hrRyH1nmpojJy127Vdrmuuds7XQsoxBA6ZaNNroRGTkew5mPtex3gjeCPu4LSunWhf0dj6sHd14jOJ2THFRv+Ukn5Sz927+5R8lPF734lo/bnt9Fvo9Eg6jFHWubOI/xb2gtexttViSdY2cLWBC3ijZlU8a5pKacTOIw8aue+N8Tx7fFT8S6J5QSaedjhuEoLT9JtwfILSbU8z2rPtJRMf3aJjq290+aNHRhXfmf3h/tWvJ1LX4hwn/rs9UvhXRO64NTOLb2wgkn9d2z6K2i1xUsR7SRllZo+s+UebScNw+OCNsULAxjNgH1k7SeZU0REbIczevV3q5ruTnMvLGcGhqo+rnYHt2jcWniHDWCk0xO9vhsVdw9evanKfvez3EuibWTT1Grc2Zuv6bf7VFNrhLorPtLs/u0dnlPmh3dF1aDYGE887vvYtOSqXY9ocJMbquz1d1F0TzG3WzxsG/I1zz78q2i1POr3faS1H5dEz17PNetGtDqaj7UbS+S1usk1usdw3NHcO+6kpoil4ON0pfxeyucqeEbvX6vbTDAzWUxga8MJc12Yi47JvsCV060ZNNH4uMLfi7MZ7J71CPRJJ+Us/du/uUfIzxe/wDiWj9ue30ajQwZI2MJvkY1t+OUAX9ymjZDlblWtXNXGXustBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEH//2Q==";
		int numOfRecords = 200;	
		String[] sample1 = new String[numOfRecords];
		String[] sample2 = new String[numOfRecords];
		String[] sample3 = new String[numOfRecords];
		
		AutoImageSearch imgSearcher = new AutoImageSearch();
		sample1 = imgSearcher.search(inputImg, numOfRecords);
		sample2 = imgSearcher.search(sample1[1], numOfRecords);
		sample3 = imgSearcher.search(sample1[2], numOfRecords);
		
		System.out.println(String.format("Overlap of sample1 and sample2: %d %%  " , imgSearcher.calculateOverlap(sample1, sample2) * 100/numOfRecords));
		
		System.out.println("Overlap of sample2 and sample3: " + imgSearcher.calculateOverlap(sample2, sample3)/numOfRecords);

		System.out.println("Overlap of sample1 and sample3: " + imgSearcher.calculateOverlap(sample1, sample3)/numOfRecords);
		
		
	}
}
