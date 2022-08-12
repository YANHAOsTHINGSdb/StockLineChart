package GraphicalAnalysis.Graphical.impl;

import java.util.ArrayList;
import java.util.List;

import GraphicalAnalysis.Graphical.圖形計算;
import OutputData.圖形;
import OutputData.平台;
import OutputData.折点;
import ParseTool2.平台Util2;

public class 圖形計算_M頭_頭肩頂_低 implements 圖形計算 {

	@Override
	public List<圖形> 計算(List<折点> 折點list_優化後, List<平台> 平台list, List<折点> 折点list3) {
		List<圖形> 圖形list = new ArrayList();


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
			
			List<折点> 折点list高點p = 平台Util2.取得指定list的高點list(p.get平台折点list1());
			List<折点> 折点list低點p = 平台Util2.取得指定list的低點list(p.get平台折点list1());
			
			圖形 t = 取得M頭信息(p, 折點list_優化後, 折点list高點p, 折点list低點p);
			if(t != null) {
				圖形list.add(t);
				continue;
			}
			
			t = 取得頭肩頂信息(p, 折點list_優化後, 折点list高點p, 折点list低點p, 折点list3);
			if(t != null) {
				圖形list.add(t);
				continue;
			}
			
		}
		
		return 圖形list;
	}

	private 圖形 取得頭肩頂信息(平台 p, List<折点> 折點list_優化後, List<折点> 折点list高點p, List<折点> 折点list低點p, List<折点> 折点list3) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	private 圖形 取得M頭信息(平台 p, List<折点> 折點list_優化後, List<折点> 折点list高點p, List<折点> 折点list低點p) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public 圖形 取得M底信息(平台 p, List<折点> 折點list_優化後, List<折点> 折点list高點, List<折点> 折点list低點) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public 圖形 取得頭肩底信息(平台 p, List<折点> 折點list_優化後, List<折点> 折点list高點, List<折点> 折点list低點, List<折点> 折点list3) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
