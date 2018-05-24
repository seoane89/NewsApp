package com.example.android.newsapp;

/**
 * Created by ti6a on 23-May-18.
 */
// News is a custom Object that contains information about a News article, derived from the Web Api
public class News {
    // Title of the News Article
    private String mTitle;
    // Section of the News Article
    private String mSection;
    // Author of the Article
    private String mAuthor;
    // Date of publishing
    private String mDate;
    // Web URL
    private String mWebUrl;

    public News(String title, String section, String author, String date, String webUrl){
        mTitle = title;
        mSection = section;
        mAuthor = author;
        mDate = date;
        mWebUrl = webUrl;
    }


    public String getTitle() {return mTitle;}
    public String getSection() {return mSection;}
    public String getAuthor() {return mAuthor;}
    public String getDate() { return mDate;}
    public String getWebUrl() {return mWebUrl;}
}
