package hotstone.standard;

import hotstone.framework.Player;

public class StandardCard implements hotstone.framework.Card {


    @Override
    public String getName() {
        return GameConstants.TRES_CARD; //FAKE IT
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    public int getHealth() {
        return 0;
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
