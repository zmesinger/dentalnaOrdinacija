/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mesinger.dentord.controller;

import hr.mesinger.dentord.model.MedicinskaSestra;
import hr.mesinger.dentord.util.EdunovaException;
import hr.mesinger.dentord.util.Pomocno;
import java.util.List;
import org.apache.commons.validator.routines.IBANValidator;

/**
 *
 * @author Zvonimir
 */
public class ObradaMedicinskaSestra extends Obrada<MedicinskaSestra>{
    
    public ObradaMedicinskaSestra(){
        super();
    }
    public ObradaMedicinskaSestra(MedicinskaSestra entitet){
        super(entitet);
    }
    

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaIban();
        kontrolaOib();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
    }

    @Override
    public List<MedicinskaSestra> getPodaci() {
        return session.createQuery("from MedicinskaSestra").list();
    }

    @Override
    protected void nakonSpremanja() throws EdunovaException {
    }
     private void kontrolaIban() throws EdunovaException{
     //    IBANValidator iv =  IBANValidator.getInstance();
       // iv.setValidator("hr", 32, "");
        //if(!iv.isValid(entitet.getIban())){
         //   throw  new EdunovaException("IBAN nije dobar");
       // }
    }
     private void kontrolaOib() throws EdunovaException{
        if(!Pomocno.isOibValjan(entitet.getOib())){
            throw new EdunovaException("OIB nije valjan");
        }
    }
}
