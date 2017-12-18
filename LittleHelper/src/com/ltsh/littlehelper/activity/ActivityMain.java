package com.ltsh.littlehelper.activity;

import android.os.Bundle;
import android.widget.GridView;

import com.ltsh.littlehelper.R;
import com.ltsh.littlehelper.adapter.AdapterAppGrid;

public class ActivityMain extends ActivityFrame {

	private GridView gvAppGrid;		//原在main_body.xml中未定义ID，这儿就找不到,不能用对象代替控件。
	private AdapterAppGrid mAdapterAppGrid;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AppendMainBody(R.layout.main_body);
		InitVariable();
		InitView();
		InitListeners();
		BindData();
	}
	
	public void InitVariable(){
		mAdapterAppGrid = new AdapterAppGrid(this);	//变量初始化
	}
	
	public void InitView(){
		gvAppGrid =(GridView)findViewById(R.id.gvAppGrid);
	}
	
	public void InitListeners(){
		
	}
	
	public void BindData(){
		gvAppGrid.setAdapter(mAdapterAppGrid);
	}
}
