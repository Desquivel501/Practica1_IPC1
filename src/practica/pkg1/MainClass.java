
package practica.pkg1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Derek
 */
public class MainClass {
    
    public static String originalMessage = "";
    public static String decryptedMessage = null;
    public static String encyptedMessage = null;
    public static String MessageToDecrypt = "";
    public static String pathA = "";
    public static String pathB = "";
    public static String pathAEn= "";
    public static String pathBEn= "";
    
    public static boolean firstRun = false;

 
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
//        scan.useDelimiter(System.lineSeparator());
        EncriptarClass encriptar = new EncriptarClass();
        DesencriptarClass desencriptar = new DesencriptarClass();
        AtaqueClass ataque = new AtaqueClass();
        ReporteClass reporte = new ReporteClass();
        boolean run = true;

        while(run == true){
            System.out.println("=================MENU=================");
            System.out.println("| 1. ENCRIPTAR                       |");
            System.out.println("| 2. DESENCRIPTAR                    |");
            System.out.println("| 3. ATAQUE CON TEXTO CLARO          |");
            System.out.println("| 4. GENERAR REPORTE                 |");
            System.out.println("| 5. SALIR                           |");
            System.out.println("======================================");
            int menu = scan.nextInt();
            scan.nextLine();
            boolean cont = true;

            switch(menu) {
                case 1: 
                    System.out.println("Ingrese mensaje a encriptar");
                    String msg = scan.nextLine().toUpperCase();
//                    msg = scan.nextLine().toUpperCase();
                    originalMessage = msg;
                    
                    System.out.println("Ingrese la ruta de la matriz A");
                    pathA = scan.nextLine();
                    File fileA = new File(pathA);
                    
                    System.out.println("Ingrese la ruta de la matriz B");
                    pathB = scan.nextLine();
                    File fileB = new File(pathB);
                    System.out.println("");
                    
                    if(fileA.isFile() && fileB.isFile()){
                        encyptedMessage = encriptar.getEncypted(msg, pathA, pathB);
                        System.out.println("El mensaje encriptado es:");
                        System.out.println(encyptedMessage);
                        System.out.println(); 
                    }else if(fileA.isFile() || fileB.isFile()){
                        System.out.println("Una de las rutas no es valida");
                        System.out.println("");
                    }else{
                        System.out.println("Las rutas ingresadas no son validas");
                        System.out.println("");
                    }
                   
                    while (cont==true) {
                        System.out.println("¿Desea realizar otra operacion? Y/N");
                        //scan.nextLine();
                        String continuar = scan.nextLine().toUpperCase();
                        firstRun = true;
                    
                        switch (continuar) {
                            case "Y":
                                run = true;
                                cont = false;
                                System.out.println(); 
                                break;  
                            case "N":
                                run = false;
                                cont = false;
                                System.out.println("¡Hasta Pronto!");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                System.out.println("");
                        }
                    }
                    scan.reset();
                    break;

                case 2:
                    System.out.println("Ingrese mensaje encriptado");
                    String msgEn = scan.nextLine();
//                    msgEn = scan.nextLine();
                    MessageToDecrypt = msgEn;
                    
                    System.out.println("Ingrese la ruta de la matriz A");
                    pathAEn = scan.nextLine();
                    File fileAEn = new File(pathAEn);
                    
                    System.out.println("Ingrese la ruta de la matriz B");
                    pathBEn = scan.nextLine();
                    File fileBEn = new File(pathBEn);
                    System.out.println("");
                    
                    
                    if(fileAEn.isFile() && fileBEn.isFile()){
                    decryptedMessage = desencriptar.getDecrypted(msgEn, pathAEn, pathBEn);
                    System.out.println("Mensaje decifrado es:"); 
                    System.out.println(decryptedMessage);
                    System.out.println();
                    }else if(fileAEn.isFile() || fileBEn.isFile()){
                        System.out.println("Una de las rutas no es valida");
                        System.out.println("");
                    }else{
                        System.out.println("Las rutas ingresadas no son validas");
                        System.out.println("");
                    } 
                    
                    while (cont==true) {
                        System.out.println("¿Desea realizar otra operacion? Y/N");
                        String continuar1 = scan.nextLine().toUpperCase();
//                        continuar1 = scan.nextLine().toUpperCase();
                        firstRun = true;
                    
                        switch (continuar1) {
                            case "Y":
                                run = true;
                                cont = false;
                                System.out.println(); 
                                break;  
                            case "N":
                                run = false;
                                cont = false;
                                System.out.println("¡Hasta Pronto!");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                System.out.println("");
                        }
                    }
                    scan.reset();
                    break;

                case 3:
                    System.out.println("Ingrese matriz del mensaje original");
                    String msgOg = scan.nextLine();
                    
                    System.out.println("Ingrese matriz del mensaje encriptado");
                    String msgEnAt = scan.nextLine();
                    
                    ataque.atacar(msgOg, msgEnAt);

     
                    
                    while (cont==true) {
                        System.out.println("¿Desea realizar otra operacion? Y/N");
                        String continuar = scan.nextLine().toUpperCase();
//                        continuar = scan.nextLine().toUpperCase();
                    
                        switch (continuar) {
                            case "Y":
                                run = true;
                                cont = false;
                                System.out.println(); 
                                break;  
                            case "N":
                                run = false;
                                cont = false;
                                System.out.println("¡Hasta Pronto!");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                System.out.println("");
                        }
                    }
                    scan.reset();
                    break;

                case 4:

                    System.out.println("=================MENU=================");
                    System.out.println("| 1. REPORTE ENCRIPTACION            |");
                    System.out.println("| 2. REPORTE DESENCRIPTACION         |");
                    System.out.println("| 3. REPORTE ATAQUE                  |");
                    System.out.println("| 4. SALIR                           |");
                    System.out.println("======================================");
                    int menuReporte = scan.nextInt();
                    
                    switch (menuReporte) {
                        case 1:
                            if(encyptedMessage == null){
                                System.out.println("No existen datos disponibles para realizar el reporte");
                            }else{
                                
                                reporte.reporteEncriptacion(pathA, pathB);
                            }

                            break;
                        case 2:
                            if(decryptedMessage != null){
                                 reporte.reporteDesencriptacion(pathAEn, pathBEn);
                            }else{
                                System.out.println("No existen datos disponibles para realizar el reporte");
                            }
                            
                            break;
                        case 3:
                            System.out.println("Opcion no disponible");
                            break;
                            
                        case 4:
                            run=false;
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }

                    System.out.println("");
                    
                    while (cont==true) {
                        System.out.println("¿Desea realizar otra operacion? Y/N");
                        String continuar = scan.nextLine().toUpperCase();
                        continuar = scan.nextLine().toUpperCase();
                    
                        switch (continuar) {
                            case "Y":
                                run = true;
                                cont = false;
                                System.out.println(); 
                                break;  
                            case "N":
                                run = false;
                                cont = false;
                                System.out.println("¡Hasta Pronto!");
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                System.out.println("");
                        }
                    }
                    scan.reset();
     
                    break;
                    
                case 5:
                    run = false;
                    break;
                    
                default:
                    System.out.println("Opcion no valida");

            }


        }
    }
}
