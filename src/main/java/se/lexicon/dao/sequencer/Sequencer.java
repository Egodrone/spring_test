package se.lexicon.dao.sequencer;



public class Sequencer {
    private static int studentSequencer;

    public static int nextStudentUserId() {
        return ++studentSequencer;
    }

    public static int getStudentUserIdSequencer() {
        return studentSequencer;
    }

}
