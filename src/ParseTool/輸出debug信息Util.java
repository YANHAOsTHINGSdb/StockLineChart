package ParseTool;

import java.util.List;

import InputData.日線;
import InputData.簡單解析;
import InputData.計算目標;
import OutputData.折点;
import ParseTool2.輸出折線圖數據3;
import common.CommonConst;

public class 輸出debug信息Util {
	
	
	static 計算目標 計算目標_确;
	static 計算目標 計算目標_假;
	
	public static void print標題() {
		System.out.println("日期    開盤    收盤    最高    最低    計算目標・確    計算目標・假    簡易・開    簡易・高    簡易・低    簡易・收     A    B ");

	}
	public static void print(List<折点> list折点, 計算目標 l計算目標, List<日線> list日線,int 日線index, 簡單解析 簡單解析對象, String s處理模式) {
		計算目標 o計算目標1  = new 計算目標(l計算目標);
		計算目標 o計算目標2  = new 計算目標(l計算目標);	
		
		// 只有debugMode 才输出
		if(輸出折線圖數據3.debugMode != CommonConst.debugMode) return ;
		
		
		if(計算目標_确 == null || 計算目標_假 == null) {
			計算目標_确 = o計算目標1;
			計算目標_假 = o計算目標2;
		}
		
		
		if(o計算目標1.get确() != null && 計算目標_确.get确() != null && o計算目標1.get确().get日時() == 計算目標_确.get确().get日時() && o計算目標1.get确().get价格().equals(計算目標_确.get确().get价格()) ) {
			o計算目標1 = null;			
		}else {
			計算目標_确 = o計算目標1;
		}
		
		
		if(o計算目標2.get假() != null  && 計算目標_假.get确() != null && o計算目標2.get假().get日時() == 計算目標_假.get假().get日時() && o計算目標2.get假().get价格().equals(計算目標_假.get假().get价格())) {
			o計算目標2 = null;	
		}else {
			計算目標_假 = o計算目標2;
		}
		

			
		
		String[] s =
			 {
//				list日線 == null || list日線.get(日線index).get日時()==null ? "----": list日線.get(日線index).get日時() + "",
//				list日線 == null || list日線.get(日線index).get開盤_价格()==null ? "----": list日線.get(日線index).get開盤_价格() + "",
//				list日線 == null || list日線.get(日線index).get收盤_价格()==null ? "----": list日線.get(日線index).get收盤_价格() + "",
//				list日線 == null || list日線.get(日線index).get最高_价格()==null ? "----": list日線.get(日線index).get最高_价格() + "",
//				list日線 == null || list日線.get(日線index).get最低_价格()==null ? "----": list日線.get(日線index).get最低_价格() + "",

				o計算目標1 == null || o計算目標1.get确() == null || o計算目標1.get确().get日時()==0 ? "    ": o計算目標1.get确().get日時() + "",
				o計算目標1 == null || o計算目標1.get确() == null || o計算目標1.get确().get价格()==null ? "    ": o計算目標1.get确().get价格() + "",
				o計算目標1 == null || o計算目標1.get确()==null ? "  " : o計算目標1.get确().get高低()==0?"低":"高",
				o計算目標2 == null || o計算目標2.get假() == null || o計算目標2.get假().get日時()==0 ? "    ": o計算目標2.get假().get日時() + "",
				o計算目標2 == null || o計算目標2.get假() == null || o計算目標2.get假().get价格()==null ? "    ": o計算目標2.get假().get价格() + "",
				o計算目標2 == null || o計算目標2.get假()==null ? "  " : o計算目標2.get假().get高低()==0?"低":"高",
				o計算目標2 == null ? "  " : o計算目標2.get求高低()==0?"低":"高",
				簡單解析對象 == null || 簡單解析對象.get开始().get日時()==0 ? "----": 簡單解析對象.get开始().get日時() + "",
				簡單解析對象 == null || 簡單解析對象.get开始().get价格()==null ? "----": 簡單解析對象.get开始().get价格() + "",
				簡單解析對象 == null || 簡單解析對象.get最高().get日時()==0 ? "----": 簡單解析對象.get最高().get日時() + "",
				簡單解析對象 == null || 簡單解析對象.get最高().get价格()==null ? "----": 簡單解析對象.get最高().get价格() + "",
				簡單解析對象 == null || 簡單解析對象.get最低().get日時()==0 ? "----": 簡單解析對象.get最低().get日時() + "",
				簡單解析對象 == null || 簡單解析對象.get最低().get价格()==null ? "----": 簡單解析對象.get最低().get价格() + "",
				簡單解析對象 == null || 簡單解析對象.get結束().get日時()==0 ? "----": 簡單解析對象.get結束().get日時() + "",
				簡單解析對象 == null || 簡單解析對象.get結束().get价格()==null ? "----": 簡單解析對象.get結束().get价格() + "",
				s處理模式 != null && s處理模式.equals("A") ?"●":"--",
				s處理模式 != null && s處理模式.equals("B") ?"●":"--"
				 
			 };
		
		
		System.out.printf("計・確%10s(%6s)(%1s)    假%10s(%6s)(%1s)   求(%1s)    簡・開%10s(%6s)    高%10s(%6s)    低%10s(%6s)    收%10s(%6s)   處%1s   處%1s %n", 
				s[0],
				s[1],
				s[2],
				s[3],
				s[4],
				s[5],
				s[6],
				s[7],
				s[8],
				s[9],
				s[10],
				s[11],
				s[12],
				s[13],
				s[14],
				s[15],
				s[16]
				);

	}
}
