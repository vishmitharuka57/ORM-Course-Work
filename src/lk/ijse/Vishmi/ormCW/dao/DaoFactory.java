package lk.ijse.Vishmi.ormCW.dao;

import lk.ijse.Vishmi.ormCW.dao.custom.Impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){

    }
    public static DaoFactory getDaoFactory(){
        if (daoFactory==null){
            return new DaoFactory();
        }
        return daoFactory;
    }

    public enum DaoTypes {
        STUDENT, ROOM, REGISTRATION, QUERYDAO,USER

    }

    public SuperDAO getDAO(DaoTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case REGISTRATION:
                return  new RegisterDAOImpl();
            case QUERYDAO:
                return new QueryDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}
