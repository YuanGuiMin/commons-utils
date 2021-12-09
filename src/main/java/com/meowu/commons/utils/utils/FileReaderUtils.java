package com.meowu.commons.utils.utils;

import com.meowu.commons.utils.security.exception.FileReaderException;
import org.apache.commons.collections4.CollectionUtils;

import java.io.File;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.List;

public class FileReaderUtils{

    // 1MB size for buffer
    private static final int BUFFER_SIZE = 1048576;

    public static void read(OutputStream output, File file, List<RangeUtils.Range> ranges){
        AssertUtils.notNull(output, "output stream must not be null");
        AssertUtils.notNull(file, "file target must not be null");

        // read permission
        try(RandomAccessFile input = new RandomAccessFile(file, "r")){

            if(CollectionUtils.isEmpty(ranges)){
                // full file read
                copy(input, output, 0, input.length());
            }else{
                // range file read
                for(RangeUtils.Range range : ranges){
                    long start  = range.getStart() == null || range.getStart() < 0 ? 0 : range.getStart();
                    long end    = range.getEnd() == null || range.getEnd() > input.length() - 1 ? input.length() - 1 : range.getEnd();
                    long length = end - start + 1;

                    copy(input, output, start, length);
                }
            }
        }catch(Exception e){
            throw new FileReaderException(e.getMessage(), e);
        }
    }

    private static void copy(RandomAccessFile input, OutputStream output, long start, long length) throws Exception{
        byte[] buffer = new byte[BUFFER_SIZE];
        int    read   = 0;

        if(input.length() == length){
            while((read = input.read(buffer)) != -1){
                output.write(buffer, 0, read);
            }
        }else{
            input.seek(start);
            long toRead = length;

            while((read = input.read(buffer)) != -1){
                if((toRead -= read) > 0){
                    output.write(buffer, 0, read);
                }else{
                    output.write(buffer, 0, (int) toRead + read);
                    break;
                }
            }
        }
    }
}
