package GraphicalAnalysis.Platform.impl;

import java.util.List;

import GraphicalAnalysis.Graphical.impl.圖形計算_M頭_頭肩頂_低;
import GraphicalAnalysis.Graphical.impl.圖形計算_M頭_頭肩頂_高;
import GraphicalAnalysis.Graphical.impl.圖形計算_その他_低;
import GraphicalAnalysis.Graphical.impl.圖形計算_その他_高;
import GraphicalAnalysis.Graphical.impl.頸線Util;
import GraphicalAnalysis.Platform.圖形計算_新;
import GraphicalAnalysis.Platform.高臺計算Util;
import OutputData.圖形;
import OutputData.平台;
import OutputData.折点;
import ParseTool2.平台Util2;
import common.CommonConst;

public class 圖形計算_新_M頭_頭肩頂 implements 圖形計算_新 {

	@Override
	public 圖形 圖形判别(平台 p, List<折点> 折点list1, List<折点> 折點list_優化後, List<折点> 折点list3) {
		
		
		if(p.get高低() == CommonConst.平台_高低_高) {
			return 圖形判别_向下(p, 折点list1, 折點list_優化後, 折点list3);
		}
		if(p.get高低() == CommonConst.平台_高低_低) {
			return 圖形判别_向上(p, 折點list_優化後, 折点list3);
		}
		
		return null;
	}
	
	public 圖形 圖形判别_向下(平台 p, List<折点> 折点list1, List<折点> 折點list_優化後, List<折点> 折点list3) {
		
		List<折点> 折点list高點 = 平台Util2.取得指定list的高點list(p.get平台折点list1());
		List<折点> 折点list低點 = 平台Util2.取得指定list的低點list(p.get平台折点list1());
		
		// 高台要加两端的低点
		// 平台只保留了以高点为边界的信息
		// 如果是高台，就需要两端的低点
		高臺計算Util.完善高台两端的低点(p, 折点list1);
		
		圖形 t = new 圖形計算_M頭_頭肩頂_高().取得M頭信息(p, 折點list_優化後, 折点list高點, 折点list低點);
		if(t != null) {
			//圖形list.add(t);
			//continue;
			
			return t;
		}
		
		t = new 圖形計算_M頭_頭肩頂_高().取得頭肩頂信息(p, 折點list_優化後, 折点list高點, 折点list低點, 折点list3);
		if(t != null) {
			//圖形list.add(t);
			//continue;
			
			return t;
		}
		
		return new 圖形計算_その他_高().取得圖形信息(p, 折點list_優化後, 折点list高點, 折点list低點, 折点list3) ;
	}
	
	public 圖形 圖形判别_向上(平台 p, List<折点> 折點list_優化後, List<折点> 折点list3) {
		List<折点> 折点list高點 = 平台Util2.取得指定list的高點list(p.get平台折点list1());
		List<折点> 折点list低點 = 平台Util2.取得指定list的低點list(p.get平台折点list1());
		
		圖形 t = new 圖形計算_M頭_頭肩頂_低().取得M底信息(p, 折點list_優化後, 折点list高點, 折点list低點);
		if(t != null) {
			//圖形list.add(t);
			//continue;
			
			return t;
		}
		
		t = new 圖形計算_M頭_頭肩頂_低().取得頭肩底信息(p, 折點list_優化後, 折点list高點, 折点list低點, 折点list3);
		if(t != null) {
			//圖形list.add(t);
			//continue;
			
			return t;
		}
		
		return new 圖形計算_その他_低().取得圖形信息(p, 折點list_優化後, 折点list高點, 折点list低點, 折点list3) ;
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
		
		if(o圖形.get高低() == CommonConst.平台_高低_高) {
			return 趨勢計算_向下(o圖形, 折点list1, 折点list2, 折点list3,折點list_優化後);
		}
		if(o圖形.get高低() == CommonConst.平台_高低_低) {
			return 趨勢計算_向上(o圖形, 折点list1, 折点list2, 折点list3,折點list_優化後);
		}
		
		return null;
	}
	
