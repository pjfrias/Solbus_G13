
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexionDB {
    
   private static final String DRIVER = "org.mariadb.jdbc.Driver";
   private static final String URL = "jdbc:mariadb://localhost:3306/solbusg13";
   private static final String USUARIO = "root";
   private static final String PASSWORD = "";
   
   private static Connection conexion;
   
   private ConexionDB(){};
   
   public static Connection getConexion(){
       
       if(conexion == null){
       
           try{
               Class.forName(DRIVER);
               conexion = DriverManager.getConnection(URL,USUARIO,PASSWORD);
               
            }catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null,"Error al cargar el driver de conexion");
            }catch(SQLException e){
               switch(e.getErrorCode()){
                   case 1049:
                       JOptionPane.showMessageDialog(null,"Base de datos desconocida");
                       break;
                   default:
                       JOptionPane.showMessageDialog(null,"Error de conexion");
                       break;
                }
           }
       }
       
       return conexion;
   }
}
