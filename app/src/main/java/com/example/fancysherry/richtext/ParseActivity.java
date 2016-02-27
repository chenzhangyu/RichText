package com.example.fancysherry.richtext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.InjectView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.fancysherry.richtext.model.Blog;
import com.example.fancysherry.richtext.model.Paragraph;
import com.example.fancysherry.richtext.util.GsonRequest;

public class ParseActivity extends AppCompatActivity {
  private String url;
  @InjectView(R.id.richtext)
  RichText richText;
  private String html_text;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_parse);
    url = getIntent().getStringExtra("url");
    loadRichText();
    ButterKnife.inject(this);

  }

  private void loadRichText() {
    RequestQueue mQueue = Volley.newRequestQueue(this);
    Map<String, String> params = new HashMap<String, String>();
    params.put("url", url);
    GsonRequest<Blog> richtext_request =
        new GsonRequest<>(Request.Method.POST, "http://139.129.22.121:24300", null,
            params, Blog.class,
            new Response.Listener<Blog>() {
              @Override
              public void onResponse(Blog mBlog) {
                List<Paragraph> items = mBlog.items;
                String title = mBlog.title;
                html_text = "";
                for (Paragraph paragraph : items) {
                  Log.e("data", paragraph.data);
                  if (paragraph.type.equals("text"))
                    html_text +=
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + paragraph.data ;//开头空2格
                  else if (paragraph.type.equals("image"))
                    html_text += "<p><img title=\"\" src=\"" + paragraph.data
                        + "\"></p>";
                }
                runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                    richText.setRichText(html_text);
                  }
                });
              }
            }, new Response.ErrorListener() {
              @Override
              public void onErrorResponse(VolleyError pVolleyError) {
                Log.e("TAG", pVolleyError.getMessage());
              }
            });
    mQueue.add(richtext_request);
  }

}
