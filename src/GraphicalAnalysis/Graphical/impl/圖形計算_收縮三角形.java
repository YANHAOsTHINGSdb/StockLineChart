package GraphicalAnalysis.Graphical.impl;

import java.util.ArrayList;
import java.util.List;

import GraphicalAnalysis.Graphical.圖形計算;
import OutputData.圖形;
import OutputData.平台;
import OutputData.折点;
import ParseTool2.平台Util2;

public class 圖形計算_收縮三角形  implements 圖形計算{

	private List<圖形> 取得收縮三角形信息( List<折点> 折點list_優化後) {
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
		List<折点> 三個低點之間折點list = 平台Util2.取得三個低點之間折點(折點list_優化後, i开始index);
		int i狀態 = 0; // 建立三角形
		while(三個低點之間折點list != null) {
			
			
			
			if(i狀態 == 0) { // 尋找三角形
				// 未找到三角形
				
				boolean b1 = 平台Util2.is高点收缩(三個低點之間折點list);		// 高点收缩
				boolean b2 = 平台Util2.is低点不创新低(三個低點之間折點list);	// 低点收缩
				if(b1 && b2) {
					//繼續取得 看是否會有打破三角形的時候
					i狀態 = 1;// 找到三角形
					
					i开始index++;
					三個低點之間折點list = 平台Util2.追加取得三個低點之間折點(折點list_優化後, i开始index, 三個低點之間折點list);
					continue;
					
				}
				
			}else if(i狀態 == 1) { // 尋找打破三角形
				// 已找到三角形
				// 找到三角形
			
				boolean b1 = 平台Util2.is是否打破三角形(三個低點之間折點list);
				if(b1 == false) { // 没有打破三角形
					//繼續取得 看是否會有打破三角形的時候
					i狀態 = 0;// 尋找三角形
					i开始index++;
					三個低點之間折點list = 平台Util2.追加取得三個低點之間折點(折點list_優化後, i开始index, 三個低點之間折點list);
					continue;
					
				}else {
					 // 打破三角形
					 // 完成三角形信息
					 圖形 t = new 圖形();
					
					 List<折点> 三角形对象折点list = 平台Util2.取得两点之间的折点List(折點list_優化後, 三個低點之間折點list.get(0), 三個低點之間折點list.get(三個低點之間折點list.size()-1));
					
					 // t.setI最低价格index(i开始index);
					 t.setI開始index(三角形对象折点list.get(0).getIndex());
					 t.setI開始日時(三角形对象折点list.get(0).get日時());
					 t.setI結束index(三角形对象折点list.get(三角形对象折点list.size()-2).getIndex());
					 t.setI結束日時(三角形对象折点list.get(三角形对象折点list.size()-2).get日時());
					 // t.setI類型(i狀態);// 10=高臺M頭  11=高臺頭肩頂   20=收縮三角形
					 t.set形状(2); // int 形状; // 0=M形 1=頭肩形 2=收縮三角形
					 t.set三角形_大邊最低價格(i狀態); // 第一低点的价格
					 t.set三角形_大邊最高價格(i狀態); // 第一高点的价格
					 t.set三角形_優化後破点折点(三角形对象折点list.get(三角形对象折点list.size()-1));     // 最后的低点或高点价格
					 t.set三角形_第一折点(三角形对象折点list.get(0));// 第一低点的价格 
					 t.set三角形_第二折点(三角形对象折点list.get(1));// 第一高点的价格
					 //取得所有低点
					 //排序之后第二低
					 t.set三角形_第三折点(三個低點之間折點list.get(三個低點之間折點list.size()-2));// 第二低点的价格 价格第二低 
					 t.set三角形_第四折点(三角形对象折点list.get(4));// 第二高点的价格 時間第二前
					 
					 折点 z打破折点 = 三角形对象折点list.get(三角形对象折点list.size()-1);
					 t.set三角形_破位后半路折点(z打破折点);
					 
					 // 方便计算颈线
					 折点 z破前折点 = 三角形对象折点list.get(三角形对象折点list.size()-2);
					 t.set三角形_破位前折点(z破前折点);
					 
					 三角形对象折点list.remove(三角形对象折点list.size()-1);// 最后一个折点打破三角形不算在内
					 t.set平台折点list(三角形对象折点list);
					// t.set方向(z打破折点.get高低());// 0=向上 1=向下 // 破點折點為高點，時向上  破點折點為低點，時向下 
					 
					 圖形list.add(t);
					
				}
				
			}			
			
			// 未找到三角形
			i开始index++;
			三個低點之間折點list = 平台Util2.取得三個低點之間折點(折點list_優化後, i开始index);
		}
		
		
		return 圖形list;
	}

	
	@Override
	public List<圖形> 計算(List<折点> 折點list_優化後, List<平台> 平台list, List<折点> 折点list3) {

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


		
		return 取得收縮三角形信息(折點list_優化後);
	}
}
