package com.meowu.commons.utils.utils;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;

public class SpellUtils{

    private static final String  EMPTY   = "";
    private static final Charset CHARSET = Charset.forName("utf-8");

    public static String upper(String str){
        if(StringUtils.isBlank(str)){
            return str;
        }

        return str.toUpperCase();
    }

    public static String lower(String str){
        if(StringUtils.isBlank(str)){
            return str;
        }

        return str.toLowerCase();
    }

    public static String capitalize(String str){
        return StringUtils.capitalize(str);
    }

    public static String uncapitalize(String str){
        return StringUtils.uncapitalize(str);
    }

    public static String underline(String str){
        if(StringUtils.isBlank(str)){
            return str;
        }

        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
    }

    public static String camel(String str){
        if(StringUtils.isBlank(str)){
            return str;
        }

        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
    }

    public static String toString(byte[] content, Charset charset){
        AssertUtils.notNull(charset, "charset must not be null");

        if(ArrayUtils.isEmpty(content)){
            return EMPTY;
        }

        return new String(content, charset);
    }

    public static String toString(byte[] content){
        return toString(content, CHARSET);
    }
}
