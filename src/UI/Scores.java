/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Home-PC
 */
public class Scores extends JPanel {
    
    public Scores(JFrame frame){
        JTable table1 = new JTable();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pacmanscores", "dev", "dev1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from scores order by score desc");
             DefaultTableModel model = new DefaultTableModel();
        Object[] o;
        String[] columns = {"Name", "Score"};
        model.setColumnIdentifiers(columns);
            while(rs.next()){
                o = new Object[2];
                o[0] = rs.getString(2);
                o[1] = rs.getInt(3);
                model.addRow(o);
            }
            table1.setModel(model);
            this.add(table1);
            table1.setVisible(true);
            
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
            
    }
    
}
