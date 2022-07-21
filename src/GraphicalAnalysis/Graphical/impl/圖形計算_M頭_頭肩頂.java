package GraphicalAnalysis.Graphical.impl;

import java.util.ArrayList;
import java.util.List;

import GraphicalAnalysis.Graphical.圖形計算;
import OutputData.圖形;
import OutputData.平台;
import OutputData.折点;
import ParseTool2.平台Util2;
import ParseTool2.簡單解析Util2;

public class 圖形計算_M頭_頭肩頂 implements 圖形計算{

	@Override
	public List<圖形> 計算(List<折点> 折點list_優化後, List<平台> 平台list, List<折点> 折点list3) {
		List<圖形> 圖形list = new ArrayList();
		List<折点> 折点list高點 = 平台Util2.取得指定list的高點list(折點list_優化後);
		List<折点> 折点list低點 = 平台Util2.取得指定list的低點list(折點list_優化後);

		//-----------------------------------------------
		// 可以是M頭，也可以是頭肩頂，無論哪一個都可以被晉級為圖形
		// 取得平台内每一个高台
		//     在該高臺內，具有5個折點(2高，3低)
		//     兩邊低點的價格相當
		//     如果满足以上条件：M頭
		
		// 取得平台内每一个高台
		//     在該高臺內，具有7個折點(3高，4低)
		//     兩邊低點的價格相當
		//	   中間的高點價格最高  
		//     如果满足以上条件：頭肩頂
		//-----------------------------------------------
		for(平台 p : 平台list) {
			
			圖形 t = 取得M頭信息(p, 折點list_優化後, 折点list高點, 折点list低點);
			if(t != null) {
				圖形list.add(t);
				continue;
			}
			
			t = 取得頭肩頂信息(p, 折點list_優化後, 折点list高點, 折点list低點, 折点list3);
			if(t != null) {
				圖形list.add(t);
				continue;
			}
			
		}
		
		return 圖形list;
	}
	
	public 圖形 取得頭肩頂信息(平台 p, List<折点> 折点list23, List<折点> 折点list高點, List<折点> 折点list低點, List<折点> 折点list3) {
		List<折点> 折点list = p.get平台折点list();
		
		圖形 t圖形 = new 圖形(p);
		//-----------------------------------------------
		// 可以是M頭，也可以是頭肩頂，無論哪一個都可以被晉級為圖形
		// 取得平台内每一个高台
		//     在該高臺內，具有5個折點(2高，3低)
		//     兩邊低點的價格相當
		//     如果满足以上条件：M頭
		//-----------------------------------------------
		
		// 包括了下行中的高点
		// 所以只取高台部分的高点
		List<折点> 相對高點list = 取得高台部分的相对高点(折点list高點, 折点list3);
		
		if(相對高點list.size() == 2 ) {
			// 在該高臺內，具有5個折點(2高，3低)			
		}else {
			return null;
		}
		
		//-----------------------------------------------
		if(相對高點list.size() == 3 ) {
			// 在該高臺內，具有5個折點(2高，3低)			
		}else {
			return null;
		}
		
		// 低点同位
		折点 p1 = 折点list低點.get(1);
		折点 p2 = 折点list低點.get(折点list低點.size()-1);
		float p_rate = 平台Util2.取得折点差价范围(p1, p2);
		if(p_rate >= 0.9 && p_rate <= 1.1) {

			//float 高台_頸部最高價格差;              // 最値折点 - 頸線價 的絶対値
			//float 高台_破位后第一折点頸線價格差;    // 破位后第一折点 - 頸線價 的絶対値
			//float 高台_破位后第二折点頸線價格差;    // 破位后第二折点 - 頸線價 的絶対値
			//折点  高台_第一折点;                    // M頭-开始低点       M底-开始高点
			//折点  高台_第二折点;                    // M頭-开始高点       M底-开始低点  
			//折点  高台_第三折点;                    // M頭-頸線关键低點   M底-頸線关键高點
			//折点  高台_最値折點;                    // M頭-最高點         M底-最低點
			
			//折点  高台_破位折点;
			//折点  高台_破位前折点;
			//折点  高台_破位后第一折点;
			//折点  高台_破位后第二折点;
			
			t圖形.set形状(1);// 0=M形 1=頭肩形 2=收縮三角形
			
			//
			折点 p3 = 簡單解析Util2.取得指定折点List的最高点(折点list高點);
			float f高台_頸部最高價格 = Float.parseFloat(p3.get价格());
			
			//float f高台_頸線價格 = Float.parseFloat(折点list低點.get(1).get价格());
			float f高台_頸線價格 = 頸線Util.取得该日颈线价格(折点list低點.get(1), 折点list低點.get(2), 折点list23, p3.get日時());
			
			t圖形.set高台_頸部最高價格差(f高台_頸部最高價格 - f高台_頸線價格);// 中間低點的價格
			//			
			t圖形.set高台_第一折点(折点list低點.get(0));// 开始折点
			t圖形.set高台_第二折点(折点list高點.get(0));// 开始高点
			t圖形.set高台_第三折点(折点list低點.get(1));// 頸線关键高低點
			t圖形.set高台_最値折點(p3);// 最高低點
			t圖形.set高台_頸線價格(f高台_頸線價格);
			
		}
		
		return t圖形;
	}

