package org.tvos.util;

/**
 * 二维码实体类
 */
public class QrEntity {
	private String qrPath;
	private String marker;
	
	public QrEntity(){
		
	}
	public QrEntity(String qrPath, String marker) {
		super();
		this.qrPath = qrPath;
		this.marker = marker;
	}
	public String getQrPath() {
		return qrPath;
	}
	public void setQrPath(String qrPath) {
		this.qrPath = qrPath;
	}
	public String getMarker() {
		return marker;
	}
	public void setMarker(String marker) {
		this.marker = marker;
	}
	
	
	

}
