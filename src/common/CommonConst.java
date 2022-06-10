package common;

public class CommonConst {
	public final static int 低点 = 0;
	public final static int 高点 = 1;
	public final static int 更低点 = 2;
	public final static int 更高点 = 3;
	public final static int 未超想象 = 99;

	public final static int 指定日線数 = 3;

	public final static int 如果_手持低点_要找高点_但碰见一个更低的谷=1;
	public final static int 如果_手持低点_要找高点_但没有碰见一个更低的谷=2;
	public final static int 如果_手持高点_要找底点_但碰见一个更高的谷=3;
	public final static int 如果_手持高点_要找底点_但没碰见一个更高的谷=4;
	public final static int 如果_這是第一次計算=5;
	public final static int 如果_這是最後一次計算=6;
	
	public final static int 日時 = 0;
	public final static int 開盤價 = 1;
	public final static int 收盤價 = 2;
	public final static int 最低價 = 3;
	public final static int 最高價 = 4;
	
	public final static int  A模式_取得新的区间	 = 0;
	public final static int  B模式_有限区间内再找一点 = 1;
}