	private List<折点> 取得高台部分的相对高点(List<折点> 折点list高點, List<折点> 折点list3) {
		// 這對高點不在折點list3對象範圍內
		// 特点是，它在最后，且不在折點list3内
		
		折点 z = 折点list高點.get(折点list高點.size()-1);
		
		if(平台Util2.is折点是否在指定list中(z, 折点list3)) {
			
			折点list高點.subList(0, 折点list高點.size()-3);
		}
		
		return 折点list高點;
	}

	public 圖形 取得M頭信息(平台 p, List<折点> 折点list23, List<折点> 折点list高點, List<折点> 折点list低點) {
		List<折点> 折点list = p.get平台折点list();
		圖形 t圖形 = new 圖形(p);
		//-----------------------------------------------
		// 可以是M頭，也可以是頭肩頂，無論哪一個都可以被晉級為圖形
		// 取得平台内每一个高台
		//     在該高臺內，具有7個折點(3高，4低)
		//     兩邊低點的價格相當
		//	   中間的高點價格最高  
		//     如果满足以上条件：頭肩頂
		//-----------------------------------------------
		if(折点list高點.size() >= 2 ) {
			// 在該高臺內，具有5個折點(2高，3低)			
		}else {
			return null;
		}
		//-----------------------------------------------
		if(折点list低點.size() >= 3 ) {
			// 在該高臺內，具有5個折點(2高，3低)			
		}else {
			return null;
		}
		
		折点 p1 = 折点list低點.get(0);
		折点 p2 = 折点list低點.get(折点list低點.size()-1);

		float p_rate = 平台Util2.取得折点差价范围(p1, p2);
		if(p_rate >= 0.9 && p_rate <= 1.1) {
			
			//float 高台_頸部最高價格差;              // 最値折点 - 頸線價 的絶対値
			//float 高台_破位后第一折点頸線價格差;    // 破位后第一折点 - 頸線價 的絶対値
			//float 高台_破位后第二折点頸線價格差;    // 破位后第二折点 - 頸線價 的絶対値
			//折点  高台_第一折点;                    // M頭-开始低点       M底-开始高点
			//折点  高台_第二折点;                    // M頭-开始高点       M底-开始低点  
			//折点  高台_第三折点;                    // M頭-頸線关键低點   M底-頸線关键高點
			//折点  高台_最値折點;                    // M頭-最高點         M底-最低點
			
			//折点  高台_破位折点;
			//折点  高台_破位前折点;
			//折点  高台_破位后第一折点;
			//折点  高台_破位后第二折点;
			
			t圖形.set形状(1);// 0=M形 1=頭肩形 2=收縮三角形
			
			折点 p3 = 簡單解析Util2.取得指定折点List的最高点(折点list高點);
			float f高台_頸部最高價格 = Float.parseFloat(p3.get价格());
			
			float f高台_頸線價格 = Float.parseFloat(折点list低點.get(1).get价格());
			
			t圖形.set高台_頸部最高價格差(f高台_頸部最高價格 - f高台_頸線價格);// 中間低點的價格
			//			
			t圖形.set高台_第一折点(折点list低點.get(0));// 开始折点
			t圖形.set高台_第二折点(折点list高點.get(0));// 开始高点
			t圖形.set高台_第三折点(折点list低點.get(1));// 頸線关键高低點
			t圖形.set高台_最値折點(p3);// 最高低點
			t圖形.set高台_頸線價格(f高台_頸線價格);
		}
		
		return t圖形;
	}

