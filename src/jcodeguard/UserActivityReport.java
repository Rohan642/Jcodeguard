/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserAccountReport.java
 *
 * 
 */
package jcodeguard;

import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JTable;
import jcodeguard.alpha.DBOperations;
import jcodeguard.report.JasperReportGenerator;
import jcodeguard.alpha.UserActivityMasterBean;

/**
 *
 *  
 */
public class UserActivityReport extends javax.swing.JFrame {

    DBOperations objDB;
    ArrayList alstUserActivity;
    ArrayList alstUserName;

    /** Creates new form UserAccountReport */
    public UserActivityReport() {
        initComponents();
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        objDB = new DBOperations();
        alstUserActivity = objDB.getAllUserActivityDetailList();
        generateTable();

        alstUserName = objDB.getAllUserNameList();
        for (int i = 0; i < alstUserName.size(); i++) {
            ddlUsername.addItem(alstUserName.get(i));
        }

        setTitle("User Activity Report");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    void generateTable() {


        Object data[][] = new Object[alstUserActivity.size()][4];
        for (int i = 0; i < alstUserActivity.size(); i++) {
            UserActivityMasterBean objBean = (UserActivityMasterBean) alstUserActivity.get(i);
            data[i][0] = objBean.getUserId();
            data[i][1] = objBean.getUsername();
            data[i][2] = objBean.getLoginTime();
            data[i][3] = objBean.getLogoutTime();

        }
        String header[] = {"User ID", "Username", "Login Time", "Logout Time"};
        tblUserActivity = new JTable(data, header);
        jScrollPane1.setViewportView(tblUserActivity);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUserActivity = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ddlUsername = new javax.swing.JComboBox();
        btnList = new javax.swing.JButton();
        btnListAll = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miPrint = new javax.swing.JMenuItem();
        miExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblUserActivity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "User ID", "Username", "Login Time", "Logout Time"
            }
        ));
        jScrollPane1.setViewportView(tblUserActivity);

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Activity Report");

        jLabel2.setText("Username");

        ddlUsername.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Username" }));

        btnList.setText("List");
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        btnListAll.setText("List All");
        btnListAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListAllActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        miPrint.setText("Print");
        miPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPrintActionPerformed(evt);
            }
        });
        jMenu1.add(miPrint);

        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        jMenu1.add(miExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(ddlUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnListAll, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ddlUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnList)
                    .addComponent(btnListAll))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        // TODO add your handling code here:
        String username = ddlUsername.getSelectedItem().toString();

        if (username.equalsIgnoreCase("Select Username")) {
            alstUserActivity = objDB.getAllUserActivityDetailList();
        } else {
            alstUserActivity = objDB.getAllUserActivityDetailListByUsername(username);
        }
        generateTable();

    }//GEN-LAST:event_btnListActionPerformed

    private void btnListAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListAllActionPerformed
        // TODO add your handling code here:
        alstUserActivity = objDB.getAllUserActivityDetailList();
        generateTable();

    }//GEN-LAST:event_btnListAllActionPerformed

    private void miPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPrintActionPerformed
        // TODO add your handling code here:
            String path = getClass().getResource("../jcodeguard/report/UserActivityReport.jrxml").getPath();
        JasperReportGenerator jrg=new JasperReportGenerator(path);
    }//GEN-LAST:event_miPrintActionPerformed

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_miExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new UserActivityReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnListAll;
    private javax.swing.JComboBox ddlUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miPrint;
    private javax.swing.JTable tblUserActivity;
    // End of variables declaration//GEN-END:variables
}
