package com.inventario.config;

import com.inventario.modelo.RolVO;
import com.inventario.modelo.UsuarioVO;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            
            Configuration configuration = new Configuration();
            
            configuration.setProperty(
                    "hibernate.connection.driver_class",
                    "com.mysql.cj.jdbc.Driver"
            
            );
            
            configuration.setProperty(
                    "hibernate.connection.url",
                    "jdbc:mysql://localhost:3306/sistem_inv?useSSL=false&serverTimezone=UTC"
            
            );
            
            configuration.setProperty(
                    "hibernate.connection.username",
                    "root"
            
            );


            configuration.setProperty(
                    "hibernate.connection.password",
                    ""
            
            );

            configuration.setProperty(
                    "hibernate.connection.driver_class",
                    "com.mysql.cj.jdbc.Driver"
            
            );

            configuration.setProperty(
                    "hibernate.dialect",
                    "org.hibernate.dialect.MySQLDialect"
            
            );        
            
            configuration.setProperty(
                    "hibernate.hbm2ddl.auto",
                    "update"
            
            ); 
            
            configuration.addAnnotatedClass(RolVO.class);
            configuration.addAnnotatedClass(UsuarioVO.class);
            
            
            return configuration.buildSessionFactory();
            
        } catch (Throwable ex) {
            System.err.println("Error al inicializar la SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}