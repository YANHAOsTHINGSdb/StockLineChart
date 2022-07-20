package GraphicalAnalysis.Platform.impl;

import java.util.List;

import GraphicalAnalysis.Graphical.impl.頸線Util;
import GraphicalAnalysis.Platform.圖形計算_新;
import OutputData.圖形;
import OutputData.平台;
import OutputData.折点;

public class 圖形計算_新_收縮三角形 implements 圖形計算_新 {

	@Override
	public 圖形 圖形判别(平台 p, List<折点> 折點list_優化後, List<折点> 折点list3) {
		// 由于 三角形是复数平台的结合，但是新设计是按平台单位返回【圖形】的
		// 所以还要在原来的设计计算
		// 在這裏【割愛】了
		return null;
	}
	
	@Override
	public 圖形 趨勢計算(圖形 o圖形, List<折点> 折点list1, List<折点> 折点list2, List<折点> 折点list3, List<折点> 折點list_優化後) {
		/*
			三角形 趨勢計算
			—————————————
			
			三角形 破位点（list2中）是高点还是低点
			       高点：向上突破、+1低点（中途）、+1高点（頂點）
			       低点：向下突破、+1高点（中途）、+1低点（底部）
			       
			三角形破位价格（日線list  上 三角形_破点日期）：
			三角形破位折点（折点list1 上 三角形_破点折点）：
					三角形破位折点的实际价格
			        頸線延伸（該日期的頸線價格，與實際價格）
			
			頸線：高三角：低点价格线（第一二高点）
			      低三角：高点价格线（第一二低点）
			
			第二低点：价格排位第二低、非時間排位第二低
			第二高点：時間排位第二高
			
			三角形破位后半路折点（折点list2 上 三角形_破点折点）：
			         +1低点（中途）
			         +1高点（中途）
			
			三角形破位后底部折点：
			         +1高点（頂點）
			         +1低点（底部）
		 */
		
		// 目標：計算以下信息
		//		折点 三角形_破位折点; //（折点list1  上 三角形_破点日期）		
		//		折点 三角形_破位后半路折点;//（折点list23 上 三角形_半路折点）
		//		折点 三角形_破位后底部折点;//（折点list23 上 三角形_底部折点）
		
		
		
		
		折点 a = o圖形.get三角形_破位后半路折点(); // 折点 三角形_破位折点; //（折点list1  上 三角形_破点日期）		
		
		if(a.get高低() == 1) { //高
			// 如果三角形_半路折点为高点，底三角形_向上
			return 趨勢計算_底三角形_向上(o圖形, 折点list1, 折点list2, 折点list3, 折點list_優化後);
		
		}else if(a.get高低() == 0) { //低
			// 如果三角形_半路折点为低点，高三角形_向下
			return 趨勢計算_高三角形_向下(o圖形, 折点list1, 折点list2, 折点list3, 折點list_優化後);
		}
		
		
		
		return null;
	}

	private 圖形 趨勢計算_高三角形_向下(圖形 o圖形, List<折点> 折点list1, List<折点> 折点list2, List<折点> 折点list3, List<折点> 折點list_優化後) {
		// 目標：計算以下信息
		//		折点 三角形_破位折点; //（折点list1  上 三角形_破点日期）		
		//		折点 三角形_破位后半路折点;//（折点list23 上 三角形_半路折点）
		//		折点 三角形_破位后底部折点;//（折点list23 上 三角形_底部折点）
		
		List<折点> 三角形对象折点list = o圖形.get平台折点list();
		
		// 底三角形的颈线是 三角形底部低点 的向上拉伸
	    // 第一低点 第二低点,延申到破前折点（日期）的价格
		//      在折点list从破前折点（日期）开始
		//		計算該日期颈线價格
		//		與實際價格比較
		//		低于实际价格的折点就是【三角形_破位折点】
		
		int i開始日時 = o圖形.getI開始日時();
		int i開始index= o圖形.getI開始index();
		int i破位index = i開始index;
				
		for( int i = i開始index;;i++) {
			
			float f該日頸線價格 = 頸線Util.取得该日颈线价格(o圖形.get三角形_第一折点(), o圖形.get三角形_第三折点(), 折点list1, 折点list1.get(i).get日時());
			float f該日價格 = Float.parseFloat(折点list1.get(i).get价格());
			if(f該日價格 > f該日頸線價格) {
				i破位index = i;
				break;
			}
			
		}
		o圖形.set三角形_破位折点(折点list1.get(i破位index));

		
		return o圖形;
	}

	private 圖形 趨勢計算_底三角形_向上(圖形 o圖形, List<折点> 折点list1, List<折点> 折点list2, List<折点> 折点list3, List<折点> 折點list_優化後) {
		// 目標：計算以下信息
		//		折点 三角形_破位折点; //（折点list1  上 三角形_破点日期）		
		//		折点 三角形_破位后半路折点;//（折点list23 上 三角形_半路折点）
		//		折点 三角形_破位后底部折点;//（折点list23 上 三角形_底部折点）
		
		List<折点> 三角形对象折点list = o圖形.get平台折点list();
		
		// 高三角形的颈线是 三角形高点折点 的向下拉伸
		// 第一低点 第二低点,延申到破后折点（日期）的价格
		//      在折点list从破前折点（日期）开始
		//		計算該日期颈线價格
		//		與實際價格比較
		//		高于实际价格的折点就是【三角形_破位折点】
		
		return null;
	}



}
