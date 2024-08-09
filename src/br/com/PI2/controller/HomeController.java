package br.com.PI2.controller;

import br.com.PI2.view.CantinaView;
import br.com.PI2.view.HomeView;
import br.com.PI2.view.BibliotecaView;

public class HomeController {
    
    private HomeView view;

    public HomeController(HomeView view) {
        this.view = view;
        initListeners();
    }

    private void initListeners() {
        view.getJButtonCantina().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirCantinaView();
            }
        });
        
        view.getJButtonBiblioteca().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirBibliotecaView();
            }
        });
        
        // Adicione aqui os outros listeners conforme necessário
    }

    private void abrirCantinaView() {
        CantinaView cantinaView = new CantinaView();
        cantinaView.setVisible(true);
        view.dispose(); // Fecha a janela atual (HomeView)
    }
    
    private void abrirBibliotecaView() {
        BibliotecaView bibliotecaView = new BibliotecaView();
        bibliotecaView.setVisible(true);
        view.dispose(); // Fecha a janela atual (HomeView)
    }

    // Adicione aqui outros métodos conforme necessário
}
