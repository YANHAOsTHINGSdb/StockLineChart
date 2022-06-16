package ParseTool2;

import java.util.ArrayList;
import java.util.List;

import InputData.日線;
import InputData.簡單解析;
import InputData.計算目標;
import OutputData.折点;
import ParseTool.簡單解析Util;
import ParseTool.計算目標Util;
import ParseTool.輸出debug信息Util;
import common.CommonConst;

public class 輸出折線圖數據3 {

	public static void main(String[] args) {

		String[][] s =
			 {
				 {"20190327","11.11","11.08","11.04","11.24","42124489","469246336.00"},{"20190328","11.03","11.03","10.90","11.05","29296120","321585856.00"},{"20190329","10.98","11.28","10.98","11.30","60526266","678436544.00"},{"20190401","11.36","11.44","11.29","11.52","70637405","808657536.00"},{"20190402","11.50","11.44","11.41","11.52","46714710","534896800.00"},{"20190403","11.37","11.50","11.34","11.54","50271029","575799424.00"},{"20190404","11.55","11.71","11.54","11.71","75232527","876099520.00"},{"20190408","11.79","11.72","11.65","11.96","77870373","920513536.00"},{"20190409","11.72","11.54","11.49","11.75","56895992","660406208.00"},{"20190410","11.50","11.48","11.42","11.56","41027539","470666656.00"},{"20190411","11.47","11.47","11.35","11.59","50172794","575765376.00"},{"20190412","11.47","11.49","11.43","11.56","26273690","301752032.00"},{"20190415","11.67","11.47","11.46","11.77","70509167","823853440.00"},{"20190416","11.46","11.95","11.43","11.99","100665400","1188260096.00"},{"20190417","11.96","11.91","11.88","12.09","68157211","816127040.00"},{"20190418","11.91","11.91","11.84","12.05","43048980","513835264.00"},{"20190419","12.01","12.01","11.86","12.20","56013041","672739648.00"},{"20190422","12.02","11.71","11.68","12.07","53389418","631192384.00"},{"20190423","11.68","11.70","11.63","11.80","33847719","396659648.00"},{"20190424","11.76","11.62","11.51","11.77","38201108","444929312.00"},{"20190425","11.56","11.54","11.48","11.69","40876129","473973536.00"},{"20190426","11.43","11.32","11.28","11.56","42469581","485267264.00"},{"20190429","11.35","11.48","11.34","11.54","38586938","442046720.00"},
					 {"20190430","11.70","11.97","11.70","12.09","123474738","1466714752.00"},{"20190506","11.75","11.80","11.54","11.86","124545414","1460217088.00"},{"20190507","11.82","11.80","11.60","11.94","85489922","1010271104.00"},{"20190508","11.64","11.51","11.49","11.78","58500103","677487360.00"},{"20190509","11.48","11.12","11.10","11.56","64128049","722119104.00"},{"20190510","11.23","11.32","11.06","11.42","48550722","548884288.00"},{"20190513","11.20","11.31","11.15","11.40","40284963","455643072.00"},{"20190514","11.18","11.21","11.17","11.44","41888998","473151520.00"},{"20190515","11.28","11.32","11.23","11.42","34404465","389533440.00"},{"20190516","11.28","11.30","11.22","11.36","34141755","385015232.00"},{"20190517","11.32","11.24","11.20","11.35","38399831","433108032.00"},{"20190520","11.28","11.34","11.25","11.44","34904438","396448384.00"},{"20190521","11.33","11.32","11.31","11.45","32975873","374972608.00"},{"20190522","11.32","11.16","11.12","11.34","40000391","447828800.00"},{"20190523","11.12","11.10","10.95","11.15","36312689","401709184.00"},{"20190524","11.17","11.11","11.00","11.22","24160265","269312448.00"},{"20190527","11.09","11.22","10.96","11.26","35087915","390018816.00"},{"20190528","11.19","11.29","11.02","11.30","72278135","809741248.00"},{"20190529","11.17","11.12","11.07","11.29","40860970","455620576.00"},{"20190530","11.18","11.11","11.03","11.18","26650033","295267456.00"},{"20190531","11.11","11.13","11.05","11.23","36976728","412819776.00"},{"20190603","11.17","11.28","11.13","11.29","30492063","342326272.00"},{"20190604","11.29","11.35","11.26","11.37","25077393","283826816.00"},{"20190605","11.43","11.41","11.35","11.52","31423641","359479712.00"},{"20190606","11.51","11.47","11.38","11.51","26427215","303162720.00"},{"20190610","11.57","11.61","11.53","11.70","43183779","502599168.00"},{"20190611","11.35","11.42","11.27","11.45","52266217","594464064.00"},{"20190612","11.42","11.60","11.40","11.70","50635228","584680896.00"},{"20190613","11.57","11.70","11.50","11.79","46966016","548219968.00"},{"20190614","11.74","11.79","11.71","11.87","47385174","558641856.00"},{"20190617","11.78","11.77","11.75","11.92","35220103","416594816.00"},{"20190618","11.82","11.82","11.72","11.90","28965124","341904864.00"},{"20190619","12.04","11.88","11.81","12.07","44927745","537339840.00"},{"20190620","11.95","12.20","11.85","12.32","71647496","869024512.00"},{"20190621","12.18","12.09","12.03","12.30","55381180","670759360.00"},{"20190624","12.09","12.03","11.96","12.13","34195336","411172384.00"}				 }
			;
					 輸出折線圖數據3 o = new 輸出折線圖數據3();
				 
				 
		List<折点> l = o.輸出折線圖數據2(s, 3);
		l.size();
	}
	
