/*
Vista Principal del administrador de farmacia
 */
package regprod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Adhemar
 */
public class WindowWarehouseManager extends JFrame implements ActionListener{
    JButton registrar=new JButton("Registrar Medicamento");
    public WindowWarehouseManager()
    {
        this.setLayout(null);
        this.setTitle("Administrador de Almacen");
        this.setSize(1200, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        registrar.setBounds(50, 80, 180, 40);
        registrar.addActionListener(this);
        add(registrar);
        
        this.setVisible(true);
    }
    
    //Abrir el formulario de registro de medicamentos
    public void openF()
    {
        new Formulario();
    }
    
        public static void main(String[] args) {
        new WindowWarehouseManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==registrar)
        {
            openF();
        }
    }
}
