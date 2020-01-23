package xyz.codecool.android.accounting;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

import xyz.codecool.android.accounting.helper.BaseActivity;

public class DetailMenu2Activity extends BaseActivity {

    TextView txtMenu;
    PhotoView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarGradiant(this);
        setContentView(R.layout.activity_detail_menu2);
        photoView = findViewById(R.id.viewPhoto);
        txtMenu = findViewById(R.id.txtMenu);
        txtMenu.setText(getString(R.string.text_menu_home_2));

        photoView.setImageResource(R.drawable.menu2);
    }

    @Override
    public void onBackPressed() {
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