	public static int 對象個數 = 0;
	public static int debugMode = CommonConst.本番mode; // 0:本番  1:debug

	public List<折点> 輸出折線圖數據2(String[][] arrayList日線, int 對象個數) {
		List<日線> list日線 = new ArrayList();
		for(String[] array日線 : arrayList日線){

			// 0:
			// 1:
			// 2:
			// 3:
			// 4:

			list日線.add(new 日線(
					array日線[CommonConst.日時],
					array日線[CommonConst.開盤價],
					array日線[CommonConst.收盤價],
					array日線[4],
					array日線[3]					
					));
		}


		計算目標 o計算目標 = new 計算目標();
		
		int index = 0 ;

		List<折点> list折点 = new ArrayList();
		
		輸出折線圖數據3.對象個數 = 對象個數;
		輸出折線圖數據3.debugMode =CommonConst.debugMode;

		輸出折線圖數據(o計算目標, list日線, index, 對象個數, list折点);

		return list折点;
	}
	
	計算目標Util 計算目標util =new 計算目標Util();

	public List<折点> 輸出折線圖數據(String[][] arrayList日線, int 對象個數) {
		List<日線> list日線 = new ArrayList();
		for(String[] array日線 : arrayList日線){

			// 0:
			// 1:
			// 2:
			// 3:
			// 4:

			list日線.add(new 日線(
					array日線[CommonConst.日時],
					array日線[CommonConst.開盤價],
					array日線[CommonConst.收盤價],
					array日線[CommonConst.最高價],
					array日線[CommonConst.最低價]
					));
		}


		計算目標 o計算目標 = new 計算目標();
		
		int index = 0 ;

		List<折点> list折点 = new ArrayList();

		輸出折線圖數據3.對象個數 = 對象個數;
				
		輸出折線圖數據(o計算目標, list日線, index, 對象個數, list折点);

		return list折点;
	}

	private void 輸出折線圖數據( 計算目標 o計算目標, List<日線> list日線,int 假点index, int 對象個數, List<折点> list折点) {
//		一个区间内（假点，日线，index，對象個數）
//	       假点以后：做成處理对象（）
//	       判断：處理对象
//	       處理（處理对象）：更新假点，追加折点
//	       是否到了最后：无處理对象：返回
//	       遞歸調用自己：（假点，日線，index，對象個數）

		
		簡單解析 o簡單解析 = 做成處理对象(o計算目標, list日線, 假点index, 對象個數, CommonConst.A模式_取得新的区间);
		輸出debug信息Util.print(list折点, o計算目標, list日線, 假点index, o簡單解析, "A");
		
		int iResult = 判断(o簡單解析, o計算目標, list日線, 假点index);
		
		if(iResult == CommonConst.如果_這是最後一次計算) {
			最后一次计算(o計算目標, o簡單解析, list折点);
			return;
		}
		

		簡單解析 o簡單解析2 = 處理(iResult, o簡單解析, o計算目標, list日線, list折点);
		輸出debug信息Util.print(list折点, o計算目標, list日線, 假点index, o簡單解析2, "A");
		
		if(是否到了最后(o計算目標, list日線)) {
			最后一次计算(o計算目標, o簡單解析, list折点);
			return;
		}
		
		// 如果还有余點，出于一个区间有两个点的考虑，再找一次
		if(o計算目標.get假().get日時() < o簡單解析.get結束().get日時()) {
			輸出折線圖數據_B(o計算目標, list日線, o計算目標.get假().getIndex(), 對象個數, list折点);
		}

		//index = 簡單解析Util.取得指定日期的index(list日線, o計算目標.get假().get日時());
		假点index =  o計算目標.get假().getIndex();
		//index++;

		if(假点index == 19 ) {
			假点index = 19;
		}
		
//		if(最后一次计算(list日線, index)) {
//			return;
//		}
		
		輸出折線圖數據(o計算目標, list日線, 假点index, 對象個數,list折点);

	}
	
	
	
