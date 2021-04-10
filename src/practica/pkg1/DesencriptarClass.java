
package practica.pkg1;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Derek
 */
public class DesencriptarClass {
    
    public static double[][] arrayMsgOriginal;
    public static double[][] arrayMsgDes;
    public static double[][] inversa;
    public static double[][] arrayRes;
    public static double[][] arrayD;

    public String getDecrypted(String msg, String pathA, String pathB) throws IOException{
        ReadClass read = new ReadClass();
        Scanner scan = new Scanner(System.in);
        
        
        int[][] arrayA = read.getArrayA(pathA);
        int[][] arrayB = read.getArrayB(pathB);
 
  
        int msgLength;
        if (msg.length()%3 == 0) {
            msgLength = msg.length()/3;
        }else{
            msgLength = (msg.length()/3)+1;
        }
               
        String[] arrayMsg = msg.split(" ");
        double arrayC[][] = new double[3][arrayMsg.length/3];
        
        //Copia el mansaje de arrayMsg a arrayC
        int k = 0; 
        for (int i = 0; i < (arrayMsg.length/3); i++) {
            for (int j = 0; j < 3; j++) {
                arrayC[j][i] = Double.parseDouble(arrayMsg[k]);
                k++;
            }
        }
        arrayMsgOriginal = arrayC;

        arrayD = new double[3][arrayC[0].length];
        
        //Le resta la arrayB a arrayC
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < arrayC[0].length; j++) {
                arrayD[i][j] = arrayC[i][j] - arrayB[i][j];
                k++;
            }
        } 
        
        inversa = new double[3][3];
        double x00,x01,x02,x10,x11,x12,x20,x21,x22;
        
        //Calcula la determinante
        double det = (arrayA[0][0]*arrayA[1][1]*arrayA[2][2]) + (arrayA[0][1]*arrayA[1][2]*arrayA[2][0]) 
                + (arrayA[1][0]*arrayA[2][1]*arrayA[0][2]) -(arrayA[0][2]*arrayA[1][1]*arrayA[2][0]) - 
                (arrayA[1][0]*arrayA[0][1]*arrayA[2][2]) - (arrayA[1][2]*arrayA[2][1]*arrayA[0][0]);
        
        
        //Opera la inversa por cofactores
        if(det!=0){
            x00=((arrayA[1][1]* arrayA[2][2] - arrayA[2][1]* arrayA[1][2]))/det;
            x01=(-(arrayA[1][0]* arrayA[2][2] - arrayA[2][0]* arrayA[1][2]))/det;
            x02=((arrayA[1][0]* arrayA[2][1] - arrayA[2][0]* arrayA[1][1]))/det;
            x10=(-(arrayA[0][1]* arrayA[2][2] - arrayA[2][1]* arrayA[0][2]))/det;
            x11=((arrayA[0][0]* arrayA[2][2] - arrayA[2][0]* arrayA[0][2]))/det;
            x12=(-(arrayA[0][0]* arrayA[2][1] - arrayA[2][0]* arrayA[0][1]))/det;
            x20=((arrayA[0][1]* arrayA[1][2] - arrayA[1][1]* arrayA[0][2]))/det;
            x21=(-(arrayA[0][0]* arrayA[1][2] - arrayA[1][0]* arrayA[0][2]))/det;
            x22=((arrayA[0][0]* arrayA[1][1] - arrayA[1][0]* arrayA[0][1] ))/det;
            
            //Invierte filas y columnas
            inversa[0][0]=x00;
            inversa[0][1]=x10;
            inversa[0][2]=x20;
            inversa[1][0]=x01;
            inversa[1][1]=x11;
            inversa[1][2]=x21;
            inversa[2][0]=x02;
            inversa[2][1]=x12;
            inversa[2][2]=x22;
        }

        arrayRes = new double[3][arrayC[0].length];
        String[][] arrayStr = new String[3][arrayC[0].length];

        //Multiplica el array inversa por C
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < arrayC[0].length; j++){
                for(int h = 0; h < 3; h++){
                    arrayRes[i][j] += inversa[i][h] * arrayD[h][j];
                    double doubleValue = arrayRes[i][j];

                    int intValue = (int) Math.round(doubleValue);
                   
                    if(intValue >= 0 && intValue<14){
                        intValue = intValue + 65;
                    }else if(intValue == 14){
                        intValue = 65533;
                    }else if(intValue > 14 && intValue != 27){
                        intValue = intValue + 64;
                    }
                    else if(intValue == 27){
                        intValue = 32;
                    }
                    
                    arrayStr[i][j] = Character.toString((char)intValue);
                }
            }
        }
        

        String decryptedMessage = "";
        for (int i = 0; i < (arrayMsg.length/3); i++) {
            for (int j = 0; j < 3; j++) {
                decryptedMessage = decryptedMessage + arrayStr[j][i];
            }
        }
   
        return decryptedMessage;
    }
    
}
