/**
 * 
 */
package jp.example.cj_account;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author b1012234
 *
 */
public class MakeProfileActivity extends Activity {
	//MakeAccountActivity maa =new MakeAccountActivity();
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makeprofile);
        setTitle("プロフィール作成画面");
        
        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	 String str10 = ((EditText) findViewById(R.id.editText10)).getText().toString();
                 String str11 = ((EditText) findViewById(R.id.editText11)).getText().toString();
                 String str12 = ((EditText) findViewById(R.id.editText12)).getText().toString();
                 String str13 = ((EditText) findViewById(R.id.editText13)).getText().toString();
                 String str14 = ((EditText) findViewById(R.id.editText14)).getText().toString();
            	if(str10.length() <1  || str11.length() < 1 || str12.length() < 1 || str13.length() < 1 || str14.length() < 1){
                	Toast.makeText(getBaseContext(), "Notsavefile", Toast.LENGTH_LONG).show();
                }else {
            	
                // Sub 画面を起動
                Intent intent = new Intent();
                intent.setClassName("jp.example.cj_account", "jp.example.cj_account.SubTopActivity");
                startActivity(intent);
                finish();
                 
                Intent intent2 =getIntent();
                String filename2 = intent2.getStringExtra("FILENAME");
	       	      //String filename2 = "test";
               String filePath = Environment.getExternalStorageDirectory().getPath() + "/"+ filename2;
                System.out.println(filename2);
                
                FileOutputStream fos = null;
            	BufferedWriter bw = null;
                
                File file = new File(filePath);
               // file.getParentFile().mkdir();

               try {
            	   fos = new FileOutputStream(file);
                    //FileOutputStream fos = openFileOutput(filePath,MODE_APPEND);
                    //fos = new FileOutputStream(file, true);
                    OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                    bw = new BufferedWriter(osw);

                    //String str = "アプリケーションデータ領域への書き込み\nテストデータ";
                    //writer.write(str);
                	 
                  bw.write(str10);
                  bw.write("\n");
                  bw.write(str11);
                  bw.write("\n");
                  bw.write(str12);
                  bw.write("\n");
                  bw.write(str13);
                  bw.write("\n");
                  bw.write(str14);
 //                 bw.write("\n");
//                  System.out.println("書き込みました");
                  bw.flush();
                   bw.close();
                   Toast.makeText(getBaseContext(), "savefile", Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                	System.out.println("ファイルありません");
                } catch (IOException e) {
                	System.out.println("IO");
               }
                
//                try {
//                	FileOutputStream stream = openFileOutput(filePath,MODE_PRIVATE);
//                    OutputStreamWriter bw = new OutputStreamWriter(stream, "UTF-8");
//                    
//                	bw.write(str10);
//                    bw.write("\n");
//                    bw.write(str11);
//                    bw.write("\n");
//                    bw.write(str12);
//                    bw.write("\n");
//                    bw.write(str13);
//                    bw.write("\n");
//                    bw.write(str14);
//                    bw.write("\n");
//                    
//                    stream.close();
//                    bw.close();
//                    Toast.makeText(getBaseContext(), "savefile", Toast.LENGTH_LONG).show();
//                } catch (FileNotFoundException e) {
//                } catch (Exception e) {
//                }
                }
           }
        });
    }

}
