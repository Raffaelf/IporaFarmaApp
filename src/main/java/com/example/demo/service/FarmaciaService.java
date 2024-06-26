/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Farmacia;
import com.example.demo.model.FarmaciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.FarmaciaRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alcídia Cristina
 */
@Service
public class FarmaciaService {

    @Autowired
    FarmaciaRepository administradorRepository;

    public FarmaciaService() {
    }

    public Farmacia autenticarAdministrador(Farmacia adm) {
        return administradorRepository.findByLoginAndSenha(adm.getLogin(), adm.getSenha());

    }

    public void cadastrarAdministrador(Farmacia adm) {
        administradorRepository.save(adm);
    }

    public void editarAdministrador(Farmacia adm) {
        administradorRepository.save(adm);
    }

    public void removerAdministrador(Long id) {
        administradorRepository.deleteById(id);
    }

    public Farmacia buscaAdministrador(Long id) {
        return administradorRepository.findById(id).get();
    }

    public java.util.List<Farmacia> buscaTodos() {

        return  administradorRepository.findAll();

        

    }

    /*
	 * Método responsavel por fazer o delete da farmacia,
	 * Recebe um objeto do tipo Farmacia e não o ID
     */
 /* public void desabilitarFarmacia (Farmacia farmacia) {
        administradorRepository.delete(farmacia);
    }*/
    
    
    public Farmacia buscaporemail(String email) {
        return administradorRepository.findByEmail(email);
    }
    
    
    
}
