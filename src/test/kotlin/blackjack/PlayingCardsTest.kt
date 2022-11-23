package blackjack

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertAll

class PlayingCardsTest : StringSpec({
    "플레잉 카드가 2Clover 3Spade일 때 카드 점수를 계산하면 5이다." {
        PlayingCards(mutableSetOf(Card.CLOVER_2, Card.SPADE_3)).sumPoint() shouldBe 5
    }

    "플레잉 카드 중 Ace를 여러개 포함할 경우: Ace를 한 장을 제외한 카드의 합이 10초과이면 Ace의 값을 1로 계산한다." {
        assertAll(
            { PlayingCards(mutableSetOf(Card.CLOVER_A, Card.CLOVER_10, Card.CLOVER_2)).sumPoint() shouldBe 13 },
            { PlayingCards(mutableSetOf(Card.CLOVER_A, Card.CLOVER_10, Card.CLOVER_J)).sumPoint() shouldBe 21 },
            { PlayingCards(mutableSetOf(Card.CLOVER_A, Card.CLOVER_10, Card.HEART_A)).sumPoint() shouldBe 12 },
        )
    }

    "플레잉 카드 중 Ace를 여러개 포함할 경우: Ace를 한 장을 제외한 카드의 합이 10이하이면 Ace의 값을 11로 계산한다." {
        assertAll(
            { PlayingCards(mutableSetOf(Card.CLOVER_A, Card.CLOVER_10)).sumPoint() shouldBe 21 },
            { PlayingCards(mutableSetOf(Card.CLOVER_A, Card.CLOVER_2)).sumPoint() shouldBe 13 },
            { PlayingCards(mutableSetOf(Card.CLOVER_A, Card.HEART_A, Card.CLOVER_9)).sumPoint() shouldBe 21 },
        )
    }

})