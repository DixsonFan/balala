package com.dixson.sharedparking;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.dixson.sharedparking.sharedparking.i.view.IFragment;
import com.dixson.sharedparking.sharedparking.map.view.MapFragment;
import com.dixson.sharedparking.sharedparking.park.view.ParkFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener {


    private List<TabItem> tabItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parking_main);
        initTabData();
        initTabHost();
    }

    private  void initTabData(){

        tabItemList = new ArrayList<TabItem>();

        //添加地图Tab
        tabItemList.add(new TabItem(R.drawable.main_map,R.drawable.main_map_press,R.string.main_map, MapFragment.class));
       //添加我Tab
        tabItemList.add(new TabItem(R.drawable.main_i,R.drawable.main_i_press,R.string.main_i,IFragment.class));
        //添加停车Tab
        tabItemList.add(new TabItem(R.drawable.main_park,R.drawable.main_park_press,R.string.main_park, ParkFragment.class));

    }

    //初始化选项卡视图
    private void initTabHost(){
        //获取fragmentTabHost
       FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //绑定TabHost(绑定body)
        fragmentTabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);
        //去掉分割线
        fragmentTabHost.getTabWidget().setDividerDrawable(null);
        for (int i = 0; i < tabItemList.size();++i)
        {
              TabItem tabItem = tabItemList.get(i);
              //绑定fragment（把Fragment添加到FragmentTabhost组件上面
            //newTabSpec代表Tab名字,
            // setIndicator 图片tab样式自己做
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(tabItem.getTitleString())
                    .setIndicator(tabItem.getView());

            //添加Fragment
            //tabSpec:选项卡
            fragmentTabHost.addTab(tabSpec,tabItem.getFragmentClass(),tabItem.getBundle());
            //给Tab按钮设置背景
            fragmentTabHost.getTabWidget()
                    .getChildTabViewAt(i)
                    .setBackgroundColor(getResources().getColor(R.color.colorAccent));
            //监听点击
            fragmentTabHost.setOnTabChangedListener(this);
            if (i == 0){
                tabItem.setChecked(true);
            }
        }
    }

    @Override
    public void onTabChanged(String tabId) {

     for (int i = 0; i < tabItemList.size(); ++i)
     {
         TabItem tabItem = tabItemList.get(i);
         if(tabId.equals(tabItem.getTitleString())){
             tabItem.setChecked(true);
         }
         else {
             tabItem.setChecked(false);
         }

     }

    }

    //代表每一个Tab
    public class TabItem{
        //正常情况下显示的图片
        private  int imageNormal;
        private  int imagePress;
        private  int title;
        private  String titleString;
        private  Class<? extends Fragment> fragmentClass;

        public Class<? extends Fragment> getFragmentClass() {
            return fragmentClass;
        }

        public void setFragmentClass(Class<? extends Fragment> fragmentClass) {
            this.fragmentClass = fragmentClass;
        }

        private View view;
        private  ImageView imageView;
        private TextView textView;
        private  Bundle bundle;

        public TabItem(int imageNormal,int imagePress,int title,Class<? extends Fragment> fragmentClass){
            this.imageNormal = imageNormal;
            this.imagePress = imagePress;
            this.title = title;;
            this.fragmentClass = fragmentClass;
        }

        public int getImageNormal() {
            return imageNormal;
        }

        public void setImageNormal(int imageNormal) {
            this.imageNormal = imageNormal;
        }

        public int getImagePress() {
            return imagePress;
        }

        public void setImagePress(int imagePress) {
            this.imagePress = imagePress;
        }


        public int getTitle() {
            return title;
        }

        public void setTitle(int title) {
            this.title = title;
        }

        public String getTitleString() {
            if (title == 0)
            {
                return "";
            }
            if (TextUtils.isEmpty(titleString))
                titleString = getString(title);
            return titleString;
        }

        public void setTitleString(String titleString) {
            this.titleString = titleString;
        }

        public  Bundle getBundle(){
            if (bundle == null){
                bundle = new Bundle();
            }
            bundle.putString("title",getTitleString());
            return bundle;
        }

        //切换Tab
        public void setChecked(boolean isChecked){
            if(imageView !=null) {

                if (isChecked) {
                    imageView.setImageResource(imagePress);
                } else {
                    imageView.setImageResource(imageNormal);
                }
            }
         //改变字体颜色
            if(textView != null &&title != 0){
                if(isChecked){
                    textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                }

            }


        }

        public View getView(){
            if(this.view == null)
            {
                this.view = getLayoutInflater().inflate(R.layout.view_tab_indicator,null);
                this.imageView = (ImageView) this.view.findViewById(R.id.iv_tab);
                this.textView = (TextView) this.view.findViewById(R.id.tv_tab);

               //判断资源是否存在
                if(this.title == 0){
                   this.textView.setVisibility(View.GONE);
               }else{
                   this.textView.setVisibility(View.VISIBLE);
                   this.textView.setText(getTitleString());
               }
               //绑定默认资源
                this.imageView.setImageResource(imageNormal);



            }
            return  this.view;
        }
    }
}
