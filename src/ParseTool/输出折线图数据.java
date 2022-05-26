package ParseTool;

import java.util.List;

import InputData.折点;
import InputData.简单解析;
import InputData.计算目标;

public class 输出折线图数据 {
	/*
	输出折线图数据
		入口  【日线List】
		出口  【简单解析List】								折点（日期，位置（SEHL），价格）
		处理内容
			先来个【简单解析】
				入口  【日线List】【指定日线数】
				出口  【简单解析List】
				处理内容

			初始化【计算目标】
				出口  【计算目标】

			再调用输出折点list
				入力  【简单解析List】【计算目标】=null 【折点list】=null
				出口  【折点list】
				处理内容

	 */
	List<折点> 输出折线图数据(List<String> list日线) {

		List<折点> 折点List = null;

		int 指定日线数 = 3;

		List<简单解析> 简单解析List = 简单解析Util.parse(list日线, 指定日线数);

		计算目标 o计算目标 = 计算目标Util.初始化();

		折点List = 输出折点list(简单解析List, o计算目标, 折点List);
		return 折点List;

	}

	private List<折点> 输出折点list(List<简单解析> 简单解析List, 计算目标 o计算目标, List<折点> 折点List) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
