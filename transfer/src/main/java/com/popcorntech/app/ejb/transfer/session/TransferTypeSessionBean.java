package com.popcorntech.app.ejb.transfer.session;

import com.popcorntech.app.core.entity.TransferType;
import com.popcorntech.app.core.service.TransferTypeService;
import jakarta.ejb.Stateless;

import java.util.Optional;

@Stateless
public class TransferTypeSessionBean implements TransferTypeService {

    @Override
    public Optional<TransferType> getTransferType(String transferType) {

        try {
            switch (transferType) {
                case "INTERNAL":
                    Optional.of(TransferType.INTERNAL);
                case "EXTERNAL":
                    Optional.of(TransferType.EXTERNAL);
                default:
                    return Optional.empty();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public boolean isTransferType(String transferType) {

        try {
            return getTransferType(transferType).isPresent();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }
}
