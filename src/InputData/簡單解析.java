package InputData;

import java.util.List;

import lombok.Data;

@Data
public class 簡單解析 {

	public 簡單解析(簡單解析 簡單解析對象) {
		开始 =簡單解析對象.get开始();
		結束 =簡單解析對象.get結束();
		最高 =簡單解析對象.get最高();
		最低 =簡單解析對象.get最低();
		list指定数据 = 簡單解析對象.getList指定数据();
	}
	public 簡單解析() {
		
	}
	日線點 开始;
	日線點 結束;
	日線點 最高;
	日線點 最低;
	List<日線> list指定数据;

}
