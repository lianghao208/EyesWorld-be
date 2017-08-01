package org.tvos.controller.Login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tvos.dao.QueryForTokenDao;
import org.tvos.util.*;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private QueryForTokenDao queryForTokenDao;
	
	@RequestMapping("test1")
	public String test(){

		return "test1";
	}


	@RequestMapping(value="/tv/getqr",method=RequestMethod.GET)
	public ResponseEntity<QrEntity> qr(HttpServletRequest request){
		QrCreate.setPath(request.getRealPath("/"));
		//QrCreate.setPath(System.getProperty("tveb.root"));
		//System.out.println(System.getProperty("tveb.root"));
		QrEntity e=QrCreate.getQr("http://192.168.0.109:8080/login.html");
		return new ResponseEntity<QrEntity>(e,HttpStatus.OK);
	}
	
	@RequestMapping(value="/phone/sendmarker",method=RequestMethod.POST)
	public ResponseEntity<?> token(@RequestParam("marker") String marker,
								   HttpServletRequest request){
		String token=null;
		Cookie[] l=request.getCookies();
		for(Cookie c:l){
			if(c.getName().equals("sfnfncfs")){
				token=c.getValue();
			}
		}
		if(token!=null) {
			queryForTokenDao.setToken(marker, token);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value="/tv/login",method=RequestMethod.POST)
	public void tvLogin(HttpServletResponse response,@RequestParam("marker") String marker,HttpServletRequest request){

		Cookie cookie=new Cookie("sfnfncfs",queryForTokenDao.getToken(marker));
		cookie.setPath("/");
		response.addCookie(cookie);
		queryForTokenDao.deleteToken(marker);
		QrCreate.setPath(request.getRealPath("/"));
		QrCreate.deleteFile(marker);
	}
}
