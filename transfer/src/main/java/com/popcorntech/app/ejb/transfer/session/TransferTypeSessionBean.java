package com.popcorntech.app.ejb.transfer.session;

import com.popcorntech.app.core.service.TransferTypeService;

public class TransferTypeSessionBean implements TransferTypeService {
    @Override
    public boolean isTransferType(String transferType) {

        try {

            switch (transferType) {
                case "INTERNAL":
                    return true;
                case "EXTERNAL":
                    return true;
                default:
                    return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }
}
