/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;
import java.io.*;  
import java.awt.CardLayout;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Adriana
 */
public class Menu extends javax.swing.JFrame {
    String ruta = "";
    File f = null;
   
    /**
     * Creates new form Menu
     */
    public Menu() {
         initComponents();
         setLocationRelativeTo(null);
       //setExtendedState(MAXIMIZED_BOTH);
       setVisible(true);
       configAreaText();
       
    }
    
    public void configAreaText(){
        SyncronizerClass synchronizer = new SyncronizerClass(txtEntrada);
        scroll.setRowHeaderView(synchronizer);
        
        StyleContext styleContext = new StyleContext();
        Style defaultStyle = styleContext.getStyle(StyleContext.DEFAULT_STYLE);
        Style cwStyle = styleContext.addStyle("ConstantWidth", null);
        Style commStyle = styleContext.addStyle("ConstantWidth", null);
        Style numStyle = styleContext.addStyle("ConstantWidth", null);
        Color col = new Color(155, 113, 252);
        StyleConstants.setForeground(cwStyle, col);
        col = new Color(0, 255, 191);
        StyleConstants.setForeground(commStyle, col);
        col = new Color(113, 157, 252);
        StyleConstants.setForeground(numStyle, col);
        StyleConstants.setBold(cwStyle, true);
        
        KeywordStyledDocument doc = new KeywordStyledDocument(defaultStyle, cwStyle, commStyle, numStyle);
        txtEntrada.setDocument(doc);
        txtEntrada.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent ce) {
                int pos = txtEntrada.getCaretPosition();
                Element map = txtEntrada.getDocument().getDefaultRootElement();
                int row = map.getElementIndex(pos);
                Element lineElem = map.getElement(row);
                int col = pos - lineElem.getStartOffset();
                updateStatus(row + 1, col + 1);
            }
            
            private void updateStatus(int linenumber, int columnnumber) {
        status.setText("Linea: " + linenumber + " Columna: " + columnnumber);
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

        codigoArea = new javax.swing.JPanel();
        jLabelGuardado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        lexicoTxt = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        status = new javax.swing.JTextField();
        scroll = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        errorBtn = new javax.swing.JButton();
        resBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivoBtn = new javax.swing.JMenu();
        abrirBtn = new javax.swing.JMenuItem();
        guardarBtn = new javax.swing.JMenuItem();
        Gcomobtn = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        editarBtn = new javax.swing.JMenu();
        copy = new javax.swing.JMenuItem();
        paste = new javax.swing.JMenuItem();
        cut = new javax.swing.JMenuItem();
        deshacer = new javax.swing.JMenuItem();
        formatoBtn = new javax.swing.JMenu();
        compilarBtn = new javax.swing.JMenu();
        ayudaBtn = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codigoArea.setBackground(new java.awt.Color(204, 204, 255));
        codigoArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelGuardado.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabelGuardado.setForeground(new java.awt.Color(0, 153, 0));
        codigoArea.add(jLabelGuardado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 250, -1));

        jLabel2.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Código a Compilar: ");
        codigoArea.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Candara", 0, 11)); // NOI18N

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        lexicoTxt.setEditable(false);
        lexicoTxt.setColumns(20);
        lexicoTxt.setRows(5);
        jScrollPane4.setViewportView(lexicoTxt);

        jTabbedPane1.addTab("Lexico", jScrollPane4);

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane5.setViewportView(jTextArea4);

        jTabbedPane1.addTab("Sintactico", jScrollPane5);

        jTextArea5.setEditable(false);
        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane6.setViewportView(jTextArea5);

        jTabbedPane1.addTab("Semantico", jScrollPane6);

        jTextArea6.setEditable(false);
        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jScrollPane7.setViewportView(jTextArea6);

        jTabbedPane1.addTab("Codigo Intermedio", jScrollPane7);

