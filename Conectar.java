/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

/**
 *
 * @author chico
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Conectar {
    Connection cn;
    Statement st;
    public Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/escue","root","");
            System.out.println("conectado");
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return cn;
    }
    public static void main(String [] args){
    Conectar c=new Conectar();
    c.conexion();
}
}