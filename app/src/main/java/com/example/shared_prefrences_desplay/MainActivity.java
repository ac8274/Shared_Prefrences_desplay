package com.example.shared_prefrences_desplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Text_Input;
    TextView Counter_Display;
    Button Counter_Increase_Button;
    Button Counter_Reset_Button;
    Button Exit_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Text_Input = findViewById(R.id.Text_Input);
        Counter_Display = findViewById(R.id.Counter_Display);
        Counter_Increase_Button = findViewById(R.id.Counter_Increase_Button);
        Counter_Reset_Button = findViewById(R.id.Counter_Reset_Button);
        Exit_Button = findViewById(R.id.Exit_Button);
        Load_SharedPreferences_file();
    }

    public void Load_SharedPreferences_file()
    {
        android.content.SharedPreferences settings=getSharedPreferences("SCORE_SAVE",MODE_PRIVATE);
        Display_change(Text_Input,settings.getString("Text_Input_content","Name"));
        Display_change(Counter_Display,settings.getString("Counter_Score","0"));
    }

    public void Program_Finish(View view) {
        android.content.SharedPreferences settings=getSharedPreferences("SCORE_SAVE",MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("Text_Input_content",Get_Display_String(Text_Input));
        editor.putString("Counter_Score",Get_Display_String(Counter_Display));
        editor.commit();
        finish();
        System.exit(0);
    }

    public void Reset_Counter(View view) {
        Display_change(Counter_Display,"0");
    }

    public void Counter_Increase(View view) {
        int score = Integer.parseInt(Get_Display_String(Counter_Display));
        Display_change(Counter_Display,Integer.toString(score +1));
    }

    public void Display_change(View view,String text)
    {
        if(view == Text_Input)
        {
            Text_Input.setText(text);
        }
        else
        {
            Counter_Display.setText(text);
        }
    }

    public String Get_Display_String(View view)
    {
        if (view == Text_Input)
        {
            return String.valueOf(Text_Input.getText());
        }
        else
        {
            return String.valueOf(Counter_Display.getText());
        }
    }
}