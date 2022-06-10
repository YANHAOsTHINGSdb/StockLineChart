package ParseTool;

import java.util.List;

import InputData.日線點;
import InputData.簡單解析;
import InputData.計算目標;
import OutputData.折点;
import common.CommonConst;

public class 計算目標Util {

	//計算目標 o計算目標;
	public void 第一次计算(計算目標 o計算目標, 簡單解析 簡單解析對象, List<折点> 折点list) {
		
		初始化(o計算目標, 簡單解析對象,  折点list);
		
		// 設定初始點
		//追加确点(o計算目標, o計算目標.get确(), 折点list);

		// 設定假設點+設定需求點
		//初次设置假点(o計算目標, o計算目標.get假(), o計算目標.get求());
	}

	private void 初始化(計算目標 o計算目標, 簡單解析 o簡單解析對象, List<折点> 折点list) {
		/*
		 * 第一个計算目標 都来自于 第一个简单解析
		 */
		// 默認開始為確
		折点 确 = turn日線點to折点(o簡單解析對象.get开始(), CommonConst.未超想象);
		折点 假 = null;
		折点 求 = new 折点();

		// 就看最高和最低谁在前面
		if (o簡單解析對象.get最高().get日時() > o簡單解析對象.get最低().get日時()) {
			假 = turn日線點to折点(o簡單解析對象.get最低(), CommonConst.未超想象);
			假.set高低(CommonConst.低点);
			确.set高低(CommonConst.高点);
		}
		if (o簡單解析對象.get最高().get日時() < o簡單解析對象.get最低().get日時()) {
			假 = turn日線點to折点(o簡單解析對象.get最高(), CommonConst.未超想象);
			假.set高低(CommonConst.高点);
			确.set高低(CommonConst.低点);
		}

		o計算目標.set确(确);
		o計算目標.set假(假);
		o計算目標.set求(編輯求點(o計算目標.get假()));
		o計算目標.set求高低(o計算目標.get求().get高低());
		
		折点list.add(确);
	}

	public 計算目標  初始化(簡單解析 o, List<折点> 折点list) {// 入力=假点信息
		/*
			第一个計算目標 都来自于 第一个简单解析
		 */
		//默認開始為確
		折点  确 = turn日線點to折点(o.get开始(), CommonConst.未超想象);
		折点  假 = null;
		折点  求 = new 折点();

		//就看最高和最低谁在前面
		if (o.get最高().get日時() > o.get最低().get日時()){
			假 = turn日線點to折点(o.get最低(), CommonConst.未超想象);
			假.set高低(CommonConst.低点);
			确.set高低(CommonConst.高点);
		}
		if (o.get最高().get日時() <  o.get最低().get日時()){
			假 = turn日線點to折点(o.get最高(), CommonConst.未超想象);			
			假.set高低(CommonConst.高点);
			确.set高低(CommonConst.低点);
		}
		
		計算目標  o計算目標 = new 計算目標();
		o計算目標.set确(确);
		o計算目標.set假(假);
		o計算目標.set求(編輯求點(o計算目標.get假()));
		o計算目標.set求高低(o計算目標.get求().get高低());
		
		折点list.add(确);
		
		return o計算目標;
	}



	private 折点 turn日線點to折点(日線點 a, int i高低点) {
		/*
			將簡單分析的一個點轉成折點
		 */
		折点  o = new 折点();
		o.set日時(a.get日時());
		o.set价格(a.get价格());
		o.set位置(a.get位置());
		o.set高低(i高低点);
		return o;
	}

	public void 結束計算目標(計算目標 o計算目標, List<折点> 折点list){
		/*
			最后的时候收摊結束
		 */
		// 現在的假點為確
		o計算目標.set确(o計算目標.get假());
		// 折点list。追加
		// 折点list。追加
		折点list.add(o計算目標.get确());
	}

	// 出現更適合的假點
	public  計算目標 更新假点(計算目標 o計算目標, 簡單解析  簡單解析對象, List<折点> 折点list) {// 入力=假点信息
		/*
		  	現在的假點=新假点信息
		 */

		// 如果求高，一定是最低点小于现在的最低点
		// 如果求低，一定是最低点小于现在的最高点
		折点 o折点 = null;
		if(o計算目標.get求高低()==CommonConst.高点) {
			o折点 =turn日線點to折点(簡單解析對象.get最低(), CommonConst.低点);
		}else {
			o折点 =turn日線點to折点(簡單解析對象.get最高(), CommonConst.高点);
		}
		o計算目標.set假(o折点);

		return o計算目標;
	}

	// 反轉（現在的假點變確，新假點設為現在的假點，2用新假點更不信求點）
	public  計算目標 追加假点(計算目標 o計算目標, 簡單解析  簡單解析對象, List<折点> 折点list) {// 入力=新假点信息，求点信息（預期信息）
		/*
		假点确定				入力=新假点信息
		追加假点
			将旧求点升级为假点
			将求点升级为求点
		設置求高低

	 */


		
		// 如果求高，一定是出现了高点
		// 如果求低，一定是出现了低点
		折点 o新假点 = null;
		if(o計算目標.get求高低()==CommonConst.高点) {
			o新假点 =turn日線點to折点(簡單解析對象.get最高(), CommonConst.高点);
		}else {
			o新假点 =turn日線點to折点(簡單解析對象.get最低(), CommonConst.低点);
		}

		// 假点确定				入力=新假点信息
		o計算目標 = 假点确定(o計算目標, o新假点, 折点list);

		// 追加假点
		o計算目標.set假(o新假点);

		// 設置求點
		// 編輯求點(新假点);
		o計算目標.set求(編輯求點(o新假点));

		// 設置求高低
		o計算目標.set求高低(o計算目標.get求().get高低());

		return o計算目標;
	}



