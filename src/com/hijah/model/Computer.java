package com.hijah.model;

import com.hijah.utility.StenSaksPapir;

import java.util.Random;

public class Computer {
    int score = 0;
    StenSaksPapir valg;

    public Computer() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score =+ score;
    }

    public StenSaksPapir getValg() {
        return valg;
    }

    public void setValg(StenSaksPapir valg) {
        this.valg = valg;
    }

    public void RandomValg() {
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        switch (randomNum) {
            case 1:
                setValg(valg.Papir);
            case 2:
                setValg(valg.Sten);
            default:
                setValg(valg.Saks);
        }
    }
}
