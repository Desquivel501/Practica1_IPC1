
package practica.pkg1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Derek
 */
public class ReadClass {
 
    public int[][] getArrayA(String path) throws IOException{
        String text = readArray(path);
        String textRows[] = text.split("\n");
        
        int arrayA[][] = new int[3][3];
        
        for (int i = 0; i < textRows.length; i++) {
            String rows[] = textRows[i].split(",");
            arrayA[i][0] = Integer.parseInt(rows[0]);
            arrayA[i][1] = Integer.parseInt(rows[1]);
            arrayA[i][2] = Integer.parseInt(rows[2]);
            
        }
        return arrayA.clone();
    }
    
    public int[][] getArrayB(String path) throws IOException{
        String text = readArray(path);
        String textRows[] = text.split("\n");
        int length = textRows[0].split(",").length;
        
        int arrayB[][] = new int[3][length];
        
        for (int i = 0; i < textRows.length; i++) {
            String rows[] = textRows[i].split(",");
            for (int j = 0; j < length; j++) {
                arrayB[i][j] = Integer.parseInt(rows[j]);  
            }   
        }

        return arrayB.clone();
    }
    
    public int[][] getArrayAtaque(String path) throws IOException{
        String text = readArray(path);
        String textRows[] = text.split("\n");
        int length = textRows.length;
        
        int arrayB[][] = new int[length][3];
        
        for (int i = 0; i < textRows.length; i++) {
            String rows[] = textRows[i].split(",");
            for (int j = 0; j < 3; j++) {
                arrayB[i][j] = Integer.parseInt(rows[j]);  
            }   
        }


        return arrayB.clone();
    }
    
    public String readArray(String path) throws IOException{
        String text = "";
        BufferedReader lector = null;
        
        try{
            File archivo = new File(path);
            lector = new BufferedReader(new FileReader(archivo));
            
            String linea = lector.readLine();
            
            while (linea != null) {
               text += linea + "\n";
               linea = lector.readLine();
            }
        
        }catch(IOException e){
            System.out.println("IOException error");
            e.printStackTrace();
        }catch(Exception e){
            System.out.println("Exception error");
            e.printStackTrace();
        }finally{
            if(lector != null){
                lector.close(); 
            }
        }
      return text;  
    }
    
}
