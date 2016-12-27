package com.dns.searchresult;

/**
 * This is class for hold searchResultTitle and searchResultHref after the getting result from Google
 * Created by dhiren on 27/12/16.
 *
 * @author dhiren
 * @see com.dns.googlewebcrawling.GoogleSearchResultCrawler
 * @since 27-12-2016
 */
public class GoogleSearchResult {

    private final String searchResultTitle;

    private final String searchResultHref;

    public GoogleSearchResult(String searchResultTitle, String searchResultHref) {
        this.searchResultTitle = searchResultTitle;
        this.searchResultHref = searchResultHref;
    }

    public String getSearchResultHref() {
        return searchResultHref;
    }

    public String getSearchResultTitle() {
        return searchResultTitle;
    }
}
