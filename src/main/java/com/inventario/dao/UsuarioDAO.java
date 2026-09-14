/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.dao;

import com.inventario.config.HibernateUtil;
import com.inventario.modelo.UsuarioVO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


/**
 *
 * @author osals
 */
public class UsuarioDAO {
    
   /** public boolean resgistrarUsuario (UsuarioVO usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.persist(usuario);
            transaction.commit();
            return true;               
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("error al guardar usuario" + e.getMessage());
            e.printStackTrace();
            return false;
        }
                    
    }
            **/
        public boolean registrarUsuario (UsuarioVO usuario) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();

                session.persist(usuario);

                transaction.commit();
                return true;
            } catch (Exception e) {
                // En try-with-resources la sesión ya se cerró al llegar aquí,
                // por lo que debemos validar si la transacción todavía se puede revertir
                if (transaction != null && transaction.getStatus().canRollback()) {
                    try {
                        transaction.rollback();
                    } catch (Exception rollbackEx) {
                        System.err.println("Error al hacer rollback: " + rollbackEx.getMessage());
                    }
                }
                System.err.println("Error al guardar usuario: " + e.getMessage());
                e.printStackTrace();
                return false;
            }
        }

    
public boolean existeUsuario(String username) {
       
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            // Consulta HQL que cuenta los registros que coinciden con el username
            String hql = "SELECT COUNT(u) FROM UsuarioVO u WHERE u.username = :user";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("user", username);
            
            Long cantidad = query.uniqueResult();
            return cantidad != null && cantidad > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
       
        
    }

    
    
    public UsuarioVO buscarUsuarioxId(int id_usuario) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        return session.find(UsuarioVO.class, id_usuario);
    } catch (Exception e) {
        System.out.println("error al buscar por id: " + e.getMessage());
        e.printStackTrace();
    }
    return null; // Retorno en caso de que ocurra una excepción
}
    // ==========================================
    // 4. UPDATE (Actualizar datos de Usuario)
    // ==========================================
    public boolean actualizar(UsuarioVO usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(usuario); // Hibernate genera el UPDATE automáticamente
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error al actualizar usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // ==========================================
    // 5. DELETE (Eliminar Usuario)
    // ==========================================
    public boolean eliminar(int idUsuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            // Primero obtenemos el objeto existente
            UsuarioVO usuario = session.find(UsuarioVO.class, idUsuario);
            if (usuario != null) {
                session.remove(usuario); // Hibernate genera el DELETE automáticamente
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error al eliminar usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    
    public UsuarioVO validarLogin(String username, String password) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        String hql = "FROM UsuarioVO WHERE username = :user AND password = :pass";
        return session.createQuery(hql, UsuarioVO.class)
                      .setParameter("user", username)
                      .setParameter("pass", password)
                      .uniqueResult();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
};

