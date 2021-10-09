package com.meowu.commons.utils.utils;

import com.meowu.commons.utils.security.exception.SnowflakeException;

public class SnowflakeUtils{

    private final long twepoch = 715017600000L;

    private final long centerIdBits = 5L;
    private final long workerIdBits = 5L;
    private final long sequenceBits = 12L;
    //31
    private final long maxCenterId  = -1L ^ (-1L << centerIdBits);
    //31
    private final long maxWorkerId  = -1L ^ (-1L << workerIdBits);
    //4095
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private final long workerIdShift  = sequenceBits;
    private final long centerIdShift  = sequenceBits + workerIdBits;
    private final long timestampShift = sequenceBits + workerIdBits + centerIdBits;

    private long centerId;
    private long workerId;
    private long sequence;
    private long lastTimestamp;

    public SnowflakeUtils(long centerId, long workerId){
        if(centerId < 0 || centerId > maxCenterId){
            throw new IllegalArgumentException("center id must be between 0 and " + maxCenterId);
        }
        if(workerId < 0 || workerId > maxWorkerId){
            throw new IllegalArgumentException("worker id must be between 0 and " + maxWorkerId);
        }

        this.centerId      = centerId;
        this.workerId      = workerId;
        this.sequence      = 0;
        this.lastTimestamp = -1L;
    }

    public synchronized long nextId(){
        long timestamp = timeGen();

        if(timestamp < lastTimestamp){
            throw new SnowflakeException("clock moves backwards, rejecting requests until [{0, number, #}]", lastTimestamp);
        }

        if(lastTimestamp == timestamp){
            sequence = (sequence + 1) & sequenceMask;

            if(sequence == 0){
                timestamp = tilNextMillis(lastTimestamp);
            }
        }else{
            sequence = 0;
        }

        lastTimestamp = timestamp;

        return ((timestamp - twepoch) << timestampShift)
                | (centerId << centerIdShift)
                | (workerId << workerIdShift)
                | sequence;
    }

    public String getId(){
        return String.valueOf(nextId());
    }

    private long tilNextMillis(long lastTimestamp){
        long timestamp = timeGen();

        while(timestamp <= lastTimestamp){
            timestamp = timeGen();
        }

        return timestamp;
    }

    private long timeGen(){
        return System.currentTimeMillis();
    }
}
