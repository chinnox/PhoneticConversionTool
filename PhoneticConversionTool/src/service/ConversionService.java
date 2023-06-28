package service;

import java.util.HashMap;

public class ConversionService {
	
	private String convertedValue;
	
	public String getConvertedValue() {
		return convertedValue;
	}
	

public void convertToPhonetic(String inputValue) {
	
		
		HashMap<Character, String> phoneticList = new HashMap<Character, String>();
		
		phoneticList.put('a', "ｴｰ");
		phoneticList.put('b', "ﾋﾞｰ");
		phoneticList.put('c', "ｼｰ");
		phoneticList.put('d', "ﾃﾞｨｰ");
		phoneticList.put('e', "ｲｰ");
		phoneticList.put('f', "ｴﾌ");
		phoneticList.put('g', "ｼﾞｰ");
		phoneticList.put('h', "ｴｲﾁ");
		phoneticList.put('i', "ｱｲ");
		phoneticList.put('j', "ｼﾞｪｲ");
		phoneticList.put('k', "ｹｰ");
		phoneticList.put('l', "ｴﾙ");
		phoneticList.put('m', "ｴﾑ");
		phoneticList.put('n', "ｴﾇ");
		phoneticList.put('o', "ｵｰ");
		phoneticList.put('p', "ﾋﾟｰ");
		phoneticList.put('q', "ｷｭｰ");
		phoneticList.put('r', "ｱｰﾙ");
		phoneticList.put('s', "ｴｽ");
		phoneticList.put('t', "ﾃｨｰ");
		phoneticList.put('u', "ﾕｰ");
		phoneticList.put('v', "ﾌﾞｲ");
		phoneticList.put('w', "ﾀﾞﾌﾞﾘｭｰ");
		phoneticList.put('x', "ｴｯｸｽ");
		phoneticList.put('y', "ﾜｲ");
		phoneticList.put('z', "ｾﾞｯﾄ");
		phoneticList.put('1',"1" );
		phoneticList.put('2', "2");
		phoneticList.put('3', "3");
		phoneticList.put('4', "4");
		phoneticList.put('5', "5");
		phoneticList.put('6', "6");
		phoneticList.put('7', "7");
		phoneticList.put('8', "8");
		phoneticList.put('9', "9");
		phoneticList.put('0', "0");
		
		String inputVal = inputValue.toLowerCase();
		String convertedVal = "";
		char storeChar;
		
		for(int i = 0; i < inputVal.length(); i++) {
			storeChar = inputVal.charAt(i);
			
			for(char keyVal :phoneticList.keySet()) {
				
				if(keyVal == storeChar) {
					String val = phoneticList.get(keyVal);
					
					convertedVal =  convertedVal + val + "・";
					
				}
			}
			convertedValue = convertedVal.toString();
		}
		
		int lastChar = convertedValue.length() -1;
		if(convertedValue.endsWith("・")) {
			convertedValue = convertedValue.substring(0, lastChar);
		}
	}
}
