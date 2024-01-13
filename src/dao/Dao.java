package dao;

import java.beans.PropertyDescriptor; // 导入Java内省包
import java.lang.reflect.Field; // 导入Java反射包中的Field类
import java.lang.reflect.Method; // 导入Java反射包中的Method类
import java.util.List; // 导入Java的List集合

public class Dao<T> { // 定义一个泛型类Dao
	String clazzname; // 实例变量clazzname，用于存放类名
	Class clazz; // 实例变量clazz，用于存放类的类型信息

	// 构造方法，初始化clazz和clazzname
	public Dao(T entity) {
		clazz = entity.getClass(); // 初始化clazz为entity的类类型
		clazzname = clazz.getSimpleName().toLowerCase(); // 初始化clazzname为类名的小写形式
	}

	// 根据key和keyvalue查询记录
	public List<T> queryByKey(String key, String keyvalue) {
		String sql = "select * from " + clazzname + " where " + key + "=?"; // 构造SQL查询语句
		List<T> list = (List<T>) DBUnitHelper.executeQuery(sql, clazz, keyvalue);
		// 使用DBUnitHelper执行SQL查询，并将结果转换为List集合
		return list; // 返回查询结果
	}

	// 根据实体对象entity查询记录
	public List<T> query(T entity) {
		StringBuffer sbf = new StringBuffer("select * from " + clazzname + " where 1=1 ");
		// 构造查询SQL语句
		for (Field field : clazz.getDeclaredFields()) {
			if (!field.getName().equals("id")) {
				if (getValue(entity, field.getName(), clazz) != null
						&& !getValue(entity, field.getName(), clazz).equals("")) {
					// 判断字段值非空
					sbf.append(" and " + field.getName() + " like '%" + getValue(entity, field.getName(), clazz) + "%'");
					// 添加条件
				}
			}
		}
		System.out.println(sbf.toString()); // 打印SQL语句
		List<T> list = (List<T>) DBUnitHelper.executeQuery(sbf.toString(), clazz);
		// 使用DBUnitHelper执行SQL查询，并将结果转换为List集合
		return list; // 返回查询结果
	}

	// 获取所有记录
	public List<T> getAll() {
		String sql = "select * from " + clazzname; // 构造查询所有记录的SQL语句
		List<T> list = (List<T>) DBUnitHelper.executeQuery(sql, clazz);
		// 使用DBUnitHelper执行SQL查询，并将结果转换为List集合
		return list; // 返回查询结果
	}

	// 执行SQL语句
	public void executeSql(String sql) {
		System.out.println(sql); // 打印要执行的SQL语句
		DBUnitHelper.executeUpdate(sql); // 使用DBUnitHelper执行SQL语句
	}

	// 根据主键更新记录
	public void update(T entity) {
		Integer value1 = (Integer) getValue(entity, getKey(), clazz); // 获取主键值
		StringBuffer sbf = new StringBuffer();
		sbf.append("update " + clazzname + " set ");
		// 构造更新SQL语句
		for (Field field : clazz.getDeclaredFields()) {
			Object o = getValue(entity, field.getName(), clazz);
			sbf.append(field.getName().toLowerCase()).append("='").append(getValue(entity, field.getName(), clazz))
					.append("'").append(","); // 添加更新字段和值
		}
		sbf = new StringBuffer(sbf.subSequence(0, sbf.length() - 1));
		sbf.append(" where id='" + value1 + "'"); // 更新条件
		executeSql(sbf.toString()); // 执行更新SQL语句
	}

	// 添加记录
	public void add(T t) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("insert into " + clazzname).append("(");
		// 构造插入SQL语句
		for (Field field : clazz.getDeclaredFields()) {
			if (!field.getName().equals("id")) {
				sbf.append(field.getName().toLowerCase()).append(",");
			}
		}
		sbf = new StringBuffer(sbf.subSequence(0, sbf.length() - 1));
		sbf.append(") values(");
		// 添加字段
		for (Field field : clazz.getDeclaredFields()) {
			if (!field.getName().equals("id")) {
				sbf.append("'").append(getValue(t, field.getName(), clazz)).append("'").append(",");
			}
		}
		sbf = new StringBuffer(sbf.subSequence(0, sbf.length() - 1));
		sbf.append(")"); // 插入值
		executeSql(sbf.toString()); // 执行插入SQL语句
	}

	// 根据key和keyvalue删除记录
	public Integer delBykey(String key, String keyvalue) {
		String sql = "delete from " + clazzname + " where " + key + "=?";
		return DBUnitHelper.executeUpdate(sql, keyvalue); // 返回执行删除操作的结果
	}

	// 获取字段值
	public Object getValue(Object entity, String fieldName, Class clazz) {
		PropertyDescriptor pd;
		try {
			pd = new PropertyDescriptor(fieldName, clazz);
			Method wM = pd.getReadMethod();
			return wM.invoke(entity) == null ? "" : wM.invoke(entity);
			// 获取字段的值
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 设置字段值
	public void setValue(String fieldName, Class clazz, Object o, Object fieldValue) {
		try {
			PropertyDescriptor pd = new PropertyDescriptor(fieldName, clazz);
			Method wM = pd.getWriteMethod();
			wM.invoke(o, fieldValue);
			// 设置字段的值
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取主键字段
	public String getKey() {
		try {
			for (Field field : clazz.getDeclaredFields()) {
				return field.getName(); // 返回主键字段名
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}