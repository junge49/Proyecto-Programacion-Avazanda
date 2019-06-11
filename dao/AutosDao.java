package dao;

import Controlador.AutosJpaController;
import Entity.Autos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author joel_
 */
public class AutosDao {
    private AutosJpaController emp= new AutosJpaController();
    private Autos au = new Autos();
    private boolean mensaje;
    public boolean insertarAuto(int ides, String modelo, String marca, String placa, String color, Date en, int lavado, int ideg){
        try{
            au.setIdAutos(Integer.BYTES);
            au.setIdEspacio(ides);
            au.setModelo(modelo);
            au.setMarca(marca);
            au.setPlaca(placa);
            au.setColor(color);
            au.setEntrada(en);
            au.setLavado(lavado);
            au.setIdEmpleadoG(ideg);
            au.setSalida(null);
            au.setPago(null);
            emp.create(au);
            mensaje=true;
        }catch(Exception e){
            System.out.println("Errorrr: "+e);
            mensaje=false;
        }
        return mensaje;
    }
    public boolean actualizarAuto(int id, int ides, String modelo, String marca, String placa, String color, Date en, int lavado, int ideg, Date sal, double pago){
        try{
            au.setIdAutos(id);
            au.setIdEspacio(ides);
            au.setModelo(modelo);
            au.setMarca(marca);
            au.setPlaca(placa);
            au.setColor(color);
            au.setEntrada(en);
            au.setLavado(lavado);
            au.setIdEmpleadoG(ideg);
            au.setSalida(sal);
            au.setPago(pago);
            emp.edit(au);
            mensaje=true;
        }catch(Exception e){
            System.out.println("Errorrr: "+e);
            mensaje=false;
        }
        return mensaje;
    }
    public boolean eliminarAuto(int id){
        try{
            emp.destroy(id);
            mensaje =true;
        }catch(Exception e){
            System.out.println("Errorrrr: "+e);
            mensaje=true;
        }
        return mensaje;
    }
    public List<Autos> regresaAllAutosActivos(){
        List<Autos> au= emp.findAutosEntities();
        List<Autos> rau=new ArrayList<Autos>();
        for (int i=0; i<au.size();i++){
            if (au.get(i).getPago()==null){
                rau.add(au.get(i));
            }
        }    
        return rau;
    }
}
