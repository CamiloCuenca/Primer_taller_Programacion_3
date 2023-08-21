package logica;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
public class Concesionario {
    private static double ganancia_total = 0;
    private static List<Vehiculo> vehiculos = new ArrayList<>();
    private static List<Vehiculo> VehiculosVendidos = new ArrayList<>();
    private static boolean entradaValida = false;


    /**
     * Esta función muestra el menú y ejecuta las acciones correspondientes a cada una de las opciones disponibles.
     */
    public static void Menu (){
        int opcion;
        do {
            String menuMensaje = "Menú:\n" +
                    "1. registrar vehiculo\n" +
                    "2. buscar vehiculo\n" +
                    "3. listar vehiculos disponibles\n" +
                    "4. vender vehiculo\n" +
                    "5. cantidad de vehiculos disponibles\n" +
                    "6. actualizar datos\n" +
                    "7. ventas totales\n" +
                    "8. eliminar vehiculo\n" +
                    "9. salir\n" +
                    "Ingrese la opción:";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menuMensaje));
            switch (opcion) {
                case 1:

                    String tipoVehiculoMensaje = "Selecciona el tipo de vehículo:\n" +
                            "1. Auto\n" +
                            "2. Moto\n" +
                            "3. Camión";
                    int tipo_vehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, tipoVehiculoMensaje));

                    switch (tipo_vehiculo) {
                        case 1:
                            registrarVehiculo(tipo_vehiculo);
                            System.out.println("Auto agregado al listado.");
                            break;
                        case 2:
                            registrarVehiculo(tipo_vehiculo);
                            System.out.println("Moto agregada al listado.");
                            break;
                        case 3:
                            registrarVehiculo(tipo_vehiculo);
                            System.out.println("Camión agregado al listado.");
                            break;
                        default:
                            System.out.println("Tipo de vehículo no válido.");
                    }

                    break;

                case 2:

                    int opcion_buscar=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el metodo de busqueda que desea" +
                            "\n1. Placa" + "\n2. Marca" + "\n3. Referencia" +  "\n4. Modelo" + "\n5. Precio"));

                    switch (opcion_buscar){
                        case 1:
                            String placasBuscar = JOptionPane.showInputDialog("Ingrese la placa a buscar");
                            buscarVehiculoPlaca(vehiculos, placasBuscar);
                            break;
                        case 2:
                            String marca_buscar = JOptionPane.showInputDialog("Ingrese la marca a buscar");
                            System.out.println("Vehiculos de la marca " + marca_buscar);
                            buscarVehiculoMarca(vehiculos, marca_buscar);
                            break;
                        case 3:
                            String modelo_buscar = JOptionPane.showInputDialog("Ingrese el modelo a buscar");
                            System.out.println("Vehiculos de la marca " + modelo_buscar);
                            buscarVehiculoModelo(vehiculos, modelo_buscar);

                            break;
                        case 4:
                            String referencia_buscar = JOptionPane.showInputDialog("Ingrese la referencia a buscar");
                            buscarVehiculoReferencia(vehiculos, referencia_buscar);
                            break;
                        case 5:
                            int precio_buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio a buscar"));
                            buscarVehiculoPrecio(vehiculos,precio_buscar);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Vehículos en la lista :");
                    int opcion_mostrar=Integer.parseInt(JOptionPane.showInputDialog("Ingrese que tipo de Vehiculo quiere ver" +"\n1. Auto" +"\n2. Moto" + "\n3. Camion"));
                    mostrarVehiculos(vehiculos , opcion_mostrar);

                    break;
                case 4:
                    int opcion_vender=Integer.parseInt(JOptionPane.showInputDialog("Ingrese que tipo de Vehiculo quiere vender" +"\n1. Auto" +"\n2. Moto" + "\n3. Camion"));
                    String placasVehiculo = JOptionPane.showInputDialog("Ingrese la placa a buscar para vender el vehiculo");
                    venderVehiculo(vehiculos,placasVehiculo,VehiculosVendidos,opcion_vender);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null , "El total de vehiculos disponibles es: " + vehiculos.size());

                    break;
                case 6:
                    String placa_editar_auto = JOptionPane.showInputDialog("Ingree la placa del auto que quiere editar");
                    editarVehiculo(vehiculos,placa_editar_auto);

                    break;
                case 7:
                    JOptionPane.showMessageDialog(null , "La ventas totales son: "+VehiculosVendidos.size() + "\nLa ganasia total es: " + ganancia_total);
                    break;
                case 8:

                    String placas_eliminar = JOptionPane.showInputDialog("Ingrese la placa a buscar para eliminar el vehiculo ");
                    eliminarVehiculo(vehiculos,placas_eliminar);
                    break;

                case 9:
                    System.out.println("Se cerro el programa :)");;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        } while (opcion != 9);


    }

    /**
     * Esta función registra un vehiculo (Auto, Moto, Camion) , en un ArrayList.
     *
     * @param opcion
     */
    public static void registrarVehiculo(int opcion) {
        String marca = JOptionPane.showInputDialog("Ingrese la marca");
        String placa = JOptionPane.showInputDialog("Ingrese la placa");
        String referencia = JOptionPane.showInputDialog("Ingrese la referencia");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo");
        int num_ruedas =0;

        do {
            try {
                num_ruedas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de ruedas"));
                entradaValida=true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número no una letra");
            }
        }while (!entradaValida);

        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del vehiculo: "));


        if (opcion == 1) {
            entradaValida = false;
            String is_gasolina = JOptionPane.showInputDialog("¿El auto usa gasolina?" + "\n(si , no)");
            boolean gasolina = false;
            if (is_gasolina.toLowerCase().equals("si")) {
                gasolina = true;
            } else if (is_gasolina.toLowerCase().equals("no")) {
                gasolina = false;
            }
            int num_puertas = 0;
            do {
                try {
                    num_puertas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de puertas"));
                    entradaValida = true; // Si no se lanza excepción, la entrada es válida y el bucle se detendrá
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un número válido de puertas.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    // Aquí puedes manejar la excepción de acuerdo a tus necesidades, como mostrar un mensaje de error o realizar otra acción.
                }
            } while (!entradaValida);

            vehiculos.add(new Auto(marca, placa, referencia, modelo, num_ruedas, num_puertas, gasolina, precio));

        } else if (opcion == 2) {
            int cilindraje_moto = 0;
            double tamano_tanque = 0.0;
            entradaValida = false;

            do {
                try {
                    cilindraje_moto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el cilindraje"));
                    tamano_tanque = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el tamaño del tanque"));
                    entradaValida = true; // Si no se lanza excepción, la entrada es válida y el bucle se detendrá
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa valores numéricos válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    // Aquí puedes manejar la excepción de acuerdo a tus necesidades, como mostrar un mensaje de error o realizar otra acción.
                }
            } while (!entradaValida);
            vehiculos.add(new Moto(marca, placa, referencia, modelo, num_ruedas, cilindraje_moto, tamano_tanque, precio));
        } else if (opcion == 3) {
            int cap_carga =0;
            entradaValida = false;
            do {
                try {
                    cap_carga = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de carga"));
                    entradaValida=true;
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Error: Ingresa valores numéricos válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                }
            }while (!entradaValida);


            vehiculos.add(new Camion(marca, placa, referencia, modelo, num_ruedas, cap_carga, precio));

        }


    }

    /**
     * Esta función busca un vehículo en la lista mediante su número de placa.
     *
     * @param lista La lista de vehículos en la que se realizará la búsqueda.
     * @param numPlacas el número de placa del vehículo que se está buscando.

     */
    private static  void buscarVehiculoPlaca(List<Vehiculo> lista, String numPlacas) {
        for (Vehiculo vehiculo : lista) {
            if (vehiculo.getPlaca().equals(numPlacas)) {
                System.out.println("Vehículo encontrado: " + vehiculo.getMarca() + " "+ vehiculo.getModelo() + " "+ vehiculo.getReferencia()+ " "+ vehiculo.getPrecio());

                return;
            }
        }
        System.out.println("Vehículo no encontrado con placas: " + numPlacas);
    }

    /**
     * Esta función busca un vehículo en la lista mediante su marca.
     *
     * @param lista La lista de vehículos en la que se realizará la búsqueda.
     * @param marca La marca del vehículo que se está buscando.
     */
    private static  void buscarVehiculoMarca(List<Vehiculo> lista, String marca) {
        for (Vehiculo vehiculo : lista) {
            if (vehiculo.getMarca().equals(marca)) {
                System.out.println("Vehículo encontrado: " + vehiculo.getMarca() + " "+ vehiculo.getModelo() + " "+ vehiculo.getReferencia()+ " "+ vehiculo.getPrecio());

            }
        }

    }

    /**
     * Esta función busca un vehículo en la lista mediante su modelo.
     *
     * @param lista La lista de vehículos en la que se realizará la búsqueda.
     * @param modelo El modelo del vehículo que se esta buscando.
     */
    private static  void buscarVehiculoModelo(List<Vehiculo> lista, String modelo) {
        for (Vehiculo vehiculo : lista) {
            if (vehiculo.getModelo().equals(modelo)) {
                System.out.println( vehiculo.getMarca() + " "+ vehiculo.getModelo() + " "+ vehiculo.getReferencia()+ " "+ vehiculo.getPrecio());
            }
        }

    }

    /**
     * Esta función busca un vehículo en la lista mediante su referencia.
     *
     * @param lista La lista de vehículos en la que se realizará la búsqueda.
     * @param referencia La referencia del vehículo que se esta buscando.
     *
     */
    private static void buscarVehiculoReferencia(List<Vehiculo> lista, String referencia) {
        for (Vehiculo vehiculo : lista) {
            if (vehiculo.getReferencia().equals(referencia)) {
                System.out.println("Vehículo encontrado: " + vehiculo.getMarca() + " "+ vehiculo.getModelo() + " "+ vehiculo.getReferencia()+ " "+ vehiculo.getPrecio());

                return;
            }
        }
        System.out.println("Vehículo no encontrado " + referencia);
    }

    /**
     * Esta función busca un vehículo en la lista mediante su precio.
     *
     * @param lista La lista de vehículos en la que se realizará la búsqueda.
     * @param precio EL precio del vehículo que se esta buscando.
     *
     */
    private static  void buscarVehiculoPrecio(List<Vehiculo> lista, double precio) {
        for (Vehiculo vehiculo : lista) {
            if (vehiculo.getPrecio()==precio) {
                System.out.println(vehiculo.getMarca() + " "+ vehiculo.getModelo() + " "+ vehiculo.getReferencia()+ " "+ vehiculo.getPrecio());
            }
        }
    }

    /**
     * Esta función realiza la venta de un vehículo, identificándolo a través de su número de placa.
     *
     * @param lista La lista de vehículos en la que se realizará la búsqueda y venta.
     * @param num_placa El número de placa del vehículo que se va a vender.
     * @param listaVendidos La lista donde se registrarán los vehículos vendidos.
     */
    private static  void venderVehiculo(List<Vehiculo> lista , String num_placa,List<Vehiculo> listaVendidos ,int opcion){

        for(Vehiculo vehiculo:lista) {

            switch (opcion){
                case 1:
                    if(vehiculo instanceof Auto){
                        if (vehiculo.getPlaca().equals(num_placa)) {
                            listaVendidos.add(vehiculo);
                            lista.remove(vehiculo);
                            ganancia_total+=vehiculo.getPrecio();
                            double precio_pagar = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de: " + vehiculo.getPrecio()));
                            System.out.println("¡Vehiculo Vendido con exito!");


                        }else {
                            System.out.println("Vehículo no encontrado con placas: " + num_placa);
                        }
                    }
                    break;
                case 2:
                    if(vehiculo instanceof Moto){
                        if (vehiculo.getPlaca().equals(num_placa)) {
                            listaVendidos.add(vehiculo);
                            lista.remove(vehiculo);
                            ganancia_total+=vehiculo.getPrecio();
                            double precio_pagar = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de: " + vehiculo.getPrecio()));
                            System.out.println("¡Vehiculo Vendido con exito!");

                        }else {
                            System.out.println("Vehículo no encontrado con placas: " + num_placa);
                        }
                    }
                    break;
                case 3:
                    if(vehiculo instanceof Camion){
                        if (vehiculo.getPlaca().equals(num_placa)) {
                            listaVendidos.add(vehiculo);
                            lista.remove(vehiculo);
                            ganancia_total+=vehiculo.getPrecio();
                            double precio_pagar = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de: " + vehiculo.getPrecio()));
                            System.out.println("¡Vehiculo Vendido con exito!");

                        }else {
                            System.out.println("Vehículo no encontrado con placas: " + num_placa);
                        }
                    }
                    break;
            }

        }
    }
    
    /**
     * Esta función permite la modificación de los atributos de un vehiculo, identificándolo mediante su número de placa.
     * 
     * @param lista La lista de vehículos en la que se realizará la búsqueda y posterior edición del vehículo.
     * @param num_placa El número de placa del vehículo que se va a modificar.
     */
    private static   void editarVehiculo (List<Vehiculo> lista , String num_placa){

        for(Vehiculo vehiculo :lista){
            if(vehiculo.getPlaca().equals(num_placa)){

                 String marca = JOptionPane.showInputDialog("Ingrese la marca",vehiculo.getMarca());
                 String placa =  JOptionPane.showInputDialog("Ingrese la placa", vehiculo.getPlaca());
                 String referencia =  JOptionPane.showInputDialog("Ingrese la referencia" , vehiculo.getReferencia());
                 String modelo =  JOptionPane.showInputDialog("Ingrese el modelo" , vehiculo.getModelo());
                int num_ruedas =0;

                do {
                    try {
                        num_ruedas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de ruedas" , vehiculo.getNum_ruedas()));
                        entradaValida=true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Ingrese un número no una letra");
                    }
                }while (!entradaValida);
                 double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio",vehiculo.getPrecio()));

                 if(vehiculo instanceof Auto){
                    Auto auto = (Auto) vehiculo;
                     int num_puertas = 0;
                     entradaValida = false;
                     do {
                         try {
                             num_puertas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de puertas", ((Auto) vehiculo).getNum_puertas()));
                             entradaValida = true; // Si no se lanza excepción, la entrada es válida y el bucle se detendrá
                         } catch (NumberFormatException e) {
                             JOptionPane.showMessageDialog(null, "Error: Ingresa un número válido de puertas.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                             // Aquí puedes manejar la excepción de acuerdo a tus necesidades, como mostrar un mensaje de error o realizar otra acción.
                         }
                     } while (!entradaValida);

                     String aux ;
                     if(((Auto) vehiculo).getIs_gasolina()){
                         aux = "si";
                     }else {
                         aux="no";
                     }


                     String is_gasolina = JOptionPane.showInputDialog("¿El auto usa gasolina?" +"\n(si , no)", aux);
                     boolean gasolina = false;
                     if(is_gasolina.toLowerCase().equals("si")){
                         gasolina = true;
                     }else if (is_gasolina.toLowerCase().equals("no")){
                         gasolina= false;
                     }
                     ((Auto) vehiculo).setIs_gasolina(gasolina);
                     ((Auto) vehiculo).setNum_puertas(num_puertas);

                 } else if (vehiculo instanceof Moto) {
                    Moto moto = (Moto) vehiculo;
                     int cilindraje = 0;
                     double tamano_tanque = 0.0;
                     entradaValida = false;
                     do {
                         try {
                             cilindraje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el cilindraje",((Moto) vehiculo).getCilindraje()));
                             tamano_tanque = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el tamaño del tanque", ((Moto) vehiculo).getTamano_tanque()));
                             entradaValida = true; // Si no se lanza excepción, la entrada es válida y el bucle se detendrá
                         } catch (NumberFormatException e) {
                             JOptionPane.showMessageDialog(null, "Error: Ingresa valores numéricos válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                             // Aquí puedes manejar la excepción de acuerdo a tus necesidades, como mostrar un mensaje de error o realizar otra acción.
                         }
                     } while (!entradaValida);


                    ((Moto) vehiculo).setCilindraje(cilindraje);
                    ((Moto) vehiculo).setTamano_tanque(tamano_tanque);
                 } else if (vehiculo instanceof Camion) {
                     Camion camion = (Camion) vehiculo;
                     int cap_carga =0;
                     entradaValida = false;
                     do {
                         try {
                             cap_carga = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de carga", ((Camion) vehiculo).getCap_carga()));
                             entradaValida=true;
                         }catch (NumberFormatException e){
                             JOptionPane.showMessageDialog(null, "Error: Ingresa valores numéricos válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                         }
                     }while (!entradaValida);


                     ((Camion) vehiculo).setCap_carga(cap_carga);
                 }

                 vehiculo.setMarca(marca);
                 vehiculo.setPlaca(placa);
                 vehiculo.setReferencia(referencia);
                 vehiculo.setModelo(modelo);
                 vehiculo.setNum_ruedas(num_ruedas);
                 vehiculo.setPrecio(precio);

                 JOptionPane.showMessageDialog(null , "¡La edicion se completo con exito!");

            }
        }
    }
    

    /**
     * Esta función realiza la eliminacion de un vehiculo, identificandolo mediante su número de placa
     * 
     * @param lista La lista de vehículos en la que se realizará la búsqueda y posterior eliminación del vehículo.
     * @param num_placas El número de placa del vehiculo  que se va a eliminar.
     */
    private static void  eliminarVehiculo (List<Vehiculo> lista , String num_placas){
        for(Vehiculo vehiculo:lista) {
            if (vehiculo.getPlaca().equals(num_placas)) {
                lista.remove(vehiculo);

                System.out.println("¡Vehiculo eliminado con exito!");
                return;
            }
            System.out.println("Vehículo no encontrado con placas: " + num_placas);

        }
    }

    /** 
     * Esta función realiza la accion de mostar todos los vehiculo disponibles .
     * 
     * @param lista La lista de vehículo.
     */
    
    private static void mostrarVehiculos(List<Vehiculo> lista , int opcion) {
        for (Vehiculo vehiculo : lista){
            switch (opcion){
                case 1:
                    if(vehiculo instanceof Auto){
                        System.out.println("Auto: "+vehiculo.toString());
                    }
                    break;
                case 2:
                    if (vehiculo instanceof Moto) {
                        System.out.println("Moto: " +vehiculo.toString());
                    }
                    break;
                case 3:
                    if (vehiculo instanceof Camion) {
                        System.out.println("Camion: " +vehiculo.toString());
                    }
                    break;
            }

        }
    }
}