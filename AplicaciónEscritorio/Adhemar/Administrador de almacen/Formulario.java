
package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Formulario extends JFrame implements ActionListener{
    JButton Guardar=new JButton("Guardar Medicamento");
    JButton cancelar=new JButton("Cancelar");
        JTextField nombre=new JTextField("");
        JTextField codsen=new JTextField("");
        JComboBox pr=new JComboBox();
        JTextField precio=new JTextField("");
        JTextField precioVenta=new JTextField("");
        JTextField dosis=new JTextField("");
        
    public Formulario()
    {
        this.setLayout(null);
        this.setTitle("Registrar Medicamentos");
        this.setSize(500, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        crearFormulario();
        this.setVisible(true);
    }
    public void validar()
    {
        String nom=nombre.getText().trim();
        String codS=codsen.getText().trim();
        String preci=precio.getText().trim();
        String preV=precioVenta.getText().trim();
        String dos=dosis.getText().trim();
        
        if(nom.isEmpty()|| codS.isEmpty()|| preci.isEmpty()|| preV.isEmpty()|| dos.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Para continuar con el Registro LLene los campos solicitados");
        }
        else
        {
            if(!validarPrecio(preci))
            {
                JOptionPane.showMessageDialog(null, "Precio NO admitido");
            }
            else
            {
                if(!validarPrecio(preV))
                {
                    JOptionPane.showMessageDialog(null, "Precio de Venta NO admitido");
                }
                else
                {
                    if(!validarDosis(dos))
                    {
                        JOptionPane.showMessageDialog(null, "Valor de Dosis NO admitido");
                    }
                    else
                    {
                        registrar();
                        
                    }
                }
            }
        }
    }
    
    public void registrar()
    {
        String seleccionado=(String)pr.getSelectedItem();
        if(seleccionado=="SI")
        {
            Conectbd.verif(nombre.getText(), codsen.getText(), "1", precio.getText(), precioVenta.getText(), dosis.getText());
        }
        else
        {
            if(seleccionado=="NO")
            {
                Conectbd.verif(nombre.getText(), codsen.getText(), "0", precio.getText(), precioVenta.getText(), dosis.getText());
            }
        }
        
    }
    
    public void crearFormulario()
    {
        JLabel nom=new JLabel("Nombre :");
        JLabel mar=new JLabel("Código senasag :");
        JLabel ti=new JLabel("Preescripcion :");
        JLabel prec=new JLabel("Precio :");
        JLabel precioV=new JLabel("Precio de venta :");
        JLabel dosi=new JLabel("Dosis :");
        
        
        
        nom.setBounds(30, 40, 100, 30);
        add(nom);
        mar.setBounds(30, 90, 100, 30);
        add(mar);
        ti.setBounds(30, 140, 100, 30);
        add(ti);
        prec.setBounds(30, 190, 100, 30);
        add(prec);
        precioV.setBounds(30, 240, 130, 30);
        add(precioV);
        dosi.setBounds(30, 290, 120, 30);
        add(dosi);
        
        nombre.setBounds(180, 40, 150, 30);
        add(nombre);
        codsen.setBounds(180, 90, 150, 30);
        add(codsen);
        pr.setBounds(180, 140, 150, 30);
        add(pr);
        pr.addItem("SI");
        pr.addItem("NO");
        //pre.setBounds(180, 140, 150, 30);
        //add(pre);
        precio.setBounds(180, 190, 150, 30);
        add(precio);
        precioVenta.setBounds(180, 240, 150, 30);
        add(precioVenta);
        dosis.setBounds(180, 290, 150, 30);
        add(dosis);
        
        
        Guardar.setBounds(30, 400, 180, 30);
        Guardar.addActionListener(this);
        add(Guardar);
        cancelar.setBounds(250, 400, 110, 30);
        cancelar.addActionListener(this);
        add(cancelar);
    }
    

    public boolean validarDosis(String valor) 
    {
        try 
        { 
            Integer.parseInt(valor); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        return true;
    }
    public boolean validarPrecio(String valor) 
    {
        try 
        { 
            float flotante = Float.parseFloat(valor); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        return true;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Guardar)
        {
            validar();
            nombre.setText("");
            codsen.setText("");
            precio.setText("");
            precioVenta.setText("");
            dosis.setText("");
            
        }
        if(e.getSource()==cancelar)
        {
            dispose();
        }
    }
    
    public static void main(String[] args) {
        new Formulario();
    }
    
    
}