	private boolean 最后一次计算(List<日線> list日線, int index) {
		if(index == list日線.size()-1 ) {
			return true;
		}
		return false;
	}

	private void 輸出折線圖數據_B( 計算目標 o計算目標, List<日線> list日線,int 假点index, int 對象個數, List<折点> list折点) {		

		簡單解析 o簡單解析 = 做成處理对象(o計算目標, list日線, 假点index, 對象個數, CommonConst.B模式_有限区间内再找一点);

		//簡單解析 o簡單解析 = new 簡單解析(簡單解析Util.取得指定日的前后指定天数的簡單解析(list日線, 假点index, 對象個數, o計算目標.get求高低()));
		
		輸出debug信息Util.print(list折点, o計算目標, list日線, 假点index, o簡單解析, "B");
		int iResult = 判断(o簡單解析, o計算目標, list日線, 假点index);
		
		if(iResult == CommonConst.如果_這是最後一次計算) {
			最后一次计算(o計算目標, o簡單解析, list折点);
			return;
		}
		

		簡單解析 o簡單解析2 = 處理(iResult, o簡單解析, o計算目標, list日線, list折点);
		
		輸出debug信息Util.print(list折点, o計算目標, list日線, 假点index, o簡單解析2, "B");

	}

	private void 最后一次计算(計算目標 o計算目標, 簡單解析 o簡單解析, List<折点> 折点list) {
		// 假点是否为日线的最后一个
		// 假点变确点
		計算目標util.追加假点(o計算目標, o簡單解析, 折点list);		
		
	}

	private boolean 是否到了最后(計算目標 o計算目標, List<日線> list日線) {
//		是否到了最后：
//	      假点是否为日线的最后一个

		int i最后一天日时 = Integer.parseInt(list日線.get(list日線.size()-1).get日時());

		if(i最后一天日时 == o計算目標.get假().get日時()) {
			return true;
		}
		return false;
	}

