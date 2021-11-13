package com.meowu.commons.utils;

import com.meowu.commons.utils.utils.HostUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HostUtilsTest{

    @Test
    public void test(){
        String regex = "((?<scheme>(http|https))://)?(?<hostname>[a-zA-Z0-9\\.]+)(:(?<port>[0-9]+))?(?<path>[/a-zA-Z0-9\\.]+)?(\\?(?<query>\\S+))?";
        String url   = "https://s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=url%E6%AD%A3%E5%88%99&fenlei=256&oq=url%2520%25E5%258C%25B9%25E9%2585%258D&rsv_pq=838331d700005ca1&rsv_t=07f2V2ZOet%2BHCJOQ54L5sXVLu1G3QLNTavTuX1I9eLNLkMn21rDk%2F2APKz4&rqlang=cn&rsv_enter=1&rsv_dl=tb&rsv_btype=t&inputT=4378&rsv_sug3=48&rsv_sug1=48&rsv_sug7=100&rsv_sug2=0&rsv_sug4=4766";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        System.out.println(matcher.matches());
        System.out.println(matcher.group("scheme"));
        System.out.println(matcher.group("hostname"));
        System.out.println(matcher.group("port"));
        System.out.println(matcher.group("path"));
        System.out.println(matcher.group("query"));
    }

    @Test
    public void parse(){
        String url = "https://apidoc.im.sasai.mobi:14799/project/35/interface/api/5096";

        System.out.println(HostUtils.parse(url));
    }
}
