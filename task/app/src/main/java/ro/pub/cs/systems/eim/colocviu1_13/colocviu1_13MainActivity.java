package ro.pub.cs.systems.eim.colocviu1_13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class colocviu1_13MainActivity extends AppCompatActivity {

    private Button northButton;
    private Button southButton;
    private Button eastButton;
    private Button westButton;
    private EditText pressedButtonsEditText;
    private Integer pressCount;
    private Button navigateToSecondaryActivityButton;


    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    protected class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.north_button:
                    if(pressedButtonsEditText.getText().toString().length() == 0) {
                        pressedButtonsEditText.setText("North");
                    } else {
                        pressedButtonsEditText.setText(pressedButtonsEditText.getText().toString() + ", North");
                    }
                    pressCount++;
                    break;
                case R.id.south_button:
                    if(pressedButtonsEditText.getText().toString().length() == 0) {
                        pressedButtonsEditText.setText("South");
                    } else {
                        pressedButtonsEditText.setText(pressedButtonsEditText.getText().toString() + ", South");
                    }
                    pressCount++;
                    break;
                case R.id.east_button:
                    if(pressedButtonsEditText.getText().toString().length() == 0) {
                        pressedButtonsEditText.setText("East");
                    } else {
                        pressedButtonsEditText.setText(pressedButtonsEditText.getText().toString() + ", East");
                    }
                    pressCount++;
                    break;
                case R.id.west_button:
                    if(pressedButtonsEditText.getText().toString().length() == 0) {
                        pressedButtonsEditText.setText("West");
                    } else {
                        pressedButtonsEditText.setText(pressedButtonsEditText.getText().toString() + ", West");
                    }
                    pressCount++;
                    break;
                case R.id.navigate_to_secondary_activity:
                            Intent intent = new Intent(getApplicationContext(), colocviu1_13SecondaryActivity.class);
                            intent.putExtra(Constants.SECONDARY_ACTIVITY, pressedButtonsEditText.getText().toString());
                            startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
                            pressCount=0;
                            pressedButtonsEditText.setText("");
                    break;

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_13_main);

        pressCount=0;

        northButton = findViewById(R.id.north_button);
        northButton.setOnClickListener(buttonClickListener);
        southButton = findViewById(R.id.south_button);
        southButton.setOnClickListener(buttonClickListener);
        eastButton = findViewById(R.id.east_button);
        eastButton.setOnClickListener(buttonClickListener);
        westButton = findViewById(R.id.west_button);
        westButton.setOnClickListener(buttonClickListener);
        pressedButtonsEditText = findViewById(R.id.pressed_buttons_edit_text);
        navigateToSecondaryActivityButton = findViewById(R.id.navigate_to_secondary_activity);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(Constants.PRESS_COUNT, pressCount);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.PRESS_COUNT)) {
            pressCount = savedInstanceState.getInt(Constants.PRESS_COUNT);
            Toast.makeText(this, "Number of presses: " + pressCount, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
            if(resultCode == RESULT_OK)
                Toast.makeText(this, "The activity returned with result Register" , Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "The activity returned with result Cancel" , Toast.LENGTH_LONG).show();
        }
    }
}
