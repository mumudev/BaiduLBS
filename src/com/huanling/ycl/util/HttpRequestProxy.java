package com.huanling.ycl.util;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.Iterator;
/**
 * Http 请求通用类
 * @author mumu
 *
 */
public class HttpRequestProxy {

	private static int connectTimeOut = 5000;

	private static int readTimeOut = 10000;

	private static String requestEncoding = "UTF-8";

	/**
	 * Http请求中Get的方法实现
	 * @param reqUrl 请求的Url
	 * @param parameters 转换为Url的参数
	 * @param recvEncoding 返回值的编码类型
	 * @return Http请求的返回值
	 */
	public static String doGet(String reqUrl, Map<?, ?> parameters, String recvEncoding) {
		StringBuffer params = new StringBuffer();
		Iterator<?> iter = parameters.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<?, ?> element = (Entry<?, ?>)iter.next();
			params.append(element.getKey().toString());
			params.append("=");
			try {
				params.append(URLEncoder.encode(element.getValue().toString(), HttpRequestProxy.requestEncoding));
			} catch (UnsupportedEncodingException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			params.append("&");
		}
		if (params.length() > 0) {
			params = params.deleteCharAt(params.length() - 1);
		}
		reqUrl += "?" + params.toString();
		return doGet(reqUrl, recvEncoding);
	}

	/**
	 * Http请求中Get的方法实现
	 * @param reqUrl 请求的Url
	 * @param recvEncoding 返回值的编码类型
	 * @return Http请求的返回值
	 */
	public static String doGet(String reqUrl, String recvEncoding) {
		HttpURLConnection url_con = null;
		String responseContent = null;
		try {
			URL url = new URL(reqUrl);
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("GET");
			url_con.setConnectTimeout(HttpRequestProxy.connectTimeOut);
			url_con.setReadTimeout(HttpRequestProxy.readTimeOut);
			url_con.setDoOutput(true);

			InputStream in = url_con.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(in,recvEncoding));
			String tempLine = rd.readLine();
			StringBuffer temp = new StringBuffer();
			String crlf = System.getProperty("line.separator");
			
			while (tempLine != null) {
				temp.append(tempLine);
				temp.append(crlf);
				tempLine = rd.readLine();
			}
			
			responseContent = temp.toString();
			rd.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (url_con != null) {
				url_con.disconnect();
			}
		}
		return decodeUnicode(responseContent);
	}

	/**
	 * Http请求中Post的方法实现
	 * @param reqUrl 请求的Url
	 * @param parameters 转换为Url的参数
	 * @param recvEncoding 返回值的编码类型
	 * @return Http请求的返回值
	 */
	public static String doPost(String reqUrl, Map<?, ?> parameters,
			String recvEncoding) {
		HttpURLConnection url_con = null;
		String responseContent = null;
		try {
			StringBuffer params = new StringBuffer();
			Iterator<?> iter = parameters.entrySet().iterator();
			while (iter.hasNext()) {
				Entry<?, ?> element = (Entry<?, ?>) iter.next();
				params.append(element.getKey().toString());
				params.append("=");
				params.append(URLEncoder.encode(element.getValue().toString(),
						HttpRequestProxy.requestEncoding));
				params.append("&");
			}

			if (params.length() > 0) {
				params = params.deleteCharAt(params.length() - 1);
			}

			URL url = new URL(reqUrl);
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("POST");
			url_con.setConnectTimeout(HttpRequestProxy.connectTimeOut);
			url_con.setReadTimeout(HttpRequestProxy.readTimeOut);
			url_con.setDoOutput(true);
			byte[] b = params.toString().getBytes();
			url_con.getOutputStream().write(b, 0, b.length);
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();

			InputStream in = url_con.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(in,
					recvEncoding));
			String tempLine = rd.readLine();
			StringBuffer tempStr = new StringBuffer();
			String crlf = System.getProperty("line.separator");
			while (tempLine != null) {
				tempStr.append(tempLine);
				tempStr.append(crlf);
				tempLine = rd.readLine();
			}
			responseContent = tempStr.toString();
			rd.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (url_con != null) {
				url_con.disconnect();
			}
		}
		return decodeUnicode(responseContent);
	}

	public static int getConnectTimeOut() {
		return HttpRequestProxy.connectTimeOut;
	}
	public static void setConnectTimeOut(int connectTimeOut) {
		HttpRequestProxy.connectTimeOut = connectTimeOut;
	}
	public static int getReadTimeOut() {
		return HttpRequestProxy.readTimeOut;
	}
	public static void setReadTimeOut(int readTimeOut) {
		HttpRequestProxy.readTimeOut = readTimeOut;
	}
	public static String getRequestEncoding() {
		return requestEncoding;
	}
	public static void setRequestEncoding(String requestEncoding) {
		HttpRequestProxy.requestEncoding = requestEncoding;
	}
	/**
	 * unicode编码转换，常用于Url的中文参数转换
	 * @param theString 源字符串
	 * @return 转换后字符串
	 */
	public static String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
									"Malformed   \\uxxxx   encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					outBuffer.append(aChar);
				}
			} else
				outBuffer.append(aChar);
		}
		return outBuffer.toString();
	}
}
