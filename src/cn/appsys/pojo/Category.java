package cn.appsys.pojo;

import java.util.Date;
//�����
public class Category {
	
	private Integer id ;         //����ID
	private String categoryCode ;//�������
	private String categoryName ;//��������
	private Integer parentId ;//�����ڵ�id
	private Integer createdBy ;//�����ߣ���Դ��backend_user�û�����û�id��
	private Date creationTime ;//����ʱ��
	private Integer modifyBy ;//�����ߣ���Դ��backend_user�û�����û�id��
	private Date modifyDate ;//���¸���ʱ��
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
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
