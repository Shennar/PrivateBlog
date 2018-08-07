package domain;

public class BlogPost {
    private int id;
    private String postText;

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

    public BlogPost(int id, String postText){
    this.id = id;
    this.postText = postText;

}
}