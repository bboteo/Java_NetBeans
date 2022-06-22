
package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Extras {
    
    public int aleatorio(){
        int a = (int)(Math.random()*10+1);
        return a;
    }
    
    public static String fechaHoy(){
        String fechaHoy;
        Date fecha = new Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd");
        fechaHoy = sdf.format(fecha.getTime());
        return fechaHoy;
    }
}
