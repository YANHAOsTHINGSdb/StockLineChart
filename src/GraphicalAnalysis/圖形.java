package GraphicalAnalysis;

import OutputData.平台;
import lombok.Data;

@Data
public class 圖形 extends 平台{
	
	int 属性; // 10=高臺M頭  11=高臺頭肩頂   20=收縮三角形
	int 方向; // 0=向上 1=向下
	float 高台_頸部最高價格;
	float 高台_頸線價格;
	float 高台_第一折点;
	float 高台_第二折点;
	
	float 三角形_大邊最低價格;
	float 三角形_大邊最高價格;
	float 三角形_破点價格;
	float 三角形_第一折点;
	float 三角形_第二折点;

}
