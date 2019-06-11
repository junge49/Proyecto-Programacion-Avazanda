package prueba;

import Entity.EmpleadoAL;
import Entity.EmpleadoG;
import dao.AutosDao;
import dao.EmpleadoALDao;
import dao.EmpleadoGDao;
import java.util.Date;

/**
 *
 * @author joel_
 */
public class Prueba {
    public static void main (String []args){
        EmpleadoALDao eal=new EmpleadoALDao();
        EmpleadoAL g = new EmpleadoAL();
        g=eal.buscarEmpleadoAL(5);
        Date d= new Date(20-11-11);
        //System.out.println(eal.actualizarEmpleadoG(3,"Josee", "Cervantes", "Lagunes", 2288243, "Centro", d, "M", 2000)); 
        //System.out.println(eal.eliminarEmpleadoG(2));
        //System.out.println(eal.insertarAuto(1, "Tsuru", "Nissan", "t90jk32", "Rojo", d, 0, 1));
    }
}
