package com.selenium.test.utils;

import java.util.Timer;
import java.util.TimerTask;

public class Chronometre {
    public  void begin() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int seconds = 30;

            @Override
            public void run() {
                if (seconds >= 0) {
                    System.out.println("Temps restant : " + seconds + " secondes");
                    seconds--;
                } else {
                    timer.cancel();
                    System.out.println("Chronomètre terminé !");
                }
            }
        };

        // Planifiez la tâche pour qu'elle s'exécute toutes les secondes
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
