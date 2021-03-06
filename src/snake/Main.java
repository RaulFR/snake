/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import javax.swing.ImageIcon;

/**
 *
 * @author Raul
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private Snake snake;
    private SnakeLoop snakeLoop;
    private int pauseSpeed = 500;
    private int modo;
    //private MusicaYSonidos musicaYsonidos;

    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        b_Pausa.setEnabled(false);

    }

    public void setModo() {
        this.modo = jComboBox1.getSelectedIndex();
        System.out.println(modo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton2 = new javax.swing.JToggleButton();
        snakePanel = new snake.SnakePanel();
        b_Sonido = new javax.swing.JToggleButton();
        b_Pausa = new javax.swing.JToggleButton();
        b_Start = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        b_Musica = new javax.swing.JToggleButton();

        jToggleButton2.setText("jToggleButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout snakePanelLayout = new javax.swing.GroupLayout(snakePanel);
        snakePanel.setLayout(snakePanelLayout);
        snakePanelLayout.setHorizontalGroup(
            snakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        snakePanelLayout.setVerticalGroup(
            snakePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        b_Sonido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sonidoON.png"))); // NOI18N
        b_Sonido.setToolTipText("Desactivar Sonido");
        b_Sonido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_SonidoActionPerformed(evt);
            }
        });

        b_Pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pause.png"))); // NOI18N
        b_Pausa.setToolTipText("Pausar la partida");
        b_Pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_PausaActionPerformed(evt);
            }
        });

        b_Start.setText("Start");
        b_Start.setToolTipText("Empezar el juego");
        b_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_StartActionPerformed(evt);
            }
        });

        jLabel1.setText("Modo:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aumento de velocidad", "Aumento de tamaño" }));

        b_Musica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/musicaON.png"))); // NOI18N
        b_Musica.setToolTipText("Desactivar la musica");
        b_Musica.setPreferredSize(new java.awt.Dimension(35, 25));
        b_Musica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_MusicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b_Start)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_Pausa)
                .addGap(36, 36, 36)
                .addComponent(b_Musica, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_Sonido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(snakePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_Start)
                        .addComponent(jLabel1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(b_Pausa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_Sonido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_Musica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(snakePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_StartActionPerformed
        setModo();
        snake = new Snake(20, 20, modo);
        //Pasar el contenido del juego al panel
        snakePanel.setSnake(snake);

        b_Pausa.setEnabled(true);

        //Inciar el movimiento automático
        snakeLoop = new SnakeLoop(snake, pauseSpeed, snakePanel, modo);
        snakeLoop.start();
        snakePanel.requestFocus();
    }//GEN-LAST:event_b_StartActionPerformed

    private void b_SonidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_SonidoActionPerformed
        if (b_Sonido.isSelected()) {
            b_Sonido.setIcon(new ImageIcon(getClass().getResource("/imagenes/sonidoOFF.png")));
            b_Sonido.setToolTipText("Activar el sonido");
        } else {
            b_Sonido.setIcon(new ImageIcon(getClass().getResource("/imagenes/sonidoON.png")));
            b_Sonido.setToolTipText("Desactivar el sonido");
        }
    }//GEN-LAST:event_b_SonidoActionPerformed

    private void b_MusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_MusicaActionPerformed
        if (b_Musica.isSelected()) {
            b_Musica.setIcon(new ImageIcon(getClass().getResource("/imagenes/musicaOFF.png")));
            b_Musica.setToolTipText("Activar la musica");
        } else {
            b_Musica.setIcon(new ImageIcon(getClass().getResource("/imagenes/musicaON.png")));
            b_Musica.setToolTipText("Desactivar la musica");
        }
    }//GEN-LAST:event_b_MusicaActionPerformed

    private void b_PausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_PausaActionPerformed
        if (b_Pausa.isSelected()) {
            snakeLoop.stop();
            b_Pausa.setIcon(new ImageIcon(getClass().getResource("/imagenes/play.png")));
            b_Pausa.setToolTipText("Continuar la partida");
        } else {
            snakeLoop.start();
            snakePanel.requestFocus();
            b_Pausa.setIcon(new ImageIcon(getClass().getResource("/imagenes/pause.png")));
            b_Pausa.setToolTipText("Pausar la partida");
        }


    }//GEN-LAST:event_b_PausaActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton b_Musica;
    private javax.swing.JToggleButton b_Pausa;
    private javax.swing.JToggleButton b_Sonido;
    private javax.swing.JButton b_Start;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton2;
    private snake.SnakePanel snakePanel;
    // End of variables declaration//GEN-END:variables
}
