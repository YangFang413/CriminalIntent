package com.yf.criminalintent.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.yf.criminalintent.R;

/**
 * Created by Administrator on 2016/8/24.
 */

// 抽象类，用来封装不同的activity加载同一个容器类的布局文件的公共代码
public abstract class SingleFragmentActicity extends AppCompatActivity {

    // 抽象方法，继承此类必须重写这个抽象方法
    protected abstract Fragment createFragment();

    // activity_fragemnt中只有一个组件：FrameLayout，用来充当容器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        // 碎片管理者FragmentManager，具体管理fragment队列和fragment事务回退栈，可以进行的操作：
        // 得到Activity中存在的fragment
        // 将fragment弹出back stack
        // 为back stack加上监听器
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.frangment_container);

        // fragmentManager的事务是用来添加、移除、附加、分离、替换Fragment队列中的fragment。
        // add()方法是整个事务的核心，包含两个参数，第一个是容器视图的资源ID，第二个是fragment对象
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.frangment_container, fragment).commit();
        }
    }
}
