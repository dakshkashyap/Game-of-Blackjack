# Game of Blackjack
A GUI-based simple Java Game of Blackjack using Java FX and Swing library.

# General rules of the game:
1. It would be a 2-player game: a user/player and a computer auto-player.
2. 1 single deck of cards (52 cards) will be used in each round of play.
3. Each player can have a maximum of 5 cards (called a hand) in a round, drawing 1 card
in each of the 5 turns in a round. The player can also decide to skip a turn and not
have any cards in that turn.
4. The cards have points associated with them: starting from 1 to 13 where Jack, Queen
and King are treated as 11, 12 and 13 respectively.
5. The player with the hand with points closest to 33 will win.
6. Any player who goes beyond 33 is treated as the loser of that round.

Here is an example of possible scenarios after 5 turns in a round:

| Player 1 points  | Player 2 points | Round winner |
| ---------------- | --------------- | ------------ |
|       28         |        34       |    Player 1  |
|       33         |        33       |     Draw     |
|       37         |        23       |    Player 2  |
|       35         |        38       |     Draw     |

# Game features:
- when a player gets over 33 points, that round is over immediately; no need to play for
the whole 5 turns in a round.
- the game should keep a score for the players winning each round. The scores will be
visible in the interface.
- After each round, it would ask the user if wants to continue or not.

# Future Developments
- Integrate AI and ML in the project so that the computer can also skip the card.
- Update UI to a sleek and modern design, but minimalistic and responsive.
