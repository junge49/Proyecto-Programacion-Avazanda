/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Controlador.EspaciosEstJpaController;
import Entity.EspaciosEst;

/**
 *
 * @author joel_
 */
public class EspaciosEstDao {
    private EspaciosEstJpaController es= new EspaciosEstJpaController();
    private EspaciosEst es2 = new EspaciosEst();
    private String mensaje;
    public String insertarEspaciosEst(){
        try{
            es2.setIdEspaciosEst(Integer.BYTES);
            es2.setOcupado(0);
            es.create(es2);
            mensaje="Guardado correctamente";
        }catch (Exception e){
            System.err.println(e);
            mensaje = "No se pudo guardar la información.";
        }
        return mensaje;
    }
    public String insertarEspaciosEst(int id,int ocp){
        try{
            es2.setIdEspaciosEst(id);
            es2.setOcupado(ocp);
            es.edit(es2);
            mensaje="Actualizado correctamente";
        }catch (Exception e){
            System.err.println(e);
            mensaje = "No se pudo actualizar la información.";
        }
        return mensaje;
    }
}
