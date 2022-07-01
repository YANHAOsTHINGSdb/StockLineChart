package ParseTool2;

import java.util.List;

import InputData.日線點;
import OutputData.折点;
import lombok.Data;

@Data
public class 簡單解析2 {
	public 簡單解析2(簡單解析2 簡單解析對象) {
		开始 =簡單解析對象.get开始();
		結束 =簡單解析對象.get結束();
		最高 =簡單解析對象.get最高();
		最低 =簡單解析對象.get最低();
		list指定数据 = 簡單解析對象.getList指定数据();
	}
	public 簡單解析2() {
		
	}
	List<折点> list指定数据;
		日線點 开始;
		日線點 結束;
		日線點 最高;
		日線點 最低;
}
