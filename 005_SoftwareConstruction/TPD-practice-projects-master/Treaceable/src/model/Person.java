package model;

public class Person {

    private String name;
    private CellPhone cellPhone;
    private FingerPrint fingerPrint;

    public Person(String name) {
        this.name = name;
    }

    // getters
    public String getName() {
        return name;
    }
    public CellPhone getCellPhone() {
        return cellPhone;
    }
    public FingerPrint getFingerPrint() {
        return fingerPrint;
    }

    // methods
    public void setCellPhone(CellPhone c) {
        this.cellPhone = c;
    }

    public void setFingerPrint(FingerPrint f) {
        this.fingerPrint = f;
    }

}
