package com.qiuhn.gudu.ui.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.qiuhn.gudu.MainActivity;
import com.qiuhn.gudu.R;
import com.qiuhn.gudu.common.GloableUtil;
import com.qiuhn.gudu.common.URLConstants;
import com.qiuhn.gudu.pojo.UserPojo;
import com.qiuhn.gudu.ui.view.LoadingDialog;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.ButterKnife;

public class Login extends Activity {
	public static final String TAG = "Login";

	// @Bind(R.id.edt_Name)
	EditText actvName;

	// @Bind(R.id.edt_Pass)
	EditText actvPwd;

	private RequestQueue mRequestQueue;

	private LoadingDialog mDialog;

	// private RequestQueue mRequestQueue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);
		actvName = (EditText) findViewById(R.id.edt_Name);
		actvPwd = (EditText) findViewById(R.id.edt_Pass);
		ButterKnife.bind(this);
		mRequestQueue = Volley.newRequestQueue(this);
		mDialog = LoadingDialog.createDialog(this);
		mDialog.setMessage("正在登录");
	}

	public void login(View view) {
		String url = URLConstants.url_login;
		actvName.getText();
		String username = actvName.getText().toString();
		String pwd = actvPwd.getText().toString();
		if ("".equals(username)) {
			Toast.makeText(this, "用户名不能为空", Toast.LENGTH_LONG).show();
			return;
		}
		if ("".equals(pwd)) {
			Toast.makeText(this, "密码不能为空", Toast.LENGTH_LONG).show();
			return;
		}
		String imie = GloableUtil.getIMEI(this);
		if (imie == null) {
			imie = username;
		}
		url = url.replace("{username}", username).replace("{pwd}", pwd).replace("{mobileNo}", imie);
		mDialog.show();
		JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject json) {
				try {
					int code = json.getInt("code");
					switch (code) {
					case 1:
						mDialog.cancel();
						String obj = json.getString("obj");
						Gson gson = new Gson();
						UserPojo pojo = gson.fromJson(obj, UserPojo.class);
						
						Intent intent = new Intent(Login.this, MainActivity.class);
						startActivity(intent);
						finish();
						break;
					case 101:
						Toast.makeText(Login.this, "密码错误", Toast.LENGTH_LONG).show();
						break;
					case 102:
						Toast.makeText(Login.this, "用户不存在", Toast.LENGTH_LONG).show();
						break;
					}
				} catch (JSONException e) {
					e.printStackTrace();
					mDialog.cancel();
				}
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Log.d(TAG, error.getMessage());
				mDialog.cancel();
				Toast.makeText(Login.this, error.getMessage(), Toast.LENGTH_LONG).show();
			}
		});
		mRequestQueue.add(request);
	}
}
