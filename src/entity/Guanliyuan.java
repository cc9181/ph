package entity;  // 包声明

public class Guanliyuan implements java.io.Serializable {  // 定义类，并实现Serializable接口

	private Integer id;  // 声明私有整型变量id

	public Integer getId() {  // 定义公有方法，用于获取id
		return id;  // 返回id值
	}
	public void setId(Integer id) {  // 定义公有方法，用于设置id
		this.id = id;  // 将传入的id赋给类变量id
	}
	private String yonghuming;  // 声明私有字符串变量yonghuming
	public String getYonghuming() {  // 定义公有方法，用于获取yonghuming
		return this.yonghuming;  // 返回yonghuming值
	}
	public void setYonghuming(String yonghuming) {  // 定义公有方法，用于设置yonghuming
		this.yonghuming = yonghuming;  // 将传入的yonghuming赋给类变量yonghuming
	}
	private String mima;  // 声明私有字符串变量mima
	public String getMima() {  // 定义公有方法，用于获取mima
		return this.mima;  // 返回mima值
	}
	public void setMima(String mima) {  // 定义公有方法，用于设置mima
		this.mima = mima;  // 将传入的mima赋给类变量mima
	}

}