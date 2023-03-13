package com.prozenda.pages;

public class Pages {

    private LoginPagePOM loginPagePOM;
    private MainPagePOM mainPagePOM;
    private LogsPagePOM logsPagePOM;
    private GeneralPagePOM generalPagePOM;

    public LoginPagePOM getLoginPagePOM(){
        if ( loginPagePOM == null ){
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

    public GeneralPagePOM getGeneralPagePOM(){
        if ( generalPagePOM == null ){
            generalPagePOM = new GeneralPagePOM();
        }

        return generalPagePOM;
    }
}
