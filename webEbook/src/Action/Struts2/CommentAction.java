/**
 * 
 */
package Action.Struts2;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import DAO.CommentDAO;

/**
 * @author mac
 *
 */
public class CommentAction {
	int postId;
	String content;
	int chapterId;

	public String execute() throws Exception {
		return "success";
	}

	public String postCommentPost() {

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
			Map<String, Object> session = ActionContext.getContext().getSession();
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

}
