import java.util.Scanner;
public class Register {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Hola este es el registro de las rutas biodiversas de la franja multicolor de la COP 16, si deseas hacer un nuevo registro por favor digita el nombre del colaborador voluntario: ");
        String name = sc.nextLine();

        System.out.println("Por favor digite el numero de cedula:"); 
        String personalId = sc.nextLine();

        if (name == null  || name == "" || personalId == null || personalId.length() > 15) {
            System.out.println("lo sentimos, no se puede continuar la información del voluntario no es valida. ");
            return;
        }
        System.out.println("Bienvenido " + name + "!");

        System.out.println("Escoge una de las siguientes rutas");
        System.out.println("1. Ruta Ladera");
        System.out.println("2. Ruta del Oriente");
        System.out.println("3. Ruta de los Farallones");
        System.out.println("Por favor digite el numero de la ruta que desea:");
        
        int numberOption = sc.nextInt();

        switch (numberOption) {
            case 1: System.out.println("Esta es la información de la Ruta Ladera:\nPunto de encuentro: Bulevar del rio\nHora de inicio: 7am Hora de cierre: 3pm");
                break;
            case 2: System.out.println("Esta es la información de la  Ruta del Oriente:\nPunto de encuentro: Bulevar del rio \nHora de inicio: 7amHora de cierre: 1pm");  
                break;
            case 3: System.out.println("Esta es la información de la Ruta de los Farallones:\nPunto de encuentro: Universidad del valle \nHora de inicio: 6:40am\nHora de cierre: 2:30pm");  
                break;
            default: System.out.println("Lo sentimos el numero de ruta no es valido");
                return;
        }
        System.out.println("Por favor ingrese la cantidad de participantes de la actividad");
        int numberParticipants = sc.nextInt();

        System.out.println("Por favor ingrese la cantidad de guias de la actividad");
        int numberVoluntaeers = sc.nextInt();
        if (numberParticipants < 1 || numberVoluntaeers < 1) {
            System.out.println("lo sentimos deben existir participantes para desarrollar la actividad");
            return;
        }
        System.out.println("Por favor ingrese los datos meteorológicos. Digite los grados centígrados:");
        float temperature = sc.nextFloat();
        System.out.println("Por favor ingrese el % de humedad:");
        float humidity = sc.nextFloat();
        if (humidity < 0 || humidity > 100) {
            System.out.println("lo sentimos los datos meteorológicos no son validos");
            return;      
         }
        if (temperature >= 20 && temperature <= 25 && humidity >= 40 && humidity <= 60 ) {
            System.out.println("¡Hace un buen día para caminar por Cali!");
            
        }
        int totalParticipants = numberParticipants + numberVoluntaeers;
        Double bussesCapacity = 25.0;
        double totalBusses = Math.ceil(totalParticipants/bussesCapacity);
        System.out.println("Al ser un total de " + totalParticipants + " personas que harán parte de la actividad.");
        System.out.println("se necesitarán un total de: "+ totalBusses +" para llevarla a cabo de manera exitosa.\n¡Nos vemos en la COP16!");


    }
}
