package com.example.fatmaali.activity119;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Viewpager1 extends AppCompatActivity {
    ViewPager viewPager;
    private int[] images = {R.drawable.ic_email_black_24dp, R.drawable.ic_help_black_24dp, R.drawable.ic_home_black_24dp, R.drawable.ic_settings_black_24dp, R.drawable.ic_share_black_24dp};
    ArrayList<item> list= new ArrayList<item>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager1);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        for (int i = 0; i <images.length ; i++) {
            list.add(new item("image:"+i,images[i]));
        }
        Swipe_page swipe = new Swipe_page(list,this);
        viewPager.setAdapter(swipe);
    }
}

class Swipe_page extends PagerAdapter{
    LayoutInflater LyIn ;
    ArrayList<item>items = new ArrayList<>();
    private Context context;

    public Swipe_page(ArrayList<item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LyIn=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = LyIn.inflate(R.layout.row_item,container,false);
        TextView txt=(TextView)view.findViewById(R.id.txt_row_viewpager);
        ImageView image=(ImageView)view.findViewById(R.id.img_viewPager);
        image.setImageResource(items.get(position).getImage_id());
        txt.setText(items.get(position).getName());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
