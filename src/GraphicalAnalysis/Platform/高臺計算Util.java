package GraphicalAnalysis.Platform;

import java.util.ArrayList;
import java.util.List;

import com.feilong.core.util.SortUtil;

import InputData.日線;
import OutputData.圖形;
import OutputData.平台;
import OutputData.折点;
import ParseTool2.平台Util2;
import ParseTool2.簡單解析Util2;
import common.CommonConst;

public class 高臺計算Util {

	public List<平台> 解析出高低臺信息(List<折点> 折点list1, List<折点> 折点list2, List<折点> 折点list3, List<日線> 日線list) {

		List<平台> 平台list = new ArrayList();
		List<折点> 折点list3高點 = 平台Util2.取得指定list的高點list(折点list3);
		List<折点> 折点list3低點 = 平台Util2.取得指定list的低點list(折点list3);
		List<Integer> 条件结果list3 = new ArrayList();
		//-----------------------------------------------
		// 从折点list3 取得所有高点

		// 循環處理每一個高點.

		//     取得折點list2裏該點相鄰左右兩個高點

		//     条件A：上記3个折點至少有2个高点在list1裏也是相邻的（最多2個高点间隔以內）

		//     条件B：上記折點的日期间隔不超過10個單位（暫定）

		//     条件C：判断上记两个高点是不是在对方90%-110%之間

		//     如果条件AB与C同時滿足

		//    上記兩個高點就是一個平臺

		// 追加 到平台list，属性为【高台】
		//-----------------------------------------------


		//-----------------------------------------------
		// 从折点list3 取得所有低点
		// 循環處理每一個低點.
		//	     取得折點list2裏該點相鄰左右兩個低點
		//	     条件A：上記3个折點至少有2个高点在list1裏也是相邻的（最多2個高点间隔以內）
		//	     条件B：上記折點的日期间隔不超過10個單位（暫定）
		//	     条件C：判断上记两个低点是不是在对方90%-110%之間
		//	     如果条件A与B同時滿足
		//	    上記兩個低點就是一個平臺
		// 追加 到平台list，属性为【低台】
		//-----------------------------------------------

		// 从折点list3 取得所有高点
//		for(折点 z : 折点list3) {
//			if(z.get高低() == CommonConst.高点) {
//				折点list3高點.add(z);
//			}
//		}

		for(折点 z : 折点list3高點) {

			// 取得折點list2裏該點相鄰左右兩個高點
			int zIndex = 簡單解析Util2.取得指定日期的index(折点list1, z.get日時());
			if(zIndex ==0) {
				continue;
			}
			if((zIndex+2) >= 折点list1.size()) {
				//已經那麽有搞掂了就退一個，保持整体计算的完整性
				zIndex=zIndex-2;
			}
			折点 left = 折点list1.get(zIndex-2);
			折点 mid = 折点list1.get(zIndex);
			折点 right = 折点list1.get(zIndex+2);
			条件结果list3 = 解析出高臺信息_条件结果(left, mid, right, 折点list1, 日線list);


			if (is条件结果判定_条件结果_滿足(条件结果list3)) {
				// 如果条件AB与C同時滿足
				// 上記兩個高點就是一個平臺
				平台 p = 設置平臺信息(left, mid, right, 条件结果list3, 折点list1, 折点list3);
				平台list.add(p);
			}

		}

//		// 从折点list3 取得所有低点
//		for(折点 z : 折点list3) {
//			if(z.get高低() == CommonConst.低点) {
//				折点list3低點.add(z);
//			}
//		}
//		for(折点 z : 折点list3低點) {
//			// 取得折點list2裏該點相鄰左右兩個高點
//			折点 left = 折点list2.get(z.getIndex()-2);
//			折点 mid = 折点list2.get(z.getIndex());
//			折点 right = 折点list2.get(z.getIndex()+2);
//			条件结果list3 = 解析出低臺信息_条件结果(left, mid, right, 折点list1);
//
//
//		}

		return 平台list;

	}

	private List<Integer> 解析出低臺信息_条件结果(折点 left, 折点 mid, 折点 right, List<折点> 折点list1, List<日線> 日線list) {

		return 解析出高臺信息_条件结果(left, mid, right, 折点list1, 日線list);
	}

