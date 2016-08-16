package Action.Struts2;
import java.util.ArrayList;
import java.util.List;
import DAO.ChapterDAO;
import DAO.CommentDAO;
import DAO.PostDAO;
import DAO.UserDAO;
import DTO.ChapterDTO;
import DTO.CommentDTO;
import DTO.PostDTO;

public class PostAction {
	List<PostDTO> listPost;
	private int postId;
	PostDTO postDTO;
	List<CommentDTO> listComments;
	List<ChapterDTO> listChapters;
	boolean priceEmpty = true;
	List<String> userComment;

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
		if (postDTO.getPrice() == 0) {
			priceEmpty = false;
		}

		CommentDAO comment = new CommentDAO();
		listComments = comment.getListCommentByPostId(postId);
		
		userComment = new ArrayList<String>();
		UserDAO user = new UserDAO();
		for (CommentDTO commentDTO : listComments) {
			userComment.add(user.getUserNameById(commentDTO.getUserId()));
		}
		
		ChapterDAO chapter = new ChapterDAO();
		listChapters = chapter.getListChapterByPostId(postId);

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

	public List<CommentDTO> getListComments() {
		return listComments;
	}

	public void setListComments(List<CommentDTO> listComments) {
		this.listComments = listComments;
	}

	public List<ChapterDTO> getListChapters() {
		return listChapters;
	}

	public void setListChapters(List<ChapterDTO> listChapters) {
		this.listChapters = listChapters;
	}

	public boolean isPriceEmpty() {
		return priceEmpty;
	}

	public void setPriceEmpty(boolean priceEmpty) {
		this.priceEmpty = priceEmpty;
	}

	public List<String> getUserComment() {
		return userComment;
	}

	public void setUserComment(List<String> userComment) {
		this.userComment = userComment;
	}
	

}
