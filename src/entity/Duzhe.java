package entity; // 包声明

public class Duzhe implements java.io.Serializable { // 定义类Duzhe，实现Serializable接口

	private Integer id; // 声明私有属性id

	public Integer getId() { // 获取id属性的方法
		return id; // 返回id属性的值
	}
	public void setId(Integer id) { // 设置id属性的方法
		this.id = id; // 设置id属性的值
	}
	private String xingming; // 声明私有属性xingming

	public String getXingming() { // 获取xingming属性的方法
		return this.xingming; // 返回xingming属性的值
	}
	public void setXingming(String xingming) { // 设置xingming属性的方法
		this.xingming = xingming; // 设置xingming属性的值
	}
	private String nianling; // 声明私有属性nianling

	public String getNianling() { // 获取nianling属性的方法
		return this.nianling; // 返回nianling属性的值
	}
	public void setNianling(String nianling) { // 设置nianling属性的方法
		this.nianling = nianling; // 设置nianling属性的值
	}
	private String xingbie; // 声明私有属性xingbie

	public String getXingbie() { // 获取xingbie属性的方法
		return this.xingbie; // 返回xingbie属性的值
	}
	public void setXingbie(String xingbie) { // 设置xingbie属性的方法
		this.xingbie = xingbie; // 设置xingbie属性的值
	}
	private String lianxidianhua; // 声明私有属性lianxidianhua

	public String getLianxidianhua() { // 获取lianxidianhua属性的方法
		return this.lianxidianhua; // 返回lianxidianhua属性的值
	}
	public void setLianxidianhua(String lianxidianhua) { // 设置lianxidianhua属性的方法
		this.lianxidianhua = lianxidianhua; // 设置lianxidianhua属性的值
	}

}
