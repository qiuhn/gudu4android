package com.qiuhn.gudu.ui.account;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnFocusChange;
import butterknife.OnItemClick;

import com.qiuhn.gudu.R;
import com.qiuhn.gudu.db.SchoolDaoHelper;
import com.qiuhn.gudu.domain.Department;
import com.qiuhn.gudu.ui.base.CustomTitleActivity;
import com.qiuhn.gudu.ui.view.ClearEditText;

public class RegisterSelectDepartment extends CustomTitleActivity{

	
	
	@Bind(R.id.search_bar)
	ClearEditText searchBar;

	@Bind(R.id.lv_search_result)
	ListView mListView;

	private List<Department> schoolList = new ArrayList<Department>(0);

	private BaseAdapter mAdapter;
	
	private int selectSchoolId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_register_select_department);
		super.onCreate(savedInstanceState);
		ButterKnife.bind(this);
		selectSchoolId = getIntent().getIntExtra("schoolId", -1);
		if(selectSchoolId == -1){
			Department d = new Department(-1, "其它", -1);
			schoolList.add(d);
		}
		mAdapter = new SchoolAdapter();
		mListView.setAdapter(mAdapter);
	}

	/**
	 * 过滤搜索关键字
	 */
	@OnFocusChange(R.id.search_bar)
	public void searchSchool() {
		if(selectSchoolId == -1){
			return;
		}
		String str = searchBar.getText().toString();
		if (str == null) {
			schoolList.clear();
		} else {
			schoolList = SchoolDaoHelper.queryDepartments(str, selectSchoolId);
		}
		mAdapter.notifyDataSetChanged();
	}

	/**
	 * 点击学校条目
	 * 
	 * @param position
	 */
	@OnItemClick(R.id.lv_search_result)
	public void onItemClickListener(int position) {
		Department d = schoolList.get(position);
		Intent intent = new Intent(this,RegisterSelectDepartment.class);
		intent.putExtra("schoolId", selectSchoolId);
		intent.putExtra("departmentId", d.getId());
		startActivity(intent);
	}

	private class SchoolAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return schoolList.size();
		}

		@Override
		public Object getItem(int position) {
			return schoolList.get(position);
		}

		@Override
		public long getItemId(int position) {

			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView != null) {
				holder = (ViewHolder) convertView.getTag();
			} else {
				convertView = LayoutInflater.from(RegisterSelectDepartment.this)
						.inflate(R.layout.item_register_select_school, parent,
								false);
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
			}
			Department d = schoolList.get(position);
			holder.tvName.setText(d.getName());
			return convertView;
		}
	}

	static class ViewHolder {
		@Bind(R.id.tv_department_name)
		TextView tvName;

		public ViewHolder(View view) {
			ButterKnife.bind(this, view);
		}
	}
}
