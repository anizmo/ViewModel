package edu.neu.madcourse.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * The view model handles the communication of the Activity with the rest of the application, it
 * keeps the data safe from configuration changes. It maintains the state and provides data for
 * using on the UI.
 */
public class MainViewModel extends ViewModel {

    private final MutableLiveData<CountUiState> uiState = new MutableLiveData<>(new CountUiState(0));

    /**
     * Returns the uiState object associated with this view model.
     *
     * @return uiState of the view-model.
     */
    public LiveData<CountUiState> getUiState() {
        return uiState;
    }

    /**
     * Increment the counter value by 1. This is done by setting a new count ui state object to the
     * value of uiState.
     */
    public void incrementCount() {
        uiState.setValue(new CountUiState(uiState.getValue().getCountValue() + 1));
    }

}
