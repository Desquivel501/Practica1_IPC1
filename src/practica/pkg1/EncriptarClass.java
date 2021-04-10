
package practica.pkg1;

import java.io.IOException;

/*
 * @author Derek
 */
public class EncriptarClass {
    public int[] arrayAscii;
    public static int[][] arrayMsg;
    public static int[][] arrayC;
    public static int[][] multiplicacion;
    
    public String getEncypted(String msg, String pathA, String pathB ) throws IOException{
        
        ReadClass read = new ReadClass();
        
        int[][] arrayA = read.getArrayA(pathA);
        int[][] arrayB = read.getArrayB(pathB);
  
        //Revisa si el mensaje opcupara todas las columnas, si no agrega una columnaextra
        int msgLength;
        if (msg.length()%3 == 0) {
            msgLength = msg.length()/3;
        }else{
            msgLength = (msg.length()/3)+1;
        }
        
        arrayAscii = new int[msg.length()];
        arrayMsg = new int[3][msgLength];
        arrayC = new int[3][arrayMsg[0].length];
        multiplicacion = new int[3][arrayMsg[0].length];
        
        //obtiene el valor ASCII de cada letra
        for (int i = 0; i < msg.length(); i++) {
            char a = msg.charAt(i);
            int ascii = (int) a;
          
            //Asigna un valor de 0-27 a cada letra segun su codifo ASCII
            if(ascii>64 && ascii<79){
                ascii = ascii-65;
                arrayAscii[i] = ascii;
            }else if(ascii>=79 && ascii<=90){
                ascii = ascii -64;
                arrayAscii[i] = ascii;
            }else if(ascii == 65533){
                arrayAscii[i] = 14;
            }else{
                arrayAscii[i] = 27;
            }
        }   
        
        //Añade la matriz con numeros traducidos a un array de 3xn, popolnado primero las columnas
        //Tambien llena espacios en blanco en casos donde el mansaje no opupe toda la columna
        int k = 0; //counter for arrayAscii
        switch (msg.length() %3) {
            case 0:
                for (int i = 0; i < (msg.length()/3); i++) {
                    for (int j = 0; j < 3; j++) {
                        arrayMsg[j][i] = arrayAscii[k];
                        k++;
                    }
                }   break;
            case 1:
                for (int i = 0; i < (msg.length()/3); i++) {
                    for (int j = 0; j < 3; j++) {
                        arrayMsg[j][i] = arrayAscii[k];
                        k++;
                    }
                }   
                arrayMsg[0][(msg.length()/3)] = arrayAscii[k]; 
                arrayMsg[1][(msg.length()/3)] = 27; 
                arrayMsg[2][(msg.length()/3)] = 27;
                break;
            case 2:
                for (int i = 0; i < (msg.length()/3); i++) {
                    for (int j = 0; j < 3; j++) {
                        arrayMsg[j][i] = arrayAscii[k];
                        k++;
                    }
                }   
                arrayMsg[0][(msg.length()/3)] = arrayAscii[k];
                arrayMsg[1][(msg.length()/3)] = arrayAscii[k+1];
                arrayMsg[2][(msg.length()/3)] = 27;
                break;
            default:
                break;
        }

        
        
        //Multiplica la matriz A con la matriz del mensaje (A*M)
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < arrayMsg[0].length; j++){
                for(int h = 0; h < 3; h++){
                    arrayC[i][j] += arrayA[i][h] * arrayMsg[h][j];
                    multiplicacion[i][j] += arrayA[i][h] * arrayMsg[h][j];
                }
            }
        }
        

        //Suma el resultado de la multiplicacion con la matriz B ((A*M)+B)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < arrayC[0].length; j++) {
                arrayC[i][j] = arrayC[i][j] + arrayB[i][j];
                k++;
            }
        }
        
        
        String encryptedMessage = "";
        for (int i = 0; i < arrayC[0].length; i++) {
            for (int j = 0; j < 3; j++) {
                encryptedMessage = encryptedMessage + arrayC[j][i] + " ";
            }
        } 
        
        return encryptedMessage;

    }   
}
