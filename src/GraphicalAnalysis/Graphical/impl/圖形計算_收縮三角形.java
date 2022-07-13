package GraphicalAnalysis.Graphical.impl;

import java.util.ArrayList;
import java.util.List;

import GraphicalAnalysis.Graphical.圖形計算;
import OutputData.圖形;
import OutputData.平台;
import OutputData.折点;
import ParseTool2.平台Util2;

public class 圖形計算_收縮三角形  implements 圖形計算{
	public List<圖形> 計算(List<折点> 折点list23, List<平台> 平台list){

		//-----------------------------------------------
		// 折点组合下，存不存在收縮三角形
		// 
		// 對於連續兩個以上折點的組合
		
		// 成立条件
		
		//     高点收缩
		
		//     低点不创新低
		
		//     高点收缩趋势（向下）
		
		//     低点收缩趋势（向上）
		
		// 追加【收縮三角形】的圖形
		//-----------------------------------------------


		
		return 取得收縮三角形信息(折点list23);
		
	}
	private List<圖形> 取得收縮三角形信息( List<折点> 折点list23) {
		List<圖形> 圖形list = new ArrayList();
		
		//-----------------------------------------------
		// 折点组合下，存不存在收縮三角形
		// 
		// 對於連續兩個以上折點的組合
		
		// 成立条件
		
		//     高点收缩
		
		//     低点不创新低
		
		//     高点收缩趋势（向下）
		
		//     低点收缩趋势（向上）
		
		// 追加【收縮三角形】的圖形
		//-----------------------------------------------		
		
		// 每次取得 三个低点(含两个高点)
		int i开始index = 0;
		List<折点> 三个低点list = 平台Util2.取得三个低点(折点list23, i开始index);
		int i狀態 = 0; // 建立三角形
		while(三个低点list != null) {
			
			
			
			if(i狀態 == 0) { // 尋找三角形
				// 未找到三角形
				
				boolean b1 = 平台Util2.is高点收缩(三个低点list);		// 高点收缩
				boolean b2 = 平台Util2.is低点不创新低(三个低点list);	// 低点收缩
				if(b1 && b2) {
					//繼續取得 看是否會有打破三角形的時候
					i狀態 = 1;// 找到三角形
					
					i开始index++;
					三个低点list = 平台Util2.取得三个低点2(折点list23, i开始index, 三个低点list);
					continue;
					
				}
				
			}else if(i狀態 == 1) { // 尋找打破三角形
				// 已找到三角形
				// 找到三角形
			
				boolean b1 = 平台Util2.is是否打破三角形(三个低点list);
				if(b1 == false) { // 没有打破三角形
					//繼續取得 看是否會有打破三角形的時候
					i狀態 = 0;// 尋找三角形
					i开始index++;
					三个低点list = 平台Util2.取得三个低点2(折点list23, i开始index, 三个低点list);
					continue;
					
				}else {
					// 打破三角形
					// 完成三角形信息
					圖形 t = new 圖形();
					// t.setI最低价格index(i开始index);
					 t.setI開始index(三个低点list.get(0).getIndex());
					 t.setI開始日時(三个低点list.get(0).get日時());
					 t.setI結束index(三个低点list.get(三个低点list.size()-2).getIndex());
					 t.setI結束日時(三个低点list.get(三个低点list.size()-2).get日時());
					 t.setI類型(i狀態);// 10=高臺M頭  11=高臺頭肩頂   20=收縮三角形
					 t.set三角形_大邊最低價格(i狀態); // 第一低点的价格
					 t.set三角形_大邊最高價格(i狀態); // 第一高点的价格
					 t.set三角形_破点折点(三个低点list.get(三个低点list.size()-1));     // 最后的低点或高点价格
					 t.set三角形_第一折点(三个低点list.get(0));// 第一低点的价格 
					 t.set三角形_第二折点(三个低点list.get(1));// 第一高点的价格
					 t.set三角形_第三折点(三个低点list.get(2));// 第二低点的价格 
					 t.set三角形_第四折点(三个低点list.get(3));// 第二高点的价格 					
					 t.set平台折点list(三个低点list);
					 t.set方向(i狀態);// 0=向上 1=向下 // 破點折點為高點，時向上  破點折點為低點，時向下 
					 
					 圖形list.add(t);
					
				}
				
			}			
			
			// 未找到三角形
			i开始index++;
			三个低点list = 平台Util2.取得三个低点(折点list23, i开始index);
		}
		
		
		return 圖形list;
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
