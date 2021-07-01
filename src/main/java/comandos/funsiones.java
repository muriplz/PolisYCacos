package comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

// Buenos días, he aquí un ejemplo de como abusar de static :)
public class funsiones {

    private static double DISTANCIA_CACHEAR = 7;
    // Devuelve el caco más cercano
    public static Player getCacoCercano(Player poli) {
        // Inicializo el caco más cercano
        Player cacoCercano = null;

        // Pillo las coordenadas del policía
        Location locPoli = poli.getLocation();

        // Inicializo el módulo de menor tamaño
        double moduloMenor = 30000000;

        // Miro que haya jugadores conectados
        if(!Bukkit.getServer().getOnlinePlayers().isEmpty()){

            // Hago un ciclo por todos los jugadores online
            for(Player caco : Bukkit.getServer().getOnlinePlayers()){

                // Pillo las coordenadas del caco
                Location locCaco = caco.getLocation();

                // Distancia entre caco y poli
                double modulo = locPoli.distance(locCaco);

                // Si el módulo es más pequeño que cualquier otro, nos quedamos con ese, para sacar el vector de menor módulo
                // También es necesario que no sea un poli
                if(modulo < moduloMenor && !caco.hasPermission("pyc.poli")){
                    moduloMenor = modulo;
                    cacoCercano = caco;
                }
            }
        }else{
            return null;
        }
        if(moduloMenor>DISTANCIA_CACHEAR){
            return null;
        }
        return cacoCercano;
    }

    // Función para hallar vector al cuadrado; es decir, (x^2,y^2,z^2) (vale para cualquier n perteneciente a N)
   public static double[] cuadradoVector (double[] vector){

       // Repito esto las veces que sean dependiendo de la dimensión de "vector"
       for(int i=0;i<vector.length;i++){

           // Calculo cada coordenada al cuadrado (no encuentro forma de hacer operaciones elementales --> son operaciones elementales si K * v = (K*x,K*y,K*z) siendo v un vector)
           vector[i]=vector[i]*vector[i];
       }
       return vector;
   }

   // Función para hallar cuanto vale x+y+z en un vector
   public static int sumaVector(double[] vector){
       int suma = 0;
       for (double v : vector) {
           suma += v;
       }
       return suma;
   }

    // Para mandar mensajes con base hexadecimal (&1,&2,&3,...)
    public static void sendMessage(Player player,String message){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
