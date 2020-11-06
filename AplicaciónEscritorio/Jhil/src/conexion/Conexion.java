package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
    private String url = "jdbc:mysql://localhost:3306/farmacia";
    private String user = "root";
    private String pass = "";
    private Connection cn;
    public boolean conectar(){
        boolean res = false;
        System.out.println("Conectando…");
        try{
            cn = DriverManager.getConnection(url, user,pass);
            System.out.println("Conectado!!");
            res = true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return res;
    }
    public boolean desconectar(){
        boolean res = false;
        System.out.println("Desconectando…");
        try{
            cn.close();
            System.out.println("Desconectado!!");
            res = true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return res;
    }
    public ResultSet rs(String url){
        ResultSet rs = null;
        try{
            Statement st = cn.createStatement();
            rs = st.executeQuery(url);
            st.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return rs;
    }
    public boolean update(String url){
        boolean res = false;
        try{
            Statement st = cn.createStatement();
            st.executeUpdate(url);
            st.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return res;
    }
}