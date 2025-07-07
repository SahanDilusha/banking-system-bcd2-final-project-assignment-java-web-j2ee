package com.popcorntech.app.ejb.account;

import com.popcorntech.app.core.entity.IDType;
import com.popcorntech.app.core.service.IDTypeService;
import jakarta.ejb.Stateless;

import java.util.Optional;

@Stateless
public class IDTypeSessionBean implements IDTypeService {

    @Override
    public Optional<IDType> findByName(String name) {
        try {

            switch (name) {
                case "PASSPORT":
                    return Optional.of(IDType.PASSPORT);
                case "DRIVER_LICENSE":
                    return Optional.of(IDType.DRIVER_LICENSE);
                case "NATIONAL_ID":
                    return Optional.of(IDType.NATIONAL_ID);
                default:
                    return Optional.empty();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean existsIDType(String name) {
        return findByName(name).isPresent();
    }
}
