package ParseTool2;

import java.util.ArrayList;
import java.util.List;

import OutputData.平台;
import OutputData.折点;
import OutputData.頸線;
import ParseTool.平台Util;

public class 輸出頸線圖數據1 {

	public static void main(String[] args) {
		

		String[][] arrayList折点 =
			 {
				 {"20190327","11.11","11.08","11.04","11.24","42124489","469246336.00"},
				 {"20190328","11.03","11.03","10.90","11.05","29296120","321585856.00"}
			 };
		
//		int 日時; // YYYYMMDD
//		String 位置; //SHLE
//		int 高低; //(高。低)
//		String 价格;
//		int index
		List<折点> 折点list = new ArrayList();
		for(String[] array折点 : arrayList折点){
			折点list.add(new 折点(
				array折点[0],
				array折点[1],
				array折点[2],
				array折点[3],
				array折点[4]
				));
		}
		

		List<頸線> list = new 輸出頸線圖數據1().輸出頸線圖數據(折点list, (float)0.1);
		

	}
	
	
	public List<頸線> 輸出頸線圖數據(List<折点> 折点list, float 誤差範圍) {
		
		平台Util pUtil = new 平台Util();
		
		// 
		List<平台> plist = pUtil.取得平台信息(折点list, 誤差範圍);
		
		// 是不是存在頸線
		//boolean b = pUtil.是否存在颈线(plist.get(0), 折点list);
		
		List<頸線> 頸線list = new  ArrayList();
		
		for(平台 x平台 : plist) {
			// 取得頸線信息
			頸線 o頸線 = pUtil.取得頸線信息(x平台, 折点list, 誤差範圍, null);
		
		
			頸線list.add(o頸線);
		}
		
		return 頸線list;
		
	}


	
}
