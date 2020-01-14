package xyz.codecool.android.accounting;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import xyz.codecool.android.accounting.helper.BaseActivity;

public class DetailMenu6Activity extends BaseActivity {
    int page = 1;
    String title = "";

    TextView txtMenu;
    LinearLayout viewContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarGradiant(this);
        setContentView(R.layout.activity_detail_menu6);

        txtMenu = findViewById(R.id.txtMenu);
        viewContent = findViewById(R.id.viewContent);

        Bundle i = getIntent().getExtras();

        if (i != null) {
            page = i.getInt("page");
            title = i.getString("title");
            txtMenu.setText(title);
        }
    }

    @Override
    public void onBackPressed() {
        invisibleView(viewContent);
        super.onBackPressed();
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
