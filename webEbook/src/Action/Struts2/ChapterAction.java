package Action.Struts2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

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
	int postId;
	String chapterName;
	String contents;
	String description;

	public String detailChapter() {
		PostDAO post = new PostDAO();
		int postId = post.getPostIdbyChapterId(chapterId);
		postDTO = post.findPostDTO(postId);

		ChapterDAO chapter = new ChapterDAO();
		chapterDTO = chapter.getChapterDTObyChapterId(chapterId);
		if (chapterDTO == null) {
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

	public String sendAddChapter() {
		PostDAO post = new PostDAO();
		postDTO = post.findPostDTO(postId);

		if (postDTO == null) {
			return "noPostId";
		}
		return "success";
	}

	public String sendUpdateChapter() {
		PostDAO post = new PostDAO();
		int postIdbyChapterId = post.getPostIdbyChapterId(chapterId);
		postDTO = post.findPostDTO(postIdbyChapterId);
		if (postDTO == null) {
			return "noPostId";
		}
		ChapterDAO chapter = new ChapterDAO();
		chapterDTO = chapter.getChapterDTObyChapterId(chapterId);
		if (chapterDTO == null) {
			return "noData";
		}
		return "success";
	}

	public String addChapter() {
		ChapterDTO chapterDTO = new ChapterDTO();
		chapterDTO.setChapterName(chapterName);
		chapterDTO.setContents(contents);
		chapterDTO.setDescription(description);
		chapterDTO.setDel_flg(false);

		ChapterDAO chapter = new ChapterDAO();
		int chapterId = chapter.insertChapter(chapterDTO);
		if (chapterId != 0) {
			boolean checkPostChapter = chapter.insertPostChapter(chapterId, postId);
			if (checkPostChapter) {
				Map<String, Object> session = ActionContext.getContext().getSession();
				String lastAction = "sendUpdatePost?postId=" + postId;
				session.put("lastAction", lastAction);
				return "success";

			}
			return "noPostChapter";
		}

		return "fail";
	}

	public String updateChapter() {
		ChapterDTO chapterDTO = new ChapterDTO();
		chapterDTO.setChapterId(chapterId);
		chapterDTO.setChapterName(chapterName);
		chapterDTO.setContents(contents);
		chapterDTO.setDescription(description);
		chapterDTO.setDel_flg(false);

		ChapterDAO chapter = new ChapterDAO();
		boolean updateChapter = chapter.updateChapterDTO(chapterDTO);
		if (updateChapter) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			String lastAction = "sendUpdatePost?postId=" + postId;
			session.put("lastAction", lastAction);
			return "success";

		}
		return "fail";
	}

	// getter setter
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

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
