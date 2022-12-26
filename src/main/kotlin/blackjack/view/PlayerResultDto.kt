package blackjack.view

import blackjack.domain.Card
import blackjack.domain.Dealer
import blackjack.domain.GameResult
import blackjack.domain.Player

data class PlayerResultDto(
    val name: String,
    val cards: Set<Card>,
    val totalPoint: Int,
    val winningCount: Int = ZERO_COUNT,
    val tieCount: Int = ZERO_COUNT,
    val losingCount: Int = ZERO_COUNT,
) {
    constructor(player: Player) : this(
        player.name,
        player.playingCards.cards,
        player.cardPoint().value,
    )

    constructor(dealer: Dealer, firstCard: Set<Card>) : this(dealer.player.name, firstCard, dealer.cardPoint().value)
    constructor(dealer: Dealer, winningCount: Int, tieCount: Int, losingCount: Int) : this(
        dealer.player.name,
        dealer.player.playingCards.cards,
        dealer.player.playingCards.calculatePoint().value,
        winningCount, tieCount, losingCount
    )

    fun bust() = totalPoint == 0 && cards.size > 2

    companion object {
        fun playerDtoOf(player: Player, gameResult: GameResult): PlayerResultDto {
            return when (gameResult) {
                GameResult.WIN -> PlayerResultDto(
                    name = player.name,
                    cards = player.playingCards.cards,
                    totalPoint = player.playingCards.calculatePoint().value,
                    winningCount = 1
                )

                GameResult.LOSE -> PlayerResultDto(
                    name = player.name,
                    cards = player.playingCards.cards,
                    totalPoint = player.playingCards.calculatePoint().value,
                    losingCount = 1
                )

                GameResult.TIE -> PlayerResultDto(
                    name = player.name,
                    cards = player.playingCards.cards,
                    totalPoint = player.playingCards.calculatePoint().value,
                    tieCount = 1
                )
            }
        }
    }
}
