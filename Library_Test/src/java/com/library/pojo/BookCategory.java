
package com.library.pojo;


public class BookCategory {
    private int id;
    private String bookId;
    private int categoryNo;
    private String categoryContent;

    public BookCategory(int id, String bookId, int categoryNo, String categoryContent) {
        this.id = id;
        this.bookId = bookId;
        this.categoryNo = categoryNo;
        this.categoryContent = categoryContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
 
  

    public BookCategory() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getCategoryContent() {
        return categoryContent;
    }

    public void setCategoryContent(String categoryContent) {
        this.categoryContent = categoryContent;
    }

   
}
