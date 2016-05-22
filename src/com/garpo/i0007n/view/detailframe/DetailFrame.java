package com.garpo.i0007n.view.detailframe;

import com.garpo.i0007n.controll.CommentTableModel;
import com.garpo.i0007n.controll.Controller;
import com.garpo.i0007n.controll.TaskTabelModel;
import com.garpo.i0007n.model.Comment;
import com.garpo.i0007n.model.Person;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class DetailFrame extends javax.swing.JFrame {
    
    Controller controller = Controller.getController();
    private int id;
    private Person assignedTo;
    private String cat;
    private String status;
    private String desc;
    private int estTime;
    private int usedTime;
    private int statusIndex;
    private int catIndex;
    private int personIndex;
    private Date updated = null;
    private JTable parent;
    private List<Comment> commentList;
    private CommentTableModel commentTableModel;
    private DefaultComboBoxModel statusListModel;
    private DefaultComboBoxModel categoryListModel;
    private DefaultComboBoxModel personListModel;
    
    public DetailFrame(JTable parent, int id, Person assignedTo, String cat, String status, String desc, int estTime, int usedTime) {
        super("Redigera ärende");
        this.id=id;
        this.assignedTo=assignedTo;
        this.cat=cat;
        this.status = status;
        this.desc = desc;
        this.estTime = estTime;
        this.usedTime = usedTime;
        this.statusListModel = new DefaultComboBoxModel();
        this.categoryListModel = new DefaultComboBoxModel();       
        this.personListModel = new DefaultComboBoxModel(); 
        this.commentTableModel = new CommentTableModel();
        this.parent = parent;
  
        
        
        
         // === Setup Status list ====
        List<String> statusList = controller.getStatusList();
        for(String stats : statusList){
            statusListModel.addElement(stats);
        }
        for(int i = 0; i < statusList.size() ;i++){
            if(statusList.get(i).equals(status)){
                statusIndex = i;
            }
        } 
        
        // === Setup Category Combobox ====

        List<String> categoryList = controller.getCategoryList();
        for(String categoryitem : categoryList){
            categoryListModel.addElement(categoryitem);
        }
        for(int i = 0; i < categoryList.size() ;i++){
            if(categoryList.get(i).equals(cat)){
                catIndex = i;
            }
        } 

        // ==== Setup AssignedTo List ======
        List<Person> persons = controller.getPersons();
        for(Person person : persons){
            personListModel.addElement(person);
        }
        for(int i = 0; i < persons.size() ;i++){
            if(persons.get(i).equals(assignedTo)){
                personIndex = i;
            }
        } 
       
        // ==== Comments setup ======
        try {
            commentList = controller.getComments(id);           
            
        } catch (Exception ex) {
            new JOptionPane("Fel. Anslutning till databasen misslyckades.");
            ex.printStackTrace();
        }
        try{
        commentTableModel.setData(controller.getComments(id));
        }
        catch (Exception e) {
                        new JOptionPane("Kan inte hämta kommentarer");
                        e.printStackTrace();
                    }
 
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblDetailTaskID = new javax.swing.JLabel();
        lblDetailCategory = new javax.swing.JLabel();
        lblTaskID = new javax.swing.JLabel();
        lblDetailDescription = new javax.swing.JLabel();
        lblDetailStatus = new javax.swing.JLabel();
        lblDetailAssignedTo = new javax.swing.JLabel();
        lblEstimatedTime = new javax.swing.JLabel();
        lblUsedTime = new javax.swing.JLabel();
        txtEstimatedTime = new javax.swing.JTextField();
        cbStatus = new javax.swing.JComboBox<>();
        cboxAssignedTo = new javax.swing.JComboBox<>();
        txtUsedTime = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnClose = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        cboxCategory = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        btnAddComment = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblComments = new javax.swing.JTable();
        lblCommentCount = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblDetailTaskID.setText("Ärendenummer:");

        lblDetailCategory.setText("Kategori:");

        lblTaskID.setText(Integer.toString(id));

        lblDetailDescription.setText("Beskrivning:");

        lblDetailStatus.setText("Status:");

        lblDetailAssignedTo.setText("Tilldelad till:");

        lblEstimatedTime.setText("Uppskattad tidsåtgång:");

        lblUsedTime.setText("Verklig tidsåtgång:");

        txtEstimatedTime.setText(Integer.toString(estTime));

        cbStatus.setModel(statusListModel);
        cbStatus.setSelectedIndex(statusIndex);

        cboxAssignedTo.setModel(personListModel);
        cboxAssignedTo.setSelectedIndex(personIndex);

        txtUsedTime.setText(Integer.toString(usedTime));

        txtDescription.setColumns(20);
        txtDescription.setLineWrap(true);
        txtDescription.setRows(3);
        txtDescription.setText(desc);
        jScrollPane1.setViewportView(txtDescription);

        btnClose.setText("Stäng");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnUpdate.setText("Uppdatera");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        cboxCategory.setModel(categoryListModel);
        cboxCategory.setSelectedIndex(catIndex);

        btnAddComment.setText("Lägg till kommentar");
        btnAddComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCommentActionPerformed(evt);
            }
        });

        tblComments.setModel(commentTableModel);
        tblComments.getColumnModel().getColumn(0).setPreferredWidth(400);
        tblComments.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblComments.getColumnModel().getColumn(2).setPreferredWidth(150);
        jScrollPane3.setViewportView(tblComments);

        lblCommentCount.setText(commentList.size() + " kommentar(er).");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDetailCategory, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDetailDescription, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDetailTaskID)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTaskID))
                                    .addComponent(lblCommentCount))
                                .addGap(171, 171, 171)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblEstimatedTime)
                                            .addComponent(lblUsedTime))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtUsedTime)
                                            .addComponent(txtEstimatedTime, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnUpdate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnClose)))
                                .addGap(0, 50, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDetailStatus)
                                    .addComponent(lblDetailAssignedTo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboxAssignedTo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddComment)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDetailTaskID)
                    .addComponent(lblTaskID)
                    .addComponent(lblDetailStatus)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDetailCategory)
                    .addComponent(lblDetailAssignedTo)
                    .addComponent(cboxAssignedTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEstimatedTime)
                                    .addComponent(txtEstimatedTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblUsedTime)
                                    .addComponent(txtUsedTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClose)
                            .addComponent(btnUpdate)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDetailDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCommentCount)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddComment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int assigned = cboxAssignedTo.getSelectedIndex();
        int categoryId = cboxCategory.getSelectedIndex();
        int statusId = cbStatus.getSelectedIndex();
        String description = txtDescription.getText();
        int est;
        if(txtEstimatedTime.getText().equals("")){
            est = 0;
        }else{
            est = Integer.parseInt(txtEstimatedTime.getText());
        }
        int used;
        if(txtEstimatedTime.getText().equals("")){
            used = 0;
        }else{
            used = Integer.parseInt(txtUsedTime.getText());
        }

        try {
            controller.updateTask(id, assigned+1, categoryId+1, statusId+1, description, est, used);


        } catch (Exception e1) {
            new JOptionPane("Update Error");
            e1.printStackTrace();
        }
        
        //Uppdatering av tabellen i MainFrame
        TaskTabelModel model = (TaskTabelModel) parent.getModel();
        try {
            model.setData(controller.getTasks());
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        this.dispose();
        
        
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCommentActionPerformed
        String comment = JOptionPane.showInputDialog("Ny kommentar");
        updated = Calendar.getInstance().getTime();
        try {
            int commentId = controller.getNextCommentId();
            Comment com = new Comment(commentId,1,id,comment,updated);
            controller.addComment(com);
        } catch (Exception e) {
            new JOptionPane("Fel när kommentaren skulle sparas.");
            e.printStackTrace();
        }

        //Hämtar data från databasen och laddar om tabellen med kommentarer.
        try{
        commentTableModel.setData(controller.getComments(id));
        }
        catch (Exception e) {
                        new JOptionPane("Kan inte hämta kommentarer");
                        e.printStackTrace();
                    }
        commentTableModel.fireTableDataChanged();

    }//GEN-LAST:event_btnAddCommentActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddComment;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JComboBox<String> cboxAssignedTo;
    private javax.swing.JComboBox<String> cboxCategory;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCommentCount;
    private javax.swing.JLabel lblDetailAssignedTo;
    private javax.swing.JLabel lblDetailCategory;
    private javax.swing.JLabel lblDetailDescription;
    private javax.swing.JLabel lblDetailStatus;
    private javax.swing.JLabel lblDetailTaskID;
    private javax.swing.JLabel lblEstimatedTime;
    private javax.swing.JLabel lblTaskID;
    private javax.swing.JLabel lblUsedTime;
    private javax.swing.JTable tblComments;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtEstimatedTime;
    private javax.swing.JTextField txtUsedTime;
    // End of variables declaration//GEN-END:variables
}
