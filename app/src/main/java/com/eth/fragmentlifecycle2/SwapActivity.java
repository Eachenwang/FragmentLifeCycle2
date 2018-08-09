package com.eth.fragmentlifecycle2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SwapActivity extends AppCompatActivity {
    private FragmentManager fragManager;
    private ContactFragment contact;
    private DetailFragment detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap);

        contact = ContactFragment.newInstance("a", "b");
        detail = DetailFragment.newInstance("a", "b");
        fragManager=getSupportFragmentManager();
        //取得片段交易物件
        FragmentTransaction trans =fragManager.beginTransaction();
        trans.add(R.id.container,contact);
        trans.commit();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swap();
            }
        });
    }

    private void swap() {
        FragmentTransaction trans = fragManager.beginTransaction();
        trans.replace(R.id.container, detail);
        //避免在 SwapActivity 中按下返回鍵回到上一個片段
        //呼叫 addToBackStack(null) 按下返回鍵可結束該活動
        trans.addToBackStack(null);
        trans.commit();
    }

}
