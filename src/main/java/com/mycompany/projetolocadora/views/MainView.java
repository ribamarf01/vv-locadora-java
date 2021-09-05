/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetolocadora.views;

import com.mycompany.projetolocadora.controller.FilmeController;
import com.mycompany.projetolocadora.controller.PessoaController;
import com.mycompany.projetolocadora.controller.AluguelController;

import com.mycompany.projetolocadora.model.Pessoa;
import com.mycompany.projetolocadora.model.Filme;
import com.mycompany.projetolocadora.model.Aluguel;

import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author 55859
 */
public class MainView extends javax.swing.JFrame {

    static PessoaController bdPessoa;
    static FilmeController bdFilme;
    static AluguelController bdAluguel;

    public MainView() {
        initComponents();
        bdPessoa = new PessoaController();
        bdFilme = new FilmeController();
        bdAluguel = new AluguelController();
        
        atualizaTabelaClientes();
        atualizaTabelaFilmes();
        atualizarTabelaAluguel();
        
    }

    public static void atualizaTabelaClientes() {
        DefaultTableModel tabela = (DefaultTableModel) TabelaClientes.getModel();
        tabela.setNumRows(0);

        ArrayList<Pessoa> pessoas = bdPessoa.listarClientes();

        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa p = pessoas.get(i);
            tabela.addRow(new Object[]{1});
            tabela.setValueAt(p.getId(), i, 0);
            tabela.setValueAt(p.getNomeCompleto(), i, 1);
            tabela.setValueAt(p.getCpf(), i, 2);
            tabela.setValueAt(p.getTelefone(), i, 3);
            tabela.setValueAt(p.getSexo(), i, 4);
            tabela.setValueAt(p.getDataNascimento(), i, 5);
            tabela.setValueAt(p.getEndereco(), i, 6);
            tabela.setValueAt(p.getEmail(), i, 7);
        }

    }

    public static void atualizaTabelaFilmes() {
        DefaultTableModel tabela = (DefaultTableModel) TabelaFilmes.getModel();
        tabela.setNumRows(0);

        ArrayList<Filme> filmes = bdFilme.listarFilmes();

        for (int i = 0; i < filmes.size(); i++) {
            Filme f = filmes.get(i);
            tabela.addRow(new Object[]{1});

            tabela.setValueAt(f.getId(), i, 0);
            tabela.setValueAt(f.getTitulo(), i, 1);
            tabela.setValueAt(f.getDescricao(), i, 2);
            tabela.setValueAt(f.getGenero(), i, 3);
            tabela.setValueAt(f.getAno(), i, 4);
            tabela.setValueAt(f.getDuracao(), i, 5);
            tabela.setValueAt(f.getDiretor(), i, 6);
            tabela.setValueAt(f.getEstudio(), i, 7);

        }
        
    }
    
    public static void atualizarTabelaAluguel() {
        DefaultTableModel tabela = (DefaultTableModel) TabelaAluguel.getModel();
        tabela.setNumRows(0);
        
        ArrayList<Aluguel> alugueis = bdAluguel.listarAlugueis();
        
        for(int i = 0; i < alugueis.size(); i++) {
            Aluguel a = alugueis.get(i);
            tabela.addRow(new Object[]{1});
            
            tabela.setValueAt(a.getId(), i, 0);
            tabela.setValueAt(a.getIdPessoa(), i, 1);
            tabela.setValueAt(a.getIdFilme(), i, 2);
            tabela.setValueAt(a.getDataAluguel(), i, 3);
            tabela.setValueAt(a.getDataDevolucao(), i, 4);
            tabela.setValueAt(a.getValorAluguel(), i, 5);
            tabela.setValueAt(a.getValorMulta(), i, 6);
            tabela.setValueAt(a.isEstaPago(), i, 7);
            
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        SplitApp = new javax.swing.JSplitPane();
        SideMenu = new javax.swing.JPanel();
        HomeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ClienteOptions = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        FilmesOptions = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        AluguelOptions = new javax.swing.JButton();
        RouterView = new javax.swing.JPanel();
        HomePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ClientesPanel = new javax.swing.JPanel();
        ClientesHeader = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnNovoCliente = new javax.swing.JButton();
        btnAtualizarCliente = new javax.swing.JButton();
        btnExcluirCliente = new javax.swing.JButton();
        ClientesRight = new javax.swing.JPanel();
        ClientesLeft = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaClientes = new javax.swing.JTable();
        ClientesBottom = new javax.swing.JPanel();
        FilmesPanel = new javax.swing.JPanel();
        FilmesHeader = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnNovoFilme = new javax.swing.JButton();
        btnAtualizarFilme = new javax.swing.JButton();
        btnExcluirFilme = new javax.swing.JButton();
        btnAlugarFilme = new javax.swing.JButton();
        FilmesRight = new javax.swing.JPanel();
        FilmesLeft = new javax.swing.JPanel();
        FilmesBottom = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaFilmes = new javax.swing.JTable();
        AlugueisPanel = new javax.swing.JPanel();
        AlguelHeader = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnQuitarAluguel = new javax.swing.JButton();
        FilmesRight1 = new javax.swing.JPanel();
        FilmesLeft1 = new javax.swing.JPanel();
        FilmesBottom1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaAluguel = new javax.swing.JTable();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Locadora de Filmes!");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(800, 500));

        SplitApp.setDividerLocation(150);

        SideMenu.setBackground(new java.awt.Color(45, 52, 54));
        SideMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SideMenu.setLayout(new java.awt.GridLayout(10, 1, 1, 0));

        HomeButton.setBackground(new java.awt.Color(45, 52, 54));
        HomeButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        HomeButton.setForeground(new java.awt.Color(255, 255, 255));
        HomeButton.setText("Locadora");
        HomeButton.setBorderPainted(false);
        HomeButton.setFocusPainted(false);
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });
        SideMenu.add(HomeButton);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(42, 14));
        jLabel1.setMinimumSize(new java.awt.Dimension(42, 14));
        jLabel1.setPreferredSize(new java.awt.Dimension(42, 14));
        SideMenu.add(jLabel1);

        ClienteOptions.setBackground(new java.awt.Color(99, 110, 114));
        ClienteOptions.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ClienteOptions.setForeground(new java.awt.Color(255, 255, 255));
        ClienteOptions.setText("Clientes");
        ClienteOptions.setBorderPainted(false);
        ClienteOptions.setFocusPainted(false);
        ClienteOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteOptionsActionPerformed(evt);
            }
        });
        SideMenu.add(ClienteOptions);
        SideMenu.add(jLabel3);

        FilmesOptions.setBackground(new java.awt.Color(99, 110, 114));
        FilmesOptions.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FilmesOptions.setForeground(new java.awt.Color(255, 255, 255));
        FilmesOptions.setText("Filmes");
        FilmesOptions.setBorderPainted(false);
        FilmesOptions.setFocusPainted(false);
        FilmesOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilmesOptionsActionPerformed(evt);
            }
        });
        SideMenu.add(FilmesOptions);
        SideMenu.add(jLabel4);

        AluguelOptions.setBackground(new java.awt.Color(99, 110, 114));
        AluguelOptions.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AluguelOptions.setForeground(new java.awt.Color(255, 255, 255));
        AluguelOptions.setText("Alugueis");
        AluguelOptions.setBorderPainted(false);
        AluguelOptions.setFocusPainted(false);
        AluguelOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AluguelOptionsActionPerformed(evt);
            }
        });
        SideMenu.add(AluguelOptions);

        SplitApp.setLeftComponent(SideMenu);

        RouterView.setBackground(new java.awt.Color(178, 190, 195));
        RouterView.setLayout(new java.awt.CardLayout());

        HomePanel.setBackground(new java.awt.Color(53, 59, 72));

        jLabel2.setBackground(new java.awt.Color(223, 230, 233));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bem vindo ao sistema de locadora, explore um pouco apertando nos botões a esquerda!");

        javax.swing.GroupLayout HomePanelLayout = new javax.swing.GroupLayout(HomePanel);
        HomePanel.setLayout(HomePanelLayout);
        HomePanelLayout.setHorizontalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                .addContainerGap())
        );
        HomePanelLayout.setVerticalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );

        RouterView.add(HomePanel, "card2");

        ClientesPanel.setBackground(new java.awt.Color(53, 59, 72));
        ClientesPanel.setLayout(new java.awt.BorderLayout());

        ClientesHeader.setBackground(new java.awt.Color(53, 59, 72));
        ClientesHeader.setMinimumSize(new java.awt.Dimension(50, 100));
        ClientesHeader.setPreferredSize(new java.awt.Dimension(644, 80));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Clientes:");

        btnNovoCliente.setText("Novo");
        btnNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoClienteActionPerformed(evt);
            }
        });

        btnAtualizarCliente.setText("Alterar");
        btnAtualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarClienteActionPerformed(evt);
            }
        });

        btnExcluirCliente.setText("Remover");
        btnExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ClientesHeaderLayout = new javax.swing.GroupLayout(ClientesHeader);
        ClientesHeader.setLayout(ClientesHeaderLayout);
        ClientesHeaderLayout.setHorizontalGroup(
            ClientesHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientesHeaderLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(ClientesHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(ClientesHeaderLayout.createSequentialGroup()
                        .addComponent(btnNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        ClientesHeaderLayout.setVerticalGroup(
            ClientesHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientesHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(ClientesHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoCliente)
                    .addComponent(btnAtualizarCliente)
                    .addComponent(btnExcluirCliente))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        ClientesPanel.add(ClientesHeader, java.awt.BorderLayout.PAGE_START);

        ClientesRight.setBackground(new java.awt.Color(53, 59, 72));
        ClientesRight.setPreferredSize(new java.awt.Dimension(50, 418));

        javax.swing.GroupLayout ClientesRightLayout = new javax.swing.GroupLayout(ClientesRight);
        ClientesRight.setLayout(ClientesRightLayout);
        ClientesRightLayout.setHorizontalGroup(
            ClientesRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        ClientesRightLayout.setVerticalGroup(
            ClientesRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        ClientesPanel.add(ClientesRight, java.awt.BorderLayout.LINE_END);

        ClientesLeft.setBackground(new java.awt.Color(53, 59, 72));
        ClientesLeft.setPreferredSize(new java.awt.Dimension(50, 418));

        javax.swing.GroupLayout ClientesLeftLayout = new javax.swing.GroupLayout(ClientesLeft);
        ClientesLeft.setLayout(ClientesLeftLayout);
        ClientesLeftLayout.setHorizontalGroup(
            ClientesLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        ClientesLeftLayout.setVerticalGroup(
            ClientesLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        ClientesPanel.add(ClientesLeft, java.awt.BorderLayout.LINE_START);

        TabelaClientes.setAutoCreateRowSorter(true);
        TabelaClientes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Telefone", "Sexo", "Data Nasc.", "Endereço", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TabelaClientes);

        ClientesPanel.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        ClientesBottom.setBackground(new java.awt.Color(53, 59, 72));
        ClientesBottom.setPreferredSize(new java.awt.Dimension(644, 20));

        javax.swing.GroupLayout ClientesBottomLayout = new javax.swing.GroupLayout(ClientesBottom);
        ClientesBottom.setLayout(ClientesBottomLayout);
        ClientesBottomLayout.setHorizontalGroup(
            ClientesBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );
        ClientesBottomLayout.setVerticalGroup(
            ClientesBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        ClientesPanel.add(ClientesBottom, java.awt.BorderLayout.PAGE_END);

        RouterView.add(ClientesPanel, "card3");

        FilmesPanel.setBackground(new java.awt.Color(53, 59, 72));
        FilmesPanel.setMinimumSize(new java.awt.Dimension(644, 498));
        FilmesPanel.setLayout(new java.awt.BorderLayout());

        FilmesHeader.setBackground(new java.awt.Color(53, 59, 72));
        FilmesHeader.setPreferredSize(new java.awt.Dimension(644, 80));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Filmes:");

        btnNovoFilme.setText("Novo");
        btnNovoFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoFilmeActionPerformed(evt);
            }
        });

        btnAtualizarFilme.setText("Alterar");
        btnAtualizarFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarFilmeActionPerformed(evt);
            }
        });

        btnExcluirFilme.setText("Remover");
        btnExcluirFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirFilmeActionPerformed(evt);
            }
        });

        btnAlugarFilme.setText("Alugar Filme");
        btnAlugarFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarFilmeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FilmesHeaderLayout = new javax.swing.GroupLayout(FilmesHeader);
        FilmesHeader.setLayout(FilmesHeaderLayout);
        FilmesHeaderLayout.setHorizontalGroup(
            FilmesHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilmesHeaderLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(FilmesHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FilmesHeaderLayout.createSequentialGroup()
                        .addComponent(btnNovoFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlugarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        FilmesHeaderLayout.setVerticalGroup(
            FilmesHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilmesHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(FilmesHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoFilme)
                    .addComponent(btnAtualizarFilme)
                    .addComponent(btnExcluirFilme)
                    .addComponent(btnAlugarFilme))
                .addContainerGap())
        );

        FilmesPanel.add(FilmesHeader, java.awt.BorderLayout.PAGE_START);

        FilmesRight.setBackground(new java.awt.Color(53, 59, 72));
        FilmesRight.setPreferredSize(new java.awt.Dimension(50, 398));

        javax.swing.GroupLayout FilmesRightLayout = new javax.swing.GroupLayout(FilmesRight);
        FilmesRight.setLayout(FilmesRightLayout);
        FilmesRightLayout.setHorizontalGroup(
            FilmesRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        FilmesRightLayout.setVerticalGroup(
            FilmesRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        FilmesPanel.add(FilmesRight, java.awt.BorderLayout.LINE_END);

        FilmesLeft.setBackground(new java.awt.Color(53, 59, 72));
        FilmesLeft.setPreferredSize(new java.awt.Dimension(50, 398));

        javax.swing.GroupLayout FilmesLeftLayout = new javax.swing.GroupLayout(FilmesLeft);
        FilmesLeft.setLayout(FilmesLeftLayout);
        FilmesLeftLayout.setHorizontalGroup(
            FilmesLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        FilmesLeftLayout.setVerticalGroup(
            FilmesLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        FilmesPanel.add(FilmesLeft, java.awt.BorderLayout.LINE_START);

        FilmesBottom.setBackground(new java.awt.Color(53, 59, 72));
        FilmesBottom.setPreferredSize(new java.awt.Dimension(644, 20));

        javax.swing.GroupLayout FilmesBottomLayout = new javax.swing.GroupLayout(FilmesBottom);
        FilmesBottom.setLayout(FilmesBottomLayout);
        FilmesBottomLayout.setHorizontalGroup(
            FilmesBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );
        FilmesBottomLayout.setVerticalGroup(
            FilmesBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        FilmesPanel.add(FilmesBottom, java.awt.BorderLayout.PAGE_END);

        TabelaFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Descrição", "Gênero", "Ano", "Duração (Min)", "Diretor", "Estúdio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelaFilmes);

        FilmesPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        RouterView.add(FilmesPanel, "card4");

        AlugueisPanel.setBackground(new java.awt.Color(53, 59, 72));
        AlugueisPanel.setLayout(new java.awt.BorderLayout());

        AlguelHeader.setBackground(new java.awt.Color(53, 59, 72));
        AlguelHeader.setPreferredSize(new java.awt.Dimension(644, 80));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Alugueis:");

        btnQuitarAluguel.setText("Quitar Aluguel");
        btnQuitarAluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarAluguelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AlguelHeaderLayout = new javax.swing.GroupLayout(AlguelHeader);
        AlguelHeader.setLayout(AlguelHeaderLayout);
        AlguelHeaderLayout.setHorizontalGroup(
            AlguelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AlguelHeaderLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(AlguelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AlguelHeaderLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(525, Short.MAX_VALUE))
                    .addGroup(AlguelHeaderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnQuitarAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );
        AlguelHeaderLayout.setVerticalGroup(
            AlguelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AlguelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnQuitarAluguel)
                .addContainerGap())
        );

        AlugueisPanel.add(AlguelHeader, java.awt.BorderLayout.PAGE_START);

        FilmesRight1.setBackground(new java.awt.Color(53, 59, 72));
        FilmesRight1.setPreferredSize(new java.awt.Dimension(50, 398));

        javax.swing.GroupLayout FilmesRight1Layout = new javax.swing.GroupLayout(FilmesRight1);
        FilmesRight1.setLayout(FilmesRight1Layout);
        FilmesRight1Layout.setHorizontalGroup(
            FilmesRight1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        FilmesRight1Layout.setVerticalGroup(
            FilmesRight1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        AlugueisPanel.add(FilmesRight1, java.awt.BorderLayout.LINE_END);

        FilmesLeft1.setBackground(new java.awt.Color(53, 59, 72));
        FilmesLeft1.setPreferredSize(new java.awt.Dimension(50, 398));

        javax.swing.GroupLayout FilmesLeft1Layout = new javax.swing.GroupLayout(FilmesLeft1);
        FilmesLeft1.setLayout(FilmesLeft1Layout);
        FilmesLeft1Layout.setHorizontalGroup(
            FilmesLeft1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        FilmesLeft1Layout.setVerticalGroup(
            FilmesLeft1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        AlugueisPanel.add(FilmesLeft1, java.awt.BorderLayout.LINE_START);

        FilmesBottom1.setBackground(new java.awt.Color(53, 59, 72));
        FilmesBottom1.setPreferredSize(new java.awt.Dimension(644, 20));

        javax.swing.GroupLayout FilmesBottom1Layout = new javax.swing.GroupLayout(FilmesBottom1);
        FilmesBottom1.setLayout(FilmesBottom1Layout);
        FilmesBottom1Layout.setHorizontalGroup(
            FilmesBottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );
        FilmesBottom1Layout.setVerticalGroup(
            FilmesBottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        AlugueisPanel.add(FilmesBottom1, java.awt.BorderLayout.PAGE_END);

        TabelaAluguel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID Cliente", "ID Filme", "Aluguel", "Devolução", "Valor", "Multa", "Pago?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TabelaAluguel);

        AlugueisPanel.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        RouterView.add(AlugueisPanel, "card5");

        SplitApp.setRightComponent(RouterView);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SplitApp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SplitApp, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ClienteOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteOptionsActionPerformed
        RouterView.removeAll();
        RouterView.add(ClientesPanel);
        RouterView.repaint();
        RouterView.revalidate();
        atualizaTabelaClientes();

    }//GEN-LAST:event_ClienteOptionsActionPerformed

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        RouterView.removeAll();
        RouterView.add(HomePanel);
        RouterView.repaint();
        RouterView.revalidate();
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void FilmesOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilmesOptionsActionPerformed
        RouterView.removeAll();
        RouterView.add(FilmesPanel);
        RouterView.repaint();
        RouterView.revalidate();
    }//GEN-LAST:event_FilmesOptionsActionPerformed

    private void AluguelOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AluguelOptionsActionPerformed
        RouterView.removeAll();
        RouterView.add(AlugueisPanel);
        RouterView.repaint();
        RouterView.revalidate();
    }//GEN-LAST:event_AluguelOptionsActionPerformed

    private void btnNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoClienteActionPerformed
        JFrame janela = new NovoCliente();
        janela.setVisible(true);
    }//GEN-LAST:event_btnNovoClienteActionPerformed

    private void btnAtualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarClienteActionPerformed
        int linha = TabelaClientes.getSelectedRow();

        if (linha >= 0) {
            JFrame janela = new AtualizarCliente(linha);
            janela.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente da lista", "Cliente", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAtualizarClienteActionPerformed

    private void btnExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirClienteActionPerformed
        int linha = TabelaClientes.getSelectedRow();

        if (linha >= 0) {
            int res = JOptionPane.showConfirmDialog(this, "Deseja remover este cliente?");
            if (res == JOptionPane.YES_OPTION) {
                Pessoa p = bdPessoa.listarClientes().get(linha);
                bdPessoa.excluirCliente(p);

                atualizaTabelaClientes();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente da lista", "Cliente", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirClienteActionPerformed

    private void btnNovoFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoFilmeActionPerformed
        JFrame janela = new NovoFilme();
        janela.setVisible(true);
    }//GEN-LAST:event_btnNovoFilmeActionPerformed

    private void btnAtualizarFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarFilmeActionPerformed
        int linha = TabelaFilmes.getSelectedRow();

        if (linha >= 0) {
            JFrame janela = new AtualizarFilme(linha);
            janela.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um filme da lista", "Cliente", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAtualizarFilmeActionPerformed

    private void btnExcluirFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirFilmeActionPerformed
        int linha = TabelaFilmes.getSelectedRow();

        if (linha >= 0) {
            int res = JOptionPane.showConfirmDialog(this, "Deseja excluir esse filme?");
            if (res == JOptionPane.YES_OPTION) {
                Filme f = bdFilme.listarFilmes().get(linha);
                bdFilme.excluirFilme(f);

                atualizaTabelaFilmes();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um filme da lista", "Cliente", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirFilmeActionPerformed

    private void btnQuitarAluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarAluguelActionPerformed
        int linha = TabelaAluguel.getSelectedRow();
        
        if(linha >= 0) {
            
            Aluguel a = bdAluguel.listarAlugueis().get(linha);          
            
            if(!a.isEstaPago()) {
                bdAluguel.calcularMulta(a);
                int res;
                if(a.getValorMulta() == 0) {
                    res = JOptionPane.showConfirmDialog(this, "Deseja quitar esse aluguel? \nValor: " + a.getValorAluguel());
                } else {
                    res = JOptionPane.showConfirmDialog(this, "Deseja quitar esse aluguel? \nValor: " 
                            + a.getValorAluguel() + "\nMulta: " + a.getValorMulta() + "\nTotal: " 
                            + a.getValorMulta() + a.getValorAluguel());
                }
                
                if(res == JOptionPane.YES_OPTION) {
                    bdAluguel.quitarAluguel(a);
                    atualizarTabelaAluguel();
                }
                
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um aluguel da lista!", "Aluguel", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnQuitarAluguelActionPerformed

    private void btnAlugarFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarFilmeActionPerformed
        int linha = TabelaFilmes.getSelectedRow();
        
        if(linha >= 0) {
            JFrame janela = new TelaAluguel(linha);
            janela.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma filme da lista", "Aluguel", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAlugarFilmeActionPerformed

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AlguelHeader;
    private javax.swing.JPanel AlugueisPanel;
    private javax.swing.JButton AluguelOptions;
    private javax.swing.JButton ClienteOptions;
    private javax.swing.JPanel ClientesBottom;
    private javax.swing.JPanel ClientesHeader;
    private javax.swing.JPanel ClientesLeft;
    private javax.swing.JPanel ClientesPanel;
    private javax.swing.JPanel ClientesRight;
    private javax.swing.JPanel FilmesBottom;
    private javax.swing.JPanel FilmesBottom1;
    private javax.swing.JPanel FilmesHeader;
    private javax.swing.JPanel FilmesLeft;
    private javax.swing.JPanel FilmesLeft1;
    private javax.swing.JButton FilmesOptions;
    private javax.swing.JPanel FilmesPanel;
    private javax.swing.JPanel FilmesRight;
    private javax.swing.JPanel FilmesRight1;
    private javax.swing.JButton HomeButton;
    private javax.swing.JPanel HomePanel;
    private javax.swing.JPanel RouterView;
    private javax.swing.JPanel SideMenu;
    private javax.swing.JSplitPane SplitApp;
    private static javax.swing.JTable TabelaAluguel;
    private static javax.swing.JTable TabelaClientes;
    private static javax.swing.JTable TabelaFilmes;
    private javax.swing.JButton btnAlugarFilme;
    private javax.swing.JButton btnAtualizarCliente;
    private javax.swing.JButton btnAtualizarFilme;
    private javax.swing.JButton btnExcluirCliente;
    private javax.swing.JButton btnExcluirFilme;
    private javax.swing.JButton btnNovoCliente;
    private javax.swing.JButton btnNovoFilme;
    private javax.swing.JButton btnQuitarAluguel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
