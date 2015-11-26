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
import com.qiuhn.gudu.domain.School;
import com.qiuhn.gudu.ui.base.CustomTitleActivity;
import com.qiuhn.gudu.ui.view.ClearEditText;
/**
 * 注册:选择学校
 * @author qiuhn
 *
 */
public class RegisterSelectSchool extends CustomTitleActivity {

	@Bind(R.id.search_bar)
	ClearEditText searchBar;

	@Bind(R.id.lv_search_result)
	ListView mListView;

	private List<School> schoolList = new ArrayList<School>(0);

	private BaseAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_register_select_school);
		super.onCreate(savedInstanceState);
		ButterKnife.bind(this);
		mAdapter = new SchoolAdapter();
		mListView.setAdapter(mAdapter);
	}

	/**
	 * 过滤搜索关键字
	 */
	@OnFocusChange(R.id.search_bar)
	public void searchSchool() {
		String str = searchBar.getText().toString();
		if (str == null) {
			schoolList.clear();
		} else {
			schoolList = SchoolDaoHelper.querySchools(str);
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
		School school = schoolList.get(position);
		Intent intent = new Intent(this,RegisterSelectDepartment.class);
		intent.putExtra("schoolId", school.getId());
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
				convertView = LayoutInflater.from(RegisterSelectSchool.this)
						.inflate(R.layout.item_register_select_school, parent,
								false);
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
			}
			School school = schoolList.get(position);
			holder.tvName.setText(school.getName());
			return convertView;
		}
	}

	static class ViewHolder {
		@Bind(R.id.tv_school_name)
		TextView tvName;

		public ViewHolder(View view) {
			ButterKnife.bind(this, view);
		}
	}
}
