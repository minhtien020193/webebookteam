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

public class ChapterAction {
	int chapterId;
	PostDTO postDTO;
	ChapterDTO chapterDTO;
	List<CommentDTO> listComments;
	List<String> userComment;
	
	public String detailChapter(){
		PostDAO post = new PostDAO();
		int postId = post.getPostIdbyChapterId(chapterId);
		postDTO = post.findPostDTO(postId);
		
		ChapterDAO chapter = new ChapterDAO();
		chapterDTO = chapter.getChapterDTObyChapterId(chapterId);
		if(chapterDTO == null){
			return "noData";
		}
		CommentDAO comment = new CommentDAO();
		listComments = comment.getListCommentByChapterId(chapterId);
		
		userComment = new ArrayList<String>();
		UserDAO user = new UserDAO();
		for (CommentDTO commentDTO : listComments) {
			userComment.add(user.getUserNameById(commentDTO.getUserId()));
		}
		return "success";
	}

	
	//getter setter
	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}


	public PostDTO getPostDTO() {
		return postDTO;
	}


	public void setPostDTO(PostDTO postDTO) {
		this.postDTO = postDTO;
	}


	public ChapterDTO getChapterDTO() {
		return chapterDTO;
	}


	public void setChapterDTO(ChapterDTO chapterDTO) {
		this.chapterDTO = chapterDTO;
	}


	public List<CommentDTO> getListComments() {
		return listComments;
	}


	public void setListComments(List<CommentDTO> listComments) {
		this.listComments = listComments;
	}


	public List<String> getUserComment() {
		return userComment;
	}


	public void setUserComment(List<String> userComment) {
		this.userComment = userComment;
	}
	
	
}
