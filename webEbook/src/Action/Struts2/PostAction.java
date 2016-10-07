package Action.Struts2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import DAO.CategoryDAO;
import DAO.ChapterDAO;
import DAO.CommentDAO;
import DAO.PostDAO;
import DAO.UserDAO;
import DTO.CategoryDTO;
import DTO.ChapterDTO;
import DTO.CommentDTO;
import DTO.PostDTO;
import DTO.UserDTO;

public class PostAction extends ActionSupport {
	private List<PostDTO> listPost;
	private List<PostDTO> listPostbyCategory;
	private int postId;
	private PostDTO postDTO;
	private List<CommentDTO> listComments;
	private List<ChapterDTO> listChapters;
	private Map<Integer, String> listCats;
	private boolean priceEmpty = true;
	private List<String> userComment;
	private boolean noData = false;
	private String postName;
	private File ebook;
	private File image;
	private String description;
	private String author;
	private int countChapter;
	private String price;
	private String content;
	private String ebookFileName;
	private String imageFileName;
	private String ebookContentType;
	private String imageContentType;
	private int categoryId;
	private String categoryName;
	boolean noFeedback = false;
	private String txtsearch;
	private String image_inserted;
	private String linkdownload_inserted;
	String messageError = "";

	final String ADMIN = "admin";
	final String SALER = "saler";
	final String MEMBER = "member";
	private static final Logger logger = Logger.getLogger(UserDAO.class
			.getName());

	public String execute() throws Exception {
		PostDAO post = new PostDAO();
		if (categoryId == 0) {
			listPost = post.getListPost();
		} else {
			listPost = post.getListPostByCategoryId(categoryId);
		}

		return "success";
	}

	public String sendCreatePost() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();
		UserDAO user = new UserDAO();
		String role = user.getRoleByRoleId(user.getRoleIdByUserId(userId))
				.getRoleName();
		if (MEMBER.equals(role)) {
			return "noPermission";
		}

