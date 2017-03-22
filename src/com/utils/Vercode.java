package com.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/WEB-INF/content/vercode.jsp")
public class Vercode extends HttpServlet{
//	设置字体
	private final Font font = new Font("arial black", Font.PLAIN, 16);
//	定义验证码的大小
	private final int WIDTH = 100;
	private final int HEIGHT = 18;
//	随机获取颜色方法
	private Color getRandColor(int fc ,int bc) {
		Random random = new Random();
		if (fc>255) {
			fc = 255;
		}
		if (bc>255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
//	定义获取随机字符串的方法
	private String  getRandString() {
		Random random = new Random();
		int rand = random.nextInt(3);
		long result = 0;
		switch (rand) {
		case 1:
			result = random.nextInt(26)+65;
			return String.valueOf((char)result);
		case 2:
			result = random.nextInt(26)+97;
			return String.valueOf((char)result);
		default:
			result = random.nextInt(10);
			return String.valueOf(result);
		}
	}
//	生成客户端的响应
	@Override
		public  void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
//		设置禁止缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
//		开始生成图片
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		Random random = new Random();
		graphics.setColor(getRandColor(200, 250));
		graphics.fillRect(1, 1, WIDTH, HEIGHT);
		
		graphics.setColor(new Color(102,102,102));
		graphics.drawRect(0, 0, WIDTH, HEIGHT);
		
		graphics.setColor(getRandColor(160, 200));
		// 生成随机干扰线
		for (int i = 0 ; i < 30 ; i++)
		{
			int x = random.nextInt(WIDTH - 1);
			int y = random.nextInt(HEIGHT - 1);
			int xl = random.nextInt(6) + 1;
			int yl = random.nextInt(12) + 1;
			graphics.drawLine(x , y , x + xl , y + yl);
		}
		graphics.setColor(getRandColor(160,200));
		// 生成随机干扰线
		for (int i = 0 ; i < 30 ; i++)
		{
			int x = random.nextInt(WIDTH - 1);
			int y = random.nextInt(HEIGHT - 1);
			int xl = random.nextInt(12) + 1;
			int yl = random.nextInt(6) + 1;
			graphics.drawLine(x , y , x - xl , y - yl);
		}
		graphics.setFont(font);
//		获得随机字符串
		String result  = "";
		for (int i = 0; i < 6; i++) {
			String rand = getRandString();
			result += rand;
			graphics.setColor(getRandColor(20, 100));
			graphics.drawString(rand, 15*i+10, 15);
		}
		System.out.println(result);
//		获取HttpSession对象
		HttpSession session = request.getSession(true);
		session.setAttribute("rand", result);
		graphics.dispose();
		ServletOutputStream outputStream = response.getOutputStream();
		ImageIO.write(image, "jpeg", outputStream);
		
		
		}
	public static void main(String[] args) {
		long i = 67;
		char a = (char)i;
		System.out.println(a);
		System.out.println(String.valueOf((char)67));
		
	}
	
	
}
