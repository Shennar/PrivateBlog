package privateblog.domain;

import java.util.Date;

public class BlogPost {
    private int id;
    private String postText;

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    private Date postDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public BlogPost(int id, String postText, Date postDate){
    this.id = id;
    this.postText = postText;

        this.postDate = postDate;
    }
}