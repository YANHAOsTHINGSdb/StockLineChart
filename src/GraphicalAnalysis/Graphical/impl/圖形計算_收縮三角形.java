package GraphicalAnalysis.Graphical.impl;

import java.util.List;

import GraphicalAnalysis.圖形;
import GraphicalAnalysis.Graphical.圖形計算;
import OutputData.平台;
import OutputData.折点;

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
