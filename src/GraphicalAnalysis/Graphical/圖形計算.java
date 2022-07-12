package GraphicalAnalysis.Graphical;

import java.util.List;

import OutputData.圖形;
import OutputData.平台;
import OutputData.折点;

public interface 圖形計算 {

	public List<圖形> 計算(List<折点> 折点list23, List<平台> 平台list);

	public List<圖形> 圖形計算_下跌(List<折点> 折点list23, List<平台> 平台list, List<圖形> 圖形_M頭_頭肩頂圖形list);

	public List<圖形> 圖形計算_上升(List<折点> 折点list23, List<平台> 平台list, List<圖形> 圖形_收縮三角形list);


}
