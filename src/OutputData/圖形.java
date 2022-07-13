package OutputData;

import lombok.Data;

@Data
public class 圖形 extends 平台{
	
	public 圖形(平台 p) {
		this.i開始index = p.getI開始index();
		this.i結束index = p.getI結束index();
		this.i開始日時 = p.getI開始日時();
		this.i結束日時 = p.getI結束日時();
		this.i類型 = p.getI類型();
	}
	public 圖形() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	int 属性; // 10=高臺M頭  11=高臺頭肩頂   20=收縮三角形
	int 方向; // 0=向上 1=向下
	float 高台_頸部最高價格;
	float 高台_頸線價格;
	折点  高台_第一折点;
	折点  高台_第二折点;
	
	float 三角形_大邊最低價格;
	float 三角形_大邊最高價格;
	折点 三角形_破点折点;
	折点  三角形_第一折点;
	折点  三角形_第二折点;
	折点  三角形_第三折点;
	折点  三角形_第四折点;
}
