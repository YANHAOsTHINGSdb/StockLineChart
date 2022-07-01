package ParseTool2;

import java.util.ArrayList;
import java.util.List;

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

}
