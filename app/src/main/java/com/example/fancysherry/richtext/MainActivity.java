package com.example.fancysherry.richtext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
  @InjectView(R.id.url)
  EditText url_edittext;
  private Activity activity;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);
    activity = this;
  }

  @OnClick(R.id.parse_button)
  public void onClick(View mView) {
    if (mView.getId() == R.id.parse_button) {
      String url = url_edittext.getText().toString();
      Intent mIntent = new Intent(activity, ParseActivity.class);
      mIntent.putExtra("url", url);
      startActivity(mIntent);
    }
  }
}