	public 圖形 取得M底信息(平台 p, List<折点> 折點list_優化後, List<折点> 折点list高點, List<折点> 折点list低點) {
		
		圖形 t圖形 = new 圖形(p);
		//-----------------------------------------------
		// 可以是M頭，也可以是頭肩頂，無論哪一個都可以被晉級為圖形
		// 取得平台内每一个高台
		//     在該高臺內，具有7個折點(3高，4低)
		//     兩邊低點的價格相當
		//	   中間的高點價格最高  
		//     如果满足以上条件：頭肩頂
		//-----------------------------------------------
		if(折点list高點.size() >= 3 ) {
			// 在該高臺內，具有5個折點(2高，3低)			
		}else {
			return null;
		}
		//-----------------------------------------------
		if(折点list低點.size() >= 2 ) {
			// 在該高臺內，具有5個折點(2高，3低)			
		}else {
			return null;
		}
		
		折点 p1 = 折点list低點.get(0);
		折点 p2 = 折点list低點.get(折点list低點.size()-1);

		float p_rate = 平台Util2.取得折点差价范围(p1, p2);
		if(p_rate >= 0.9 && p_rate <= 1.1) {
			
			//float 高台_頸部最高價格差;              // 最値折点 - 頸線價 的絶対値
			//float 高台_破位后第一折点頸線價格差;    // 破位后第一折点 - 頸線價 的絶対値
			//float 高台_破位后第二折点頸線價格差;    // 破位后第二折点 - 頸線價 的絶対値
			//折点  高台_第一折点;                    // M頭-开始低点       M底-开始高点
			//折点  高台_第二折点;                    // M頭-开始高点       M底-开始低点  
			//折点  高台_第三折点;                    // M頭-頸線关键低點   M底-頸線关键高點
			//折点  高台_最値折點;                    // M頭-最高點         M底-最低點
			
			//折点  高台_破位折点;
			//折点  高台_破位前折点;
			//折点  高台_破位后第一折点;
			//折点  高台_破位后第二折点;
			
			t圖形.set形状(1);// 0=M形 1=頭肩形 2=收縮三角形
			
			折点 p3 = 簡單解析Util2.取得指定折点List的最低点(折点list低點);
			
			
			float f高台_頸部最低價格 = Float.parseFloat(p3.get价格());
			
			float f高台_頸線價格 = Float.parseFloat(折点list高點.get(1).get价格());
			
			t圖形.set高台_頸部最高價格差(f高台_頸線價格 - f高台_頸部最低價格);// 中間低點的價格
			//			
			t圖形.set高台_第一折点(折点list高點.get(0));// 开始折点
			t圖形.set高台_第二折点(折点list低點.get(0));// 开始高点
			t圖形.set高台_第三折点(折点list高點.get(1));// 頸線关键高低點
			t圖形.set高台_最値折點(p3);// 最高低點
			t圖形.set高台_頸線價格(f高台_頸線價格);
		}
		
		return t圖形;
	}

