
public class 料金CD中分類1 implements 料金CD中分類 {


	
	@Override
	public String 取得料金CD(料金CD作成用情報 o料金cd作成用情報) {
		
		String 中分類CD = "";
		
		switch(o料金cd作成用情報.get基本個別区分()) {
		
		case(CommonConst.基本個別区分_基本):
			中分類CD = 中分類CD.concat(CommonConst.料金CD_中分類_基本);break;
		case(CommonConst.基本個別区分_個別):	
			中分類CD =中分類CD.concat(CommonConst.料金CD_中分類_個別);break;
		case(CommonConst.基本個別区分_その他):	
			中分類CD =中分類CD.concat(CommonConst.料金CD_中分類_その他);break;	
		default:
			中分類CD =中分類CD.concat(CommonConst.料金CD_中分類_その他);break;
		}
		
		
		switch(o料金cd作成用情報.get納品形態()) {
		
		case(CommonConst.納品形態_買取):
			中分類CD =中分類CD.concat(CommonConst.料金CD_中分類_買取);break;
		case(CommonConst.納品形態_SCM検品):	
			中分類CD =中分類CD.concat(CommonConst.料金CD_中分類_SCM検品);break;
		case(CommonConst.納品形態_消化):	
			中分類CD =中分類CD.concat(CommonConst.料金CD_中分類_消化);break;
		default:
			中分類CD =中分類CD.concat(CommonConst.料金CD_中分類_その他);break;
		}
		
		
		switch(o料金cd作成用情報.getサイズ有無()) {
		
		case(CommonConst.サイズ有無_なし):
			中分類CD =中分類CD.concat(CommonConst.料金CD_中分類_サイズなし);break;
		case(CommonConst.サイズ有無_あり):	
			中分類CD =中分類CD.concat(CommonConst.料金CD_中分類_サイズあり);break;
		case(CommonConst.サイズ有無_その他):	
			中分類CD =中分類CD.concat(CommonConst.料金CD_中分類_その他);break;
		default:
			中分類CD =中分類CD.concat(CommonConst.料金CD_中分類_その他);break;
		}		
		

		return 中分類CD;
	}


}