	private 平台 設置平臺信息(折点 left, 折点 mid, 折点 right, List<Integer> 条件结果list3, List<折点> 折点list1, List<折点> 折点list3) {
		平台 p = new 平台();
		List<折点> 平台_折点list = new ArrayList();

		// 条件结果1 0：left與mid相鄰  1：mid與right相鄰  2：前面两个都成立  9：全不滿足
		// 条件结果2 0：left與mid不超過10個單位  1：mid與right不超過10個單位  2：前面两个都成立  9：全不滿足
		// 条件结果3 0：left與mid在對方90%-110%之間  1：mid與right在對方90%-110%之間  2：前面两个都成立  9：全不滿足

		int 条件结果1 = 条件结果list3.get(0);
		int 条件结果2 = 条件结果list3.get(1);
		int 条件结果3 = 条件结果list3.get(2);


		//
		if(判断開始条件(条件结果1, 条件结果2, 条件结果3)) {
			
			p.setI開始日時(left.get日時());
			p.setI開始index(left.getIndex());
			平台_折点list.add(left);
			
		}else {
			p.setI開始日時(mid.get日時());
			p.setI開始index(mid.getIndex());
		}

		平台_折点list.add(mid);

		//
		if(判断结束条件(条件结果1, 条件结果2, 条件结果3)) {
			
			p.setI結束日時(right.get日時());
			p.setI結束index(right.getIndex());
			平台_折点list.add(right);
		}else {
			p.setI結束日時(mid.get日時());
			p.setI結束index(mid.getIndex());
		}

		//p.setI類型(CommonConst.平台_類型_高台);
		p.set平台折点list(平台_折点list);

		return p;
	}

