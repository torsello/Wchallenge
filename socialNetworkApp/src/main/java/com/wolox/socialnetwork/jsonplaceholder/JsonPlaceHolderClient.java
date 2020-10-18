package com.wolox.socialnetwork.jsonplaceholder;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import okhttp3.OkHttpClient;

@Component
public class JsonPlaceHolderClient {

	@Value("${jsonPlaceHolder.connection.timeout.miliseconds:3000}")
	private int connectionTimeOut;
	@Value("${jsonPlaceHolder.read.timeout.miliseconds:3000}")
	private int readTimeOut;
	@Value("${jsonPlaceHolder.write.timeout.miliseconds:3000}")
	private int writeTimeOut;

	public OkHttpClient getNewJsonPlaceHolderClient() {
		return new OkHttpClient.Builder().connectTimeout(connectionTimeOut, TimeUnit.MILLISECONDS)
				.readTimeout(readTimeOut, TimeUnit.MILLISECONDS).writeTimeout(writeTimeOut, TimeUnit.MILLISECONDS)
				.build();
	}

}
