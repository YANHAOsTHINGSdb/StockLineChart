package GraphicalAnalysis;

import java.util.List;

import GraphicalAnalysis.Graphical.圖形計算;
import GraphicalAnalysis.Graphical.impl.圖形計算_M頭_頭肩頂;
import GraphicalAnalysis.Graphical.impl.圖形計算_收縮三角形;
import GraphicalAnalysis.Graphical.impl.圖形計算_收縮三角形上升;
import GraphicalAnalysis.Graphical.impl.圖形計算_高台下跌;
import OutputData.平台;
import OutputData.折点;
import OutputData.頸線;
import ParseTool2.平台Util2;
import ParseTool2.輸出頸線圖數據2;

public class 圖形解析 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}
	
	
	void 輸出圖形解析結果(List<折点> 折点list1, List<折点> 折点list2) {
		
		List<圖形> 圖形list = new 圖形解析().o圖形解析(折点list1, 折点list2);
		
		List<頸線> list = new 圖形解析().輸出頸線圖數據(圖形list, (float)0.1);
		
	}


	private List<圖形> o圖形解析(List<折点> 折点list1, List<折点> 折点list2) {
		// 第三次折点计算
		List<折点> 折点list3 = new 輸出頸線圖數據2().輸出折線圖數據(折点list2);
		
		// 高臺計算
		高臺計算 o高臺計算 = new 高臺計算();
		List<平台> 平台list = o高臺計算.計算(折点list3);
		
		// 排除幹擾
		List<折点>折點list_優化後 = o高臺計算.排除幹擾(折点list2, 折点list3, 平台list);
		// 高台充实
		折點list_優化後 = o高臺計算.高台充实(折点list1, 折點list_優化後, 平台list);
		
		// 圖形計算_M頭_頭肩頂
		圖形計算 o圖形計算_M頭_頭肩頂 = new 圖形計算_M頭_頭肩頂();		
		List<圖形> 圖形_M頭_頭肩頂圖形list = o圖形計算_M頭_頭肩頂.計算(折點list_優化後, 平台list);
		
		// 圖形計算_收縮三角形
		圖形計算 o圖形計算_收縮三角形 = new 圖形計算_收縮三角形();		
		List<圖形> 圖形_收縮三角形list = o圖形計算_收縮三角形.計算(折點list_優化後, 平台list);
		
		// 圖形計算_高台下跌
		圖形計算 o圖形計算_高台下跌 = new 圖形計算_高台下跌();		
		List<圖形> 圖形list = o圖形計算_高台下跌.圖形計算_下跌(折點list_優化後, 平台list, 圖形_M頭_頭肩頂圖形list);
		
		// 圖形計算_收縮三角形上升
		圖形計算 o圖形計算_收縮三角形上升 = new 圖形計算_收縮三角形上升();	
		圖形list.addAll(o圖形計算_收縮三角形上升.圖形計算_上升(折點list_優化後, 平台list, 圖形_收縮三角形list));
		
		return 圖形list;
	}
	

	public List<頸線> 輸出頸線圖數據(List<圖形> 圖形list, float 誤差範圍) {
		平台Util2 pUtil = new 平台Util2();
		
		// 
	//	List<平台> plist = pUtil.取得平台信息(圖形list, 誤差範圍);
		
		// 取得頸線信息
	//	List<頸線> 頸線list = pUtil.取得頸線信息(plist, 圖形list, 誤差範圍, null);
		
		List<頸線> 頸線list = null;
		return 頸線list;
		
	}
}
