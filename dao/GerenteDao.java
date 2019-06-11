package dao;

import Controlador.GerenteJpaController;
import Entity.Gerente;

/**
 *
 * @author joel_
 */
public class GerenteDao {
    private GerenteJpaController ge= new GerenteJpaController();
    private Gerente g = new Gerente();
    public boolean buscarGerente(int id, String contra){
        try{
            g=ge.findGerente(id);
            if (g.getContraseña().equals(contra)){
                return true;
            }
        }catch(Exception e){
            System.out.println("Errorr: "+e);
        }
        return false;
    }
}
