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

    private String partner;
    public String getPartner(){
        return partner;
    }

    private String comment;
    public String getComment(){
        return comment;
    }

    private String supplier;
    public String getSupplier(){
        return supplier;
    }

    private String newCompanyNumber;
    public String getNewCompanyNumber(){
        return newCompanyNumber;
    }

    private String id;
    public String getId(){
        return id;
    }

    private String relatedPartnerName;
    public String getRelatedPartnerName(){
        return relatedPartnerName;
    }
}
