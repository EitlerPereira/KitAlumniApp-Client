package edu.kit.isco.kitalumniapp.dbObjects;

import android.content.ContentValues;

import java.util.Calendar;

import edu.kit.isco.kitalumniapp.dbServices.EventTable;

/**
 * DAO for Event
 * Created by Andre on 04.02.2015.
 */
public class DataAccessEvent implements DataAccessObject {

    private long id;
    private String title;
    private String shortInfo;
    private String allText;
    private String url;
    private String date;

    public DataAccessEvent() {
    }

    public DataAccessEvent(String title, String shortInfo, String allText, String url, Calendar date) {
        this.title = title;
        this.shortInfo = shortInfo;
        this.allText = allText;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    public String getAllText() {
        return allText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setText(String allText) {
        this.allText = allText;
    }

    @Override
    public String toString() {
        return new StringBuffer(" ID : ").append(this.getId())
                .append(" Title : ").append(this.getTitle())
                .append(" shortDescription: ").append(this.getShortInfo())
                .append(" fullText : ").append(this.getAllText())
                .append(" url : ").append(this.getUrl())
                .toString();
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(EventTable.ID, id);
        values.put(EventTable.TITLE, title);
        values.put(EventTable.SHORT_INFO, shortInfo);
        values.put(EventTable.FULL_TEXT, allText);
        values.put(EventTable.URL, url);
        values.put(EventTable.DATE, date);
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataAccessEvent that = (DataAccessEvent) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}