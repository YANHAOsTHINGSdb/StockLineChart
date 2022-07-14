package GraphicalAnalysis;

import java.util.List;

import OutputData.圖形;
import OutputData.平台;
import OutputData.折点;

public interface 圖形計算1 {


	圖形 圖形判别(平台 p, List<折点> 折點list_優化後, List<折点> 折点list3);

	圖形 趨勢計算(圖形 o圖形, List<折点> 折点list1, List<折点> 折点list2, List<折点> 折点list3);

}
