package com.hellocsu.testlogin;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	private EditText studentID,password; 
	private TextView Result;
	private String userIDstr;
	String b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnlogin = (Button) findViewById(R.id.button1);  
        btnlogin.setOnClickListener(this); 
        studentID=(EditText)findViewById(R.id.editText1);
        password = (EditText) findViewById(R.id.editText2);  
        Result = (TextView) findViewById(R.id.textView3); 
        btnlogin.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		try{
		userIDstr=studentID.getText().toString();
    	int i = Integer.parseInt(userIDstr);
    	//testLoginService发布在下列地址，将会执行public方法Login
        String serviceUrl = "http://198.74.97.66:8080/axis2/services/LoginService?wsdl";  
        String methodName = "Login";  
        SoapObject request = new SoapObject("http://ws.apache.org/axis2",  
                methodName);  
        //建立请求，传入参数
        request.addProperty("userID", i);
        request.addProperty("password", password.getText().toString()); 
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(  
                SoapEnvelope.VER11);  
        envelope.bodyOut = request;  
        HttpTransportSE ht = new HttpTransportSE(serviceUrl);  
        ht.call(null, envelope);  
        //获取返回结果
        if (envelope.getResponse() != null)  
        {  
            SoapObject soapObject = (SoapObject) envelope.getResponse();  
            int s=(Integer) soapObject.getProperty("userID"); 
            if(s<=0){
            	 Result.setText("你确定WebServiceZ正确运行了么？");
            }
            else{
            	Result.setText("大三了就不要装新生了。。。。");
            }
        }  
        else  
        {  
            Result.setText("你确定WebServiceZ正确运行了么？");  
        }
        /*Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();*/
	}
		catch (Exception e)  
        {  
            Result.setText("调用WebService错误.");  
        }  
	}
}
