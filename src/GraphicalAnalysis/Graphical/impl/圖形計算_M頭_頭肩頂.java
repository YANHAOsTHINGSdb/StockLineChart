package GraphicalAnalysis.Graphical.impl;

import java.util.ArrayList;
import java.util.List;

import GraphicalAnalysis.Graphical.圖形計算;
import OutputData.圖形;
import OutputData.平台;
import OutputData.折点;
import ParseTool2.平台Util2;
import common.CommonConst;

public class 圖形計算_M頭_頭肩頂 implements 圖形計算{

	@Override
	public List<圖形> 計算(List<折点> 折點list_優化後, List<平台> 平台list, List<折点> 折点list3) {
		List<圖形> 圖形list = null;
		List<折点> 折点list高點 = new ArrayList();
		List<折点> 折点list低點 = new ArrayList();
		for(折点 z : 折點list_優化後) {
			if(z.get高低() == CommonConst.高点) {
				折点list高點.add(z);
			}
		}
		
		// 从折点list3 取得所有低点
		for(折点 z : 折點list_優化後) {
			if(z.get高低() == CommonConst.低点) {
				折点list低點.add(z);
			}
		}
		
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
		折点 p1 = 折点list低點.get(0);
		折点 p2 = 折点list低點.get(折点list低點.size()-1);
		float p_rate = 平台Util2.取得折点差价范围(p1, p2);
		if(p_rate >= 0.9 && p_rate <= 1.1) {

			t圖形.set形状(0);// 0=M形 1=頭肩形 2=收縮三角形
			float f高台_頸線價格 = Float.parseFloat(折点list低點.get(1).get价格());
			t圖形.set高台_頸線價格(f高台_頸線價格);// 中間低點的價格
			float f高台_頸部最高價格 = Float.parseFloat(折点list高點.get(0).get价格());
			t圖形.set高台_頸部最高價格(f高台_頸部最高價格);// 折点list23高点价格
			
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
		if(折点list高點.size() == 3 ) {
			// 在該高臺內，具有5個折點(2高，3低)			
		}else {
			return null;
		}
		//-----------------------------------------------
		if(折点list低點.size() == 4 ) {
			// 在該高臺內，具有5個折點(2高，3低)			
		}else {
			return null;
		}
		
		折点 p1 = 折点list低點.get(0);
		折点 p2 = 折点list低點.get(折点list低點.size()-1);
		float p_rate = 平台Util2.取得折点差价范围(p1, p2);
		if(p_rate >= 0.9 && p_rate <= 1.1) {
			
			t圖形.set形状(1);// 0=M形 1=頭肩形 2=收縮三角形
			float f高台_頸線價格 = Float.parseFloat(折点list低點.get(1).get价格());
			t圖形.set高台_頸線價格(f高台_頸線價格);// 中間低點的價格
			float f高台_頸部最高價格 = Float.parseFloat(折点list高點.get(1).get价格());
			t圖形.set高台_頸部最高價格(f高台_頸部最高價格);// 折点list23高点价格
			
		}
		
		return t圖形;
	}

	@Override
	public List<圖形> 圖形計算_下跌(List<折点> 折点list23, List<平台> 平台list, List<圖形> 圖形_M頭_頭肩頂圖形list) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<圖形> 圖形計算_上升(List<折点> 折点list23, List<平台> 平台list, List<圖形> 圖形_收縮三角形list) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


}
