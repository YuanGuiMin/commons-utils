package com.meowu.commons.utils.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.meowu.commons.utils.security.exception.IPException;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

public class IPUtils{

    public static List<String> find(){
        try{
            // ip list
            Set<String> ips = Sets.newHashSet();

            // all network interfaces
            Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();

            // traverse
            while(networks.hasMoreElements()){
                NetworkInterface network = networks.nextElement();

                if(network != null){
                    // all addresses
                    Enumeration<InetAddress> addresses = network.getInetAddresses();

                    while(addresses.hasMoreElements()){
                        InetAddress ip = addresses.nextElement();

                        if(ip != null && ip instanceof Inet4Address){
                            ips.add(ip.getHostAddress());
                        }
                    }
                }
            }

            return Lists.newArrayList(ips);
        }catch(Exception e){
            throw new IPException(e.getMessage(), e);
        }
    }

    public static List<String> findByUsing(){
        try{
            // ip list
            Set<String> ips = Sets.newHashSet();

            // all network interfaces
            Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();

            // traverse
            while(networks.hasMoreElements()){
                NetworkInterface network = networks.nextElement();

                if(network != null && !network.isLoopback() && !network.isVirtual() && network.isUp()){
                    // all addresses
                    Enumeration<InetAddress> addresses = network.getInetAddresses();

                    while(addresses.hasMoreElements()){
                        InetAddress ip = addresses.nextElement();

                        if(ip != null && ip instanceof Inet4Address){
                            ips.add(ip.getHostAddress());
                        }
                    }
                }
            }

            return Lists.newArrayList(ips);
        }catch(Exception e){
            throw new IPException(e.getMessage(), e);
        }
    }
}
