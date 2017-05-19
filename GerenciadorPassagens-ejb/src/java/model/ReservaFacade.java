/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Clientes;
import entities.Reserva;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 09123471980
 */
@Stateless
public class ReservaFacade extends AbstractFacade<Reserva> {

    @PersistenceContext(unitName = "GerenciadorPassagens-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Reserva> listaPorClienteAtivo(Clientes cliente){
        Query query = em.createQuery("SELECT r FROM Reserva r WHERE r.idCliente = :idCliente");
        query.setParameter("idCliente", cliente);
        return query.getResultList();
    }

    public ReservaFacade() {
        super(Reserva.class);
    }
    
}
