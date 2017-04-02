package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpUtil {

	public static String get(String url) throws IOException {
		URL reqURL = new URL(url); // 创建URL对象
		HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL
				.openConnection();
		InputStream in = httpsConn.getInputStream();
		byte[] buf = new byte[httpsConn.getContentLength()];
		in.read(buf);
		return new String(buf);
	}

	public static void post(String url) throws IOException {
		URL reqURL = new URL(url);
		HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL
				.openConnection();
		InputStreamReader insr = new InputStreamReader(
				httpsConn.getInputStream());
		int respInt = insr.read();
		while (respInt != -1) {
			System.out.print((char) respInt);
			respInt = insr.read();
		}
	}

	public static void main(String[] args) {
	}
}
