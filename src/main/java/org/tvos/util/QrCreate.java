package org.tvos.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

/**
 * 二维码生成类
 */
public class QrCreate {
	
	private static String defaultPath=
			"target/"+
			"classes/"+
			"static/";
	
	public static void setPath(String path){
		defaultPath=path;
	}
	
	public static QrEntity getQr(String url){
		QrEntity q=new QrEntity();
		Long time=System.currentTimeMillis();
		String marker=time.toString();
		String imgPath="img\\";
		String urlPath=imgPath+marker;
		q.setMarker(marker);
		ByteArrayOutputStream bout=QRCode.from(url+"?marker="+marker).to(ImageType.PNG).stream();
		FileOutputStream fout;
		File realPath=new File(defaultPath+imgPath);
		try {
			if(!realPath.exists()){
				realPath.mkdirs();
			}
			fout=new FileOutputStream(defaultPath+imgPath+marker);
			fout.write(bout.toByteArray());
			fout.flush();
			fout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();return null;
		}
		finally{
			
		}
		q.setQrPath(urlPath);
		return q;
	}

	public static boolean deleteFile(String token){
		File file=new File(defaultPath+"\\img\\"+token);
		file.deleteOnExit();
		return true;
	}
	
}