		CategoryDAO cat = new CategoryDAO();
		List<CategoryDTO> lstCat = cat.getListCategory();
		listCats = new HashMap<>();
		for (CategoryDTO categoryDTO : lstCat) {
			listCats.put(categoryDTO.getCategoryId(),
					categoryDTO.getCategoryName());
		}
		return "success";
	}

	public String detailPost() {
		if (("").equals(postId)) {
			return "noId";
		}
		PostDAO post = new PostDAO();
		postDTO = post.findPostDTO(postId);
		if (postDTO == null) {
			return "noData";
		}
		if (postDTO.getPrice() == 0) {
			priceEmpty = false;
		}
		// listcomment
		CommentDAO comment = new CommentDAO();
		listComments = comment.getListCommentByPostId(postId);
		// user comment
		userComment = new ArrayList<String>();
		UserDAO user = new UserDAO();
		for (CommentDTO commentDTO : listComments) {
			userComment.add(user.getUserNameById(commentDTO.getUserId()));
		}
		// post by category
		listPostbyCategory = post.getListPostbyCatId(postDTO.getCategoryId());

		// listChapter
		ChapterDAO chapter = new ChapterDAO();
		listChapters = chapter.getListChapterByPostId(postId);
		// category
		CategoryDAO cat = new CategoryDAO();
		categoryName = cat.getCategoryById(postDTO.getCategoryId());
		// show button feedback for poster
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") != null) {
			UserDTO usr = (UserDTO) session.get("LOGINED");
			int userId = usr.getUserId();
			if (userId == postDTO.getUserId()) {
				noFeedback = true;
			}
		}
		return "success";
	}

	public String createPost() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();

		UserDAO user = new UserDAO();
		String role = user.getRoleByRoleId(user.getRoleIdByUserId(userId))
				.getRoleName();
		if (MEMBER.equals(role)) {
			return "noPermission";
		}
		// start validate postname
		if (postName == null || postName.trim().equals("")) {
			messageError += "postname null \n";
		}
		// end validate postname

		// start validate category Id
		if (categoryId != 1 || categoryId != 2 || categoryId != 3) {
			messageError += "categoryId null \n";
		}
		// end validate category Id

		// start validate author
		if (author == null || author.trim().equals("")) {
			messageError += "author null \n";
		}
		// end validate author

		// check validate
		if (messageError != null || messageError != "") {
			return "failValidate";
		}

		String linkdownload = uploadFile(ebookFileName, ebook);
		if (("failed").equals(linkdownload)) {
			return "fail";
		}
		String imagelink = uploadImage(imageFileName, image, userId);
		if (("failed").equals(imagelink)) {
			return "fail";
		}

		PostDTO post = new PostDTO();
		post.setAuthorName(author);
		post.setContents(content);
		post.setCountChapter(countChapter);
		post.setPostName(postName);
		post.setDescription(description);
		post.setImage(ebookFileName);
		post.setPrice(Double.parseDouble(price));
		post.setPostType(true);
		post.setUserId(userId);
		post.setCategoryId(categoryId);
		post.setSaleoff(0);
		post.setImage(imagelink);
		post.setLinkDownload(linkdownload);
		post.setPostStatus(false);
		post.setDel_flg(false);

		PostDAO postDAO = new PostDAO();
		int newPostId = postDAO.insertPost(post);
		if (newPostId != 0) {
			return "success";
		}

		return "fail";
	}

	public String listPost() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();
		UserDAO user = new UserDAO();
		String role = user.getRoleByRoleId(user.getRoleIdByUserId(userId))
				.getRoleName();
		if (MEMBER.equals(role)) {
			return "noPermission";
		}

		PostDAO post = new PostDAO();
		listPost = post.getListPostbyUserId(userId);
		if (listPost.isEmpty()) {
			noData = true;
		}
		return "success";
	}

	public String sendUpdatePost() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();
		UserDAO user = new UserDAO();
		String role = user.getRoleByRoleId(user.getRoleIdByUserId(userId))
				.getRoleName();
		if (MEMBER.equals(role)) {
			return "noPermission";
		}

		ChapterDAO chapter = new ChapterDAO();
		listChapters = chapter.getListChapterByPostId(postId);

		CategoryDAO cat = new CategoryDAO();
		List<CategoryDTO> lstCat = cat.getListCategory();
		listCats = new HashMap<>();
		for (CategoryDTO categoryDTO : lstCat) {
			listCats.put(categoryDTO.getCategoryId(),
					categoryDTO.getCategoryName());
		}
		PostDAO post = new PostDAO();
		postDTO = post.findPostDTO(postId);
		if (postDTO == null) {
			return "fail";
		}

		return "success";
	}

	public String updatePost() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();
		UserDAO user = new UserDAO();
		String role = user.getRoleByRoleId(user.getRoleIdByUserId(userId))
				.getRoleName();
		if (MEMBER.equals(role)) {
			return "noPermission";
		}
		// start validate postname
		if (postName == null || postName.trim().equals("")) {
			messageError += "postname null \n";
		}
		// end validate postname

		// start validate category Id
		if (categoryId != 1 || categoryId != 2 || categoryId != 3) {
			messageError += "categoryId null \n";
		}
		// end validate category Id

		// start validate author
		if (author == null || author.trim().equals("")) {
			messageError += "author null \n";
		}
		// end validate author

		// check validate
		if (messageError != null || messageError != "") {
			return "failValidate";
		}
		String linkdownload = uploadFile(ebookFileName, ebook);
		if (("failed").equals(linkdownload)) {
			return "fail";
		}
		String imagelink = uploadImage(imageFileName, image, userId);
		if (("failed").equals(image)) {
			return "fail";
		}
		PostDTO post = new PostDTO();
		post.setPostId(postId);
		post.setAuthorName(author);
		post.setContents(content);
		post.setCountChapter(countChapter);
		post.setPostName(postName);
		post.setDescription(description);
		post.setImage(ebookFileName);
		post.setPrice(Double.parseDouble(price));
		post.setPostType(true);
		post.setCategoryId(categoryId);
		post.setUserId(userId);
		post.setSaleoff(0);
		if (imagelink == null) {
			post.setImage(image_inserted);
		} else {
			post.setImage(imagelink);
		}
		if (linkdownload == null) {
			post.setLinkDownload(linkdownload_inserted);
		} else {
			post.setLinkDownload(linkdownload);
		}
		post.setPostStatus(false);
		post.setDel_flg(false);

		PostDAO postDAO = new PostDAO();
		boolean check = postDAO.updatePostDTO(post);
		if (check) {
			return "success";
		}

		return "fail";
	}

	public String deletePost() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();
		UserDAO user = new UserDAO();
		String role = user.getRoleByRoleId(user.getRoleIdByUserId(userId))
				.getRoleName();
		if (MEMBER.equals(role)) {
			return "noPermission";
		}

		PostDAO post = new PostDAO();
		boolean checkDel = post.updateDel_FlgPostDTO(postId);
		if (checkDel) {
			return "success";
		}

		return "fail";
	}

	public String sendAcceptPost() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();
		UserDAO user = new UserDAO();
		String role = user.getRoleByRoleId(user.getRoleIdByUserId(userId))
				.getRoleName();
		if (!(ADMIN).equals(role)) {
			return "notAdmin";
		}
		PostDAO post = new PostDAO();
		listPost = post.getListPostHold();
		if (listPost.isEmpty()) {
			noData = true;
		}
		return "success";
	}

	public String acceptPost() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("LOGINED") == null) {
			return "noPermission";
		}
		UserDTO usr = (UserDTO) session.get("LOGINED");
		int userId = usr.getUserId();
		UserDAO user = new UserDAO();
		String role = user.getRoleByRoleId(user.getRoleIdByUserId(userId))
				.getRoleName();
		if (!(ADMIN).equals(role)) {
			return "notAdmin";
		}
		PostDAO post = new PostDAO();
		boolean check = post.updateStatusPost(postId);
		if (check) {
			return "success";
		}
		return "fail";
	}

	public String searchEbook() {
		PostDAO post = new PostDAO();
		listPost = post.searchPost(txtsearch);
		if (listPost.isEmpty()) {
			return "noData";
		}
		return "success";
	}

	private String uploadFile(String fileName, File fileUpload) {
		String pathFileUpload = "";
		if (fileUpload == null) {
			return null;
		}
		try {
			ServletContext context = ServletActionContext.getServletContext();
			String sRootPath = context.getRealPath("/");
			// String newName = "";
			// long millis = System.currentTimeMillis();
			// newName = millis + "_" + fileName;
			// fileUpload.renameTo(new File(newName));

			File destFile = new File(sRootPath + "/ebookFolder", fileName);
			FileUtils.copyFile(fileUpload, destFile);
			pathFileUpload = "ebookFolder/" + destFile.getName();
			logger.info("upload file success");
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("failed upload file");
			return "failed";
		}

		return pathFileUpload;
	}

	private String uploadImage(String fileName, File fileUpload, int userId) {
		String pathFileUpload = "";
		if (fileUpload == null) {
			return null;
		}
		try {
			ServletContext context = ServletActionContext.getServletContext();
			String sRootPath = context.getRealPath("/");
			// String sRootPath
			// ="E:\\Ebook\\branches\\dev\\webEbook\\WebContent\\image";

			String newFileName = new Date().getTime() + fileUpload.hashCode()
					+ "_" + userId + "_" + fileName;
			File destFile = new File(sRootPath + "/image", newFileName);
			FileUtils.copyFile(fileUpload, destFile);
			pathFileUpload = "image/" + newFileName;
			logger.info("upload image success");
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("failed image file");
			return "failed";
		}

		return pathFileUpload;
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

	public Map<Integer, String> getListCats() {
		return listCats;
	}

	public void setListCats(Map<Integer, String> listCats) {
		this.listCats = listCats;
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

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public File getEbook() {
		return ebook;
	}

	public void setEbook(File ebook) {
		this.ebook = ebook;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCountChapter() {
		return countChapter;
	}

	public void setCountChapter(int countChapter) {
		this.countChapter = countChapter;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEbookFileName() {
		return ebookFileName;
	}

	public void setEbookFileName(String ebookFileName) {
		this.ebookFileName = ebookFileName;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getEbookContentType() {
		return ebookContentType;
	}

	public void setEbookContentType(String ebookContentType) {
		this.ebookContentType = ebookContentType;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public boolean isNoFeedback() {
		return noFeedback;
	}

	public void setNoFeedback(boolean noFeedback) {
		this.noFeedback = noFeedback;
	}

	public String getTxtsearch() {
		return txtsearch;
	}

	public void setTxtsearch(String txtsearch) {
		this.txtsearch = txtsearch;
	}

	public String getImage_inserted() {
		return image_inserted;
	}

	public void setImage_inserted(String image_inserted) {
		this.image_inserted = image_inserted;
	}

	public String getLinkdownload_inserted() {
		return linkdownload_inserted;
	}

	public void setLinkdownload_inserted(String linkdownload_inserted) {
		this.linkdownload_inserted = linkdownload_inserted;
	}

	public List<PostDTO> getListPostbyCategory() {
		return listPostbyCategory;
	}

	public void setListPostbyCategory(List<PostDTO> listPostbyCategory) {
		this.listPostbyCategory = listPostbyCategory;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

}
