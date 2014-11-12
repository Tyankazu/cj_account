/**
 * 
 */
package jp.example.cj_account;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

/**
 * @author b1012234
 *
 */
public class PostJsonTask_Ac extends AsyncTask<String, Integer, Integer> {
	private String response;
	private int statusCode;
    private Activity makeaccountActivity;
    
    public PostJsonTask_Ac(Activity activity) {

        // 呼び出し元のアクティビティ
        this.makeaccountActivity = activity;
    }
	
	@Override
	protected Integer doInBackground(String... contents) {
		// TODO 自動生成されたメソッド・スタブ
		
		// 通信の際に送信するデータを付加
        // 今回の場合はIDとPass
        ArrayList <NameValuePair> params = new ArrayList <NameValuePair>();
        //params.add( new BasicNameValuePair("jsonQuery", contents[0]));
        params.add( new BasicNameValuePair("id", contents[0]));
        params.add( new BasicNameValuePair("pass", contents[1]));
        
		// 送信先URLを指定して通信を確立
		String url="http://rhyth.dip.jp/user_regist.php";
		HttpPost httpPost = new HttpPost(url);
		
		// パラメータの設定
					try {
						httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
						Log.d("httPostQuery", params.toString());
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					DefaultHttpClient client = new DefaultHttpClient();
					HttpResponse httpResponse = null;
					
					try {
						 httpResponse = client.execute(httpPost);

						// ステータスコードを取得
						statusCode = httpResponse.getStatusLine().getStatusCode();

						// レスポンスを取得
						HttpEntity entity = httpResponse.getEntity();
						response = EntityUtils.toString(entity);

						// リソースを解放
						entity.consumeContent();

						// クライアントを終了させる
						client.getConnectionManager().shutdown();
						
					} catch (ClientProtocolException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Log.d("RESPONSE", response);
		            return statusCode;
	}
	
	protected void onPostExecute(Integer result) {
		makeaccountActivity.finish();
	}


}
