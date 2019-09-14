package pl.scrabbleproject.game;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ListOfLetters {


    private @Getter
    List<Letters> lettersList;

    public ListOfLetters() {
        this.lettersList = new ArrayList<>();
        lettersList.add(new Letters('A', 1));
        lettersList.add(new Letters('B', 3));
        lettersList.add(new Letters('C', 2));
        //TODO delete rest of unnecessary variables
        Letters d = new Letters('D', 2);
        lettersList.add(d);
        Letters e = new Letters('E', 1);
        lettersList.add(e);
        Letters f = new Letters('F', 2);
        lettersList.add(f);
        Letters g = new Letters('G', 3);
        lettersList.add(g);
        Letters h = new Letters('H', 3);
        lettersList.add(h);
        Letters i = new Letters('I', 1);
        lettersList.add(i);
        Letters j = new Letters('J', 3);
        lettersList.add(j);
        Letters k = new Letters('K', 2);
        lettersList.add(k);
        Letters l = new Letters('L', 2);
        lettersList.add(l);
        Letters m = new Letters('M', 2);
        lettersList.add(m);
        Letters n = new Letters('N', 1);
        lettersList.add(n);
        Letters o = new Letters('O', 1);
        lettersList.add(o);
        Letters p = new Letters('P', 2);
        lettersList.add(p);
        Letters r = new Letters('R', 1);
        lettersList.add(r);
        Letters s = new Letters('S', 1);
        lettersList.add(s);
        Letters t = new Letters('T', 2);
        lettersList.add(t);
        Letters u = new Letters('U', 3);
        lettersList.add(u);
        Letters w = new Letters('W', 1);
        lettersList.add(w);
        Letters y = new Letters('Y', 2);
        lettersList.add(y);
        Letters z = new Letters('Z', 1);
        lettersList.add(z);

    }


    public void pritn() {//TODO fix typo
        for (Letters letter : lettersList) {
            System.out.println(letter.getLetter());
        }
    }
    //ConcurrentModificationException?

    public void exchangeLetters(List<Character> lettersToExchange, Player player) {
        List<Letters> tempList = new ArrayList<>();
        for (Letters letter : player.getPlayerLetters().getPlayerListOfLetters()) {
            for (char letterToExchange : lettersToExchange) {
                if (letter.getLetter() == letterToExchange) {
                    tempList.add(letter);
                }
            }
        }
        player.getPlayerLetters().getPlayerListOfLetters().removeAll(tempList);

    }

    public void exchangeLetters(Player player) {
        player.getPlayerLetters().getPlayerListOfLetters().clear();
    }//TODO fix name

}
