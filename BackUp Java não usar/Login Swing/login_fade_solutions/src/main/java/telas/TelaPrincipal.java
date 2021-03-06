/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import com.github.britooo.looca.api.core.Looca;
import java.util.Timer;
import java.util.TimerTask;
import oshi.util.FormatUtil;


public class TelaPrincipal extends javax.swing.JFrame {
    Looca api = new Looca();
    Timer timer = new Timer();
    
    //Quantos Segundos a RAM vai atualizar(2s)
    final long SEGUNDOSRAM = (1000 * 2 );
    //Quantos Segundos os PROCESSOS vão atualizar(10s)
    final long SEGUNDOSPROCESS = (1000 * 10 );
    //Quantos Segundos os DISCOS vão atualizar(2s)
    final long SEGUNDOSDISCOS = (1000 * 2 );
    //Quantos Segundos a CPU vai atualizar (3s)
    final long SEGUNDOSCPU = (1000 * 3 );
    //AQUI RODAMOS AS INFORMAÇÕES DA RAM
        TimerTask ram;
    //AQUI RODAMOS AS INFORMAÇÕES DOS PROCESSOS
        TimerTask processos;
    //AQUI RODAMOS AS INFORMAÇÕES DA DISCO
        TimerTask disco;
    //AQUI RODAMOS AS INFORMAÇÕES DA CPU
         TimerTask cpu;
        
        
    public TelaPrincipal() {
        this.cpu = new TimerTask(){
            @Override
            public void run(){
                var cpuUso = api.getProcessador().getUso();
                var cpuFrequencia= (FormatUtil.formatHertz(api.getProcessador().getFrequencia()));
                var cpuTempo= (FormatUtil.formatElapsedSecs(api.getSistema().getTempoDeAtividade()));
                
                lblUso.setText(String.format("%.2f",cpuUso));
                lblFrequencia.setText(cpuFrequencia);
                lblTempo.setText(cpuTempo);
            }
        };
        this.disco = new TimerTask(){
            @Override
            public void run(){
                var discoEmUso = (FormatUtil.formatBytes(api.getGrupoDeDiscos().getQuantidadeDeDiscos()));
                var discoTotal = (FormatUtil.formatBytes(api.getGrupoDeDiscos().getTamanhoTotal()));
                var discoDisponivel = api.getGrupoDeDiscos().getVolumes();
                
                for(int x=0; x<discoDisponivel.size();x++){
                    lblDiscoDisponivel.setText("");
                    lblDiscoDisponivel.setText(String.format("%.1f GiB", new Double(lblDiscoDisponivel.getText()+discoDisponivel.get(x).getDisponivel()) / 1000000000));
                }
                
                lblTotalDisco.setText(discoTotal);
            }
        };
        this.ram = new TimerTask(){
            @Override
            public void run(){
                var memoriaEmUso = (FormatUtil.formatBytes(api.getMemoria().getEmUso()));
                var memoriaTotal = (FormatUtil.formatBytes(api.getMemoria().getTotal()));
                var memoriaDisponivel = (FormatUtil.formatBytes(api.getMemoria().getDisponivel()));
                
                lblRamUso.setText(memoriaEmUso);
                lblTotalRam.setText(memoriaTotal);
                lblRamDisponivel.setText(memoriaDisponivel);
                
            }
        };
        this.processos = new TimerTask(){
            @Override
            public void run(){
                
                listProcesso.setText("");
                
                var teste = api.getGrupoDeProcessos().getProcessos();
                
                for(int x=0; x<teste.size();x++){
                    
                    listProcesso.setText(listProcesso.getText()+teste.get(x).getNome()+"\n");
                }
            }
        };
        initComponents();
       //AQUI CHAMAMOS AS INFORMAÇÕES DA RAM DE 2 EM 2 SEGUNDOS
        timer.scheduleAtFixedRate(ram, 0, SEGUNDOSRAM);
        //AQUI CHAMAMOS AS INFORMAÇÕES DOS PROCESSOS DE 10 EM 10 SEGUNDOS
        timer.scheduleAtFixedRate(processos, 0, SEGUNDOSPROCESS);
        //AQUI CHAMAMOS AS INFORMAÇÕES DO DISCO DE 2 EM 2 SEGUNDOS
        timer.scheduleAtFixedRate(disco, 0, SEGUNDOSDISCOS);
        //AQUI CHAMAMOS AS INFORMAÇÕES DA CPU DE 3 EM 3 SEGUNDOS
        timer.scheduleAtFixedRate(cpu, 0, SEGUNDOSCPU);
       
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelCpu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTempo = new javax.swing.JLabel();
        lblUso = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblFrequencia = new javax.swing.JLabel();
        PanelRam = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblRamUso = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblTotalRam = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblRamDisponivel = new javax.swing.JLabel();
        PanelProcessos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProcesso = new javax.swing.JTextArea();
        PanelDisco = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblDiscoUso = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblTotalDisco = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblDiscoDisponivel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Olá, Usuário");

        PanelCpu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240), 2));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("CPU: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Em uso:");

        lbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl.setText("Velocidade Base");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Tempo atividade");

        lblTempo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTempo.setText("00:00:00");

        lblUso.setText("0,0");

        jLabel17.setText("%");

        lblFrequencia.setText("0.0 %");

        javax.swing.GroupLayout PanelCpuLayout = new javax.swing.GroupLayout(PanelCpu);
        PanelCpu.setLayout(PanelCpuLayout);
        PanelCpuLayout.setHorizontalGroup(
            PanelCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCpuLayout.createSequentialGroup()
                .addGroup(PanelCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCpuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(PanelCpuLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(PanelCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(lblTempo)
                            .addGroup(PanelCpuLayout.createSequentialGroup()
                                .addGroup(PanelCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelCpuLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblUso)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(lblFrequencia))))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        PanelCpuLayout.setVerticalGroup(
            PanelCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCpuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblUso)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl)
                    .addComponent(lblFrequencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTempo)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        PanelRam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240), 2));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("RAM: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Em uso: ");

        lblRamUso.setText("0,0");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Total:");

        lblTotalRam.setText("0,0");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Disponível:");

        lblRamDisponivel.setText("0,0");

        javax.swing.GroupLayout PanelRamLayout = new javax.swing.GroupLayout(PanelRam);
        PanelRam.setLayout(PanelRamLayout);
        PanelRamLayout.setHorizontalGroup(
            PanelRamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRamLayout.createSequentialGroup()
                .addGroup(PanelRamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(PanelRamLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotalRam))
                    .addGroup(PanelRamLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(PanelRamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRamLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRamUso))
                            .addGroup(PanelRamLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRamDisponivel)))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        PanelRamLayout.setVerticalGroup(
            PanelRamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(13, 13, 13)
                .addGroup(PanelRamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRamUso)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(PanelRamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalRam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRamDisponivel))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        PanelProcessos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240), 2));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Processos:");

        listProcesso.setColumns(20);
        listProcesso.setRows(5);
        jScrollPane1.setViewportView(listProcesso);

        javax.swing.GroupLayout PanelProcessosLayout = new javax.swing.GroupLayout(PanelProcessos);
        PanelProcessos.setLayout(PanelProcessosLayout);
        PanelProcessosLayout.setHorizontalGroup(
            PanelProcessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProcessosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelProcessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(PanelProcessosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelProcessosLayout.setVerticalGroup(
            PanelProcessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProcessosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelDisco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240), 2));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Disco:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Em uso: ");

        lblDiscoUso.setText("0,0");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Total:");

        lblTotalDisco.setText("0,0");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Disponível:");

        lblDiscoDisponivel.setText("0,0");

        javax.swing.GroupLayout PanelDiscoLayout = new javax.swing.GroupLayout(PanelDisco);
        PanelDisco.setLayout(PanelDiscoLayout);
        PanelDiscoLayout.setHorizontalGroup(
            PanelDiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDiscoLayout.createSequentialGroup()
                .addGroup(PanelDiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDiscoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDiscoLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(PanelDiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel21)
                            .addComponent(jLabel11))
                        .addGap(6, 6, 6)))
                .addGroup(PanelDiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDiscoUso, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(lblTotalDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDiscoDisponivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        PanelDiscoLayout.setVerticalGroup(
            PanelDiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDiscoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addGroup(PanelDiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDiscoUso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalDisco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelDiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDiscoDisponivel))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelCpu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanelProcessos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanelRam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelCpu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelRam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelProcessos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
                 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCpu;
    private javax.swing.JPanel PanelDisco;
    private javax.swing.JPanel PanelProcessos;
    private javax.swing.JPanel PanelRam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblDiscoDisponivel;
    private javax.swing.JLabel lblDiscoUso;
    private javax.swing.JLabel lblFrequencia;
    private javax.swing.JLabel lblRamDisponivel;
    private javax.swing.JLabel lblRamUso;
    private javax.swing.JLabel lblTempo;
    private javax.swing.JLabel lblTotalDisco;
    private javax.swing.JLabel lblTotalRam;
    private javax.swing.JLabel lblUso;
    private javax.swing.JTextArea listProcesso;
    // End of variables declaration//GEN-END:variables

}
