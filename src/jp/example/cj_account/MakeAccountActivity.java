/**
 * 
 */
package jp.example.cj_account;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author b1012234
 *
 */
public class MakeAccountActivity extends Activity {
	
	 
		
		
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.make_account);
	        setTitle("アカウント作成画面");
	        
	        
	        Button button3 = (Button)findViewById(R.id.button3);
	        button3.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	                
	            	//Intent intent2 = new Intent(MakeAccountActivity.this, MakeProfileActivity.class);    
	                
	            	EditText et = (EditText)findViewById(R.id.editText1);
	           	     EditText et2 = (EditText)findViewById(R.id.editText2);
	           	     String s = null;
	           	     s =et.getText().toString();
	           	     String s2 = null;
	           	     s2 = et2.getText().toString();
	           	     String s3 = s + s2;
	           	     String txt = ".txt";
	           	      String filename = s3 + txt;
		            
		                if(s.length() <1  || s2.length() < 8){
		                	Toast.makeText(getBaseContext(), "Notsavefile", Toast.LENGTH_LONG).show();
		                }else {
		                	// Sub 画面を起動
			                Intent intent = new Intent();
			                intent.setClassName("jp.example.cj_account", "jp.example.cj_account.MakeProfileActivity");
			                //startActivity(intent);
			                
			                
		           	   intent.putExtra("FILENAME", filename);
			               startActivity(intent);
			                
		                	String sdcardPath = Environment.getExternalStorageDirectory().getPath();
				            File file = new File(sdcardPath + "/" + filename);		            
				            file.getParentFile().mkdir();
				     
				            FileOutputStream fos;
			            try {
				                fos = new FileOutputStream(file, true);
				                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
				                BufferedWriter bw = new BufferedWriter(osw);
				                //String str = ((EditText) findViewById(R.id.EditTextInput)).getText().toString();
//				                bw.write(s3);
				                bw.flush();
				                bw.close();
				                
			            } catch (Exception e) {
			            	Toast.makeText(getBaseContext(), "Notsavefile", Toast.LENGTH_LONG).show();
			            }
		                Toast.makeText(getBaseContext(), "savefile", Toast.LENGTH_LONG).show();
		                }
		            
	            
	            
		            
		            
//            try{
//		            FileOutputStream out = openFileOutput(filename,MODE_PRIVATE);
//		            OutputStreamWriter writer = new OutputStreamWriter(out);
//		            //PrintWriter writer = new PrintWriter(new OutputStreamWriter(out,"UTF-8"));
//		            writer.write(s3);
//		            writer.flush();
//		            writer.close();
//		            
//		          
//		            } catch (FileNotFoundException e) {
//		              
//		              e.printStackTrace();
//		            }catch(IOException e){
//		           
//		            e.printStackTrace();
//		            }
		            
//		            try{
//		            	InputStream in = openFileInput("filename");
//		            	BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
//			            EditText et3 = (EditText)findViewById(R.id.Test);
//			            
//		            	 while((s3 = reader.readLine())!= null){
//		            	 et3.append(s3);
//		            	 et3.append("\n");
//		            	 reader.close();
//		            	 }
//		            	}catch(IOException e){
//		            	 e.printStackTrace();
//		            	}
	            
	            
	            
	            }
		        	            
	        });
	     
	        }
	
	
	 
}
