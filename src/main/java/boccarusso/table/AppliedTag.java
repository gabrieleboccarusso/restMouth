package boccarusso.table;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppliedTag {

	@Id
	private Integer id;
	private Integer tagId;
	private Integer postId;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTagId() {
		return tagId;
	}
	
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	
	public Integer getPostId() {
		return postId;
		
	}
	
	public void setPostId(Integer postId) {
		this.postId = postId;
		
	}
}
