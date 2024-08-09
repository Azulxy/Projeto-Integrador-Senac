package br.com.PI2.controller;

import br.com.PI2.view.HomeView;
import br.com.PI2.view.CantinaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jvazu
 */
public class CantinaController {

    private CantinaView view;

    public CantinaController(CantinaView view) {
        this.view = view;
        this.view.setVisible(true);
        this.view.getJButtonCantinaVoltar().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            voltarParaHome();
     }
});

    }

    private void voltarParaHome() {
        view.dispose();
        HomeView homeView = new HomeView();
        homeView.setVisible(true);
    }

}
