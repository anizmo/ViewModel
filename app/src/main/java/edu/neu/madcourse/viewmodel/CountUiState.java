package edu.neu.madcourse.viewmodel;

/**
 * A simple class that keeps track of the state of the UI. Here we have one variable that is used to
 * update the UI, that is, the count value.
 */
public class CountUiState {

    private final Integer countValue;

    /**
     * Constructs an instance of CountUiState with the provided countValue. This is a holder to hold
     * the value of the counter.
     *
     * @param countValue   the initial number to be stored.
     */
    public CountUiState(Integer countValue) {
        this.countValue = countValue;
    }

    public Integer getCountValue() {
        return countValue;
    }
}
