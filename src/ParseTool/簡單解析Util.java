package ParseTool;

import java.util.ArrayList;
import java.util.List;

import com.feilong.core.util.SortUtil;

import InputData.日線;
import InputData.日線點;
import InputData.簡單解析;

public class 簡單解析Util {

	/*
	【簡單解析】
	目的：给出对象单位的有效数据
	入口  【日线List】【指定日线数】

	出口  【簡單解析List】
	处理内容
			<基本设计>
			1. 顺次从【日线List】取得【指定日线数】以内的数据
			2. 将1取到的数据按以下处理生成【簡單解析】
					取开始第一个的S位的信息（XXX）作为簡單解析的开始；
					取开始第一个的S位的信息（XXX）作为簡單解析的开始；
					取开始第一个的S位的信息（XXX）作为簡單解析的开始；
					取开始第一个的S位的信息（XXX）作为簡單解析的开始；
			3.循环1与2返回【簡單解析】的list

	 */
	public static List<簡單解析> 取得簡單解析對象數據(List<日線> list日線, int 指定日线数) {
		/*
			 <详细设计>
				1，设置【开始位置】=0
				2，从【日线List】的【指定位置】开始取得【指定日线数】以内的数据
					2.0 如果【开始位置】> 【日线List】的个数 - 【指定日线数】+1
						跳出2的循环
					2.1. 生成【簡單解析】
							取开始第一个的S位的信息（XXX）作为簡單解析的开始；
							取开始第一个的S位的信息（XXX）作为簡單解析的开始；
							取开始第一个的S位的信息（XXX）作为簡單解析的开始；
							取开始第一个的S位的信息（XXX）作为簡單解析的开始；
					2.2将生成的【簡單解析】追加到list
					2.3.开始位置 +1
				3.返回【簡單解析】的list

		 */
		List<簡單解析> list簡單解析 = new ArrayList();
		list日線 = 取得顺序日线数据(list日線);

		// 1，设置【开始位置】=0
		int i开始位置 = 0;

		// 2，从【日线List】的【指定位置】开始取得【指定日线数】以内的数据
		for (;;) {
			//2.0 如果【开始位置】> 【日线List】的个数 - 【指定日线数】+1
			if (i开始位置 > list日線.size() - 指定日线数)
				//跳出2的循环
				break;

			List<日線> list指定数据 = list日線.subList(i开始位置, i开始位置+指定日线数);



			if(!是否有效日(list日線.get(i开始位置))) {
				continue;
			}

			//2.1. 生成【簡單解析】

			//2.2将生成的【簡單解析】追加到list
			list簡單解析.add(根据指定日线数据制作簡單解析(list指定数据));
			//2.3.开始位置 +1
			i开始位置++;
		} // end for

		// 3.返回【簡單解析】的list
		return list簡單解析;
	}

	public static 簡單解析 根据指定日线数据制作簡單解析(List<日線> list指定数据 ) {

		簡單解析 o簡單解析 = new 簡單解析();
		//取开始第一个的S位的信息（XXX）作为簡單解析的开始；

		o簡單解析.set开始(簡單解析Util.取得簡單解析的开始位(new ArrayList(list指定数据)));
		//取开始第一个的S位的信息（XXX）作为簡單解析的开始；
		o簡單解析.set最低(簡單解析Util.取得簡單解析的最低位(new ArrayList(list指定数据)));
		//取开始第一个的S位的信息（XXX）作为簡單解析的开始；
		o簡單解析.set最高(簡單解析Util.取得簡單解析的最高位(new ArrayList(list指定数据)));
		//取开始第一个的S位的信息（XXX）作为簡單解析的开始；
		o簡單解析.set結束(簡單解析Util.取得簡單解析的結束位(new ArrayList(list指定数据)));

		o簡單解析.setList指定数据(list指定数据);

		return o簡單解析;
	}

	private static boolean 是否有效日(日線 日线) {
		if(日线.get開盤_价格().equals(日线.get收盤_价格()) && 日线.get最高_价格().equals(日线.get最低_价格())) {
			return false;
		}
		return true;
	}

	private static 日線點 取得簡單解析的結束位(List<日線> list指定数据) {
		日線點 o = new 日線點();

		日線 r = list指定数据.get(list指定数据.size()-1);
		o.set价格(r.get收盤_价格());
		o.set位置("E");
		o.set日時(Integer.parseInt(r.get日時()));
		return o;
	}

	private static 日線點 取得簡單解析的最高位(List<日線> list指定数据) {
		日線點 o = new 日線點();

		//SortUtil.sortList(list指定数据,newPropertyComparator<日线>("价格"));
		List<日線> l = SortUtil.sortListByPropertyNamesValue(list指定数据,"最高_价格");
		日線 r = l.get(l.size()-1);
		o.set价格(r.get最高_价格());
		o.set位置("H");
		o.set日時(Integer.parseInt(r.get日時()) );

		return o;
	}

	private static 日線點 取得簡單解析的最低位(List<日線> list指定数据) {
		日線點 o = new 日線點();

		List<日線> l = SortUtil.sortListByPropertyNamesValue(list指定数据,"最低_价格");
		日線 r = l.get(0);
		o.set价格(r.get最低_价格());
		o.set位置("L");
		o.set日時(Integer.parseInt(r.get日時()));
		return o;
	}

	private static 日線點 取得簡單解析的开始位(List<日線> list指定数据) {
		日線點 o = new 日線點();

		日線 r = list指定数据.get(0);
		o.set价格(r.get開盤_价格());
		o.set位置("S");
		o.set日時(Integer.parseInt(r.get日時()));
		return o;
	}

	private static List<日線> 取得顺序日线数据(List<日線> list指定数据) {
		日線點 o = new 日線點();
		List<日線> l = SortUtil.sortListByPropertyNamesValue(list指定数据,"日時");

		return l;
	}

	public static 簡單解析 排除指定日时之前的数据(簡單解析 簡單解析對象, int i指定日時) {
		簡單解析 o = new 簡單解析();
		List<日線> list日線 = new ArrayList();
		for(日線 i : 簡單解析對象.getList指定数据()) {
			if(Integer.parseInt(i.get日時())
					 > i指定日時) {
				list日線.add(i);
			}
		}

		// 重新计算高低点

		return 根据指定日线数据制作簡單解析(list日線);
	}

	public static int 取得指定日期的index(List<日線> list日線, int i指定日時) {

		int index =0;
		for(日線 i : list日線) {
				if(Integer.parseInt(i.get日時())
						 == i指定日時) {
					return index;
				}
				index++;

		}
		return index;
	}

	public static 簡單解析 取得指定区间数据制作簡單解析(List<日線> list日線,int index, int 对象个数) {
		List<日線> list指定数据 = list日線.subList(index, index+对象个数);
		return 簡單解析Util.根据指定日线数据制作簡單解析(list指定数据);

	}
}
