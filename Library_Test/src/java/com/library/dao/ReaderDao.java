
package com.library.dao;

import com.library.pojo.Books;
import com.library.pojo.Borrow;
import com.library.pojo.Comment;
import com.library.pojo.Reader;
import com.qdu.util.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ReaderDao {
    public Reader findUser(String readname,String readpassword){
       Session session=null;
       try{
           session=HibernateUtil.getSession();
            Query query=session.createQuery("from Reader where readName=:rname and readPassword=:rpwd");
            query.setString("rname",readname);
            query.setString("rpwd",readpassword);
            List<Reader> list=(List<Reader>)query.list();
             if(list.size()!=0) 
                return list.get(0);
       }catch(Exception e){
           e.printStackTrace();
       }finally{
            if(session!=null)
                session.close();
        }
        return null;
    }
     public int register(Reader reader) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.save(reader);
            tran.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

     public void updatePassword(String readid, String newPassword) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran=session.beginTransaction();
            Reader reader=(Reader)session.load(Reader.class, readid); 
            reader.setReadPassword(newPassword);
            session.update(reader);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
     public void updateMessage(String readidd, String newMobile,String newAddress) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran=session.beginTransaction();
            Reader reader=(Reader)session.load(Reader.class, readidd); 
            reader.setReadAddress(newAddress);
            reader.setReadMobile(newMobile);
            session.update(reader);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public ArrayList<Books> blurQuery(String searchword){
         //HashMap<Integer,Books> book=new HashMap<>();
         Session session=null;
         session=HibernateUtil.getSession();
         Query query=session.createQuery("from Books where writerName like :name or bookName like :name or press  like :name or country  like :name or category  like :name ");
         query.setString("name","%"+searchword+"%");
         List<Books> list=(List<Books>)query.list();

         if(list.isEmpty()) return null;
         ArrayList<Books> book=new ArrayList<>();
         for(int i=0;i<list.size();i++){
             book.add(list.get(i));
         }
         return book;
    }
    
     public Books findBook(String bookname){
       Session session=null;
       try{
            session=HibernateUtil.getSession();
            Query query=session.createQuery("from Books where bookName=:bname");
            query.setString("bname",bookname);
            List<Books> list=(List<Books>)query.list();
             if(list.size()!=0) 
                return list.get(0);
       }catch(Exception e){
           e.printStackTrace();
       }finally{
            if(session!=null)
                session.close();
        }
        return null;
    }
     
    public int insertborrow(Borrow borrow,String bookid,Reader reader,String readid)
	{
                 Session session=null;
		try {
                    session=HibernateUtil.getSession();
                    Transaction tran = session.beginTransaction();
                    Books bo=(Books)session.load(Books.class,bookid); 
                    Reader re=(Reader)session.load(Reader.class,readid);
                    re.setReadBalance(re.getReadBalance()-5);
                    bo.setBookStaus("借出");
                    session.update(bo);
	            session.save(borrow) ;
	            tran.commit() ;
                    return 1;
                    
		} catch (Exception e) {
			e.printStackTrace();
                        return 0;
		}finally {
            if (session != null) {
                session.close();
            }
                }
	}
       
    public ArrayList<Books> precisesearch(String selected,String precisecontent){
         Session session=null;
         session=HibernateUtil.getSession();
         Query query=session.createQuery("from Books book where exists(from BookCategory bookcategory where bookcategory.bookId=book.bookId and bookcategory.categoryNo=:x1 and bookcategory.categoryContent like :x2)");
         query.setString("x1", selected);
         query.setString("x2","%"+precisecontent+"%");
         List<Books> list=(List<Books>)query.list();

         if(list.isEmpty()) return null;
         ArrayList<Books> book=new ArrayList<>();
         for(int i=0;i<list.size();i++){
             book.add(list.get(i));
         }
         return book;
    }

    public ArrayList<Comment> commentQuery(String bookname){
         //HashMap<Integer,Books> book=new HashMap<>();
         Session session=null;
         session=HibernateUtil.getSession();
         Query query=session.createQuery("from Comment where bookName=:bname");
         query.setString("bname",bookname);
         List<Comment> list=(List<Comment>)query.list();

         if(list.isEmpty()) return null;
         ArrayList<Comment> com=new ArrayList<>();
         for(int i=0;i<list.size();i++){
             com.add(list.get(i));
         }
         return com;
    }
    
      public int insertcomment(Comment comment) {
     
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.save(comment);
            tran.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
      
        public void deletereader(String readid) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            Reader r = (Reader) session.load(Reader.class,readid);
            session.delete(r);
            tran.commit();
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
        public ArrayList<Borrow> findBorrow(String readId) {
        Session session = null;
        session = HibernateUtil.getSession();
        Query query = session.createQuery("from Borrow where readId=:rid");
        query.setString("rid", readId);
        List<Borrow> list = (List<Borrow>) query.list();
        if (list.isEmpty()) {
            return null;
        }
        ArrayList<Borrow> borrow = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            borrow.add(list.get(i));
        }
        return borrow;

    }
         public void UpdateBorrow(int id) {
        System.out.println("----------" + id);
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            Borrow borrow = (Borrow) session.load(Borrow.class, id);
            System.out.println("----------" + borrow.getBorrowDate());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            borrow.setReturnDate(sdf.format(new Date()));
            System.out.println("----------" + borrow.getReturnDate());
            session.update(borrow);
            System.out.println("---------------");
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
         }
          public ArrayList<Comment> commentQueryByReadId(String readId) {
        Session session = null;
        session = HibernateUtil.getSession();
        Query query = session.createQuery("from Comment where readID=:rid");
        query.setString("rid", readId);
        List<Comment> list = (List<Comment>) query.list();

        if (list.isEmpty()) {
            return null;
        }
        ArrayList<Comment> com = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            com.add(list.get(i));
        }
        return com;
    }
         public void deleteComment(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            Comment comment = (Comment) session.load(Comment.class, id);
            
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
          public void updateComment(int id,String newCaption,String newContent) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            Comment comment = (Comment) session.load(Comment.class, id);
            comment.setCaption(newCaption);
            comment.setContent(newContent);
            session.update(comment);
            session.save(comment);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
        

    }
    