	public 圖形 趨勢計算_向下(圖形 o圖形, List<折点> 折点list1, List<折点> 折点list2, List<折点> 折点list3, List<折点> 折點list_優化後) {
//		List<折点> 折点list高點 = 平台Util2.取得指定list的高點list(o圖形.get平台折点list());
//		List<折点> 折点list低點 = 平台Util2.取得指定list的低點list(o圖形.get平台折点list());
		//-----------------------------------------------
		// 目的：豐富圖形信息，計算差價，驗證教科书圖形是否有效
		// 循環取得所有圖形
		//     如果图形是高台（10=高臺）
		//     	   是否存在下跌後的第一個折點
		//         是否存在下跌後的第一個低点
		
	
		// 高台_破位后第一折点頸線價格差;    // 破位后第一折点 - 頸線價 的絶対値
		// 高台_破位后第二折点頸線價格差;    // 破位后第二折点 - 頸線價 的絶対値
		// 高台_破位折点;
		// 高台_破位前折点;
		// 高台_破位后第一折点;
		// 高台_破位后第二折点;
		//-----------------------------------------------
		
		int i開始index= o圖形.getI開始index();
		int i破位index = i開始index;
		// 取得最值折点
		折点 p1 = o圖形.get高台_最値折點();
				
		for( int i = i開始index;;i++) {
			
			float f該日頸線價格 = 0;
			if(o圖形.get形状()==1) {// 0=M形 1=頭肩形 2=收縮三角形
				
				f該日頸線價格 = o圖形.get高台_頸線價格();
				// 頸線Util.取得该日颈线价格(折点list低點.get(0), 折点list低點.get(1), 折点list23, p3.get日時());
				f該日頸線價格 = 頸線Util.取得该日颈线价格(o圖形.get高台_第一折点(), o圖形.get高台_第三折点(), 折点list1, 折点list1.get(i).get日時());
			}			
			if(o圖形.get形状()==0) {// 0=M形 1=頭肩形 2=收縮三角形
				f該日頸線價格 = o圖形.get高台_頸線價格();
			}			
			
			float f該日價格 = Float.parseFloat(折点list1.get(i).get价格());
			if(f該日價格 < f該日頸線價格) {
				i破位index = i;
				break;
			}
			
		}
		折点 p2 =折点list1.get(i破位index);
		o圖形.set高台_破位折点(p2);
		
		int index =  平台Util2.取得指定日期后的第一index(折點list_優化後, p2.get日時());
		
		o圖形.set高台_破位前折点(折點list_優化後.get(index-1));  //折点list23 上 三角形_破位前折点
		o圖形.set高台_破位后第一折点(折點list_優化後.get(index));//折点list23 上 三角形_半路折点
		if(index+2 >= 折點list_優化後.size()) {
		}else {
			o圖形.set高台_破位后第二折点(折點list_優化後.get(index+2));//折点list23 上 三角形_底部折点
		}
		
		
		return o圖形;
	}
	
	public 圖形 趨勢計算_向上(圖形 o圖形, List<折点> 折点list1, List<折点> 折点list2, List<折点> 折点list3, List<折点> 折點list_優化後) {
		List<折点> 折点list高點 = 平台Util2.取得指定list的高點list(o圖形.get平台折点list1());
		List<折点> 折点list低點 = 平台Util2.取得指定list的低點list(o圖形.get平台折点list1());
		//-----------------------------------------------
		// 目的：豐富圖形信息，計算差價，驗證教科书圖形是否有效
		// 循環取得所有圖形
		//     如果图形是高台（10=高臺）
		//     	   是否存在下跌後的第一個折點
		//         是否存在下跌後的第一個低点
		
		// 高台_破位后第一折点頸線價格差;    // 破位后第一折点 - 頸線價 的絶対値
		// 高台_破位后第二折点頸線價格差;    // 破位后第二折点 - 頸線價 的絶対値
		// 高台_破位折点;
		// 高台_破位前折点;
		// 高台_破位后第一折点;
		// 高台_破位后第二折点;
		//-----------------------------------------------
		
		int i開始index= o圖形.getI開始index();
		int i破位index = i開始index;
		折点 p1 = 折点list高點.get(2);
				
		for( int i = i開始index;;i++) {
			
			float f該日頸線價格 = 0;
			if(o圖形.get形状()==1) {// 0=M形 1=頭肩形 2=收縮三角形
				
				f該日頸線價格 = 頸線Util.取得该日颈线价格(o圖形.get高台_第三折点(), p1, 折点list1, 折点list1.get(i).get日時());
			}			
			if(o圖形.get形状()==0) {// 0=M形 1=頭肩形 2=收縮三角形
				f該日頸線價格 = o圖形.get高台_頸線價格();
			}			
			
			float f該日價格 = Float.parseFloat(折点list1.get(i).get价格());
			if(f該日價格 > f該日頸線價格) {
				i破位index = i;
				break;
			}
			
		}

		折点 p2 =折点list1.get(i破位index);
		o圖形.set高台_破位折点(p2);
		
		int index =  平台Util2.取得指定日期后的第一index(折點list_優化後, p2.get日時());
		
		o圖形.set高台_破位前折点(折點list_優化後.get(index-1));  //折点list23 上 三角形_破位前折点
		o圖形.set高台_破位后第一折点(折點list_優化後.get(index));//折点list23 上 三角形_半路折点
		o圖形.set高台_破位后第二折点(折點list_優化後.get(index+2));//折点list23 上 三角形_底部折点
		
		return o圖形;
	}

}
