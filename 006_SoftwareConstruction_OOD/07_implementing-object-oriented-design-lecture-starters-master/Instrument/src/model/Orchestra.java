package model;

import java.util.ArrayList;
import java.util.List;

public class Orchestra {

    private List<BrassInstrument> brassTeam;
    private List<StringInstrument> stringTeam;

    public Orchestra(ArrayList<BrassInstrument> brassTeam, ArrayList<StringInstrument> stringTeam) {
        this.brassTeam = brassTeam;
        this.stringTeam = stringTeam;
    }

    public void addBrassInstrument(BrassInstrument artist) {
        if (!this.brassTeam.contains(artist)) {
            this.brassTeam.add(artist);
            artist.setOrchestra(this);
        }
    }

    public void addStringInstrument(StringInstrument artist) {
        if (!this.stringTeam.contains(artist)) {
            this.stringTeam.add(artist);
            artist.setOrchestra(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orchestra)) return false;

        Orchestra orchestra = (Orchestra) o;

        if (brassTeam != null ? !brassTeam.equals(orchestra.brassTeam) : orchestra.brassTeam != null) return false;
        return stringTeam != null ? stringTeam.equals(orchestra.stringTeam) : orchestra.stringTeam == null;
    }

    @Override
    public int hashCode() {
        int result = brassTeam != null ? brassTeam.hashCode() : 0;
        result = 31 * result + (stringTeam != null ? stringTeam.hashCode() : 0);
        return result;
    }
}
