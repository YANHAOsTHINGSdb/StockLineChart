
public class 料金CD小分類1 implements 料金CD小分類 {


	@Override
	public String 取得料金CD(料金CD作成用情報 o料金cd作成用情報) {
		
		String 小分類CD = "";
		
		switch(o料金cd作成用情報.get集着荷区分()) {
		
		case(CommonConst.集着荷区分_集荷):
			小分類CD = 小分類CD.concat(CommonConst.料金CD_小分類_基本);break;
		case(CommonConst.集着荷区分_着荷):	
			小分類CD = 小分類CD.concat(CommonConst.料金CD_小分類_個別);break;
		case(CommonConst.集着荷区分_その他):	
			小分類CD = 小分類CD.concat(CommonConst.料金CD_小分類_その他);break;	
		default:
			小分類CD = 小分類CD.concat(CommonConst.料金CD_小分類_その他);break;
		}
		
		
		switch(o料金cd作成用情報.get荷物種類()) {
		
		case(CommonConst.荷物種類_ケース):
			小分類CD = 小分類CD.concat(CommonConst.料金CD_小分類_ケース);break;
		case(CommonConst.荷物種類_ハンガー):	
			小分類CD = 小分類CD.concat(CommonConst.料金CD_小分類_ハンガー);break;
		case(CommonConst.荷物種類_食品):	
			小分類CD = 小分類CD.concat(CommonConst.料金CD_小分類_食品);break;
		case(CommonConst.荷物種類_不定型):	
			小分類CD = 小分類CD.concat(CommonConst.料金CD_小分類_不定型);break;
		case(CommonConst.荷物種類_その他):	
			小分類CD = 小分類CD.concat(CommonConst.料金CD_小分類_その他);break;
		case(CommonConst.荷物種類_最低料金):	
			小分類CD = 小分類CD.concat(CommonConst.料金CD_小分類_最低料金);break;
		default:
			小分類CD = 小分類CD.concat(CommonConst.料金CD_小分類_その他);break;
		}
		
		小分類CD = 小分類CD.concat(CommonConst.料金CD_小分類_固定);

		return 小分類CD;
	}

}
