package com.myit.common.param;

/**
 * 参数配置实体类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class Parameter {
	private String paramName;
	private String paramVal;
	private String describe;
	private boolean isActive;

	public Parameter() {
	}

	/**
	 * 初始化参数配置实体
	 * @param paramName
	 * @param paramVal
	 * @param paramType
	 * @param describe
	 * @param isActive
	 */
	public Parameter(String paramName, String paramVal, String paramType,
			String describe, boolean isActive) {
		this.paramName = paramName;
		this.paramVal = paramVal;
		this.describe = describe;
		this.isActive = isActive;
	}

	/**
	 * @return the paramName
	 */
	public String getParamName() {
		return paramName;
	}

	/**
	 * @param paramName
	 *            the paramName to set
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 * @return the paramVal
	 */
	public String getParamVal() {
		return paramVal;
	}

	/**
	 * @param paramVal
	 *            the paramVal to set
	 */
	public void setParamVal(String paramVal) {
		this.paramVal = paramVal;
	}

	/**
	 * @return the describe
	 */
	public String getDescribe() {
		return describe;
	}

	/**
	 * @param describe
	 *            the describe to set
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((paramName == null) ? 0 : paramName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parameter other = (Parameter) obj;
		if (paramName == null) {
			if (other.paramName != null)
				return false;
		} else if (!paramName.equals(other.paramName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Parameter [paramName=" + paramName + ", paramVal=" + paramVal
				+ ", describe=" + describe
				+ ", isActive=" + isActive + "]";
	}

	/**
	 * 获取JSON字符串<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @return
	 */
	public String toJSONString() {
		return "{paramName: \"" + paramName + "\", paramVal: \"" + paramVal
				+"\", describe: \"" + describe + "\", isActive: \"" + isActive + "\"}";
	}

}
