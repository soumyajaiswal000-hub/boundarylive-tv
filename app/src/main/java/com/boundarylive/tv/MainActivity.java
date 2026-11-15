package com.boundarylive.tv;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/** A dependency-free Android TV broadcast scoreboard. */
public final class MainActivity extends Activity {
    private boolean demoMode = true;
    private TextView mode;
    private TextView score;
    private TextView detail;

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        render();
    }

    @Override public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
            demoMode = !demoMode;
            render();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    private TextView text(String value, float size, int color) {
        TextView view = new TextView(this);
        view.setText(value);
        view.setTextSize(size);
        view.setTextColor(color);
        view.setGravity(Gravity.CENTER);
        view.setFontFeatureSettings("smcp");
        return view;
    }

    private void render() {
        int white = Color.rgb(247, 250, 252);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(80, 44, 80, 44);
        GradientDrawable background = new GradientDrawable(
                GradientDrawable.Orientation.TL_BR,
                new int[]{Color.rgb(7, 20, 35), Color.rgb(16, 39, 58)});
        root.setBackground(background);

        mode = text(demoMode ? "BOUNDARYLIVE  •  DEMO BROADCAST" : "BOUNDARYLIVE  •  LIVE MODE", 18, Color.rgb(255, 213, 74));
        root.addView(mode, new LinearLayout.LayoutParams(-1, 54));
        root.addView(text(demoMode ? "INDIA  vs  AUSTRALIA" : "Waiting for CricketData.org", 34, white), new LinearLayout.LayoutParams(-1, 86));
        score = text(demoMode ? "186 / 4" : apiMessage(), 86, white);
        root.addView(score, new LinearLayout.LayoutParams(-1, 150));
        detail = text(demoMode ? "18.2 overs  •  Target 212  •  Partnership 67 (42)" : "Add CRICKETDATA_API_KEY to build settings to enable live scores.", 21, Color.rgb(190, 209, 222));
        root.addView(detail, new LinearLayout.LayoutParams(-1, 66));
        TextView prompt = text("Press OK / Enter to switch mode", 16, Color.rgb(190, 209, 222));
        root.addView(prompt, new LinearLayout.LayoutParams(-1, 48));
        setContentView(root);
    }

    private String apiMessage() {
        return BuildConfig.CRICKETDATA_API_KEY.isEmpty() ? "NO API KEY" : "LIVE SCORE READY";
    }
}
