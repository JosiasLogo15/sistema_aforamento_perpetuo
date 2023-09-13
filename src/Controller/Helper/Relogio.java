package Controller.Helper;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.Timer;

public class Relogio {
    private JTextField campoHora;
    private SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    private Timer timer;

    public Relogio(JTextField campoHora) {
        this.campoHora = campoHora;
        this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarHora();
            }
        });
        timer.start();
    }

    private void atualizarHora() {
        Date agora = new Date();
        String horaFormatada = formatoHora.format(agora);
        campoHora.setText(horaFormatada);
    }
}