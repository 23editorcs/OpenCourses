package ui;

import model.Transcript;

public class Main {
    public static void main(String[] args) {
        Transcript t1 = new Transcript("Jane Doe", 7830);
        Transcript t2 = new Transcript("Ada Lovelace", 8853);
        //TODO: create another Transcript object
        Transcript t3 = new Transcript("Quy Nguyen", 60801755);

        t1.addGrade("CPSC-210", 3.5);
        t1.addGrade("ENGL-201", 4.0);
        t1.addGrade("CPSC-110", 3.1);

        //TODO: add grades to the other Transcript objects
        t3.addGrade("CS-101", 4.0);
        t3.addGrade("HtC", 3.9);

        t1.printTranscript();
        t2.printTranscript();
        t3.printTranscript();
    }
}
