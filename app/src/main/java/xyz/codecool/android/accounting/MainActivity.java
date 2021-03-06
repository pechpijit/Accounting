package xyz.codecool.android.accounting;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.jetradarmobile.snowfall.SnowfallView;

import xyz.codecool.android.accounting.helper.BaseActivity;
import xyz.codecool.android.accounting.helper.MyBounceInterpolator;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    FrameLayout btnMenu1, btnMenu2, btnMenu3, btnMenu4, btnMenu5, btnMenu6;
    TextView txtMenu1, txtMenu2, txtMenu3, txtMenu4, txtMenu5, txtMenu6;
    TextView txtAppName;
    SnowfallView snowView;
    CardView barCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarGradiant(this);
        setContentView(R.layout.activity_main);
        bindView();

        new Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        aimationOne();
                    }
                }, 400);
    }

    private void bindView() {
        barCard = findViewById(R.id.bar);
        txtAppName = findViewById(R.id.txtAppName);
        snowView = findViewById(R.id.snowView);

        btnMenu1 = findViewById(R.id.btnMenu1);
        btnMenu2 = findViewById(R.id.btnMenu2);
        btnMenu3 = findViewById(R.id.btnMenu3);
        btnMenu4 = findViewById(R.id.btnMenu4);
        btnMenu5 = findViewById(R.id.btnMenu5);
        btnMenu6 = findViewById(R.id.btnMenu6);

        invisibleView(btnMenu1,btnMenu2,btnMenu3,btnMenu4,btnMenu5,btnMenu6);

        txtMenu1 = findViewById(R.id.txtMenu1);
        txtMenu2 = findViewById(R.id.txtMenu2);
        txtMenu3 = findViewById(R.id.txtMenu3);
        txtMenu4 = findViewById(R.id.txtMenu4);
        txtMenu5 = findViewById(R.id.txtMenu5);
        txtMenu6 = findViewById(R.id.txtMenu6);

        btnMenu1.setOnClickListener(this);
        btnMenu2.setOnClickListener(this);
        btnMenu3.setOnClickListener(this);
        btnMenu4.setOnClickListener(this);
        btnMenu5.setOnClickListener(this);
        btnMenu6.setOnClickListener(this);
    }

    private void aimationOne() {
        visibleView(barCard);
        YoYo.with(Techniques.FadeInDown)
                .duration(600)
                .playOn(barCard);

        visibleView(btnMenu1);
        YoYo.with(Techniques.ZoomIn)
                .duration(200)
                .playOn(btnMenu1);

        visibleView(btnMenu2);
        YoYo.with(Techniques.ZoomIn)
                .duration(400)
                .playOn(btnMenu2);

        visibleView(btnMenu3);
        YoYo.with(Techniques.ZoomIn)
                .duration(600)
                .playOn(btnMenu3);

        visibleView(btnMenu4);
        YoYo.with(Techniques.ZoomIn)
                .duration(700)
                .playOn(btnMenu4);

        visibleView(btnMenu5);
        YoYo.with(Techniques.ZoomIn)
                .duration(900)
                .playOn(btnMenu5);

        visibleView(btnMenu6);
        YoYo.with(Techniques.ZoomIn)
                .duration(1000)
                .playOn(btnMenu6);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btnMenu1:
                intent = new Intent(this, DetailMenu1Activity.class);
                intentDetail(intent, btnMenu1, txtMenu1);
                break;
            case R.id.btnMenu2:
                intent = new Intent(this, DetailMenu2Activity.class);
                intentDetail(intent, btnMenu2, txtMenu2);
                break;
            case R.id.btnMenu3:
                intent = new Intent(this, DetailMenu3Activity.class);
                intentDetail(intent, btnMenu3, txtMenu3);
                break;
            case R.id.btnMenu4:
                intent = new Intent(this, DetailMenu4Activity.class);
                intentDetail(intent, btnMenu4, txtMenu4);
                break;
            case R.id.btnMenu5:
                intent = new Intent(this, DetailMenu5Activity.class);
                intentDetail(intent, btnMenu5, txtMenu5);
                break;
            case R.id.btnMenu6:
                intent = new Intent(this, DetailMenu6Activity.class);
                intentDetail(intent, btnMenu6, txtMenu6);
                break;
        }
    }

    private void intentDetail(Intent intent , FrameLayout view, TextView txtMenu) {
        Pair[] pairs = new Pair[2];
        pairs[0] = new Pair<View, String>(view, "btnMenu");
        pairs[1] = new Pair<View, String>(txtMenu, "txtMenu");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pairs);

        startActivity(intent, options.toBundle());
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void didTapButton(View view) {
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.07, 30);
        myAnim.setInterpolator(interpolator);

        view.startAnimation(myAnim);
    }

    protected void setStatusBarGradiant(Activity activity) {
        Window window = activity.getWindow();
        Drawable background = activity.getResources().getDrawable(R.drawable.gradient_theme);
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(activity.getResources().getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);
    }
}
