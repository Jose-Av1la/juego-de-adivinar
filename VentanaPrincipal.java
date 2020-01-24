
package game;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame {

    JPanel p = new JPanel();
    JLabel l = new JLabel("Juguemos.... Escoge lo que vamos adivinar");
    JButton b = new JButton("Chequear");
    JTextField t = new JTextField(15);
    VentanaResultado q;
    JComboBox cb;

    public VentanaPrincipal() {
        super("Inicio");
        setLocation(200, 200);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        agregarComponentes();
        pack();
    }

    public void agregarComponentes() {
        getContentPane().add(p);
        p.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.gridx = 0;
        g.gridy = 0;
        g.insets = new Insets(10, 10, 10, 10);
        p.add(l, g);
        g.gridy = 1;
        p.add(t, g);
        Vector v = new Vector(4);
        v.addElement("Numero de la semana");
        v.addElement("Dia del año");
        v.addElement("Mes del año");
        cb = new JComboBox(v);
        g.gridx = 1;
        p.add(cb, g);
        g.gridy = 2;
        g.gridx = 0;
        p.add(b, g);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!t.getText().isEmpty()) {
//                    chequear();
                    cbActionLister();
                } else {
                    JOptionPane.showMessageDialog(null, "Inserte texto para empezar a jugar");
                }
            }
        });
    }

    public void cbActionLister() {
        switch (cb.getSelectedIndex()) {
            case 0:
                try {
                    int text = Integer.parseInt(t.getText());
                    Calendar c = Calendar.getInstance();
                    int ns = c.get(Calendar.WEEK_OF_YEAR);
                    if (text == ns) {
                        verdadero();
                    } else {
                        falso();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese numero entero para jugar ");
                }
                break;
            case 1:
                try {
                    int text1 = Integer.parseInt(t.getText());
                    Calendar d = Calendar.getInstance();
                    int da = d.get(Calendar.DAY_OF_MONTH);
                    if (text1 == da) {
                        q = new VentanaResultado();
                        q.lr.setText("correcto");
                        q.lr.setForeground(Color.green);
                        q.br.setText("Terminar");
                    } else {
                        q = new VentanaResultado();
                        q.lr.setText("incorrecto");
                        q.lr.setForeground(Color.red);
                        q.br.setText("Trata de nuevo");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese numero entero para jugar ");
                }
                break;
            case 2:
                try {
                    int text1 = Integer.parseInt(t.getText());
                    Calendar d = Calendar.getInstance();
                    int da = d.get( Calendar.MONTH)+1;
                    if (text1 == da) {
                        
                        verdadero();
                    } else {
                        falso();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese numero entero para jugar ");
                }
                break;
        }
    }

    public Boolean verdadero() {
        q = new VentanaResultado();
        q.lr.setText("correcto");
        q.lr.setForeground(Color.green);
        q.br.setText("Terminar");
        
                
        return true;

    }

    public Boolean falso() {
        q = new VentanaResultado();
        q.lr.setText("incorrecto");
        q.lr.setForeground(Color.red);
        q.br.setText("Intentar de nuevo");
        return true;

    }
}


