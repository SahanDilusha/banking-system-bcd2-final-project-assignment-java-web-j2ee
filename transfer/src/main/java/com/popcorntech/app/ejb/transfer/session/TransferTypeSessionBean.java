package com.popcorntech.app.ejb.transfer.session;

import com.popcorntech.app.core.entity.TransferType;
import com.popcorntech.app.core.service.TransferTypeService;

public class TransferTypeSessionBean implements TransferTypeService {
    @Override
    public boolean isTransferType(String transferType) {
        return false;
    }
}