	public  計算目標 追加确点(計算目標 o計算目標, 折点  确, List<折点> 折点list) {// 入力=确点信息，折点list

		o計算目標.set确(确);
		// 折点list。追加
		折点list.add(o計算目標.get确());

		return o計算目標;
	}

	public  計算目標 假点确定(計算目標 o計算目標, 折点  新假点, List<折点> 折点list) {// 入力=求点信息
		/*
		    确定 = 現在的假點
			假点= 求点确定信息
			編輯求點				入力=新假点信息
				求点=求点信息（預期信息）（根据新假点映射）
			折点list。追加

		 */
		// 确定 = 現在的假點
		o計算目標.set确(o計算目標.get假());
		// 假点= 求点确定信息
		o計算目標.set假(新假点);
		// 編輯求點				入力=新假点信息
		// 編輯求點(新假点);
		o計算目標.set求(編輯求點(新假点));

		// 折点list。追加
		折点list.add(o計算目標.get确());

		return o計算目標;
	}

	public  計算目標 初次设置假点(計算目標 o計算目標, 折点  假, 折点  求) { // 入力=假点信息，求点信息（預期信息）
		/*
			将求升级为假
			設置求點					入力=求点信息
			設置求高低
		 */
		//将求升级为假
		o計算目標 = new 計算目標();
		o計算目標.set假(假);
		o計算目標.set求(求);
		o計算目標.set求高低(求.get高低());

		return o計算目標;
	}

	public void 設置求高低(計算目標 o計算目標, int i高低 ) {
		// 求点的高低
		o計算目標.set求高低(i高低);

	}

	public int 取得求高低(計算目標 o計算目標) {

		return o計算目標.get求高低();
	}

	// 入力=新假点信息
	public  折点 編輯求點(折点  假) {// 入力=新假点信息
		// 求点=求点信息（預期信息）（根据新假点映射）
		// o計算目標.set求(q);
		折点 q = new 折点();
		q.set高低(假.get高低()==CommonConst.低点?CommonConst.高点:CommonConst.低点);
		return q;
	}

	public void 最后一次计算(計算目標 o計算目標, 簡單解析 簡單解析對象, List<折点> 折点list) {
		// 如果求高，一定是出现了高点
		// 如果求低，一定是出现了低点
		折点 o新假点 = null;
		if(o計算目標.get求高低()==CommonConst.高点) {
			o新假点 =turn日線點to折点(簡單解析對象.get最高(), CommonConst.高点);
		}else {
			o新假点 =turn日線點to折点(簡單解析對象.get最低(), CommonConst.低点);
		}

		float f結束  = Float.parseFloat(簡單解析對象.get結束().get价格());
		float f假  =  Float.parseFloat(o計算目標.get假().get价格());

		if(o計算目標.get求高低()==CommonConst.高点) {
			// 求高

			// 最后一点  小于 假的值
			if(f結束 < f假) {
				//假的点 = 最后一点（日期、价格，位置，高低=低）
				o計算目標.set假(turn日線點to折点(簡單解析對象.get結束(), CommonConst.低点));
				o計算目標.set求高低(CommonConst.高点);

				//假的点确定，追加折点
				假点确定(o計算目標, o計算目標.get假(), 折点list);

			}else if(f結束 > f假) {
			// 最后一点  大于 假的点
				//假的点确定，追加折点
				假点确定(o計算目標, o計算目標.get假(), 折点list);
				折点list.add(o計算目標.get确());

				//求的点 = 最后一点（日期、价格，位置，高低=高），追加折点
				折点  o确 = turn日線點to折点(簡單解析對象.get結束(), CommonConst.高点);
				o确.set高低(CommonConst.高点);
				折点list.add(o确);

			}
		}else if(o計算目標.get求高低()==CommonConst.低点){
			// 求低

			// 最后一点  小于 假的值
			if(f結束 < f假) {
				//假的点确定，追加折点
				假点确定(o計算目標, o計算目標.get假(), 折点list);
				折点list.add(o計算目標.get确());

				//求的点 = 最后一点（日期、价格，位置，高低=低），追加折点
				折点  o确 = turn日線點to折点(簡單解析對象.get結束(), CommonConst.低点);
				o确.set高低(CommonConst.低点);
				折点list.add(o确);

			}else if(f結束 > f假) {
			// 最后一点  大于 假的点
				//假的点 = 最后一点（日期、价格，位置，高低=高）
				o計算目標.set假(turn日線點to折点(簡單解析對象.get結束(), CommonConst.高点));
				o計算目標.set求高低(CommonConst.低点);

				//假的点确定，追加折点
				假点确定(o計算目標, o計算目標.get假(), 折点list);
			}
		}
	}
}
