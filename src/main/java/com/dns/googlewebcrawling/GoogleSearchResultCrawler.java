package com.dns.googlewebcrawling;

import com.dns.searchresult.GoogleSearchResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;

/**
 * This is web crawling class that get search result from google
 * Created by dhiren on 27/12/16.
 *
 * @author dhiren
 * @see GoogleSearchResult
 * @since 27-12-2016
 */

public class GoogleSearchResultCrawler {


    private final PhantomJSDriver webDriver;

    public GoogleSearchResultCrawler() {
        DesiredCapabilities capabilities = DesiredCapabilities.phantomjs(); // This is Configuration class of PhantomJSDriver
        String[] args = {"--web-security=no", "--ignore-ssl-errors=yes",
                "--ssl-protocol=tlsv1"}; //Here I am creating phantomjs argument
        capabilities.setCapability(
                PhantomJSDriverService.PHANTOMJS_CLI_ARGS, args); //Set the phantomjs argument into configuration class
        String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
        capabilities.setCapability(
                PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX
                        + "userAgent", userAgent); //Some of site catch your crawling request as robot for that I am adding user agent into configuration
        webDriver = new PhantomJSDriver(capabilities); //PhantomJSDriver initialization
    }

    /**
     * This method is used for search phrase and term in google and fetch the result and create {@link GoogleSearchResult} that hold search result title and href
     *
     * @param phrase {@link String} searchTerm
     * @return java.util.List of {@link GoogleSearchResult}
     */
    public List<GoogleSearchResult> searchTermInGoogle(String phrase) {
        String BASE_URL = "https://www.google.co.in/search?q="; //This is base url of google search result
        webDriver.get(BASE_URL + phrase); //Here I am request with phrase
        List<WebElement> searchResults = webDriver.findElementsByCssSelector("div.g"); //Here I am using css selector. It is similar to Html Css selector for get search result list
        List<GoogleSearchResult> googleSearchResults = new ArrayList<>(); //Create List of of GoogleSearchResult
        for (WebElement webElement : searchResults)
            try {
                WebElement searchResult = webElement.findElement(By.cssSelector("h3.r>a")); //Here I am extracting Title and href of search result exact anchor tag element
                googleSearchResults.add(new GoogleSearchResult(searchResult.getText(), searchResult.getAttribute("href"))); //Get the anchor tag data and add into list
            } catch (Exception e) {
                e.printStackTrace();
            }
        return googleSearchResults;
    }
}
