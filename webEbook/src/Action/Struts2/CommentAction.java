/**
 * 
 */
package Action.Struts2;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import DAO.ChapterDAO;
import DAO.CommentDAO;
import DAO.PostDAO;

/**
 * @author mac
 *
 */
public class CommentAction {
	int postId;
	String content;
	int chapterId;
	int commentId;

	public String execute() throws Exception {
		return "success";
	}

	public String postCommentPost() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (("").equals(content)) {
			return "noComment";
		}
		CommentDAO comment = new CommentDAO();
		//type comment = false -> comment post
		int commentId = comment.postCommentPost(content, 2, false);
		if (commentId == 0) {
			return "fail";
		}
		boolean insertPostComment = comment.insertPostComment(postId, commentId);
		if (insertPostComment) {
			String lastAction = "detailPost?postId=" + postId;
			session.put("lastAction", lastAction);
			return "success";
		}
		return "fail";

	}

	public String postCommentChapter() {
		if (("").equals(content)) {
			return "noComment";
		}
		CommentDAO comment = new CommentDAO();
		//type comment = true -> comment chapter
		int commentId = comment.postCommentPost(content, 2, true);
		if (commentId == 0) {
			return "fail";
		}
		boolean insertPostComment = comment.insertChapterComment(chapterId, commentId);
		if (insertPostComment) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			String lastAction = "chapterDetail?chapterId=" + chapterId;
			session.put("lastAction", lastAction);
			return "success";
		}
		return "fail";

	}
	
	public String feedbackCommentPost(){
		PostDAO post = new PostDAO();
		int postId = post.getPostIdbyCommentId(commentId);
		if(postId == 0){
			return "noPostId";
		}
		CommentDAO comment = new CommentDAO();
		boolean voteComment = comment.updateVoteComment(commentId, true);
		if(voteComment){
			Map<String, Object> session = ActionContext.getContext().getSession();
			String lastAction = "detailPost?postId=" + postId;
			session.put("lastAction", lastAction);
			return "success";
		}
		return "fail";
	}
	
	public String cancelFeedbackCommentPost(){
		PostDAO post = new PostDAO();
		int postId = post.getPostIdbyCommentId(commentId);
		if(postId == 0){
			return "noPostId";
		}
		CommentDAO comment = new CommentDAO();
		boolean voteComment = comment.updateVoteComment(commentId, false);
		if(voteComment){
			Map<String, Object> session = ActionContext.getContext().getSession();
			String lastAction = "detailPost?postId=" + postId;
			session.put("lastAction", lastAction);
			return "success";
		}
		return "fail";
	}
	
	public String feedbackCommentChapter(){
		ChapterDAO chapter = new ChapterDAO();
		int chapterId = chapter.getChapterIdbyCommentId(commentId);
		if(chapterId == 0){
			return "noChapterId";
		}
		CommentDAO comment = new CommentDAO();
		boolean voteComment = comment.updateVoteComment(commentId, true);
		if(voteComment){
			Map<String, Object> session = ActionContext.getContext().getSession();
			String lastAction = "chapterDetail?chapterId=" + chapterId;
			session.put("lastAction", lastAction);
			return "success";
		}
		return "fail";
	}
	
	public String cancelFeedbackCommentChapter(){
		ChapterDAO chapter = new ChapterDAO();
		int chapterId = chapter.getChapterIdbyCommentId(commentId);
		if(chapterId == 0){
			return "noChapterId";
		}
		CommentDAO comment = new CommentDAO();
		boolean voteComment = comment.updateVoteComment(commentId, false);
		if(voteComment){
			Map<String, Object> session = ActionContext.getContext().getSession();
			String lastAction = "chapterDetail?chapterId=" + chapterId;
			session.put("lastAction", lastAction);
			return "success";
		}
		return "fail";
	}
	
	// getter setter
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

}
