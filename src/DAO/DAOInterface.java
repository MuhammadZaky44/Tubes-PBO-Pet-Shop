/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author MFI
 */
public interface DAOInterface<A>{
    
    public void insert(A object);
    public void update(A object);
    public void delete(Integer id);
    public List<A> get(String key);
    public List<A> getAll();

}

