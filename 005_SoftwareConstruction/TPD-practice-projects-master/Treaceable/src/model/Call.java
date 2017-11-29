package model;

public class Call implements Traceable {
    private CellPhone outgoing;

    public Call(CellPhone out) {
        this.outgoing = out;
    }

    // getters
    public CellPhone getOutgoing() {
        return outgoing;
    }

    @Override
    public String getLocation() {
        return outgoing.getLocation();
    }

    @Override
    public Object getTrace() {
        return outgoing;
    }

    @Override
    public void track() {
        System.out.println("Tracking..." + outgoing.getNumber() +" !!!");
    }
}