	public 圖形 取得頭肩底信息(平台 p, List<折点> 折點list_優化後, List<折点> 折点list高點, List<折点> 折点list低點, List<折点> 折点list3) {
		List<折点> 折点list = p.get平台折点list();
		
		圖形 t圖形 = new 圖形(p);
		//-----------------------------------------------
		// 可以是M頭，也可以是頭肩頂，無論哪一個都可以被晉級為圖形
		// 取得平台内每一个高台
		//     在該高臺內，具有5個折點(2高，3低)
		//     兩邊低點的價格相當
		//     如果满足以上条件：M頭
		//-----------------------------------------------
		
		// 頭肩底的开始是下行线与颈线的结合点
		
		// 頭肩底的第一个低点才是实际开始点
		
		// 頭肩底的最低点与颈线的差是颈线高差
		
		// 頭肩底的第一折点与颈线的差是第一折点颈线差
		
		// 頭肩底的第二折点与颈线的差是第二折点颈线差
		

		//-----------------------------------------------
		// 可以是M頭，也可以是頭肩頂，無論哪一個都可以被晉級為圖形
		// 取得平台内每一个高台
		//     在該高臺內，具有5個折點(2高，3低)
		//     兩邊低點的價格相當
		//     如果满足以上条件：M頭
		//-----------------------------------------------
		
		// 包括了下行中的高点
		// 所以只取高台部分的高点
		List<折点> 相對高點list = 取得高台部分的相对高点(折点list高點, 折点list3);
		
		if(相對高點list.size() == 2 ) {
			// 在該高臺內，具有5個折點(2高，3低)			
		}else {
			return null;
		}
		
		//-----------------------------------------------
		if(相對高點list.size() == 3 ) {
			// 在該高臺內，具有5個折點(2高，3低)			
		}else {
			return null;
		}
		
		// 低点同位
		折点 p1 = 折点list高點.get(1);
		折点 p2 = 折点list高點.get(折点list高點.size()-1);
		float p_rate = 平台Util2.取得折点差价范围(p1, p2);
		if(p_rate >= 0.9 && p_rate <= 1.1) {

			//float 高台_頸部最高價格差;              // 最値折点       - 頸線價 的絶対値
			//float 高台_破位后第一折点頸線價格差;    // 破位后第一折点 - 頸線價 的絶対値
			//float 高台_破位后第二折点頸線價格差;    // 破位后第二折点 - 頸線價 的絶対値
			//折点  高台_第一折点;                    // M頭-开始低点       M底-开始高点
			//折点  高台_第二折点;                    // M頭-开始高点       M底-开始低点  
			//折点  高台_第三折点;                    // M頭-頸線关键低點   M底-頸線关键高點
			//折点  高台_最値折點;                    // M頭-最高點         M底-最低點
			
			//折点  高台_破位折点;
			//折点  高台_破位前折点;
			//折点  高台_破位后第一折点;
			//折点  高台_破位后第二折点;
			
			t圖形.set形状(1);// 0=M形 1=頭肩形 2=收縮三角形
			//

			折点 p3 = 簡單解析Util2.取得指定折点List的最低点(折点list低點);
			float f高台_頸部最低價格 = Float.parseFloat(p3.get价格());
			
			//float f高台_頸線價格 = Float.parseFloat(p3.get价格());
			float f高台_頸線價格 = 頸線Util.取得该日颈线价格(折点list低點.get(1), 折点list低點.get(2), 折點list_優化後, p3.get日時());
			
			t圖形.set高台_頸部最高價格差(f高台_頸線價格 - f高台_頸部最低價格);// 中間低點的價格
			//			
			t圖形.set高台_第一折点(折点list高點.get(0));// 开始折点
			t圖形.set高台_第二折点(折点list低點.get(0));// 开始高点
			t圖形.set高台_第三折点(折点list高點.get(1));// 頸線关键高低點
			t圖形.set高台_最値折點(p3);// 最高低點
			t圖形.set高台_頸線價格(f高台_頸線價格);

		}
		
		return t圖形;
		

	}


}
