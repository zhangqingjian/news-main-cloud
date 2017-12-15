/**
 * 
 */
package com.yo.news.sale.goods.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yo.news.sale.framework.controller.BaseController;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年9月27日 上午9:37:26 说明：
 */
@RestController
public class DownloadGoodCtrler  extends BaseController
{
	@RequestMapping(value = "/testDownload", method = RequestMethod.GET)
	public void testDownload(HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("application/OCTET-STREAM;charset=UTF-8");
		// 得到下载文件的名字
		// String filename=request.getParameter("filename");

		// 创建file对象
		File file = new File("D:/2.jpg");

		// 写明要下载的文件的大小
		response.setContentLength((int) file.length());
		// 设置附加文件名
		// response.setHeader("Content-Disposition","attachment;filename="+filename);

		// 解决中文乱码
		response.setHeader("Content-Disposition", "attachment;filename=2.png");
		// 读出文件到i/o流
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream buff = new BufferedInputStream(fis);
		byte[] b = new byte[1024];// 相当于我们的缓存
		long k = 0;// 该值用于计算当前实际下载了多少字节
		// 从response对象中得到输出流,准备下载
		OutputStream myout = response.getOutputStream();
		// 开始循环下载
		while (k < file.length())
		{
			int j = buff.read(b, 0, 1024);
			k += j;
			// 将b中的数据写到客户端的内存
			myout.write(b, 0, j);
		}
		// 将写入到客户端的内存的数据,刷新到磁盘
		myout.flush();
	}
}
