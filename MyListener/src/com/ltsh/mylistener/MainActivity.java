package com.ltsh.mylistener;

import com.ltsh.mytext.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity {
	
	private Button mButton;			//定义按钮对象
	private TimePicker mTimePicker; //定义时间对象
	
	private CheckBox eatBox;		//定义多选按钮
	private CheckBox sleepBox;
	
	private RadioGroup mRadioGroup; // 定义对象
	private RadioButton femaleButton;
	private RadioButton maleButton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//得到按钮控件对象、创建按钮监听器对象并绑定按钮对象。
		mButton = (Button)findViewById(R.id.okButton);
		ButtonListener buttonListener = new ButtonListener();
		mButton.setOnClickListener(buttonListener);
		
		//得到时间控件对象、创建时间监听器对象和绑定时间控件。
		mTimePicker = (TimePicker) findViewById(R.id.timePicker);
		TimeListener timeListener = new TimeListener(); // 定义时间监听器
		mTimePicker.setOnTimeChangedListener(timeListener); // 绑定到时间对象上。

		//得到多选按钮控件对象、创建多选按钮监听器对象和绑定多选按钮控件。
		eatBox = (CheckBox) findViewById(R.id.eatId); // 找出对象
		sleepBox = (CheckBox) findViewById(R.id.sleepId);
		BoxClickListener boxListener = new BoxClickListener();// 创建监听器对象
		eatBox.setOnClickListener(boxListener);
		sleepBox.setOnClickListener(boxListener);

		//得到单选按钮控件对象、创建单按钮监听器对象和绑定单选按钮控件。
		mRadioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
		femaleButton = (RadioButton) findViewById(R.id.femaleButtonId);
		maleButton = (RadioButton) findViewById(R.id.maleButtonId);
		RadioGroupListener radioListener = new RadioGroupListener();
		mRadioGroup.setOnCheckedChangeListener(radioListener);	//此对象监听了RadioGroup
		
	}
	
	//创建按钮监听器内部类并实现接口
	class ButtonListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			System.out.println("按钮 Button 触动");			
		}
	}

	//创建时间监听器内部类并实现接口
	class TimeListener implements OnTimeChangedListener {
		/**
		 * view:该对象代表着TimePicker hourOfDay:用户所选择的小时 minute:用户所选择的分钟
		 */
		@Override
		public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
			System.out.println("Hour:" + hourOfDay + ",minute:" + minute);
		}
	}

	//创建多选按钮监听器内部类并实现接口
    class BoxClickListener implements OnClickListener{
		@Override
		public void onClick(View view) {
			CheckBox box = (CheckBox)view;	//向下转型对象
			System.out.println("Id-->"+box.getId());
			//判断是那一个控件被选中。
			if(box.getId() == R.id.eatId){
				System.out.println("eatBox 触动");
			}
			else if(box.getId() == R.id.sleepId){
				System.out.println("sleepBox 触动");
			}
		}   	
    }
	
	class RadioGroupListener implements OnCheckedChangeListener {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			System.out.println("选中了RadioGroup");
			if (checkedId == femaleButton.getId()) {
				System.out.println("选中了female");
			}else if(checkedId == maleButton.getId()){
					System.out.println("选中了male");
			}
		}
	}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