	private boolean 判断结束条件(int 条件结果1, int 条件结果2, int 条件结果3) {
		if(条件结果1 == 2 || 条件结果1 == 1) {
			if(条件结果2 == 2 || 条件结果2 == 1) {
				if(条件结果3 == 2 || 条件结果3 == 1) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean 判断開始条件(int 条件结果1, int 条件结果2, int 条件结果3) {
		if(条件结果1 == 2 || 条件结果1 == 0) {
			if(条件结果2 == 2 || 条件结果2 == 0) {
				if(条件结果3 == 2 || 条件结果3 == 0) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean is条件结果判定_条件结果_滿足(List<Integer> 条件list3) {

		for(Integer 条件结果 : 条件list3) {
			// 有任何一个条件全部满足就out
			if(条件结果 == CommonConst.高臺信息_条件结果_全不滿足 ) {
				return false;
			}
		}
		return true ;
	}

	private List<Integer> 解析出高臺信息_条件结果(折点 left, 折点 mid, 折点 right, List<折点> 折点list1, List<日線> 日線list) {
		List<Integer> 条件结果list = new ArrayList();

		int 条件结果A = CommonConst.高臺信息_条件结果_条件结果1_全不滿足; // 条件结果1 0：left與mid相鄰  1：mid與right相鄰  2：前面两个都成立  9：全不滿足
		int 条件结果B = CommonConst.高臺信息_条件结果_条件结果2_全不滿足; // 条件结果2 0：left與mid不超過10個單位  1：mid與right不超過10個單位  2：前面两个都成立  9：全不滿足
		int 条件结果C = CommonConst.高臺信息_条件结果_条件结果3_全不滿足; // 条件结果3 0：left與mid在對方90%-110%之間  1：mid與right在對方90%-110%之間  2：前面两个都成立  9：全不滿足
		
		
		//-------------------------------------------------------------------------------
		// 条件A：上記3个折點至少有2个高点在list1裏也是相邻的（最多2個高点间隔以內）
		//-------------------------------------------------------------------------------
		条件结果A = chk間隔位置差(left, mid, right, 折点list1);
		
		//-------------------------------------------------------------------------------
		// 条件B：上記折點的日期间隔不超過10個單位（暫定）
		//-------------------------------------------------------------------------------
		条件结果B = chk間隔時間差(left, mid, right, 日線list);
		
		//-------------------------------------------------------------------------------
		// 条件C：判断上记两个高点是不是在对方90%-110%之間，且在【標準價差】之内
		// 標準價差:不超过高低点差额1/5範圍
		// float left价格 = Float.parseFloat(left.get价格());
		// float mid价格 = Float.parseFloat(mid.get价格());
		// float right价格 = Float.parseFloat(right.get价格());
		//-------------------------------------------------------------------------------
		条件结果C = chk价格差(left, mid, right, 折点list1);


		条件结果list.add(条件结果A);
		条件结果list.add(条件结果B);
		条件结果list.add(条件结果C);

		return 条件结果list;
	}

	private int chk間隔位置差(折点 left, 折点 mid, 折点 right, List<折点> 折点list1) {
		int 折点list1_left_index = 0;
		int 折点list1_mid_index = 0;
		int 折点list1_right_index = 0;

		折点list1_left_index = 取得指定List中的index(left, 折点list1);
		折点list1_mid_index = 取得指定List中的index(mid, 折点list1);
		折点list1_right_index = 取得指定List中的index(right, 折点list1);

		if((折点list1_mid_index - 折点list1_left_index <=  4) && (折点list1_right_index - 折点list1_mid_index <=  4)) {
			return CommonConst.高臺信息_条件结果_条件结果1_前面两个都成立;
		}
		if(折点list1_mid_index - 折点list1_left_index <=  4) {
			return CommonConst.高臺信息_条件结果_条件结果1_left與mid相鄰; // 条件结果1 0：left與mid相鄰  1：mid與right相鄰  2：前面两个都成立  9：全不滿足
		}
		if(折点list1_right_index - 折点list1_mid_index <=  4) {
			return CommonConst.高臺信息_条件结果_条件结果1_mid與right相鄰; // 条件结果1 0：left與mid相鄰  1：mid與right相鄰  2：前面两个都成立  9：全不滿足
		}
		return CommonConst.高臺信息_条件结果_条件结果1_全不滿足;
	}

	private int chk間隔時間差(折点 left, 折点 mid, 折点 right, List<日線> 日線list) {
		int left_index = 取得日線list中的index(left, 日線list);
		int mid_index = 取得日線list中的index(mid, 日線list);
		int right_index = 取得日線list中的index(right, 日線list);
		
		if((mid_index - left_index <=  10) && (right_index - mid_index <=  10)) {
			return CommonConst.高臺信息_条件结果_条件结果2_前面两个都成立;
		}

		if(mid_index - left.getIndex() <=  10) {
			return CommonConst.高臺信息_条件结果_条件结果2_left與mid不超過10個單位;// 0 条件结果2 0：left與mid不超過10個單位  1：mid與right不超過10個單位  2：前面两个都成立  9：全不滿足
		}

		if(right_index - mid_index <=  10) {
			return CommonConst.高臺信息_条件结果_条件结果2_mid與right不超過10個單位;// 1 条件结果2 0：left與mid不超過10個單位  1：mid與right不超過10個單位  2：前面两个都成立  9：全不滿足
		}
		return CommonConst.高臺信息_条件结果_条件结果2_全不滿足;
	}

	private int chk价格差(折点 left, 折点 mid, 折点 right, List<折点> 折点list1) {
		//float mid_left_rate = left价格 / mid价格;
		float mid_left_rate = 平台Util2.取得折点差价范围(left, mid);

		//float mid_right_rate = right价格 / mid价格;
		float mid_right_rate = 平台Util2.取得折点差价范围(right, mid);

		float f_right_mid价差 = 平台Util2.取得指定两点价差(right, mid);
		float f_left_mid价差 = 平台Util2.取得指定两点价差(left, mid);
		//
		折点 h = 簡單解析Util2.取得指定折点List的最高点(折点list1);
		折点 l = 簡單解析Util2.取得指定折点List的最低点(折点list1);
		//標準價差 = 不超过高低点差额1/5範圍
		float f標準價差 = 平台Util2.取得視覺圖上最多不能跨過的誤差範圍(h, l);
		
		if((mid_left_rate >= 0.9 && mid_left_rate <= 1.1) && (mid_right_rate >= 0.9 && mid_right_rate <= 1.1) ){
			if( f標準價差 > f_right_mid价差 && f標準價差 > f_left_mid价差) {
				return CommonConst.高臺信息_条件结果_条件结果3_前面两个都成立;				
			}
		}
		if(mid_left_rate >= 0.9 && mid_left_rate <= 1.1 ) {
			if( f標準價差 > f_left_mid价差) {
				return CommonConst.高臺信息_条件结果_条件结果3_left與mid在對方90_110之間;// 0 条件结果3 0：left與mid在對方90%-110%之間  1：mid與right在對方90%-110%之間  2：前面两个都成立  9：全不滿足
			}

		}
		if(mid_right_rate >= 0.9 && mid_right_rate <= 1.1) {
			if( f標準價差 > f_right_mid价差) {
				return CommonConst.高臺信息_条件结果_条件结果3_mid與right在對方90_110之間;// 1 条件结果3 0：left與mid在對方90%-110%之間  1：mid與right在對方90%-110%之間  2：前面两个都成立  9：全不滿足
			}
		}
		return CommonConst.高臺信息_条件结果_条件结果3_全不滿足;
	}

	private int 取得日線list中的index(折点 o, List<日線> 日線list) {
		int i =0;
		for(日線 z : 日線list) {
			if(o.get日時()==Integer.parseInt(z.get日時())) {
				return i;
			}
			i++;
		}
		return 9999999;
	}

	public List<折点> 排除幹擾(List<折点> 折点list2, List<折点> 折点list3, List<平台> 平台list) {

		List<折点> 折点list23 = new ArrayList(折点list3);
		//List<折点> 折点list3低點 = new ArrayList();
		List<折点> 折点list3低點 = 平台Util2.取得指定list的低點list(折点list3);
		//-----------------------------------------------
		// 从折点list3 取得所有低点

		// 循環處理每一個低點.

		//    該低點是不是也是折點list3的低點

		//    上記為【是】的情況

		//    	  低点之后是高点还是高台

		//    	  如果是高點：去掉折點list2裏對應的折點（高低一對）

		//        如果是高台：保留最高位的那对儿
		//-----------------------------------------------

		List<折点> 平台内折点list = new ArrayList();


		for(折点 z低點 : 折点list3低點) {

			//------------------------------
			//  低点之后是高点还是高台
			//------------------------------

			// 折點list3裏該低點之後的高點
			int index = 取得指定List中的index(z低點, 折点list3);

			if((index + 1 ) >= 折点list3.size()){
				break;
			}
			折点 g = 折点list3.get(index + 1);

			boolean b該点是否在高臺內 = 該点是否在高臺內(g, 平台list, 折点list2);

			if(b該点是否在高臺內 == true) {
				//  如果是高台：保留最高位的那对儿
				// (将最后的折点加到 折点list23 中)

				// 取得目标折点（一高一低）
				List<折点> 折点_高_低_list = 取得目标折点_一高_一低(z低點, 折点list3.get(index + 1), 折点list2);

				// 将目标折点加入到目标折点list
				// 這對高點不在折點list3對象範圍內
				// 特点是，它在最后，且不在折點list3内
				折点list23 = 将目标折点加入到目标折点list(折点list23, 折点_高_低_list);

			}else {
				//  如果是高點：去掉折點list2裏對應的折點（高低一對）
				// (啥 也不動)

			}
		}
		return 折点list23;
		
	}

	private List<折点> 将目标折点加入到目标折点list(List<折点> 折点list3, List<折点> 折点_高_低_list) {

		List<折点> 目標list = new ArrayList();

		目標list.addAll(折点list3);

		目標list.addAll(折点_高_低_list);

		return SortUtil.sortListByPropertyNamesValue(目標list,"日時");
	}

	private List<折点> 取得目标折点_一高_一低(折点 z低点, 折点 z高点, List<折点> 折点list2) {

		List<折点> 目標list = new ArrayList();

		int index低点 = 取得指定List中的index(z低点, 折点list2);

		int index高点 = 取得指定List中的index(z高点, 折点list2);

		if(index高点 - index低点 >= 2 ) {
			目標list.add(折点list2.get(index高点 -1));
			目標list.add(折点list2.get(index高点 -2));
		}

		return 目標list;
	}

	private boolean 該点是否在高臺內(折点 g, List<平台> 平台list, List<折点> 折点list2) {
		// 為了【排除幹擾】，
		// 確認一下是否存在平臺型高臺
		// 取得每个平台
		// 看看该点是否在其中某一个平台内


		int g日時 = g.get日時();

		for(平台 p : 平台list) {
			if(p.getI開始日時()<=g日時 && g日時<= p.getI結束日時()) {
				return true;
			}
		}

		return false;
	}

	private int 取得指定List中的index(折点 o, List<折点> 折点list) {
		int i =0;
		for(折点 z : 折点list) {
			if(o.get日時()==z.get日時()) {
				return i;
			}
			i++;
		}
		return 9999999;

	}

	public List<折点> 高台充实(List<折点> 折点list1, List<折点> 折点list23, List<平台> 平台list) {

		//-----------------------------------------------
		// 循環處理平台list里的每一個高台.

		//    条件A：高台的两端之间存在未记录的高点。

		//    条件B：該高點在允許範圍內 90-110%，

		//    如果条件A与B同時滿足

		//        追加该折点（高低）到折点list23
		//-----------------------------------------------

		for(平台 p : 平台list) {
			// 取得高台的两端之间所有折点list1的高点
			List<折点> 目標list = 取得高台的两端之间所有折点(p, 折点list1);

			目標list = 解析出高臺信息_条件结果(目標list, 折点list1, p);

			折点list23 = 将目标折点加入到目标折点list(折点list23, 目標list);
		}

		return 折点list23;
	}

	private List<折点> 解析出高臺信息_条件结果(List<折点> 目標list, List<折点> 折点list1, 平台 p) {


		// 从折点list1 取得所有高点
		List<折点> 折点list1高點 = 平台Util2.取得指定list的高點list(折点list1);


		// 該高點在允許範圍內 90-110%
		折点 p1 = SortUtil.sortListByPropertyNamesValue(p.get平台折点list(),"价格").get(0);
		//float p1价格 = Float.parseFloat(p1.get价格());


		for(折点 z : 折点list1高點) {
			float z价格 = Float.parseFloat(z.get价格());
			//float p_rate = p1价格 / z价格;

			float p_rate =平台Util2.取得折点差价范围(p1, z);
			if(p_rate >= 0.9 && p_rate <= 1.1) {
				p.get平台折点list().add(z);
				目標list.add(z);
				目標list.add(取得下一点(z, 折点list1));
			}
		}

		//
		return SortUtil.sortListByPropertyNamesValue(目標list,"日時");

	}

	private 折点 取得下一点(折点 z, List<折点> 折点list1) {

		int indexZ = 取得指定List中的index(z, 折点list1);

		return 折点list1.get(indexZ+1);
	}

	private List<折点> 取得高台的两端之间所有折点(平台 p, List<折点> 折点list1) {
		// 取得高台的两端之间所有折点list1的高点

		List<折点> l = new ArrayList();

		int i開始日時 = p.getI開始日時();

		int i結束日時 = p.getI結束日時();

		for(折点 z : 折点list1) {
			if(z.get日時() >= i開始日時 || z.get日時() <= i結束日時) {
				l.add(z);
			}
		}

		return l;
	}

	public static List<平台> 設置高低平臺(List<平台> 平台list, List<折点> 折点list3) {
		// 如果这个平台高于两旁高点，就是高台
		// 如果这个平台低于两旁任一高点，就是低台
		List<平台> 平台list1 = new ArrayList();

		for(平台 p平台 : 平台list) {
			int size = p平台.get平台折点list().size();
			折点 z之前高点 =  平台Util2.取得指定list中指定折点之前的高点(p平台.get平台折点list().get(0), 折点list3);
			折点 z之后高点 =  平台Util2.取得指定list中指定折点之后的高点(p平台.get平台折点list().get(size-1), 折点list3);
			
			float  f之前高点价格 = 0;
			float  f之后高点价格 =0;
			if(z之前高点 != null) {
				f之前高点价格=		Float.parseFloat(z之前高点.get价格());
			}
			if(z之后高点 != null) {
				f之后高点价格 = Float.parseFloat(z之后高点.get价格());
			}
			float f平台最高价格 = p平台.getF最高价格();
//			int 高低; // 0=高 1=低
//			int 形状; // 0=M形 1=頭肩形 2=收縮三角形
			if(f之前高点价格 > f平台最高价格 && f之后高点价格 > f平台最高价格 ) {
				// 如果这个平台高于两旁高点，就是高三角形
				p平台.set高低(1);
			}else {
				// 如果这个平台低于两旁任一高点，就是低三角形
				p平台.set高低(0);
			}
			平台list1.add(p平台);
		}


		return 平台list1;
	}

	public List<圖形> 設置高低三角形(List<圖形> 圖形_收縮三角形list, List<折点> 折点list3) {
		// 如果这个平台高于两旁高点，就是高三角形
		// 如果这个平台低于两旁任一高点，就是低三角形
		List<圖形> 圖形_收縮三角形list_ = new ArrayList();


		for(圖形 t三角形 : 圖形_收縮三角形list) {

			折点 z之前高点 =  平台Util2.取得指定list中指定折点之前的高点(t三角形.get三角形_第一折点(), 折点list3);
			折点 z之后高点 =  平台Util2.取得指定list中指定折点之后的高点(t三角形.get三角形_優化後破点折点(), 折点list3);
			float f之前高点价格 = Float.parseFloat(z之前高点.get价格());
			float f之后高点价格 = Float.parseFloat(z之后高点.get价格());
			float f三角形最高价格 = t三角形.get三角形_大邊最高價格();
//			int 高低; // 0=高 1=低
//			int 形状; // 0=M形 1=頭肩形 2=收縮三角形
			if(f之前高点价格 > f三角形最高价格 && f之后高点价格 > f三角形最高价格 ) {
				// 如果这个平台高于两旁高点，就是高三角形
				t三角形.set高低(1);
			}else {
				// 如果这个平台低于两旁任一高点，就是低三角形
				t三角形.set高低(0);
			}

			圖形_收縮三角形list_.add(t三角形);
		}

		return 圖形_收縮三角形list_;
	}

}
