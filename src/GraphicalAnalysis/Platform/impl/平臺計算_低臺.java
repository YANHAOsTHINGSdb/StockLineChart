package GraphicalAnalysis.Platform.impl;

import java.util.ArrayList;
import java.util.List;

import GraphicalAnalysis.Platform.平臺計算;
import GraphicalAnalysis.Platform.高臺計算Util;
import OutputData.平台;
import OutputData.折点;

public class 平臺計算_低臺 implements 平臺計算 {

	@Override
	public List<折点> 排除幹擾(List<折点> 折点list2, List<折点> 折点list3, List<平台> 平台list) {

		return new 高臺計算Util().排除幹擾(折点list2, 折点list3, 平台list);
	}

	@Override
	public List<折点> 平台充实(List<折点> 折点list1, List<折点> 單一平臺優化後, 平台 p) {
		List<平台> 平台list = new ArrayList();
		平台list.add(p);
		//public List<折点> 高台充实(List<折点> 折点list1, List<折点> 折点list23, List<平台> 平台list) {
		return new 高臺計算Util().高台充实(折点list1, 單一平臺優化後, 平台list);
	}

	@Override
	public List<折点> 排除幹擾(List<折点> 折点list2, List<折点> 折点list3, 平台 p) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
