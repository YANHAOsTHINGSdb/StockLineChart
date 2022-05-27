package ParseTool;

import java.util.ArrayList;
import java.util.List;

import com.feilong.core.util.SortUtil;

import InputData.日线;
import InputData.日线点;
import InputData.简单解析;

public class 简单解析Util {

	/*
	【简单解析】
	目的：给出对象单位的有效数据
	入口  【日线List】【指定日线数】

	出口  【简单解析List】
	处理内容
			<基本设计>
			1. 顺次从【日线List】取得【指定日线数】以内的数据
			2. 将1取到的数据按以下处理生成【简单解析】
					取开始第一个的S位的信息（XXX）作为简单解析的开始；
					取开始第一个的S位的信息（XXX）作为简单解析的开始；
					取开始第一个的S位的信息（XXX）作为简单解析的开始；
					取开始第一个的S位的信息（XXX）作为简单解析的开始；
			3.循环1与2返回【简单解析】的list

	 */
	public static List<简单解析> parse(List<日线> list日线, int 指定日线数) {
		/*
			 <详细设计>
				1，设置【开始位置】=0
				2，从【日线List】的【指定位置】开始取得【指定日线数】以内的数据
					2.0 如果【开始位置】> 【日线List】的个数 - 【指定日线数】+1
						跳出2的循环
					2.1. 生成【简单解析】
							取开始第一个的S位的信息（XXX）作为简单解析的开始；
							取开始第一个的S位的信息（XXX）作为简单解析的开始；
							取开始第一个的S位的信息（XXX）作为简单解析的开始；
							取开始第一个的S位的信息（XXX）作为简单解析的开始；
					2.2将生成的【简单解析】追加到list
					2.3.开始位置 +1
				3.返回【简单解析】的list

		 */
		List<简单解析> list简单解析 = new ArrayList();

		// 1，设置【开始位置】=0
		int i开始位置 = 0;

		// 2，从【日线List】的【指定位置】开始取得【指定日线数】以内的数据
		for (;;) {
			List<日线> list指定数据 = list日线.subList(i开始位置, 指定日线数);

			//2.0 如果【开始位置】> 【日线List】的个数 - 【指定日线数】+1
			if (i开始位置 > list日线.size() - 指定日线数 + 1)
				//跳出2的循环
				break;
			//2.1. 生成【简单解析】
			简单解析 o简单解析 = new 简单解析();
			//取开始第一个的S位的信息（XXX）作为简单解析的开始；

			o简单解析.set开始(简单解析Util.取得简单解析的开始位(list指定数据));
			//取开始第一个的S位的信息（XXX）作为简单解析的开始；
			o简单解析.set最低(简单解析Util.取得简单解析的最低位(list指定数据));
			//取开始第一个的S位的信息（XXX）作为简单解析的开始；
			o简单解析.set最高(简单解析Util.取得简单解析的最高位(list指定数据));
			//取开始第一个的S位的信息（XXX）作为简单解析的开始；
			o简单解析.set结束(简单解析Util.取得简单解析的结束位(list指定数据));
			//2.2将生成的【简单解析】追加到list
			list简单解析.add(o简单解析);
			//2.3.开始位置 +1
			i开始位置++;
		} // end for

		// 3.返回【简单解析】的list
		return list简单解析;
	}

	private static 日线点 取得简单解析的结束位(List<日线> list指定数据) {
		日线点 o = new 日线点();
		日线 r = list指定数据.get(list指定数据.size()-1);
		o.set价格(r.get收盘_价格());
		o.set位置("E");
		o.set日时(r.get日时());
		return o;
	}

	private static 日线点 取得简单解析的最高位(List<日线> list指定数据) {
		日线点 o = new 日线点();

		//SortUtil.sortList(list指定数据,newPropertyComparator<日线>("价格"));
		List<日线> l = SortUtil.sortListByPropertyNamesValue(list指定数据,"最高_价格");
		日线 r = l.get(0);
		o.set价格(r.get最高_价格());
		o.set位置("H");
		o.set日时(r.get日时());

		return o;
	}

	private static 日线点 取得简单解析的最低位(List<日线> list指定数据) {
		日线点 o = new 日线点();
		List<日线> l = SortUtil.sortListByPropertyNamesValue(list指定数据,"最低_价格");
		日线 r = l.get(l.size()-1);
		o.set价格(r.get最高_价格());
		o.set位置("L");
		o.set日时(r.get日时());
		return o;
	}

	private static 日线点 取得简单解析的开始位(List<日线> list指定数据) {
		日线点 o = new 日线点();
		日线 r = list指定数据.get(0);
		o.set价格(r.get开盘_价格());
		o.set位置("S");
		o.set日时(r.get日时());
		return o;
	}


}
