package com.ltsh.littlehelper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.ltsh.littlehelper.R;

public class AdapterAppGrid extends BaseAdapter {

	private class Holder {
		ImageView ivIcon;
		TextView tvName;
	}

	private Integer[] mImageInteger = { R.drawable.grid_payoun,	//图片数组，直接读出。
			R.drawable.grid_bill, R.drawable.grid_rsport,
			R.drawable.grid_account_book, R.drawable.grid_payoun,
			R.drawable.grid_user, };

	private String[] mImageString = new String[6];	//定义主页的文字数组
	private Context mContext;

	public AdapterAppGrid(Context pContext) {	//构造函数中读出文字。
		mContext = pContext;
		//用   pContext.getString(resId)
		mImageString[0] = pContext.getString(R.string.appGridTextPayoutAdd);
		mImageString[1] = pContext.getString(R.string.appGridTextPayoutManage);
		mImageString[2] = pContext
				.getString(R.string.appGridTextStatistiosManage);
		mImageString[3] = pContext
				.getString(R.string.appGridTextAccountBookManage);
		mImageString[4] = pContext
				.getString(R.string.appGridTextCategoryManage);
		mImageString[5] = pContext.getString(R.string.appGridTextUserManage);
	}

	@Override
	public int getCount() {		//得到计数。
		return mImageString.length;
	}

	@Override
	public Object getItem(int position) {  //得到项目(位置)
		return mImageString[position];
	}

	@Override
	public long getItemId(int position) {	// 得到项目的ID(位置）
		return position;	//返回数组的数字
	}

	@Override		//得到视图，生成布局
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder _Holder;

		if (convertView == null) {	//如果布局不为空.
			LayoutInflater _LayoutInflater = LayoutInflater.from(mContext);
			convertView = _LayoutInflater
					.inflate(R.layout.main_body_item, null);
			_Holder = new Holder();
			_Holder.ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon); //得到图片
			_Holder.tvName = (TextView) convertView.findViewById(R.id.tvName);	//得到文字
			convertView.setTag(_Holder); // 设置标签，转换成布局
		} else {
			_Holder = (Holder) convertView.getTag();	//不为空，直接取tag.
		}

		_Holder.ivIcon.setImageResource(mImageInteger[position]);	//获得数组的 Icon
		
		LinearLayout.LayoutParams _LayoutParams = new LinearLayout.LayoutParams(50,50);
		_Holder.ivIcon.setLayoutParams(_LayoutParams);
		_Holder.ivIcon.setScaleType(ImageView.ScaleType.FIT_XY);
		
		
		_Holder.tvName.setText(mImageString[position]);		//获得string
		return convertView;
	}
	
	//由于在上二行把数组的[],用错成() 。导致不能显示Grid控件！！
	//下面二个方法也是用()后，变成要补充的方法，和教程不同，
/*	private CharSequence mImageString(int position) {
		return null;
	}

	private int mImageInteger(int position) {
		return 0;
	}*/
}
