package cn.appsys.pojo;

import java.util.Date;
//�����ֵ��ѯ��
public class Data_dictionary {
	
	  private Integer id;           //NOT NULL����ID
	  private String typeCode;      //varchar(50) NULL���ͱ���
	  private String typeName;      //varchar(50) NULL��������
	  private Integer valueId;      //bigint(30) NULL����ֵID
	  private String valueName;     //varchar(50) NULL����ֵName
	  private Integer createdBy;    //bigint(30) NULL�����ߣ���Դ��backend_user�û�����û�id��
	  private Date creationDate;    //datetime NULL����ʱ��
	  private Integer modifyBy;     //NULL�����ߣ���Դ��backend_user�û�����û�id��
	  private Date modifyDate;      //datetime NULL���¸���ʱ��
	  
	  
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getValueId() {
		return valueId;
	}
	public void setValueId(Integer valueId) {
		this.valueId = valueId;
	}
	public String getValueName() {
		return valueName;
	}
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	  
	  
	  

}
