package com.example.android.newsapp;

/**
 * Created by ti6a on 23-May-18.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each news Article
 * in the data source (a list of {@link News} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {
    private static final String TIME_SEPARATOR = "T";
    private static final String TIME_END = "Z";

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news    is the list of news, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays the News Article at the given position
     * in the list of news.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Find the news article at the given position in the list of news
        News currentNews = getItem(position);

        // Find the TextView with view ID news_title
        TextView titleView = (TextView) listItemView.findViewById(R.id.news_title);
        titleView.setText(currentNews.getTitle());
        // Find the TextView with view ID news_ssection
        TextView sectionView = (TextView) listItemView.findViewById(R.id.news_section);
        sectionView.setText(currentNews.getSection());
        // Find the TextView with view ID news_author
        TextView authorView = (TextView) listItemView.findViewById(R.id.news_author);
        if (currentNews.getAuthor() != null) {
            authorView.setText(currentNews.getAuthor());
        } else {
            authorView.setVisibility(View.GONE);
        }


        // Get the original Date string from the News object.
        String originalDateTime = currentNews.getDate();
        String primaryDate = "";
        String timeOffset = "";
        String finalTime = "";

        // Check whether the originalDateTIme string contains the "T"&&"Z" text
        if (originalDateTime.contains(TIME_SEPARATOR) && originalDateTime.contains(TIME_END)) {
            // Split the string into different parts (as an array of Strings)
            // based on the "T" text. We expect an array of 2 Strings, where
            // the first String will be the DATE and the second String will be the TIME.
            String[] parts = originalDateTime.split(TIME_SEPARATOR);
            primaryDate = parts[0];
            timeOffset = parts[1];
            // we split once again the timeOffcet string to remove the Z at the end
            String[] time = timeOffset.split(TIME_END);
            finalTime = time[0];
        }

        // Find the TextView with view ID news_date
        TextView dateView = (TextView) listItemView.findViewById(R.id.news_date);
        // Display the date of the current news in that TextView
        dateView.setText(primaryDate);

        // Find the TextView with view ID news_time
        TextView timeView = (TextView) listItemView.findViewById(R.id.news_time);
        // Display the time of the current news Article in that TextView
        timeView.setText(finalTime);


        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}
