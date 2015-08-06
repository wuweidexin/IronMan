package com.chen.dict;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Utils {
	private static Logger logger = LoggerFactory.getLogger(Utils.class);
	static int HTTP_OK = 200;
	//params.add(new BasicNameValuePair("pwd","2544"));
	public static String sendPost(String url, List<NameValuePair> params){
		HttpUriRequest httpPost = null;
		try {
			httpPost = RequestBuilder
					.post()
					.addHeader("Content-Type",
							ContentType.APPLICATION_FORM_URLENCODED.toString())
					.setEntity(new UrlEncodedFormEntity(params,"UTF-8"))
					.setUri(url).build();
		} catch (UnsupportedEncodingException e) {
			logger.error("发送http请求失败",e.getMessage());
		}
		return sendHttpRequest(httpPost);
		
	}
	
	
	public static String sendHttpRequest(HttpUriRequest httpRequest) {
		HttpClient httpClient = HttpClients.createDefault();
		try {
			HttpResponse httpResponse = httpClient.execute(httpRequest);
			if (isRequestSuccessful(httpResponse)) {
				HttpEntity httpEntity = httpResponse.getEntity();
				String response = EntityUtils.toString(httpEntity, "utf-8");
				logger.info("发送http请求返回：{}", response); 
				return response;
			}
		} catch (ClientProtocolException e) {
			logger.error("发送http请求失败,uri={}, exception={}",
					httpRequest.getURI(), e);
		} catch (IOException e) {
			logger.error("发送http请求失败,uri={}, exception={}",
					httpRequest.getURI(), e);
		}
		return null;
	}

	private static boolean isRequestSuccessful(HttpResponse httpResponse) {
		logger.info("调用返回状态码：{}", httpResponse.getStatusLine().getStatusCode());
		return httpResponse.getStatusLine().getStatusCode() == HTTP_OK;
	}
}
