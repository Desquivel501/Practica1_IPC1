
package practica.pkg1;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Derek
 */
public class ReporteClass {
    
    void reporteEncriptacion(String pathA, String pathB) throws IOException {
        ReadClass read = new ReadClass();
        Date date = new Date();
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        File file = new File("C:\\reporte\\reporteEn.html");
        
        int[][] arrayMsg = EncriptarClass.arrayMsg;
        int[][] arrayC = EncriptarClass.arrayC;
        int[][] arrayAM = EncriptarClass.multiplicacion;
        
        if(MainClass.encyptedMessage != null){
        
        int [][] arrayA = read.getArrayA(pathA);
        int [][] arrayB = read.getArrayB(pathB);
        String html;
        String css;


        html="<head> <link rel=\"stylesheet\" href=\"style.css\"><head/>\n" +
            "<div id= \"demo\" class=\"boxed\">\n" +
            "<div id=\"titletext\"><h1 style=\"text-align: center;\"><span style=\"text-decoration: underline;\"><strong><span style=\"text-decoration: olid #1C6EA4;\">Reporte Encriptaci&oacute;n</span></strong></span></h1></div>\n" +
            "<p style=\"text-align: center;\"><font size=\"+2\">Fecha: " + fecha.format(date) + " </font></p>\n" +
            "<p style=\"text-align: center;\"><font size=\"+2\">Hora: " + hora.format(date) +" </font></p>\n" +
            "<h2 style=\"text-align: center;\">Mensaje a Encriptar</h2>\n" +
            "<p style=\"text-align: center;\"><font size=\"+2\">"+MainClass.originalMessage+"</font></p>\n" +
            "\n" +
            "<h2 style=\"text-align: center;\">Matriz Mensaje Original</h2>\n" +
            "\n" +
            "<table style=\"height: 138px; width: 400px; border-collapse: collapse; margin-left: auto; margin-right: auto;\" border=\"1\">\n" +
            "<tbody>\n";
        
            double columnasM = arrayB[0].length;
            double porcentajeM = 100/columnasM;
 
            for(int i = 0; i<arrayMsg.length; i++){
                html += "<tr>\n";
                for(int j = 0; j<arrayB[0].length ;j++){       
                    html += "<td style=\"width: " + porcentajeM + "%; text-align: center;\"> "+arrayB[i][j] +"</td>\n";
                }
                html += "</tr>\n";
            }      
            
            html += "</tbody>\n" +
            "</table>\n" +
            "\n" +
            "<h2 style=\"text-align: center;\">Matriz A</h2>\n" +
            "\n" +
            "<table style=\"height: 138px; width: 400px; border-collapse: collapse; margin-left: auto; margin-right: auto;\" border=\"1\">\n" +
            "<tbody>\n";
                
                for(int i = 0; i<arrayA[0].length; i++){
                    html += "<tr>\n" +                
                            "<td style=\"width: 33.3333%; text-align: center;\">" + arrayA[i][0] + "</td>\n" +
                            "<td style=\"width: 33.3333%; text-align: center;\">" + arrayA[i][1] + "</td>\n" +
                            "<td style=\"width: 33.3333%; text-align: center;\">" + arrayA[i][2] + "</td>\n" +
                            "</tr>\n";
                }           

            html +=
            "</tbody>\n" +
            "</table>\n" +
            "\n" +
            "<h2 style=\"text-align: center;\">Matriz B</h2>\n"+
            "\n";
   
            html += "<table style=\"height: 138px; width: 400px; border-collapse: collapse; margin-left: auto; margin-right: auto;\" border=\"1\">\n" +
            "<tbody>\n";
            
            double columnasB = arrayB[0].length;
            double porcentajeB = 100/columnasB;
 
            for(int i = 0; i<arrayB.length; i++){
                html += "<tr>\n";
                for(int j = 0; j<arrayB[0
                        ].length ;j++){       
                    html += "<td style=\"width: " + porcentajeB + "%; text-align: center;\">"+arrayB[i][j] +"</td>\n";
                }
                html += "</tr>\n";
            }     

            html += "</tbody>\n" +
            "</table>\n" +
            "<h2 style=\"text-align: center;\">Matriz A*M</h2>\n" +
            "<table style=\"height: 138px; width: 400px; border-collapse: collapse; margin-left: auto; margin-right: auto;\" border=\"1\">\n" +
            "<tbody>\n";
            
            double columnasAM = arrayAM[0].length;
            double porcentajeAM = 100/columnasAM;
 
            for(int i = 0; i<arrayAM.length; i++){
                html += "<tr>\n";
                for(int j = 0; j<arrayB[0
                        ].length ;j++){       
                    html += "<td style=\"width: " + porcentajeAM + "%; text-align: center;\">"+arrayAM[i][j] +"</td>\n";
                }
                html += "</tr>\n";
            }            

            
            html += "</tbody>\n" +
            "</table>\n" +       
            "<h2 style=\"text-align: center;\">Matriz A*M + B</h2>\n" +
            "<table style=\"height: 138px; width: 400px; border-collapse: collapse; margin-left: auto; margin-right: auto;\" border=\"1\">\n" +
            "<tbody>\n";
            
            double columnasC = arrayC[0].length;
            double porcentajeC = 100/columnasC;
            
             for(int i = 0; i<arrayC.length; i++){
                html += "<tr>\n";
                for(int j = 0; j<arrayC[0].length ;j++){       
                    html += "<td style=\"width: " + porcentajeC +"%; text-align: center;\">"+arrayC[i][j] +"</td>\n";
                }
                html += "</tr>\n"; 
            }   
            
            html += "</tbody>\n" +
            "</table>\n" +
            "<h2 style=\"text-align: center;\">Mensaje Encriptado</h2>\n" +
            "<p style=\"text-align: center;\">" + MainClass.encyptedMessage + "</p>\n" +
            "<h3>&nbsp;</h3>\n" +
            "</div>";
            
            css=".boxed {\n" +
                "  	border-width: 30px;\n" +
                "	border-style: outset;\n" +
                "	border-color: #1C6EA4; ;\n" +
                "} \n" +
                "\n" +
                "body {\n" +
                "font-size: 150%;\n" +
                "}\n" +
                "\n" +
                "background: #D0E4F5 url;\n" +
                "\n" +
                "#demotext {\n" +
                "text-shadow: rgb(0, 230, 230) -5px 5px 0px, rgb(1, 204, 204) -10px 10px 0px, rgb(0, 189, 189) -15px 15px 0px; --darkreader-inline-color:#ffffff; --darkreader-inline-bgcolor:#0059f5; --darkreader-inline-bgimage:none, 2px 2px 2px rgba(206,89,55,0);\n" +
                "}"+ "#demo {\n" +
                "background: #D0E4F5;\n" +
                "}\n" +
                "#demo {\n" +
                "padding: 50px 20px; \n" +
                "}"
                
                    ;

            
//            this.escribirReporte(css, "reporte\\style.css");
//            this.escribirReporte(html, "reporte\\reporte.html");
            this.escribirReporte(css, "C:\\reporte\\style.css");
            this.escribirReporte(html, "C:\\reporte\\reporteEn.html");
            System.out.println("Archivo Generado");
            

            if(!Desktop.isDesktopSupported()){
                System.out.println("No se pudo abrir el archivo automaticamente");
                System.out.println("El archivo esta disponible en: " + file.getAbsolutePath() );
            }
            
            System.out.println("El archivo esta disponible en: " + file.getAbsolutePath());
            Desktop desktop = Desktop.getDesktop();
            if(file.exists()) desktop.open(file);
            
            

        }else{
            System.out.println("No hay datos que reportar");
        }
        
    }
    
