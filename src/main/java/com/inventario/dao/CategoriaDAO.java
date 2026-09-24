/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.dao;

import com.inventario.config.HibernateUtil;
import org.hibernate.Transaction;

import com.inventario.modelo.CategoriaVO;
import java.util.List;
import org.hibernate.Session;


/**
 * @author osals
 */
public class CategoriaDAO {

    public boolean registrarCategoria(CategoriaVO categoria) {
        Transaction transaction = null;

        // IMPRESIÓN 1: Verificar qué nombre llegó desde el Controller
        System.out.println(">>> DAO: Intentando guardar la categoría -> " + categoria.getNombre_categoria());

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            session.persist(categoria);
            
            transaction.commit();
            
            System.out.println(">>> DAO: ¡ÉXITO! Guardado en MySQL correctamente.");
            return true;

        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                try {
                    transaction.rollback();
                } catch (Exception rollbackEx) {
                    System.err.println("Error en Rollback: " + rollbackEx.getMessage());
                }
            }
            // IMPRESIÓN 2: Ver la causa exacta de la falla en NetBeans
            System.err.println(">>> DAO ERROR: Falló la persistencia en Hibernate!");
            e.printStackTrace(); // Imprime la pila de errores roja en consola
            return false;
        }
    }
    
    
    
    public CategoriaVO buscarCategoria ( int id_categoria) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){          
            return session.find(CategoriaVO.class, id_categoria);     
     } catch (Exception e){
         System.out.println("error al buscar por id: " + e.getMessage());
         e.printStackTrace();       
    }
    return null;
    
    }

    


   public boolean eliminarCategoria (int id_categoria) {
       Transaction transaction = null ;
       try (Session session = HibernateUtil.getSessionFactory().openSession()){
           transaction = session.beginTransaction();
           
           CategoriaVO categoria = session.find(CategoriaVO.class, id_categoria);
           if (categoria != null){
               session.remove(categoria);
               transaction.commit();
               return true;
           }
           return false;                                 
       } catch (Exception e) {
           if (transaction != null) transaction.rollback();
            System.err.println("Error al eliminar categoria: " + e.getMessage());
            e.printStackTrace();
            return false;
       }
       
       
   }
   /**
   public List<CategoriaVO> listarCategorias() {

    try (Session session = HibernateUtil.getSessionFactory().openSession()) {

        return session
                .createQuery("FROM CategoriaVO", CategoriaVO.class)
                .getResultList();

    } catch (Exception e) {

        System.out.println("Error al listar categorias: " + e.getMessage());
        e.printStackTrace();

        return new ArrayList<>();
    }
}
   **/
   
public List<CategoriaVO> listarCategorias() {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {

        List<CategoriaVO> categorias = session
                .createQuery("FROM CategoriaVO", CategoriaVO.class)
                .getResultList();

        System.out.println(">>> DAO: Categorías encontradas = " + categorias.size());
        return categorias;

    } catch (Exception e) {
        System.err.println(">>> DAO ERROR AL LISTAR CATEGORIAS");
        e.printStackTrace();
        // Retornar lista vacía evita el NullPointerException en el JSP
        return new java.util.ArrayList<>();
    }
}
   public boolean actualizarCategoria (CategoriaVO categoria) {
       Transaction transaction = null;
       try (Session session = HibernateUtil.getSessionFactory().openSession()){
           transaction = session.beginTransaction();
           session.merge(categoria);
           transaction.commit();
           return true;
           
       } catch (Exception e) {
           
           if (transaction != null){
               transaction.rollback();
               
           }
           System.out.println("error al actualizar categoria" + e.getMessage());
           e.printStackTrace();
           return false;
       }
   }






}