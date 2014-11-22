package jp.example.cj_account;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.os.Build;

public class LoginActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("アカウント画面");
		//setContentView(R.layout.sub);
		

		Button login_btn = (Button)findViewById(R.id.login_Button);
		Button mab_btn = (Button)findViewById(R.id.make_account_Button);
		
		login_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Sub 画面を起動
                Intent intent = new Intent(LoginActivity.this,
                		SubTopActivity.class);
                startActivity(intent);
            }
        });
	        
		mab_btn.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	                // Sub 画面を起動
	                Intent intent = new Intent(LoginActivity.this,
	                		MakeAccountActivity.class);
	                startActivity(intent);
	            }
	        });
	 
	}
	
	 public boolean dispatchKeyEvent(KeyEvent event) {
         if (event.getAction()==KeyEvent.ACTION_DOWN) {
             switch (event.getKeyCode()) {
             case KeyEvent.KEYCODE_BACK:
                 // ダイアログ表示など特定の処理を行いたい場合はここに記述
            	 Toast.makeText(getBaseContext(), "戻るキーは無効です", Toast.LENGTH_LONG).show();	
                 // 親クラスのdispatchKeyEvent()を呼び出さずにtrueを返す
                 return true;
             }
         }
         return super.dispatchKeyEvent(event);
     }

}
