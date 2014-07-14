package com.thenewboston.nikola;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ourView extends WebViewClient {
	
	@Override
	public boolean shouldOverrideUrlLoading(WebView v, String url){
		v.loadUrl(url);
		return true;
	}
}
