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
    private Reserva reserva = new Reserva();

   
    
    public ReservaController() {
    }
    
    public List<Reserva> findAll(){
        return this.reservaFacade.findAll();
    }
    
    public String reservar(Passagem passagem, Clientes cliente){
        this.reserva = new Reserva();
        reserva.setIdPassagem(passagem);
        reserva.setIdCliente(cliente);
        try{
            this.reservaFacade.create(reserva);
        }catch(Exception e){
            System.err.println(e);
        }
        this.reserva = new Reserva();
        return "listaPassagens";
    }
    
     public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    
}
