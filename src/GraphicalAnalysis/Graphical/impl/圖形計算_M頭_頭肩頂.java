package GraphicalAnalysis.Graphical.impl;

import java.util.List;

import GraphicalAnalysis.圖形;
import GraphicalAnalysis.Graphical.圖形計算;
import OutputData.平台;
import OutputData.折点;

public class 圖形計算_M頭_頭肩頂 implements 圖形計算{

	public List<圖形> 計算(List<折点> 折点list23, List<平台> 平台list) {
		List<圖形> 圖形list = null;
		// 取得平台内每一个高台
		//     在該高臺內，具有5個折點(2高，3低)
		//     兩邊低點的價格相當
		//     如果满足以上条件：M頭
		
		// 取得平台内每一个高台
		//     在該高臺內，具有7個折點(3高，4低)
		//     兩邊低點的價格相當
		//	   中間的高點價格最高  
		//     如果满足以上条件：頭肩頂
		
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
