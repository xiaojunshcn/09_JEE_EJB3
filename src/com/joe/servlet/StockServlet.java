package com.joe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joe.ajax.StockVO;

public class StockServlet extends HttpServlet {

	private HashMap<String, StockVO> stocks;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//return price info of the 2 stocks
		
		double sz = Math.random()*20;
		double pf = Math.random() * 0.5;
		
		boolean flagsz = ((int)(Math.random()*10))%2 == 0;
		boolean flagpf = ((int)(Math.random()*10))%2 == 0;
		
		StockVO szzs = stocks.get("300001");
		StockVO pfyh = stocks.get("000001");
		
		double temp;
		if (flagsz) {
			temp = szzs.getCurrentPrice() + sz;
		} else {
			temp = szzs.getCurrentPrice() - sz;
		}
		temp = (int) (temp*100)/100.0;
		szzs.setCurrentPrice(temp);
		
		if (flagpf) {
			temp = pfyh.getCurrentPrice() + pf;
		} else {
			temp = pfyh.getCurrentPrice() - pf;
		}
		temp = (int) (temp*100)/100.0;
		pfyh.setCurrentPrice(temp);
		
		resp.setContentType("text/html");
		PrintWriter wr = resp.getWriter();
		//wr.println(szzs + "<br/>" + pfyh);
		
		//use json data format to return the stock info
		/**
		 * json data like:
		[
		 {name:"ShangZheng ZhiShu",id:"300001",yes:3000.0,tod:2990.1,now:3003.41},
		 {name:"Pufa Yinhang",id:"000001",yes:23.22,tod:23.5,now:23.48}
		] 
		*/
//		StringBuilder sb = new StringBuilder();
//		sb.append("[{name:\"").append(szzs.getStockName()).append("\",id:\"");
//		sb.append(szzs.getStockId()).append("\",yes:").append(szzs.getYesterdayEndPrice());
//		sb.append(",tod:").append(szzs.getTodayStartPrice()).append(",now:");
//		sb.append(szzs.getCurrentPrice()).append("},{");
//		sb.append("name:\"").append(pfyh.getStockName()).append("\",id:\"");
//		sb.append(pfyh.getStockId()).append("\",yes:").append(pfyh.getYesterdayEndPrice());
//		sb.append(",tod:").append(pfyh.getTodayStartPrice()).append(",now:");
//		sb.append(pfyh.getCurrentPrice()).append("}]");
		
		StringBuilder sb = new StringBuilder();
		/**
		 this is a json object:
			{
			 "300001":{name:"ShangZheng ZhiShu",yes:3000.0,tod:2990.1,now:2994.37},
			 "000001":{name:"Pufa Yinhang",id:"000001",yes:23.22,tod:23.5,now:23.86}
			} 
		 */
		
		//when it is a json object returned to js to parse, you need to put the json object in a brackets "()".
		//otherwise, it will not be parsed correctly in js
		sb.append("({\"").append(szzs.getStockId())
			.append("\":{name:\"").append(szzs.getStockName())
			.append("\",yes:").append(szzs.getYesterdayEndPrice())
			.append(",tod:").append(szzs.getTodayStartPrice()).append(",now:");
		sb.append(szzs.getCurrentPrice()).append("},\"").append(pfyh.getStockId());
		sb.append("\":{name:\"").append(pfyh.getStockName()).append("\",id:\"");
		sb.append(pfyh.getStockId()).append("\",yes:").append(pfyh.getYesterdayEndPrice());
		sb.append(",tod:").append(pfyh.getTodayStartPrice()).append(",now:");
		sb.append(pfyh.getCurrentPrice()).append("}})");
		
		System.out.println(sb.toString());
		wr.println(sb.toString());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

	public void init(ServletConfig config) throws ServletException {
		stocks = new HashMap<String, StockVO>();
		
		//create 2 stocks
		StockVO szzs = new StockVO();
		szzs.setYesterdayEndPrice(3000.0);
		szzs.setTodayStartPrice(2995.1);
		szzs.setCurrentPrice(2995.1);
		szzs.setStockName("ShangZheng ZhiShu");
		szzs.setStockId("300001");
		
		StockVO pfyh = new StockVO();
		pfyh.setYesterdayEndPrice(23.22);
		pfyh.setTodayStartPrice(23.30);
		pfyh.setCurrentPrice(23.30);
		pfyh.setStockName("Pufa Yinhang");
		pfyh.setStockId("000001");
		
		//store these 2 stocks to the map
		stocks.put(szzs.getStockId(), szzs);
		stocks.put(pfyh.getStockId(), pfyh);
	}
}
