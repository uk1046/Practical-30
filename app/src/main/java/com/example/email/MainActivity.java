package com.example.email;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText toEditText;
    private EditText subjectEditText;
    private EditText messageEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toEditText = findViewById(R.id.toEditText);
        subjectEditText = findViewById(R.id.subjectEditText);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        String to = toEditText.getText().toString();
        String subject = subjectEditText.getText().toString();
        String message = messageEditText.getText().toString();

        if (!to.isEmpty() && !subject.isEmpty() && !message.isEmpty()) {
            // Create an intent with ACTION_SEND action
            Intent intent = new Intent(Intent.ACTION_SEND);

            // Set the type to "message/rfc822" to ensure it opens an email client
            intent.setType("message/rfc822");

            // Add email address, subject, and message to the intent
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, message);

            // Start the activity with the intent
            startActivity(Intent.createChooser(intent, "Send Email"));
        }
    }
}
