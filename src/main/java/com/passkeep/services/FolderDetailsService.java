package com.passkeep.services;

import java.util.List;

public interface FolderDetailsService<T> {
    List<T> getByFolder(Integer folderId);
    T getByName(Integer folderId, String name);
    void add(T t);
    void delete(Integer id);
}
