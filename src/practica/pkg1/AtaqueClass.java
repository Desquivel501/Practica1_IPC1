
package practica.pkg1;

import java.io.IOException;

/**
 *
 * @author Derek
 */
public class AtaqueClass {
    void atacar(String pathMsg, String pathEn) throws IOException{
        ReadClass read = new ReadClass();
 
        int[][] arrayMsgInt = read.getArrayAtaque(pathMsg);
        int[][] arrayEnInt = read.getArrayAtaque(pathEn);
        
        double arrayMsg[][] = new double[arrayMsgInt.length][arrayMsgInt[0].length];
        double arrayEn[][] = new double[arrayEnInt.length][arrayEnInt[0].length];
        
        
        for (int i = 0; i < arrayMsg.length; i++) {
            for (int j = 0; j < arrayMsgInt[0].length; j++) {
                arrayMsg[i][j] = arrayMsgInt[i][j];
            }
        }
        for (int i = 0; i < arrayEn.length; i++) {
            for (int j = 0; j < arrayEnInt[0].length; j++) {
                arrayEn[i][j] = arrayEnInt[i][j];
            }
        }
        
        int pivoteLinea = 0;
        int pivoteColumna  = 0;
        
        for (int i = 0; i < 3; i++) {
            
            if(arrayMsg[pivoteLinea][pivoteColumna]%3==0){
                
                while (arrayMsg[pivoteLinea][pivoteColumna]%3==0) {
                    for (int j = 0; j < 3; j++) {
                    arrayMsg[pivoteLinea][j] = 0;
                    arrayEn[pivoteLinea][j] = 0;
                }
                pivoteLinea++;
                }
                
            }
            
            int a = (int)arrayMsg[pivoteLinea][pivoteColumna];
            int x = 0; //inverso multipicativo
            int res;

            do {
                x++;
                res = (x*a)%27;
            } while (res != 1); 
        
            for (int j = 0; j < 3; j++){  
                
                arrayMsg[pivoteLinea][j] = (arrayMsg[pivoteLinea][j] * x)%27;
                arrayEn[pivoteLinea][j] = (arrayEn[pivoteLinea][j] * x)%27;
                
            }
            
            switch (i) {
                case 0:
                    for (int j = pivoteLinea+1; j < arrayMsg.length; j++) {
                        int c = (int)arrayMsg[j][0];
                        int d = (int)arrayEn[j][0];
                        arrayMsg[j][0] = arrayMsg[j][0] - c*arrayMsg[pivoteLinea][0];
                        arrayEn[j][0] = arrayEn[j][0] - d*arrayEn[pivoteLinea][0];
                    }
                    break;
                    
                case 1:
                    for (int j = pivoteLinea+1; j < arrayMsg.length; j++) {
                        int c = (int)arrayMsg[j][1];
                        int d = (int)arrayEn[j][1];
                        arrayMsg[j][1] = arrayMsg[j][1] - c*arrayMsg[pivoteLinea][1];
                        arrayEn[j][1] = arrayEn[j][1] - d*arrayEn[pivoteLinea][1];
                    }
                    for (int j = pivoteLinea-1; j >= 0; j--) {
                        int c = (int)arrayMsg[j][1];
                        int d = (int)arrayEn[j][1];
                        arrayMsg[j][1] = arrayMsg[j][1] - c*arrayMsg[pivoteLinea][1];
                        arrayEn[j][1] = arrayEn[j][1] - d*arrayEn[pivoteLinea][1];
                    }
                    break;
                    
                case 2:
                    for (int j = pivoteLinea+1; j < arrayMsg.length; j++) {
                        int c = (int)arrayMsg[j][2];
                        int d = (int)arrayEn[j][2];
                        arrayMsg[j][2] = arrayMsg[j][2] - c*arrayMsg[pivoteLinea][2];
                        arrayEn[j][2] = arrayEn[j][2] - d*arrayEn[pivoteLinea][2];
                    }
                    for (int j = pivoteLinea-1; j >= 0; j--) {
                        int c = (int)arrayMsg[j][2];
                        int d = (int)arrayEn[j][2];
                        arrayMsg[j][2] = arrayMsg[j][2] - c*arrayMsg[pivoteLinea][2];
                        arrayEn[j][2] = arrayEn[j][2] - d*arrayEn[pivoteLinea][2];
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            

           pivoteLinea++;
           pivoteColumna++;
        }

        
        for (double[] x : arrayMsg){
            for (double y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
        
        System.out.println("");
        
        for (double[] x : arrayEn){
            for (double y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
        
        System.out.println("");

    }
}