	private 簡單解析 處理(int iResult, 簡單解析 簡單解析對象, 計算目標 o計算目標, List<日線> list日線, List<折点> 折点list) {

		簡單解析 O處理對象 = 簡單解析對象;
		// 新假点的前2天，后2天再确认
		// 重新取得指定日的前后指定天数的最大最小值（簡單解析對象）
		if(iResult !=  CommonConst.如果_這是第一次計算 &&  簡單解析對象.getList指定数据().size() > 1 ) {
			if(o計算目標.get确().get日時() >= 20190530) {
				iResult = iResult;
			}
			int index假点 = o計算目標.get假().getIndex();
			O處理對象 = new 簡單解析(簡單解析Util.取得指定日的前后指定天数的簡單解析(list日線, index假点, 輸出折線圖數據3.對象個數, o計算目標.get求高低()));
			
			
			//  判斷2是否是周圍的極限點(int iResult, 簡單解析 o處理對象, 計算目標 o計算目標, List<日線> list日線, int 假index) 
			
			// 再算一次
			int inewResult = 判斷2是否是周圍的極限點(iResult, O處理對象, o計算目標, list日線, index假点);
			
			if(inewResult != iResult) {
				iResult = inewResult;
			}

		}

		switch (iResult) {

		case CommonConst.如果_手持低点_要找高点_但碰见一个更低的谷:
			//1=如果  手持低点，要找高点，但碰见一个更低的谷
			// 更新假点
			計算目標util.更新假点(o計算目標, O處理對象, 折点list);
			break;

		case CommonConst.如果_手持低点_要找高点_但没有碰见一个更低的谷:
			//2=如果  手持低点，要找高点，但没有碰见一个更低的谷
			// 如果 碰見高點
			// 就，固定低点，假設高點，尋找下一個低點
			// 假点是否在簡單解析的对象中

			計算目標util.追加假点(o計算目標, O處理對象, 折点list);
			break;

		case CommonConst.如果_手持高点_要找底点_但碰见一个更高的谷:
			//3=如果  手持高点，要找底点，但碰见一个更高的谷
			// 更新假点
			計算目標util.更新假点(o計算目標, O處理對象, 折点list);
			break;

		case CommonConst.如果_手持高点_要找底点_但没碰见一个更高的谷:
			//4=如果  手持高点，要找底点，但没碰见一个更高的谷
			// 如果  碰見低點
			// 就，固定高点，假設低點，尋找下一個高點

			計算目標util.追加假点(o計算目標, O處理對象, 折点list);
			break;

		case CommonConst.如果_這是第一次計算:
			//5=如果  這是第一次計算（折点list為空）
			計算目標util.第一次计算(o計算目標, 簡單解析對象, 折点list);
			break;

		case CommonConst.如果_這是最後一次計算:
			//6=如果  這是最後一次計算（簡單解析结果的最后一条 ）
			計算目標util.最后一次计算(o計算目標, O處理對象, 折点list);
			break;
		}
		
		return O處理對象;

	}

	private boolean 判斷2是否是周圍的極限點(int iResult, 計算目標 o計算目標, List<日線> list日線, 簡單解析 o處理對象) {
		// 如果 两次判断的结果不一样，
		// 将下一个影响你的最高点 找到
		// 看看它是否是周围的一个极限点 ●
		// 如果是，就将其设置为新的假点
		
		int index =0;
		
		if(o計算目標.get假().get高低() == CommonConst.高点) {
			index = o處理對象.get最高().getIndex();
		}else {
			index = o處理對象.get最低().getIndex();
		}
			
		簡單解析 O處理對象 = 簡單解析Util.取得指定日的前后指定天数的簡單解析2(list日線, index, 輸出折線圖數據3.對象個數, o計算目標.get假().get高低());
		
		if(o計算目標.get假().get高低() == CommonConst.高点) {
			if(O處理對象.get最高().getIndex() != index) {
				return false; // 不是最高
			}else {
				return true; // 是最高
			}			

		}else {
			if(O處理對象.get最低().getIndex() != index) {
				return false;// 不是最低
			}else {
				return  true;// 是最低
			}
		}
	}

