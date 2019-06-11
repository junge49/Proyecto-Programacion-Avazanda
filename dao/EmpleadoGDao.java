package dao;

import Controlador.EmpleadoGJpaController;
import Entity.EmpleadoG;
import java.util.Date;

/**
 *
 * @author joel_
 */
public class EmpleadoGDao {
    private EmpleadoGJpaController emp= new EmpleadoGJpaController();
    private EmpleadoG eg = new EmpleadoG();
    private String mensaje;
    public String insertarEmpleadoG(String nombre, String aPaterno, String aMaterno, int tel, String direccion, Date fechaNac, String genero, double sueldo){
        try{
            eg.setIdEmpleadoG(Integer.BYTES);
            eg.setNombre(nombre);
            eg.setAPaterno(aPaterno);
            eg.setAMaterno(aMaterno);
            eg.setTelefono(tel);
            eg.setDireccion(direccion);
            eg.setFechaNac(fechaNac);
            eg.setGenero(genero);
            eg.setSueldo(sueldo);
            emp.create(eg);
            mensaje = "Guardado correctamente.";
        } catch (Exception e){
            System.out.println("Errorrrr: "+e);
            mensaje="No se pudo guardar la información";
        }
        return mensaje;
    }
    public String actualizarEmpleadoG(int id, String nombre, String aPaterno, String aMaterno, int tel, String direccion, Date fechaNac, String genero, double sueldo){
        try{
            eg.setIdEmpleadoG(id);
            eg.setNombre(nombre);
            eg.setAPaterno(aPaterno);
            eg.setAMaterno(aMaterno);
            eg.setTelefono(tel);
            eg.setDireccion(direccion);
            eg.setFechaNac(fechaNac);
            eg.setGenero(genero);
            eg.setSueldo(sueldo);
            emp.edit(eg);
            mensaje = "Actualizado correctamente.";
        } catch (Exception e){
            System.out.println("Errorrrr: "+e);
            mensaje="No se pudo actualizar la información";
        }
        return mensaje;
    }
    public String eliminarEmpleadoG(int id){
        try{
            emp.destroy(id);
            mensaje = "Eliminado correctamente.";
        }catch(Exception e){
            System.out.println("Errorrrr: "+e);
            mensaje="No se pudo eliminar la información";
        }
        return mensaje;
    }
    public EmpleadoG buscarEmpleadoG(int id){
        try{
            eg=emp.findEmpleadoG(id);
            System.out.println("Usuario encontrado.");
        }catch(Exception e){
            System.out.println("Errorrrr: "+e);
            mensaje="Usuario inexistente";
        }
        return eg;
    }
    public boolean bBuscarEmpleadoG(int id){
        try{
            eg=emp.findEmpleadoG(id);
            System.out.println("Usuario encontrado.");
        }catch(Exception e){
            System.out.println("Errorrrr: "+e);
            mensaje="Usuario inexistente";
            return false;
        }
        return true;
    }
}
