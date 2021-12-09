package com.meowu.commons.utils;

import com.meowu.commons.utils.utils.FileReaderUtils;
import com.meowu.commons.utils.utils.RangeUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class FileReaderUtilsTest{

    @Test
    public void read(){
        try(FileOutputStream outputStream =  new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test\\output.txt")){
            File file = new File("C:\\Users\\Administrator\\Desktop\\test\\input.txt");

            String header = "bytes=5-9,7-26";
            List<RangeUtils.Range> ranges = RangeUtils.parse(header);

            FileReaderUtils.read(outputStream, file, ranges);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
