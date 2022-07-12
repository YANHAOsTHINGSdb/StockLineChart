package GraphicalAnalysis.Graphical.impl;

import java.util.List;

import GraphicalAnalysis.Graphical.圖形計算;
import OutputData.圖形;
import OutputData.平台;
import OutputData.折点;
import ParseTool2.平台Util2;

public class 圖形計算_收縮三角形  implements 圖形計算{
	public List<圖形> 計算(List<折点> 折点list23, List<平台> 平台list){
		List<圖形> 圖形list = null;

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

		for(平台 p : 平台list) {
			圖形 t = 取得收縮三角形信息(p, 折点list23);
			if(t != null) {
				圖形list.add(t);
				continue;
			}

			
		}
		
		return 圖形list;
		
	}
	private 圖形 取得收縮三角形信息(平台 p, List<折点> 折点list23) {
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
		int i = 0;
		List<折点> 三个低点list = 平台Util2.取得三个低点(折点list23, i);
		int i狀態 = 0; // 建立三角形
		while(三个低点list != null) {
			
			
			
			if(i狀態 == 0) { // 尋找三角形
				//  高点收缩
				boolean b1 = 平台Util2.is高点收缩(三个低点list);
				boolean b2 = 平台Util2.is低点不创新低(三个低点list);
				if(b1 && b2) {
					//繼續取得 看是否會有打破三角形的時候
					i狀態 = 1;// 打破三角形
					三个低点list = 平台Util2.取得三个低点(折点list23, i, 三个低点list);
					continue;
					
				}
				
			}else if(i狀態 == 1) { // 尋找打破三角形		
				
			
				boolean b1 = 平台Util2.is是否打破三角形(三个低点list);
				if(b1 == false) { // 没有打破三角形
					//繼續取得 看是否會有打破三角形的時候
					i狀態 = 0;// 尋找三角形
					三个低点list = 平台Util2.取得三个低点(折点list23, i, 三个低点list);
					continue;
					
				}else {
					// 打破三角形
					// 完成三角形信息
					
					
				}
				
			}
			
			
			// 未找到三角形
			i++;
			三个低点list = 平台Util2.取得三个低点(折点list23, i);
		}
		
		
		return null;
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
