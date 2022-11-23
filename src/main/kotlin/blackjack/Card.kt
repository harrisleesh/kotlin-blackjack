package blackjack

const val ACE_POINT = 1
const val SPECIAL_ACE_POINT = 11

enum class Card(
    val shape: Shape,
    val value: Int,
) {
    HEART_A(Shape.HEART, ACE_POINT),
    HEART_2(Shape.HEART, 2),
    HEART_3(Shape.HEART, 3),
    HEART_4(Shape.HEART, 4),
    HEART_5(Shape.HEART, 5),
    HEART_6(Shape.HEART, 6),
    HEART_7(Shape.HEART, 7),
    HEART_8(Shape.HEART, 8),
    HEART_9(Shape.HEART, 9),
    HEART_10(Shape.HEART, 10),
    HEART_J(Shape.HEART, 10),
    HEART_Q(Shape.HEART, 10),
    HEART_K(Shape.HEART, 10),
    DIAMOND_A(Shape.DIAMOND, ACE_POINT),
    DIAMOND_2(Shape.DIAMOND, 2),
    DIAMOND_3(Shape.DIAMOND, 3),
    DIAMOND_4(Shape.DIAMOND, 4),
    DIAMOND_5(Shape.DIAMOND, 5),
    DIAMOND_6(Shape.DIAMOND, 6),
    DIAMOND_7(Shape.DIAMOND, 7),
    DIAMOND_8(Shape.DIAMOND, 8),
    DIAMOND_9(Shape.DIAMOND, 9),
    DIAMOND_10(Shape.DIAMOND, 10),
    DIAMOND_J(Shape.DIAMOND, 10),
    DIAMOND_Q(Shape.DIAMOND, 10),
    DIAMOND_K(Shape.DIAMOND, 10),
    SPADE_A(Shape.SPADE, ACE_POINT),
    SPADE_2(Shape.SPADE, 2),
    SPADE_3(Shape.SPADE, 3),
    SPADE_4(Shape.SPADE, 4),
    SPADE_5(Shape.SPADE, 5),
    SPADE_6(Shape.SPADE, 6),
    SPADE_7(Shape.SPADE, 7),
    SPADE_8(Shape.SPADE, 8),
    SPADE_9(Shape.SPADE, 9),
    SPADE_10(Shape.SPADE, 10),
    SPADE_J(Shape.SPADE, 10),
    SPADE_Q(Shape.SPADE, 10),
    SPADE_K(Shape.SPADE, 10),
    CLOVER_A(Shape.CLOVER, ACE_POINT),
    CLOVER_2(Shape.CLOVER, 2),
    CLOVER_3(Shape.CLOVER, 3),
    CLOVER_4(Shape.CLOVER, 4),
    CLOVER_5(Shape.CLOVER, 5),
    CLOVER_6(Shape.CLOVER, 6),
    CLOVER_7(Shape.CLOVER, 7),
    CLOVER_8(Shape.CLOVER, 8),
    CLOVER_9(Shape.CLOVER, 9),
    CLOVER_10(Shape.CLOVER, 10),
    CLOVER_J(Shape.CLOVER, 10),
    CLOVER_Q(Shape.CLOVER, 10),
    CLOVER_K(Shape.CLOVER, 10);

    fun isAce(): Boolean {
        return this in setOf(
            CLOVER_A,
            HEART_A,
            DIAMOND_A,
            SPADE_A,
        )
    }
}