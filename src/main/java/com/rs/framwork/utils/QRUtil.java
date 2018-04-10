package com.rs.framwork.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class QRUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat("MMDDHHmmss");

	/**
	 * 生成二维码
	 * 
	 * @param message
	 * @return void
	 * @author:Nfj
	 * @date:2017年12月20日
	 */
	public static String generateImg(HttpServletRequest request, String message) {
		String perfixName = null;
		try {
			perfixName = sdf.format(new Date());

			String base = request.getSession().getServletContext().getRealPath("/");

			String fileName = base +"files\\"+ perfixName + ".png";

			File file = new File(fileName);
			File fileParent = file.getParentFile();
			// 如果文件夹不存在则创建
			if (!fileParent.exists()) {
				fileParent.mkdirs();
			}
			file.createNewFile();

			ZxingUtils.getQRCodeImge(message, 420, fileName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return perfixName;

	}
}
