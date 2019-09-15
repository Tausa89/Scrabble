package pl.scrabbleproject.game;

import lombok.Getter;

public class Letters {

    private @Getter
    char letter;
    private @Getter
    int pointsForLetter;

    public Letters() {
    }

    public Letters(char letter) {
        this.letter = letter;
        this.pointsForLetter = 1;//TODO automatically get it from somewhere
    }

    public Letters(char letter, int pointsForLetter) {
        this.letter = letter;
        this.pointsForLetter = pointsForLetter;
    }

    @Override
    public String toString() {
        return "" + letter;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Letters)) return false;
        final Letters other = (Letters) o;
        if (!other.canEqual(this)) return false;
        return this.letter == other.letter;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.letter;
        result = result * PRIME + this.pointsForLetter;
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Letters;
    }


    //    public List<Letters> lettersList(){
//
//        List<Letters> lettersList = new ArrayList<>();
//        Letters a= new Letters('A', 1);
//        lettersList.add(a);
//        Letters b = new Letters('B',3);
//        lettersList.add(b);
//        Letters c = new Letters('C',2);
//        lettersList.add(c);
//        Letters d = new Letters('D',2);
//        lettersList.add(d);
//        Letters e = new Letters('E',1);
//        lettersList.add(e);
//        Letters f = new Letters('F',2);
//        lettersList.add(f);
//        Letters g = new Letters('G',3);
//        lettersList.add(g);
//        Letters h = new Letters('H',3);
//        lettersList.add(h);
//        Letters i = new Letters('I',1);
//        lettersList.add(i);
//        Letters j = new Letters('J',3);
//        lettersList.add(j);
//        Letters k = new Letters('K',2);
//        lettersList.add(k);
//        Letters l = new Letters('L',2);
//        lettersList.add(l);
//        Letters m = new Letters('M',2);
//        lettersList.add(m);
//        Letters n = new Letters('N',1);
//        lettersList.add(n);
//        Letters o = new Letters('O',1);
//        lettersList.add(o);
//        Letters p = new Letters('P',2);
//        lettersList.add(p);
//        Letters r = new Letters('R',1);
//        lettersList.add(r);
//        Letters s = new Letters('S',1);
//        lettersList.add(s);
//        Letters t = new Letters('T',2);
//        lettersList.add(t);
//        Letters u = new Letters('U',3);
//        lettersList.add(u);
//        Letters w = new Letters('W',1);
//        lettersList.add(w);
//        Letters y = new Letters('Y',2);
//        lettersList.add(y);
//        Letters z = new Letters('Z',1);
//        lettersList.add(z);
//
//
//
//        return lettersList;
//    }

}
