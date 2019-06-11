
package dao;

import Controlador.EmpleadoALJpaController;
import Entity.EmpleadoAL;
import java.util.Date;

/**
 *
 * @author joel_
 */
public class EmpleadoALDao {
    private EmpleadoALJpaController emp= new EmpleadoALJpaController();
    private EmpleadoAL eau = new EmpleadoAL();
    private String mensaje;
    public String insertarEmpleadoAL(String nombre, String aPaterno, String aMaterno, int tel, String direccion, Date fechaNac, String genero, double sueldo){
        try{
            eau.setIdEmpleadoAL(Integer.BYTES);
            eau.setNombre(nombre);
            eau.setAPaterno(aPaterno);
            eau.setAMaterno(aMaterno);
            eau.setTelefono(tel);
            eau.setDireccion(direccion);
            eau.setFechaNac(fechaNac);
            eau.setGenero(genero);
            eau.setSueldo(sueldo);
            emp.create(eau);
            mensaje = "Guardado correctamente.";
        } catch (Exception e){
            System.out.println("Errorrrr: "+e);
            mensaje="No se pudo guardar la información";
        }
        return mensaje;
    }
    public String actualizarEmpleadoAL(int id, String nombre, String aPaterno, String aMaterno, int tel, String direccion, Date fechaNac, String genero, double sueldo){
        try{
            eau.setIdEmpleadoAL(id);
            eau.setNombre(nombre);
            eau.setAPaterno(aPaterno);
            eau.setAMaterno(aMaterno);
            eau.setTelefono(tel);
            eau.setDireccion(direccion);
            eau.setFechaNac(fechaNac);
            eau.setGenero(genero);
            eau.setSueldo(sueldo);
            emp.edit(eau);
            mensaje = "Actualizado correctamente.";
        } catch (Exception e){
            System.out.println("Errorrrr: "+e);
            mensaje="No se pudo actualizar la información";
        }
        return mensaje;
    }
    public String eliminarEmpleadoAL(int id){
        try{
            emp.destroy(id);
            mensaje = "Eliminado correctamente.";
        }catch(Exception e){
            System.out.println("Errorrrr: "+e);
            mensaje="No se pudo eliminar la información";
        }
        return mensaje;
    }
    public EmpleadoAL buscarEmpleadoAL(int id){
        try{
            eau=emp.findEmpleadoAL(id);
            System.out.println("Usuario encontrado.");
        }catch(Exception e){
            System.out.println("Errorrrr: "+e);
            mensaje="Usuario inexistente";
        }
        return eau;
    }
    public boolean bBuscarEmpleadoAL(int id){
        try{
            eau=emp.findEmpleadoAL(id);
            System.out.println("Usuario encontrado.");
            
        }catch(Exception e){
            System.out.println("Errorrrr: "+e);
            mensaje="Usuario inexistente";
            return false;
        }
        return true;
    }
}
