package com.coding17.easycms.web.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.coding17.easycms.web.exception.CmsWebException;

/**
 * 文件操作工具类
 * @Title: FileUtil
 * @Package: com.coding17.easycms.web.util
 * @author: yin.kh
 * @date: 2016年2月26日 下午2:15:14
 */
public class FileUtil {
	
	/**
	 * 写文件
	 * @param path
	 * @param content
	 */
	public static void write(String path, String content) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), WebConst.wc_encoding_utf8));
			writer.write(content);
			writer.close();
		} catch (IOException ex) {
			throw new CmsWebException(ex);
		}
	}
	
}
