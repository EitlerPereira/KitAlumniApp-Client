package edu.kit.isco.kitalumniapp.dbObjects;

/**
 * Created by Andre on 04.02.2015.
 */
public class DataAccessNews implements DataAccessObject {

    private long id;
    private String title;
    private String shortInfo;
    private String text;
    private String url;
    private String imageUrl;
    private String date;

    public DataAccessNews() {
    }

    public DataAccessNews(long id, String title, String shortInfo, String text, String url, String imageUrl, String date) {
        this.id = id;
        this.title = title;
        this.shortInfo = shortInfo;
        this.text = text;
        this.url = url;
        this.imageUrl = imageUrl;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortDescription() {
        return shortInfo;
    }

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDate() {
        return date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShortDescription(String shortDescription) {
        this.shortInfo = shortDescription;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
        return new StringBuffer(" ID : ").append(this.getId())
                .append(" Title : ").append(this.getTitle())
                .append(" shortDescription: ").append(this.getShortDescription())
                .append(" fullText : ").append(this.getText())
                .append(" url : ").append(this.getUrl())
                .append(" imageUrl : ").append(this.getImageUrl())
                .toString();
    }
}
