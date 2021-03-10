package com.example.designpattern.codeSimplified.proxyPattern;

public class DBInteractionProxy implements DBInteractionDao{

    private boolean isAdmin = false;
    private DBInteractionDao dbInteractionDao;

    public DBInteractionProxy(String userName,String password) {
        dbInteractionDao = new DBInteractionDaoImpl();
        if(userName.equals("ADMIN") && password.equals("ADMIN")){
            isAdmin=true;
        }
    }

    @Override
    public void execute(String query) {
        if(isAdmin){
            dbInteractionDao.execute(query);
        }
        else {
            if("DELETE".equalsIgnoreCase(query)){
                throw  new RuntimeException("USER does not admin privileges");
            }
            else {
                dbInteractionDao.execute(query);
            }
        }
    }
}
