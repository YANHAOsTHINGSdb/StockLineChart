package GraphicalAnalysis.Graphical.impl;

import java.util.List;

import GraphicalAnalysis.Graphical.圖形計算;
import OutputData.圖形;
import OutputData.平台;
import OutputData.折点;
import ParseTool2.簡單解析Util2;

public class 圖形計算_その他_低 extends 圖形計算_M頭_頭肩頂_低 implements 圖形計算 {

	@Override
	public List<圖形> 計算(List<折点> 折點list_優化後, List<平台> 平台list, List<折点> 折点list3) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public 圖形 取得圖形信息(平台 p, List<折点> 折点list23, List<折点> 折点list高點, List<折点> 折点list低點, List<折点> 折点list3) {
//		int 形状; // 0=M形 1=頭肩形 2=收縮三角形 99=其他位置图形
//		
//		float 高台_頸部最高價格差;              // 最値折点 - 頸線價 的絶対値
//		float 高台_破位后第一折点頸線價格差;    // 破位后第一折点 - 頸線價 的絶対値
//		float 高台_破位后第二折点頸線價格差;    // 破位后第二折点 - 頸線價 的絶対値
//		float 高台_頸線價格;
//		折点  高台_第一折点;                    // M頭-开始低点       M底-开始高点
//		折点  高台_第二折点;                    // M頭-开始高点       M底-开始低点  
//		折点  高台_第三折点;                    // M頭-頸線关键低點   M底-頸線关键高點
//		折点  高台_第四折点;                    //                    
//		折点  高台_第五折点;                    //                    only M底 有效
//		折点  高台_第六折点;                    //                    only M底 有效
//		折点  高台_最値折點;                    // M頭-最高點         M底-最低點
//		
//		折点  高台_破位折点;
//		折点  高台_破位前折点;
//		折点  高台_破位后第一折点;
//		折点  高台_破位后第二折点;
		
		圖形 t圖形 = new 圖形(p);
		折点 p3 = 簡單解析Util2.取得指定折点List的最高点(折点list高點);
		float f高台_頸部最高價格 = Float.parseFloat(p3.get价格());
		
		
		float f高台_頸線價格 = 頸線Util.取得该日颈线价格(折点list低點.get(0), 折点list低點.get(1), 折点list23, p3.get日時());
		t圖形.set高台_頸部最高價格差(f高台_頸部最高價格 - f高台_頸線價格);// 中間低點的價格
		
		t圖形.set高台_第一折点(折点list低點.get(0));// 开始折点
		t圖形.set高台_第二折点(折点list高點.get(0));// 开始高点
		t圖形.set高台_第三折点(折点list低點.get(1));// 頸線关键高低點
		t圖形.set高台_第四折点(折点list高點.get(1));
		t圖形.set高台_第五折点(折点list低點.get(2));// only 頭肩形 有效
		t圖形.set高台_第六折点(折点list高點.get(2));// only 頭肩形 有效
		t圖形.set高台_最値折點(p3);// 最高低點
		t圖形.set高台_頸線價格(f高台_頸線價格);
		
		return t圖形;
	}

}
