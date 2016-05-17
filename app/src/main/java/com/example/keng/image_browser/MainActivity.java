package com.example.keng.image_browser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements android.view.View.OnClickListener {

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<View> mViews = new ArrayList<View>();
    private View view;
    //四个线性布局，每个代表一个页面的按钮
    private LinearLayout mFirst;
    private LinearLayout mSecond;
    private LinearLayout mThird;
    private LinearLayout mForth;
    //四个按键
    private ImageButton FirstButton;
    private ImageButton SecondButton;
    private ImageButton ThirdButton;
    private ImageButton ForthButton;

    private TextView first_text;
    private TextView second_text;
    private TextView third_text;
    private TextView forth_text;

    public ImageButton First_Button;
    public ImageButton Second_Button;
    private ImageButton Third_Button;
    private ImageButton Forth_Button;

    private int first_number = 0;
    private int[] First_Image_Ids = new int[]{
            R.drawable.first_view1,R.drawable.second_view1,R.drawable.third_view1
    };

    private int second_number = 0;
    private int[] Second_Image_Ids = new int[]{
            R.drawable.first_view2,R.drawable.second_view2
    };

    private int third_number = 0;
    private int[] Third_Image_Ids = new int[]{
            R.drawable.first_view3,R.drawable.second_view3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        initView();
        initViewPage();
        initEvent();
    }


    public void firstbuttonclick(View view)
    {
        if(first_number<First_Image_Ids.length-1){
            First_Button = (ImageButton) findViewById(R.id.first_button);
            if(first_number==0){
                First_Button.setBackgroundResource(R.drawable.second_view1);
                first_number++;
            }else {
                First_Button.setBackgroundResource(R.drawable.third_view1);
                first_number++;
            }
        }
        else{

        }
    }

    public void secondbuttonclick(View view)
    {
        Second_Button=(ImageButton)findViewById(R.id.second_button);
        Second_Button.setBackgroundResource(R.drawable.second_view2);
    }

    public void thirdbuttonclick(View view)
    {
        Third_Button=(ImageButton)findViewById(R.id.third_button);
        Third_Button.setBackgroundResource(R.drawable.second_view3);
    }

    private void initEvent() {
        FirstButton.setOnClickListener(this);
        SecondButton.setOnClickListener(this);
        ThirdButton.setOnClickListener(this);
        ForthButton.setOnClickListener(this);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /*
            *当View左右滑动的时候触发
             */
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageSelected(int arg0) {
                int currentItem = mViewPager.getCurrentItem();
                switch (currentItem) {
                    case 0:
                        resetImage();
                        FirstButton.setImageResource(R.drawable.first_pressed);
                        first_text.setTextColor(0xffee2c2c);
                        first_number=0;
                        First_Button = (ImageButton) findViewById(R.id.first_button);
                        First_Button.setBackgroundResource(R.drawable.first_view1);
                        break;
                    case 1:
                        resetImage();
                        SecondButton.setImageResource(R.drawable.second_pressed);
                        second_text.setTextColor(0xffee2c2c);
                        Second_Button=(ImageButton)findViewById(R.id.second_button);
                        Second_Button.setBackgroundResource(R.drawable.first_view2);
                        break;
                    case 2:
                        resetImage();
                        ThirdButton.setImageResource(R.drawable.third_pressed);
                        third_text.setTextColor(0xffee2c2c);
                        Third_Button=(ImageButton)findViewById(R.id.third_button);
                        Third_Button.setBackgroundResource(R.drawable.first_view3);
                        break;
                    case 3:
                        resetImage();
                        ForthButton.setImageResource(R.drawable.forth_pressed);
                        forth_text.setTextColor(0xffee2c2c);
                        Forth_Button = (ImageButton) findViewById(R.id.forth_button);
                        Forth_Button.setBackgroundResource(R.drawable.first_view4);
                    default:
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void resetImage() {
        FirstButton.setImageResource(R.drawable.first_unpressed);
        SecondButton.setImageResource(R.drawable.second_unpressed);
        ThirdButton.setImageResource(R.drawable.third_unpressed);
        ForthButton.setImageResource(R.drawable.forth_unpressed);
        first_text.setTextColor(0xff9c9c9c);
        second_text.setTextColor(0xff9c9c9c);
        third_text.setTextColor(0xff9c9c9c);
        forth_text.setTextColor(0xff9c9c9c);

    }

    /*
    *初始化Viewpage
     */
    private void initViewPage() {
        //初始化三个布局
        LayoutInflater mLayoutInflater=LayoutInflater.from(this);
        View tab01=mLayoutInflater.inflate(R.layout.viewpage1, null);
        View tab02=mLayoutInflater.inflate(R.layout.viewpage2,null);
        View tab03=mLayoutInflater.inflate(R.layout.viewpage3,null);
        View tab04=mLayoutInflater.inflate(R.layout.viewpage4,null);

        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);
        mViews.add(tab04);

        //适配器初始化并配置
        mPagerAdapter=new PagerAdapter() {

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0==arg1;
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
    }

    /*
    *初始化设置
     */
    private void initView() {
        mViewPager=(ViewPager)findViewById(R.id.id_viewpager);
        /*
        初始化四个界面
         */
        mFirst=(LinearLayout)findViewById(R.id.Browser_first);
        mSecond=(LinearLayout)findViewById(R.id.Browser_second);
        mThird=(LinearLayout)findViewById(R.id.Browser_third);
        mForth= (LinearLayout) findViewById(R.id.Browser_forth);
        /*
        *初始化四个图片按钮
         */
        FirstButton=(ImageButton)findViewById(R.id.first_image);
        SecondButton=(ImageButton)findViewById(R.id.second_image);
        ThirdButton=(ImageButton)findViewById(R.id.third_image);
        ForthButton= (ImageButton) findViewById(R.id.forth_image);

        first_text = (TextView) findViewById(R.id.first_text);
        second_text = (TextView) findViewById(R.id.second_text);
        third_text = (TextView) findViewById(R.id.third_text);
        forth_text = (TextView) findViewById(R.id.forth_text);

    }

    /*
    *判断哪个界面需要显示，以及设置显示图片
     */
    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()){
            case R.id.first_image:
                mViewPager.setCurrentItem(0);
                resetImage();
                FirstButton.setImageResource(R.drawable.first_pressed);
                first_text.setTextColor(0xffee2c2c);
                first_number=0;
                First_Button = (ImageButton) findViewById(R.id.first_button);
                First_Button.setBackgroundResource(R.drawable.first_view1);
                break;
            case R.id.second_image:
                mViewPager.setCurrentItem(1);
                resetImage();
                SecondButton.setImageResource(R.drawable.second_pressed);
                second_text.setTextColor(0xffee2c2c);
                Second_Button=(ImageButton)findViewById(R.id.second_button);
                Second_Button.setBackgroundResource(R.drawable.first_view2);
                break;
            case R.id.third_image:
                mViewPager.setCurrentItem(2);
                resetImage();
                ThirdButton.setImageResource(R.drawable.third_pressed);
                third_text.setTextColor(0xffee2c2c);
                Third_Button=(ImageButton)findViewById(R.id.third_button);
                Third_Button.setBackgroundResource(R.drawable.first_view3);
                break;
            case R.id.forth_image:
                mViewPager.setCurrentItem(3);
                resetImage();
                ForthButton.setImageResource(R.drawable.forth_pressed);
                forth_text.setTextColor(0xffee2c2c);
                Forth_Button = (ImageButton) findViewById(R.id.forth_button);
                Forth_Button.setBackgroundResource(R.drawable.first_view4);
            default:
                break;
        }

    }
}