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
	
	
	public String execute() throws Exception {
		return "success";
	}
	//getter setter
	public String postCommentPost(){
		
		if(("").equals(content)){
			return "noComment";
		}
		CommentDAO comment = new CommentDAO();
		int commentId = comment.postCommentPost(postId, content, 2);
		if(commentId == 0){
			return "fail";
		}
		boolean insertPostComment  = comment.insertPostComment(postId, commentId);
		if(insertPostComment){
			Map<String, Object> session = ActionContext.getContext().getSession();
			String lastAction = "detailPost?postId="+postId;
			session.put("lastAction", lastAction);
			return "success";
		}
		return "fail";
		
	}

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
}
