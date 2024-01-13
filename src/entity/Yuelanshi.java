package entity;  // 包名entity

public class Yuelanshi implements java.io.Serializable {  // 定义一个实现Serializable接口的Yuelanshi类

	private Integer id;  // 私有属性id

	public Integer getId() {  // 获取id的方法
		return id;
	}
	public void setId(Integer id) {  // 设置id的方法
		this.id = id;
	}
	private String mingcheng;  // 私有属性mingcheng

	public String getMingcheng() {  // 获取mingcheng的方法
		return this.mingcheng;
	}
	public void setMingcheng(String mingcheng) {  // 设置mingcheng的方法
		this.mingcheng = mingcheng;
	}

}  // Yuelanshi类结束