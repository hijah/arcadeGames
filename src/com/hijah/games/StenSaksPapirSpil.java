package com.hijah.games;

import com.hijah.model.Computer;
import com.hijah.model.Player;
import com.hijah.utility.StenSaksPapir;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StenSaksPapirSpil {
    int antalSpil;
    String valg;
    
    public void start(){
        Scanner input = new Scanner(System.in);
        Player player = new Player();
        Computer computer = new Computer();
        System.out.println("Velkommen til Sten, Saks, Papir" + "\n" + "Vælg hvor mange runder du vil spille");

        AntalSpil();
        for (int i = 0; i < antalSpil ; i++) {
            System.out.println("Runde " + (i+1));
            spillersValg(input, player);
            computer.RandomValg();
            System.out.println("Computeren har valg: " + computer.getValg().name());
            findVinder(player, computer);
            System.out.println("Det står: Computer " + computer.getScore() + " Dig " + player.getScore());
        }

    }

    private void AntalSpil() {
        Scanner input = new Scanner(System.in);
        try {
            antalSpil = input.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Det indtastede er ikke et tal prøv igen");
            AntalSpil();
        }
    }

    private void findVinder(Player player, Computer computer) {
        switch (player.getValg()) {
            case Saks:
                switch (computer.getValg()) {
                    case Saks:
                        System.out.println("Spillet blev uafgjort");
                        break;
                    case Sten:
                        computer.setScore(1);
                        System.out.println("Computeren vandt");
                        break;
                    case Papir:
                        player.setScore(1);
                        System.out.println("Du vandt");
                }
                break;
            case Papir:
                switch (computer.getValg()) {
                    case Papir:
                        System.out.println("Spillet blev uafgjort");
                        break;
                    case Sten:
                        player.setScore(1);
                        System.out.println("Du vandt");
                        break;
                    case Saks:
                        computer.setScore(1);
                        System.out.println("Computeren vandt");
                        break;
                }
                break;
            case Sten:
                switch (computer.getValg()) {
                    case Sten:
                        System.out.println("Spillet blev uafgjort");
                        break;
                    case Saks:
                        player.setScore(1);
                        System.out.println("Du vandt");
                        break;
                    case Papir:
                        computer.setScore(1);
                        System.out.println("Computeren vandt");
                        break;
                }
                break;
        }
    }

    public void spillersValg(Scanner scan, Player player) {
        System.out.println("Du skal nu vælge imellem Sten, Saks og Papir");
        valg = scan.next().toLowerCase();
        if (!valg.equals("sten") && !valg.equals("saks") && !valg.equals("papir")) {
            System.out.println("Dit valg *" + valg + "* er ikke en mulighed");
            spillersValg(scan, player);
        } else {
            player.setValg(valg);
            System.out.println("Du valgte: " + valg);
        }
    }
}
