import java.util.Scanner;
public class Register {

    public static void main(String[] args) {

        /*
         * Programa para registro de voluntarios y calculo de numero de buses necesarios.
         */
        Scanner sc = new Scanner(System.in);

        //Solicitamos el nombre y numero de cedula para iniciar el registro
        System.out.println("Hola este es el registro de las rutas biodiversas de la franja multicolor de la COP 16, si deseas hacer un nuevo registro por favor digita el nombre del colaborador voluntario: ");
        String name = sc.nextLine();

        System.out.println("Por favor digite el numero de cedula:"); 
        String personalId = sc.nextLine();

        boolean validInput = register(name, personalId);
        if (!validInput) {
            return;
        }

        // Hacemos un menu con un swictch para que sea mas facil escoger una de las 3 rutas.
        System.out.println("Escoge una de las siguientes rutas");
        System.out.println("1. Ruta Ladera");
        System.out.println("2. Ruta del Oriente");
        System.out.println("3. Ruta de los Farallones");
        System.out.println("Por favor digite el numero de la ruta que desea:");
        
        int numberOption = sc.nextInt();

        boolean validOption = option(numberOption);
        if (!validOption) {
            return;
            
        }
        //Solicitamos el numero de guias y participantes para despues operarlo.
        System.out.println("Por favor ingrese la cantidad de participantes de la actividad");
        int numberParticipants = sc.nextInt();
        System.out.println("Por favor ingrese la cantidad de guias de la actividad");
        int numberVoluntaeers = sc.nextInt();

        boolean validParticipants = participants(numberParticipants, numberVoluntaeers);
        if (!validParticipants) {
            return;
            
        }


        //optenemos los datos meteorologicos para saber si hace un buen dia en cali
        System.out.println("Por favor ingrese los datos meteorológicos. Digite los grados centígrados:");
        float temperature = sc.nextFloat();
        System.out.println("Por favor ingrese el % de humedad:");
        float humidity = sc.nextFloat();
        
        boolean validWeatherData = weatherData(temperature, humidity);
        if (!validWeatherData) {
            return;
        }
        //Ya que el calculo de buses puede resulatar en decimal, lo aproximos al entero mas alto usando la funcion math.
        int totalParticipants = numberParticipants + numberVoluntaeers;
        final Double bussesCapacity = 25.0;
        calculateBusses(totalParticipants, bussesCapacity); 
    }

    /**
     * calcula la cantidad de buses necesarios. 
     * lo aproximos al entero mas alto usando la funcion math.
     * informa sobre los anteriores estos datos
     * @param totalParticipants numero total de participantes entero > 0
     * @param bussesCapacity capacidad maxima de los buses
     */
    public static void calculateBusses( int totalParticipants, Double bussesCapacity ){
        double totalBusses = Math.ceil(totalParticipants/bussesCapacity);
        System.out.println("Al ser un total de " + totalParticipants + " personas que harán parte de la actividad.");
        System.out.println("se necesitarán un total de: "+ totalBusses +" buses para llevarla a cabo de manera exitosa.\n¡Nos vemos en la COP16!");
    
        
    }
    
    /**
     * Verifica si los nombres y la cedula ingresados son validos e informa si no es asi.
     * @param name
     * @param personalId
     */
    public static boolean register(String name, String personalId){
        if (name == null  || name.isEmpty() || personalId == null || personalId.length() > 15 || personalId.isEmpty()) {
            System.out.println("lo sentimos, no se puede continuar la información del voluntario no es valida. ");
            return false;
        }
        System.out.println("Bienvenido " + name + "!");
        return true;
    }

    /**
     * Decide que infromacion mostrar segun el numero escogido y si no es valido tambien lo informa
     * @param numberOption
     */
    public static boolean option(int numberOption){
        switch (numberOption) {
            case 1: System.out.println("Esta es la información de la Ruta Ladera:\nPunto de encuentro: Bulevar del rio\nHora de inicio: 7am Hora de cierre: 3pm");
                return true;
            case 2: System.out.println("Esta es la información de la  Ruta del Oriente:\nPunto de encuentro: Bulevar del rio \nHora de inicio: 7am Hora de cierre: 1pm");  
                return true;
            case 3: System.out.println("Esta es la información de la Ruta de los Farallones:\nPunto de encuentro: Universidad del valle \nHora de inicio: 6:40am Hora de cierre: 2:30pm");  
                return true;
            default: System.out.println("Lo sentimos el numero de ruta no es valido");
                return false;
        }
    }
    /**
     * Verifica si la cantidad de voluntarios y participantes ingresados son validos e informa si no es asi.
     * @param numberParticipants
     * @param numberVoluntaeers
     */
    public static boolean participants(int numberParticipants, int numberVoluntaeers){
        if (numberParticipants < 1 || numberVoluntaeers < 1) {
            System.out.println("lo sentimos deben existir participantes para desarrollar la actividad");
            return false;
        }
        return true;
    }
    
    /**
     * Evalua si la temperatura y humedad son datos validos y si ambos estan en el rango de ser un buen dia para caminar por cali.
     * @param temperature
     * @param humidity
     */
    public static boolean weatherData(float temperature, float humidity){
        if (humidity < 0 || humidity > 100 ) {
            System.out.println("lo sentimos los datos meteorológicos no son validos");
            return false;      
         }
        
        if (temperature >= 20 && temperature <= 25 && humidity >= 40 && humidity <= 60 ) {
            System.out.println("¡Hace un buen día para caminar por Cali!");
        }
        return true; 
    }

}
