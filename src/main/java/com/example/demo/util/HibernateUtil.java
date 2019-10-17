package com.example.demo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author by ys
 * @create by 2019/10/16
 */
public class HibernateUtil {
    /**
     * 在没有使用springBoot+hibernate的情况下，hibernate基本工具包，用来连接数据库；
     * 创建SessionFactory session等操作
     */
    private static SessionFactory sessionFactory;
    //创建线程局部变量用来存储session
    private final static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

    /**
     * 应用启动时只加载一次
     */
    static {
        try {
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable throwable) {
            throw new ExceptionInInitializerError(throwable);
        }
    }

    /**
     * 获取sessionFactory实例
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * 使用ThreadLocal管理session实例
     */
    public static Session getSession() {
        Session session = threadLocal.get();
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = sessionFactory != null ? sessionFactory.openSession() : null;
            threadLocal.set(session);
        }
        return session;
    }

    /**
     * 关闭session实例
     */
    public static void closeSession() {
        Session session = threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }
    }

    /**
     * 重建session
     */
    private static void rebuildSessionFactory() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭缓存和连接池
     */
    public static void shutdown() {
        getSessionFactory().close();
    }
}
