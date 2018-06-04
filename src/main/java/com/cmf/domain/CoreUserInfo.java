package com.cmf.domain;

import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "core_user_info")
public class CoreUserInfo implements Serializable {
    private static final long serialVersionUID = -7785322335891369585L;
    private Long userID;
    private Long comID;
    private String loginAccount;
    private String cellPhone;
    private String email;
    private String weChatId;
    private String password;
    private Integer userType;
    private Byte verifyStatus;
    private Byte cancellationStatus;
    private Timestamp registerDate;
    private Timestamp verifyDate;
    private Timestamp cancellationDate;
    private Long provinceId;
    private String address;
    private Integer industryId;
    private String corporationName;
    private String legalName;
    private String legalIcn;
    private String picUrl1;
    private String picUrl2;
    private String picUrl3;
    private String picUrl4;
    private String userName;
    private String userIcn;
    private String picUrl5;
    private String picUrl6;
    private String failureReason;
    private Long tempUserId;
    private String linkPerson;
    private String linkPhone;
    private String nickName;
    private Timestamp verifySubmitDate;


    @Id
    @Column(name = "UserID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Basic
    @Column(name = "ComID", nullable = true)
    public Long getComID() {
        return comID;
    }

    public void setComID(Long comID) {
        this.comID = comID;
    }

    @Basic
    @Column(name = "LoginAccount", nullable = true, length = 32)
    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    @Basic
    @Column(name = "CellPhone", nullable = true, length = 20)
    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "WeChatID", nullable = true, length = 32)
    public String getWeChatId() {
        return weChatId;
    }

    public void setWeChatId(String weChatId) {
        this.weChatId = weChatId;
    }

