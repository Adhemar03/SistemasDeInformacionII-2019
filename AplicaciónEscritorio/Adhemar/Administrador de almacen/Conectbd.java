
package interfaz;

import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;


public class Conectbd {
    
    public static final String url="jdbc:mysql://localhost:3306/basededatos_farmacia";
    public static final String username="root";
    public static final String password="12345";
        static PreparedStatement ps;
        static ResultSet res;
    static Connection con=null;
    public static Connection conectar()
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection(url, username, password);
        //JOptionPane.showMessageDialog(null,"coneccion exitosa");
        } catch(Exception e){
        System.out.println(e);
        }
        return con;
    }
    public static void guardar(String nombre,String codsen, String prees,String precio,String preciov,String dosis){
        
        try{
        ps=(PreparedStatement) con.prepareStatement("INSERT INTO medicamento(NOMBREMedicamento,CODIGOSENASAG,PREESCRIPCION,PRECIO,PRECIODEVenta,DOSIS) VALUES(?,?,?,?,?,?)");
        ps.setString(1, nombre);
        ps.setString(2, codsen);
        ps.setString(3, prees);
        ps.setString(4, precio);
        ps.setString(5, preciov);
        ps.setString(6, dosis);
        int res=ps.executeUpdate();
        if(res>0){
            JOptionPane.showMessageDialog(null, "Medicamento registrado ");
        }
        } catch(Exception e){
            System.out.println(e);
        }
    }
    public static void verif(String nombre,String codsen, String prees,String precio,String preciov,String dosis)
    {
        Connection con=conectar();
        try{
            ps=(PreparedStatement) con.prepareStatement("SELECT NOMBREMedicamento FROM medicamento WHERE NOMBREMedicamento=?");
            ps.setString(1,nombre);
            res=ps.executeQuery();
            if(res.next())
            {
                JOptionPane.showMessageDialog(null,"Ya existe el Medicamento");
            }else{
                guardar(nombre, codsen, prees,precio, preciov, dosis);
            }
        } catch(Exception e){
        System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        Conectbd s=new Conectbd();
        s.conectar();
    }
}
