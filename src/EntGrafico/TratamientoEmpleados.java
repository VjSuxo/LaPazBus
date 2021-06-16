package EntGrafico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Codigo.*; 
/**
 *
 * @author Tostadora
 */
public class TratamientoEmpleados extends javax.swing.JFrame {

    /**
     * Creates new form TratamientoEmpleados
     */
    
    private DefaultTableModel modeloEmp,modeloCon,modeloAnd,modeloBus;
    private metodos met = new metodos();
    private PilaRuta pilaRuta = new PilaRuta();
    private PilaContratacion pilaContrato = new PilaContratacion();
    private String ciC;
    private String codigoB;
    private int indi=0;
    public TratamientoEmpleados() {
        initComponents();
        jButton4.setEnabled(false);
        modeloEmp = new DefaultTableModel();
        modeloEmp.addColumn("Ci");
        modeloEmp.addColumn("Nombre");
        this.tablaEmpleados.setModel(modeloEmp);
        
        modeloCon = new DefaultTableModel();
        modeloCon.addColumn("Ci");
        modeloCon.addColumn("Nombre");
        this.tablaConductor.setModel(modeloCon);
        
        modeloAnd = new DefaultTableModel();
        modeloAnd.addColumn("Ci");
        modeloAnd.addColumn("Nombre");
        this.tablaAnfitrion.setModel(modeloAnd);
        
        modeloBus = new DefaultTableModel();
        modeloBus.addColumn("Codigo");
        this.tablaBus.setModel(modeloBus);
        
    }

    public void Base(PilaRuta pruta,PilaContratacion pilacon){
        this.pilaRuta = pruta;
        this.pilaContrato = pilacon;
        
    }
    
    public void CargarEmpleados(){
    
        PilaRuta aux = new PilaRuta();
        
        while(!pilaRuta.esVacia()){
        
            Ruta ruta = pilaRuta.eliminar();
            PilaBus pilaBus = ruta.getBuses();
            PilaBus pilaBaux = new PilaBus();
            while(!pilaBus.esVacia()){
                
                Bus b = pilaBus.eliminar();
                PilaPersonal pilaPersonal = b.getDp();
                PilaPersonal pilaPaux = new PilaPersonal();
                
                while(!pilaPersonal.esVacia()){
                    
                    DatosPersonal data = pilaPersonal.eliminar();
                    String[] INFO = new String[2];
                    INFO[0] = data.getCi();
                    INFO[1] = data.getNombre();
                    modeloEmp.addRow(INFO);
                    tablaEmpleados.setModel(modeloEmp);
                    pilaPaux.adiElem(data);
                
                }
                pilaPersonal.vaciar(pilaPaux);
                b.setDp(pilaPersonal);
                pilaBaux.adiElem(b);
            }
            pilaBus.vaciar(pilaBaux);
            ruta.setBuses(pilaBus);
            aux.adiElem(ruta);
        }
        pilaRuta.vaciar(aux);
        
    }
    
        public void CargarBus(){
            System.out.println("x");
        PilaRuta aux = new PilaRuta();
        
        while(!pilaRuta.esVacia()){
        
            Ruta ruta = pilaRuta.eliminar();
            PilaBus pilaBus = ruta.getBuses();
            PilaBus pilaBaux = new PilaBus();
            while(!pilaBus.esVacia()){
                
                Bus b = pilaBus.eliminar();
                String[] INFO = new String[1];
                INFO[0] = String.valueOf(b.getCodigo());
                modeloBus.addRow(INFO);
                tablaBus.setModel(modeloBus);
                pilaBaux.adiElem(b);
            }
            pilaBus.vaciar(pilaBaux);
            ruta.setBuses(pilaBus);
            aux.adiElem(ruta);
        }
        pilaRuta.vaciar(aux);
            System.out.println("c");
    }
        
    public void CargarContrato(){
        
        
        PilaContratacion pilaCaux = new PilaContratacion();
        String[] INFO  = new String[2];
        while(!pilaContrato.esVacia()){
            
            Postulante contrato = pilaContrato.eliminar();
            
            if(contrato.getCargo().equals("conductor")){
                INFO[0] = contrato.getCi();
                INFO[1] = contrato.getNombre();
                indi++;
                modeloCon.addRow(INFO);
                tablaConductor.setModel(modeloCon);
            }
            else{
                INFO[0] = contrato.getCi();
                INFO[1] = contrato.getNombre();
                modeloAnd.addRow(INFO);
                tablaAnfitrion.setModel(modeloAnd);
            }
            
            pilaCaux.adiElem(contrato);
        }
        
        pilaContrato.vaciar(pilaCaux);
                
    }    
    
