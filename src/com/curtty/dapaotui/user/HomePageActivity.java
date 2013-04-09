package com.curtty.dapaotui.user;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.curtty.dapaotui.BaseNaviActivity;
import com.curtty.dapaotui.R;
import com.curtty.dapaotui.common.Utils;
import com.curtty.dapaotui.data.User;

public class HomePageActivity extends BaseNaviActivity implements
		OnClickListener {
	EditText mName;
	TextView mPhone, mGender, mBirth, mSchool, mClass;
	ImageView mAvatar;
	TextView mLikeCnt;
	User mTmpUser;
	private static final int REQUEST_TAKE_PHOTO = 3;
	private static final int REQUEST_CROP_PHOTO = 4;

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_homepage);
		mAvatar = (ImageView) findViewById(R.id.avatar);
		mLikeCnt = (TextView) findViewById(R.id.like_cnt);
		mAvatar = (ImageView) findViewById(R.id.avatar);
		mName = (EditText) findViewById(R.id.realname);
		mPhone = (TextView) findViewById(R.id.user_name);
		mGender = (TextView) findViewById(R.id.gender);
		mBirth = (TextView) findViewById(R.id.birthday);
		mSchool = (TextView) findViewById(R.id.school);
		mClass = (TextView) findViewById(R.id.class_grade);
		findViewById(R.id.phone_bind).setOnClickListener(this);
		mAvatar.setOnClickListener(this);
		mSchool.setOnClickListener(this);
		mClass.setOnClickListener(this);
		mGender.setOnClickListener(this);
		mBirth.setOnClickListener(this);
	}

	ProgressDialog mProgressDialog;

	public void takePhoto() {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, REQUEST_TAKE_PHOTO);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.phone_bind:
			break;
		case R.id.avatar:
			takePhoto();
			break;
		case R.id.school: {
			FragmentTransaction ft = getSupportFragmentManager()
					.beginTransaction();
			Fragment prev = getSupportFragmentManager().findFragmentByTag(
					"school");
			if (prev != null) {
				ft.remove(prev);
			}
		}
			break;
		case R.id.class_grade: {
		}
			break;
		case R.id.gender:
			new AlertDialog.Builder(this)
					.setTitle("Select Gender")
					.setItems(R.array.gender,
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dlg,
										int which) {
								}
							}).show();
			break;
		case R.id.birthday:
			Calendar birth = Calendar.getInstance();
			new DatePickerDialog(this, new OnDateSetListener() {

				@Override
				public void onDateSet(DatePicker view, int year,
						int monthOfYear, int dayOfMonth) {
					Calendar birth = Calendar.getInstance();
					birth.set(Calendar.YEAR, year);
					birth.set(Calendar.MONTH, monthOfYear);
					birth.set(Calendar.DATE, dayOfMonth);
				}
			}, birth.get(Calendar.YEAR), birth.get(Calendar.MONTH), birth
					.get(Calendar.DATE)).show();
			break;
		}

	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode != Activity.RESULT_OK) {
			return;
		}
		switch (requestCode) {
		case REQUEST_TAKE_PHOTO:
			Bitmap photo = data.getParcelableExtra("data");
			if (photo != null) {
				Intent intent = Utils.getCropImageIntent(photo);
				startActivityForResult(intent, REQUEST_CROP_PHOTO);
			}
			break;
		case REQUEST_CROP_PHOTO:
			Bitmap bmpAvatar = data.getParcelableExtra("data");
			mAvatar.setImageBitmap(bmpAvatar);
			break;
		}
	}

}
