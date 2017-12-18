package com.ltsh.littlehelper.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

public class ActivityBase extends Activity{
	
	protected void ShowMsg(String pMsg){
		Toast.makeText(this,pMsg,1).show();
	}
	
	protected void OpenActivity(Class<?> pClass){
		Intent _Intent = new Intent();
		_Intent.setClass(this, pClass);
		
		startActivity(_Intent);
	}

}