    @Basic
    @Column(name = "Password", nullable = true, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "UserType", nullable = true)
    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "VerifyStatus", nullable = true)
    public Byte getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Byte verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    @Basic
    @Column(name = "CancellationStatus", nullable = true)
    public Byte getCancellationStatus() {
        return cancellationStatus;
    }

    public void setCancellationStatus(Byte cancellationStatus) {
        this.cancellationStatus = cancellationStatus;
    }

    @Basic
    @Column(name = "RegisterDate", nullable = true)
    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    @Basic
    @Column(name = "VerifyDate", nullable = true)
    public Timestamp getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Timestamp verifyDate) {
        this.verifyDate = verifyDate;
    }

    @Basic
    @Column(name = "CancellationDate", nullable = true)
    public Timestamp getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(Timestamp cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    @Basic
    @Column(name = "ProvinceID", nullable = true)
    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    @Basic
    @Column(name = "Address", nullable = true, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "IndustryID", nullable = true)
    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    @Basic
    @Column(name = "CorporationName", nullable = true, length = 100)
    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    @Basic
    @Column(name = "LegalName", nullable = true, length = 50)
    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    @Basic
    @Column(name = "LegalICN", nullable = true, length = 25)
    public String getLegalIcn() {
        return legalIcn;
    }

    public void setLegalIcn(String legalIcn) {
        this.legalIcn = legalIcn;
    }

    @Basic
    @Column(name = "PicUrl1", nullable = true, length = 100)
    public String getPicUrl1() {
        return picUrl1;
    }

    public void setPicUrl1(String picUrl1) {
        this.picUrl1 = picUrl1;
    }

    @Basic
    @Column(name = "PicUrl2", nullable = true, length = 100)
    public String getPicUrl2() {
        return picUrl2;
    }

    public void setPicUrl2(String picUrl2) {
        this.picUrl2 = picUrl2;
    }

    @Basic
    @Column(name = "PicUrl3", nullable = true, length = 100)
    public String getPicUrl3() {
        return picUrl3;
    }

    public void setPicUrl3(String picUrl3) {
        this.picUrl3 = picUrl3;
    }

    @Basic
    @Column(name = "PicUrl4", nullable = true, length = 100)
    public String getPicUrl4() {
        return picUrl4;
    }

    public void setPicUrl4(String picUrl4) {
        this.picUrl4 = picUrl4;
    }

    @Basic
    @Column(name = "UserName", nullable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "UserICN", nullable = true, length = 25)
    public String getUserIcn() {
        return userIcn;
    }

    public void setUserIcn(String userIcn) {
        this.userIcn = userIcn;
    }

    @Basic
    @Column(name = "PicUrl5", nullable = true, length = 100)
    public String getPicUrl5() {
        return picUrl5;
    }

    public void setPicUrl5(String picUrl5) {
        this.picUrl5 = picUrl5;
    }

    @Basic
    @Column(name = "PicUrl6", nullable = true, length = 100)
    public String getPicUrl6() {
        return picUrl6;
    }

    public void setPicUrl6(String picUrl6) {
        this.picUrl6 = picUrl6;
    }

    @Basic
    @Column(name = "FailureReason", nullable = true, length = 255)
    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    @Basic
    @Column(name = "TempUserID", nullable = true)
    public Long getTempUserId() {
        return tempUserId;
    }

    public void setTempUserId(Long tempUserId) {
        this.tempUserId = tempUserId;
    }

    @Basic
    @Column(name = "LinkPerson", nullable = true, length = 20)
    public String getLinkPerson() {
        return linkPerson;
    }

    public void setLinkPerson(String linkPerson) {
        this.linkPerson = linkPerson;
    }

    @Basic
    @Column(name = "LinkPhone", nullable = true, length = 15)
    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    @Basic
    @Column(name = "NickName", nullable = true, length = 20)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "VerifySubmitDate", nullable = true)
    public Timestamp getVerifySubmitDate() {
        return verifySubmitDate;
    }

    public void setVerifySubmitDate(Timestamp verifySubmitDate) {
        this.verifySubmitDate = verifySubmitDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoreUserInfo that = (CoreUserInfo) o;
        return userID == that.userID &&
                Objects.equals(loginAccount, that.loginAccount) &&
                Objects.equals(cellPhone, that.cellPhone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(weChatId, that.weChatId) &&
                Objects.equals(password, that.password) &&
                Objects.equals(userType, that.userType) &&
                Objects.equals(verifyStatus, that.verifyStatus) &&
                Objects.equals(cancellationStatus, that.cancellationStatus) &&
                Objects.equals(registerDate, that.registerDate) &&
                Objects.equals(verifyDate, that.verifyDate) &&
                Objects.equals(cancellationDate, that.cancellationDate) &&
                Objects.equals(provinceId, that.provinceId) &&
                Objects.equals(address, that.address) &&
                Objects.equals(industryId, that.industryId) &&
                Objects.equals(corporationName, that.corporationName) &&
                Objects.equals(legalName, that.legalName) &&
                Objects.equals(legalIcn, that.legalIcn) &&
                Objects.equals(picUrl1, that.picUrl1) &&
                Objects.equals(picUrl2, that.picUrl2) &&
                Objects.equals(picUrl3, that.picUrl3) &&
                Objects.equals(picUrl4, that.picUrl4) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userIcn, that.userIcn) &&
                Objects.equals(picUrl5, that.picUrl5) &&
                Objects.equals(picUrl6, that.picUrl6) &&
                Objects.equals(failureReason, that.failureReason) &&
                Objects.equals(tempUserId, that.tempUserId) &&
                Objects.equals(linkPerson, that.linkPerson) &&
                Objects.equals(linkPhone, that.linkPhone) &&
                Objects.equals(nickName, that.nickName) &&
                Objects.equals(verifySubmitDate, that.verifySubmitDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userID, loginAccount, cellPhone, email, weChatId, password, userType, verifyStatus, cancellationStatus, registerDate, verifyDate, cancellationDate, provinceId, address, industryId, corporationName, legalName, legalIcn, picUrl1, picUrl2, picUrl3, picUrl4, userName, userIcn, picUrl5, picUrl6, failureReason, tempUserId, linkPerson, linkPhone, nickName, verifySubmitDate);
    }
}
