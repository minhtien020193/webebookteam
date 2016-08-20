package Action.Struts2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

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
	boolean noData = false;
	String postName;
	File ebook;
	File image;
	String description;
	String author;
	int countChapter;
	String price;
	String content;
	private String ebookFileName;
	private String imageFileName;
	private String ebookContentType;
	private String imageContentType;

	public String execute() throws Exception {
		PostDAO post = new PostDAO();
		listPost = post.getListPost();
		return "success";
	}

	public String sendCreatePost() {
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

	public String createPost() {
		// uploadFile();
		int userId = 1;
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
		post.setSaleoff(0);
		post.setImage("image");
		post.setLinkDownload("linkdownload");
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
		int userId = 1;
		PostDAO post = new PostDAO();
		listPost = post.getListPostbyUserId(userId);
		if (listPost.isEmpty()) {
			noData = true;
		}
		return "success";
	}
	
	public String sendUpdatePost() {
		ChapterDAO chapter = new ChapterDAO();
		listChapters = chapter.getListChapterByPostId(postId);
		
		PostDAO post = new PostDAO();
		postDTO = post.findPostDTO(postId);
		if(postDTO == null){
			return "fail";
		}
		return "success";
	}
	
	public String updatePost() {
		int userId = 1;
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
		post.setUserId(userId);
		post.setSaleoff(0);
		post.setImage("image");
		post.setLinkDownload("linkdownload");
		post.setPostStatus(false);
		post.setDel_flg(false);
		
		PostDAO postDAO = new PostDAO();
		boolean check = postDAO.updatePostDTO(post);
		if (check) {
			return "success";
		}

		return "fail";
	}
	
	public String deletePost(){
		PostDAO post = new PostDAO();
		boolean checkDel = post.updateDel_FlgPostDTO(postId);
		if (checkDel) {
			return "success";
		}

		return "fail";
	}

	// private String uploadFile(){
	// /* Copy file to a safe location */
	// String destPath = "../ebookFolder";
	//
	// try{
	// System.out.println("Src File name: " + ebook);
	// System.out.println("Dst File name: " + ebookFileName);
	//
	// File destFile = new File(destPath, ebookFileName);
	// FileUtils.copyFile(ebook, destFile);
	//
	// }catch(IOException e){
	// e.printStackTrace();
	// return "noUpload";
	// }
	//
	// return "aa";
	// }

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

}