        codigoArea.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 340, 250));

        status.setEditable(false);
        status.setBackground(new java.awt.Color(200, 200, 211));
        status.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        status.setForeground(new java.awt.Color(0, 51, 51));
        status.setText("Linea:    Columna:");
        status.setBorder(null);
        codigoArea.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 150, -1));

        scroll.setViewportView(txtEntrada);

        codigoArea.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 450, 220));

        getContentPane().add(codigoArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 290));

        jPanel3.setBackground(new java.awt.Color(204, 204, 224));

        errorBtn.setBackground(new java.awt.Color(153, 153, 255));
        errorBtn.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        errorBtn.setText("Errores");
        errorBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        errorBtn.setMargin(new java.awt.Insets(2, 14, 0, 14));
        errorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                errorBtnActionPerformed(evt);
            }
        });

        resBtn.setBackground(new java.awt.Color(153, 153, 255));
        resBtn.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        resBtn.setText("Resultados");
        resBtn.setBorderPainted(false);
        resBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        resBtn.setMargin(new java.awt.Insets(2, 14, 0, 14));
        resBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resBtnMouseEntered(evt);
            }
        });
        resBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                resBtnMouseDragged(evt);
            }
        });
        resBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resBtnActionPerformed(evt);
            }
        });

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtResultado.setEditable(false);
        txtResultado.setBackground(new java.awt.Color(244, 244, 255));
        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        txtResultado.setMargin(new java.awt.Insets(0, 2, 2, 2));
        jScrollPane2.setViewportView(txtResultado);

        jButton1.setText("RUN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(errorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(errorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(resBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 830, 170));

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 255));

        archivoBtn.setText("Archivo");

        abrirBtn.setText("Abrir");
        abrirBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirBtnMouseClicked(evt);
            }
        });
        abrirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirBtnActionPerformed(evt);
            }
        });
        archivoBtn.add(abrirBtn);

        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });
        archivoBtn.add(guardarBtn);

        Gcomobtn.setText("Guardar como...");
        Gcomobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GcomobtnActionPerformed(evt);
            }
        });
        archivoBtn.add(Gcomobtn);

        jMenuItem1.setText("Cerrar");
        archivoBtn.add(jMenuItem1);

        jMenuBar1.add(archivoBtn);

        editarBtn.setText("Editar");
        editarBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editarBtnKeyPressed(evt);
            }
        });

        copy.setText("Copiar");
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });
        copy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                copyKeyPressed(evt);
            }
        });
        editarBtn.add(copy);

        paste.setText("Pegar");
        paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteActionPerformed(evt);
            }
        });
        editarBtn.add(paste);

        cut.setText("Cortar");
        cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutActionPerformed(evt);
            }
        });
        editarBtn.add(cut);

        deshacer.setText("Deshacer");
        deshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deshacerActionPerformed(evt);
            }
        });
        editarBtn.add(deshacer);

        jMenuBar1.add(editarBtn);

        formatoBtn.setText("Formato");
        jMenuBar1.add(formatoBtn);

        compilarBtn.setText("Compilar");
        jMenuBar1.add(compilarBtn);

        ayudaBtn.setText("Ayuda");
        jMenuBar1.add(ayudaBtn);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void errorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_errorBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_errorBtnActionPerformed

    private void resBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resBtnActionPerformed
       
    }//GEN-LAST:event_resBtnActionPerformed

    private void resBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resBtnMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_resBtnMouseEntered

    private void abrirBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirBtnMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_abrirBtnMouseClicked

    private void resBtnMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resBtnMouseDragged
        // TODO add your handling code here:}
        
        
    }//GEN-LAST:event_resBtnMouseDragged

    private void abrirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirBtnActionPerformed
        // TODO add your handling code here:
       
        //Elegir archivo
        JFileChooser j = new JFileChooser();
        j.showOpenDialog(j);
        ruta = j.getSelectedFile().getAbsolutePath();
        //System.out.print(ruta);
        
        f = new File(ruta);
        Scanner entrada = null;
        String contenido = "";
        try {
            entrada = new Scanner(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Mostrar en pantalla
        while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                contenido = contenido + entrada.nextLine() + "\n";  //se lee una líne
                
         }
        
        txtEntrada.setText(contenido);
 
    }//GEN-LAST:event_abrirBtnActionPerformed

    private void GcomobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GcomobtnActionPerformed
        // TODO add your handling code here:
        //GUARDAR COMO
        try {
            //String ruta = "/ruta/filename.txt";
            JFileChooser j = new JFileChooser();
            j.showOpenDialog(j);
            ruta = j.getSelectedFile().getAbsolutePath() + ".txt";
            
            String contenido = txtEntrada.getText().toString();
            f = new File(ruta);
            // Si el archivo no existe es creado
            if (!f.exists()) {
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            
            jLabelGuardado.setText("Guardado");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_GcomobtnActionPerformed

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        // TODO add your handling code here:
        
        //GUARDAR
        if(f!=null){
            System.out.println(f.getName());
            FileWriter fw = null;
            try {
                fw = new FileWriter(f);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedWriter bw = new BufferedWriter(fw);
            
            try {
                bw.write(txtEntrada.getText().toString());
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                bw.close();
                jLabelGuardado.setText("Guardado");
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_guardarBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txtResultado.setText(""); 
        File archivo = new File("archivo.txt");        
        PrintWriter escribir;
        List<Token> TAll = new ArrayList<Token>();
        try {
            escribir = new PrintWriter(archivo);
            escribir.print(txtEntrada.getText());
            escribir.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Reader lector = new BufferedReader(new FileReader("archivo.txt"));
            Lexer lexer = new Lexer(lector);
            String resultado ="";
            String res2 = "";
            int l = 1; 
            while (true) {
                Tokens tokens = lexer.yylex();
                if(tokens == null){
                    resultado += "FIN";
                    lexicoTxt.setText(resultado);
                    txtResultado.setText(res2);
                    AnalizadorSintactico Ansin = new AnalizadorSintactico(TAll,0);
                    Nodo n = new Nodo(); 
                    n = Ansin.program();
                    txtResultado.setText(Ansin.error);
                    return;
                }
                switch(tokens){
                    case ERROR:
                        res2 +="Linea: "+l+" "+"Simbolo no definido\n";
                        
                        break;
                    case Identificador: case Numero: case Reservadas:
                        resultado +="Linea: "+l+" "+ lexer.lexeme + ": Es un " + tokens + "\n";
                        Token t = new Token(l,tokens, lexer.lexeme); 
                        TAll.add(t);
                        break;
                    case Salto: 
                        l = l +1;
                        break;
                    case abrellave:  
                        resultado +="Linea: "+l+" "+"Token: " + tokens + "\n";
                        Token t2 = new Token(l,tokens, "{"); 
                        TAll.add(t2);
                        break; 
                    case cierrallave: 
                        resultado +="Linea: "+l+" "+"Token: " + tokens + "\n";
                        Token t3 = new Token(l,tokens, "}"); 
                        TAll.add(t3);
                         break;
                    case abreparentesis: 
                        resultado +="Linea: "+l+" "+"Token: " + tokens + "\n";
                        Token t4 = new Token(l,tokens, "("); 
                        TAll.add(t4);
                        break;
                    case cierraparentesis:
                        resultado +="Linea: "+l+" "+"Token: " + tokens + "\n";
                        Token t5 = new Token(l,tokens, ")"); 
                        TAll.add(t5);
                        break; 
                    case puntoycoma:
                        resultado +="Linea: "+l+" "+"Token: " + tokens + "\n";
                        Token t6 = new Token(l,tokens, ";"); 
                        TAll.add(t6);
                        break;
                    case coma:
                        resultado +="Linea: "+l+" "+"Token: " + tokens + "\n";
                        Token t7 = new Token(l,tokens, ","); 
                        TAll.add(t7);
                        break;
                    default:
                        resultado +="Linea: "+l+" "+"Token: " + tokens + "\n";
                        break;       
                }
            }
            
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteActionPerformed
        // TODO add your handling code here:
        txtEntrada.paste();
    }//GEN-LAST:event_pasteActionPerformed

    private void editarBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editarBtnKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_editarBtnKeyPressed

    private void copyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_copyKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_copyKeyPressed

    private void copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyActionPerformed
        // TODO add your handling code here:
        txtEntrada.copy();
    }//GEN-LAST:event_copyActionPerformed

    private void cutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutActionPerformed
        // TODO add your handling code here:
         txtEntrada.cut();
    }//GEN-LAST:event_cutActionPerformed

    private void deshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deshacerActionPerformed
        // TODO add your handling code here:
        UndoManager um = new UndoManager();
        txtEntrada.getDocument().addUndoableEditListener(um);
        um.undo();
    }//GEN-LAST:event_deshacerActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Gcomobtn;
    private javax.swing.JMenuItem abrirBtn;
    private javax.swing.JMenu archivoBtn;
    private javax.swing.JMenu ayudaBtn;
    private javax.swing.JPanel codigoArea;
    private javax.swing.JMenu compilarBtn;
    private javax.swing.JMenuItem copy;
    private javax.swing.JMenuItem cut;
    private javax.swing.JMenuItem deshacer;
    private javax.swing.JMenu editarBtn;
    private javax.swing.JButton errorBtn;
    private javax.swing.JMenu formatoBtn;
    private javax.swing.JMenuItem guardarBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelGuardado;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea lexicoTxt;
    private javax.swing.JMenuItem paste;
    private javax.swing.JButton resBtn;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField status;
    private javax.swing.JTextPane txtEntrada;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
