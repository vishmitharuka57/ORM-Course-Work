package lk.ijse.Vishmi.ormCW.service;

import lk.ijse.Vishmi.ormCW.service.custom.impl.*;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    private ServiceFactory(){

    }
    public static ServiceFactory getServiceFactory(){
        if (serviceFactory==null){
            return new ServiceFactory();
        }
        return serviceFactory;
    }

    public enum ServiceTypes {
        LOG,PENDINGKEYMONEY,REGISTRATION,ROOM,STUDENT,USER
    }

    public SuperService getService(ServiceFactory.ServiceTypes types) {
        switch (types) {
            case LOG:
                return new LogServiceImpl();
            case PENDINGKEYMONEY:
                return new PendingKeyMoneyServiceImpl();
            case REGISTRATION:
                return new RegistrationServiceImpl();
            case ROOM:
                return new RoomServiceImpl();
            case STUDENT:
                return new StudentServiceImpl();
            case USER:
                return new UserServiceImpl();
            default:
                return null;
        }
    }
}
