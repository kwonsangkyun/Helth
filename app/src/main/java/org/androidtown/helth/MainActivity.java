package org.androidtown.helth;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    MyAdapter myAdapter;

    public static final int REQUEST_CODE_ANOTHER = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.first);
        setContentView(R.layout.activity_main);

        pager=(ViewPager) findViewById(R.id.pager);
        myAdapter=new MyAdapter();
        pager.setAdapter(myAdapter);
    }
    public  boolean onCreateOptionsMenu(Menu menu)
    {
     getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            default:
               // Toast.makeText(this,"설정메뉴선택",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),AnotherActivity.class);
                startActivityForResult(intent,REQUEST_CODE_ANOTHER);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);


    }

    public void onButton1Clicked(View v){

        finish();

    }

    class MyAdapter extends PagerAdapter{
        int NumberOfPages=2;

        int[] colors={
            0xFF606060,0xFF00FF00};

        public int getCount(){
            return NumberOfPages;
        }



        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
        TextView textView = new TextView(MainActivity.this);
            textView.setTextColor(Color.BLACK);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setTextSize(12);
            textView.setText(String.valueOf(position)+" 페이지번호");
        TextView textView1 =new TextView(MainActivity.this);
            textView1.setTextSize(30);
            textView1.setTypeface(Typeface.DEFAULT_BOLD);
            textView1.setText("심박수"+String.valueOf(position));

            TextView textView2 =new TextView(MainActivity.this);
            textView2.setTextSize(30);
            textView2.setTypeface(Typeface.DEFAULT_BOLD);
            textView2.setText("GPS"+String.valueOf(position));

       LinearLayout layout = new LinearLayout(MainActivity.this);
            layout.setOrientation(LinearLayout.VERTICAL);
            ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,ActionBar.LayoutParams.MATCH_PARENT);

            //layout.setBackgroundColor(colors[position]);
            layout.setLayoutParams(layoutParams);
            layout.addView(textView);
            layout.addView(textView1);
            layout.addView(textView2);
            final int page = position;

            container.addView(layout);
            return layout;

        }

        public boolean isViewFromObject(View view,Object object){
            return view == object;
        }
    }

}
