
public class 料金CD中分類2 implements 料金CD中分類 {

	public final static int 送り状種類_納品 = 1;
	public final static int 送り状種類_返品 = 2;
	public final static int 送り状種類_店間 = 3;
	
	public final static String 料金CD_中分類_納品 = "1";
	public final static String 料金CD_中分類_返品 = "2";
	public final static String 料金CD_中分類_店間 = "3";
	public final static String 料金CD_中分類_その他 = "0";
	
	public final static int 納品形態_買取 = 1;
	public final static int 納品形態_SCM検品 = 2;
	public final static int 納品形態_消化 = 3;
	
	public final static String 料金CD_中分類_買取 = "1";
	public final static String 料金CD_中分類_SCM検品 = "2";
	public final static String 料金CD_中分類_消化 = "0";
	
	public final static String 料金CD_中分類_固定 = "0";
	
	@Override
	public String 取得料金CD(料金CD作成用情報 o料金cd作成用情報) {
		
		String 中分類CD = "";
		
		switch(o料金cd作成用情報.get送り状種類()) {
		
		case(送り状種類_納品):
			中分類CD =中分類CD.concat(料金CD_中分類_納品);break;
		case(送り状種類_返品):	
			中分類CD =中分類CD.concat(料金CD_中分類_返品);break;
		case(送り状種類_店間):	
			中分類CD =中分類CD.concat(料金CD_中分類_店間);break;	
		default:
			中分類CD =中分類CD.concat(料金CD_中分類_その他);
		}
		
		
		switch(o料金cd作成用情報.get納品形態()) {
		
		case(納品形態_買取):
			中分類CD =中分類CD.concat(料金CD_中分類_買取);break;
		case(納品形態_SCM検品):	
			中分類CD =中分類CD.concat(料金CD_中分類_SCM検品);break;
		case(納品形態_消化):	
			中分類CD =中分類CD.concat(料金CD_中分類_消化);break;
		default:
			中分類CD =中分類CD.concat(料金CD_中分類_その他);
		}
		
	
		中分類CD =中分類CD.concat(料金CD_中分類_固定);
		
		
		return 中分類CD;
	}

}
