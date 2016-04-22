package cyiq001.enumtest;
/**
 * 枚举类的构造函数必须为私有的
 * 
 * @author cyiq
 */
public enum Grade {
	A("100-90"){
		public String getLocalString(){
			return "优";
		}
	},
	B("89-80"){
		public String getLocalString(){
			return "好";
		}
	},
	C("79-70"){
		public String getLocalString(){
			return "良";
		}
	},
	D("69-60"){
		public String getLocalString(){
			return "及格";
		}
	},
	E("59-0"){
		public String getLocalString(){
			return "不及格";
		}
	},
	
	;
	
	
	private String value;
	private Grade(String value){
		this.value = value;
	}
	public String getValue(){
		return this.value;
	}
	public abstract String getLocalString();
}
