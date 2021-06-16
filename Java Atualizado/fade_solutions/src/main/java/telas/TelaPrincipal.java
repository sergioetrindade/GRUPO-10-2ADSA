
package telas;

import com.github.britooo.looca.api.core.Looca;
import conecaoBanco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import oshi.util.FormatUtil;
import funcionalidades.UsuarioValidacao;
import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {

    
    //Aqui Criamos nossos Objetos de cada classe
    Login login = new Login();
    Looca api = new Looca();
    Timer timer = new Timer();
    

    private Connection conectoryFactory;

    //Quantos Segundos a RAM vai atualizar(2s)
    final long SEGUNDOSRAM = (1000 * 2);
    //Quantos Segundos os PROCESSOS vão atualizar(10s)
    final long SEGUNDOSPROCESS = (1000 * 10);
    //Quantos Segundos os DISCOS vão atualizar(2s)
    final long SEGUNDOSDISCOS = (1000 * 2);
    //Quantos Segundos a CPU vai atualizar (3s)
    final long SEGUNDOSCPU = (1000 * 3);    
    
    final long SEGUNDOSNR17 = (1000 * 3);


    TimerTask envioApi = new TimerTask() {
        @Override
        public void run() {
            PreparedStatement stn = null;
            String insertQuery = String.format("INSERT INTO registro (cpu1, disco, memoria, dataHora, idMaquina) values ('%s', %d, %d, getdate(), 1)", api.getProcessador().getUso().toString().replaceAll(",", "."), api.getGrupoDeDiscos().getTamanhoTotal(), api.getMemoria().getEmUso());
            try {
                stn = conectoryFactory.prepareStatement(insertQuery);
                stn.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    //AQUI RODAMOS AS INFORMAÇÕES DA RAM
    TimerTask ram = new TimerTask() {
        @Override
        public void run() {
            var memoriaEmUso = (FormatUtil.formatBytes(api.getMemoria().getEmUso()));
            var memoriaTotal = (FormatUtil.formatBytes(api.getMemoria().getTotal()));
            var memoriaDisponivel = (FormatUtil.formatBytes(api.getMemoria().getDisponivel()));

            lblRamUso.setText(memoriaEmUso);
            lblTotalRam.setText(memoriaTotal);
            lblRamDisponivel.setText(memoriaDisponivel);

        }
    };

    //AQUI RODAMOS AS INFORMAÇÕES DOS PROCESSOS
    TimerTask processos = new TimerTask() {
        @Override
        public void run() {

            listProcesso.setText("");

            var teste = api.getGrupoDeProcessos().getProcessos();

            for (int x = 0; x < teste.size(); x++) {

                listProcesso.setText(listProcesso.getText() + teste.get(x).getNome() + "\n");
            }
        }
    };

    //AQUI RODAMOS AS INFORMAÇÕES DA DISCO
    TimerTask disco = new TimerTask() {
        @Override
        public void run() {
            var discoEmUso = (FormatUtil.formatBytes(api.getGrupoDeDiscos().getQuantidadeDeDiscos()));
            var discoTotal = (FormatUtil.formatBytes(api.getGrupoDeDiscos().getTamanhoTotal()));
            var discoDisponivel = api.getGrupoDeDiscos().getVolumes();

            for (int x = 0; x < discoDisponivel.size(); x++) {
                lblDiscoDisponivel.setText("");
                lblDiscoDisponivel.setText(String.format("%.1f GiB", new Double(lblDiscoDisponivel.getText() + discoDisponivel.get(x).getDisponivel()) / 1000000000));
            }

            lblTotalDisco.setText(discoTotal);
        }
    };
    //AQUI RODAMOS AS INFORMAÇÕES DA CPU
    TimerTask cpu = new TimerTask() {
        @Override
        public void run() {
            var cpuUso = api.getProcessador().getUso();
            var cpuFrequencia = (FormatUtil.formatHertz(api.getProcessador().getFrequencia()));
            var cpuTempo = (FormatUtil.formatElapsedSecs(api.getSistema().getTempoDeAtividade()));

            lblUso.setText(String.format("%.2f", cpuUso));
            lblFrequencia.setText(cpuFrequencia);
            lblTempo.setText(cpuTempo);
        }
    };
    
   
    //Variavel Global para Reconhecer Usuario no parametro do construtor.
    static String colaborador;
    

    public TelaPrincipal(String usuario) {
        
        initComponents();
        //Aqui Mandamos o usuario que foi digitado na tela de Login
        this.colaborador = usuario;

        Conexao connection = new Conexao();

        try {
            this.conectoryFactory = connection.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
                //AQUI CHAMAMOS AS INFORMAÇÕES DA RAM DE 2 EM 2 SEGUNDOS
        //AQUI CHAMAMOS AS INFORMAÇÕES DA RAM DE 2 EM 2 SEGUNDOS
        timer.scheduleAtFixedRate(ram, 0, SEGUNDOSRAM);
        //AQUI CHAMAMOS AS INFORMAÇÕES DOS PROCESSOS DE 10 EM 10 SEGUNDOS
        timer.scheduleAtFixedRate(processos, 0, SEGUNDOSPROCESS);
        //AQUI CHAMAMOS AS INFORMAÇÕES DO DISCO DE 2 EM 2 SEGUNDOS
        timer.scheduleAtFixedRate(disco, 0, SEGUNDOSDISCOS);
        //AQUI CHAMAMOS AS INFORMAÇÕES DA CPU DE 3 EM 3 SEGUNDOS
        timer.scheduleAtFixedRate(cpu, 0, SEGUNDOSCPU);
        //AQUI CHAMAMOS AS INFORMAÇÕES DA CPU DE 0 EM 10 SEGUNDOS
        timer.scheduleAtFixedRate(envioApi, 0, 10000);
    }

    TelaPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
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
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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
                .addContainerGap(117, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(23, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fade.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(PanelCpu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanelDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanelRam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(PanelProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(PanelCpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PanelRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PanelProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(PanelDisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(67, 67, 67))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal(colaborador).setVisible(true);
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
