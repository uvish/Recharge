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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity{
    EditText number;
    EditText amt;
    Spinner sp;
    ArrayList<String> list;
    ImageView logo;
    String code,date,logcode;
    String text1,text2,message;

    AlertDialog.Builder adb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filllist();

        Calendar c=Calendar.getInstance();
        SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
        String date=df.format(c.getTime());
        ArrayAdapter<String> ad=new ArrayAdapter<String>(this,R.layout.spinner_item,list);
        number=(EditText)findViewById(R.id.number);
        amt=(EditText)findViewById(R.id.amount);
        sp=(Spinner)findViewById(R.id.spinner);
        sp.setAdapter(ad);
        logo=(ImageView)findViewById(R.id.logo);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected=(String)sp.getSelectedItem();
                if(selected.equals("Airtel")){logo.setImageResource(R.drawable.airtel);}
                if(selected.equals("Aircel")){logo.setImageResource(R.drawable.aircel);}
                if(selected.equals("Vodafone")){logo.setImageResource(R.drawable.vodafone);}
                if(selected.equals("Idea")){logo.setImageResource(R.drawable.idea);}
                if(selected.equals("Jio")){logo.setImageResource(R.drawable.ril);}
                if(selected.equals("Docomo Normal")){logo.setImageResource(R.drawable.dcm);}
                if(selected.equals("Docomo Special")){logo.setImageResource(R.drawable.dcm);}
                if(selected.equals("Telenor Normal")){logo.setImageResource(R.drawable.tlnr);}
                if(selected.equals("Telenor Special")){logo.setImageResource(R.drawable.tlnr);}
                if(selected.equals("BSNL Special")){logo.setImageResource(R.drawable.bsnl);}
                if(selected.equals("BSNL Top Up")){logo.setImageResource(R.drawable.bsnl);}
                if(selected.equals("Reliance GSM")){logo.setImageResource(R.drawable.ril);}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void filllist()
    {
        list=new ArrayList<>();
        list.add("Airtel");
      //  list.add("Aircel");
        list.add("Vodafone");
        list.add("Idea");
        list.add("Jio");
        list.add("Docomo Normal");
        list.add("Docomo Special");
        list.add("Telenor Normal");
        list.add("Telenor Special");
        list.add("BSNL Special");
        list.add("BSNL Top Up");
      //  list.add("Reliance GSM");

    }
    public void sendmessage(View v)
    {
        String clr=(String)sp.getSelectedItem();
        //OLD CODES
//        if(clr.equalsIgnoreCase("Airtel"))
//        { code="RA";logcode="Airtel";}
//        else if(clr.equalsIgnoreCase("Vodafone"))
//        {code="RV";logcode="Vodafone";}
//       else if(clr.equalsIgnoreCase("Idea"))
//        {  code="RI";logcode="Idea";}
//       else if(clr.equalsIgnoreCase("Docomo Normal"))
//        { code="RD";logcode="Docomo";}
//        else if(clr.equalsIgnoreCase("Docomo Special"))
//        {  code="TD";logcode="Docomo";}
//       else if(clr.equalsIgnoreCase("Telenor Normal"))
//        {  code="RU";logcode="Telenor";}
//       else if(clr.equalsIgnoreCase("Telenor Special"))
//        {   code="TU";logcode="Telenor";}
//       else if(clr.equalsIgnoreCase("BSNL Special"))
//        {  code="RB";logcode="BSNL";}
//       else if(clr.equalsIgnoreCase("BSNL Top Up"))
//        {  code="TB";logcode="BSNL";}
//       else if(clr.equalsIgnoreCase("Reliance GSM"))
//        {  code="RG";logcode="Reliance GSM";}
//       else if(clr.equalsIgnoreCase("Reliance CDMA"))
//        {   code="RH";logcode="Reliance CDMA";}
//       else if(clr.equalsIgnoreCase("Aircel"))
//        { code="RC";logcode="Aircel";}
//        else if(clr.equalsIgnoreCase("Jio"))
//        {  code="Jio";logcode="JIO";}
// NEW CODES ->
        if(clr.equalsIgnoreCase("Airtel"))
        { code="RA";logcode="Airtel";}
        else if(clr.equalsIgnoreCase("Vodafone"))
        {code="RV";logcode="Vodafone";}
        else if(clr.equalsIgnoreCase("Idea"))
        {  code="RI";logcode="Idea";}
        else if(clr.equalsIgnoreCase("Docomo Normal"))
        { code="RD";logcode="Docomo";}
        else if(clr.equalsIgnoreCase("Docomo Special"))
        {  code="TD";logcode="Docomo";}
        else if(clr.equalsIgnoreCase("Telenor Normal"))
        {  code="RU";logcode="Telenor";}
        else if(clr.equalsIgnoreCase("Telenor Special"))
        {   code="TU";logcode="Telenor";}
        else if(clr.equalsIgnoreCase("BSNL Special"))
        {  code="RB";logcode="BSNL";}
        else if(clr.equalsIgnoreCase("BSNL Top Up"))
        {  code="TB";logcode="BSNL";}
//        else if(clr.equalsIgnoreCase("Reliance GSM"))
//        {  code="RG";logcode="Reliance GSM";}
//        else if(clr.equalsIgnoreCase("Reliance CDMA"))
//        {   code="RH";logcode="Reliance CDMA";}
//        else if(clr.equalsIgnoreCase("Aircel"))
//        { code="RC";logcode="Aircel";}
        else if(clr.equalsIgnoreCase("Jio"))
        {  code="RJ";logcode="JIO";}

        text1=number.getText().toString();
        text2=amt.getText().toString();
        message=code.concat(text1).concat("A").concat(text2);


        adb=new AlertDialog.Builder(this);

        adb.setTitle("Select Server Server");
        LinearLayout ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setMinimumHeight(600);

        //OLD SERVERS
//        s1.setText("Server 1 (7800098293)");
//        s1.setMinimumHeight(200);
//        Button s2=new Button(this);
//        s2.setText("Server 2 (7800097416)");
//        s2.setMinimumHeight(200);
//        Button s3=new Button(this);
//        s3.setText("Server 3 (7880969671)");
//        s3.setMinimumHeight(200);
        // NEW SERVERS ->
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
                if(text1.length()!=10)
                {

                    Toast.makeText(MainActivity.this,"Check Number", Toast.LENGTH_SHORT).show();

                }
                 else { mssg(message,logcode,text1.concat(" "+text2),1,"9648923456");}
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text1.length()!=10)
                {
                    Toast.makeText(MainActivity.this,"Check Number", Toast.LENGTH_SHORT).show();
                }
                else { mssg(message,logcode,text1.concat(" "+text2),1,"8381838383");}
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text1.length()!=10)
                {
                    Toast.makeText(MainActivity.this,"Check Number", Toast.LENGTH_SHORT).show();
                }
                else { mssg(message,logcode,text1.concat(" "+text2),1,"8604667788");}

            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text1.length()!=10)
                {
                    Toast.makeText(MainActivity.this,"Check Number", Toast.LENGTH_SHORT).show();
                }
                else { mssg(message,logcode,text1.concat(" "+text2),1,"8808552222");}
            }
        });

        adb.show();


    }
    public void checkbalance(View v)
    {  adb=new AlertDialog.Builder(this);
        adb.setTitle("Select Server");
        LinearLayout ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setMinimumHeight(210);
        Button s1=new Button(this);
        s1.setText("9628823456");
        s1.setMinimumHeight(200);
        Button s2=new Button(this);
        s2.setText("9648923456");
        s2.setMinimumHeight(200);
//        Button s3=new Button(this);
//        s3.setText("DOCOMO (8604667788)");
//        s3.setMinimumHeight(200);
//        Button s4=new Button(this);
//        s4.setText("IDEA (8808552222)");
//        s4.setMinimumHeight(200);
        ll.addView(s1);ll.addView(s2);//ll.addView(s3);ll.addView(s4);
        adb.setView(ll);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mssg("CB",null,null,0,"9628823456");
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mssg("CB",null,null,0,"9648923456");
            }
        });
//        s3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mssg("CB",null,null,0,"8604667788");
//
//            }
//        });
//        s4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mssg("CB",null,null,0,"8808552222");
//            }
//        });


        adb.show();



    }
public void mssg(String message,String logcode,String log,int c,String serv)
{
    Intent i=new Intent(this,MainActivity.class);

    PendingIntent pi=PendingIntent.getActivity(this,1,i,PendingIntent.FLAG_ONE_SHOT);

    SmsManager sm=SmsManager.getDefault();
    sm.sendTextMessage(serv,null,message,pi,null);


    Toast.makeText(this,"Message Sent", Toast.LENGTH_SHORT).show();
}


}
