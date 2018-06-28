package com.uvish.recharge.ETop;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class dth extends AppCompatActivity {
    EditText id;
    EditText amt;
    Spinner sp;
    ImageView logodth;
    AlertDialog.Builder adb;
    String code,text1,message;
    ArrayList<String> dthlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dth);
        filllist();
        ArrayAdapter<String> add=new ArrayAdapter<String>(this,R.layout.spinner_item,dthlist);
        id=(EditText)findViewById(R.id.id);
        logodth=(ImageView)findViewById(R.id.logodth) ;
        amt=(EditText)findViewById(R.id.amount1);
        sp=(Spinner)findViewById(R.id.spinner1);
        sp.setAdapter(add);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected=(String)sp.getSelectedItem();
                if(selected.equals("Tata Sky")){logodth.setImageResource(R.drawable.ts);}
                if(selected.equals("Airtel")){logodth.setImageResource(R.drawable.adth);}
                if(selected.equals("Videocon")){logodth.setImageResource(R.drawable.vdth);}
                if(selected.equals("Dish Tv")){logodth.setImageResource(R.drawable.dstv);}
                if(selected.equals("Big Tv")){logodth.setImageResource(R.drawable.btv);}
                if(selected.equals("Sun Tv")){logodth.setImageResource(R.drawable.stv);}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public void filllist()
    {
        dthlist=new ArrayList<>();
        dthlist.add("Tata Sky");
        dthlist.add("Airtel");
        dthlist.add("Videocon");
        dthlist.add("Dish Tv");
        dthlist.add("Big Tv");
        dthlist.add("Sun Tv");


    }
    public void send(View v)
    {
        String clr=(String)sp.getSelectedItem();
        //OLD CODES ->
//        if(clr.equalsIgnoreCase("Tata Sky")) code="DT";
//        else if(clr.equalsIgnoreCase("Airtel")) code="TA";
//        else if(clr.equalsIgnoreCase("Videocon")) code="DV";
//        else if(clr.equalsIgnoreCase("Dish Tv")) code="DD";
//        else if(clr.equalsIgnoreCase("Big Tv")) code="DB";
//        else if(clr.equalsIgnoreCase("Sun Tv")) code="DS";
        //NEW CODES ->
                if(clr.equalsIgnoreCase("Tata Sky")) code="DT";
        else if(clr.equalsIgnoreCase("Airtel")) code="RH";
        else if(clr.equalsIgnoreCase("Videocon")) code="DV";
        else if(clr.equalsIgnoreCase("Dish Tv")) code="DD";
        else if(clr.equalsIgnoreCase("Big Tv")) code="DB";
        else if(clr.equalsIgnoreCase("Sun Tv")) code="DS";



         text1=id.getText().toString();
        final String text2=amt.getText().toString();
        message=code.concat(text1).concat("A").concat(text2);

        if((code.equals("RH")&& text1.length()!=10)
                ||
                (code.equals("DB")&& text1.length()!=12)
                ||
                (code.equals("DD")&& text1.length()!=11)
                ||
                (code.equals("DT")&& text1.length()!=10)
                ||
                (code.equals("DS")&& text1.length()!=11)
                ||
                (code.equals("DV")&& (text1.length()<7 || text1.length() >9)))
    {
        Toast.makeText(this,"Check ID", Toast.LENGTH_LONG).show();
    }

        else {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);

            adb.setTitle("SelectServer");
            LinearLayout ll=new LinearLayout(this);
            ll.setOrientation(LinearLayout.VERTICAL);
            ll.setMinimumHeight(600);

            Button s1=new Button(this);
            s1.setText("VODAFONE (9648923456)");
            s1.setMinimumHeight(200);
            Button s2=new Button(this);
            s2.setText("AIRTEL (8381838383)");
            s2.setMinimumHeight(200);
            Button s3=new Button(this);
            s3.setText("DOCOMO (8604667788)");
            s3.setMinimumHeight(200);
            Button s4=new Button(this);
            s4.setText("IDEA (8808552222)");
            s4.setMinimumHeight(200);
            ll.addView(s1);ll.addView(s2);ll.addView(s3);ll.addView(s4);
            adb.setView(ll);
            s1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     mssgdth(message,"9648923456");
                }
            });
            s2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mssgdth(message,"8381838383");
                }
            });
            s3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   mssgdth(message,"8604667788");

                }
            });
            s4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  mssgdth(message,"8808552222");
                }
            });

            adb.show();









            }

    }
    public void balance(View v)
    {
        adb=new AlertDialog.Builder(this);
        adb.setTitle("Select Server");
        LinearLayout ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setMinimumHeight(210);
        Button s1=new Button(this);
        s1.setText("9628823456");
        s1.setMinimumHeight(200);
        Button s2=new Button(this);
        s2.setText("9648923456");
        ll.addView(s1);
        ll.addView(s2);
        adb.setView(ll);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mssgdth("CB","9628823456");
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mssgdth("CB","9648923456");
            }
        });


        adb.show();
    }
    public void mssgdth(String mssg,String number)
    {
        Intent i=new Intent(this,dth.class);

        PendingIntent pi=PendingIntent.getActivity(this,1,i,PendingIntent.FLAG_ONE_SHOT);

        SmsManager sm=SmsManager.getDefault();
        sm.sendTextMessage(number,null,mssg,pi,null);

        Toast.makeText(this,"Message Sent", Toast.LENGTH_SHORT).show();
    }
}
