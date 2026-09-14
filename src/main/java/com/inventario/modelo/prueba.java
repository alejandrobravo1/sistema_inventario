package com.inventario.modelo;

import com.inventario.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class prueba {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {



            Transaction transaction = session.beginTransaction();

            // Consulta HQL para obtener el rol por su ID
            RolVO rolAdmin = session.createQuery("FROM RolVO WHERE id_rol = :id", RolVO.class)
                                    .setParameter("id", 1)
                                    .uniqueResult();

            if (rolAdmin != null) {
                UsuarioVO usuario = new UsuarioVO();
                usuario.setUsername("osman");
                usuario.setCorreo("osas1@gmail.com");
                usuario.setPassword("1245");
                usuario.setEstado("Activo");
                usuario.setRol(rolAdmin);

                session.persist(usuario);
                transaction.commit();

                System.out.println("¡USUARIO GUARDADO CON ÉXITO!");
            } else {
                System.out.println("El Rol con ID 1 no fue encontrado en la base de datos.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}