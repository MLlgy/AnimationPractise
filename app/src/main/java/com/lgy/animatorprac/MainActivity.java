package com.lgy.animatorprac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        findViewById(R.id.btn_layout_animation).setOnClickListener(this);
        findViewById(R.id.btnCodeLayoutAnimation).setOnClickListener(this);
        findViewById(R.id.view_animatino).setOnClickListener(this);
        findViewById(R.id.object_animator).setOnClickListener(this);
        findViewById(R.id.layourAnimator).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_layout_animation:
                IntentUtils.INSTANCE.showIntent(this, XmlLayoutAnimationActivity.class);
                break;
            case R.id.btnCodeLayoutAnimation:
                IntentUtils.INSTANCE.showIntent(this, CodeLayoutAnimationActivity.class);
                break;
            case R.id.view_animatino:
                IntentUtils.INSTANCE.showIntent(this, ViewAnimationActivity.class);
                break;

            case R.id.object_animator:
                IntentUtils.INSTANCE.showIntent(this, ObjectAnimatorActivity.class);
                break;

            case R.id.layourAnimator:
                IntentUtils.INSTANCE.showIntent(this, LayoutAnimatorActivity.class);
                break;
            default:
                break;
        }
    }
}
