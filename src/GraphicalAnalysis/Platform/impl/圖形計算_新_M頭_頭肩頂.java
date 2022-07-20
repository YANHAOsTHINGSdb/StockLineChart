package GraphicalAnalysis.Platform.impl;

import java.util.List;

import GraphicalAnalysis.Graphical.impl.圖形計算_M頭_頭肩頂;
import GraphicalAnalysis.Platform.圖形計算_新;
import OutputData.圖形;
import OutputData.平台;
import OutputData.折点;
import ParseTool2.平台Util2;

public class 圖形計算_新_M頭_頭肩頂 implements 圖形計算_新 {

	@Override
	public 圖形 圖形判别(平台 p, List<折点> 折點list_優化後, List<折点> 折点list3) {
		
		List<折点> 折点list高點 = 平台Util2.取得指定list的高點list(折點list_優化後);
		List<折点> 折点list低點 = 平台Util2.取得指定list的低點list(折点list高點);
		
		圖形 t = new 圖形計算_M頭_頭肩頂().取得M頭信息(p, 折點list_優化後, 折点list高點, 折点list低點);
		if(t != null) {
			//圖形list.add(t);
			//continue;
			
			return t;
		}
		
		t = new 圖形計算_M頭_頭肩頂().取得頭肩頂信息(p, 折點list_優化後, 折点list高點, 折点list低點, 折点list3);
		if(t != null) {
			//圖形list.add(t);
			//continue;
			
			return t;
		}
		
		return null;
	}

	@Override
	public 圖形 趨勢計算(圖形 o圖形, List<折点> 折点list1, List<折点> 折点list2, List<折点> 折点list3, List<折点> 折點list_優化後) {
		
		/*
		 * 是高臺還是低臺，在圖形計算時再去解析，
		 * 還是在最初平臺計算時就清楚的標記
		 * 問題
		 * 		1、是否解决了低台上升的需求
		 * 			答：在开始只是解析了平台，并未与其他平台比较就无法得知是高还是低
		 * 
		 *      2、如何解决低台上升的图形计算（提取图形数据，驗證指標圖）
		 *      	答：先解决低台的识别（与其他平台比较）后再计算图形
		 *      
		 *      3、如何解决低位三角形要下降的图形计算
		 *      	答：先解决三角形的识别后再计算上或下的图形计算
		 *      
		 *      4、如何真的要重写，如何解决三角形与高低台同时计算的需求
		 *      	答：各算个的。
		 */	
		
		
		//-----------------------------------------------
		// 目的：豐富圖形信息，計算差價，驗證教科书圖形是否有效
		// 循環取得所有圖形
		//     如果图形是高台（10=高臺）
		//     	   是否存在下跌後的第一個折點
		//         是否存在下跌後的第一個低点
		
		// 高台_頸部最高價格
		// 高台_頸線價格
		// 高台_第一折点
		// 高台_第二折点
		//-----------------------------------------------
		
		// 折點list_優化後 是帶上行下行折點的
		
		//t圖形.set属性(11);                              // 10=高臺M頭  11=高臺頭肩頂   20=收縮三角形
		//t圖形.set高台_頸線價格(f高台_頸線價格);         // 中間低點的價格
		//t圖形.set高台_頸部最高價格(f高台_頸部最高價格); // 折点list23高点价格
		

		
		return null;
	}

}
