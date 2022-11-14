package atm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CardRepository {

    public Map<Integer, Card> cards = new HashMap<>();

    public CardRepository() {
        cards.put(123456, new Card(
            123456, new int[] {1,0,0,4},
            new ArrayList<>(Collections.singletonList(new Account(3244, 2000)))
        ));
    }

    public Optional<Card> findByCardNumberAndPin(int cardNumber, int[] pin) {
        if (!cards.containsKey(cardNumber)) {
            return Optional.empty();
        }
        Card card = cards.get(cardNumber);
        if (!card.checkPin(pin)) {
            return Optional.empty();
        }
        return Optional.of(card);
    }
}
