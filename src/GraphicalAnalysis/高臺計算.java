package GraphicalAnalysis;

import java.util.List;

import OutputData.平台;
import OutputData.折点;

public class 高臺計算 {

	public List<平台> 計算(List<折点> 折点list2) {
		
		List<平台> 平台list = null;
		
		//-----------------------------------------------
		// 从折点list3 取得所有高点
		
		// 循環處理每一個高點.
		
		//     取得相邻的两个高点
		
		//     条件A：判断上记两个高点在折点list2里是否也是同样相邻
		
		//     条件B：判断上记两个高点是不是在对方90%-110%之間
		
		//     如果条件A与B同時滿足
		
		//    上記兩個高點就是一個平臺
		
		// 追加 到平台list，属性为【高台】
		//-----------------------------------------------
		
		
		//-----------------------------------------------
		// 从折点list3 取得所有低点
		// 循環處理每一個低點.
		//	     取得相邻的两个低点
		//	     条件A：判断上记两个低点在折点list2里是否也是同样相邻.
		//	     条件B：判断上记两个低点是不是在对方90%-110%之間
		//	     如果条件A与B同時滿足
		//	    上記兩個低點就是一個平臺
		// 追加 到平台list，属性为【低台】
		//-----------------------------------------------
		
		return 平台list;
		
	}

	public List<折点> 排除幹擾(List<折点> 折点list2, List<折点> 折点list3, List<平台> 平台list) {

		List<折点> 折点list23 = null;
		//-----------------------------------------------
		// 从折点list2 取得所有低点
		
		// 循環處理每一個低點.
		
		//    該低點是不是也是折點list3的低點
		
		//    上記為【是】的情況
		
		//    	  低点之后是高点还是高台
		
		//    	  如果是高點：去掉折點list2裏對應的折點（高低一對）
		
		//        如果是高台：保留最高位的那对儿
		//-----------------------------------------------
		
		
		return 折点list23;
	}

	public List<折点> 高台充实(List<折点> 折点list1, List<折点> 折点list23, List<平台> 平台list) {
		
		//-----------------------------------------------
		// 循環處理平台list里的每一個高台.
		
		//    条件A：高台的两端之间存在未记录的高点。
		
		//    条件B：該高點在允許範圍內 90-110%，
		
		//    如果条件A与B同時滿足
		
		//        追加该折点（高低）到折点list23
		//-----------------------------------------------
		
		return 折点list23;
	}

}
