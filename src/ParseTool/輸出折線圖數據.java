package ParseTool;

import java.util.ArrayList;
import java.util.List;

import InputData.日線;
import InputData.簡單解析;
import InputData.計算目標;
import OutputData.折点;
import common.CommonConst;

public class 輸出折線圖數據 {
	
	
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
		輸出折線圖數據 o = new 輸出折線圖數據();
		List<折点> l = o.輸出折線圖數據(s);
		l.size();
	}
	

	計算目標Util 計算目標util =new 計算目標Util();
	/*
	輸出折線圖數據
		入口  【日線List】
		出口  【簡單解析List】								折点（日期，位置（SEHL），价格）
		處理內容
			先来个【簡單解析】
				入口  【日線List】【指定日線数】
				出口  【簡單解析List】
				處理內容

			初始化【計算目標】
				出口  【計算目標】

			再調用輸出折點list
				入力  【簡單解析List】【計算目標】=null 【折点list】=null
				出口  【折点list】
				處理內容

	 */
	
	public List<折点> 輸出折線圖數據(String[][] arrayList日線) {
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
		return 輸出折線圖數據(list日線);
	}
	
	private List<折点> 輸出折線圖數據(List<日線> list日線) {
		List<折点> 折点list = new ArrayList();

		List<簡單解析> 簡單解析List = 簡單解析Util.取得簡單解析對象數據(list日線, CommonConst.指定日線数);
		計算目標Util util = new 計算目標Util();
		計算目標 o計算目標 = util.初始化(簡單解析List.get(0),  折点list);

		List<折点> 折点List = 輸出折點list(簡單解析List, o計算目標,  折点list, list日線);
		return 折点List;

	}

	private List<折点> 輸出折點list(List<簡單解析> 簡單解析List, 計算目標 o計算目標, List<折点> 折点list, List<日線> list日線) {
		//List<折点> 折点list = new ArrayList();

		//逐次解析每个簡單解析的节点
		int index = 0;
		for(簡單解析 o簡單解析 : 簡單解析List) {
 
			輸出折點list(index, o計算目標, 簡單解析List, 折点list, list日線);
			
			index ++;
		}
		return 折点list;
	}

	private void 輸出折點list(int index, 計算目標 o計算目標, List<簡單解析> 簡單解析List, List<折点> 折点list, List<日線> list日線) {

		boolean is是否最后的簡單解析 = 簡單解析List.size()==index+1?true:false;
		// 返回要解析的状态

		簡單解析 簡單解析對象 =簡單解析List.get(index);
		
		switch(解析当前状态(o計算目標, 簡單解析對象,折点list,is是否最后的簡單解析)) {
		
		case CommonConst.如果_手持低点_要找高点_但碰见一个更低的谷:
		//1=如果  手持低点，要找高点，但碰见一个更低的谷
			// 更新假点
			計算目標util.更新假点(o計算目標, 簡單解析對象, 折点list);break;

		case CommonConst.如果_手持低点_要找高点_但没有碰见一个更低的谷:
		//2=如果  手持低点，要找高点，但没有碰见一个更低的谷
			// 如果 碰見高點
			// 就，固定低点，假設高點，尋找下一個低點
			// 假点是否在簡單解析的对象中
			
			//補丁 假点是否在簡單解析的对象中的处理
			boolean b補丁 = is假点是否在簡單解析的对象中( o計算目標,   簡單解析對象);
			if(b補丁 == true) {
				追加假點_針對假點以後的數據(o計算目標, 簡單解析對象, 折点list, list日線);
				break;
			}
			
			計算目標util.追加假点(o計算目標, 簡單解析對象, 折点list);break;

		case CommonConst.如果_手持高点_要找底点_但碰见一个更高的谷:
		//3=如果  手持高点，要找底点，但碰见一个更高的谷
			// 更新假点
			計算目標util.更新假点(o計算目標, 簡單解析對象, 折点list);break;

		case CommonConst.如果_手持高点_要找底点_但没碰见一个更高的谷:
		//4=如果  手持高点，要找底点，但没碰见一个更高的谷
			// 如果  碰見低點
			// 就，固定高点，假設低點，尋找下一個高點
			//補丁 假点是否在簡單解析的对象中的处理
			b補丁 = is假点是否在簡單解析的对象中( o計算目標,   簡單解析對象);
			if(b補丁 == true) {
				追加假點_針對假點以後的數據(o計算目標, 簡單解析對象, 折点list, list日線);
				break;
			}
			
			計算目標util.追加假点(o計算目標, 簡單解析對象, 折点list);break;

		case CommonConst.如果_這是第一次計算:
		//5=如果  這是第一次計算（折点list為空）
			計算目標util.第一次计算(o計算目標, 簡單解析對象, 折点list);break;

		case CommonConst.如果_這是最後一次計算:
		//6=如果  這是最後一次計算（簡單解析结果的最后一条 ）
			計算目標util.最后一次计算(o計算目標, 簡單解析對象, 折点list);break;
		}
	}

	private 計算目標 追加假點_針對假點以後的數據(計算目標 o計算目標, 簡單解析 簡單解析對象, List<折点> 折点list, List<日線> list日線) {
		/*	
		1，假点是否在簡單解析的对象中的处理
			1、求的是高
	  			高于现在的假点
	  			大于现在的日期
	  		2、求的是低
	  			低于现在的假点
	  			大于现在的日期

		*/
		// 重新计算高低点
		簡單解析 o重新計算後簡單解析 = 簡單解析Util.排除指定日时之前的数据(list日線, 簡單解析對象, o計算目標.get假().get日時());
		
		return 計算目標util.追加假点(o計算目標, o重新計算後簡單解析, 折点list);
	}

	private boolean is假点是否在簡單解析的对象中(計算目標 o計算目標, 簡單解析 簡單解析對象) {
		if (o計算目標.get假().get日時() < 簡單解析對象.get結束().get日時())
			return true;
		
		return false;
	}
	
	private int 解析当前状态(計算目標 o計算目標, 簡單解析 o簡單解析, List<折点> 折点list, boolean is是否最后的簡單解析) {

		// 6=如果  這是最後一次計算（簡單解析结果的最后一条 ）
		if(is是否最后的簡單解析) return CommonConst.如果_這是最後一次計算;
		
		// 已確定的點
		
		
		// 計算的目標的點

		
		if(o簡單解析.get开始().get日時() == 20191220) {
			is是否最后的簡單解析 =false;
		}		
		
		// 計算的目標一定不能包含已確定的點
//		if(o簡單解析.get开始().get日時() <= o計算目標.get假().get日時()) {
//			return 0;//啥也不是
//		}
		
		// 手持高低点:假是低还高
		int 手持高低点=o計算目標.get假().get高低();//0=低 1=高
		// 要找高低点:求是低还高
		int 要找高低点=o計算目標.get求().get高低();//0=低 1=高
		
		
		
		
		
		// 下一个简单安区间的高低点(求=高，看簡單區間的低點；求=低，看簡單區間的高點)
		int 碰見更高低點=判断是都更高低(o簡單解析, o計算目標);


		//1=如果  手持低点，要找高点，但碰见一个更低的谷
		if(手持高低点==CommonConst.低点 && 要找高低点==CommonConst.高点 && 碰見更高低點 == CommonConst.更低点) return CommonConst.如果_手持低点_要找高点_但碰见一个更低的谷;
		//2=如果  手持低点，要找高点，但没有碰见一个更低的谷
		if(手持高低点==CommonConst.低点 && 要找高低点==CommonConst.高点 && 碰見更高低點 != CommonConst.更低点) return CommonConst.如果_手持低点_要找高点_但没有碰见一个更低的谷;
		//3=如果  手持高点，要找底点，但碰见一个更高的谷
		if(手持高低点==CommonConst.高点 && 要找高低点==CommonConst.低点 && 碰見更高低點 == CommonConst.更高点) {
//			
//			boolean is之前是否存在求高低点 = false;
//			
//			if(o簡單解析.get最低().get日時() < o簡單解析.get最高().get日時()) {
//				is之前是否存在求高低点 = true;
//			}else {
//				is之前是否存在求高低点 = false;
//			}
			
			return CommonConst.如果_手持高点_要找底点_但碰见一个更高的谷;
		}
		//4=如果  手持高点，要找底点，但没碰见一个更高的谷
		if(手持高低点==CommonConst.高点 && 要找高低点==CommonConst.低点 && 碰見更高低點 != CommonConst.更高点) return CommonConst.如果_手持高点_要找底点_但没碰见一个更高的谷;
		//5=如果  这是第一次计算（折点list為空 ）
		if(折点list.isEmpty())return CommonConst.如果_這是最後一次計算;


		return 0;//啥也不是
	}

	private int 判断是都更高低(簡單解析 o簡單解析, 計算目標 o計算目標) {
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



//		簡單解析 ＝ 【簡單解析List】的开始点
//		p12 =【計算目標】．假
//		p13 =【計算目標】．求							有明确的高低，但无价格
//		p14 = 新
//
//
//		如果  手持低点，要找高点，但碰见一个更低的谷														（【計算目標】．求高低 = 高  and   簡單解析。最低 小于 p12。价格）
//
//				p12 = 【簡單解析。最低】
//
//		如果  手持低点，要找高点，但没有碰见一个更低的谷
//				如果 碰见高点
//					就，固定低点，假设高点，寻找下一个低点
//						固定低点（p12 .状态 = 确，追加确定折点：折点list。追加（p12））
//						假设高点（p13 .状态 = 假  p13 .日期 = yymmdd  p13 .位置 = H   p13 .价格 = H）
//						寻找下一个低点（新增折点p14，p14 .状态 = 求    p14 .高低 = 底）
//
//		如果  手持高点，要找底点，但碰见一个更高的谷														（【計算目標】．求高低 = 底  and   簡單解析。最高   大于  p12。价格）
//
//				p12 = 【簡單解析。最高】
//
//		如果  手持高点，要找底点，但没碰见一个更高的谷														（【計算目標】．求高低 = 底  and   簡單解析。最高   大于 【計算目標。假定价格】）
//				如果 碰见低点
//					就，固定高点，假设低点，寻找下一个高点
//						固定低点（p12 .状态 = 确，追加确定折点：折点list。追加（p12））
//						假设高点（p13 .状态 = 假  p13 .日期 = yymmdd  p13 .位置 = H   p13 .价格 = H）
//						寻找下一个低点（新增折点p14，p14 .状态 = 求    p14 .高低 = 底）
//
//		如果	这是第一次计算					（折点list为空 ）
//				初始化【計算目標】
//					设定初始点
//						p1 .状态=确
//						p1 .日期 = yymmdd
//						p1 .位置 = S
//						p1 .格 = 价格
//						p1 .高低 = 高-低
//
//					设定假设点
//						p2 .状态=假							说明：p2是第一个碰到的【极致】点（高或低）就看哪个先出现
//						p2 .日期 = yymmdd
//						p2 .位置 = S
//						p2 .格 = 价格
//						p2 .高低 = 高-低
//
//					设定需求点
//						p3 .状态=求
//						p3 .日期 = 未知
//						p3 .位置 = 未知
//						p3 .格 = 未知
//						p3 .高低 = 高-低
//
//				【計算目標】。设置【确】信息
//				【計算目標】。设置【假】信息
//						根据【确】信息设置需求信息（尚不知道【假设】信息，只能利用【确】信息取得、）
//						设置		求高低
//								确定高低
//								确定价格
//				【計算目標】。设置【求】信息
//				【計算目標】。设置求高低
//
//				新增折点p1（追加确定折点：折点list。追加（p1））
//
//		如果		這是最後一次計算					（簡單解析结果的最后一条 ）
//			求高
//				最后一点  小于 假的值
//					假的点 = 最后一点（日期、价格，位置，高低=低）
//					假的点确定，追加折点
//				最后一点  大于 假的点
//					假的点确定，追加折点
//					求的点 = 最后一点（日期、价格，位置，高低=高），追加折点
//
//			求低
//				最后一点  小于 假的值
//					假的点确定，追加折点
//					求的点 = 最后一点（日期、价格，位置，高低=低），追加折点
//
//				最后一点  大于 假的点
//					假的点 = 最后一点（日期、价格，位置，高低=高）
//					假的点确定，追加折点

}