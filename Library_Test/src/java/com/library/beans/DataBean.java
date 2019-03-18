package com.library.beans;

import com.library.dao.ReaderDao;
import com.library.pojo.Books;
import com.library.pojo.Borrow;
import com.library.pojo.Comment;
import com.library.pojo.Reader;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

@ManagedBean
@SessionScoped
public class DataBean {

    private String readname;
    private String readpassword;
    private Reader reader;
    private String searchword;
    private String selected;
    private String precisecontent;
    private ArrayList<Books> bookMap;
    private ArrayList<Comment> comMap;
    private String bookname;
    private Books books;
    private String password;
    private String readaddress;
    private String readmobile;
    private Comment comment;
    private Borrow borrow;
    private String message;
    private String message2;
    private String color;
    private String bookid;
    private String booksat;
    private String readid;
    private ArrayList<Borrow> borrowMap;
    private ArrayList<Comment> comMap2;
    private String caption;
    private String content;
     private Part part;
    private String src;

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
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

    public ArrayList<Borrow> getBorrowMap() {
        return borrowMap;
    }

    public void setBorrowMap(ArrayList<Borrow> borrowMap) {
        this.borrowMap = borrowMap;
    }

    public ArrayList<Comment> getComMap2() {
        return comMap2;
    }

    public void setComMap2(ArrayList<Comment> comMap2) {
        this.comMap2 = comMap2;
    }

    public String getReadid() {
        return readid;
    }

    public void setReadid(String readid) {
        this.readid = readid;
    }

    public String getBooksat() {
        return booksat;
    }

    public void setBooksat(String booksat) {
        this.booksat = booksat;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReadaddress() {
        return readaddress;
    }

    public void setReadaddress(String readaddress) {
        this.readaddress = readaddress;
    }

    public String getReadmobile() {
        return readmobile;
    }

    public void setReadmobile(String readmobile) {
        this.readmobile = readmobile;
    }

    public ArrayList<Comment> getComMap() {
        return comMap;
    }

    public void setComMap(ArrayList<Comment> comMap) {
        this.comMap = comMap;
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

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getPrecisecontent() {
        return precisecontent;
    }

    public void setPrecisecontent(String precisecontent) {
        this.precisecontent = precisecontent;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public ArrayList<Books> getBookMap() {
        return bookMap;
    }

    public void setBookMap(ArrayList<Books> bookMap) {
        this.bookMap = bookMap;
    }

    public String getSearchword() {
        return searchword;
    }

    public void setSearchword(String searchword) {
        this.searchword = searchword;
    }

    public String getReadname() {
        return readname;
    }

    public void setReadname(String readname) {
        this.readname = readname;
    }

    public String getReadpassword() {
        return readpassword;
    }

    public void setReadpassword(String readpassword) {
        this.readpassword = readpassword;
    }

    public Reader getReader() {
        return reader;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public void registerReader() {
        ReaderDao dao = new ReaderDao();
        upload();
        int rows = dao.register(reader);
        if (rows != 0) {
            message = "注册成功，请跳转到登录页面登录！";
            color = "green";
        } else {
            message = "注册失败，请检查信息！";
            color = "red";
        }
    }

    public String changePassword() {
        ReaderDao dao = new ReaderDao();
        dao.updatePassword(reader.getReadId(), readpassword);
        return "index";
    }

    public String changeMes() {
        ReaderDao dao = new ReaderDao();
        dao.updateMessage(reader.getReadId(), readmobile, readaddress);
        return "main";
    }

    public String deleteread() {
        ReaderDao dao = new ReaderDao();
        readid = reader.getReadId();
        dao.deletereader(readid);
        return "index";

    }

    public String validateReader() {

        ReaderDao dao = new ReaderDao();
        reader = dao.findUser(readname, readpassword);
        if (reader != null) {
            return "main";
        } else {
            return "fail";
        }
    }

    public String menuBook() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        bookname = request.getParameter("name");
        ReaderDao dao = new ReaderDao();
        books = dao.findBook(bookname);
        comMap = dao.commentQuery(bookname);
        if ((books.getBookStaus().trim()).equals("在库")) {
            return "BookInformation";
        } else {
            return "BookView";
        }
    }

    public String searchblur() {
        ReaderDao dao = new ReaderDao();
        bookMap = dao.blurQuery(searchword);
        return "BlurSearch";
    }

    public String searchprecise() {
        ReaderDao dao = new ReaderDao();
        bookMap = dao.precisesearch(selected, precisecontent);
        return "PreciseSearchResult";
    }

    public void insertcomment() {
        ReaderDao dao = new ReaderDao();
        comment.setReadId(reader.getReadId());
        comment.setReadName(reader.getReadName());
        comment.setBookId(books.getBookId());
        comment.setBookName(books.getBookName());
        comment.setPortrait(reader.getPortrait());
        comment.setCommentDate(new Date().toLocaleString());
        int rows = dao.insertcomment(comment);
        if (rows != 0) {
            message = "成功！";
            color = "green";
        } else {
            message = "失败！";
            color = "red";
        }
    }

    public void insertborrow() {
        int rows;
        ReaderDao dao = new ReaderDao();
        borrow.setReadId(reader.getReadId());
        borrow.setBookId(books.getBookId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        borrow.setBorrowDate(sdf.format(new Date()));
        borrow.setReturnDate("未还");
        bookid = books.getBookId();
        booksat = books.getBookStaus();
        System.out.println(books.getBookStaus());
        if (booksat.equals("借出")) {
            rows = 0;
        } else {
            books.setBookStaus("借出");
            rows = dao.insertborrow(borrow, bookid, reader, reader.getReadId());
        }
        
        if (rows != 0) {
            message2 = "借阅成功！";
            color = "green";
        } else {
            message2 = "失败或图书不在库！";
            color = "red";
        }
    }

    public String borrowInfo() {
        ReaderDao dao = new ReaderDao();
        borrowMap = dao.findBorrow(reader.getReadId());
        comMap2 = dao.commentQueryByReadId(reader.getReadId());
        return "PersonalCenter";
    }

    public void returnBook(int id) {
        ReaderDao dao = new ReaderDao();
        dao.UpdateBorrow(id);
    }

    public void deleteComment(int id) {
        ReaderDao dao = new ReaderDao();
        dao.deleteComment(id);
    }

    public void updateComment(int id,String caption,String content) {
        ReaderDao dao = new ReaderDao();
        dao.updateComment(id,caption,content);
    }
 public void upload(){
try{
      String file = getClass().getResource("/../../").getFile().toString();
    String src = file.substring(1, file.length());
    String src1=src.replaceAll("build/", "");
    System.out.println(src1);
BufferedImage bi = ImageIO.read(part.getInputStream());
File f1 = new File(src1+"portrait/"+reader.getReadId()+".png");
reader.setPortrait("portrait/"+reader.getReadId()+".png");
		if (!f1.exists())
			f1.mkdirs();
ImageIO.write(bi, "png", f1);

}catch(Exception ex){
    ex.printStackTrace();
    
}
    }
    public DataBean() {
        comment = new Comment();
        borrow = new Borrow();
        reader = new Reader();
    }

}
