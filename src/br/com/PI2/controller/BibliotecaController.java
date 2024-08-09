package br.com.PI2.controller;

import br.com.PI2.view.BibliotecaView;
import br.com.PI2.view.HomeView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BibliotecaController {

    private final BibliotecaView view;

    public BibliotecaController(BibliotecaView view) {
        this.view = view;
        this.view.setVisible(true);
        // Add listener to the button responsible for going back (replace with the appropriate button name)
        this.view.getJButtonVoltar().addActionListener(e -> voltarParaHome());
    }

    private void voltarParaHome() {
        view.dispose();
        HomeView homeView = new HomeView();
        homeView.setVisible(true);
    }
}
