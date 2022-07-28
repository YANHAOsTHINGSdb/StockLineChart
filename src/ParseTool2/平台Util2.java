package ParseTool2;

import java.util.ArrayList;
import java.util.List;

import com.feilong.core.util.SortUtil;

import OutputData.平台;
import OutputData.折点;
import OutputData.頸線;
import ParseTool.平台Util;
import common.CommonConst;

/**
 * 平台信息：
 * 每个低点之间
 * 中間有個最高點
 * @author yanhao
 *
 */
public class 平台Util2 {

	public List<平台> 取得平台信息(List<折点> 折点list, float 誤差範圍) {

		 List<平台> l = new ArrayList();
		int i开始 = 0;
		平台 p = new 平台();
		// 两个低点之间就是一个平台
		for (折点 o : 折点list) {
			if(o.get高低() == CommonConst.低点) {

				if(i开始 == 0) {
					// 如果是开始状态

					// 設置平臺開始
					p.setI開始日時(o.get日時());
					p.setI開始index(o.getIndex());
					// 調整為結束狀態
					i开始 = 1;

					continue;
				}else {
					// 如果是結束狀態

					// 設置平臺結束
					p.setI結束日時(o.get日時());
					p.setI結束index(o.getIndex());

					p.set平台折点list(平台Util2.取得两点之间的折点List(折点list, 折点list.get(p.getI結束index()), 折点list.get(p.getI結束index())));
					// 重置開始狀態
					i开始 = 0;

					// 添加平台
					l.add(p);

					// 初始化平台
					p = new 平台();
					continue;
				}
			}
		}

		return l;
	}

	public List<頸線> 取得頸線信息(List<平台> plist, List<折点> 折点list, float 誤差範圍, Object object) {

		平台Util pUtil = new 平台Util();
		List<頸線> 頸線list = new  ArrayList();

		for(平台 x平台 : plist) {
			// 取得頸線信息
			頸線 o頸線 = pUtil.取得頸線信息(x平台, 折点list, 誤差範圍, null);


			頸線list.add(o頸線);
		}
		return 頸線list;
	}

	public static float 取得折点差价范围(折点 p1, 折点 p2) {
		float p1价格 = Float.parseFloat(p1.get价格());
		float p2价格 = Float.parseFloat(p2.get价格());
		return p1价格/p2价格;
	}

	public static boolean is高点收缩(List<折点> 三個低點之間折點list) {
		List<折点> 折点list高點 = 取得指定list的高點list(三個低點之間折點list);

		 List<折点> 折点list = SortUtil.sortListByPropertyNamesValue(折点list高點,"价格");
		 boolean b1 =折点list高點.get(0).get日時() == 折点list.get(0).get日時();
		 boolean b2 =折点list高點.get(折点list高點.size()-1).get日時() == 折点list.get(折点list.size()-1).get日時();
		 if(b1 && b2) {
			 return true;
		 }

		return false;
	}

	public static boolean is低点不创新低(List<折点> 三個低點之間折點list) {

		List<折点> 折点list低點 = 取得指定list的低點list(三個低點之間折點list);

		float f开始价格 = Float.parseFloat(折点list低點.get(0).get价格());
		for(折点 z : 折点list低點) {
			float f价格 = Float.parseFloat(z.get价格());
			if(f价格 < f开始价格) {
				// 創新低
				return false;
			}
		}

		return true;
	}


	public static List<折点> 取得三個低點之間折點(List<折点> 折点list23, int i开始index) {

		// 三个低点就是一高一低三个折点


		List<折点> 折点list低點 = 取得指定list的低點list(折点list23);

		if(折点list低點.size() < i开始index + 3) {
			return null;
		}


		return 平台Util2.取得两点之间的折点List(折点list23, 折点list低點.get(i开始index), 折点list低點.get(i开始index+3));
	}

	public static List<折点> 取得两点之间的折点List(List<折点> 折点list23, 折点 開始折點, 折点 結束折點) {
		List<折点> 折点list = new ArrayList();
		for(折点 z : 折点list23) {
			if(z.get日時() >= 開始折點.get日時() && z.get日時() <= 結束折點.get日時()) {
				折点list.add(z);
			}
		}

		return 折点list;
	}
	
	public static List<折点> 取得两日期之间的折点List(List<折点> 折点list23, int 開始日期, int 結束日期) {
		List<折点> 折点list = new ArrayList();
		for(折点 z : 折点list23) {
			if(z.get日時() >= 開始日期 && z.get日時() <= 結束日期) {
				折点list.add(z);
			}
		}

		return 折点list;
	}

