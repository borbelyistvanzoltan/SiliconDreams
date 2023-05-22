package com.prozenda.testdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;

/**
 * @author Rebeka Alajtner
 * @created 25/04/2023 - 11:55
 * @project SiliconDreams
 */
public class TestData {
    public TestData init(JSONObject json){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json.toString(), TestData.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private String user;
    public String getUser() {
        return user;
    }

    private String partnerID;
    public String getPartnerID(){
        return partnerID;
    }

    private String createdPartnerName;
    public String getCreatedPartnerName(){
        return createdPartnerName;
    }

    private String companyNumber;
    public String getCompanyNumber(){
        return companyNumber;
    }

    private String privatePartnerName;
    public String getPrivatePartnerName(){ return privatePartnerName;}

    private String editedCompanyId;
    public String getEditedCompanyId(){
        return editedCompanyId;
    }

    private String clonePartnerName;
    public String getClonePartnerName(){
        return clonePartnerName;
    }

    private String clonePartnerId;
    public String getClonePartnerId(){
        return clonePartnerId;
    }

    private String taxNumber;
    public String getTaxNumber(){
        return taxNumber;
    }

    private String customer;
    public String getCustomer(){
        return customer;
    }

    private String postalCode;
    public String getPostalCode(){
        return postalCode;
    }

    private String settlement;
    public String getSettlement(){
        return settlement;
    }

    private String publicSpaceName;
    public String getPublicSpaceName(){
        return publicSpaceName;
    }

    private String natureOfPublicSpace;
    public String getNatureOfPublicSpace(){
        return natureOfPublicSpace;
    }
}
