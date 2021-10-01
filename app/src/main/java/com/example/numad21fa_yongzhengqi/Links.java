package com.example.numad21fa_yongzhengqi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Patterns;
import android.webkit.URLUtil;

public class Links {
    public final String linkName;
    public final String url;

    public Links(String linkName, String url) {
        this.linkName = linkName;
        this.url = url;
    }

    public String getLinkName() {
        return linkName;
    }

    public String getUrl() {
        return url;
    }

    public void createLink(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(intent);
    }

    public boolean isValid() {
        return Patterns.WEB_URL.matcher(url).matches();
    }
}
