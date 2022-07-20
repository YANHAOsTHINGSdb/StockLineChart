package GraphicalAnalysis.Graphical.impl;

import java.util.List;

import OutputData.折点;
import ParseTool2.簡單解析Util2;

public class 頸線Util {


	public static float 取得该日颈线价格(折点 get三角形_第一折点, 折点 get三角形_第三折点, List<折点> 折点list1, int i日時) {
		// 在指定折点list 取得 【get三角形_第一折点】的index1
		// 在指定折点list 取得 【get三角形_第三折点】的index2
		// 在指定折点list 取得 【i日時】的index2
		// 取得index1和index2對應的價格
		int x = i日時;
		int x1 = 簡單解析Util2.取得指定日期的index(折点list1, get三角形_第一折点.get日時());
		float y1 = Float.parseFloat(get三角形_第一折点.get价格());
		int x2 = 簡單解析Util2.取得指定日期的index(折点list1, get三角形_第三折点.get日時());
		float y2 = Float.parseFloat(get三角形_第三折点.get价格());				
				
		float f  = 取得该日颈线价格(x ,x1, y1, x2, y2);
		
		return f;
	}

	private static float 取得该日颈线价格(int x, int x1, float y1, int x2, float y2) {
		
		return (x - x1)*(y2-y1)/(x2-x1) + y1;
	}

}
