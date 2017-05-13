/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Clientes;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Matheus
 */
@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> {

    @PersistenceContext(unitName = "GerenciadorPassagens-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public void autenticar(String login, String senha){
        Query query = em.createQuery("Clientes.autenticar");
        query.setParameter("senha", senha);
        query.setParameter("login", login);
        List<Clientes> cliente = query.getResultList();
        if(cliente.isEmpty()){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("erro");
            } catch (IOException ex) {
                System.err.println("ERRO REDIRECIONAMENTO "+ex);
            }
        }
        
    }

    public ClientesFacade() {
        super(Clientes.class);
    }
    
}
