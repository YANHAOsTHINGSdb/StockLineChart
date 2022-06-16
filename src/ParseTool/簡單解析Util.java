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
			list簡單解析.add(根据指定日线数据制作簡單解析(list日線, list指定数据));
			//2.3.开始位置 +1
			i开始位置++;
		} // end for

		// 3.返回【簡單解析】的list
		return list簡單解析;
	}

	public static 簡單解析 根据指定日线数据制作簡單解析(List<日線> list日線, List<日線> list指定数据 ) {

		簡單解析 o簡單解析 = new 簡單解析();
		//取开始第一个的S位的信息（XXX）作为簡單解析的开始；

		o簡單解析.set开始(簡單解析Util.取得簡單解析的开始位(list日線, new ArrayList(list指定数据)));
		//取开始第一个的S位的信息（XXX）作为簡單解析的开始；
		o簡單解析.set最低(簡單解析Util.取得簡單解析的最低位(list日線, new ArrayList(list指定数据)));
		//取开始第一个的S位的信息（XXX）作为簡單解析的开始；
		o簡單解析.set最高(簡單解析Util.取得簡單解析的最高位(list日線, new ArrayList(list指定数据)));
		//取开始第一个的S位的信息（XXX）作为簡單解析的开始；
		o簡單解析.set結束(簡單解析Util.取得簡單解析的結束位(list日線, new ArrayList(list指定数据)));

		o簡單解析.setList指定数据(list指定数据);

		return o簡單解析;
	}

	private static boolean 是否有效日(日線 o日線) {
		if(o日線.get開盤_价格().equals(o日線.get收盤_价格()) && o日線.get最高_价格().equals(o日線.get最低_价格())) {
			return false;
		}
		return true;
	}

	private static 日線點 取得簡單解析的結束位(List<日線> list日線, List<日線> list指定数据 ) {
		日線點 o = new 日線點();

		日線 r = list指定数据.get(list指定数据.size()-1);
		o.set价格(r.get收盤_价格());
		o.set位置("E");
		o.set日時(Integer.parseInt(r.get日時()));
		o.setIndex(取得指定日期的index(list日線, Integer.parseInt(r.get日時())));
		return o;
	}

	private static 日線點 取得簡單解析的最高位(List<日線> list日線, List<日線> list指定数据 ) {
		日線點 o = new 日線點();

		//SortUtil.sortList(list指定数据,newPropertyComparator<日线>("价格"));
		List<日線> l = SortUtil.sortListByPropertyNamesValue(list指定数据,"最高_价格");
		日線 最高r = l.get(l.size()-1);
		String s最高价格 = 最高r.get最高_价格();
		
		// 如果最高价格一样，以最先出现的为准
		for( 日線 r : l) {
			if( r.get最高_价格().equals(s最高价格)) {
				最高r = r;
				break;
			}
		}
		
		o.set价格(s最高价格);
		o.set位置("H");
		o.set日時(Integer.parseInt(最高r.get日時()) );
		o.setIndex(取得指定日期的index(list日線, Integer.parseInt(最高r.get日時())));
		return o;
	}

	private static 日線點 取得簡單解析的最低位(List<日線> list日線, List<日線> list指定数据 ) {
		日線點 o = new 日線點();

		List<日線> l = SortUtil.sortListByPropertyNamesValue(list指定数据,"最低_价格");
		日線 r = l.get(0);
		
		// 如果最低价格一样，以最后出现的为准
		
		
		o.set价格(r.get最低_价格());
		o.set位置("L");
		o.set日時(Integer.parseInt(r.get日時()));
		o.setIndex(取得指定日期的index(list日線, Integer.parseInt(r.get日時())));
		return o;
	}

	private static 日線點 取得簡單解析的开始位(List<日線> list日線, List<日線> list指定数据 ) {
		日線點 o = new 日線點();

		日線 r = list指定数据.get(0);
		o.set价格(r.get開盤_价格());
		o.set位置("S");
		o.set日時(Integer.parseInt(r.get日時()));
		o.setIndex(取得指定日期的index(list日線, Integer.parseInt(r.get日時())));
		return o;
	}

	private static List<日線> 取得顺序日线数据(List<日線> list指定数据) {
		日線點 o = new 日線點();
		List<日線> l = SortUtil.sortListByPropertyNamesValue(list指定数据,"日時");

		return l;
	}

	public static 簡單解析 排除指定日时之前的数据(List<日線> list日線, 簡單解析 簡單解析對象, int i指定日時) {
		簡單解析 o = new 簡單解析();
		List<日線> list指定数据 = new ArrayList();
		for(日線 i : 簡單解析對象.getList指定数据()) {
			if(Integer.parseInt(i.get日時())
					 > i指定日時) {
				list指定数据.add(i);
			}
		}

		// 重新计算高低点

		return 根据指定日线数据制作簡單解析(list日線, list指定数据);
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

	/**
	 * 从指定index开始到對象個數的指定區間的簡單解析数据做成
	 * 
	 *    |--------------對象個數--------------|
	 *  指定index
	 * 
	 * @param list日線
	 * @param index
	 * @param 對象個數
	 * @return
	 */
	public static 簡單解析 取得指定區間數據製作簡單解析(List<日線> list日線, int 指定index, int 對象個數) {
		List<日線> list指定数据 = null;
		if(指定index + 對象個數 >= list日線.size()) {
			list指定数据 = list日線.subList(指定index, list日線.size() - 1);
		}else {
			list指定数据 = list日線.subList(指定index, 指定index  + 對象個數);
		}
		if(list指定数据.size()==0) {
			指定index = 指定index;
		}
		return 根据指定日线数据制作簡單解析(list日線, list指定数据);

	}
	
	/**
	 * 从指定index的下一个单位开始到對象個數的指定區間的簡單解析数据做成
	 * 
	 *   |--- 1 ---|--------------對象個數--------------|
	 *  指定index
	 * 	 
	 * @param list日線
	 * @param index
	 * @param 對象個數
	 * @return
	 */
	public static 簡單解析 取得指定區間數據製作簡單解析2(List<日線> list日線,int index, int 對象個數) {
		if(index >= list日線.size() -1 ) return null;
		
		List<日線> list指定数据 = null;
		if(index+對象個數 >= list日線.size()) {
			list指定数据 = list日線.subList(index+1, list日線.size() - 1);
		}else {
			list指定数据 = list日線.subList(index+1, index + 1 + 對象個數);
		}
		
		return 根据指定日线数据制作簡單解析(list日線, list指定数据);

	}
	
	
	public static 簡單解析 取得指定區間數據製作簡單解析3(簡單解析 o處理對象, List<日線> list日線,int 開始index, int 結束index) {
		if(開始index >= list日線.size() -1 ) return null;
		
		List<日線> list指定数据 = null;
		if(結束index >= list日線.size()) {
			list指定数据 = list日線.subList(開始index, list日線.size() - 1);
		}else {
			list指定数据 = list日線.subList(開始index, 結束index+1);
		}
		
		簡單解析 o簡單解析 = 根据指定日线数据制作簡單解析(list日線, list指定数据);

		o處理對象.setList指定数据(o簡單解析.getList指定数据());
		o處理對象.set开始(o簡單解析.get开始());
		o處理對象.set最低(o簡單解析.get最低());
		o處理對象.set最高(o簡單解析.get最高());
		o處理對象.set結束(o簡單解析.get結束());		
		
		return o處理對象;
	}
	/**
	 * 取得指定日的前后指定天数的簡單解析
	 * 
	 *   |--- 對象個數 - 1 ---|----對象個數 - 1 ---|
	 *                     指定index
	 *  
	 * @param list日線
	 * @param i指定日時
	 * @param i指定天数
	 * @param i最大最小值
	 * @return
	 */
	public static 簡單解析 取得指定日的前后指定天数的簡單解析(List<日線> list日線, int index假点, int i指定天数, int i最大最小值) {

		// |index假点 ----(對象個數)----|
		
		
		//int i开始index = i指定index - i指定天数 + 1;
		int i开始index = index假点 + 1;
		//int i結束index = index假点 + i指定天数;
		i开始index = i开始index < 0 ? 0 : i开始index;
		
		//List<日線> list指定数据 = list日線.subList(i开始index, i結束index);
		return 取得指定區間數據製作簡單解析(list日線, i开始index, i指定天数);

	}

	public static 簡單解析 取得指定日的前后指定天数的簡單解析2(List<日線> list日線, int index假点, int 對象個數, int get高低) {
		
		// | ---(對象個數)---- index假点 ----(對象個數)----|
		//i开始index
		
		//int i开始index = i指定index - i指定天数 + 1;
		int i开始index = index假点 - 對象個數;
		//int i結束index = index假点 + i指定天数;
		i开始index = i开始index < 0 ? 0 : i开始index;
		
		//List<日線> list指定数据 = list日線.subList(i开始index, i結束index);
		return 取得指定區間數據製作簡單解析(list日線, i开始index, 對象個數 * 2);
	}

}
