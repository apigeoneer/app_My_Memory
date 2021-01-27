package com.gmail.apigeoneer.mymemory.models

import com.gmail.apigeoneer.mymemory.utils.DEFAULT_ICONS

class MemoryGame(private val boardSize: BoardSize) {
    /**
     * This class encapsulates all the logic for the memory game
     */
    val cards: List<MemoryCard>
    var numPairsFound = 0

    private var numCardsFlipped = 0
    private var indexOfSingleSelectedCard: Int? = null

    init {
        val chosenImages = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        val randomizedImages = (chosenImages + chosenImages).shuffled()
        cards = randomizedImages.map { MemoryCard(it) }
    }

    fun flipCard(position: Int): Boolean {
        numCardsFlipped++
        val card = cards[position]
        /**
         * On tapping a card, whether to flip it or not?
         * -> There can be 3 cases:
         *  a. #previously flipped cards: 0 => flip over
         *  b.                          : 1 => flip over + Check if match is found
         *  c.                          : 2 => restore + flip over
         *  
         *  Finally, Case 1: a = b = restore + flip over,
         *           Case 2: c = flip over + check for match
         */
        var foundMatch = false
        if(indexOfSingleSelectedCard == null) {
            // 0 / 2 cards previously flipped over
            restoreCards()
            indexOfSingleSelectedCard = position
        } else {
            // 1 card previously flipped over
            foundMatch = checkForMatch(indexOfSingleSelectedCard!!, position)
            indexOfSingleSelectedCard = null
        }
        
        card.isFaceUp = !card.isFaceUp
        return foundMatch
    }

    private fun checkForMatch(position1: Int, position2: Int): Boolean {
        if (cards[position1].identifier != cards[position2].identifier) {
            return false
        }
        cards[position1].isMatched = true
        cards[position2].isMatched = true
        numPairsFound++
        return true
    }

    private fun restoreCards() {
        for (card in cards) {
            // then flip over every card that isn't a part of a match previously found
            if(!card.isMatched) {
                card.isFaceUp = false
            }
        }
    }

    fun haveWonGame(): Boolean {
        return numPairsFound == boardSize.getNumPairs()
    }

    fun isCardFaceUp(position: Int): Boolean {
        return cards[position].isFaceUp
    }

    fun getNumMoves(): Int {
        return numCardsFlipped / 2
    }
}
