package com.qiuhn.gudu.ui.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

import com.qiuhn.gudu.R;
import com.qiuhn.gudu.common.GuduApplication;
import com.qiuhn.gudu.db.SchoolDaoHelper;
import com.qiuhn.gudu.domain.Department;
import com.qiuhn.gudu.domain.School;

public class RegisterStepOne extends Activity {

	@Bind(R.id.tv_school_select)
	TextView tvSchool;

	@Bind(R.id.tv_depart_select)
	TextView tvDepartment;

	@Bind(R.id.tv_time_select)
	TextView tvTime;

	@Bind(R.id.tv_degree_select)
	TextView tvDegree;

	@Bind(R.id.btn_next)
	Button btnNext;

	private SharedPreferences sp;
	private School selectedSchool;
	private Department selectedDepartment;

	private int time;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_step_one);
		ButterKnife.bind(this);
		sp = this.getSharedPreferences(GuduApplication.SP_REGISTER_SETTING,
				Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE);

	}

	@Override
	protected void onResume() {
		super.onResume();
		initData();
	}

	private void initData() {
		int schoolId = sp.getInt("selected_school_id", -2);
		int departmentId = sp.getInt("selected_department_id", -2);
		time = sp.getInt("selected_school_time", 0);
		selectedSchool = SchoolDaoHelper.getSchool(schoolId);
		selectedDepartment = SchoolDaoHelper.getDepartment(departmentId,
				schoolId);
		if (selectedSchool != null) {
			tvSchool.setText(selectedSchool.getName());
		}
		if (selectedDepartment != null) {
			tvDepartment.setText(selectedDepartment.getName());
		}
		if (time != 0) {
			tvTime.setText(time);
		}
		if (schoolId != -1 && departmentId != -2 && time != 0) {
			btnNext.setVisibility(View.VISIBLE);
		}else{
			btnNext.setVisibility(View.VISIBLE);
		}
	}

	/**
	 * 点击选择学校
	 * 
	 * @param view
	 */
	public void selectSchool(View view) {
		Intent intent = new Intent(this, RegisterSelectSchool.class);
		startActivity(intent);
	}

	/**
	 * 点击选择院系
	 * 
	 * @param view
	 */
	public void selectDepartment(View view) {
		if (selectedSchool == null) {
			Intent intent = new Intent(this, RegisterSelectSchool.class);
			startActivity(intent);
		} else {
			Intent intent = new Intent(this, RegisterSelectDepartment.class);
			startActivity(intent);
		}

	}

	/**
	 * 点击选择学历
	 * 
	 * @param view
	 */
	public void selectDegree(View view) {
		if (selectedDepartment == null) {
			Intent intent = new Intent(this, RegisterSelectDepartment.class);
			startActivity(intent);
		} else {

		}
	}

	/**
	 * 点击选择入学时间
	 * 
	 * @param view
	 */
	public void selectTime(View view) {
		if (selectedDepartment == null) {
			Intent intent = new Intent(this, RegisterSelectDepartment.class);
			startActivity(intent);
		} else {

		}
	}
	/**
	 * 点击下一步
	 * @param view
	 */
	public void nextStep(View view){
		
	}
}
