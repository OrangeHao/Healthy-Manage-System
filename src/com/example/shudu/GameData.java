package com.example.shudu;


public class GameData {

	private final String initstr=
			"360000000004230800000004200"+  
		    "070460003820000014500013020"+  
		    "001900000007048300000000045"; 
	private int[] shuduku=new int[9*9];
	
	public GameData() {
		shuduku=translatestrtointnum(initstr);
	}
	
	public int getTile(int x, int y) {
		return shuduku[y*9+x];
	}
	
	public String getTitleString(int x, int y) {
		int temp=shuduku[y*9+x];
		if (temp==0) {
			return "";
		}else {
			return String.valueOf(temp);
		}
	}
	
	public int[] translatestrtointnum(String str) {
		int[] shudu=new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			shudu[i]=str.charAt(i)-'0';
		}
		return shudu;
	}

}
