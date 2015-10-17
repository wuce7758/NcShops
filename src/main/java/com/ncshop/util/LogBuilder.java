package com.ncshop.util;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class LogBuilder {

	private static final String path = LogBuilder.class.getClassLoader()
			.getResource("log.txt").getPath();

	public static void writeToLog(String message) {
		FileWriter fw = null;
		File f =null;
		try {
			
			// 如果文件存在，则追加内容；如果文件不存在，则创建文件
			f = new File(path);
			fw = new FileWriter(f, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("\r\n" + new Date() + ":" + message);
			pw.flush();
			fw.flush();
			pw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}

	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			LogBuilder.writeToLog("我错了"+i);
		}
	}
}
