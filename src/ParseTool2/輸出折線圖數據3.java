package ParseTool2;

import java.util.ArrayList;
import java.util.List;

import InputData.日線;
import InputData.簡單解析;
import InputData.計算目標;
import OutputData.折点;
import ParseTool.簡單解析Util;
import ParseTool.計算目標Util;
import common.CommonConst;

public class 輸出折線圖數據3 {

	public static void main(String[] args) {
		String[][] s =
			 {
				 {"20191219","12.40","12.41","12.38","12.50","23789907","295686656.00"},
				 {"20191220","12.41","12.42","12.38","12.55","40150148","500592352.00"},
				 {"20191223","12.46","12.20","12.17","12.46","37033891","455979040.00"},
				 {"20191224","12.21","12.28","12.20","12.29","21671029","265496464.00"},
				 {"20191225","12.29","12.24","12.20","12.29","13678175","167407904.00"},
				 {"20191226","12.26","12.29","12.23","12.32","15739054","193083040.00"},
				 {"20191227","12.25","12.32","12.25","12.43","27932109","344832512.00"},
				 {"20191230","12.27","12.34","12.12","12.36","41051555","503090496.00"},
				 {"20191231","12.32","12.37","12.21","12.38","31953628","392736224.00"},
				 {"20200102","12.47","12.47","12.45","12.64","51629079","647446144.00"},
				 {"20200103","12.57","12.60","12.47","12.63","38018810","477053344.00"},
				 {"20200106","12.52","12.46","12.42","12.65","41001193","514432544.00"},
				 {"20200107","12.51","12.50","12.46","12.60","28421482","355811744.00"},
				 {"20200108","12.41","12.32","12.25","12.45","35240536","434980256.00"},
				 {"20200109","12.39","12.37","12.35","12.43","26151448","324168064.00"},
				 {"20200110","12.37","12.39","12.31","12.42","18321252","226580304.00"},
				 {"20200113","12.40","12.41","12.31","12.41","20715566","255982384.00"},
				 {"20200114","12.40","12.43","12.39","12.69","29994561","374971648.00"},
				 {"20200115","12.41","12.25","12.25","12.45","31897217","392531136.00"},
				 {"20200116","12.28","12.20","12.16","12.31","22454876","274130144.00"}
			};
		輸出折線圖數據3 o = new 輸出折線圖數據3();
		List<折点> l = o.輸出折線圖數據(s,3);
		l.size();
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

		int iResult = 判断(o簡單解析, o計算目標, list日線, 假点index);
		
		if(iResult == CommonConst.如果_這是最後一次計算) {
			最后一次计算(o計算目標, o簡單解析, list折点);
			return;
		}
		
		處理(iResult, o簡單解析, o計算目標, list日線, list折点);
		
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

	private void 輸出折線圖數據_B( 計算目標 o計算目標, List<日線> list日線,int index, int 對象個數, List<折点> list折点) {		

		簡單解析 o簡單解析 = 做成處理对象(o計算目標, list日線, index, 對象個數, CommonConst.B模式_有限区间内再找一点);

		int iResult = 判断(o簡單解析, o計算目標, list日線, index);
		
		if(iResult == CommonConst.如果_這是最後一次計算) {
			最后一次计算(o計算目標, o簡單解析, list折点);
			return;
		}
		
		處理(iResult, o簡單解析, o計算目標, list日線, list折点);

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

	private void 處理(int iResult, 簡單解析 簡單解析對象, 計算目標 o計算目標, List<日線> list日線, List<折点> 折点list) {

		簡單解析 O處理對象 = new 簡單解析(簡單解析對象);
		// 新假点的前2天，后2天再确认
		// 重新取得指定日的前后指定天数的最大最小值（簡單解析對象）
		if(iResult !=  CommonConst.如果_這是第一次計算 &&  簡單解析對象.getList指定数据().size() > 1 ) {
			int index假点 = o計算目標.get假().getIndex();
			O處理對象 = new 簡單解析(簡單解析Util.取得指定日的前后指定天数的簡單解析(list日線, index假点, 簡單解析對象.getList指定数据().size(), o計算目標.get求高低()));
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
