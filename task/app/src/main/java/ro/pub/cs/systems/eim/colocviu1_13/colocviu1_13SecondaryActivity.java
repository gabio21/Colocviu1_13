package ro.pub.cs.systems.eim.colocviu1_13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class colocviu1_13SecondaryActivity extends AppCompatActivity {

    private Button registerButton;
    private Button cancelButton;
    private EditText editText;

    private ButtonClickListener2 buttonClickListener2 = new ButtonClickListener2();
    private class ButtonClickListener2 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.register_button:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_13secondary);

        registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(buttonClickListener2);
        cancelButton = findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(buttonClickListener2);

        editText = findViewById(R.id.edit_text);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.SECONDARY_ACTIVITY)) {
            editText.setText(intent.getStringExtra(Constants.SECONDARY_ACTIVITY));
        }
    }
}
