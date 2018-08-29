package com.example.waelelsharkawy.newsfeedapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NewsAdapter extends ArrayAdapter<News> {

    NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        News currentNew = getItem(position);
        TextView article_titleV = view.findViewById(R.id.article_title);
        assert currentNew != null;
        article_titleV.setText(currentNew.getArticle_title());
        TextView author_nameV = view.findViewById(R.id.author_name);
        author_nameV.setText(currentNew.getAuthor_name());
        TextView section_nameV = view.findViewById(R.id.section_name);
        section_nameV.setText(currentNew.getSection_name());
        TextView publish_dateV = view.findViewById(R.id.publish_date);
        publish_dateV.setText(formatDate(currentNew.getPublish_date()));
        return view;
    }

    private static String formatDate(String date) {
        String jsonDate = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        SimpleDateFormat jsonDateFormatter = new SimpleDateFormat(jsonDate, Locale.US);
        try {
            Date dateParsedJson = jsonDateFormatter.parse(date);
            String finalDate = "dd MMM yyyy";
            SimpleDateFormat finalDateFormatter = new SimpleDateFormat(finalDate, Locale.US);
            return finalDateFormatter.format(dateParsedJson);
        } catch (ParseException e) {
            Log.e("QueryUtils", "Error parsing JSON date: ", e);
            return "";
        }
    }
}
