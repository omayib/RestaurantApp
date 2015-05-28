package id.co.technomotion.restaurantapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;

public class ClientToServer {
	public static final int HTTP_TIMEOUT = 30 * 1000;
	private static HttpClient client;
	static FileInputStream fileInputStream = null;
	static String sResponse;

	private static HttpClient getHttpClient() {
		if (client == null) {
			client = new DefaultHttpClient();
			final HttpParams parameterHttp = client.getParams();

			HttpConnectionParams.setConnectionTimeout(parameterHttp,
					HTTP_TIMEOUT);
			ConnManagerParams.setTimeout(parameterHttp, HTTP_TIMEOUT);
		}
		return client;

	}

	public static String eksekusiHttpPost(String url,
			ArrayList<NameValuePair> postParameters) throws Exception {
		Log.d("url", url);
		BufferedReader in = null;
		try {
			HttpClient client = getHttpClient();
			HttpPost req = new HttpPost(url);
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(
					postParameters);
			req.setEntity(formEntity);
			HttpResponse respon = client.execute(req);
			in = new BufferedReader(new InputStreamReader(respon.getEntity()
					.getContent()));

			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			String hasil = sb.toString();
			return hasil;
		} finally {
			if (in != null) {
				in.close();
			}

		}

	}

	public static String eksekusiHttpGet(String url) throws Exception {
		Log.d("omayib", url);
		BufferedReader in = null;
		try {
			HttpClient hc = getHttpClient();
			HttpGet req = new HttpGet();
			req.setURI(new URI(url));
			HttpResponse resp = hc.execute(req);
			in = new BufferedReader(new InputStreamReader(resp.getEntity()
					.getContent()));

			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			String hasil = sb.toString();
			return hasil;
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	public static boolean isNetworkAvailable(Context con) {
		ConnectivityManager connectivityManager = (ConnectivityManager) con
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager
				.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
}