    public void vaciar(){
        String[] INFO = new String[2];
        modeloCon = new DefaultTableModel();
        int c = modeloCon.getRowCount();
        for (int i = 0; i < c; i++) {
            INFO[0] = "";
            INFO[1] = "";
            modeloCon.addRow(INFO);
        }
    
            tablaConductor.setModel(modeloCon);
        
        c = modeloAnd.getRowCount();
        modeloAnd = new DefaultTableModel();
        
        for (int i = 0; i < c; i++) {
            INFO[0] = "";
            INFO[1] = "";
            modeloAnd.addRow(INFO);
        }
        tablaAnfitrion.setModel(modeloAnd);
       
        
        modeloCon = new DefaultTableModel();
        modeloCon.addColumn("Ci");
        modeloCon.addColumn("Nombre");
        this.tablaConductor.setModel(modeloCon);
        
        modeloAnd = new DefaultTableModel();
        modeloAnd.addColumn("Ci");
        modeloAnd.addColumn("Nombre");
        this.tablaAnfitrion.setModel(modeloAnd);
        
        modeloBus = new DefaultTableModel();
        modeloBus.addColumn("Codigo");
        this.tablaBus.setModel(modeloBus);
        
        jButton4.setEnabled(false);
        asig.setEnabled(false);
    }
    
    
    public void vaiarEmp(){
        int c = modeloEmp.getRowCount();
        modeloEmp = new DefaultTableModel();
        String[] INFO = new String[2];
        for (int i = 0; i < c; i++) {
            INFO[0] = "";
            INFO[1] = "";
            modeloEmp.addRow(INFO);
        }
        tablaEmpleados.setModel(modeloEmp);
             
        modeloEmp = new DefaultTableModel();
        modeloEmp.addColumn("Ci");
        modeloEmp.addColumn("Nombre");
        this.tablaEmpleados.setModel(modeloEmp);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaConductor = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAnfitrion = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaBus = new javax.swing.JTable();
        asig = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ver solicitudes : ");

        jLabel2.setText("Ver empleados : ");

        jButton1.setText("VER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("VER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("EMPLEADOS"));

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tablaEmpleados);

        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Solicitudes"));

        jButton4.setText("CONTRATAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Conductor"));

        tablaConductor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaConductor);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Anfitrion"));

        tablaAnfitrion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaAnfitrion);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 121, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Todos los Buses"));

        tablaBus.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tablaBus);

        asig.setText("ASIGNAR");
        asig.setEnabled(false);
        asig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asig))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(asig)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setText("REGRESAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        vaiarEmp();
        CargarEmpleados();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String ci = "";
        
        
        ci = JOptionPane.showInputDialog("Ingrese Ci a eliminar :");
       
        PilaRuta pilaRaux = new PilaRuta();
        
        while(!pilaRuta.esVacia()){
        
            Ruta ruta = pilaRuta.eliminar();
            PilaBus pilaBus = ruta.getBuses();
            PilaBus pilaBaux = new PilaBus();
            while(!pilaBus.esVacia()){
            
                Bus b = pilaBus.eliminar();
                b.setDp(met.eliminar(b.getDp(),ci)); 
                pilaBaux.adiElem(b);
            }
            pilaBus.vaciar(pilaBaux);
            ruta.setBuses(pilaBus);
            pilaRaux.adiElem(ruta);
        
        }
        pilaRuta.vaciar(pilaRaux);
        vaiarEmp();
        
       
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:\
        jButton4.setEnabled(true);
        CargarContrato();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        int filaCon = tablaConductor.getSelectedRow(); 
        int filaAn  = tablaAnfitrion.getSelectedRow();
        
        if(filaCon!=-1){
            System.out.println(modeloCon.getValueAt(filaCon,0));
            ciC = (String) modeloCon.getValueAt(filaCon,0);
            asig.setEnabled(true);
            CargarBus();
        }
        else{
            if(filaAn!=-1){
                System.out.println(modeloAnd.getValueAt(filaAn,0));
                ciC = (String) modeloAnd.getValueAt(filaAn,0);
                asig.setEnabled(true);
                CargarBus();
            }
            else{
                JOptionPane.showMessageDialog(null,"Seleccione a un postulante de las tablas");
            }
        }
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void asigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asigActionPerformed
        // TODO add your handling code here:
        
        
        int filaAn  = tablaBus.getSelectedRow();
        
        if(filaAn!=-1){
            System.out.println(modeloBus.getValueAt(filaAn,0));
            codigoB = (String) modeloBus.getValueAt(filaAn,0);
           
        }
        
        
        
        pilaRuta = met.contratar(pilaRuta, pilaContrato, ciC, codigoB);
        
         PilaContratacion pilaCaux  = new PilaContratacion();
         Postulante data = null;
         
         while(!pilaContrato.esVacia()){
             Postulante pos = pilaContrato.eliminar();
             if(!ciC.equals(pos.getCi())){
                pilaCaux.adiElem(pos);
             }
         }
         pilaContrato.vaciar(pilaCaux);
        vaiarEmp();
        CargarEmpleados();
        vaciar();
    }//GEN-LAST:event_asigActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Personal p = new Personal();
        p.setRuta(pilaRuta, pilaContrato);
        p.show();
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(TratamientoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TratamientoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TratamientoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TratamientoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TratamientoEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asig;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable tablaAnfitrion;
    private javax.swing.JTable tablaBus;
    private javax.swing.JTable tablaConductor;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}
