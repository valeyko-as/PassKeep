package com.passkeep.services;

import java.util.List;

public interface FolderService<T> {
    List<T> getAllByOwnerId(Integer ownerId);
    T getById(Integer id);
    T update(Integer id, T t);
    void delete(Integer id);
}
