/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elle.analyster;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Tina
 */
public class ReportWin extends JDialog {

    /**
     * Creates new form ReportWin
     */
    public ReportWin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        connection(sqlC);
    }

    public ReportWin() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReportWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Create and display the dialog
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReportWin dialog = new ReportWin(new JFrame(), true);
                /*dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });*/
                dialog.setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addNew = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        title_text = new javax.swing.JTextField();
        note = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        note_text = new javax.swing.JTextArea();
        submit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        scrollpane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(700, 550));
        setMinimumSize(new java.awt.Dimension(550, 200));

        addNew.setText("New");
        addNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewActionPerformed(evt);
            }
        });

        title.setText("Title:");

        title_text.setEditable(false);
        title_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        title_text.setMaximumSize(new java.awt.Dimension(200, 18));
        title_text.setMinimumSize(new java.awt.Dimension(100, 18));
        title_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title_textActionPerformed(evt);
            }
        });

        note.setText("Suggestions:");

        note_text.setEditable(false);
        note_text.setColumns(20);
        note_text.setRows(5);
        note_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        note_text.setMaximumSize(new java.awt.Dimension(220, 18));
        note_text.setMinimumSize(new java.awt.Dimension(102, 18));
        jScrollPane1.setViewportView(note_text);

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(note))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(title_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(19, 19, 19))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submit)
                            .addComponent(addNew))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(title_text, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(note)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(submit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scrollpane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setMaximumSize(new java.awt.Dimension(260, 100));
        scrollpane.setMinimumSize(new java.awt.Dimension(130, 50));

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Date", "Author", "title", "Notes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        scrollpane.setViewportView(table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void title_textActionPerformed(ActionEvent evt) {//GEN-FIRST:event_title_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_title_textActionPerformed

    private void addNewActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addNewActionPerformed
        // TODO add your handling code here:
        title_text.setEditable(true);
        //title_text.setEnabled(true);
        title_text.setDragEnabled(true);

        note_text.setEditable(true);
        note_text.setEnabled(true);
        note_text.setDragEnabled(true);

        title_text.setText(null);
        note_text.setText(null);
    }//GEN-LAST:event_addNewActionPerformed

    private void submitActionPerformed(ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date = format.format(new Date()).toString();

            String sqlChange = "INSERT INTO Suggestions (Date, Author, title, Notes) VALUES ('"
                    + date + "','Tester','" + title_text.getText() + "','" + note_text.getText() + "')";
            //System.out.println(sqlChange);
            stmt.executeUpdate(sqlChange);
            connection(sqlC);
	    			//logwind.sendMessages(sqlChange);
            //c.revalidate();
            title_text.setText(null);
            note_text.setText(null);
            title_text.setEditable(false);
            note_text.setEditable(false);

        } catch (SQLException ex) {
	    			//logwind.sendMessages(ex.getMessage());
            //logwind.sendMessages(ex.getSQLState() + "\n");
            System.out.println("sql Error: " + ex);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            //logwind.sendMessages(ex.getMessage());
        }

    }//GEN-LAST:event_submitActionPerformed

    private void tableMouseClicked(MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        title_text.setEditable(false);
        note_text.setEditable(false);
        int row = table.getSelectedRow();
        ResultSet rs = null;
        try {
            String sqlView = "select * from Suggestions where ID= " + table.getValueAt(row, 0) + ";";
            //System.out.println(sqlView);
            rs = stmt.executeQuery(sqlView);
            /*int size= 0;
             if (rs != null)   
             {  
             rs.beforeFirst();  
             rs.last();  
             size = rs.getRow();  
             } */
            rs.first();
	    			//System.out.println(size);
            //logwind.sendMessages(sqlChange);
            note_text.setText(rs.getString("notes"));
            title_text.setText(rs.getString("title"));
            rs.close();

        } catch (SQLException ex) {
	    			//logwind.sendMessages(ex.getMessage());
            //logwind.sendMessages(ex.getSQLState() + "\n");
            System.out.println("Error: " + ex);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            //logwind.sendMessages(ex.getMessage());
        }
    }//GEN-LAST:event_tableMouseClicked
    public void connection(String sql) {
        stmt = null;
		//String sql="select * from Suggesions";
        //System.out.println(sql);
        Vector columnNames = new Vector();

        Vector data = new Vector();

        int columns = 0;

		// panel_display = new JPanel();
        String db_url, username, password;

        String jdbc_driver = "com.mysql.jdbc.Driver";

        db_url = "jdbc:mysql://elle.csndtbcukajz.us-west-2.rds.amazonaws.com:3306/ELLE_Fundamentals";

        username = "dbashicheng";

        password = "shicheng1221";

        try {

            Class.forName(jdbc_driver);

			//logwind.sendMessages("\nStart to connect AWS...");
            Connection con = DriverManager.getConnection(db_url, username, password);

			//logwind.sendMessages("Connect successfully!\n");
            stmt = con.createStatement();

            System.out.println("Report Connection successfully");

        } catch (Exception ex) {

            System.out.println("Cannot open AWS database -- make sure AWS is configured properly.");
            //logwind.sendMessages(ex.getMessage());
            System.exit(1);

        }

        ResultSet rs = null;

        ResultSetMetaData metaData = null;

        try {

            rs = stmt.executeQuery(sql);

            metaData = rs.getMetaData();

        } catch (Exception ex) {

            System.out.println("Error: " + ex);

        }

        try {

            columns = metaData.getColumnCount();

            for (int i = 1; i <= columns; i++) {

                columnNames.addElement(metaData.getColumnName(i));

            }

            while (rs.next()) {

                Vector row = new Vector(columns);

                for (int i = 1; i <= columns; i++) {

                    row.addElement(rs.getObject(i));

                }

                data.addElement(row);
				//System.out.println(data.size());
                //System.out.println(row.size());

            }

            rs.close();

			//stmt.close();
        } catch (SQLException ex) {
			//logwind.sendMessages(ex.getMessage());
            //logwind.sendMessages(ex.getSQLState() + "\n");
            System.out.println("Error: " + ex);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            //logwind.sendMessages(ex.getMessage());
        }

        table.setModel(new MyTableModel(data, columnNames,true));   // true - isCellEditable
		//System.out.println(data.size());
        //System.out.println(columnNames.size());
        //table.setModel(new DefaultTableModel(data, columnNames));
        //numOfRecords.setText("Number of records:" +data.size());

		// table.getColumnClass(0);
		// table.getColumnClass(2);
		// table.isCellEditable(0, 0);
		// table.isCellEditable(0, 2);
		//table.setPreferredScrollableViewportSize(new Dimension(400, 300));
		//TableColumn column;

        /*for (int i = 0; i < table.getColumnCount(); i++) {

         column = table.getColumnModel().getColumn(i);
         column.setMinWidth(40);
         column.setMaxWidth(200);

         }*/
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int col = 0; col < table.getColumnCount(); col++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(col);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, col);
                Component c = table.prepareRenderer(cellRenderer, row, col);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width + 5;
                preferredWidth = Math.max(preferredWidth, width);
                            //System.out.print(width + " ");
                //  We've exceeded the maximum width, no need to check other rows

                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }
            //System.out.print(preferredWidth+ "\n");
            tableColumn.setPreferredWidth(preferredWidth);

        }

        //table.getColumnModel().getColumn(4).setCellRenderer(new TextAreaRenderer.TextAreaRenderer());
        table.setRowHeight(20);
        System.out.println("Report table added successfully");

    }

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    /*try {
     for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
     if ("Nimbus".equals(info.getName())) {
     javax.swing.UIManager.setLookAndFeel(info.getClassName());
     break;
     }
     }
     } catch (ClassNotFoundException ex) {
     java.util.logging.Logger.getLogger(ReportWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (InstantiationException ex) {
     java.util.logging.Logger.getLogger(ReportWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (IllegalAccessException ex) {
     java.util.logging.Logger.getLogger(ReportWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
     java.util.logging.Logger.getLogger(ReportWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }
     //</editor-fold>

     // Create and display the dialog
     java.awt.EventQueue.invokeLater(new Runnable() {
     public void run() {
     ReportWin dialog = new ReportWin(new javax.swing.JFrame(), true);
     dialog.addWindowListener(new java.awt.event.WindowAdapter() {
     @Override
     public void windowClosing(java.awt.event.WindowEvent e) {
     System.exit(0);
     }
     });
     dialog.setVisible(true);
     }
     });
     }*/
    //private Container c;
    private Statement stmt;
    private final String sqlC = "select * from Suggestions";

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNew;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel note;
    private javax.swing.JTextArea note_text;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JButton submit;
    private javax.swing.JTable table;
    private javax.swing.JLabel title;
    private javax.swing.JTextField title_text;
    // End of variables declaration//GEN-END:variables
}


