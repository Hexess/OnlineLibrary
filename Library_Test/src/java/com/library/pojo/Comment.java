
package com.library.pojo;

public class Comment {
    private int id;
    private String readId;
    private String bookId;
    private String readName;
    private String bookName;
    private String caption;
    private String content;
    private String commentDate;
    private String portrait;

    public Comment() {
    }

    public Comment(int id, String readId, String bookId, String readName, String bookName, String caption, String content, String commentDate, String portrait) {
        this.id = id;
        this.readId = readId;
        this.bookId = bookId;
        this.readName = readName;
        this.bookName = bookName;
        this.caption = caption;
        this.content = content;
        this.commentDate = commentDate;
        this.portrait = portrait;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getReadId() {
        return readId;
    }

    public void setReadId(String readId) {
        this.readId = readId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getReadName() {
        return readName;
    }

    public void setReadName(String readName) {
        this.readName = readName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public Object getAttributes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
