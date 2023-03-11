package edu.neu.madcourse.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Here, we have a simple example of using a ViewModel that demonstrates maintaining state
 * on configuration changes such as screen rotation without using the 'onSaveInstance' and
 * 'onRestoreInstance' methods.
 */
public class MainActivity extends AppCompatActivity {

    private TextView countTextView;

    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the reference of the Text View to update it in the code later
        countTextView = findViewById(R.id.countTextView);

        // Create a ViewModel the first time the system calls an activity's onCreate() method.
        // Re-created activities receive the same MyViewModel instance created by the first activity.
        model = new ViewModelProvider(this).get(MainViewModel.class);

        // Observe on the UI State object to listen to any changes to the data that is in the
        // view-model
        model.getUiState().observe(this, uiState -> {
            // Set the current value of the count from the uiState object, this is triggered when
            // there is a change in the count value.
            countTextView.setText("Current Value of Number: " +uiState.getCountValue());
        });

    }

    /**
     * This method is invoked from the XML file on the click of the button.
     */
    public void incrementCounter(View view) {
        // Call the incrementCount method of the ViewModel, which will trigger the observable above.
        model.incrementCount();
    }
}