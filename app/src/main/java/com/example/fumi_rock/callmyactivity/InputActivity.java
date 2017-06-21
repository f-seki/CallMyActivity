package com.example.fumi_rock.callmyactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by fumi-rock on 2017/06/22.
 */

class InputActivity extends Activity implements View.OnClickListener{
    private static final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
    private static final int MP = ViewGroup.LayoutParams.MATCH_PARENT;
    private EditText editText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setResult(Activity.RESULT_CANCELED);
        //インテントから値取得
        String text = "";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            text = extras.getString("comment");
        }
        //レイアウト生成
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
        //ボタン生成
        Button button = new Button(this);
        button.setText("(＾o＾)");
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));
        layout.addView(button);
        //エディットテキスト生成
        editText = new EditText(this);
        editText.setText(text);
        editText.setLayoutParams(new LinearLayout.LayoutParams(MP,WC));
        layout.addView(editText);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("comment",editText.getText().toString());
        setResult(Activity.RESULT_OK,intent);

        finish();
    }
}
