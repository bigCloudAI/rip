package com.rip.ctrl;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ripBackend")
public class RipOsController {
 
   @RequestMapping("")
    public String sayHello(HttpServletRequest request) throws UnknownHostException {
    	InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
        String hostAddress = address.getHostAddress();//192.168.0.121  
    	String ip = "ip:" + hostAddress;
    	String requestIp = "reIp:" + request.getLocalAddr();
    	String remoteIp = "remoteIp:" + request.getRemoteHost();
        return ip + "\n\t" + requestIp + "\n\t" + remoteIp+"/////v1.1";
    }

}
