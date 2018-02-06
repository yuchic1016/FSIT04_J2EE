package j2eeClass02;

public class CModel {
	int x,y;
	public CModel(String x,String y){
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}
	
	public int add() {
		return x+y;
	}
	
}