	public static List<折点> 追加取得三個低點之間折點(List<折点> 折点list23, int i开始index, List<折点> 三个低点list) {
		// 在既有基礎上再取得（一高一低）一對兒折點
		// 三个低点就是（一高一低）三个折点
		//

		int i个数 = 三个低点list.size();
		List<折点> 折点list低點 = new ArrayList();

		// 从折点list3 取得所有低点
		for(折点 z : 三个低点list) {
			if(z.get高低() == CommonConst.低点) {
				折点list低點.add(z);
			}
		}

		int 對象個數 = i开始index + i个数 + 1;

		if(折点list低點.size() < 對象個數) {
			return null;
		}

		return 平台Util2.取得两点之间的折点List(折点list23, 折点list低點.get(i开始index), 折点list低點.get(對象個數));
	}

	public static boolean is是否打破三角形(List<折点> 三个低点list) {
		// 新高点打破高点收缩趋势
		// 新低点创了新低，打破了最低价格

		List<折点> 折点list高點 = 取得指定list的高點list(三个低点list);
		List<折点> 折点list低點 = 取得指定list的低點list(三个低点list);

		boolean b1 = is低点不创新低(三个低点list);
		boolean b2 = is高点收缩(三个低点list);
		if(b1 && b2) {
			return false;
		}

		return true;
	}

	public static List<折点> 取得指定list的低點list(List<折点> 折点list3) {
		List<折点> 折点list低點 = new ArrayList();

		// 从折点list3 取得所有低点
		for(折点 z : 折点list3) {
			if(z.get高低() == CommonConst.低点) {
				折点list低點.add(z);
			}
		}
		return 折点list低點;
	}

	public static List<折点> 取得指定list的高點list(List<折点> 折点list3) {
		List<折点> 折点list高點 = new ArrayList();

		for(折点 z : 折点list3) {
			if(z.get高低() == CommonConst.高点) {
				折点list高點.add(z);
			}
		}
		return 折点list高點;
	}

	public static boolean is折点是否在指定list中(折点 z對象, List<折点> 折点list3) {
		for(折点 z : 折点list3) {
			if(z.get日時() == z對象.get日時()) {
				return true;
			}
		}
		return false;
	}

	public static 折点 取得指定list中指定折点之前的高点(折点 z指定折点, List<折点> 折点list3) {
		List<折点> 高点list = 取得指定list的高點list(折点list3);

		for(折点 z : 高点list) {
			if(z.get日時() > z指定折点.get日時()) {
				int index = 簡單解析Util2.取得指定日期的index(折点list3, z.get日時());
				index = index - 1;
				index = index>=0?index:0;
				return 折点list3.get(index);
			}
		}

		return null;
	}

	public static 折点 取得指定list中指定折点之后的高点(折点 z指定折点, List<折点> 折点list3) {
		List<折点> 高点list = 取得指定list的高點list(折点list3);

		for(折点 z : 高点list) {
			if(z.get日時() > z指定折点.get日時()) {
				return z;
			}
		}

		return null;
	}

	public static 折点 取得折点list中指定点之间最低折点(List<折点> 折点list, int i開始index, int i結束index) {
		// SortUtil.sortListByPropertyNamesValue(目標list,"日時");
		折点 p1 = 折点list.get(i開始index+1);
		折点 p2 = 折点list.get(i結束index-1);

		List<折点> l = 取得两点之间的折点List(折点list, p1, p2);

		List<折点> 低点list = 取得指定list的低點list(l);

		return SortUtil.sortListByPropertyNamesValue(低点list,"价格").get(0);
	}

	public static int 取得指定日期后的第一index(List<折点> 折点list, int i指定日時) {

		int index =0;
		for(折点 i : 折点list) {
				if(i.get日時() >= i指定日時) {
					return index;
				}
				index++;

		}
		return index;

	}

	public static float 取得指定两点价差(折点 right, 折点 left) {

		float fRight = Float.parseFloat(right.get价格());
		float fLeft = Float.parseFloat(left.get价格());
		if(fRight >= fLeft) {
			return fRight - fLeft;
		}else {
			return fLeft - fRight;
		}

	}

	public static float 取得視覺圖上最多不能跨過的誤差範圍(折点 high, 折点 low) {
		// 就是视觉图上最多不能跨过的误差范围
		float fHight = Float.parseFloat(high.get价格());
		float fLow = Float.parseFloat(low.get价格());
		if(fHight >= fLow) {
			return (fHight - fLow)/10;
		}else {
			return (fLow - fHight)/10;
		}
	}

}
