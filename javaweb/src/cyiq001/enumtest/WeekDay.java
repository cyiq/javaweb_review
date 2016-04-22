package cyiq001.enumtest;

public enum WeekDay {
	Mon{
		public String getCNWeek() {
			return "星期一";
		}
	},
	Tue{
		public String getCNWeek() {
			return "星期二";
		}
	},
	Wed{
		public String getCNWeek() {
			return "星期三";
		}
	},
	Thu{
		public String getCNWeek() {
			return "星期四";
		}
	},
	Fri{
		public String getCNWeek() {
			return "星期五";
		}
	},
	Sat{
		public String getCNWeek() {
			return "星期六";
		}
	},
	Sun{
		public String getCNWeek() {
			return "星期日";
		}
	};
	public abstract String getCNWeek();
}
