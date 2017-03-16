package com.example.anthony.toastlogin;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText e1,e2;
    Button b1;
    int no=4;
    Toast t3=Toast.makeText(getApplicationContext(),"WRONG USERNAME/PASSWORD \nNumber of tries left="+no,Toast.LENGTH_LONG);
    //Toast t2=Toast.makeText(getApplicationContext(),"WRONG USERNAME/PASSWORD \nNumber of tries left="+no,Toast.LENGTH_LONG);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button);


        LayoutInflater li=getLayoutInflater();
        View layout=li.inflate(R.layout.layout2,(ViewGroup)findViewById(R.id.toast));
        Toast t=Toast.makeText(getApplicationContext(),"Hello!",Toast.LENGTH_LONG);
        t.setView(layout);
        t.show();

        b1.setOnClickListener(new View.OnClickListener() {//function called on button click
            @Override
            public void onClick(View view) {
                if(e1.getText().toString().compareTo("salil")==0)
                {
                    if(e2.getText().toString().compareTo("12345")==0)
                    {
                        Intent i = new Intent(getApplicationContext(), Page2.class);
                        startActivity(i);
                    }
                    else
                    {
                        no--;
                        t3.show();//wrong username/password toast
                    }
                }
                else
                {
                    no--;
                    t3.show();//wrong username/password toast
                }
             if(no==0)
                 b1.setEnabled(false);//disable butto
            }
        });
    }
}
