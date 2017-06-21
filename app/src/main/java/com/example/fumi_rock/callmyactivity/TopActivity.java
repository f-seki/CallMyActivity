package com.example.fumi_rock.callmyactivity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TopActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
    private static final int REQUEST_TEXT = 0;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //レイアウト生成
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(R.layout.activity_top);

        //ボタン生成
        Button bt = new Button(this);
        bt.setText("入力呼び出し");
        bt.setOnClickListener(this);
        bt.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));
        layout.addView(bt);

        //テキストビュー生成
        textView = new TextView(this);
        textView.setText("");
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(16);
        textView.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));
        layout.addView(textView);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,InputActivity.class);
        intent.putExtra("comment", textView.getText().toString());
        startActivityForResult(intent,REQUEST_TEXT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){

        if(requestCode==REQUEST_TEXT && resultCode==RESULT_OK){
            String res = "";
            Bundle extras = intent.getExtras();
            if(extras != null){
                res = extras.getString("comment");
            }
            textView.setText(res);
        }
    }
}
