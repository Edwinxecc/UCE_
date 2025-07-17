package ec.edu.uce.gui;

import ec.edu.uce.dominio.Banco;
import ec.edu.uce.dominio.Cliente;
import ec.edu.uce.dominio.Genero;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JFrameCliente {
    private JLabel JLabelNombre;
    private JTextField JtextFieldApellido;
    private JButton buttonEliminar;
    private JButton buttonListar;
    private JTextField JtextFieldNombre;
    private JPanel mainPanel;
    private JTextArea textAreaLista;
    private JButton agregarButton;
    private JButton buscarButton;
    private JTable jtableCliente;

    Banco banco = Banco.getInstance();

    public JFrameCliente() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JtextFieldNombre.getText();
                String apellido = JtextFieldApellido.getText();
                banco.agregarCliente(1, nombre, apellido, Genero.MASCULINO);
                Limpiar();
                textAreaLista.setText(banco.reporteClientes());
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JtextFieldNombre.getText();

                Cliente c = banco.getCliente(nombre);

                if (c != null){
                    JtextFieldNombre.setText(c.getNombre());
                    JtextFieldApellido.setText(c.getApellido());
                } else {
                    Limpiar();
                    JOptionPane.showMessageDialog(null, "No se encuentra el cliente: " + nombre);
                }
            }
        });
        buttonListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llenarTabla();
                textAreaLista.setText(banco.reporteClientes());

            }
        });
        buttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel tblModel = (DefaultTableModel) jtableCliente.getModel();
                //System.err.println(jtableCliente.getSelectedRowCount());

                if (jtableCliente.getSelectedRowCount() == 1){
                    banco.eliminarCliente(jtableCliente.getSelectedRow());// esto hay que completar con el banco
                    tblModel.removeRow(jtableCliente.getSelectedRow());
                }else {
                    if (jtableCliente.getRowCount() == 0){
                        JOptionPane.showMessageDialog(null, "No hay cliente en la tabla");
                    }else {
                        System.err.println(jtableCliente.getSelectedRowCount());
                        JOptionPane.showMessageDialog(null, "Seleccione un solo cliente");
                    }
                }
                textAreaLista.setText(banco.reporteClientes());
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ClienteUI");
        frame.setContentPane(new JFrameCliente().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();// no puede estar antes de refernciar el contenedor
        frame.setLocationRelativeTo(null);
        JFrameCliente jf = new JFrameCliente(); // my changes
        jf.llenarTabla(); // my changes
        frame.setResizable(true);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
    private void Limpiar(){
        textAreaLista.setText("");
        JtextFieldNombre.setText("");
        JtextFieldApellido.setText("");
    }

    public void llenarTabla(){
        //banco.inicializar();

        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"ID", "Nombre", "Apellido", "Genero"});
        List<Cliente> clientes = banco.getClientes();
        for (Cliente cli : clientes) {
            model.addRow(new Object[]{
                    cli.getClienteId(),
                    cli.getNombre(),
                    cli.getApellido(),
                    cli.getGenero().toString()
            });
        }
        jtableCliente.setModel(model);
    }
}
