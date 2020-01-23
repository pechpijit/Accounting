package xyz.codecool.android.accounting;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import xyz.codecool.android.accounting.helper.BaseActivity;

public class DetailActivity extends BaseActivity {
    int page = 1;
    String title = "";

    TextView txtMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarGradiant(this);
        setContentView(R.layout.activity_detail);

        txtMenu = findViewById(R.id.txtMenu);

        Bundle i = getIntent().getExtras();

        if (i != null) {
            page = i.getInt("page");
            title = i.getString("title");

            txtMenu.setText(title);

        }
    }

    protected void setStatusBarGradiant(Activity activity) {
        Window window = activity.getWindow();
        Drawable background = activity.getResources().getDrawable(R.drawable.gradient_theme);
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(activity.getResources().getColor(android.R.color.transparent));
        window.setBackgroundDrawable(background);
//        Transition ts = new Explode();  //Slide(); //Explode();
//
//        ts.setStartDelay(0);
//        ts.setDuration(1000);
//        getWindow().setEnterTransition(ts);
//        getWindow().setExitTransition(ts);
    }
}
