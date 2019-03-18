
package com.library.pojo;

import java.util.Date;


public class Books implements java.io.Serializable {
    private String bookId;
    private String bookName;
    private String writerName;
    private Date publishDate;
    private String press;
    private String country;
    private String category;
    private String pictureUrl;
    private String pictureUrl_Big;
    private String bookDescription;
    private String bookStaus;

    public String getBookStaus() {
        return bookStaus;
    }

    public void setBookStaus(String bookStaus) {
        this.bookStaus = bookStaus;
    }

   

    public Books() {
    }

    
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureUrl_Big() {
        return pictureUrl_Big;
    }

    public void setPictureUrl_Big(String pictureUrl_Big) {
        this.pictureUrl_Big = pictureUrl_Big;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

   

    
}