    void reporteDesencriptacion(String pathA, String pathB) throws IOException{
        ReadClass read = new ReadClass();

        Date date = new Date();
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        File file = new File("C:\\reporte\\reporteDes.html");
        
        double[][] arrayMsg = DesencriptarClass.arrayMsgOriginal;
        double[][] arrayC = DesencriptarClass.arrayRes;
        double[][] arrayD = DesencriptarClass.arrayD;
        double[][] arrayRes = DesencriptarClass.arrayRes;
        double[][] arrayAI = DesencriptarClass.inversa;
        int [][] arrayA = read.getArrayA(pathA);
        int [][] arrayB = read.getArrayB(pathB);
        String html;
        String css;
        
        html = "<head> <link rel=\"stylesheet\" href=\"style.css\"><head/>\n"+
                "<div id=\"demo\" class=\"boxed\">\n" +
                "<div id=\"titletext\">\n<h1 style=\"text-align: center;\"><span style=\"text-decoration: underline;\"><strong><span style=\"text-decoration: olid #1C6EA4;\">Reporte Desencriptaci&oacute;n</span></strong></span></h1>\n" +
                "<p style=\"text-align: center;\"><font size=\"+2\">Fecha: " + fecha.format(date) + " </font></p>\n" +
                "<p style=\"text-align: center;\"><font size=\"+2\">Hora: " + hora.format(date) +" </font></p>\n" +
                "<h2 style=\"text-align: center;\">Mensaje Encriptado</h2>\n" +
                "<p style=\"text-align: center;\"><font size=\"+2\">" + MainClass.MessageToDecrypt+ "</font></p>\n" +
                "<h2 style=\"text-align: center;\">Matriz Mensaje Encriptado</h2>\n" +
                "<table style=\"height: 138px; width: 338px; border-collapse: collapse; margin-left: auto; margin-right: auto;\" border=\"1\">\n" +
                "<tbody>\n";
                
            double porcentajeM = 100/arrayMsg[0].length;
 
            for(int i = 0; i<arrayMsg.length; i++){
                html += "<tr>\n";
                for(int j = 0; j<arrayMsg[0].length ;j++){
                    html += "<td style=\"width: " + porcentajeM + "%; text-align: center;\"> "+(int)Math.round(arrayMsg[i][j]) +"</td>\n";
                }
                html += "</tr>\n";
            }      

                html +=
                "</tbody>\n" +
                "</table>\n" +
                
                "<h2 style=\"text-align: center;\">Matriz A</h2>\n" +
                "\n" +
                "<table style=\"height: 138px; width: 400px; border-collapse: collapse; margin-left: auto; margin-right: auto;\" border=\"1\">\n" +
                "<tbody>\n";
                
                for(int i = 0; i<arrayA[0].length; i++){
                    html += "<tr>\n" +                
                            "<td style=\"width: 33.3333%; text-align: center;\">" + arrayA[i][0] + "</td>\n" +
                            "<td style=\"width: 33.3333%; text-align: center;\">" + arrayA[i][1] + "</td>\n" +
                            "<td style=\"width: 33.3333%; text-align: center;\">" + arrayA[i][2] + "</td>\n" +
                            "</tr>\n";
                }           

                html +=
                "</tbody>\n" +
                "</table>\n" +
                 
                "<h2 style=\"text-align: center;\">Matriz Inversa de A</h2>\n" +
                "\n" +
                "<table style=\"height: 138px; width: 400px; border-collapse: collapse; margin-left: auto; margin-right: auto;\" border=\"1\">\n" +
                "<tbody>\n";
                
                for(int i = 0; i<arrayAI[0].length; i++){
                    html += "<tr>\n" +                
                            "<td style=\"width: 33.3333%; text-align: center;\">" + arrayAI[i][0] + "</td>\n" +
                            "<td style=\"width: 33.3333%; text-align: center;\">" + arrayAI[i][1] + "</td>\n" +
                            "<td style=\"width: 33.3333%; text-align: center;\">" + arrayAI[i][2] + "</td>\n" +
                            "</tr>\n";
                }           

                html +=
                "</tbody>\n" +
                "</table>\n" +
                 
                "<h2 style=\"text-align: center;\">Matriz B</h2>\n" +
                "\n" +
                "<table style=\"height: 138px; width: 400px; border-collapse: collapse; margin-left: auto; margin-right: auto;\" border=\"1\">\n" +
                "<tbody>\n";
                
                double columnasB = arrayB[0].length;
                double porcentajeB = 100/columnasB;
 
                for(int i = 0; i<arrayB.length; i++){
                    html += "<tr>\n";
                    for(int j = 0; j<arrayB[0
                        ].length ;j++){       
                    html += "<td style=\"width: " + porcentajeB + "%; text-align: center;\">"+arrayB[i][j] +"</td>\n";
                    }
                    html += "</tr>\n";
                }     
                
                html +=
                "</tbody>\n" +
                "</table>\n" +
                        
                "<h2 style=\"text-align: center;\">Matriz M - B</h2>\n" +
                "\n" +
                "<table style=\"height: 138px; width: 400px; border-collapse: collapse; margin-left: auto; margin-right: auto;\" border=\"1\">\n" +
                "<tbody>\n";
                
                double columnasD = arrayD[0].length;
                double porcentajeD = 100/columnasD;
 
                for(int i = 0; i<arrayD.length; i++){
                    html += "<tr>\n";
                    for(int j = 0; j<arrayB[0
                        ].length ;j++){       
                    html += "<td style=\"width: " + porcentajeD + "%; text-align: center;\">"+arrayD[i][j] +"</td>\n";
                    }
                    html += "</tr>\n";
                }     
                
                html +=
                "</tbody>\n" +
                "</table>\n" +

                        
                "<h2 style=\"text-align: center;\">Matriz inversa A*(M-B)</h2>\n" +
                "<table style=\"height: 138px; width: 338px; border-collapse: collapse; margin-left: auto; margin-right: auto;\" border=\"1\">\n" +
                "<tbody>\n";
  
                
                for(int i = 0; i<arrayC.length; i++){
                    html += "<tr>\n";
                    for(int j = 0; j<arrayC[0].length ;j++){
                        html += "<td style=\"width: " + porcentajeD + "%; text-align: center;\"> "+ (int)Math.round(arrayC[i][j]) +"</td>\n";
                    }
                    html += "</tr>\n";
                }   
                
        html += "</tbody>\n" +
                "</table>\n" +
                "<h2 style=\"text-align: center;\">Mensaje Desencriptado</h2>\n" +
                "<p style=\"text-align: center;\">" + MainClass.decryptedMessage +"</p>\n" +
                "<h3>&nbsp;</h3>\n" +
                "</div>\n" +
                "</div>";
        
        css=".boxed {\n" +
                "  	border-width: 30px;\n" +
                "	border-style: outset;\n" +
                "	border-color: #1C6EA4; ;\n" +
                "} \n" +
                "\n" +
                "body {\n" +
                "font-size: 150%;\n" +
                "}\n" +
                "\n" +
                "background: #D0E4F5 url;\n" +
                "\n" +
                "#demotext {\n" +
                "text-shadow: rgb(0, 230, 230) -5px 5px 0px, rgb(1, 204, 204) -10px 10px 0px, rgb(0, 189, 189) -15px 15px 0px; --darkreader-inline-color:#ffffff; --darkreader-inline-bgcolor:#0059f5; --darkreader-inline-bgimage:none, 2px 2px 2px rgba(206,89,55,0);\n" +
                "}"+ 
                "#demo {\n" +
                "background: #D0E4F5;\n" +
                "}\n" +
                "#demo {\n" +
                "padding: 50px 20px; \n" +
                "}";

            
//            this.escribirReporte(css, "reporte\\style.css");
//            this.escribirReporte(html, "reporte\\reporte.html");
            this.escribirReporte(css, "C:\\reporte\\style.css");
            this.escribirReporte(html, "C:\\reporte\\reporteDes.html");
            System.out.println("Archivo Generado");
            

            if(!Desktop.isDesktopSupported()){
                System.out.println("No se pudo abrir el archivo automaticamente");
                System.out.println("El archivo esta disponible en: " + file.getAbsolutePath() );
            }
            
            System.out.println("El archivo esta disponible en: " + file.getAbsolutePath());
            Desktop desktop = Desktop.getDesktop();
            if(file.exists()) desktop.open(file);

        
    }
    
    public void escribirReporte(String texto, String path){
        FileWriter flw = null;
        
        try{
            flw = new FileWriter(path);
            BufferedWriter bfw = new BufferedWriter(flw);
            bfw.write(texto);
            bfw.close();
        }catch(IOException e){
            System.out.println("Error al escribir el archivo");
            e.printStackTrace();
        }finally{
            if(flw != null){
                try{
                    flw.close();
                }catch(IOException e){
                    System.out.println("Error al cerrar el archivo");
                    e.printStackTrace();
                }
            }
        }
    }
    
}
