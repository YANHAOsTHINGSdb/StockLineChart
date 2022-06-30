package ParseTool;

import java.util.ArrayList;
import java.util.List;

import OutputData.平台;
import OutputData.彈夾;
import OutputData.折点;
import OutputData.頸線;
import common.CommonConst;

public class 平台Util {

	public List<平台> 取得平台信息(List<折点> 折点list, float 誤差範圍) {
		/*
		 * 【直到碰见一个比前面所有高低点都高或者都死的点。】

		 */

		List<平台> plist = new ArrayList();
		
		彈夾 o彈夾 = new 彈夾();
		平台 p = null;
		
		for(折点 z : 折点list) {

			if(z.get日時() == 20190625) {
				z.set日時(20190625);
			}
			if(o彈夾.追加折点(z, 誤差範圍)) {
				//追加折点
				//N（是否打破原来模式），#未取到平台信息
				//Y（是否打破原来模式），#取到平台信息
				
				p = o彈夾.取得平台信息(p);
				
				o彈夾.初始化(折点list.get(p.getI結束index()));
				
				plist.add(new 平台(p));
			}
		}
		
		// 退出时再次设置
		p = o彈夾.取得平台信息(p);
		plist.add(p);
		
		return plist;
	}

	private int 取得平台类型(平台 o平台, List<折点> 折点list, float 誤差範圍, 平台 o舊平臺) {
		int 平台类型 = CommonConst.平臺類型_低平台;
		float f開始价格 = Float.parseFloat(折点list.get(o平台.getI開始index()).get价格());
		float f結束价格 = Float.parseFloat(折点list.get(o平台.getI結束index()).get价格());
		float f結束价格_誤差範圍_low = f結束价格 - f結束价格*誤差範圍;
		float f結束价格_誤差範圍_high = f結束价格 + f結束价格*誤差範圍;
		
		if(f開始价格 >= f結束价格_誤差範圍_low && f開始价格 <= f結束价格_誤差範圍_high) {
			// 首尾两个点在一个价位区间
				// 默認為低平臺
			if(o舊平臺 == null) return 	平台类型;
				
			float f舊平臺結束价格 = Float.parseFloat(折点list.get(o舊平臺.getI結束index()).get价格());
			float f新平臺開始价格 = Float.parseFloat(折点list.get(o平台.getI開始index()).get价格());
			if(f舊平臺結束价格 > f新平臺開始价格) {
				// 高点小于前任低点
				
				平台类型 = CommonConst.平臺類型_低平台;
						
			}else {			 
				// 低点大于前任高点
				平台类型 = CommonConst.平臺類型_高平台;
			}
		}else {
		// 首尾两个点不在一个价位区间
			if(f開始价格 < f結束价格_誤差範圍_low) {
				// 開始小於結束
				平台类型 = CommonConst.平臺類型_上坡;
			}
			if(f開始价格 > f結束价格_誤差範圍_high) {
				// 開始大於結束
				平台类型 = CommonConst.平臺類型_下坡;
			}
		}
		
		return 平台类型;
	}

	public 頸線 取得頸線信息(平台 o平台, List<折点> 折点list, float 誤差範圍, 平台 o舊平臺) {
		
		頸線 o頸線 = new 頸線();
		int i平臺類型 =取得平台类型(o平台, 折点list, 誤差範圍, o舊平臺);
		
		switch(i平臺類型) {
		case(CommonConst.平臺類型_高平台):
		case(CommonConst.平臺類型_低平台):
			//頸線 =  最低低點位的平線
			折点 o折点 = 折点list.get(o平台.getI最低价格index());
			float f折点价格 = Float.parseFloat(o折点.get价格());
			o頸線.set開始价格(f折点价格);
			o頸線.setI開始日時(o平台.getI開始日時());
			
			o頸線.set結束价格(f折点价格);
			o頸線.setI結束日時(o平台.getI結束日時());
			break;
			
		case(CommonConst.平臺類型_上坡):
		case(CommonConst.平臺類型_下坡):
			//頸線 = 兩端連線的斜線
			o頸線.setI開始日時(o平台.getI開始日時());
			float f開始价格 = Float.parseFloat(折点list.get(o平台.getI開始index()).get价格());
			o頸線.set開始价格(f開始价格);
			o頸線.setI結束日時(o平台.getI結束日時());
			float f結束价格 = Float.parseFloat(折点list.get(o平台.getI結束index()).get价格());
			o頸線.set結束价格(f結束价格);
			break;
		}
		
		// 如果是平台型（高平台，低平台）
		// 如果是坡型（爬坡，降坡）
		return o頸線;
	}

	
}
