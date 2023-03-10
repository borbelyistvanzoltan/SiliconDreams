package com.prozenda.pages;

public class Pages {

    private LoginPagePOM loginPagePOM;
    private ControlPanelPagePOM controlPanelPagePOM;
    private CompanyDetailsAddressesPagePOM companyDetailsAddressesPagePOM;
    private MainPagePOM mainPagePOM;
    private LogsPagePOM logsPagePOM;

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
}
