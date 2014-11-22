/**
 * 
 */
package jp.example.cj_account;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author b1012234
 *
 */
public class MakeAccountActivity extends Activity {
	
	private Activity makeaccountActivity;
			
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.make_account);
	        setTitle("アカウント作成画面");
	        makeaccountActivity = this;
	        	        
	        Button sign_btn = (Button)findViewById(R.id.sign_button);	        	        
	        sign_btn.setOnClickListener(new OnClickListener() {	        	
	            public void onClick(View v) {
	            	//String body="";
	            	
	            	EditText id = (EditText) findViewById(R.id.makeId);
					String s = id.getText().toString();
					
					EditText pass = (EditText) findViewById(R.id.makePass);
					String s2 = pass.getText().toString();
					
					HttpClient httpClient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost("rhyth.dip.jp/login_json.php");
					
					JSONObject json = new JSONObject();
					try {
						json.accumulate("id",s);
						json.accumulate("pass",s2);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					PostJsonTask_Ac pjta = new PostJsonTask_Ac(makeaccountActivity);
					pjta.execute(json.toString());
					
		                	// Sub 画面を起動
			                Intent intent = new Intent();
			                intent.setClassName("jp.example.cj_account", "jp.example.cj_account.SubTopActivity");
			                startActivity(intent);
			                Toast.makeText(getBaseContext(), "登録しました", Toast.LENGTH_LONG).show();		                		           	                   	            
	            }
		        	            
	        });;
	        
	        Button back_btn = (Button)findViewById(R.id.backButton);
	        back_btn.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	                	            	
		                	// Sub 画面を起動
			                Intent intent2 = new Intent();
			                intent2.setClassName("jp.example.cj_account", "jp.example.cj_account.LoginActivity");
			                startActivity(intent2);
			                	                		           	                   	            
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
