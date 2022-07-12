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
 * 中間有個最高點v +69*-
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
					
					// 調整為結束狀態
					i开始 = 1;
					
					continue;
				}else {
					// 如果是結束狀態
					
					// 設置平臺結束
					p.setI結束日時(o.get日時());
					
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

	public static boolean is高点收缩(List<折点> 三个低点list) {
		List<折点> 折点list高點 = new ArrayList();
		List<折点> 折点list低點 = new ArrayList();
		for(折点 z : 三个低点list) {
			if(z.get高低() == CommonConst.高点) {
				折点list高點.add(z);
			}
		}
		
		 List<折点> 折点list = SortUtil.sortListByPropertyNamesValue(折点list高點,"价格");
		 boolean b1 =折点list高點.get(0).get日時() == 折点list.get(0).get日時();
		 boolean b2 =折点list高點.get(折点list高點.size()-1).get日時() == 折点list.get(折点list.size()-1).get日時();
		 if(b1 && b2) {
			 return true;
		 }
		
		return false;
	}

	public static boolean is低点不创新低(List<折点> 三个低点list) {
		List<折点> 折点list高點 = new ArrayList();
		List<折点> 折点list低點 = new ArrayList();
		for(折点 z : 三个低点list) {
			if(z.get高低() == CommonConst.高点) {
				折点list高點.add(z);
			}
		}
		
		// 从折点list3 取得所有低点
		for(折点 z : 三个低点list) {
			if(z.get高低() == CommonConst.低点) {
				折点list低點.add(z);
			}
		}
		
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
	
	
	public static List<折点> 取得三个低点(List<折点> 折点list23, int i) {
		List<折点> 三个低点list = new ArrayList();
		
		List<折点> 折点list高點 = new ArrayList();
		List<折点> 折点list低點 = new ArrayList();
		for(折点 z : 三个低点list) {
			if(z.get高低() == CommonConst.高点) {
				折点list高點.add(z);
			}
		}
		
		// 从折点list3 取得所有低点
		for(折点 z : 三个低点list) {
			if(z.get高低() == CommonConst.低点) {
				折点list低點.add(z);
			}
		}
		
		if(折点list低點.size() < i + 3) {
			return null;
		}
		
		
		return 平台Util2.取得两点之间的折点List(折点list23, 折点list低點.get(i), 折点list低點.get(i+3));
	}

	public static List<折点> 取得两点之间的折点List(List<折点> 折点list23, 折点 開始折點, 折点 結束折點) {
		List<折点> 折点list = new ArrayList();
		for(折点 z : 折点list23) {
			if(z.get日時() >= 開始折點.get日時() || z.get日時() <= 結束折點.get日時()) {
				折点list.add(z);
			}
		}
		
		return 折点list;
	}
}
