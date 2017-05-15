/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Passagem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 09123471980
 */
@Stateless
public class PassagemFacade extends AbstractFacade<Passagem> {

    @PersistenceContext(unitName = "GerenciadorPassagens-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PassagemFacade() {
        super(Passagem.class);
    }
    
}
