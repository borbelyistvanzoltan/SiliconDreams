package com.prozenda.pages;

import com.prozenda.selectors.UsersPermission;

public class Pages {

    private LoginPagePOM loginPagePOM;
    private ControlPanelPagePOM controlPanelPagePOM;
    private CompanyDetailsAddressesPagePOM companyDetailsAddressesPagePOM;
    private MainPagePOM mainPagePOM;
    private LogsPagePOM logsPagePOM;
    private GeneralPagePOM generalPagePOM;
    private NewProductPagePOM newProductPagePOM;
    private ProductsPagePOM productsPagePOM;
    private LogoutFromPagePOM logoutFromPagePOM;
    private HelpPagePOM helpPagePOM;
    private PartnersPagePOM partnersPagePOM;
    private UsersPermission usersPermissionPOM;
    private ReceiptPagePOM receiptPagePOM;

    public LoginPagePOM getLoginPagePOM() {
        if (loginPagePOM == null){
            loginPagePOM = new LoginPagePOM();
        }

        return loginPagePOM;
    }

    public MainPagePOM getMainPagePOM(){
        if ( mainPagePOM == null ){
            mainPagePOM = new MainPagePOM();
        }

        return mainPagePOM;
    }

    public LogsPagePOM getLogsPagePOM(){
        if ( logsPagePOM == null ){
            logsPagePOM = new LogsPagePOM();
        }

        return logsPagePOM;
    }

    public ControlPanelPagePOM getControlPanelPagePOM() {
        if (controlPanelPagePOM == null){
            controlPanelPagePOM = new ControlPanelPagePOM();
        }

        return controlPanelPagePOM;
    }

    public CompanyDetailsAddressesPagePOM getCompanyDetailsAddressesPagePOM() {
        if (companyDetailsAddressesPagePOM == null){
            companyDetailsAddressesPagePOM = new CompanyDetailsAddressesPagePOM();
        }

        return companyDetailsAddressesPagePOM;
    }

    public GeneralPagePOM getGeneralPagePOM(){
        if (generalPagePOM == null){
            generalPagePOM = new GeneralPagePOM();
        }

        return generalPagePOM;
    }

    public NewProductPagePOM getNewProductPagePOM() {
        if (newProductPagePOM == null){
            newProductPagePOM = new NewProductPagePOM();
        }

        return newProductPagePOM;
    }

    public ProductsPagePOM getProductsPagePOM() {
        if (productsPagePOM == null){
            productsPagePOM = new ProductsPagePOM();
        }

        return productsPagePOM;
    }

    public LogoutFromPagePOM getLogoutFromPagePOM(){
        if (logoutFromPagePOM == null){
            logoutFromPagePOM = new LogoutFromPagePOM();
        }

        return logoutFromPagePOM;
    }

    public HelpPagePOM getHelpPagePOM() {
        if (helpPagePOM == null){
            helpPagePOM = new HelpPagePOM();
        }

        return helpPagePOM;
    }

    public PartnersPagePOM getPartnersPagePOM() {
        if (partnersPagePOM == null){
            partnersPagePOM = new PartnersPagePOM();
        }

        return partnersPagePOM;
    }

    public UsersPermission getUsersPermissionPOM() {
        if (usersPermissionPOM == null){
            usersPermissionPOM = new UsersPermission();
        }

        return usersPermissionPOM;
    }

    public ReceiptPagePOM getReceiptPagePOM() {
        if (receiptPagePOM == null){
            receiptPagePOM = new ReceiptPagePOM();
        }

        return receiptPagePOM;
    }
}
