package com.meowu.commons.utils.utils;

public class VersionUtils{

    public static String max(String targetVersion, String sourceVersion){
        return compare(targetVersion, sourceVersion) >= 0 ? targetVersion : sourceVersion;
    }

    public static String min(String targetVersion, String sourceVersion){
        return compare(targetVersion, sourceVersion) <= 0 ? targetVersion : sourceVersion;
    }

    public static int compare(String targetVersion, String sourceVersion){
        AssertUtils.hasText(targetVersion, "target version must not be null");
        AssertUtils.hasText(sourceVersion, "source version must not be null");

        if(sourceVersion.equals(targetVersion)){
            return 0;
        }

        String[] targetArrays = targetVersion.split("\\.");
        String[] sourceArrays = sourceVersion.split("\\.");

        int minLength = Math.min(targetArrays.length, sourceArrays.length);

        for(int i = 0; i < minLength; i++){
            String targetBit = targetArrays[i];
            String sourceBit = sourceArrays[i];

            int compare = targetBit.compareTo(sourceBit);

            if(compare < 0){
                return -1;
            }else if(compare > 0){
                return 1;
            }else{
                continue;
            }
        }

        return targetArrays.length - sourceVersion.length() > 0 ? 1 : -1;
    }
}
