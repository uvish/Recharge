package com.uvish.recharge.ETop;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Custom extends AppCompatActivity {
    EditText code,num,amt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        code=(EditText)findViewById(R.id.code);
        num=(EditText)findViewById(R.id.number);
        amt=(EditText)findViewById(R.id.amt);

    }
    public void sendCustom(View v)
    {
        String cd=code.getText().toString(),
                no=num.getText().toString(),
                am=amt.getText().toString();


        Intent i = new Intent(this, com.uvish.recharge.ETop.MainActivity.class);

        PendingIntent pi = PendingIntent.getActivity(this, 1, i, PendingIntent.FLAG_ONE_SHOT);

        SmsManager sm = SmsManager.getDefault();
        sm.sendTextMessage("7800097416", null, cd.concat(no).concat("A").concat(am), pi, null);

        Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
    }
}
