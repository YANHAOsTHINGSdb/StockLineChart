package OutputData;

import java.util.List;

import lombok.Data;

@Data
public class 平台 {
	// 平台:折点3的两个低点间的数据为一个平台数据。
	
	public 平台(平台 p) {
		 i類型 = p.getI類型();// (0:高点 1:高台)
		 i開始日時 = p.getI開始日時(); // YYYYMMDD
		 i開始index = p.getI開始index(); // 
		 i結束日時 = p.getI結束日時(); // YYYYMMDD
		 i結束index = p.getI結束index(); // 
		 頸線日時list = p.get頸線日時list();//頸線與平臺結合的交叉點的日期List
		 頸椎日時 = p.get頸椎日時();
		 頸部跌幅 = p.get頸部跌幅();// 價格（頸椎日時）- 頸線價格 （頸椎日時）
		 o頸線 = p.getO頸線();
		 i最低价格index = p.getI最低价格index(); // 
	
	}
	public 平台() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	int i類型;
	int i開始日時; // YYYYMMDD
	int i開始index; // 
	int i結束日時; // YYYYMMDD
	int i結束index; // 
	List<Integer> 頸線日時list;//頸線與平臺結合的交叉點的日期List
	int 頸椎日時;
	float 頸部跌幅;// 價格（頸椎日時）- 頸線價格 （頸椎日時）
	頸線 o頸線;
	int i最低价格index; // 
	List<折点> 平台折点list;//頸線與平臺結合的交叉點的日期List
}
