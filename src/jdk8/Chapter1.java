/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdk8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 *
 * @author John
 */
public class Chapter1 {

    public static void main(String[] args) {

    }

    public static void learning() {
        System.err.println("START");
        Button button = new Button();

        // without lambda
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Thanks for clicking!");
            }
        });

        // with type definitikon
        EventHandler<ActionEvent> eventHandler2 = (ActionEvent event) -> {
            System.err.println(event.getSource());
        };

        // with type interfering only one input argument
        EventHandler<ActionEvent> eventHandler3 = event -> {
            System.err.println(event.getSource());
        };

        button.setOnAction(eventHandler2);

        // with lambda contracted
        button.setOnAction((ActionEvent event) -> {
            event.getSource();
            System.out.println("Thanks for clicking!");
        });

        Runnable runnable = () -> {
            throw new UnsupportedOperationException("Not supported yet.");
        };

        Runnable runnable2 = new Runnable() {

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        Thread t = new Thread(runnable);
        t.start();

        Comparator<String> comp
                = (String first, String second)
                -> Integer.compare(first.length(), second.length());

        Comparator<String> comp2
                = (first, second)
                -> Integer.compare(first.length(), second.length());

        Comparator<String> comp3
                = (first, second)
                -> 0x1;

        Comparator<String> comp4
                = (first, second)
                -> {return 0x1;};
        
        
        Comparator<String> comp5
                = (String first, String second)
                -> { return Integer.compare(first.length(), second.length());
                };
        
        BiFunction<String, String, Integer> compXXX
        = (first, second) -> Integer.compare(first.length(), second.length());
        
        
        String[] words = {"asdsa","adsasd"};
        Arrays.sort(words,comp3);
        
        // ovo ne radi....
        //Arrays.sort(words,compXXX);
        
        
        // mora se catchati checked exception
      //  Runnable sleeper1 = () -> { System.out.println("Zzz"); Thread.sleep(1000); };
        
        
        Runnable sleeper2 = () -> { System.out.println("Zzz"); try {
            Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Chapter1.class.getName()).log(Level.SEVERE, null, ex);
            }
};

    }

    class Worker implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                doWork();
            }
        }

        private void doWork() {
        }
    }

    class LengthComparator implements Comparator<String> {

        @Override
        public int compare(String first, String second) {
            return Integer.compare(first.length(), second.length());
        }
    }

}
