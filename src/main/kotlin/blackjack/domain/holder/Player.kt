package blackjack.domain.holder

import blackjack.domain.card.Card
import blackjack.domain.value.BettingAmount
import blackjack.domain.value.Point

data class Player(
    val name: String,
    val hands: Hands = Hands(),
    val bettingAmount: BettingAmount = BettingAmount(0),
) {
    fun addCard(deal: Card): Player {
        hands.addOne(deal)
        return this
    }

    fun addCard(cards: Set<Card>): Player {
        hands.addAll(cards)
        return this
    }

    fun cardPoint() = hands.calculatePoint()
    fun blackJack() = hands.cards.size == 2 && hands.calculatePoint() == Point.BLACK_JACK

    fun flip(dealer: Dealer): Int {
        return when {
            bust() -> bettingAmount.lose()
            blackJack() && !dealer.blackJack() -> bettingAmount.blackJack()
            dealer.bust() -> bettingAmount.win()
            dealer.blackJack() && !blackJack() -> bettingAmount.lose()
            cardPoint() > dealer.cardPoint() -> bettingAmount.win()
            cardPoint() < dealer.cardPoint() -> bettingAmount.lose()
            else -> bettingAmount.tie()
        }
    }

    fun bust(): Boolean = hands.bust()
    fun firstCard(): Set<Card> = hands.firstCard()

}
