package ParseTool;

import java.util.List;

import InputData.日线点;
import InputData.简单解析;
import InputData.计算目标;
import OutputData.折点;
import common.CommonConst;

public class 计算目标Util {

	计算目标 o计算目标;
	public void 第一次计算(计算目标 o计算目标2, 简单解析 简单解析对象, List<折点> 折点list) {
		// 设定初始点
		追加确点(o计算目标2.get确(), 折点list);

		// 设定假设点+设定需求点
		初次设置假点(o计算目标2.get假(), o计算目标2.get求());
	}

	public 计算目标  初始化(简单解析 o) {// 入力=假点信息
		/*
			第一个计算目标 都来自于 第一个简单解析
		 */
		//默认开始为确
		折点  确 = turn日线点to折点(o.get开始());
		折点  假 = null;
		折点  求 = new 折点();

		//就看最高和最低谁在前面
		int i最高日时=Integer.parseInt(o.get最高().get日时());
		int i最低日时=Integer.parseInt(o.get最低().get日时());
		if (i最高日时 > i最低日时){
			假 = turn日线点to折点(o.get最低());
			假.set高低(CommonConst.低点);
			确.set高低(CommonConst.高点);
		}
		if (i最高日时 < i最低日时){
			假 = turn日线点to折点(o.get最低());
			确.set高低(CommonConst.低点);
			假.set高低(CommonConst.高点);
		}

		o计算目标.set确(确);
		o计算目标.set假(假);
		o计算目标.set求(编辑求点(o计算目标.get假()));
		return o计算目标;
	}



	private 折点 turn日线点to折点(日线点 a) {
		/*
			将简单分析的一个点转成折点
		 */
		折点  o = new 折点();
		o.set日时(o.get日时());
		o.set价格(a.get价格());
		o.set位置(a.get位置());
		return o;
	}

	public void 结束计算目标(List<折点> 折点list){
		/*
			最后的时候收摊结束
		 */
		// 现在的假点为确
		o计算目标.set确(o计算目标.get假());
		// 折点list。追加
		// 折点list。追加
		折点list.add(o计算目标.get确());
	}

	// 出现更适合的假点
	public  计算目标 更新假点(计算目标 o计算目标, 简单解析  简单解析对象, List<折点> 折点list) {// 入力=假点信息
		/*
		  	现在的假点=新假点信息
		 */

		// 如果求高，一定是最低点小于现在的最低点
		// 如果求低，一定是最低点小于现在的最高点
		折点 o折点 = null;
		if(o计算目标.get求高低()==CommonConst.高点) {
			o折点 =turn日线点to折点(简单解析对象.get最低());
		}else {
			o折点 =turn日线点to折点(简单解析对象.get最高());
		}
		o计算目标.set假(o折点);

		return o计算目标;
	}

	// 反转（现在的假点变确，新假点设为现在的假点，2用新假点更不信求点）
	public  计算目标 追加假点(计算目标 o计算目标, 简单解析  简单解析对象, List<折点> 折点list) {// 入力=新假点信息，求点信息（预期信息）
		/*
		假点确定				入力=新假点信息
		追加假点
			将旧求点升级为假点
			将求点升级为求点
		设置求高低

	 */

		// 如果求高，一定是出现了高点
		// 如果求低，一定是出现了低点
		折点 o新假点 = null;
		if(o计算目标.get求高低()==CommonConst.高点) {
			o新假点 =turn日线点to折点(简单解析对象.get最高());
		}else {
			o新假点 =turn日线点to折点(简单解析对象.get最低());
		}

		// 假点确定				入力=新假点信息
		假点确定(o计算目标.get假(), 折点list);

		// 追加假点
		o计算目标.set假(o新假点);

		// 设置求点
		//编辑求点(新假点);
		o计算目标.set求(编辑求点(o新假点));

		// 设置求高低
		o计算目标.set求高低(o计算目标.get求().get高低());

		return o计算目标;
	}

	public  计算目标 追加确点(折点  确, List<折点> 折点list) {// 入力=确点信息，折点list

		o计算目标.set确(确);
		// 折点list。追加
		折点list.add(o计算目标.get确());

		return o计算目标;
	}

