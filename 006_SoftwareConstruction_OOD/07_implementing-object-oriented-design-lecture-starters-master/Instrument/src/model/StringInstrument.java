package model;

public abstract class StringInstrument implements Instrument {

    protected Orchestra orchestra;

    public StringInstrument(Orchestra orchestra) {
        this.orchestra = orchestra;
    }

    public Orchestra getOrchestra() { return orchestra; }

    public void setOrchestra(Orchestra orchestra) {
        if (!this.getOrchestra().equals(orchestra)) {
            this.orchestra = orchestra;
            orchestra.addStringInstrument(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringInstrument)) return false;

        StringInstrument that = (StringInstrument) o;

        return orchestra != null ? orchestra.equals(that.orchestra) : that.orchestra == null;
    }

    @Override
    public int hashCode() {
        return orchestra != null ? orchestra.hashCode() : 0;
    }
}
