/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Clientes;
import entities.Passagem;
import entities.Reserva;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.PassagemFacade;
import model.ReservaFacade;

/**
 *
 * @author 09123471980
 */
@Named(value = "reservaController")
@SessionScoped
public class ReservaController implements Serializable {

    @EJB
    private ReservaFacade reservaFacade;
   
    public ReservaController() {
    }
    
    public List<Reserva> findAll(){
        return this.reservaFacade.findAll();
    }
    
    public List<Reserva> listaPorClienteAtivo(){
        return this.reservaFacade.listaPorClienteAtivo(Session.getUsuario());
    }
    
    public String reservar(Passagem passagem){
        Reserva reserva = new Reserva();
        reserva.setIdPassagem(passagem);
        Session.getInstance();
        reserva.setIdCliente(Session.getUsuario());
        try{
            this.reservaFacade.create(reserva);
            return "listaReservas";
        }catch(Exception e){
            System.err.println(e);
            return "listaPassagem";
        }
    }
    
    public void cancelarReserva(Reserva reserva){
        this.reservaFacade.remove(reserva);
    }
}
