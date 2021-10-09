package com.meowu.commons.utils.utils;

import com.google.common.collect.Maps;
import com.meowu.commons.utils.security.exception.HostParserException;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HostUtils{

    private static final String HTTP_REGEX = "((?<scheme>(http|https))://)?(?<hostname>[a-zA-Z0-9\\.]+)(:(?<port>[0-9]+))?(?<path>[/a-zA-Z0-9\\._]+)?(\\?(?<query>\\S+))?";

    public static Host parse(String url){
        AssertUtils.hasText(url, "url to parse must not be null");

        Pattern pattern = Pattern.compile(HTTP_REGEX);
        Matcher matcher = pattern.matcher(url);

        if(!matcher.matches()){
            throw new HostParserException("bad url format: [scheme://]hostname[:port][/path][?params]");
        }

        String scheme   = matcher.group("scheme");
        String hostname = matcher.group("hostname");
        String port     = matcher.group("port");
        String path     = matcher.group("path");
        String query    = matcher.group("query");

        //create host information
        Host host = new Host();
        host.setScheme(StringUtils.isBlank(scheme) ? "http": scheme);
        host.setHostname(hostname);
        host.setPort(StringUtils.isBlank(port) ? ("http".equals(host.getScheme()) ? 80 : 443) : Integer.valueOf(port));
        host.setPath(path);
        host.setQuery(extractParams(query));

        return host;
    }

    private static Map<String, String> extractParams(String query){
        if(StringUtils.isBlank(query)){
            return Maps.newHashMap();
        }

        //parse
        String[] pairs = query.split("&");
        if(ArrayUtils.isNotEmpty(pairs)){
            //result
            Map<String, String> params = Maps.newLinkedHashMap();

            //extract
            for(String pair : pairs){
                String[] param = pair.split("=");

                if(param.length != 2){
                    throw new HostParserException("bad query string: [{0}]", query);
                }

                params.put(param[0], param[1]);
            }

            return params;
        }

        return Maps.newHashMap();
    }

    @Getter
    @Setter
    public static class Host{

        private String  scheme;
        private String  hostname;
        private Integer port;
        private String  path;
        private Map<String, String> query;

        @Override
        public String toString(){
            return GsonUtils.serialize(this);
        }
    }
}
