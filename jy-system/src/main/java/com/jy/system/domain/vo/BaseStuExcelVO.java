package com.jy.system.domain.vo;

import com.jy.common.annotation.Excel;
import com.jy.common.core.domain.BaseEntity;

/**
 * Created by 彭嘉颖 on 2019/5/14.
 */
public class BaseStuExcelVO extends BaseEntity {
    @Excel(name = "序号")
    private String num;
    @Excel(name = "协议编号")
    private String ProtocolNumber;
    @Excel(name = "学员ID")
    private String userID;
    @Excel(name = "学员姓名")
    private String userName;
    @Excel(name = "性别")
    private String sex;
    @Excel(name = "学员状态")
    private String userType;
    @Excel(name = "身份证号码")
    private String idnumber;
    @Excel(name = "手机号")
    private String phonenumber;
    @Excel(name = "付款方式")
    private String PaymentMethod;
    @Excel(name = "执行价格")
    private String ExecutionPrice;
    @Excel(name = "优惠金额")
    private String PreferentialAmount;
    @Excel(name = "应交学费")
    private String TuitionPayable;
    @Excel(name = "已交学费")
    private String TuitionPaid;
    @Excel(name = "欠费")
    private String Arrears;
    @Excel(name = "是否交齐学费")
    private String PaymentOfTuitionFees;
    @Excel(name = "开班日期")
    private String OpeningDate;
    @Excel(name = "预计毕业日期")
    private String ExpectedGraduationDate;
    @Excel(name = "毕业日期")
    private String BaseGraduationDate;
    @Excel(name = "协议版本")
    private String ProtocolVersion;
    @Excel(name = "合同有效性")
    private String ContractValidity;
    @Excel(name = "合同链接")
    private String ContractLink;
    @Excel(name = "身份证地址")
    private String idnumberAddress;
    @Excel(name = "现住址")
    private String Address;
    @Excel(name = "家庭联系电话")
    private String FamilyContactTelephone;
    @Excel(name = "QQ")
    private String qQnumber;
    @Excel(name = "学历")
    private String education;
    @Excel(name = "毕业学校")
    private String graduateschool;
    @Excel(name = "专业")
    private String major;
    @Excel(name = "毕业日期")
    private String GraduationDate;
    @Excel(name = "年龄")
    private int age;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getProtocolNumber() {
        return ProtocolNumber;
    }

    public void setProtocolNumber(String protocolNumber) {
        ProtocolNumber = protocolNumber;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    public String getExecutionPrice() {
        return ExecutionPrice;
    }

    public void setExecutionPrice(String executionPrice) {
        ExecutionPrice = executionPrice;
    }

    public String getPreferentialAmount() {
        return PreferentialAmount;
    }

    public void setPreferentialAmount(String preferentialAmount) {
        PreferentialAmount = preferentialAmount;
    }

    public String getTuitionPayable() {
        return TuitionPayable;
    }

    public void setTuitionPayable(String tuitionPayable) {
        TuitionPayable = tuitionPayable;
    }

    public String getTuitionPaid() {
        return TuitionPaid;
    }

    public void setTuitionPaid(String tuitionPaid) {
        TuitionPaid = tuitionPaid;
    }

    public String getArrears() {
        return Arrears;
    }

    public void setArrears(String arrears) {
        Arrears = arrears;
    }

    public String getPaymentOfTuitionFees() {
        return PaymentOfTuitionFees;
    }

    public void setPaymentOfTuitionFees(String paymentOfTuitionFees) {
        PaymentOfTuitionFees = paymentOfTuitionFees;
    }

    public String getOpeningDate() {
        return OpeningDate;
    }

    public void setOpeningDate(String openingDate) {
        OpeningDate = openingDate;
    }

    public String getExpectedGraduationDate() {
        return ExpectedGraduationDate;
    }

    public void setExpectedGraduationDate(String expectedGraduationDate) {
        ExpectedGraduationDate = expectedGraduationDate;
    }

    public String getBaseGraduationDate() {
        return BaseGraduationDate;
    }

    public void setBaseGraduationDate(String baseGraduationDate) {
        BaseGraduationDate = baseGraduationDate;
    }

    public String getProtocolVersion() {
        return ProtocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        ProtocolVersion = protocolVersion;
    }

    public String getContractValidity() {
        return ContractValidity;
    }

    public void setContractValidity(String contractValidity) {
        ContractValidity = contractValidity;
    }

    public String getContractLink() {
        return ContractLink;
    }

    public void setContractLink(String contractLink) {
        ContractLink = contractLink;
    }

    public String getIdnumberAddress() {
        return idnumberAddress;
    }

    public void setIdnumberAddress(String idnumberAddress) {
        this.idnumberAddress = idnumberAddress;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getFamilyContactTelephone() {
        return FamilyContactTelephone;
    }

    public void setFamilyContactTelephone(String familyContactTelephone) {
        FamilyContactTelephone = familyContactTelephone;
    }

    public String getqQnumber() {
        return qQnumber;
    }

    public void setqQnumber(String qQnumber) {
        this.qQnumber = qQnumber;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGraduateschool() {
        return graduateschool;
    }

    public void setGraduateschool(String graduateschool) {
        this.graduateschool = graduateschool;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGraduationDate() {
        return GraduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        GraduationDate = graduationDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
