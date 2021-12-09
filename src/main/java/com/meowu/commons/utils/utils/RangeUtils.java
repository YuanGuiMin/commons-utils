package com.meowu.commons.utils.utils;

import com.google.common.collect.Lists;
import com.meowu.commons.utils.security.exception.HostParserException;
import com.meowu.commons.utils.security.exception.RangeParserException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RangeUtils{

    private static final String RANGE_REGEX = "^bytes=\\d*-\\d*(,\\d*-\\d*)*$";

    public static List<Range> parse(String header){
        if(StringUtils.isBlank(header)){
            return Lists.newArrayList();
        }

        Pattern pattern = Pattern.compile(RANGE_REGEX);
        Matcher matcher = pattern.matcher(header);

        if(!matcher.matches()){
            throw new RangeParserException("bad range format: [bytes=start-end(,start-end)]");
        }

        // result
        List<Range> ranges = Lists.newArrayList();

        // parse
        String[] parts = header.replace("bytes=", "").split(",");
        for(String part : parts){
            int    separatorIndex = part.indexOf("-");
            String start          = part.substring(0, separatorIndex);
            String end            = part.substring(separatorIndex + 1);

            ranges.add(new Range(StringUtils.isBlank(start) ? null : Long.parseLong(start), StringUtils.isBlank(end) ? null : Long.parseLong(end)));
        }

        return ranges;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Range{

        private Long start;
        private Long end;

        @Override
        public String toString(){
            return GsonUtils.serialize(this);
        }
    }
}
