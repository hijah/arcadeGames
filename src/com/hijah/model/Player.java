package com.hijah.model;

import com.hijah.utility.StenSaksPapir;

public class Player {
    int score = 0;
    StenSaksPapir valg;

    public Player() {
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

    public void setValg(String valg) {
        switch (valg) {
            case "sten":
                this.valg = StenSaksPapir.Sten;
            case "papir":
                this.valg = StenSaksPapir.Papir;
            case "saks":
                this.valg = StenSaksPapir.Saks;
        }
    }
}
