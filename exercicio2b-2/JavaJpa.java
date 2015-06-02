/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefet.view;

import lp2.persistence.PersistenceSingleton;
import javax.persistence.EntityManagerFactory;
import lp2.controller.UsuarioJpaController;
import lp2.model.Usuario;

/**
 *
 * @author alunos
 */
public class JavaJpa {
    public static void main(String[] a) {
        EntityManagerFactory ponte = PersistenceSingleton.getInstance().getEntityManagerFactory();
        System.out.println(ponte);
        
        UsuarioJpaController usuController = new UsuarioJpaController(ponte);
        
        Usuario u1 = new Usuario();
        usuController.create(u1);
        System.out.println(u1.toString());
    }
}
