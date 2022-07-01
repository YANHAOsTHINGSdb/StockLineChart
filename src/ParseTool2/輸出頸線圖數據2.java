package ParseTool2;

import java.util.ArrayList;
import java.util.List;

import InputData.計算目標;
import OutputData.平台;
import OutputData.折点;
import OutputData.頸線;
import common.CommonConst;

public class 輸出頸線圖數據2 {
	public static void main(String[] args) {


		String[][] arrayList折点 =
			{
					{"20190327", "1", "S", "11.11"}, {"20190328", "0", "L", "10.90"},
					{"20190408", "1", "H", "11.96"}, {"20190411", "0", "L", "11.35"}, 
					{"20190419", "1", "H", "12.20"}, {"20190426", "0", "L", "11.28"}, 
					{"20190430", "1", "H", "12.09"}, {"20190510", "0", "L", "11.06"}, 
					{"20190514", "1", "H", "11.44"}, {"20190517", "0", "L", "11.20"}, 
					{"20190521", "1", "H", "11.45"}, {"20190523", "0", "L", "10.95"}, 
					{"20190528", "1", "H", "11.30"}, {"20190530", "0", "L", "11.03"}, 
					{"20190610", "1", "H", "11.70"}, {"20190611", "0", "L", "11.27"}, 
					{"20190620", "1", "H", "12.32"}, {"20190625", "0", "L", "11.51"}, 
					{"20190627", "1", "H", "11.84"}, {"20190628", "0", "L", "11.54"}, 
					{"20190701", "1", "H", "11.92"}, {"20190708", "0", "L", "11.31"}, 
					{"20190712", "1", "H", "11.62"}, {"20190715", "0", "L", "11.22"}, 
					{"20190716", "1", "H", "11.57"}, {"20190718", "0", "L", "11.45"}, 
					{"20190719", "1", "H", "11.63"}, {"20190723", "0", "L", "11.43"}, 
					{"20190725", "1", "H", "11.96"}, {"20190729", "0", "L", "11.80"}, 
					{"20190730", "1", "H", "12.00"}, {"20190806", "0", "L", "10.97"}, 
					{"20190814", "1", "H", "11.48"}, {"20190819", "0", "L", "11.08"}, 
					{"20190820", "1", "H", "11.47"}, {"20190821", "0", "L", "11.34"}, 
					{"20190823", "1", "H", "11.59"}, {"20190826", "0", "L", "11.15"}, 
					{"20190827", "1", "H", "11.57"}, {"20190829", "0", "L", "11.18"}, 
					{"20190905", "1", "H", "11.74"}, {"20190906", "0", "L", "11.58"}, 
					{"20190912", "1", "H", "12.09"}, {"20190917", "0", "L", "11.77"}, 
					{"20190918", "1", "H", "12.00"}, {"20190923", "0", "L", "11.68"}, 
					{"20190926", "1", "H", "12.18"}, {"20190927", "0", "L", "11.76"}, 
					{"20191014", "1", "H", "13.22"}, {"20191015", "0", "L", "12.86"}, 
					{"20191016", "1", "H", "13.33"}, {"20191018", "0", "L", "12.72"}, 
					{"20191022", "1", "H", "13.05"}, {"20191023", "0", "L", "12.77"}, 
					{"20191024", "1", "H", "13.24"}, {"20191101", "0", "L", "12.44"}, 
					{"20191105", "1", "H", "13.19"}, {"20191114", "0", "L", "12.10"}, 
					{"20191118", "1", "H", "12.35"}, {"20191121", "0", "L", "11.91"}, 
					{"20191126", "1", "H", "12.17"}, {"20191204", "0", "L", "11.70"}, 
					{"20191217", "1", "H", "12.51"}, {"20191218", "0", "L", "12.34"}, 
					{"20191220", "1", "H", "12.55"}, {"20191223", "0", "L", "12.17"}, 
					{"20191227", "1", "H", "12.43"}, {"20191230", "0", "L", "12.12"}, 
					{"20200106", "1", "H", "12.65"}, {"20200108", "0", "L", "12.25"}, 
					{"20200114", "1", "H", "12.69"}, {"20200116", "0", "L", "12.16"}
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
				array折点[3]
				));
		}

		List<頸線> list = new 輸出頸線圖數據2().輸出頸線圖數據(折点list, (float)0.1);

	}

	public List<頸線> 輸出頸線圖數據(List<折点> 折点list, float 誤差範圍) {
		平台Util2 pUtil = new 平台Util2();
		
		// 
		List<平台> plist = pUtil.取得平台信息(折点list, 誤差範圍);
		
		// 取得頸線信息
		List<頸線> 頸線list = pUtil.取得頸線信息(plist, 折点list, 誤差範圍, null);
		
		return 頸線list;
		
	}
	
	public List<折点> 輸出折線圖數據(String[][] arrayList日線) {
		
		List<折点> list折点 = new ArrayList();
		List<折点> list日線_折点 = new ArrayList();
		計算目標 o計算目標 = new 計算目標();
		
		int index = 0 ;

		CommonConst.debugMode =CommonConst.調試mode;
		
		int 對象個數 = 3;
		輸出折線圖數據(o計算目標, list日線_折点, index, 對象個數, list折点);
		 
		 return list折点;
		
	}
	
	計算目標Util2 計算目標util2 =new 計算目標Util2();

	private void 輸出折線圖數據(計算目標 o計算目標, List<折点> list日線_折点, int 假点index, int 對象個數, List<折点> list折点_頸線) {
//		一个区间内（假点，日线，index，對象個數）
//	       假点以后：做成處理对象（）
//	       判断：處理对象
//	       處理（處理对象）：更新假点，追加折点
//	       是否到了最后：无處理对象：返回
//	       遞歸調用自己：（假点，日線，index，對象個數）

		
		簡單解析2 o簡單解析 = 做成處理对象(o計算目標, list日線_折点, 假点index, 對象個數, CommonConst.A模式_取得新的区间);
		//輸出debug信息Util.print(list折点_頸線, o計算目標, list日線_折点, 假点index, o簡單解析, "A");
		
		int iResult = 判断(o簡單解析, o計算目標, list日線_折点, 假点index);
		
		if(iResult == CommonConst.如果_這是最後一次計算) {
			最后一次计算(o計算目標, o簡單解析, list折点_頸線);
			return;
		}
		

		簡單解析2 o簡單解析2 = 處理(iResult, o簡單解析, o計算目標, list日線_折点, list折点_頸線);
		//輸出debug信息Util.print(list折点_頸線, o計算目標, list日線_折点, 假点index, o簡單解析2, "A");
		
		if(是否到了最后(o計算目標, list日線_折点)) {
			最后一次计算(o計算目標, o簡單解析2, list折点_頸線);
			return;
		}
		
//		// 如果还有余點，出于一个区间有两个点的考虑，再找一次
//		if(o計算目標.get假().get日時() < o簡單解析2.get結束().get日時()) {
//			int i對象個數 = o簡單解析2.get結束().getIndex() - o計算目標.get假().getIndex();
//			輸出折線圖數據_B(o計算目標, list日線, o計算目標.get假().getIndex(), i對象個數, list折点);
//		}

		//index = 簡單解析Util.取得指定日期的index(list日線, o計算目標.get假().get日時());
		假点index =  o計算目標.get假().getIndex();
		//index++;

		if(假点index == 19 ) {
			假点index = 19;
		}
		
//		if(最后一次计算(list日線, index)) {
//			return;
//		}
		
		輸出折線圖數據(o計算目標, list日線_折点, 假点index, 對象個數,list折点_頸線);
		
	}

	private void 最后一次计算(計算目標 o計算目標, 簡單解析2 o簡單解析2, List<折点> list折点_頸線) {

		// 假点是否为日线的最后一个
		// 假点变确点
		計算目標util2.追加假点(o計算目標, o簡單解析2, list折点_頸線);	
	}

	private boolean 是否到了最后(計算目標 o計算目標, List<折点> list日線_折点) {
//		是否到了最后：
//	      假点是否为日线的最后一个

		int i最后一天日时 =list日線_折点.get(list日線_折点.size()-1).get日時();

		if(i最后一天日时 == o計算目標.get假().get日時()) {
			return true;
		}
		return false;
	}

	private 簡單解析2 處理(int iResult, 簡單解析2 簡單解析對象2, 計算目標 o計算目標, List<折点> list日線_折点, List<折点> list折点_頸線) {

		簡單解析2 O處理對象2 = 簡單解析對象2;
		// 新假点的前2天，后2天再确认
		// 重新取得指定日的前后指定天数的最大最小值（簡單解析對象）
		if(iResult !=  CommonConst.如果_這是第一次計算 &&  簡單解析對象2.getList指定数据().size() > 1 ) {
			if(o計算目標.get确().get日時() >= 20190927) {
				iResult = iResult;
			}
			int index假点 = o計算目標.get假().getIndex();
			O處理對象2 = new 簡單解析2(簡單解析Util2.取得指定日的前后指定天数的簡單解析(list日線_折点, index假点, CommonConst.對象個數, o計算目標.get求高低()));
			
			
			//  判斷2是否是周圍的極限點(int iResult, 簡單解析 o處理對象, 計算目標 o計算目標, List<日線> list日線, int 假index) 
			
			// 再算一次
			int inewResult = 判斷2是否是周圍的極限點(iResult, O處理對象2, o計算目標, list日線_折点, index假点);
			
			if(inewResult != iResult) {
				iResult = inewResult;
			}

		}

		switch (iResult) {

		case CommonConst.如果_手持低点_要找高点_但碰见一个更低的谷:
			//1=如果  手持低点，要找高点，但碰见一个更低的谷
			// 更新假点
			計算目標util2.更新假点(o計算目標, O處理對象2, list折点_頸線);
			break;

		case CommonConst.如果_手持低点_要找高点_但没有碰见一个更低的谷:
			//2=如果  手持低点，要找高点，但没有碰见一个更低的谷
			// 如果 碰見高點
			// 就，固定低点，假設高點，尋找下一個低點
			// 假点是否在簡單解析的对象中

			計算目標util2.追加假点(o計算目標, O處理對象2, list折点_頸線);
			break;

		case CommonConst.如果_手持高点_要找底点_但碰见一个更高的谷:
			//3=如果  手持高点，要找底点，但碰见一个更高的谷
			// 更新假点
			計算目標util2.更新假点(o計算目標, O處理對象2, list折点_頸線);
			break;

		case CommonConst.如果_手持高点_要找底点_但没碰见一个更高的谷:
			//4=如果  手持高点，要找底点，但没碰见一个更高的谷
			// 如果  碰見低點
			// 就，固定高点，假設低點，尋找下一個高點

			計算目標util2.追加假点(o計算目標, O處理對象2, list折点_頸線);
			break;

		case CommonConst.如果_這是第一次計算:
			//5=如果  這是第一次計算（折点list為空）
			計算目標util2.第一次计算(o計算目標, 簡單解析對象2, list折点_頸線);
			break;

		case CommonConst.如果_這是最後一次計算:
			//6=如果  這是最後一次計算（簡單解析结果的最后一条 ）
			計算目標util2.最后一次计算(o計算目標, O處理對象2, list折点_頸線);
			break;
		}
		
		return O處理對象2;
	}

	private int 判斷2是否是周圍的極限點(int i前次判断结果, 簡單解析2 o處理對象2, 計算目標 o計算目標, List<折点> list日線_折点, int index假点) {
		// iResult   iResult2
		//   1          2       中間存在一個反向高點
		//   3          4       中間存在一個反向低點
		//   2          1       存在更合适的高点
		//   4          3       存在更格式的低点		
		
		int i是否存在更合適的點 = 判斷_是否存在更合適的點( i前次判断结果,  o處理對象2,  o計算目標, list日線_折点,  index假点);
		
		if(i是否存在更合適的點 == i前次判断结果) {
			return i前次判断结果;
		}
		
		
		// iResult為2和4的時候，判斷一下更合適的點是否滿足需求：周圍極致點
		// 只對【i前次判断结果=2】和【i前次判断结果=4】有效
		boolean b是否極限點 = 判斷2是否是周圍的極限點(i前次判断结果, o計算目標, list日線_折点, o處理對象2);
		
		
		// 如果 两次判断的结果不一样，
		// 将下一个影响你的最高点 找到
		// 看看它是否是周围的一个极限点
		// 如果是，就将其设置为新的假点 ●
		
		switch (i前次判断结果) {

		//case CommonConst.如果_手持低点_要找高点_但碰见一个更低的谷:
		case CommonConst.如果_手持低点_要找高点_但没有碰见一个更低的谷:
			if(b是否極限點) {
				return CommonConst.如果_手持低点_要找高点_但碰见一个更低的谷;
			}else {
				return  CommonConst.如果_手持低点_要找高点_但没有碰见一个更低的谷;
			}

		//case CommonConst.如果_手持高点_要找底点_但碰见一个更高的谷:
		case CommonConst.如果_手持高点_要找底点_但没碰见一个更高的谷:

			if(b是否極限點) {
				return CommonConst.如果_手持高点_要找底点_但碰见一个更高的谷;
			}else {
				return CommonConst.如果_手持高点_要找底点_但没碰见一个更高的谷;
			}
			
		case CommonConst.如果_手持低点_要找高点_但碰见一个更低的谷:
		case CommonConst.如果_手持高点_要找底点_但碰见一个更高的谷:
			// 存在更合適的點
			return i是否存在更合適的點;
		}
		return i前次判断结果;
		

	}

	private boolean 判斷2是否是周圍的極限點(int i前次判断结果, 計算目標 o計算目標, List<折点> list日線_折点, 簡單解析2 o處理對象2) {
		// 如果 两次判断的结果不一样，
		// 将下一个影响你的最高点 找到
		// 看看它是否是周围的一个极限点 ●
		// 如果是，就将其设置为新的假点
		
		int index =0;
		
		if(o計算目標.get假().get高低() == CommonConst.高点) {
			index = o處理對象2.get最高().getIndex();
		}else {
			index = o處理對象2.get最低().getIndex();
		}
			
		簡單解析2 O處理對象2 = 簡單解析Util2.取得指定日的前后指定天数的簡單解析2(list日線_折点, index, CommonConst.對象個數, o計算目標.get假().get高低());
		
		if(o計算目標.get假().get高低() == CommonConst.高点) {
			if(O處理對象2.get最高().getIndex() != index) {
				return false; // 不是最高
			}else {
				return true; // 是最高
			}			

		}else {
			if(O處理對象2.get最低().getIndex() != index) {
				return false;// 不是最低
			}else {
				return  true;// 是最低
			}
		}
	}

	private int 判斷_是否存在更合適的點(int i前次判断结果, 簡單解析2 o處理對象2, 計算目標 o計算目標, List<折点> list日線_折点, int 假index) {
		// 如果 两次判断的结果不一样， ●
		// 将下一个影响你的最高点 找到
		// 看看它是否是周围的一个极限点
		// 如果是，就将其设置为新的假点
	
		boolean b比較結果 = false;
		float f假 = Float.parseFloat(  o計算目標.get假().get价格());
		float f最低_處理對象 = Float.parseFloat(  o處理對象2.get最低().get价格());
		float f最高_處理對象 = Float.parseFloat(  o處理對象2.get最高().get价格());
		
		switch (i前次判断结果) {
		case CommonConst.如果_手持高点_要找底点_但碰见一个更高的谷:
			
			//                        .←更高的谷 |判断范围
			//         高→ .        .  .         |
			//          .      .   .      .       |
			//       .           .          .     |
			//   .                            .   |
			
			
			 
			//假點與下一個極限點之間是否有存在一個反向低谷
			//且高低谷的寬度不小於 1.5倍對象個數
			//且高低谷的落差不小於 確與假的高度
			//　為什麽是1.5倍對象個數？因為，
			//　落差：最低--最高的價格差
			//　寬度：最低--最高--最低的單位個數
			
			
			// 如果高低在同一天，還是維持原判
			if(o處理對象2.get最低().getIndex() < o處理對象2.get最高().getIndex()) {
				int i寬度 = o處理對象2.get最高().getIndex() - 假index + 1;
			
				
				
				//float f落差_最高_最低 = f最高_處理對象 - f最低_處理對象;
				float f落差_假_最低 = f假 - f最低_處理對象;
				//float f落差_假_确   = f假 - Float.parseFloat(o計算目標.get确().get价格());
				float f落差_高_假   = f最高_處理對象 - f假;
				
				
				//且高低谷的寬度不小於 1.5倍對象個數
				//且高低谷的落差不小於 確與假的0.75 高度
				
				//if(f落差_最高_最低 >= f落差_假_确 * 0.75 && f落差_假_最低 > f落差_假_确 * 0.75) {	
				
				
				if(f落差_假_最低 >= f落差_高_假) {
					// o處理對象 = 低点---最后
					o處理對象2 = 簡單解析Util2.取得指定區間數據製作簡單解析3(o處理對象2, list日線_折点, o處理對象2.get最低().getIndex(), o處理對象2.get結束().getIndex());
					return CommonConst.如果_手持高点_要找底点_但没碰见一个更高的谷;
				}
			}
			
			return i前次判断结果;
					
		case CommonConst.如果_手持低点_要找高点_但碰见一个更低的谷:
			
			//	  .             .      |判断范围 
			//     .         .   .     |
			//      ・    ・           | 
			//         ・ ←低    ・   |
			//                     ・ ←更低的谷
			
			
			
			//假點與下一個極限點之間是否有存在一個反向低谷
			//且高低谷的寬度不小於 1.5倍對象個數
			//且高低谷的落差不小於 確與假的高度
			//　為什麽是1.5倍對象個數？因為，
			//　落差：最低--最高的價格差
			//　寬度：最低--最高--最低的單位個數
			
			if(o處理對象2.get最高().getIndex() < o處理對象2.get最低().getIndex()) {
				int i寬度 = o處理對象2.get最低().getIndex() - 假index + 1;
			
				// float f落差_最高_最低 = f最高_處理對象 - f最低_處理對象;
				// float f落差_假_确 =   Float.parseFloat(o計算目標.get确().get价格()) - f假;
				float f落差_假_最高 = f最高_處理對象 - f假;
				float f落差_低_假   = f假 -f最低_處理對象;
				
				//且高低谷的寬度不小於 1.5倍對象個數
				//且高低谷的落差不小於 確與假的0.75 高度
				
				//if(f落差_最高_最低 >= f落差_假_确 * 0.75 && f落差_假_最高 > f落差_假_确 * 0.75) {
				if(f落差_假_最高 >= f落差_低_假) {
					// o處理對象 = 低点---最后
					o處理對象2 = 簡單解析Util2.取得指定區間數據製作簡單解析3(o處理對象2, list日線_折点, o處理對象2.get最高().getIndex(), o處理對象2.get結束().getIndex());
					return CommonConst.如果_手持低点_要找高点_但没有碰见一个更低的谷;
				}
			}
			
			return i前次判断结果;
			
		//case CommonConst.如果_手持低点_要找高点_但碰见一个更低的谷:
		case CommonConst.如果_手持低点_要找高点_但没有碰见一个更低的谷:
			//    .
			//      .       |判断范围 ・     |追加范围
			//        ・    |        ・      |
			//          ・ ←低    ・        |
			//              |・  ・          |
			//              |  ・ ←更低的谷 |
			
			float f最低 = Float.parseFloat( o處理對象2.get最低().get价格());
			
			b比較結果 = o處理對象2.get最低().getIndex() != 假index && f最低 < f假;
			
			if(b比較結果) {
				return CommonConst.如果_手持低点_要找高点_但碰见一个更低的谷;
			}else {
				return  CommonConst.如果_手持低点_要找高点_但没有碰见一个更低的谷;
			}

		//case CommonConst.如果_手持高点_要找底点_但碰见一个更高的谷:
		case CommonConst.如果_手持高点_要找底点_但没碰见一个更高的谷:
			
			//        判断范围| .←更高的谷
			//         高→ . |   .         |追加范围
			//          .     |     .       |
			//       .        |       .     |
			//   .                      .   |
			
			float f最高 = Float.parseFloat( o處理對象2.get最高().get价格());
			
			b比較結果 = o處理對象2.get最高().getIndex() != 假index && f最高 > f假;
			
			if(b比較結果) {
				return CommonConst.如果_手持高点_要找底点_但碰见一个更高的谷;
			}else {
				return CommonConst.如果_手持高点_要找底点_但没碰见一个更高的谷;
			}
		}
		return i前次判断结果;
		
	}

	private int 判断(簡單解析2 o簡單解析2, 計算目標 o計算目標, List<折点> list日線_折点, int 假点index) {
//		判断：
//	      假点为空：第一次：追加确点，追加假点
//	      假点为高，求低，碰见更高：更新假点_高
//	      假点为高，求低，未碰见更高：追加新假点_高
//	      假点为低，求高，碰见更低：更新假点_低
//	      假点为低，求高，未碰见更低：追加新假点_低

		//5=如果  这是第一次计算（折点list為空 ）
		if(o計算目標.get假()==null)return CommonConst.如果_這是第一次計算;
		if(假点index >= list日線_折点.size()-1 )
			return CommonConst.如果_這是最後一次計算;

		// 手持高低点:假是低还高
		int 假点高低点=o計算目標.get假().get高低();//0=低 1=高
		// 要找高低点:求是低还高
		int 求高低点=o計算目標.get求().get高低();//0=低 1=高
		// 下一个简单安区间的高低点(求=高，看簡單區間的低點；求=低，看簡單區間的高點)
		int 碰見更高低點=判断是否更高低(o簡單解析2, o計算目標);


		//1=如果  手持低点，要找高点，但碰见一个更低的谷
		if(假点高低点==CommonConst.低点 && 求高低点==CommonConst.高点 && 碰見更高低點 == CommonConst.更低点) return CommonConst.如果_手持低点_要找高点_但碰见一个更低的谷;
		//2=如果  手持低点，要找高点，但没有碰见一个更低的谷
		if(假点高低点==CommonConst.低点 && 求高低点==CommonConst.高点 && 碰見更高低點 != CommonConst.更低点) return CommonConst.如果_手持低点_要找高点_但没有碰见一个更低的谷;
		//3=如果  手持高点，要找底点，但碰见一个更高的谷
		if(假点高低点==CommonConst.高点 && 求高低点==CommonConst.低点 && 碰見更高低點 == CommonConst.更高点) return CommonConst.如果_手持高点_要找底点_但碰见一个更高的谷;
		//4=如果  手持高点，要找底点，但没碰见一个更高的谷
		if(假点高低点==CommonConst.高点 && 求高低点==CommonConst.低点 && 碰見更高低點 != CommonConst.更高点) return CommonConst.如果_手持高点_要找底点_但没碰见一个更高的谷;

		if(是否到了最后(o計算目標, list日線_折点)) return CommonConst.如果_這是最後一次計算;

		return 0;//啥也不是
	}

	private int 判断是否更高低(簡單解析2 o簡單解析2, 計算目標 o計算目標) {
		int 碰見更高低點=CommonConst.未超想象; //0=更低 1=更高


		Float f簡單解析最低 = Float.parseFloat(o簡單解析2.get最低().get价格());
		Float f簡單解析最高 = Float.parseFloat(o簡單解析2.get最高().get价格());
		Float f現在假點的價格 = Float.parseFloat(o計算目標.get假().get价格());

		if(o計算目標.get求高低() == CommonConst.高点) {
			if(f簡單解析最低 < f現在假點的價格) {
				碰見更高低點=CommonConst.更低点;
			}
		}
		if(o計算目標.get求高低() == CommonConst.低点) {
			if(f簡單解析最高 > f現在假點的價格) {
				碰見更高低點=CommonConst.更高点;
			}
		}
		return 碰見更高低點;
	}

	private 簡單解析2 做成處理对象(計算目標 o計算目標, List<折点> list日線_折点, int 假点index, int 對象個數, int a模式取得新的区间) {
//		做成處理对象
//	     如果假点为空，
//	             就是全对象（日线，index，對象個數）
//	     如果假点不为空，
//	             就是假点以后的对象
//	                  （日线，假点index，
//	                     對象個數 - 假点index - index）
		
		int 處理個數 = 對象個數;

		簡單解析2 o簡單解析2 = new 簡單解析2();
		if(o計算目標.get假()==null) {
			o簡單解析2 = 簡單解析Util2.取得指定區間數據製作簡單解析(list日線_折点, 假点index, 對象個數);


		}

		if (o計算目標.get假() != null) {
			//int i假点index = 簡單解析Util.取得指定日期的index(list日線, o計算目標.get假().get日時());
			int i假点index = o計算目標.get假().getIndex();
			
			if( a模式取得新的区间 == CommonConst.A模式_取得新的区间) { // A模式：取得新的区间			
			
				if(i假点index + 1 + 對象個數 > list日線_折点.size()-1) {
					處理個數 = list日線_折点.size() -1 - i假点index;
				}
			
			}
			if( a模式取得新的区间 == CommonConst.B模式_有限区间内再找一点) { // B模式：有限区间内再找一点	
				if(i假点index + 1 + 對象個數 > list日線_折点.size()-1) {
					處理個數 = list日線_折点.size() -1  - i假点index;
				}else {
					處理個數 = 假点index + 對象個數 - i假点index;
				}
			}
			
			o簡單解析2 = 簡單解析Util2.取得指定區間數據製作簡單解析2(list日線_折点, i假点index, 處理個數);
		}
		
		
		return o簡單解析2;
	}
}
