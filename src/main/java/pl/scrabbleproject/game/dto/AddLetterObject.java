package pl.scrabbleproject.game.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class AddLetterObject {
    @Getter
    int posX;
    @Getter
    int posY;
    @Getter
    char letter;
}
