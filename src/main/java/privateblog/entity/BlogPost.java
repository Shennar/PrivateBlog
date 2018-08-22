package privateblog.entity;

import org.springframework.data.annotation.Id;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="PRIVATEBLOG")
public class BlogPost{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id", nullable = false)
	private Long id;
	
	@Column (name="Date", nullable = false)
	private LocalDate postDate;
	
	@Column (name="PostText", length = 960, nullable = false)
	private String postText;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}
}