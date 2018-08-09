package privateblog.domain;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "PrivateBlog")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Post_Text", length = 1024, nullable = false)
    private String postText;

    @Temporal(TemporalType.DATE)
    @Column(name = "Posting_Date", nullable = false)
    private LocalDate postDate;

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }
}