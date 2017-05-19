/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Passagem;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PassagemFacade extends AbstractFacade<Passagem> {

    @PersistenceContext(unitName = "GerenciadorPassagens-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    

    public List<Passagem> listaDisponiveis(Timestamp agora){
        Query query = em.createQuery("SELECT p FROM Passagem p WHERE p.assentosDisponiveis > 0 AND p.horario > :horario ORDER BY p.horario");
        query.setParameter("horario", agora);
        return query.getResultList();
    }

    public PassagemFacade() {
        super(Passagem.class);
    }
    
}
