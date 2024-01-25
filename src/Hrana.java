/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package atginput;

/**
 *
 * @author Maroš
 */
public class Hrana {

    private int vrcholZ;
    private int vrcholDo;
    private int cena;

    public Hrana(int vrcholZ, int vrcholDo, int cena) {
        this.vrcholZ = vrcholZ;
        this.vrcholDo = vrcholDo;
        this.cena = cena;
    }

    public Hrana(int vrcholZ, int vrcholDo) {
        this.vrcholZ = vrcholZ;
        this.vrcholDo = vrcholDo;
    }

    public int getVrcholZ() {
        return vrcholZ;
    }

    public int getVrcholDo() {
        return vrcholDo;
    }

    public int getCena() {
        return cena;
    }

}
