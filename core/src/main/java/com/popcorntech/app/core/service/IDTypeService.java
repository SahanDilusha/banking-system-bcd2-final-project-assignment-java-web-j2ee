package com.popcorntech.app.core.service;

import com.popcorntech.app.core.entity.IDType;

import java.util.Optional;

public interface IDTypeService {
    Optional<IDType> findByName(String name);
    boolean existsIDType(String name);
}
