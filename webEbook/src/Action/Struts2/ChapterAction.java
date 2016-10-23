package Action.Struts2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import DAO.ChapterDAO;
import DAO.CommentDAO;
import DAO.PostDAO;
import DAO.UserDAO;
import DAO.VoteDAO;
import DTO.ChapterDTO;
import DTO.CommentDTO;
import DTO.PostDTO;
import DTO.UserDTO;

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
	final String ADMIN = "admin";
	final String SALER = "saler";
	final String MEMBER = "member";
	boolean noFeedback = false;
	private boolean chapterVoted;
	private boolean voteValue;
	private int countVote;

	public String detailChapter() {
		PostDAO post = new PostDAO();
		int postId = post.getPostIdbyChapterId(chapterId);
		postDTO = post.findPostDTO(postId);
		Map<String, Object> session = ActionContext.getContext().getSession();
		//vote count
		VoteDAO voteDAO = new VoteDAO();
		countVote = voteDAO.countVoteChapter(chapterId);
		if (session.get("LOGINED") != null) {
			UserDTO usr = (UserDTO) session.get("LOGINED");
			int userId = usr.getUserId();
			if (userId == postDTO.getUserId()) {
				noFeedback = true;
			}

			// check chapter vote
			chapterVoted = voteDAO.checkVoteChapter(userId, chapterId);
		}

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
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();
		UserDAO user = new UserDAO();
		String role = user.getRoleByRoleId(user.getRoleIdByUserId(userId)).getRoleName();
		if (MEMBER.equals(role)) {
			return "noPermission";
		}
		PostDAO post = new PostDAO();
		postDTO = post.findPostDTO(postId);

		if (postDTO == null) {
			return "noPostId";
		}
		return "success";
	}

	public String sendUpdateChapter() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();
		UserDAO user = new UserDAO();
		String role = user.getRoleByRoleId(user.getRoleIdByUserId(userId)).getRoleName();
		if (MEMBER.equals(role)) {
			return "noPermission";
		}
		PostDAO post = new PostDAO();
		int postIdbyChapterId = post.getPostIdbyChapterId(chapterId);
		postDTO = post.findPostDTO(postIdbyChapterId);
		if (userId != postDTO.getUserId()) {
			// user nay ko co quyen chinh sua chapter nay
			return "noPermission";
		}
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
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();
		UserDAO user = new UserDAO();
		String role = user.getRoleByRoleId(user.getRoleIdByUserId(userId)).getRoleName();
		if (MEMBER.equals(role)) {
			return "noPermission";
		}
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
				String lastAction = "sendUpdatePost?postId=" + postId;
				session.put("lastAction", lastAction);
				return "success";

			}
			return "noPostChapter";
		}

		return "fail";
	}

	public String updateChapter() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();
		UserDAO user = new UserDAO();
		String role = user.getRoleByRoleId(user.getRoleIdByUserId(userId)).getRoleName();
		if (MEMBER.equals(role)) {
			return "noPermission";
		}

		ChapterDTO chapterDTO = new ChapterDTO();
		chapterDTO.setChapterId(chapterId);
		chapterDTO.setChapterName(chapterName);
		chapterDTO.setContents(contents);
		chapterDTO.setDescription(description);
		chapterDTO.setDel_flg(false);

		ChapterDAO chapter = new ChapterDAO();
		boolean updateChapter = chapter.updateChapterDTO(chapterDTO);
		if (updateChapter) {
			String lastAction = "sendUpdatePost?postId=" + postId;
			session.put("lastAction", lastAction);
			return "success";

		}
		return "fail";
	}

	public String voteChapter() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();
		VoteDAO vote = new VoteDAO();
		int voteId = vote.searchVoteChapter(userId, chapterId);
		boolean updateVote = false;
		if (voteId == 0) {
			updateVote = vote.voteInsertChapter(chapterId, userId, voteValue);
		} else {
			updateVote = vote.voteUpdate(voteId, voteValue);
		}
		if (updateVote) {
			chapterVoted = voteValue;
		}
		return "success";
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

	public boolean isNoFeedback() {
		return noFeedback;
	}

	public void setNoFeedback(boolean noFeedback) {
		this.noFeedback = noFeedback;
	}

	public boolean isChapterVoted() {
		return chapterVoted;
	}

	public void setChapterVoted(boolean chapterVoted) {
		this.chapterVoted = chapterVoted;
	}

	public boolean isVoteValue() {
		return voteValue;
	}

	public void setVoteValue(boolean voteValue) {
		this.voteValue = voteValue;
	}

	public int getCountVote() {
		return countVote;
	}

	public void setCountVote(int countVote) {
		this.countVote = countVote;
	}

}
