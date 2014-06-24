
package com.octo.android.robospice.request.googlehttpclient;

import com.google.api.client.http.HttpRequestFactory;
import com.octo.android.robospice.request.SpiceRequest;

import org.codehaus.jackson.type.TypeReference;

public abstract class GoogleHttpClientSpiceRequest<RESULT> extends SpiceRequest<RESULT> {

    private HttpRequestFactory httpRequestFactory;

    public GoogleHttpClientSpiceRequest(TypeReference<RESULT> typeRef) {
        super(typeRef);
    }

    public void setHttpRequestFactory(HttpRequestFactory httpRequestFactory) {
        this.httpRequestFactory = httpRequestFactory;
    }

    public HttpRequestFactory getHttpRequestFactory() {
        return httpRequestFactory;
    }

}
