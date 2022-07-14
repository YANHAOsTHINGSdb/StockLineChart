package GraphicalAnalysis.Platform;

import java.util.List;

import OutputData.平台;
import OutputData.折点;

public interface 平臺計算 {

	List<折点> 排除幹擾(List<折点> 折点list2, List<折点> 折点list3, 平台 p);

	List<折点> 平台充实(List<折点> 折点list1, List<折点> 單一平臺優化後, 平台 p);

}
