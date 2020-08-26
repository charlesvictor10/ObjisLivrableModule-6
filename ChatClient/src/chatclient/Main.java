package chatclient;


import java.awt.Color;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.ArrayList;
import java.util.HashMap;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame
{    
    public Main()
    {
        try
        {
           initComponents();
           FileDrop fd=new FileDrop(this,new FileDrop.Listener()
           {
               @Override
               public void filesDropped(File[] files)
               {
                   try
                   {
                       if(isConnected)
                       {
                           Thread sendfiles=new Thread(new Runnable()
                           {
                               @Override
                               public void run()
                               {
                                   try
                                   {
                                       ArrayList<HashMap<String,Object>> files_to_send = new ArrayList<HashMap<String,Object>>();
                                       for(File f:files)
                                       {
                                           byte[] data=Files.readAllBytes(Paths.get(f.getAbsolutePath()));
                                           HashMap<String,Object> values=new HashMap<String, Object>();
                                           values.put("data_type", "file");
                                           values.put("data_content",data);
                                           values.put("data_sender", jTextField4.getText());
                                           values.put("data_file_name",f.getName());
                                           files_to_send.add(values);
                                       }
                                       ObjectOutputStream oos = new ObjectOutputStream(socket2.getOutputStream());
                                       oos.writeObject(files_to_send);
                                   }
                                   catch(Exception e)
                                   {
                                   }   
                                }  
                            });
                            sendfiles.start();
                       }
                       
                       else
                       {
                           JOptionPane.showMessageDialog(null,"Not Connected","Connection Error",JOptionPane.ERROR_MESSAGE); 
                       }
                   }
                   catch(Exception e)
                   {
                   }
               }
           });

        }
        catch(Exception e)
        {
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Online Chat Server & Data Transfer");
        setBackground(new java.awt.Color(255, 0, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("IP");

        jTextField1.setBackground(new java.awt.Color(0, 153, 204));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Online Chat Server & Data Transfer");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 0));
        jButton1.setText("CONNECT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 0));
        jButton2.setText("SEND");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("List of Sent Messages");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("List of Sent Files");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("Name");

        jTextField4.setBackground(new java.awt.Color(0, 153, 204));
        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));

        jTextArea1.setBackground(new java.awt.Color(0, 255, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Message");

        jCheckBox2.setBackground(new java.awt.Color(0, 0, 0));
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Receive Files");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Status : Not Connected");

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(0, 255, 204));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("Local Chat Server with multiple clients\nSend messages using keyboard\nSend files using drag and drop\nDownload files sent by other clients");
        jScrollPane4.setViewportView(jTextArea2);

        jButton5.setBackground(new java.awt.Color(0, 153, 204));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 204));
        jButton5.setText("DOWNLOAD FILE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 153));
        jButton4.setText("DELETE FILE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(33, 33, 33)
                                .addComponent(jLabel7)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(82, 82, 82)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jCheckBox2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel7))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane4)
                                    .addComponent(jScrollPane3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jButton5)
                                .addGap(36, 36, 36)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try
        {
            if(!isConnected)
            {
                if(jTextField1.getText().trim().equals(""))
                {
                    JOptionPane.showMessageDialog(this,"IP is empty","Empty IP",JOptionPane.ERROR_MESSAGE);
                }
                else if(jTextField4.getText().trim().equals(""))
                {
                    JOptionPane.showMessageDialog(this,"Name is empty","Empty Name",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    connect(jTextField1.getText());
                    if(isConnected)
                    {
                        JOptionPane.showMessageDialog(this,"Succesfuly Connected","Connection Successfull",JOptionPane.INFORMATION_MESSAGE);
                        jTextField4.setEditable(false);           
                        HashMap<String,Object> values=new HashMap<String,Object>();
                        values.put("user_name",jTextField4.getText());
                        ObjectOutputStream oos = new ObjectOutputStream(socket1.getOutputStream());
                        oos.writeObject(values);                        
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Not Connected","Connection Error",JOptionPane.ERROR_MESSAGE); 
                    }
                }
            }
        }
        catch(Exception e)
        {   
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try
        {
            if(isConnected)
            {
                if(!jTextArea1.getText().trim().equals(""))
                {
                    HashMap<String,Object> values=new HashMap<>();
                    values.put("data_type","message");
                    values.put("data_content", jTextArea1.getText());
                    values.put("data_sender", jTextField4.getText());
                    ObjectOutputStream oos = new ObjectOutputStream(socket1.getOutputStream());
                    oos.writeObject(values);
                    jTextArea1.setText("");
                }
                
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Not Connected","Connection Error",JOptionPane.ERROR_MESSAGE); 
            }
        }
        catch(Exception e)
        {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if(jTable1.getSelectionModel().isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please select a file first","No file selected",JOptionPane.ERROR_MESSAGE); 
        }
        else
        {
            int[] rows = jTable1.getSelectedRows();
            DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
            for (int row : rows)
            {
                try
                {
                    files.remove(row);
                    model.removeRow(jTable2.convertRowIndexToModel(row));
                }
                catch(Exception e)
                {
                }
            }
            jTable1.clearSelection();
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        if(jTable1.getSelectionModel().isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please select a file first","No file selected",JOptionPane.ERROR_MESSAGE); 
        }
        else
        {
            try
            {
                byte[] data=files.get(jTable1.getSelectedRow());
                JFileChooser filedialog = new JFileChooser();
                filedialog.setDialogTitle("Specify where to save the file");
                String filename=(String)jTable1.getValueAt(jTable1.getSelectedRow(),1);
                String fileext=getFileExtension(filename);
                filedialog.setSelectedFile(new File(filename));
                filedialog.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter(fileext.toUpperCase()+" Files",fileext);
                filedialog.addChoosableFileFilter(filter);
                int result = filedialog.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION)
                {
                    Files.write(Paths.get(filedialog.getSelectedFile().getAbsolutePath()), data,CREATE);
                }
            }
            catch(Exception e)
            {
            }
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        DefaultTableModel model = new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        model.setDataVector(new Object[][]{}, new Object[]{ "User","Message"});
        jTable2.setModel(model);
        jTable2.getColumn("User").setCellRenderer(new TextFieldRenderer());
        jTable2.getColumn("Message").setCellRenderer(new TextAreaRenderer());
        jTable2.getColumn("Message").setCellEditor(new TextAreaEditor());
        jTable2.setRowHeight(60);

    }//GEN-LAST:event_formWindowOpened

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed

        try
        {
            HashMap<String,Object> values=new HashMap<String,Object>();
            if(jCheckBox2.isSelected())
            {
                values.put("will_receive_files",true);
            }
            else
            {
                values.put("will_receive_files",false);
            }
            ObjectOutputStream oos = new ObjectOutputStream(socket1.getOutputStream());
            oos.writeObject(values);
        }
        catch(Exception e)
        {
        }
        
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    void connect(String IP)
    {
        try
        {
            InetAddress address=InetAddress.getByName(IP);
            socket1  = new Socket(address,6000);
            socket2  = new Socket(address,7000);
            Thread messageListener=new Thread(new Runnable()
            {
               @Override
               public void run()
               {
                   try
                   {
                       while(true)
                       {
                           ObjectInputStream ois = new ObjectInputStream(socket1.getInputStream());
                           HashMap<String,Object> data=(HashMap<String,Object>) ois.readObject();
                           if(data.containsKey("data_type") && data.get("data_type").equals("message"))
                           {
                               String user=(String)data.get("data_sender");
                               String  message=(String)data.get("data_content");
                               DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
                               model.addRow(new Object[] {user,message});
                               jTable2.setRowSelectionInterval(jTable2.getRowCount()-1, jTable2.getRowCount()-1);
                               JScrollBar vertical = jScrollPane2.getVerticalScrollBar();
                               vertical.setValue( vertical.getMaximum());
                               notifyMessage();
                           }
                       }
                   }
                   catch(Exception e)
                   {
                       isConnected=false;
                       jLabel8.setText("Status : Not Connected");
                       jLabel8.setForeground(Color.red);
                       jButton2.setEnabled(false);
                   }
               }
            });
            Thread fileListener=new Thread(new Runnable()
            {
               @Override
               public void run()
               {
                   try
                   {
                       while(true)
                       {
                           ObjectInputStream ois = new ObjectInputStream(socket2.getInputStream());
                           ArrayList<HashMap<String,Object>> data=(ArrayList<HashMap<String,Object>>) ois.readObject();
                           for(HashMap<String,Object> f:data)
                           {   
                               byte[] file=(byte[])f.get("data_content");
                               files.add(file);
                               String user=(String)f.get("data_sender");
                               String filename=(String)f.get("data_file_name");
                               DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
                               model.addRow(new Object[] { user, filename });
                           }
                           notifyMessage();
                       }
                   }
                   catch(Exception e)
                   {
                       isConnected=false;
                       jLabel8.setText("Status : Not Connected");
                       jLabel8.setForeground(Color.red);
                       jButton2.setEnabled(false);
                   }
               }
            });
            messageListener.start();
            fileListener.start();
            isConnected=true;
            jLabel8.setText("Status : Connected");
            jLabel8.setForeground(Color.white);
            jButton2.setEnabled(true);
        }
        catch(Exception e)
        {
            isConnected=false;
            jLabel8.setText("Status : Not Connected");
            jLabel8.setForeground(Color.red);
            jButton2.setEnabled(false);
        }
    }
    
    String getFileExtension(String file)
    {
        if(file.lastIndexOf(".") != -1 && file.lastIndexOf(".") != 0)
        {
            return file.substring(file.lastIndexOf(".")+1);
        }
        else 
        {
            return "";
        }
    }
    
    void notifyMessage()
    {
        try
        {
            URL defaultSound = getClass().getResource("notification.wav");
            File soundFile = new File(defaultSound.toURI());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch(Exception ex)
        {
        }
    }

    
    public static void main(String args[])
    {
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    Main main=new Main();
                    main.setLocationRelativeTo(null);
                    main.getContentPane().setBackground(Color.black);
                    main.setVisible(true);
                }
                catch(Exception e)
                {
                    
                }                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
    private static Socket socket1;
    private static Socket socket2;
    private static ArrayList<byte[]> files=new ArrayList<byte[]>();
    private static boolean isConnected=false;
}
