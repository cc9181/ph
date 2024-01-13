package entity;  // 包声明

public class Zuoweiyuding implements java.io.Serializable {  // 类声明

	private Integer id;  // 私有属性id

	public Integer getId() {  // 获取id值的方法
		return id;
	}
	public void setId(Integer id) {  // 设置id值的方法
		this.id = id;
	}
	private String duzhe;  // 私有属性读者

	public String getDuzhe() {  // 获取读者值的方法
		return this.duzhe;
	}
	public void setDuzhe(String duzhe) {  // 设置读者值的方法
		this.duzhe = duzhe;
	}
	private String zuowei;  // 私有属性座位

	public String getZuowei() {  // 获取座位值的方法
		return this.zuowei;
	}
	public void setZuowei(String zuowei) {  // 设置座位值的方法
		this.zuowei = zuowei;
	}
	private String yuelanshi;  // 私有属性阅览室

	public String getYuelanshi() {  // 获取阅览室值的方法
		return this.yuelanshi;
	}
	public void setYuelanshi(String yuelanshi) {  // 设置阅览室值的方法
		this.yuelanshi = yuelanshi;
	}
	private String riqi;  // 私有属性日期

	public String getRiqi() {  // 获取日期值的方法
		return this.riqi;
	}
	public void setRiqi(String riqi) {  // 设置日期值的方法
		this.riqi = riqi;
	}
	private String shijian;  // 私有属性时间

	public String getShijian() {  // 获取时间值的方法
		return this.shijian;
	}
	public void setShijian(String shijian) {  // 设置时间值的方法
		this.shijian = shijian;
	}

}  // 类声明结束