package InputData;

import OutputData.折点;
import lombok.Data;

@Data
public class 計算目標 {

	public 計算目標(計算目標 o計算目標) {
		求高低 =o計算目標.求高低;
		确 = o計算目標.get确();
		假 = o計算目標.get假();
		求 = o計算目標.get求();
	}
	public 計算目標() {
		
	}
	int 求高低;
	折点  确;
	折点  假;
	折点  求;

}
