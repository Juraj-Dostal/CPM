import java.util.ArrayList;

//Metody casoveho planovania
public class CPM {

    private int pocetVrcholov;
    private ArrayList<Integer> zoznamSmernikov;
    private ArrayList<Hrana> zoznamHran;
    private ArrayList<Integer> monotonneOcislovanie;
    private int[] trvanieCinnosti;
    private int[] z;
    private int[] x;
    private int[] k;
    private int[] y;
    private int[] R;
    private int trvanieProjektu;


    public CPM(Input input,String suborTrvanieCinnosti) {
        this.pocetVrcholov = input.getPocetVrchol();
        this.zoznamHran = input.getZoznamHran();
        this.zoznamSmernikov = input.getSmernikVrcholov();

        this.trvanieCinnosti = input.nacitajTrvaniaCinnosti(suborTrvanieCinnosti, this.pocetVrcholov);

        this.monotonneOcislovanie = new ArrayList<>();
        this.z = new int[this.pocetVrcholov + 1];
        this.x = new int[this.pocetVrcholov + 1];
        this.k = new int[this.pocetVrcholov + 1];
        this.y = new int[this.pocetVrcholov + 1];
        this.R = new int[this.pocetVrcholov + 1];

        this.monotonneOcislujVrcholy();
        this.najskorMoznyZaciatok();
        this.najneskorNutnyKoniec();
        this.vypocitajRezervu();
        this.vypis();

    }

    public void monotonneOcislujVrcholy() {

        int d[] = new int[this.pocetVrcholov + 1];
        for (var aktualny : this.zoznamHran) {
            d[aktualny.getVrcholDo()] += 1;
        }

        while(this.monotonneOcislovanie.size() < this.pocetVrcholov ) {
            var vrchol = new ArrayList<Integer>();

            for (int v = 1; v < d.length; v++){
                if (d[v] == 0){
                    d[v] = -1;
                    vrchol.add(v);
                }
            }
            if (vrchol.isEmpty()){
                System.out.println("Neexistuje monotonne ocislovanie.");
                return;
            }
            for (var aktualny : vrchol) {

                this.monotonneOcislovanie.add(aktualny);

                for (int i = this.zoznamSmernikov.get(aktualny); i < this.zoznamSmernikov.get(aktualny + 1); i++) {
                    var hrana = this.zoznamHran.get(i);
                    d[hrana.getVrcholDo()] -= 1;
                }
            }
        }
    }

    public void najskorMoznyZaciatok() {
        int r = 0;
        for (var aktualne : this.monotonneOcislovanie) {
            r = aktualne;
            for (int i = this.zoznamSmernikov.get(r); i < this.zoznamSmernikov.get(r + 1); i++) {
                int j = this.zoznamHran.get(i).getVrcholDo();
                if(this.z[j] < this.z[r] + this.trvanieCinnosti[r]) {
                    this.z[j] = this.z[r] + this.trvanieCinnosti[r];
                    this.x[j] = r;
                }
            }
        }

        this.trvanieProjektu = this.z[r] + this.trvanieCinnosti[r];

    }

    public void najneskorNutnyKoniec() {
        for (int i = 1; i < this.k.length; i++){
            this.k[i] = this.trvanieProjektu;
        }

        for (int a = this.monotonneOcislovanie.size() - 2; a >= 0; a--){
            var r = this.monotonneOcislovanie.get(a);
            for (int i = this.zoznamSmernikov.get(r); i < this.zoznamSmernikov.get(r + 1); i++) {
                int j = this.zoznamHran.get(i).getVrcholDo();
                if(this.k[r] > this.k[j] - this.trvanieCinnosti[j]) {
                    this.k[r] = this.k[j] - this.trvanieCinnosti[j];
                    this.x[r] = j;
                }
            }
        }
    }

    public void vypocitajRezervu() {
        for (int i = 1; i < this.R.length; i++) {
            this.R[i] = k[i] - z[i] - this.trvanieCinnosti[i];
        }
    }

    public void vypis() {
        var sb = new StringBuilder();
        sb.append(String.format("%5s | %7s | %7s | %7s | %7s\n", "v", "t(v)", "z(v)", "k(v)", "R(v)"));
        for (var aktualny : this.monotonneOcislovanie) {
            sb.append(String.format("%5d | %7d | %7d | %7d | %7d \n", aktualny, this.trvanieCinnosti[aktualny], this.z[aktualny],
                    this.k[aktualny], this.R[aktualny]));
        }

        System.out.println(sb.toString());
        System.out.println("Doba trvania projektu: " + this.trvanieProjektu);
        System.out.print("Kriticka cesta: ");
        for (var aktualny : this.monotonneOcislovanie) {
            if (this.R[aktualny] == 0) {
                System.out.print(aktualny + " -> ");
            }
        }
    }

}
