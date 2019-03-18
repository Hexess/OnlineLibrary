package com.library.pojo;

import java.util.Date;

public class Author {

    private String authorName;
    private String authorNationality;
    private String birthDate;
    private String aepresentativeBooks;
    private String authorPhoto;
    private String aboutAuthor;

    public Author() {
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorNationality() {
        return authorNationality;
    }

    public void setAuthorNationality(String authorNationality) {
        this.authorNationality = authorNationality;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAepresentativeBooks() {
        return aepresentativeBooks;
    }

    public void setAepresentativeBooks(String aepresentativeBooks) {
        this.aepresentativeBooks = aepresentativeBooks;
    }

    public String getAuthorPhoto() {
        return authorPhoto;
    }

    public void setAuthorPhoto(String authorPhoto) {
        this.authorPhoto = authorPhoto;
    }

    public String getAboutAuthor() {
        return aboutAuthor;
    }

    public void setAboutAuthor(String aboutAuthor) {
        this.aboutAuthor = aboutAuthor;
    }

    public Author(String authorName, String authorNationality, String birthDate, String aepresentativeBooks, String authorPhoto, String aboutAuthor) {
        this.authorName = authorName;
        this.authorNationality = authorNationality;
        this.birthDate = birthDate;
        this.aepresentativeBooks = aepresentativeBooks;
        this.authorPhoto = authorPhoto;
        this.aboutAuthor = aboutAuthor;
    }

  
}
