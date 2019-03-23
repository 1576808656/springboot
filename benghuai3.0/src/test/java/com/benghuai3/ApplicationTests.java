package com.benghuai3;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.benghuai3.bean.Log;
import com.benghuai3.mapper.LogMapper;
import com.benghuai3.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private UserMapper mapper;
	@Autowired
	private LogMapper logmapper;
	@Test
	public void contextLoads() throws UnknownHostException {
		System.out.println(InetAddress.getLocalHost());
	}

}
