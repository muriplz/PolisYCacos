package comandos;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

// Buenos días, he aquí un ejemplo de como abusar de static :)
public class funsiones {

    // Cambia el Player poli por el caco más cercano
    public static void getCacoCercano(Player poli) {

        // Pillo las coordenadas del policía
        Location locPoli = poli.getLocation();

        // Hago un ciclo por todos los jugadores online
        for(Player caco : Bukkit.getServer().getOnlinePlayers()){

            // Pillo las coordenadas del caco
            Location locCaco = caco.getLocation();

            // Inicializo el vector posición (punto A del vector AB -> el policía)
            double[] vectorPosicion;
            vectorPosicion = new double[3];

            // Posición x del vector (x,y,z)
            vectorPosicion[0] = locCaco.getX() - locPoli.getX();

            // Posición y del vector (x,y,z)
            vectorPosicion[1] = locCaco.getY() - locPoli.getY();

            // Posición z del vector (x,y,z)
            vectorPosicion[2] = locCaco.getZ() - locPoli.getZ();

            // Módulo del vector v = (x,y,z)


            // Formula módulo = raíz cuadrada( x ^ 2 + y ^ 2 + z ^ 2 )
            double modulo = Math.sqrt(sumaVector(cuadradoVector(vectorPosicion)));

            // Inicializo el módulo de menor tamaño
            double moduloMenor = 15000000;

            // Si el módulo es más pequeño que cualquier otro, nos quedamos con ese, para sacar el vector de menor módulo
            // También es necesario que no sea un poli
            if(modulo < moduloMenor && !caco.hasPermission("polisycacos.poli")){

                moduloMenor = modulo;

                // Aquí lo que hago es devolver al caco que menor módulo tiene como el poli, aunque no sea el poli. (consecuencia de ser un "void" para simplificar)
                poli = caco;
            }
        }


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
}
