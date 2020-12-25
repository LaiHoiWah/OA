package com.wah.oa.manager.commons.utils.message.converter;

import com.google.gson.Gson;
import com.wah.commons.utils.GsonUtils;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.nio.charset.Charset;

public class Gson2HttpMessageConverter extends GsonHttpMessageConverter{

    private Gson gson;

    public Gson2HttpMessageConverter(Charset charset){
        super.setGson(this.getGson());
        super.setDefaultCharset(charset);
    }

    public Gson getGson(){
        if(this.gson == null){
            this.gson = GsonUtils.getGson();
        }

        return this.gson;
    }
}
