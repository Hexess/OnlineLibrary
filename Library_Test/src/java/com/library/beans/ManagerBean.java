package com.library.beans;

import com.library.dao.ManagerDao;
import com.library.pojo.Author;
import com.library.pojo.Books;
import com.library.pojo.Borrow;
import com.library.pojo.Comment;
import com.library.pojo.Manager;
import com.library.pojo.Reader;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class ManagerBean {

    private String managerID;
    private String managerPassword;
    private String readID;
    private String message; //显示提示消息
    private String color; //提示消息的颜色，红或绿

    private Author author;
    private Reader reader;
    private Manager manager;
    private Books books;
    private Borrow borrow;
    private Comment comment;

    private String findreadtext;
    private String findauthortext;
    private int ID;
    private String newMobile;
    private String newAddress;
    private String newPassword;
    private int readbalance;

    private List<Reader> userList = null;
    private List<Comment> commetList = null;
    private List<Books> bookList = null;
    private int currentPage = 1;
    private int pages;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }



    public List<Books> getBookList() {
        return bookList;
    }

    public void setBookList(List<Books> bookList) {
        this.bookList = bookList;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }


    public String changeAuthorInfo() {
        ManagerDao dao = new ManagerDao();
        dao.updateMessage_a(author);
        return "AuthorInfo";
    }

    public List<Comment> getCommetList() {
        return commetList;
    }

    public void setCommetList(List<Comment> commetList) {
        
        this.commetList = commetList;
    }

    public void changePage(ActionEvent e) {
        HtmlCommandLink link = (HtmlCommandLink) e.getSource();
        currentPage = Integer.valueOf(link.getValue().toString());
    }

    public String findReaderInfo() {
        ManagerDao dao = new ManagerDao();
        reader = dao.findReader(findreadtext);
        return null;
    }
        public String findCommentInfo() {
        ManagerDao dao = new ManagerDao();
        reader = dao.findReader(findreadtext);
        return null;
    }

    public String deleteReaderInfo() {
        ManagerDao dao = new ManagerDao();
        reader = dao.deleteReader(findreadtext);
        return null;
    }
        public String deleteCommentInfo() {
        ManagerDao dao = new ManagerDao();
        comment=dao.deleteComment(ID);
        commetList=dao.queryComment(0);
        return null;
    }

    public String findAuthorInfo() {
        ManagerDao dao = new ManagerDao();
        author = dao.findAuthor(findauthortext);
        return null;
    }

    public String validate() {
        ManagerDao dao = new ManagerDao();
        manager = dao.findManager(managerID, managerPassword);
        if (manager != null) {
            return "success";
        } else {
            return "fail";
        }
    }

    public String changeReaderInfo() {
        ManagerDao dao = new ManagerDao();
        dao.updateMessage(reader);
        return "ReaderInfo";
    }

    public String deleteAuthorInfo() {
        ManagerDao dao = new ManagerDao();
        author = dao.deleteAuthor(findauthortext);
        return null;
    }

    public Reader recharge() {
        ManagerDao dao = new ManagerDao();
        reader = dao.Recharge(reader.getReadId(), readbalance);
        message = "成功充值";
        return null;
    }

    public String getNewMobile() {
        return newMobile;
    }

    public void setNewMobile(String newMobile) {
        this.newMobile = newMobile;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReadID() {
        return readID;
    }

    public void setReadID(String readID) {
        this.readID = readID;
    }

    public String getManagerID() {
        return managerID;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }


    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }


    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public String getFindreadtext() {
        return findreadtext;
    }

    public void setFindreadtext(String findreadtext) {
        this.findreadtext = findreadtext;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public String getFindauthortext() {
        return findauthortext;
    }

    public void setFindauthortext(String findauthortext) {
        this.findauthortext = findauthortext;
    }

    public int getReadbalance() {
        return readbalance;
    }

    public void setReadbalance(int readbalance) {
        this.readbalance = readbalance;
    }

    public List<Reader> getUserList() {
        return userList;
    }

    public void setUserList(List<Reader> userList) {
        this.userList = userList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void next() {
        if (currentPage < pages) {
            currentPage++;
            System.out.println(currentPage);
            updateList();
        }
    }



    public void previous() {
        if (currentPage > 1) {
            currentPage--;
            updateList();
        }
    }

    public void first() {
        currentPage = 1;
        updateList();
    }


    public void last() {
        currentPage = pages;
        updateList();
    }



    public ManagerBean() {
        ManagerDao dao = new ManagerDao();
        userList = dao.queryReader(0);
        commetList=dao.queryComment(0);
        bookList=dao.queryBooks(0);
        int size = dao.getSize();
        pages = size % 5 == 0 ? size / 5 : size / 5 + 1;
    }

    public void updateList() {
        ManagerDao dao = new ManagerDao();
        userList = dao.queryReader((currentPage - 1) * 5);
    }


}
