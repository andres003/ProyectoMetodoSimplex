package LogicaDeNegocios;

import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Validador {

    private boolean flag;
    private String[][] matriz;

    public Validador() {
        this.flag = true;
    }

    public boolean isFlag() {
        return flag;
    }

    public String[][] getMatriz() {
        return matriz;
    }
    
    public void validarCampos(JTextField campo1, JTextField campo2) {
        if (campo1.getText().isEmpty() || campo2.getText().isEmpty()) {
            flag = false;
        }
    }

    public void validarGrupoBoton(ButtonGroup grupo) {
        if (grupo.getSelection() == null) {
            flag = false;
        }
    }

    public void validarTabla(JTable tabla) {
        //Validar que no hallan campos vacios o nulos en la tabla
        String[][] datos = new String[tabla.getRowCount()][4];
        for (int i = 0; i < tabla.getRowCount(); i++) {
            for (int j = 0; j < 4; j++) {
                if (tabla.getValueAt(i, j) != null && tabla.getValueAt(i, j).toString() != "") {
                    datos[i][j] = tabla.getValueAt(i, j).toString();
                } else {
                    flag = false;
                    datos[i][j] = "EMPTY";

                }
            }
        }
        //Validar que se hallan colocado los simbolos respectivos en cada una de las casillas de la tabla
        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (datos[i][2].equals("=") || datos[i][2].equals("<=") || datos[i][2].equals(">=")) {
                switch (datos[i][2].toString()) {
                    case "=":
                        datos[i][2] = "eq";
                        break;
                    case "<=":
                        datos[i][2] = "le";
                        break;
                    case ">=":
                        datos[i][2] = "ge";
                        break;
                }
            } else {
                flag = false;
            }
        }
        this.matriz = datos;

//        for (int i = 0; i < tabla.getRowCount(); i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.println(datos[i][j]);
//            }
//        }
    }

}
