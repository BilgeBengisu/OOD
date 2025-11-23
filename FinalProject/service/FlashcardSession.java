package service;

import model.Deck;
import model.Flashcard;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FlashcardSession {

    private Deck deck;

    public FlashcardSession(Deck deck) {
        this.deck = deck;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        List<Flashcard> cards = deck.getCards();
        Collections.shuffle(cards);

        for (Flashcard card : cards) {
            System.out.println("ENGLISH: " + card.getFront());
            sc.nextLine();
            System.out.println("TRANSLATION: " + card.getBack());
            System.out.println("----");
        }
    }
}
