
package com.qdu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//加载配置文件，创建SessionFactory对象
//或者说直接用它生成Session对象
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    //单例模式
    static {
        try {
            Configuration cfg=new Configuration().configure();
            sessionFactory = cfg.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession(){
        return sessionFactory.openSession();
    }
}