	public  计算目标 假点确定(折点  新假点, List<折点> 折点list) {// 入力=求点信息
		/*
		    确定 = 现在的假点
			假点= 求点确定信息
			编辑求点				入力=新假点信息
				求点=求点信息（预期信息）（根据新假点映射）
			折点list。追加

		 */
		// 确定 = 现在的假点
		o计算目标.set确(o计算目标.get假());
		// 假点= 求点确定信息
		o计算目标.set假(新假点);
		// 编辑求点				入力=新假点信息
		// 编辑求点(新假点);
		o计算目标.set求(编辑求点(新假点));

		// 折点list。追加
		折点list.add(o计算目标.get确());

		return o计算目标;
	}

	public  计算目标 初次设置假点(折点  假, 折点  求) { // 入力=假点信息，求点信息（预期信息）
		/*
			将求升级为假
			设置求点					入力=求点信息
			设置求高低
		 */
		//将求升级为假
		o计算目标 = new 计算目标();
		o计算目标.set假(假);
		o计算目标.set求(求);
		o计算目标.set求高低(求.get高低());

		return o计算目标;
	}

	public void 设置求高低(int i高低 ) {
		// 求点的高低
		o计算目标.set求高低(i高低);

	}

	public int 取得求高低() {

		return o计算目标.get求高低();
	}

	// 入力=新假点信息
	public  折点 编辑求点(折点  假) {// 入力=新假点信息
		// 求点=求点信息（预期信息）（根据新假点映射）
		// o计算目标.set求(q);
		折点 q = new 折点();
		q.set高低(假.get高低()==CommonConst.低点?CommonConst.高点:CommonConst.低点);
		return q;
	}

	public void 最后一次计算(计算目标 o计算目标, 简单解析 简单解析对象, List<折点> 折点list) {
		// 如果求高，一定是出现了高点
		// 如果求低，一定是出现了低点
		折点 o新假点 = null;
		if(o计算目标.get求高低()==CommonConst.高点) {
			o新假点 =turn日线点to折点(简单解析对象.get最高());
		}else {
			o新假点 =turn日线点to折点(简单解析对象.get最低());
		}

		float f结束  = Float.parseFloat(简单解析对象.get结束().get价格());
		float f假  =  Float.parseFloat(o计算目标.get假().get价格());

		if(o计算目标.get求高低()==CommonConst.高点) {
			// 求高

			// 最后一点  小于 假的值
			if(f结束 < f假) {
				//假的点 = 最后一点（日期、价格，位置，高低=低）
				o计算目标.set假(turn日线点to折点(简单解析对象.get结束()));
				o计算目标.set求高低(CommonConst.高点);

				//假的点确定，追加折点
				假点确定(o计算目标.get假(), 折点list);

			}else if(f结束 > f假) {
			// 最后一点  大于 假的点
				//假的点确定，追加折点
				假点确定(o计算目标.get假(), 折点list);
				折点list.add(o计算目标.get确());

				//求的点 = 最后一点（日期、价格，位置，高低=高），追加折点
				折点  o确 = turn日线点to折点(简单解析对象.get结束());
				o确.set高低(CommonConst.高点);
				折点list.add(o确);

			}
		}else if(o计算目标.get求高低()==CommonConst.低点){
			// 求低

			// 最后一点  小于 假的值
			if(f结束 < f假) {
				//假的点确定，追加折点
				假点确定(o计算目标.get假(), 折点list);
				折点list.add(o计算目标.get确());

				//求的点 = 最后一点（日期、价格，位置，高低=低），追加折点
				折点  o确 = turn日线点to折点(简单解析对象.get结束());
				o确.set高低(CommonConst.低点);
				折点list.add(o确);

			}else if(f结束 > f假) {
			// 最后一点  大于 假的点
				//假的点 = 最后一点（日期、价格，位置，高低=高）
				o计算目标.set假(turn日线点to折点(简单解析对象.get结束()));
				o计算目标.set求高低(CommonConst.低点);

				//假的点确定，追加折点
				假点确定(o计算目标.get假(), 折点list);
			}
		}
	}
}
