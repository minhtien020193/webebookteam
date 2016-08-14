package Action.Struts2;

import java.util.List;

import DAO.PostDAO;
import DTO.PostDTO;

public class PostAction {
	List<PostDTO> listPost;
	private int postId;
	PostDTO postDTO;

	public String execute() throws Exception {
		PostDAO post = new PostDAO();
		listPost = post.getListPost();
		return "success";
	}

	public String detailPost() {
		if (("").equals(postId)) {
			return "noId";
		}
		PostDAO post = new PostDAO();
		postDTO = post.findPost(postId);
		if (postDTO == null) {
			return "noData";
		}
		return "success";
	}

	// getter setter
	public List<PostDTO> getListPost() {
		return listPost;
	}

	public void setListPost(List<PostDTO> listPost) {
		this.listPost = listPost;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public PostDTO getPostDTO() {
		return postDTO;
	}

	public void setPostDTO(PostDTO postDTO) {
		this.postDTO = postDTO;
	}

}
