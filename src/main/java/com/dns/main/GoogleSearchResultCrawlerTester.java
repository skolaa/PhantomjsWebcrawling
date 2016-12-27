package com.dns.main;

import com.dns.googlewebcrawling.GoogleSearchResultCrawler;

/**
 * This is tester class of {@link GoogleSearchResultCrawler}
 * Created by dhiren on 28/12/16.
 * @author dhiren
 * @since 28-12-2016
 */
class GoogleSearchResultCrawlerTester {


    /**
     * This is main method . It is entry point of program
     *
     * @param args {@link System} arguments
     */
    public static void main(String[] args) {
        GoogleSearchResultCrawler googleSearchResultCrawler = new GoogleSearchResultCrawler();
        System.out.println("Title --------------------> Href");
        googleSearchResultCrawler.searchTermInGoogle("phantomjs").forEach(googleSearchResult -> System.out.println(googleSearchResult.getSearchResultTitle() + "-------------------->" + googleSearchResult.getSearchResultHref()));
    }
}