	int  判斷2是否是周圍的極限點(int i前次判断结果, 簡單解析 o處理對象, 計算目標 o計算目標, List<日線> list日線, int 假index) {

		// iResult   iResult2
		//   1          2       中間存在一個反向高點
		//   3          4       中間存在一個反向低點
		//   2          1       存在更合适的高点
		//   4          3       存在更格式的低点		
		
		int i是否存在更合適的點 = 判斷_是否存在更合適的點( i前次判断结果,  o處理對象,  o計算目標, list日線,  假index);
		
		if(i是否存在更合適的點 == i前次判断结果) {
			return i前次判断结果;
		}
		
		
		// iResult为2和4的时候，判断一下更合适的点是否满足需求：周围极致点
		boolean b是否極限點 = 判斷2是否是周圍的極限點(i前次判断结果, o計算目標, list日線, o處理對象);
		
		
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

	
	int  判斷_是否存在更合適的點(int iResult, 簡單解析 o處理對象, 計算目標 o計算目標, List<日線> list日線, int 假index) {
		// 如果 两次判断的结果不一样， ●
		// 将下一个影响你的最高点 找到
		// 看看它是否是周围的一个极限点
		// 如果是，就将其设置为新的假点
	
		boolean b比較結果 = false;
		float f假 = Float.parseFloat(  o計算目標.get假().get价格());
		float f最低_處理對象 = Float.parseFloat(  o處理對象.get最低().get价格());
		float f最高_處理對象 = Float.parseFloat(  o處理對象.get最高().get价格());
		
		switch (iResult) {
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
			
			if(o處理對象.get最低().getIndex() <= o處理對象.get最高().getIndex()) {
				int i寬度 = o處理對象.get最高().getIndex() - 假index + 1;
			
				
				
				float f落差_最高_最低 = f最高_處理對象 - f最低_處理對象;
				float f落差_假_最低 = f假 - f最低_處理對象;
				float f落差_假_确   = f假 - Float.parseFloat(o計算目標.get确().get价格());
				
				//且高低谷的寬度不小於 1.5倍對象個數
				//且高低谷的落差不小於 確與假的0.75 高度
				if(f落差_最高_最低 >= f落差_假_确 * 0.75 && f落差_假_最低 > f落差_假_确 * 0.75) {
					
					return CommonConst.如果_手持高点_要找底点_但没碰见一个更高的谷;
				}
			}
			
			return iResult;
					
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
			
			if(o處理對象.get最高().getIndex() <= o處理對象.get最低().getIndex()) {
				int i寬度 = o處理對象.get最低().getIndex() - 假index + 1;
			
				float f落差_最高_最低 = f最高_處理對象 - f最低_處理對象;
				float f落差_假_确 =   Float.parseFloat(o計算目標.get确().get价格()) - f假;
				float f落差_假_最高 = f最高_處理對象 - f假;
				
				//且高低谷的寬度不小於 1.5倍對象個數
				//且高低谷的落差不小於 確與假的0.75 高度
				if(f落差_最高_最低 >= f落差_假_确 * 0.75 && f落差_假_最高 > f落差_假_确 * 0.75) {
					
					return CommonConst.如果_手持低点_要找高点_但没有碰见一个更低的谷;
				}
			}
			
			return iResult;
			
		//case CommonConst.如果_手持低点_要找高点_但碰见一个更低的谷:
		case CommonConst.如果_手持低点_要找高点_但没有碰见一个更低的谷:
			//    .
			//      .       |判断范围 ・     |追加范围
			//        ・    |        ・      |
			//          ・ ←低    ・        |
			//              |・  ・          |
			//              |  ・ ←更低的谷 |
			
			float f最低 = Float.parseFloat( o處理對象.get最低().get价格());
			
			b比較結果 = o處理對象.get最低().getIndex() != 假index && f最低 < f假;
			
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
			
			float f最高 = Float.parseFloat( o處理對象.get最高().get价格());
			
			b比較結果 = o處理對象.get最高().getIndex() != 假index && f最高 > f假;
			
			if(b比較結果) {
				return CommonConst.如果_手持高点_要找底点_但碰见一个更高的谷;
			}else {
				return CommonConst.如果_手持高点_要找底点_但没碰见一个更高的谷;
			}
		}
		return iResult;
		
	}
	
	private int 判断(簡單解析 o簡單解析, 計算目標 o計算目標, List<日線> list日線, int index) {

//		判断：
//	      假点为空：第一次：追加确点，追加假点
//	      假点为高，求低，碰见更高：更新假点_高
//	      假点为高，求低，未碰见更高：追加新假点_高
//	      假点为低，求高，碰见更低：更新假点_低
//	      假点为低，求高，未碰见更低：追加新假点_低

		//5=如果  这是第一次计算（折点list為空 ）
		if(o計算目標.get假()==null)return CommonConst.如果_這是第一次計算;
		if(index >= list日線.size()-1 )
			return CommonConst.如果_這是最後一次計算;

		// 手持高低点:假是低还高
		int 假点高低点=o計算目標.get假().get高低();//0=低 1=高
		// 要找高低点:求是低还高
		int 求高低点=o計算目標.get求().get高低();//0=低 1=高
		// 下一个简单安区间的高低点(求=高，看簡單區間的低點；求=低，看簡單區間的高點)
		int 碰見更高低點=判断是否更高低(o簡單解析, o計算目標);


		//1=如果  手持低点，要找高点，但碰见一个更低的谷
		if(假点高低点==CommonConst.低点 && 求高低点==CommonConst.高点 && 碰見更高低點 == CommonConst.更低点) return CommonConst.如果_手持低点_要找高点_但碰见一个更低的谷;
		//2=如果  手持低点，要找高点，但没有碰见一个更低的谷
		if(假点高低点==CommonConst.低点 && 求高低点==CommonConst.高点 && 碰見更高低點 != CommonConst.更低点) return CommonConst.如果_手持低点_要找高点_但没有碰见一个更低的谷;
		//3=如果  手持高点，要找底点，但碰见一个更高的谷
		if(假点高低点==CommonConst.高点 && 求高低点==CommonConst.低点 && 碰見更高低點 == CommonConst.更高点) return CommonConst.如果_手持高点_要找底点_但碰见一个更高的谷;
		//4=如果  手持高点，要找底点，但没碰见一个更高的谷
		if(假点高低点==CommonConst.高点 && 求高低点==CommonConst.低点 && 碰見更高低點 != CommonConst.更高点) return CommonConst.如果_手持高点_要找底点_但没碰见一个更高的谷;

		if(是否到了最后(o計算目標, list日線)) return CommonConst.如果_這是最後一次計算;

		return 0;//啥也不是
	}

	private int 判断是否更高低(簡單解析 o簡單解析, 計算目標 o計算目標) {
		int 碰見更高低點=CommonConst.未超想象; //0=更低 1=更高


		Float f簡單解析最低 = Float.parseFloat(o簡單解析.get最低().get价格());
		Float f簡單解析最高 = Float.parseFloat(o簡單解析.get最高().get价格());
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

	private 簡單解析 做成處理对象(計算目標 o計算目標, List<日線> list日線, int index, int 對象個數, int iType) {
//		做成處理对象
//	     如果假点为空，
//	             就是全对象（日线，index，對象個數）
//	     如果假点不为空，
//	             就是假点以后的对象
//	                  （日线，假点index，
//	                     對象個數 - 假点index - index）
		
		int 處理個數 = 對象個數;

		簡單解析 o簡單解析 = new 簡單解析();
		if(o計算目標.get假()==null) {
			o簡單解析 = 簡單解析Util.取得指定區間數據製作簡單解析(list日線,index, 對象個數);


		}

		if (o計算目標.get假() != null) {
			//int i假点index = 簡單解析Util.取得指定日期的index(list日線, o計算目標.get假().get日時());
			int i假点index = o計算目標.get假().getIndex();
			
			if( iType == CommonConst.A模式_取得新的区间) { // A模式：取得新的区间			
			
				if(i假点index + 1 + 對象個數 > list日線.size()-1) {
					處理個數 = list日線.size() -1 - i假点index;
				}
			
			}
			if( iType == CommonConst.B模式_有限区间内再找一点) { // B模式：有限区间内再找一点	
				if(i假点index + 1 + 對象個數 > list日線.size()-1) {
					處理個數 = list日線.size() -1  - i假点index;
				}else {
					處理個數 = index + 對象個數 - i假点index -1;
				}
			}
			
			o簡單解析 = 簡單解析Util.取得指定區間數據製作簡單解析2(list日線, i假点index, 處理個數);
		}
		
		
		return o簡單解析;
	}

	/*
一个区间内只有一个高低点

除非是单一属性：直下。直上。否则必有波动

问题在于：结合点的處理：只處理假点以后未识别的数据
理由：一个假点只代表一个高或低点。另一个点不应该被漏掉。


一个区间内（假点，日线，index，對象個數）
       假点以后：做成處理对象（）
       判断：處理对象
       處理（處理对象）：更新假点，追加折点
       是否到了最后：无處理对象：返回
       递归调用自己：（假点，日线，index，對象個數）

做成處理对象
     如果假点为空，
             就是全对象（日线，index，對象個數）
     如果假点不为空，
             就是假点以后的对象
                  （日线，假点index，
                     對象個數 - 假点index - index）

判断：
      假点为空：第一次：追加确点，追加假点
      假点为高，求低，碰见更高：更新假点_高
      假点为高，求低，未碰见更高：追加新假点_高
      假点为低，求高，碰见更低：更新假点_低
      假点为低，求高，未碰见更低：追加新假点_低


是否到了最后：
      假点是否为日线的最后一个


處理：
      更新假点_高：
              新假点为属性相同的最大点（處理对象内）
              假点向后推移。不增加折点

      追加新假点_高：增加新折点
      更新假点_低：新假点为更低。
      追加新假点_低：
              新假点为属性相反的最大点（處理对象内）

	 */
}
