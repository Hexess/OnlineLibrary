package com.library.dao;


import com.library.pojo.Author;
import com.library.pojo.Books;
import com.library.pojo.Comment;
import com.library.pojo.Manager;
import com.library.pojo.Reader;
import com.qdu.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManagerDao {

    public Manager findManager(String managerID, String managerPassword) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Query query = session.createQuery("from Manager where managerID=:managerID and managerPassword=:managerPassword");
            query.setString("managerID", managerID);
            query.setString("managerPassword", managerPassword);
            List<Manager> list = (List<Manager>) query.list();
            if (list.size() != 0) //如果集合中有数据
            {
                return list.get(0); //获取集合中的第一个User对象            
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public int insert(Manager manager) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.save(manager);
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

    public void delete(String managerID) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            Manager manager = (Manager) session.load(Manager.class, managerID);
            session.delete(manager);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Reader findReader(String findreadtext) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Query query = session.createQuery("from Reader where readID=:rid  ");
            query.setString("rid", findreadtext);
            List<Reader> list = (List<Reader>) query.list();

            if (list.size() != 0) {
                return list.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public Author findAuthor(String findauthor) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Query query = session.createQuery("from Author where authorName=:aname");
            query.setString("aname", findauthor);
            List<Author> list = (List<Author>) query.list();
            if (list.size() != 0) {
                return list.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public Reader deleteReader(String readID) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            Reader reader = (Reader) session.load(Reader.class, readID);
            session.delete(reader);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
        public Comment deleteComment(int ID) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            Comment comment = (Comment) session.load(Comment.class, ID);
            session.delete(comment);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public Reader updateMessage(Reader reader) {

        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.update(reader);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public Reader Recharge(String readID, int readbalance) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            Reader reader = (Reader) session.load(Reader.class, readID);
            reader.setReadBalance(reader.getReadBalance() + readbalance);
            session.update(reader);
            session.save(reader);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;

    }

    public List<Reader> queryReader(int first) {
        Session session = HibernateUtil.getSession();
        String sql = "from Reader";
        Query query = session.createQuery(sql);
        query.setFirstResult(first);
        query.setMaxResults(5);
        List<Reader> list = (List<Reader>) query.list();
        session.close();
        return list;
    }
        public List<Comment> queryComment(int first) {
        Session session = HibernateUtil.getSession();
        String sql = "from Comment";
        Query query = session.createQuery(sql);
        query.setFirstResult(first);
        List<Comment> list = (List<Comment>) query.list();
        session.close();
        return list;
    }
                public List<Books> queryBooks (int first) {
        Session session = HibernateUtil.getSession();
        String sql = "from Books";
        Query query = session.createQuery(sql);
        query.setFirstResult(first);
        List<Books> list = (List<Books>) query.list();
        session.close();
        return list;
    }

    public int getSize() {
        Session session = HibernateUtil.getSession();
        String sql = "from Reader";
        Query query = session.createQuery(sql);
        return query.list().size();
    }
        public int getSize_c() {
        Session session = HibernateUtil.getSession();
        String sql = "from Comment";
        Query query = session.createQuery(sql);
        return query.list().size();
    }

    public Author updateMessage_a(Author author) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            session.update(author);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public Author deleteAuthor(String findauthortext) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            Transaction tran = session.beginTransaction();
            Author author = (Author) session.load(Author.class, findauthortext);
            session.delete(author);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
