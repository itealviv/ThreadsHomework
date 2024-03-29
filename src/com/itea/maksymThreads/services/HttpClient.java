package com.itea.maksymThreads.services;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClient {
    HttpGet httpGet;
    private String responseBody;


    public HttpClient(String url) {
        this.httpGet = new HttpGet(url);
        System.out.println("Executing request " + this.httpGet.getRequestLine());
    }

    private void setResponseBody() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };

            responseBody = httpclient.execute(httpGet, responseHandler);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try{
                httpclient.close();
            } catch (Exception e) {
                System.err.println(e);
            }

        }

    }

    public String getResponseBody() {
        setResponseBody();
        return responseBody;
    }
}