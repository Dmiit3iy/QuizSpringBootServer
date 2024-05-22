package com.dmiit3iy.quizespringboot.service;

import com.dmiit3iy.quizespringboot.model.Admin;
import com.dmiit3iy.quizespringboot.model.User;
import com.dmiit3iy.quizespringboot.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;

    @Autowired
    public void setAdminRepository(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void add(Admin admin) {
        try {
            adminRepository.save(admin);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Такой администратор уже существует");
        }
    }

    @Override
    public Admin get(long id) {
        return adminRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("С таким Id нет администратора"));
    }

    @Override
    public List<Admin> get() {
        return adminRepository.findAll();
    }

    @Override
    public Admin update(Admin admin) {
        Admin baseAdmin = get(admin.getId());
        baseAdmin.setLogin(admin.getLogin());
        baseAdmin.setSurname(admin.getSurname());
        baseAdmin.setFirstName(admin.getFirstName());
        baseAdmin.setPassword(admin.getPassword());
        return baseAdmin;
    }

    @Override
    public Admin delete(long id) {
        Admin adminBase = get(id);
        adminRepository.deleteById(id);
        return adminBase;
    }
}
