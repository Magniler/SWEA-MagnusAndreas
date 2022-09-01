package hotstone.standard;

import hotstone.framework.Player;

public class StandardCard implements hotstone.framework.Card {


    @Override
    public String getName() {
        return GameConstants.TRES_CARD; //FAKE IT
    }

    @Override
    public int getManaCost() {
        return 2; //FAKE-IT
    }

    @Override
    public int getAttack() {
        return 2; //FAKE-IT
    }

    @Override
    public int getHealth() {
        return 2; //FAKE-IT
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public Player getOwner() {
        return null;
    }
}
