/*
 * Copyright (C) 2022. Henrik Bærbak Christensen, Aarhus University.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *
 *  You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package hotstone.standard;

/**
 * Skeleton class for AlphaStone test cases
 *
 *    This source code is from the book
 *      "Flexible, Reliable Software:
 *        Using Patterns and Agile Development"
 *      2nd Edition
 *    Author:
 *      Henrik Bærbak Christensen
 *      Department of Computer Science
 *      Aarhus University
 */

import hotstone.framework.Card;
import hotstone.framework.Player;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import hotstone.framework.Game;

/** Template for your own ongoing TDD process.
 * Fill it out until you have covered all
 * requirements for the alpha stone game.
 */
public class TestAlphaStone {
  private Game game;

  /** Fixture for AlphaStone testing. */
  @BeforeEach
  public void setUp() {
    game = new StandardHotStoneGame();
  }

  // The HotStone specs are quite insisting on how
  // the cards, drawn from the deck, are organized
  // in the hand. So when drawing the top three cards
  // from the deck (uno, dos, tres) they have to
  // be organized in the hand as
  // index 0 = tres; index 1 = dos; index 2 = uno
  // That is, a newly drawn card is 'at the top'
  // of the hand - always entered at position 0
  // and pushing the rest of the cards 1 position
  // 'down'
  @Test
  public void shouldHaveUnoDosTresIntially() {
    // Given a game, Findus has 3 cards in hand
    int count = game.getHandSize(Player.FINDUS);
    assertThat(count, is(3));
    // And these are ordered Tres, Dos, Uno in slot 0,1,2

    // Given card 0 in the hand
    Card cardTres = game.getCardInHand(Player.FINDUS, 0);
    Card cardDos = game.getCardInHand(Player.FINDUS, 1);
    Card cardUno = game.getCardInHand(Player.FINDUS, 2);
    // Then is it Tres
    // ENABLE TO START TDD'ing
    assertThat(cardTres.getName(), is(GameConstants.TRES_CARD));
    assertThat(cardDos.getName(), is(GameConstants.DOS_CARD));
    assertThat(cardUno.getName(), is(GameConstants.UNO_CARD));
  }

  @Test
  public void dosHasTwoTwoTwo(){
    Card card_dos = new StandardCard(GameConstants.DOS_CARD);
    assertThat(card_dos.getAttack(), is(2));
    assertThat(card_dos.getHealth(), is(2));
    assertThat(card_dos.getManaCost(), is(2));
  }

  @Test
  public void shouldReturnFindusInTurn(){
    assertThat(game.getPlayerInTurn(), is(Player.FINDUS));
  }

  @Test
  public void shouldReturnPeddersenInTurn(){
    //After 1 turn, it should be Peddersens turn if Findus started
    game.endTurn();
    assertThat(game.getPlayerInTurn(), is(Player.PEDDERSEN));
  }

  @Test
  public void peddersenShouldHave3CardsAfterFindusPlaysOne(){
    Card card = game.getCardInHand(Player.FINDUS, 0);
    game.playCard(Player.FINDUS, card);
    assertThat(game.getHandSize(Player.PEDDERSEN), is(3));
  }

  @Test
  public void shouldReturnList(){
    Iterable<? extends Card> hand = game.getHand(Player.FINDUS);
    assertThat(hand.getClass(), is(ArrayList.class));
  }

  @Test
  public void shouldReturnCardType(){
    Card cardInHand = game.getCardInHand(Player.FINDUS,0);
    assertThat(cardInHand.getClass(), is(StandardCard.class));

  }

}
